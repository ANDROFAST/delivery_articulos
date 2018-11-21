package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new zzo();
    private final String mPath;
    final int mVersionCode;
    private final String zzTR;
    private final String zzblS;

    static final class zza implements GetInputStreamResult {
        private final Status zzTA;
        private final InputStream zzbnc;

        zza(Status status, InputStream inputStream) {
            this.zzTA = (Status) zzx.zzy(status);
            this.zzbnc = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzbnc;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            if (this.zzbnc != null) {
                try {
                    this.zzbnc.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzTA;
        private final OutputStream zzbnd;

        zzb(Status status, OutputStream outputStream) {
            this.zzTA = (Status) zzx.zzy(status);
            this.zzbnd = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzbnd;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            if (this.zzbnd != null) {
                try {
                    this.zzbnd.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.mVersionCode = versionCode;
        this.zzTR = (String) zzx.zzy(token);
        this.zzblS = (String) zzx.zzy(nodeId);
        this.mPath = (String) zzx.zzy(path);
    }

    private static zza<ChannelListener> zza(final String str, final IntentFilter[] intentFilterArr) {
        return new zza<ChannelListener>() {
            public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, zzmn<ChannelListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, channelListener, (zzmn) com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_ChannelApi_ChannelListener, str, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        return zzb.zza(client, zza(this.zzTR, new IntentFilter[]{zzcc.zzfY(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbmY;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzt(this, this.zzbmY.zzTR);
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> close(GoogleApiClient client, final int errorCode) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbmY;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzh(this, this.zzbmY.zzTR, errorCode);
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzTR.equals(channelImpl.zzTR) && zzw.equal(channelImpl.zzblS, this.zzblS) && zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zza(new zzi<GetInputStreamResult>(this, client) {
            final /* synthetic */ ChannelImpl zzbmY;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzu(this, this.zzbmY.zzTR);
            }

            public GetInputStreamResult zzbp(Status status) {
                return new zza(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbp(status);
            }
        });
    }

    public String getNodeId() {
        return this.zzblS;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zza(new zzi<GetOutputStreamResult>(this, client) {
            final /* synthetic */ ChannelImpl zzbmY;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzv(this, this.zzbmY.zzTR);
            }

            public GetOutputStreamResult zzbq(Status status) {
                return new zzb(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbq(status);
            }
        });
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzTR;
    }

    public int hashCode() {
        return this.zzTR.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient client, final Uri uri, final boolean append) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbmY;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, this.zzbmY.zzTR, uri, append);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzb(client, listener, this.zzTR));
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri, long startOffset, long length) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb(this.zzTR, (Object) "token is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        zzx.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        boolean z = length >= 0 || length == -1;
        zzx.zzb(z, "invalid length: %s", Long.valueOf(length));
        final Uri uri2 = uri;
        final long j = startOffset;
        final long j2 = length;
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ ChannelImpl zzbmY;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, this.zzbmY.zzTR, uri2, j, j2);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzTR + '\'' + ", nodeId='" + this.zzblS + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
