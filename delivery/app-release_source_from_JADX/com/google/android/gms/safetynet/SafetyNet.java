package com.google.android.gms.safetynet;

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
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzrv;

public final class SafetyNet {
    public static final Api<NoOptions> API = new Api("SafetyNet.API", zzTp, zzTo);
    public static final SafetyNetApi SafetyNetApi = new zzrt();
    public static final zzc<zzru> zzTo = new zzc();
    public static final zza<zzru, NoOptions> zzTp = new C07791();
    public static final zzc zzbbj = new zzrv();

    static class C07791 extends zza<zzru, NoOptions> {
        C07791() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzs(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzru zzs(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzru(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private SafetyNet() {
    }
}
