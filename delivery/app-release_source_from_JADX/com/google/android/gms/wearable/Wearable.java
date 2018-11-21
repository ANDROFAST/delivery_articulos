package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.wearable.internal.zzbc;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbo;
import com.google.android.gms.wearable.internal.zzcb;
import com.google.android.gms.wearable.internal.zzce;
import com.google.android.gms.wearable.internal.zzcg;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable {
    public static final Api<WearableOptions> API = new Api("Wearable.API", zzTp, zzTo);
    public static final CapabilityApi CapabilityApi = new zzj();
    public static final ChannelApi ChannelApi = new zzl();
    public static final DataApi DataApi = new zzx();
    public static final MessageApi MessageApi = new zzbm();
    public static final NodeApi NodeApi = new zzbo();
    public static final zzc<zzce> zzTo = new zzc();
    private static final zza<zzce, WearableOptions> zzTp = new C07981();
    public static final LargeAssetApi zzbma = new zzbc();
    public static final zzc zzbmb = new zzg();
    public static final zza zzbmc = new zze();
    public static final zzf zzbmd = new zzw();
    public static final zzj zzbme = new zzcb();
    public static final zzl zzbmf = new zzcg();

    static class C07981 extends zza<zzce, WearableOptions> {
        C07981() {
        }

        public zzce zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new zzce(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
