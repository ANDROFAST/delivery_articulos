package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zzlx {

    public interface zzb<R> {
        void zzr(R r);

        void zzx(Status status);
    }

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zzly<R> implements zzb<R>, zze<A> {
        private final zzc<A> zzacX;
        private AtomicReference<zzd> zzafc = new AtomicReference();

        protected zza(zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(((GoogleApiClient) zzx.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null")).getLooper());
            this.zzacX = (zzc) zzx.zzy(com_google_android_gms_common_api_Api_zzc_A);
        }

        private void zza(RemoteException remoteException) {
            zzx(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void zza(A a) throws RemoteException;

        public void zza(zzd com_google_android_gms_internal_zzmg_zzd) {
            this.zzafc.set(com_google_android_gms_internal_zzmg_zzd);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza((com.google.android.gms.common.api.Api.zzb) a);
            } catch (RemoteException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        public final zzc<A> zzoA() {
            return this.zzacX;
        }

        public void zzoP() {
            setResultCallback(null);
        }

        public int zzoQ() {
            return 0;
        }

        protected void zzoR() {
            zzd com_google_android_gms_internal_zzmg_zzd = (zzd) this.zzafc.getAndSet(null);
            if (com_google_android_gms_internal_zzmg_zzd != null) {
                com_google_android_gms_internal_zzmg_zzd.zzc(this);
            }
        }

        public /* synthetic */ void zzr(Object obj) {
            super.zzb((Result) obj);
        }

        public final void zzx(Status status) {
            zzx.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            zzb(zzc(status));
        }
    }
}
