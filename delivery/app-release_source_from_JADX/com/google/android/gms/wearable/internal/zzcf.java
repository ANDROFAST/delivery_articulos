package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zzb;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.LargeAssetApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzba.zza;
import com.google.android.gms.wearable.zzc;
import java.util.List;

final class zzcf<T> extends zza {
    private zzmn<MessageListener> zzaWe;
    private zzmn<com.google.android.gms.wearable.zza.zza> zzboV;
    private zzmn<zzc.zza> zzboW;
    private zzmn<DataListener> zzboX;
    private zzmn<NodeListener> zzboY;
    private zzmn<NodeApi.zza> zzboZ;
    private final IntentFilter[] zzbou;
    private zzmn<ChannelListener> zzbpa;
    private zzmn<LargeAssetApi.zza> zzbpb;
    private zzmn<CapabilityListener> zzbpc;
    private final String zzbpd;

    private zzcf(IntentFilter[] intentFilterArr, String str) {
        this.zzbou = (IntentFilter[]) zzx.zzy(intentFilterArr);
        this.zzbpd = str;
    }

    private static zzb<NodeApi.zza> zzF(final List<NodeParcelable> list) {
        return new zzb<NodeApi.zza>() {
            public void zza(NodeApi.zza com_google_android_gms_wearable_NodeApi_zza) {
                com_google_android_gms_wearable_NodeApi_zza.onConnectedNodes(list);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((NodeApi.zza) obj);
            }
        };
    }

    public static zzcf<ChannelListener> zza(zzmn<ChannelListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener, String str, IntentFilter[] intentFilterArr) {
        zzcf<ChannelListener> com_google_android_gms_wearable_internal_zzcf = new zzcf(intentFilterArr, (String) zzx.zzy(str));
        com_google_android_gms_wearable_internal_zzcf.zzbpa = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener);
        return com_google_android_gms_wearable_internal_zzcf;
    }

    public static zzcf<DataListener> zza(zzmn<DataListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_DataApi_DataListener, IntentFilter[] intentFilterArr) {
        zzcf<DataListener> com_google_android_gms_wearable_internal_zzcf = new zzcf(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzcf.zzboX = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_DataApi_DataListener);
        return com_google_android_gms_wearable_internal_zzcf;
    }

    private static zzb<DataListener> zzai(final DataHolder dataHolder) {
        return new zzb<DataListener>() {
            public void zza(DataListener dataListener) {
                try {
                    dataListener.onDataChanged(new DataEventBuffer(dataHolder));
                } finally {
                    dataHolder.close();
                }
            }

            public void zzpb() {
                dataHolder.close();
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((DataListener) obj);
            }
        };
    }

    private static zzb<com.google.android.gms.wearable.zza.zza> zzb(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        return new zzb<com.google.android.gms.wearable.zza.zza>() {
            public void zza(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza) {
                com_google_android_gms_wearable_zza_zza.zza(amsEntityUpdateParcelable);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((com.google.android.gms.wearable.zza.zza) obj);
            }
        };
    }

    private static zzb<zzc.zza> zzb(final AncsNotificationParcelable ancsNotificationParcelable) {
        return new zzb<zzc.zza>() {
            public void zza(zzc.zza com_google_android_gms_wearable_zzc_zza) {
                com_google_android_gms_wearable_zzc_zza.zza(ancsNotificationParcelable);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((zzc.zza) obj);
            }
        };
    }

    private static zzb<CapabilityListener> zzb(final CapabilityInfoParcelable capabilityInfoParcelable) {
        return new zzb<CapabilityListener>() {
            public void zza(CapabilityListener capabilityListener) {
                capabilityListener.onCapabilityChanged(capabilityInfoParcelable);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((CapabilityListener) obj);
            }
        };
    }

    private static zzb<ChannelListener> zzb(final ChannelEventParcelable channelEventParcelable) {
        return new zzb<ChannelListener>() {
            public void zzb(ChannelListener channelListener) {
                channelEventParcelable.zza(channelListener);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zzb((ChannelListener) obj);
            }
        };
    }

    private static zzb<LargeAssetApi.zza> zzb(final LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
        return new zzb<LargeAssetApi.zza>() {
            public void zza(LargeAssetApi.zza com_google_android_gms_wearable_LargeAssetApi_zza) {
                com_google_android_gms_wearable_LargeAssetApi_zza.zza(largeAssetQueueStateChangeParcelable);
                largeAssetQueueStateChangeParcelable.release();
            }

            public void zzpb() {
                largeAssetQueueStateChangeParcelable.release();
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((LargeAssetApi.zza) obj);
            }
        };
    }

    private static zzb<MessageListener> zzb(final MessageEventParcelable messageEventParcelable) {
        return new zzb<MessageListener>() {
            public void zza(MessageListener messageListener) {
                messageListener.onMessageReceived(messageEventParcelable);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((MessageListener) obj);
            }
        };
    }

    public static zzcf<MessageListener> zzb(zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_MessageApi_MessageListener, IntentFilter[] intentFilterArr) {
        zzcf<MessageListener> com_google_android_gms_wearable_internal_zzcf = new zzcf(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzcf.zzaWe = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_MessageApi_MessageListener);
        return com_google_android_gms_wearable_internal_zzcf;
    }

    private static zzb<NodeListener> zzc(final NodeParcelable nodeParcelable) {
        return new zzb<NodeListener>() {
            public void zza(NodeListener nodeListener) {
                nodeListener.onPeerConnected(nodeParcelable);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((NodeListener) obj);
            }
        };
    }

    public static zzcf<NodeListener> zzc(zzmn<NodeListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_NodeApi_NodeListener, IntentFilter[] intentFilterArr) {
        zzcf<NodeListener> com_google_android_gms_wearable_internal_zzcf = new zzcf(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzcf.zzboY = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_NodeApi_NodeListener);
        return com_google_android_gms_wearable_internal_zzcf;
    }

    private static zzb<NodeListener> zzd(final NodeParcelable nodeParcelable) {
        return new zzb<NodeListener>() {
            public void zza(NodeListener nodeListener) {
                nodeListener.onPeerDisconnected(nodeParcelable);
            }

            public void zzpb() {
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((NodeListener) obj);
            }
        };
    }

    public static zzcf<ChannelListener> zzd(zzmn<ChannelListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener, IntentFilter[] intentFilterArr) {
        zzcf<ChannelListener> com_google_android_gms_wearable_internal_zzcf = new zzcf(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzcf.zzbpa = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener);
        return com_google_android_gms_wearable_internal_zzcf;
    }

    public static zzcf<CapabilityListener> zze(zzmn<CapabilityListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_CapabilityApi_CapabilityListener, IntentFilter[] intentFilterArr) {
        zzcf<CapabilityListener> com_google_android_gms_wearable_internal_zzcf = new zzcf(intentFilterArr, null);
        com_google_android_gms_wearable_internal_zzcf.zzbpc = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_CapabilityApi_CapabilityListener);
        return com_google_android_gms_wearable_internal_zzcf;
    }

    private static void zze(zzmn<?> com_google_android_gms_internal_zzmn_) {
        if (com_google_android_gms_internal_zzmn_ != null) {
            com_google_android_gms_internal_zzmn_.clear();
        }
    }

    public void clear() {
        zze(this.zzboV);
        this.zzboV = null;
        zze(this.zzboW);
        this.zzboW = null;
        zze(this.zzboX);
        this.zzboX = null;
        zze(this.zzaWe);
        this.zzaWe = null;
        zze(this.zzboY);
        this.zzboY = null;
        zze(this.zzboZ);
        this.zzboZ = null;
        zze(this.zzbpa);
        this.zzbpa = null;
        zze(this.zzbpb);
        this.zzbpb = null;
        zze(this.zzbpc);
        this.zzbpc = null;
    }

    public void onConnectedNodes(List<NodeParcelable> connectedNodes) {
        if (this.zzboZ != null) {
            this.zzboZ.zza(zzF(connectedNodes));
        }
    }

    public IntentFilter[] zzGZ() {
        return this.zzbou;
    }

    public String zzHa() {
        return this.zzbpd;
    }

    public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.zzboV != null) {
            this.zzboV.zza(zzb(amsEntityUpdateParcelable));
        }
    }

    public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzboW != null) {
            this.zzboW.zza(zzb(ancsNotificationParcelable));
        }
    }

    public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzbpc != null) {
            this.zzbpc.zza(zzb(capabilityInfoParcelable));
        }
    }

    public void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzbpa != null) {
            this.zzbpa.zza(zzb(channelEventParcelable));
        }
    }

    public void zza(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
        if (this.zzbpb != null) {
            this.zzbpb.zza(zzb(largeAssetQueueStateChangeParcelable));
        } else {
            largeAssetQueueStateChangeParcelable.release();
        }
    }

    public void zza(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) {
        throw new UnsupportedOperationException("onLargeAssetSyncRequest not supported on live listener");
    }

    public void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzaWe != null) {
            this.zzaWe.zza(zzb(messageEventParcelable));
        }
    }

    public void zza(NodeParcelable nodeParcelable) {
        if (this.zzboY != null) {
            this.zzboY.zza(zzc(nodeParcelable));
        }
    }

    public void zza(zzax com_google_android_gms_wearable_internal_zzax, String str, int i) {
        throw new UnsupportedOperationException("openFileDescriptor not supported on live listener");
    }

    public void zzag(DataHolder dataHolder) {
        if (this.zzboX != null) {
            this.zzboX.zza(zzai(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    public void zzb(NodeParcelable nodeParcelable) {
        if (this.zzboY != null) {
            this.zzboY.zza(zzd(nodeParcelable));
        }
    }
}
