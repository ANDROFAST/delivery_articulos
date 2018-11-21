package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzbm implements MessageApi {

    public static class zzb implements SendMessageResult {
        private final Status zzTA;
        private final int zzamD;

        public zzb(Status status, int i) {
            this.zzTA = status;
            this.zzamD = i;
        }

        public int getRequestId() {
            return this.zzamD;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class zza extends zzi<Status> {
        private zzmn<MessageListener> zzaWl;
        private MessageListener zzbot;
        private IntentFilter[] zzbou;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_MessageApi_MessageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbot = (MessageListener) zzx.zzy(messageListener);
            this.zzaWl = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_MessageApi_MessageListener);
            this.zzbou = (IntentFilter[]) zzx.zzy(intentFilterArr);
        }

        protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
            com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, this.zzbot, this.zzaWl, this.zzbou);
            this.zzbot = null;
            this.zzaWl = null;
            this.zzbou = null;
        }

        public Status zzb(Status status) {
            this.zzbot = null;
            this.zzaWl = null;
            this.zzbou = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, googleApiClient.zzq(messageListener), intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return zza(client, listener, new IntentFilter[]{zzcc.zzfY(MessageApi.ACTION_MESSAGE_RECEIVED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener, Uri uri, int filterType) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzcc.zza(MessageApi.ACTION_MESSAGE_RECEIVED, uri, filterType)});
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ zzbm zzbor;

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

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.zza(new zzi<SendMessageResult>(this, client) {
            final /* synthetic */ zzbm zzbor;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, str, str2, bArr);
            }

            protected SendMessageResult zzbv(Status status) {
                return new zzb(status, -1);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbv(status);
            }
        });
    }
}
