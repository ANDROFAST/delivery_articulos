package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zzd;
import com.google.android.gms.location.places.zzl.zzf;

public class zzj implements PlaceDetectionApi {
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new zzd<zzk>(this, Places.zzaMV, client) {
            final /* synthetic */ zzj zzaNB;

            protected void zza(zzk com_google_android_gms_location_places_internal_zzk) throws RemoteException {
                com_google_android_gms_location_places_internal_zzk.zza(new zzl((zzd) this, com_google_android_gms_location_places_internal_zzk.getContext()), filter);
            }
        });
    }

    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new zzf<zzk>(this, Places.zzaMV, client) {
            final /* synthetic */ zzj zzaNB;

            protected void zza(zzk com_google_android_gms_location_places_internal_zzk) throws RemoteException {
                com_google_android_gms_location_places_internal_zzk.zza(new zzl((zzf) this), report);
            }
        });
    }
}
