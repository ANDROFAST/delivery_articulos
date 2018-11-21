package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznz;

public class zzl extends com.google.android.gms.location.places.internal.zzi.zza {
    private static final String TAG = zzl.class.getSimpleName();
    private final Context mContext;
    private final zzd zzaMW;
    private final zza zzaMX;
    private final zze zzaMY;
    private final zzf zzaMZ;
    private final zzc zzaNa;

    public static abstract class zzb<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.internal.zzlx.zza<R, A> {
        public zzb(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }
    }

    public static abstract class zza<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected AutocompletePredictionBuffer zzaS(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbJ(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaS(status);
        }
    }

    public static abstract class zzc<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected PlaceBuffer zzaT(Status status) {
            return new PlaceBuffer(DataHolder.zzbJ(status.getStatusCode()), null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaT(status);
        }
    }

    public static abstract class zzd<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected PlaceLikelihoodBuffer zzaU(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbJ(status.getStatusCode()), 100, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaU(status);
        }
    }

    public static abstract class zze<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        protected com.google.android.gms.location.places.personalized.zzd zzaV(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaW(status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaV(status);
        }
    }

    public static abstract class zzf<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<Status, A> {
        public zzf(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zzl(zza com_google_android_gms_location_places_zzl_zza) {
        this.zzaMW = null;
        this.zzaMX = com_google_android_gms_location_places_zzl_zza;
        this.zzaMY = null;
        this.zzaMZ = null;
        this.zzaNa = null;
        this.mContext = null;
    }

    public zzl(zzc com_google_android_gms_location_places_zzl_zzc, Context context) {
        this.zzaMW = null;
        this.zzaMX = null;
        this.zzaMY = null;
        this.zzaMZ = null;
        this.zzaNa = com_google_android_gms_location_places_zzl_zzc;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzd com_google_android_gms_location_places_zzl_zzd, Context context) {
        this.zzaMW = com_google_android_gms_location_places_zzl_zzd;
        this.zzaMX = null;
        this.zzaMY = null;
        this.zzaMZ = null;
        this.zzaNa = null;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzf com_google_android_gms_location_places_zzl_zzf) {
        this.zzaMW = null;
        this.zzaMX = null;
        this.zzaMY = null;
        this.zzaMZ = com_google_android_gms_location_places_zzl_zzf;
        this.zzaNa = null;
        this.mContext = null;
    }

    public void zzaR(Status status) throws RemoteException {
        this.zzaMZ.zzb(status);
    }

    public void zzac(DataHolder dataHolder) throws RemoteException {
        zzx.zza(this.zzaMW != null, (Object) "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zznz.zzrY());
            }
            this.zzaMW.zzx(Status.zzaeZ);
            return;
        }
        this.zzaMW.zzb(new PlaceLikelihoodBuffer(dataHolder, 100, this.mContext));
    }

    public void zzad(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zznz.zzrY());
            }
            this.zzaMX.zzx(Status.zzaeZ);
            return;
        }
        this.zzaMX.zzb(new AutocompletePredictionBuffer(dataHolder));
    }

    public void zzae(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zznz.zzrY());
            }
            this.zzaMY.zzx(Status.zzaeZ);
            return;
        }
        this.zzaMY.zzb(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
    }

    public void zzaf(DataHolder dataHolder) throws RemoteException {
        this.zzaNa.zzb(new PlaceBuffer(dataHolder, this.mContext));
    }
}
