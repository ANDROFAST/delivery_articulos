package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzrz;

public class SearchAuth {
    public static final Api<NoOptions> API = new Api("SearchAuth.API", zzbbw, zzTo);
    public static final SearchAuthApi SearchAuthApi = new zzrz();
    public static final zzc<zzry> zzTo = new zzc();
    private static final zza<zzry, NoOptions> zzbbw = new C07801();

    public static class StatusCodes {
        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;
    }

    static class C07801 extends zza<zzry, NoOptions> {
        C07801() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzt(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzry zzt(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzry(context, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    private SearchAuth() {
    }
}
