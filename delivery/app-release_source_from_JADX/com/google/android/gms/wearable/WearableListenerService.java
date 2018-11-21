package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.LargeAssetQueueStateChangeParcelable;
import com.google.android.gms.wearable.internal.LargeAssetSyncRequestPayload;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzay;
import com.google.android.gms.wearable.internal.zzbj;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener, com.google.android.gms.wearable.NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private boolean zzOR;
    private String zzSp;
    private IBinder zzaiT;
    private Handler zzbmg;
    private final Object zzbmh = new Object();

    private final class zza extends com.google.android.gms.wearable.internal.zzba.zza {
        private volatile int zzaiR;
        final /* synthetic */ WearableListenerService zzbmi;

        private zza(WearableListenerService wearableListenerService) {
            this.zzbmi = wearableListenerService;
            this.zzaiR = -1;
        }

        private void zzGA() throws SecurityException {
            int callingUid = Binder.getCallingUid();
            if (callingUid != this.zzaiR) {
                if (GooglePlayServicesUtil.zze(this.zzbmi, callingUid)) {
                    this.zzaiR = callingUid;
                    return;
                }
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }

        private boolean zza(Runnable runnable, String str, Object obj) {
            return !(this.zzbmi instanceof zzk) ? false : zzb(runnable, str, obj);
        }

        private boolean zzb(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, this.zzbmi.zzSp, obj}));
            }
            zzGA();
            synchronized (this.zzbmi.zzbmh) {
                if (this.zzbmi.zzOR) {
                    return false;
                }
                this.zzbmi.zzbmg.post(runnable);
                return true;
            }
        }

        public void onConnectedNodes(final List<NodeParcelable> connectedNodes) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    this.zzbmk.zzbmi.onConnectedNodes(connectedNodes);
                }
            }, "onConnectedNodes", connectedNodes);
        }

        public void zza(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            zza(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    ((zzk) this.zzbmk.zzbmi).zza(amsEntityUpdateParcelable);
                }
            }, "onEntityUpdate", (Object) amsEntityUpdateParcelable);
        }

        public void zza(final AncsNotificationParcelable ancsNotificationParcelable) {
            zza(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    ((zzk) this.zzbmk.zzbmi).zza(ancsNotificationParcelable);
                }
            }, "onNotificationReceived", (Object) ancsNotificationParcelable);
        }

        public void zza(final CapabilityInfoParcelable capabilityInfoParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    this.zzbmk.zzbmi.onCapabilityChanged(capabilityInfoParcelable);
                }
            }, "onConnectedCapabilityChanged", capabilityInfoParcelable);
        }

        public void zza(final ChannelEventParcelable channelEventParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    channelEventParcelable.zza(this.zzbmk.zzbmi);
                }
            }, "onChannelEvent", channelEventParcelable);
        }

        public void zza(final LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) {
            try {
                if (!zza(new Runnable(this) {
                    final /* synthetic */ zza zzbmk;

                    public void run() {
                        try {
                            ((zzk) this.zzbmk.zzbmi).zza(largeAssetQueueStateChangeParcelable);
                        } finally {
                            largeAssetQueueStateChangeParcelable.release();
                        }
                    }
                }, "onLargeAssetStateChanged", (Object) largeAssetQueueStateChangeParcelable)) {
                }
            } finally {
                largeAssetQueueStateChangeParcelable.release();
            }
        }

        public void zza(final LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, final zzay com_google_android_gms_wearable_internal_zzay) {
            zza(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    zzh com_google_android_gms_wearable_internal_zzbj = new zzbj(largeAssetSyncRequestPayload, com_google_android_gms_wearable_internal_zzay);
                    ((zzk) this.zzbmk.zzbmi).zza(com_google_android_gms_wearable_internal_zzbj);
                    try {
                        com_google_android_gms_wearable_internal_zzbj.zzGX();
                    } catch (Throwable e) {
                        Log.w("WearableLS", "Failed to respond to LargeAssetRequest", e);
                    }
                }
            }, "onLargeAssetSyncRequest", (Object) largeAssetSyncRequestPayload);
        }

        public void zza(final MessageEventParcelable messageEventParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    this.zzbmk.zzbmi.onMessageReceived(messageEventParcelable);
                }
            }, "onMessageReceived", messageEventParcelable);
        }

        public void zza(final NodeParcelable nodeParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    this.zzbmk.zzbmi.onPeerConnected(nodeParcelable);
                }
            }, "onPeerConnected", nodeParcelable);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zza(com.google.android.gms.wearable.internal.zzax r7, java.lang.String r8, int r9) {
            /*
            r6 = this;
            r1 = 0;
            r0 = r6.zzbmi;
            r0 = r0 instanceof com.google.android.gms.wearable.zzk;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return;
        L_0x0008:
            r0 = "WearableLS";
            r2 = 3;
            r0 = android.util.Log.isLoggable(r0, r2);
            if (r0 == 0) goto L_0x0029;
        L_0x0011:
            r0 = "WearableLS";
            r2 = "openFileDescriptor: %s (mode=%s)";
            r3 = 2;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r3[r4] = r8;
            r4 = 1;
            r5 = java.lang.Integer.valueOf(r9);
            r3[r4] = r5;
            r2 = java.lang.String.format(r2, r3);
            android.util.Log.d(r0, r2);
        L_0x0029:
            r6.zzGA();
            r0 = r6.zzbmi;
            r2 = r0.zzbmh;
            monitor-enter(r2);
            r0 = r6.zzbmi;	 Catch:{ all -> 0x003d }
            r0 = r0.zzOR;	 Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0040;
        L_0x003b:
            monitor-exit(r2);	 Catch:{ all -> 0x003d }
            goto L_0x0007;
        L_0x003d:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x003d }
            throw r0;
        L_0x0040:
            monitor-exit(r2);	 Catch:{ all -> 0x003d }
            r0 = new java.io.File;	 Catch:{ RemoteException -> 0x00b0 }
            r0.<init>(r8);	 Catch:{ RemoteException -> 0x00b0 }
            r0 = r0.getParentFile();	 Catch:{ RemoteException -> 0x00b0 }
            r2 = r0.exists();	 Catch:{ RemoteException -> 0x00b0 }
            if (r2 != 0) goto L_0x007a;
        L_0x0050:
            r2 = r0.mkdirs();	 Catch:{ RemoteException -> 0x00b0 }
            if (r2 != 0) goto L_0x007a;
        L_0x0056:
            r2 = "WearableLS";
            r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x00b0 }
            r3.<init>();	 Catch:{ RemoteException -> 0x00b0 }
            r4 = "Unable to create directory: ";
            r3 = r3.append(r4);	 Catch:{ RemoteException -> 0x00b0 }
            r0 = r0.getAbsolutePath();	 Catch:{ RemoteException -> 0x00b0 }
            r0 = r3.append(r0);	 Catch:{ RemoteException -> 0x00b0 }
            r0 = r0.toString();	 Catch:{ RemoteException -> 0x00b0 }
            android.util.Log.w(r2, r0);	 Catch:{ RemoteException -> 0x00b0 }
            r0 = 0;
            r7.zzb(r0);	 Catch:{ RemoteException -> 0x00b0 }
            com.google.android.gms.internal.zznt.zza(r1);
            goto L_0x0007;
        L_0x007a:
            r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x008e }
            r0.<init>(r8);	 Catch:{ FileNotFoundException -> 0x008e }
            r2 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
            r2 = r2 | r9;
            r1 = android.os.ParcelFileDescriptor.open(r0, r2);	 Catch:{ FileNotFoundException -> 0x008e }
            r7.zzb(r1);	 Catch:{ RemoteException -> 0x00b0 }
            com.google.android.gms.internal.zznt.zza(r1);
            goto L_0x0007;
        L_0x008e:
            r0 = move-exception;
            r2 = "WearableLS";
            r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x00b0 }
            r3.<init>();	 Catch:{ RemoteException -> 0x00b0 }
            r4 = "Failed to open file: ";
            r3 = r3.append(r4);	 Catch:{ RemoteException -> 0x00b0 }
            r3 = r3.append(r8);	 Catch:{ RemoteException -> 0x00b0 }
            r3 = r3.toString();	 Catch:{ RemoteException -> 0x00b0 }
            android.util.Log.w(r2, r3, r0);	 Catch:{ RemoteException -> 0x00b0 }
            r0 = 0;
            r7.zzb(r0);	 Catch:{ RemoteException -> 0x00b0 }
            com.google.android.gms.internal.zznt.zza(r1);
            goto L_0x0007;
        L_0x00b0:
            r0 = move-exception;
            r2 = "WearableLS";
            r3 = "Failed to set file descriptor";
            android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.zznt.zza(r1);
            goto L_0x0007;
        L_0x00bd:
            r0 = move-exception;
            com.google.android.gms.internal.zznt.zza(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.WearableListenerService.zza.zza(com.google.android.gms.wearable.internal.zzax, java.lang.String, int):void");
        }

        public void zzag(final DataHolder dataHolder) {
            try {
                if (!zzb(new Runnable(this) {
                    final /* synthetic */ zza zzbmk;

                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            this.zzbmk.zzbmi.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                }, "onDataItemChanged", dataHolder)) {
                }
            } finally {
                dataHolder.close();
            }
        }

        public void zzb(final NodeParcelable nodeParcelable) {
            zzb(new Runnable(this) {
                final /* synthetic */ zza zzbmk;

                public void run() {
                    this.zzbmk.zzbmi.onPeerDisconnected(nodeParcelable);
                }
            }, "onPeerDisconnected", nodeParcelable);
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.zzaiT : null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.zzSp = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzbmg = new Handler(handlerThread.getLooper());
        this.zzaiT = new zza();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        synchronized (this.zzbmh) {
            this.zzOR = true;
            if (this.zzbmg == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzbmg.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
