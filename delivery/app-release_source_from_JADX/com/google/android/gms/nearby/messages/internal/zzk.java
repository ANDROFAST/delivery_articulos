package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.PublishOptions.Builder;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public class zzk implements Messages {
    public static final zzc<zzj> zzTo = new zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzj, MessagesOptions> zzTp = new C07751();

    static class C07751 extends com.google.android.gms.common.api.Api.zza<zzj, MessagesOptions> {
        C07751() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzj zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, messagesOptions);
        }
    }

    static abstract class zza extends com.google.android.gms.internal.zzlx.zza<Status, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzk.zzTo, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient client) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zzj(this);
            }
        });
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message) {
        return publish(client, message, PublishOptions.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient client, final Message message, final PublishOptions options) {
        zzx.zzy(message);
        zzx.zzy(options);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zza(this, MessageWrapper.zza(message), options);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> publish(GoogleApiClient client, Message message, Strategy strategy) {
        return publish(client, message, new Builder().setStrategy(strategy).build());
    }

    public PendingResult<Status> registerStatusCallback(GoogleApiClient client, final StatusCallback statusCallback) {
        zzx.zzy(statusCallback);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zza((zzb) this, statusCallback);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener) {
        return subscribe(client, listener, SubscribeOptions.DEFAULT);
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).build());
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy, MessageFilter filter) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).setFilter(filter).build());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, final MessageListener listener, final SubscribeOptions options) {
        zzx.zzy(listener);
        zzx.zzy(options);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zza(this, listener, options, null);
            }
        });
    }

    public PendingResult<Status> unpublish(GoogleApiClient client, final Message message) {
        zzx.zzy(message);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zza((zzb) this, MessageWrapper.zza(message));
            }
        });
    }

    public PendingResult<Status> unregisterStatusCallback(GoogleApiClient client, final StatusCallback statusCallback) {
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zzb(this, statusCallback);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final MessageListener listener) {
        zzx.zzy(listener);
        return client.zzb(new zza(this, client) {
            final /* synthetic */ zzk zzaXz;

            protected void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzj.zza((zzb) this, listener);
            }
        });
    }
}
