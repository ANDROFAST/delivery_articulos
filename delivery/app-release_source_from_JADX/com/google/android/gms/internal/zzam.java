package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzam extends zzal {
    private static AdvertisingIdClient zznV = null;
    private static CountDownLatch zznW = new CountDownLatch(1);
    private static volatile boolean zznX;
    private boolean zznY;

    class zza {
        private String zznZ;
        private boolean zzoa;
        final /* synthetic */ zzam zzob;

        public zza(zzam com_google_android_gms_internal_zzam, String str, boolean z) {
            this.zzob = com_google_android_gms_internal_zzam;
            this.zznZ = str;
            this.zzoa = z;
        }

        public String getId() {
            return this.zznZ;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoa;
        }
    }

    private static final class zzb implements Runnable {
        private Context zzoc;

        public zzb(Context context) {
            this.zzoc = context.getApplicationContext();
            if (this.zzoc == null) {
                this.zzoc = context;
            }
        }

        public void run() {
            synchronized (zzam.class) {
                try {
                    if (zzam.zznV == null) {
                        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzoc);
                        advertisingIdClient.start();
                        zzam.zznV = advertisingIdClient;
                    }
                    zzam.zznW.countDown();
                } catch (GooglePlayServicesNotAvailableException e) {
                    zzam.zznX = true;
                    zzam.zznW.countDown();
                } catch (IOException e2) {
                    zzam.zznW.countDown();
                } catch (GooglePlayServicesRepairableException e3) {
                    zzam.zznW.countDown();
                } catch (Throwable th) {
                    zzam.zznW.countDown();
                }
            }
        }
    }

    protected zzam(Context context, zzap com_google_android_gms_internal_zzap, zzaq com_google_android_gms_internal_zzaq, boolean z) {
        super(context, com_google_android_gms_internal_zzap, com_google_android_gms_internal_zzaq);
        this.zznY = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzap com_google_android_gms_internal_zzah = new zzah();
        zzal.zza(str, context, com_google_android_gms_internal_zzah);
        if (z) {
            synchronized (zzam.class) {
                if (zznV == null) {
                    new Thread(new zzb(context)).start();
                }
            }
        }
        return new zzam(context, com_google_android_gms_internal_zzah, new zzas(239), z);
    }

    zza zzZ() throws IOException {
        try {
            if (!zznW.await(2, TimeUnit.SECONDS)) {
                return new zza(this, null, false);
            }
            synchronized (zzam.class) {
                if (zznV == null) {
                    zza com_google_android_gms_internal_zzam_zza = new zza(this, null, false);
                    return com_google_android_gms_internal_zzam_zza;
                }
                Info info = zznV.getInfo();
                return new zza(this, zzk(info.getId()), info.isLimitAdTrackingEnabled());
            }
        } catch (InterruptedException e) {
            return new zza(this, null, false);
        }
    }

    protected void zzc(Context context) {
        super.zzc(context);
        try {
            if (zznX || !this.zznY) {
                zza(24, zzal.zzf(context));
                zzal.zza(24, zznN);
                return;
            }
            zza zzZ = zzZ();
            String id = zzZ.getId();
            if (id != null) {
                zza(28, zzZ.isLimitAdTrackingEnabled() ? 1 : 0);
                zza(26, 5);
                zza(24, id);
                zzal.zza(28, zznN);
            }
        } catch (IOException e) {
        } catch (zza e2) {
        }
    }
}
