package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzrx.zza;

public class zzry extends zzj<zzrx> {
    public zzry(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, context.getMainLooper(), 73, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdU(iBinder);
    }

    protected zzrx zzdU(IBinder iBinder) {
        return zza.zzdT(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzgi() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
