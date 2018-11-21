package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishCallback;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

class zzj extends com.google.android.gms.common.internal.zzj<zzd> {
    private final String zzTz;
    private final String zzaXo;
    private final boolean zzaXp;
    private final boolean zzaXq;
    private final zze<StatusCallback> zzaXr = new C07731(this);
    private final zze<MessageListener> zzaXs = new C07742(this);

    private static abstract class zze<C> {
        private final SimpleArrayMap<C, IBinder> zzalY;

        private zze() {
            this.zzalY = new SimpleArrayMap(1);
        }

        protected abstract IBinder zzF(C c);

        IBinder zzG(C c) {
            if (c == null) {
                return null;
            }
            IBinder iBinder = (IBinder) this.zzalY.get(c);
            if (iBinder != null) {
                return iBinder;
            }
            iBinder = zzF(c);
            this.zzalY.put(c, iBinder);
            return iBinder;
        }

        void zzH(C c) {
            if (c != null) {
                this.zzalY.remove(c);
            }
        }
    }

    class C07731 extends zze<StatusCallback> {
        final /* synthetic */ zzj zzaXt;

        C07731(zzj com_google_android_gms_nearby_messages_internal_zzj) {
            this.zzaXt = com_google_android_gms_nearby_messages_internal_zzj;
            super();
        }

        protected /* synthetic */ IBinder zzF(Object obj) {
            return zza((StatusCallback) obj);
        }

        protected IBinder zza(StatusCallback statusCallback) {
            return new zzc(statusCallback);
        }
    }

    class C07742 extends zze<MessageListener> {
        final /* synthetic */ zzj zzaXt;

        C07742(zzj com_google_android_gms_nearby_messages_internal_zzj) {
            this.zzaXt = com_google_android_gms_nearby_messages_internal_zzj;
            super();
        }

        protected /* synthetic */ IBinder zzF(Object obj) {
            return zza((MessageListener) obj);
        }

        protected IBinder zza(MessageListener messageListener) {
            return new zza(messageListener);
        }
    }

    private static class zza extends com.google.android.gms.nearby.messages.internal.zzb.zza {
        private final MessageListener zzaXu;

        private zza(MessageListener messageListener) {
            this.zzaXu = messageListener;
        }

        public void zza(MessageWrapper messageWrapper) throws RemoteException {
            this.zzaXu.onFound(messageWrapper.zzaXn);
        }

        public void zzb(MessageWrapper messageWrapper) throws RemoteException {
            this.zzaXu.onLost(messageWrapper.zzaXn);
        }
    }

    private static class zzb extends com.google.android.gms.nearby.messages.internal.zze.zza {
        private final PublishCallback zzaXv;

        private zzb(PublishCallback publishCallback) {
            this.zzaXv = publishCallback;
        }

        private static zzb zza(PublishCallback publishCallback) {
            return publishCallback == null ? null : new zzb(publishCallback);
        }

        public void onExpired() {
            this.zzaXv.onExpired();
        }
    }

    private static class zzc extends com.google.android.gms.nearby.messages.internal.zzf.zza {
        private final StatusCallback zzaXw;

        private zzc(StatusCallback statusCallback) {
            this.zzaXw = statusCallback;
        }

        public void onPermissionChanged(boolean granted) {
            this.zzaXw.onPermissionChanged(granted);
        }
    }

    private static class zzd extends com.google.android.gms.nearby.messages.internal.zzg.zza {
        private final SubscribeCallback zzaXx;

        private zzd(SubscribeCallback subscribeCallback) {
            this.zzaXx = subscribeCallback;
        }

        private static zzd zza(SubscribeCallback subscribeCallback) {
            return subscribeCallback == null ? null : new zzd(subscribeCallback);
        }

        public void onExpired() {
            this.zzaXx.onExpired();
        }
    }

    zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions) {
        super(context, looper, 62, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzTz = com_google_android_gms_common_internal_zzf.zzqd();
        if (messagesOptions != null) {
            this.zzaXo = messagesOptions.zzaWI;
            this.zzaXp = messagesOptions.zzaWJ;
            this.zzaXq = messagesOptions.zzaWK;
            return;
        }
        this.zzaXo = null;
        this.zzaXp = false;
        this.zzaXq = false;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdz(iBinder);
    }

    void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener) throws RemoteException {
        zzqr();
        ((zzd) zzqs()).zza(new UnsubscribeRequest(this.zzaXs.zzG(messageListener), zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), null, 0, this.zzaXo, this.zzTz, this.zzaXq));
        this.zzaXs.zzH(messageListener);
    }

    void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener, SubscribeOptions subscribeOptions, byte[] bArr) throws RemoteException {
        zzqr();
        ((zzd) zzqs()).zza(new SubscribeRequest(this.zzaXs.zzG(messageListener), subscribeOptions.getStrategy(), zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), subscribeOptions.getFilter(), null, 0, this.zzaXo, this.zzTz, bArr, this.zzaXp, zzd.zza(subscribeOptions.getCallback()), this.zzaXq));
    }

    void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, StatusCallback statusCallback) throws RemoteException {
        zzqr();
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), this.zzaXr.zzG(statusCallback), this.zzaXo);
        registerStatusCallbackRequest.zzaXK = true;
        ((zzd) zzqs()).zza(registerStatusCallbackRequest);
    }

    void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, MessageWrapper messageWrapper) throws RemoteException {
        zzqr();
        ((zzd) zzqs()).zza(new UnpublishRequest(messageWrapper, zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), this.zzaXo, this.zzTz, this.zzaXq));
    }

    void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, MessageWrapper messageWrapper, PublishOptions publishOptions) throws RemoteException {
        zzqr();
        ((zzd) zzqs()).zza(new PublishRequest(messageWrapper, publishOptions.getStrategy(), zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), this.zzaXo, this.zzTz, this.zzaXp, zzb.zza(publishOptions.getCallback()), this.zzaXq));
    }

    void zzb(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, StatusCallback statusCallback) throws RemoteException {
        zzqr();
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), this.zzaXr.zzG(statusCallback), this.zzaXo);
        registerStatusCallbackRequest.zzaXK = false;
        ((zzd) zzqs()).zza(registerStatusCallbackRequest);
        this.zzaXr.zzH(statusCallback);
    }

    protected zzd zzdz(IBinder iBinder) {
        return com.google.android.gms.nearby.messages.internal.zzd.zza.zzdv(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    void zzj(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzqr();
        ((zzd) zzqs()).zza(new GetPermissionStatusRequest(zzm.zzk(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), this.zzaXo));
    }
}
