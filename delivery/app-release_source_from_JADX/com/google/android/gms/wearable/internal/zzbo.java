package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzbo implements NodeApi {

    public static class zza implements GetConnectedNodesResult {
        private final Status zzTA;
        private final List<Node> zzbox;

        public zza(Status status, List<Node> list) {
            this.zzTA = status;
            this.zzbox = list;
        }

        public List<Node> getNodes() {
            return this.zzbox;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    public static class zzb implements GetLocalNodeResult {
        private final Status zzTA;
        private final Node zzboy;

        public zzb(Status status, Node node) {
            this.zzTA = status;
            this.zzboy = node;
        }

        public Node getNode() {
            return this.zzboy;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static zza<NodeListener> zza(final IntentFilter[] intentFilterArr) {
        return new zza<NodeListener>() {
            public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, NodeListener nodeListener, zzmn<NodeListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_NodeApi_NodeListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, nodeListener, (zzmn) com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_NodeApi_NodeListener, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return zzb.zza(client, zza(new IntentFilter[]{zzcc.zzfY("com.google.android.gms.wearable.NODE_CHANGED")}), listener);
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new zzi<GetConnectedNodesResult>(this, client) {
            final /* synthetic */ zzbo zzbov;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzq(this);
            }

            protected GetConnectedNodesResult zzbx(Status status) {
                return new zza(status, new ArrayList());
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbx(status);
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new zzi<GetLocalNodeResult>(this, client) {
            final /* synthetic */ zzbo zzbov;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzp(this);
            }

            protected GetLocalNodeResult zzbw(Status status) {
                return new zzb(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbw(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ zzbo zzbov;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }
}
