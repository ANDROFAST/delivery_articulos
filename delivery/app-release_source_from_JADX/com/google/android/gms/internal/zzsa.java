package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzh;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

public final class zzsa {
    public static final Api<zzsd> API = new Api("SignIn.API", zzTp, zzTo);
    public static final zzc<zzi> zzTo = new zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzi, zzsd> zzTp = new C07631();
    public static final Scope zzVA = new Scope(Scopes.PROFILE);
    public static final Scope zzVB = new Scope("email");
    public static final Api<zza> zzamM = new Api("SignIn.INTERNAL_API", zzbbE, zzatI);
    public static final zzc<zzi> zzatI = new zzc();
    static final com.google.android.gms.common.api.Api.zza<zzi, zza> zzbbE = new C07642();
    public static final zzsb zzbbF = new zzh();

    static class C07631 extends com.google.android.gms.common.api.Api.zza<zzi, zzsd> {
        C07631() {
        }

        public zzi zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzsd com_google_android_gms_internal_zzsd, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, true, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzsd == null ? zzsd.zzbbH : com_google_android_gms_internal_zzsd, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    }

    static class C07642 extends com.google.android.gms.common.api.Api.zza<zzi, zza> {
        C07642() {
        }

        public zzi zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_internal_zzsa_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, false, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzsa_zza.zzDK(), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static class zza implements HasOptions {
        private final Bundle zzbbG;

        public Bundle zzDK() {
            return this.zzbbG;
        }
    }
}
