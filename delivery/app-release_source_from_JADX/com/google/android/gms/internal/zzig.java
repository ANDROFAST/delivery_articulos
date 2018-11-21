package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzin.zzb;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

@zzha
public class zzig implements zzb {
    private Context mContext;
    private boolean zzIn = true;
    private boolean zzIo = true;
    private final String zzJX;
    private final zzih zzJY;
    private BigInteger zzJZ = BigInteger.ONE;
    private final HashSet<zzif> zzKa = new HashSet();
    private final HashMap<String, zzij> zzKb = new HashMap();
    private boolean zzKc = false;
    private int zzKd = 0;
    private zzcb zzKe = null;
    private zzbl zzKf = null;
    private final LinkedList<Thread> zzKg = new LinkedList();
    private Boolean zzKh = null;
    private String zzKi;
    private boolean zzKj = false;
    private boolean zzKk = false;
    private VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    private zzay zzpb;
    private boolean zzqh = false;
    private zzbk zzsP = null;
    private zzbj zzsQ = null;
    private final zzgz zzsR = null;

    public zzig(zzip com_google_android_gms_internal_zzip) {
        this.zzJX = com_google_android_gms_internal_zzip.zzha();
        this.zzJY = new zzih(this.zzJX);
    }

    public String getSessionId() {
        return this.zzJX;
    }

    public void zzB(boolean z) {
        synchronized (this.zzpK) {
            if (this.zzIo != z) {
                zzin.zzb(this.mContext, z);
            }
            this.zzIo = z;
            zzbl zzG = zzG(this.mContext);
            if (!(zzG == null || zzG.isAlive())) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaG("start fetching content...");
                zzG.zzcB();
            }
        }
    }

    public void zzC(boolean z) {
        synchronized (this.zzpK) {
            this.zzKj = z;
        }
    }

    public zzbl zzG(Context context) {
        if (!((Boolean) zzbz.zzvO.get()).booleanValue() || !zznx.zzrQ() || zzgJ()) {
            return null;
        }
        synchronized (this.zzpK) {
            if (this.zzsP == null) {
                if (context instanceof Activity) {
                    this.zzsP = new zzbk((Application) context.getApplicationContext(), (Activity) context);
                } else {
                    return null;
                }
            }
            if (this.zzsQ == null) {
                this.zzsQ = new zzbj();
            }
            if (this.zzKf == null) {
                this.zzKf = new zzbl(this.zzsP, this.zzsQ, new zzgz(this.mContext, this.zzpI, null, null));
            }
            this.zzKf.zzcB();
            zzbl com_google_android_gms_internal_zzbl = this.zzKf;
            return com_google_android_gms_internal_zzbl;
        }
    }

    public Bundle zza(Context context, zzii com_google_android_gms_internal_zzii, String str) {
        Bundle bundle;
        synchronized (this.zzpK) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzJY.zzc(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzKb.keySet()) {
                bundle2.putBundle(str2, ((zzij) this.zzKb.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzKa.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzif) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            com_google_android_gms_internal_zzii.zza(this.zzKa);
            this.zzKa.clear();
        }
        return bundle;
    }

    public Future zza(Context context, boolean z) {
        Future zza;
        synchronized (this.zzpK) {
            if (z != this.zzIn) {
                this.zzIn = z;
                zza = zzin.zza(context, z);
            } else {
                zza = null;
            }
        }
        return zza;
    }

    public void zza(zzif com_google_android_gms_internal_zzif) {
        synchronized (this.zzpK) {
            this.zzKa.add(com_google_android_gms_internal_zzif);
        }
    }

    public void zza(String str, zzij com_google_android_gms_internal_zzij) {
        synchronized (this.zzpK) {
            this.zzKb.put(str, com_google_android_gms_internal_zzij);
        }
    }

    public void zza(Thread thread) {
        zzgz.zza(this.mContext, thread, this.zzpI);
    }

    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.zzpK) {
            if (!this.zzqh) {
                this.mContext = context.getApplicationContext();
                this.zzpI = versionInfoParcel;
                zzin.zza(context, (zzb) this);
                zzin.zzb(context, (zzb) this);
                zzin.zzc(context, this);
                zza(Thread.currentThread());
                this.zzKi = zzp.zzbx().zzd(context, versionInfoParcel.afmaVersion);
                if (zznx.zzrX() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzKk = true;
                }
                this.zzpb = new zzay(context.getApplicationContext(), this.zzpI, new zzei(context.getApplicationContext(), this.zzpI, (String) zzbz.zzvg.get()));
                zzgU();
                zzp.zzbH().zzz(this.mContext);
                this.zzqh = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zzpK) {
            this.zzKh = bool;
        }
    }

    public void zzb(Throwable th, boolean z) {
        new zzgz(this.mContext, this.zzpI, null, null).zza(th, z);
    }

    public void zzb(HashSet<zzif> hashSet) {
        synchronized (this.zzpK) {
            this.zzKa.addAll(hashSet);
        }
    }

    public void zze(Bundle bundle) {
        synchronized (this.zzpK) {
            this.zzIn = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.zzIn;
            this.zzKd = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.zzKd;
            if (bundle.containsKey("content_url_opted_out")) {
                zzB(bundle.getBoolean("content_url_opted_out"));
            }
        }
    }

    public String zzf(int i, String str) {
        Resources resources = this.zzpI.zzLH ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    public boolean zzgJ() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzIo;
        }
        return z;
    }

    public String zzgK() {
        String bigInteger;
        synchronized (this.zzpK) {
            bigInteger = this.zzJZ.toString();
            this.zzJZ = this.zzJZ.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public zzih zzgL() {
        zzih com_google_android_gms_internal_zzih;
        synchronized (this.zzpK) {
            com_google_android_gms_internal_zzih = this.zzJY;
        }
        return com_google_android_gms_internal_zzih;
    }

    public zzcb zzgM() {
        zzcb com_google_android_gms_internal_zzcb;
        synchronized (this.zzpK) {
            com_google_android_gms_internal_zzcb = this.zzKe;
        }
        return com_google_android_gms_internal_zzcb;
    }

    public boolean zzgN() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzKc;
            this.zzKc = true;
        }
        return z;
    }

    public boolean zzgO() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzIn || this.zzKk;
        }
        return z;
    }

    public String zzgP() {
        String str;
        synchronized (this.zzpK) {
            str = this.zzKi;
        }
        return str;
    }

    public Boolean zzgQ() {
        Boolean bool;
        synchronized (this.zzpK) {
            bool = this.zzKh;
        }
        return bool;
    }

    public zzay zzgR() {
        return this.zzpb;
    }

    public boolean zzgS() {
        boolean z;
        synchronized (this.zzpK) {
            if (this.zzKd < ((Integer) zzbz.zzwf.get()).intValue()) {
                this.zzKd = ((Integer) zzbz.zzwf.get()).intValue();
                zzin.zza(this.mContext, this.zzKd);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzgT() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzKj;
        }
        return z;
    }

    void zzgU() {
        try {
            this.zzKe = zzp.zzbC().zza(new zzca(this.mContext, this.zzpI.afmaVersion));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot initialize CSI reporter.", e);
        }
    }
}
