package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzl implements ChannelApi {

    static final class zza implements OpenChannelResult {
        private final Status zzTA;
        private final Channel zzbmT;

        zza(Status status, Channel channel) {
            this.zzTA = (Status) zzx.zzy(status);
            this.zzbmT = channel;
        }

        public Channel getChannel() {
            return this.zzbmT;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    static final class zzb extends zzi<Status> {
        private final String zzTR;
        private ChannelListener zzbmU;

        zzb(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzbmU = (ChannelListener) zzx.zzy(channelListener);
            this.zzTR = str;
        }

        protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
            com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, this.zzbmU, this.zzTR);
            this.zzbmU = null;
        }

        public Status zzb(Status status) {
            this.zzbmU = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static zza<ChannelListener> zza(final IntentFilter[] intentFilterArr) {
        return new zza<ChannelListener>() {
            public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, zzmn<ChannelListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, channelListener, (zzmn) com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener, null, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return zzb.zza(client, zza(new IntentFilter[]{zzcc.zzfY(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    public PendingResult<OpenChannelResult> openChannel(GoogleApiClient client, final String nodeId, final String path) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) nodeId, (Object) "nodeId is null");
        zzx.zzb((Object) path, (Object) "path is null");
        return client.zza(new zzi<OpenChannelResult>(this, client) {
            final /* synthetic */ zzl zzbmS;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zze(this, nodeId, path);
            }

            public OpenChannelResult zzbo(Status status) {
                return new zza(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbo(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzb(client, listener, null));
    }
}
