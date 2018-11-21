package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api("Plus.API", zzTp, zzTo);
    @Deprecated
    public static final Account AccountApi = new zzrk();
    public static final Moments MomentsApi = new zzrn();
    public static final People PeopleApi = new zzro();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final zzc<zze> zzTo = new zzc();
    static final com.google.android.gms.common.api.Api.zza<zze, PlusOptions> zzTp = new C07781();
    public static final zzb zzaYJ = new zzrm();
    public static final zza zzaYK = new zzrl();

    static class C07781 extends com.google.android.gms.common.api.Api.zza<zze, PlusOptions> {
        C07781() {
        }

        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, new PlusSession(com_google_android_gms_common_internal_zzf.zzpY().name, zzoa.zzc(com_google_android_gms_common_internal_zzf.zzqb()), (String[]) plusOptions.zzaYM.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class PlusOptions implements Optional {
        final String zzaYL;
        final Set<String> zzaYM;

        public static final class Builder {
            String zzaYL;
            final Set<String> zzaYM = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                zzx.zzb((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.zzaYM.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.zzaYL = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.zzaYL = null;
            this.zzaYM = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzaYL = builder.zzaYL;
            this.zzaYM = builder.zzaYM;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzTo, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zze) googleApiClient.zza(zzTo) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
