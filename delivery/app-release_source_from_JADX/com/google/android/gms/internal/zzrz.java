package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzrz implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzrw.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbf(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final Status zzTA;
        private final GoogleNowAuthState zzbbB;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzTA = status;
            this.zzbbB = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzbbB;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    static class zzb extends com.google.android.gms.internal.zzlx.zza<Status, zzry> {
        private final GoogleApiClient zzYC;
        private final String zzbbu;
        private final boolean zzbbx = Log.isLoggable("SearchAuth", 3);

        class C11971 extends zza {
            final /* synthetic */ zzb zzbby;

            C11971(zzb com_google_android_gms_internal_zzrz_zzb) {
                this.zzbby = com_google_android_gms_internal_zzrz_zzb;
            }

            public void zzbf(Status status) {
                if (this.zzbby.zzbbx) {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                this.zzbby.zzb(status);
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzTo, googleApiClient);
            this.zzYC = googleApiClient;
            this.zzbbu = str;
        }

        protected void zza(zzry com_google_android_gms_internal_zzry) throws RemoteException {
            if (this.zzbbx) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String packageName = this.zzYC.getContext().getPackageName();
            ((zzrx) com_google_android_gms_internal_zzry.zzqs()).zzb(new C11971(this), packageName, this.zzbbu);
        }

        protected Status zzb(Status status) {
            if (this.zzbbx) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static class zzc extends com.google.android.gms.internal.zzlx.zza<GoogleNowAuthResult, zzry> {
        private final GoogleApiClient zzYC;
        private final boolean zzbbx = Log.isLoggable("SearchAuth", 3);
        private final String zzbbz;

        class C11981 extends zza {
            final /* synthetic */ zzc zzbbA;

            C11981(zzc com_google_android_gms_internal_zzrz_zzc) {
                this.zzbbA = com_google_android_gms_internal_zzrz_zzc;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.zzbbA.zzbbx) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.zzbbA.zzb(new zzd(status, googleNowAuthState));
            }
        }

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzTo, googleApiClient);
            this.zzYC = googleApiClient;
            this.zzbbz = str;
        }

        protected void zza(zzry com_google_android_gms_internal_zzry) throws RemoteException {
            if (this.zzbbx) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String packageName = this.zzYC.getContext().getPackageName();
            ((zzrx) com_google_android_gms_internal_zzry.zzqs()).zza(new C11981(this), packageName, this.zzbbz);
        }

        protected GoogleNowAuthResult zzbg(Status status) {
            if (this.zzbbx) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbg(status);
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient client, String accessToken) {
        return client.zza(new zzb(client, accessToken));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzc(client, webAppClientId));
    }
}
