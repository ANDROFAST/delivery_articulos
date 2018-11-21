package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzav;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private static boolean zzoN = false;
    private final Context mContext;
    com.google.android.gms.common.zza zzoH;
    zzav zzoI;
    boolean zzoJ;
    Object zzoK;
    zza zzoL;
    final long zzoM;

    public static final class Info {
        private final String zzoS;
        private final boolean zzoT;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.zzoS = advertisingId;
            this.zzoT = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.zzoS;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoT;
        }

        public String toString() {
            return "{" + this.zzoS + "}" + this.zzoT;
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzoO;
        private long zzoP;
        CountDownLatch zzoQ = new CountDownLatch(1);
        boolean zzoR = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzoO = new WeakReference(advertisingIdClient);
            this.zzoP = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzoO.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzoR = true;
            }
        }

        public void cancel() {
            this.zzoQ.countDown();
        }

        public void run() {
            try {
                if (!this.zzoQ.await(this.zzoP, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaM() {
            return this.zzoR;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.zzoK = new Object();
        zzx.zzy(context);
        this.mContext = context;
        this.zzoJ = false;
        this.zzoM = timeoutInMillis;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean shouldSkipGmsCoreVersionCheck) {
        zzoN = shouldSkipGmsCoreVersionCheck;
    }

    static zzav zza(Context context, com.google.android.gms.common.zza com_google_android_gms_common_zza) throws IOException {
        try {
            return com.google.android.gms.internal.zzav.zza.zzb(com_google_android_gms_common_zza.zzor());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zzaL() {
        synchronized (this.zzoK) {
            if (this.zzoL != null) {
                this.zzoL.cancel();
                try {
                    this.zzoL.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzoM > 0) {
                this.zzoL = new zza(this, this.zzoM);
            }
        }
    }

    static com.google.android.gms.common.zza zzp(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            if (zzoN) {
                Log.d(AdRequest.LOGTAG, "Skipping gmscore version check");
                switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                GooglePlayServicesUtil.zzac(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (zzb.zzrz().zza(context, intent, com_google_android_gms_common_zza, 1)) {
                    return com_google_android_gms_common_zza;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzx.zzcy(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzoH;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzoJ;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.zzb.zzrz();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.zzoH;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzoJ = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoI = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoH = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzx.zzcy("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzoJ) {
                synchronized (this.zzoK) {
                    if (this.zzoL == null || !this.zzoL.zzaM()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzoJ) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzy(this.zzoH);
            zzx.zzy(this.zzoI);
            info = new Info(this.zzoI.getId(), this.zzoI.zzc(true));
        }
        zzaL();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    protected void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.zzcy("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzoJ) {
                finish();
            }
            this.zzoH = zzp(this.mContext);
            this.zzoI = zza(this.mContext, this.zzoH);
            this.zzoJ = true;
            if (z) {
                zzaL();
            }
        }
    }
}
