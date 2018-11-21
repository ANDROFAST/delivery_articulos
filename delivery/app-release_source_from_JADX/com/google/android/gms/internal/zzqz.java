package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzqz extends zzj<zzrc> {
    private final long zzaBC = ((long) hashCode());

    private static final class zzf implements StartAdvertisingResult {
        private final Status zzTA;
        private final String zzaWp;

        zzf(Status status, String str) {
            this.zzTA = status;
            this.zzaWp = str;
        }

        public String getLocalEndpointName() {
            return this.zzaWp;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static class zzb extends zzqy {
        private final zzmn<MessageListener> zzaWe;

        zzb(zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzaWe = com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzaWe.zza(new com.google.android.gms.internal.zzmn.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzaWh;

                public void zza(MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                public void zzpb() {
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }

        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzaWe.zza(new com.google.android.gms.internal.zzmn.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzaWh;

                public void zza(MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                public void zzpb() {
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }
    }

    private static class zzc extends zzqy {
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzaWi;

        zzc(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            this.zzaWi = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
        }

        public void zziO(int i) throws RemoteException {
            this.zzaWi.zzr(new Status(i));
        }
    }

    private static final class zze extends zzqy {
        private final zzmn<ConnectionRequestListener> zzaWl;
        private final com.google.android.gms.internal.zzlx.zzb<StartAdvertisingResult> zzakL;

        zze(com.google.android.gms.internal.zzlx.zzb<StartAdvertisingResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, zzmn<ConnectionRequestListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzakL = (com.google.android.gms.internal.zzlx.zzb) zzx.zzy(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzaWl = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
            final String str = remoteEndpointId;
            final String str2 = remoteDeviceId;
            final String str3 = remoteEndpointName;
            final byte[] bArr = payload;
            this.zzaWl.zza(new com.google.android.gms.internal.zzmn.zzb<ConnectionRequestListener>(this) {
                final /* synthetic */ zze zzaWo;

                public void zza(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str, str2, str3, bArr);
                }

                public void zzpb() {
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((ConnectionRequestListener) obj);
                }
            });
        }

        public void zzo(int i, String str) throws RemoteException {
            this.zzakL.zzr(new zzf(new Status(i), str));
        }
    }

    private static final class zzg extends zzqy {
        private final zzmn<EndpointDiscoveryListener> zzaWl;
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzakL;

        zzg(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, zzmn<EndpointDiscoveryListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzakL = (com.google.android.gms.internal.zzlx.zzb) zzx.zzy(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
            this.zzaWl = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
            final String str = endpointId;
            final String str2 = deviceId;
            final String str3 = serviceId;
            final String str4 = name;
            this.zzaWl.zza(new com.google.android.gms.internal.zzmn.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzg zzaWt;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str, str2, str3, str4);
                }

                public void zzpb() {
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }
            });
        }

        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzaWl.zza(new com.google.android.gms.internal.zzmn.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzg zzaWt;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                public void zzpb() {
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }
            });
        }

        public void zziK(int i) throws RemoteException {
            this.zzakL.zzr(new Status(i));
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzakL;

        public zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzakL = (com.google.android.gms.internal.zzlx.zzb) zzx.zzy(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        }

        public void zziN(int i) throws RemoteException {
            this.zzakL.zzr(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final zzmn<ConnectionResponseCallback> zzaWj;
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzakL;

        public zzd(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, zzmn<ConnectionResponseCallback> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzakL = (com.google.android.gms.internal.zzlx.zzb) zzx.zzy(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
            this.zzaWj = (zzmn) zzx.zzy(com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzaWj.zza(new com.google.android.gms.internal.zzmn.zzb<ConnectionResponseCallback>(this) {
                final /* synthetic */ zzd zzaWk;

                public void zza(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public void zzpb() {
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((ConnectionResponseCallback) obj);
                }
            });
        }

        public void zziM(int i) throws RemoteException {
            this.zzakL.zzr(new Status(i));
        }
    }

    public zzqz(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzrc) zzqs()).zzF(this.zzaBC);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public String zzCs() {
        try {
            return ((zzrc) zzqs()).zzU(this.zzaBC);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzCt() {
        try {
            return ((zzrc) zzqs()).zzCt();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzCu() {
        try {
            ((zzrc) zzqs()).zzR(this.zzaBC);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzCv() {
        try {
            ((zzrc) zzqs()).zzT(this.zzaBC);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdq(iBinder);
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, String str, long j, zzmn<EndpointDiscoveryListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) throws RemoteException {
        ((zzrc) zzqs()).zza(new zzg(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzaBC);
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<StartAdvertisingResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, zzmn<ConnectionRequestListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) throws RemoteException {
        ((zzrc) zzqs()).zza(new zze(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzaBC);
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, zzmn<ConnectionResponseCallback> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzrc) zzqs()).zza(new zzd(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzaBC);
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, zzmn<MessageListener> com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzrc) zzqs()).zza(new zza(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzmn_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzaBC);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzrc) zzqs()).zza(strArr, bArr, this.zzaBC);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzrc) zzqs()).zzb(strArr, bArr, this.zzaBC);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected zzrc zzdq(IBinder iBinder) {
        return com.google.android.gms.internal.zzrc.zza.zzds(iBinder);
    }

    public void zzeL(String str) {
        try {
            ((zzrc) zzqs()).zzh(str, this.zzaBC);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzeM(String str) {
        try {
            ((zzrc) zzqs()).zzi(str, this.zzaBC);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected String zzgh() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzrc) zzqs()).zza(new zzc(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), str, this.zzaBC);
    }
}
