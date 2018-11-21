package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

final class zzb<T> extends zzi<Status> {
    private T mListener;
    private zzmn<T> zzaWl;
    private zza<T> zzbmv;

    interface zza<T> {
        void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, T t, zzmn<T> com_google_android_gms_internal_zzmn_T) throws RemoteException;
    }

    private zzb(GoogleApiClient googleApiClient, T t, zzmn<T> com_google_android_gms_internal_zzmn_T, zza<T> com_google_android_gms_wearable_internal_zzb_zza_T) {
        super(googleApiClient);
        this.mListener = zzx.zzy(t);
        this.zzaWl = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_T);
        this.zzbmv = (zza) zzx.zzy(com_google_android_gms_wearable_internal_zzb_zza_T);
    }

    static <T> PendingResult<Status> zza(GoogleApiClient googleApiClient, zza<T> com_google_android_gms_wearable_internal_zzb_zza_T, T t) {
        return googleApiClient.zza(new zzb(googleApiClient, t, googleApiClient.zzq(t), com_google_android_gms_wearable_internal_zzb_zza_T));
    }

    protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
        this.zzbmv.zza(com_google_android_gms_wearable_internal_zzce, this, this.mListener, this.zzaWl);
        this.mListener = null;
        this.zzaWl = null;
    }

    protected Status zzb(Status status) {
        this.mListener = null;
        this.zzaWl = null;
        return status;
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzb(status);
    }
}
