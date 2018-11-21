package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkn.zza;

public class zzkk extends zzj<zzkn> {
    private final String zzTz;

    public zzkk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 77, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzTz = com_google_android_gms_common_internal_zzf.zzqd();
    }

    private Bundle zzlV() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzTz);
        return bundle;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaj(iBinder);
    }

    public void zza(zzkm com_google_android_gms_internal_zzkm) {
        try {
            ((zzkn) zzqs()).zza(com_google_android_gms_internal_zzkm);
        } catch (RemoteException e) {
        }
    }

    public void zza(zzkm com_google_android_gms_internal_zzkm, String str) {
        try {
            ((zzkn) zzqs()).zza(com_google_android_gms_internal_zzkm, str);
        } catch (RemoteException e) {
        }
    }

    protected zzkn zzaj(IBinder iBinder) {
        return zza.zzal(iBinder);
    }

    public void zzb(zzkm com_google_android_gms_internal_zzkm, String str) {
        try {
            ((zzkn) zzqs()).zzb(com_google_android_gms_internal_zzkm, str);
        } catch (RemoteException e) {
        }
    }

    protected String zzgh() {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected Bundle zzlU() {
        return zzlV();
    }
}
