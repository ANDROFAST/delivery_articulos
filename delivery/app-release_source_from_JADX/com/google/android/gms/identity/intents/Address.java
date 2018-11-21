package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqe;

public final class Address {
    public static final Api<AddressOptions> API = new Api("Address.API", zzTp, zzTo);
    static final zzc<zzqe> zzTo = new zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzqe, AddressOptions> zzTp = new C06701();

    static class C06701 extends com.google.android.gms.common.api.Api.zza<zzqe, AddressOptions> {
        C06701() {
        }

        public zzqe zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzqe((Activity) context, looper, com_google_android_gms_common_internal_zzf, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class zza extends com.google.android.gms.internal.zzlx.zza<Status, zzqe> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzTo, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.zza(new zza(googleApiClient) {
            protected void zza(zzqe com_google_android_gms_internal_zzqe) throws RemoteException {
                com_google_android_gms_internal_zzqe.zza(request, requestCode);
                zzb(Status.zzaeX);
            }
        });
    }
}
