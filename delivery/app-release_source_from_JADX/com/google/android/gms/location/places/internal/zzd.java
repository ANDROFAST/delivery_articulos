package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zzb;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zza;
import com.google.android.gms.location.places.zzl.zzc;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzd implements GeoDataApi {
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient client, final AddPlaceRequest addPlaceRequest) {
        return client.zzb(new zzc<zze>(this, Places.zzaMU, client) {
            final /* synthetic */ zzd zzaNs;

            protected void zza(zze com_google_android_gms_location_places_internal_zze) throws RemoteException {
                com_google_android_gms_location_places_internal_zze.zza(new zzl((zzc) this, com_google_android_gms_location_places_internal_zze.getContext()), addPlaceRequest);
            }
        });
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient client, String query, LatLngBounds bounds, AutocompleteFilter filter) {
        final String str = query;
        final LatLngBounds latLngBounds = bounds;
        final AutocompleteFilter autocompleteFilter = filter;
        return client.zza(new zza<zze>(this, Places.zzaMU, client) {
            final /* synthetic */ zzd zzaNs;

            protected void zza(zze com_google_android_gms_location_places_internal_zze) throws RemoteException {
                com_google_android_gms_location_places_internal_zze.zza(new zzl((zza) this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient client, final String... placeIds) {
        boolean z = true;
        if (placeIds == null || placeIds.length < 1) {
            z = false;
        }
        zzx.zzab(z);
        return client.zza(new zzc<zze>(this, Places.zzaMU, client) {
            final /* synthetic */ zzd zzaNs;

            protected void zza(zze com_google_android_gms_location_places_internal_zze) throws RemoteException {
                com_google_android_gms_location_places_internal_zze.zza(new zzl((zzc) this, com_google_android_gms_location_places_internal_zze.getContext()), Arrays.asList(placeIds));
            }
        });
    }

    public PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient client, final String placeId) {
        return client.zza(new zzb<zze>(this, Places.zzaMU, client) {
            final /* synthetic */ zzd zzaNs;

            protected void zza(zze com_google_android_gms_location_places_internal_zze) throws RemoteException {
                com_google_android_gms_location_places_internal_zze.zza(new zzf((zzb) this), placeId);
            }
        });
    }
}
