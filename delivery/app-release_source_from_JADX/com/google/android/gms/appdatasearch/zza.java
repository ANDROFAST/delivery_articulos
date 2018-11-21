package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzki;

public final class zza {
    public static final zzc<zzkg> zzSe = new zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzkg, NoOptions> zzSf = new C06231();
    public static final Api<NoOptions> zzSg = new Api("AppDataSearch.LIGHTWEIGHT_API", zzSf, zzSe);
    public static final zzk zzSh = new zzki();

    static class C06231 extends com.google.android.gms.common.api.Api.zza<zzkg, NoOptions> {
        C06231() {
        }

        public zzkg zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkg(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }
}
