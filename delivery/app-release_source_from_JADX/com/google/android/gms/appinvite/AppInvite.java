package com.google.android.gms.appinvite;

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
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzkk;

public final class AppInvite {
    public static final Api<NoOptions> API = new Api("AppInvite.API", zzTp, zzTo);
    public static final AppInviteApi AppInviteApi = new zzkj();
    public static final zzc<zzkk> zzTo = new zzc();
    private static final zza<zzkk, NoOptions> zzTp = new C06241();

    static class C06241 extends zza<zzkk, NoOptions> {
        C06241() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzkk zzb(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkk(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    private AppInvite() {
    }
}
