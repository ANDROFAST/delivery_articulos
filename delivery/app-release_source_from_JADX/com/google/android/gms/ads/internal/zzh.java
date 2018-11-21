package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzio;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzha
class zzh implements zzaj, Runnable {
    private zzq zzoZ;
    private final List<Object[]> zzpw = new Vector();
    private final AtomicReference<zzaj> zzpx = new AtomicReference();
    CountDownLatch zzpy = new CountDownLatch(1);

    public zzh(zzq com_google_android_gms_ads_internal_zzq) {
        this.zzoZ = com_google_android_gms_ads_internal_zzq;
        if (zzl.zzcN().zzhr()) {
            zzio.zza((Runnable) this);
        } else {
            run();
        }
    }

    private void zzbj() {
        if (!this.zzpw.isEmpty()) {
            for (Object[] objArr : this.zzpw) {
                if (objArr.length == 1) {
                    ((zzaj) this.zzpx.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzaj) this.zzpx.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzpw.clear();
        }
    }

    private Context zzq(Context context) {
        if (!((Boolean) zzbz.zzvr.get()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public void run() {
        try {
            boolean z = !((Boolean) zzbz.zzvD.get()).booleanValue() || this.zzoZ.zzqR.zzLH;
            zza(zzb(this.zzoZ.zzqR.afmaVersion, zzq(this.zzoZ.context), z));
        } finally {
            this.zzpy.countDown();
            this.zzoZ = null;
        }
    }

    public void zza(int i, int i2, int i3) {
        zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzpx.get();
        if (com_google_android_gms_internal_zzaj != null) {
            zzbj();
            com_google_android_gms_internal_zzaj.zza(i, i2, i3);
            return;
        }
        this.zzpw.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzpx.get();
        if (com_google_android_gms_internal_zzaj != null) {
            zzbj();
            com_google_android_gms_internal_zzaj.zza(motionEvent);
            return;
        }
        this.zzpw.add(new Object[]{motionEvent});
    }

    protected void zza(zzaj com_google_android_gms_internal_zzaj) {
        this.zzpx.set(com_google_android_gms_internal_zzaj);
    }

    protected zzaj zzb(String str, Context context, boolean z) {
        return zzam.zza(str, context, z);
    }

    public String zzb(Context context) {
        if (zzbi()) {
            zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzpx.get();
            if (com_google_android_gms_internal_zzaj != null) {
                zzbj();
                return com_google_android_gms_internal_zzaj.zzb(zzq(context));
            }
        }
        return "";
    }

    public String zzb(Context context, String str) {
        if (zzbi()) {
            zzaj com_google_android_gms_internal_zzaj = (zzaj) this.zzpx.get();
            if (com_google_android_gms_internal_zzaj != null) {
                zzbj();
                return com_google_android_gms_internal_zzaj.zzb(zzq(context), str);
            }
        }
        return "";
    }

    protected boolean zzbi() {
        try {
            this.zzpy.await();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
