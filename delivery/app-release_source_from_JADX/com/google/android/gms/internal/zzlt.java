package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlt implements com.google.android.gms.clearcut.zzb {
    private static final Object zzadD = new Object();
    private static final zze zzadE = new zze();
    private static final long zzadF = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    private GoogleApiClient zzYC;
    private final zza zzadG;
    private final Object zzadH;
    private long zzadI;
    private final long zzadJ;
    private ScheduledFuture<?> zzadK;
    private final Runnable zzadL;
    private final zznl zzqD;

    class C03571 implements Runnable {
        final /* synthetic */ zzlt zzadM;

        C03571(zzlt com_google_android_gms_internal_zzlt) {
            this.zzadM = com_google_android_gms_internal_zzlt;
        }

        public void run() {
            synchronized (this.zzadM.zzadH) {
                if (this.zzadM.zzadI <= this.zzadM.zzqD.elapsedRealtime() && this.zzadM.zzYC != null) {
                    Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                    this.zzadM.zzYC.disconnect();
                    this.zzadM.zzYC = null;
                }
            }
        }
    }

    public interface zza {
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        public boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
            synchronized (this) {
                while (this.mSize != 0) {
                    if (convert <= 0) {
                        z = false;
                        break;
                    }
                    wait(convert);
                    convert -= System.currentTimeMillis() - currentTimeMillis;
                }
                z = true;
            }
            return z;
        }

        public synchronized void zzop() {
            this.mSize++;
        }

        public synchronized void zzoq() {
            if (this.mSize == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.mSize--;
            if (this.mSize == 0) {
                notifyAll();
            }
        }
    }

    class C07342 implements com.google.android.gms.common.api.PendingResult.zza {
        final /* synthetic */ zzlt zzadM;

        C07342(zzlt com_google_android_gms_internal_zzlt) {
            this.zzadM = com_google_android_gms_internal_zzlt;
        }

        public void zzu(Status status) {
            zzlt.zzadE.zzoq();
        }
    }

    public static class zzb implements zza {
    }

    static abstract class zzc<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzlu> {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zza.zzTo, googleApiClient);
        }
    }

    final class zzd extends zzc<Status> {
        final /* synthetic */ zzlt zzadM;
        private final LogEventParcelable zzadN;

        class C11461 extends com.google.android.gms.internal.zzlv.zza {
            final /* synthetic */ zzd zzadO;

            C11461(zzd com_google_android_gms_internal_zzlt_zzd) {
                this.zzadO = com_google_android_gms_internal_zzlt_zzd;
            }

            public void zzv(Status status) {
                this.zzadO.zzb(status);
            }
        }

        zzd(zzlt com_google_android_gms_internal_zzlt, LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            this.zzadM = com_google_android_gms_internal_zzlt;
            super(googleApiClient);
            this.zzadN = logEventParcelable;
        }

        public boolean equals(Object rhs) {
            if (!(rhs instanceof zzd)) {
                return false;
            }
            return this.zzadN.equals(((zzd) rhs).zzadN);
        }

        public String toString() {
            return "MethodImpl(" + this.zzadN + ")";
        }

        protected void zza(zzlu com_google_android_gms_internal_zzlu) throws RemoteException {
            zzlv c11461 = new C11461(this);
            try {
                zzlt.zza(this.zzadN);
                com_google_android_gms_internal_zzlu.zza(c11461, this.zzadN);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.zzadN.zzadB.toString() + " threw: " + th.toString());
            }
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zzlt() {
        this(new zzno(), zzadF, new zzb());
    }

    public zzlt(zznl com_google_android_gms_internal_zznl, long j, zza com_google_android_gms_internal_zzlt_zza) {
        this.zzadH = new Object();
        this.zzadI = 0;
        this.zzadK = null;
        this.zzYC = null;
        this.zzadL = new C03571(this);
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzadJ = j;
        this.zzadG = com_google_android_gms_internal_zzlt_zza;
    }

    private static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.zzadB != null && logEventParcelable.zzadA.zzbqD.length == 0) {
            logEventParcelable.zzadA.zzbqD = logEventParcelable.zzadB.zzon();
        }
        if (logEventParcelable.zzadC != null && logEventParcelable.zzadA.zzbqK.length == 0) {
            logEventParcelable.zzadA.zzbqK = logEventParcelable.zzadC.zzon();
        }
        logEventParcelable.zzady = zztk.toByteArray(logEventParcelable.zzadA);
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzadE.zzop();
        zzd com_google_android_gms_internal_zzlt_zzd = new zzd(this, logEventParcelable, googleApiClient);
        com_google_android_gms_internal_zzlt_zzd.zza(new C07342(this));
        return com_google_android_gms_internal_zzlt_zzd;
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zza(logEventParcelable);
        return googleApiClient.zza(zzb(googleApiClient, logEventParcelable));
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        try {
            return zzadE.zza(j, timeUnit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
