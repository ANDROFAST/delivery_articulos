package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzq implements SettingsApi {
    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient client, LocationSettingsRequest request) {
        return zza(client, request, null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new zza<LocationSettingsResult>(this, googleApiClient) {
            final /* synthetic */ zzq zzaMn;

            protected void zza(zzl com_google_android_gms_location_internal_zzl) throws RemoteException {
                com_google_android_gms_location_internal_zzl.zza(locationSettingsRequest, (zzb) this, str);
            }

            public LocationSettingsResult zzaO(Status status) {
                return new LocationSettingsResult(status);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzaO(status);
            }
        });
    }
}
