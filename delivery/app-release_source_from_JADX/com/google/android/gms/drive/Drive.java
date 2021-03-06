package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;

public final class Drive {
    public static final Api<NoOptions> API = new Api("Drive.API", new C10911(), zzTo);
    public static final DriveApi DriveApi = new zzs();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzaa();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final zzc<zzu> zzTo = new zzc();
    public static final Scope zzamK = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzamL = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzamM = new Api("Drive.INTERNAL_API", new C10922(), zzTo);
    public static final zzd zzamN = new zzx();
    public static final zzg zzamO = new zzac();

    public static abstract class zza<O extends ApiOptions> extends com.google.android.gms.common.api.Api.zza<zzu, O> {
        protected abstract Bundle zza(O o);

        public zzu zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzu(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    static class C10911 extends zza<NoOptions> {
        C10911() {
        }

        protected Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }

    static class C10922 extends zza<zzb> {
        C10922() {
        }

        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzsg();
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzTn;

        public Bundle zzsg() {
            return this.zzTn;
        }
    }

    private Drive() {
    }
}
