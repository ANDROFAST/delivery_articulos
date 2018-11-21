package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;

public class zza {
    private static Object zzbcs = new Object();
    private static zza zzbct;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzKt;
    private volatile Info zzOC;
    private volatile long zzbcm;
    private volatile long zzbcn;
    private volatile long zzbco;
    private volatile long zzbcp;
    private final Object zzbcq;
    private zza zzbcr;
    private final zznl zzqD;

    class C04182 implements Runnable {
        final /* synthetic */ zza zzbcu;

        C04182(zza com_google_android_gms_tagmanager_zza) {
            this.zzbcu = com_google_android_gms_tagmanager_zza;
        }

        public void run() {
            this.zzbcu.zzDY();
        }
    }

    public interface zza {
        Info zzDZ();
    }

    class C07851 implements zza {
        final /* synthetic */ zza zzbcu;

        C07851(zza com_google_android_gms_tagmanager_zza) {
            this.zzbcu = com_google_android_gms_tagmanager_zza;
        }

        public Info zzDZ() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzbcu.mContext);
            } catch (Throwable e) {
                zzbg.zzd("IllegalStateException getting Advertising Id Info", e);
            } catch (Throwable e2) {
                zzbg.zzd("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            } catch (Throwable e22) {
                zzbg.zzd("IOException getting Ad Id Info", e22);
            } catch (Throwable e222) {
                zzbg.zzd("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            } catch (Throwable e2222) {
                zzbg.zzd("Unknown exception. Could not get the Advertising Id Info.", e2222);
            }
            return info;
        }
    }

    private zza(Context context) {
        this(context, null, zzno.zzrM());
    }

    public zza(Context context, zza com_google_android_gms_tagmanager_zza_zza, zznl com_google_android_gms_internal_zznl) {
        this.zzbcm = 900000;
        this.zzbcn = 30000;
        this.mClosed = false;
        this.zzbcq = new Object();
        this.zzbcr = new C07851(this);
        this.zzqD = com_google_android_gms_internal_zznl;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (com_google_android_gms_tagmanager_zza_zza != null) {
            this.zzbcr = com_google_android_gms_tagmanager_zza_zza;
        }
        this.zzbco = this.zzqD.currentTimeMillis();
        this.zzKt = new Thread(new C04182(this));
    }

    private void zzDV() {
        synchronized (this) {
            try {
                zzDW();
                wait(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private void zzDW() {
        if (this.zzqD.currentTimeMillis() - this.zzbco > this.zzbcn) {
            synchronized (this.zzbcq) {
                this.zzbcq.notify();
            }
            this.zzbco = this.zzqD.currentTimeMillis();
        }
    }

    private void zzDX() {
        if (this.zzqD.currentTimeMillis() - this.zzbcp > 3600000) {
            this.zzOC = null;
        }
    }

    private void zzDY() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            Info zzDZ = this.zzbcr.zzDZ();
            if (zzDZ != null) {
                this.zzOC = zzDZ;
                this.zzbcp = this.zzqD.currentTimeMillis();
                zzbg.zzaG("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.zzbcq) {
                    this.zzbcq.wait(this.zzbcm);
                }
            } catch (InterruptedException e) {
                zzbg.zzaG("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    public static zza zzaW(Context context) {
        if (zzbct == null) {
            synchronized (zzbcs) {
                if (zzbct == null) {
                    zzbct = new zza(context);
                    zzbct.start();
                }
            }
        }
        return zzbct;
    }

    public boolean isLimitAdTrackingEnabled() {
        if (this.zzOC == null) {
            zzDV();
        } else {
            zzDW();
        }
        zzDX();
        return this.zzOC == null ? true : this.zzOC.isLimitAdTrackingEnabled();
    }

    public void start() {
        this.zzKt.start();
    }

    public String zzDU() {
        if (this.zzOC == null) {
            zzDV();
        } else {
            zzDW();
        }
        zzDX();
        return this.zzOC == null ? null : this.zzOC.getId();
    }
}
