package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzlp;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API = new Api("CastRemoteDisplay.API", zzTp, zzTo);
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzlo(zzTo);
    private static final zzc<zzlp> zzTo = new zzc();
    private static final zza<zzlp, CastRemoteDisplayOptions> zzTp = new C06361();

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    static class C06361 extends zza<zzlp, CastRemoteDisplayOptions> {
        C06361() {
        }

        public zzlp zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastRemoteDisplayOptions castRemoteDisplayOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlp(context, looper, com_google_android_gms_common_internal_zzf, castRemoteDisplayOptions.zzYf, castRemoteDisplayOptions.zzYw, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    public static final class CastRemoteDisplayOptions implements HasOptions {
        final CastDevice zzYf;
        final CastRemoteDisplaySessionCallbacks zzYw;

        public static final class Builder {
            CastDevice zzYi;
            CastRemoteDisplaySessionCallbacks zzYx;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks callbacks) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzYi = castDevice;
                this.zzYx = callbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions();
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzYf = builder.zzYi;
            this.zzYw = builder.zzYx;
        }
    }

    private CastRemoteDisplay() {
    }
}
