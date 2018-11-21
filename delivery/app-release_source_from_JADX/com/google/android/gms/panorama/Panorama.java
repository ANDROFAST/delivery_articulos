package com.google.android.gms.panorama;

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
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;

public final class Panorama {
    public static final Api<NoOptions> API = new Api("Panorama.API", zzTp, zzTo);
    public static final PanoramaApi PanoramaApi = new zzrf();
    public static final zzc<zzrg> zzTo = new zzc();
    static final zza<zzrg, NoOptions> zzTp = new C07771();

    static class C07771 extends zza<zzrg, NoOptions> {
        C07771() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzr(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzrg zzr(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrg(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private Panorama() {
    }
}
