package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcm implements zze {
    private boolean mClosed;
    private final Context mContext;
    private final String zzbcF;
    private String zzbdc;
    private zzbf<zzj> zzbeZ;
    private zzs zzbfa;
    private final ScheduledExecutorService zzbfc;
    private final zza zzbfd;
    private ScheduledFuture<?> zzbfe;

    interface zza {
        zzcl zza(zzs com_google_android_gms_tagmanager_zzs);
    }

    interface zzb {
        ScheduledExecutorService zzFf();
    }

    class C07861 implements zzb {
        final /* synthetic */ zzcm zzbff;

        C07861(zzcm com_google_android_gms_tagmanager_zzcm) {
            this.zzbff = com_google_android_gms_tagmanager_zzcm;
        }

        public ScheduledExecutorService zzFf() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    class C07872 implements zza {
        final /* synthetic */ zzcm zzbff;

        C07872(zzcm com_google_android_gms_tagmanager_zzcm) {
            this.zzbff = com_google_android_gms_tagmanager_zzcm;
        }

        public zzcl zza(zzs com_google_android_gms_tagmanager_zzs) {
            return new zzcl(this.zzbff.mContext, this.zzbff.zzbcF, com_google_android_gms_tagmanager_zzs);
        }
    }

    public zzcm(Context context, String str, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, str, com_google_android_gms_tagmanager_zzs, null, null);
    }

    zzcm(Context context, String str, zzs com_google_android_gms_tagmanager_zzs, zzb com_google_android_gms_tagmanager_zzcm_zzb, zza com_google_android_gms_tagmanager_zzcm_zza) {
        this.zzbfa = com_google_android_gms_tagmanager_zzs;
        this.mContext = context;
        this.zzbcF = str;
        if (com_google_android_gms_tagmanager_zzcm_zzb == null) {
            com_google_android_gms_tagmanager_zzcm_zzb = new C07861(this);
        }
        this.zzbfc = com_google_android_gms_tagmanager_zzcm_zzb.zzFf();
        if (com_google_android_gms_tagmanager_zzcm_zza == null) {
            this.zzbfd = new C07872(this);
        } else {
            this.zzbfd = com_google_android_gms_tagmanager_zzcm_zza;
        }
    }

    private synchronized void zzFe() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    private zzcl zzfy(String str) {
        zzcl zza = this.zzbfd.zza(this.zzbfa);
        zza.zza(this.zzbeZ);
        zza.zzfi(this.zzbdc);
        zza.zzfx(str);
        return zza;
    }

    public synchronized void release() {
        zzFe();
        if (this.zzbfe != null) {
            this.zzbfe.cancel(false);
        }
        this.zzbfc.shutdown();
        this.mClosed = true;
    }

    public synchronized void zza(zzbf<zzj> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj) {
        zzFe();
        this.zzbeZ = com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj;
    }

    public synchronized void zzf(long j, String str) {
        zzbg.m10v("loadAfterDelay: containerId=" + this.zzbcF + " delay=" + j);
        zzFe();
        if (this.zzbeZ == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzbfe != null) {
            this.zzbfe.cancel(false);
        }
        this.zzbfe = this.zzbfc.schedule(zzfy(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void zzfi(String str) {
        zzFe();
        this.zzbdc = str;
    }
}
