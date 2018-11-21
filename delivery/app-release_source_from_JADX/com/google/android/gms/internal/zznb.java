package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;

public final class zznb implements zzna {

    private static class zza extends zzmy {
        private final zzb<Status> zzakL;

        public zza(zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzcd(int i) throws RemoteException {
            this.zzakL.zzr(new Status(i));
        }
    }

    public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zznb zzakK;

            protected void zza(zznd com_google_android_gms_internal_zznd) throws RemoteException {
                ((zznf) com_google_android_gms_internal_zznd.zzqs()).zza(new zza(this));
            }
        });
    }
}
