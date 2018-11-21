package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.bootstrap.zza;

public class zzqs implements zza {
    public static final zzc<zzqr> zzTo = new zzc();
    public static final Api.zza<zzqr, NoOptions> zzTp = new C07551();

    static class C07551 extends Api.zza<zzqr, NoOptions> {
        C07551() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzo(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzqr zzo(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqr(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }
}
