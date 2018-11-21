package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

public interface zzba extends IInterface {

    public static abstract class zza extends Binder implements zzba {

        private static class zza implements zzba {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void onConnectedNodes(List<NodeParcelable> connectedNodes) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    obtain.writeTypedList(connectedNodes);
                    this.zzoo.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (amsEntityUpdateParcelable != null) {
                        obtain.writeInt(1);
                        amsEntityUpdateParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (capabilityInfoParcelable != null) {
                        obtain.writeInt(1);
                        capabilityInfoParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ChannelEventParcelable channelEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (channelEventParcelable != null) {
                        obtain.writeInt(1);
                        channelEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (largeAssetQueueStateChangeParcelable != null) {
                        obtain.writeInt(1);
                        largeAssetQueueStateChangeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (largeAssetSyncRequestPayload != null) {
                        obtain.writeInt(1);
                        largeAssetSyncRequestPayload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_wearable_internal_zzay != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzay.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MessageEventParcelable messageEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (messageEventParcelable != null) {
                        obtain.writeInt(1);
                        messageEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzax com_google_android_gms_wearable_internal_zzax, String str, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (com_google_android_gms_wearable_internal_zzax != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzax.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoo.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzag(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static zzba zzeq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzba)) ? new zza(iBinder) : (zzba) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            LargeAssetSyncRequestPayload largeAssetSyncRequestPayload = null;
            NodeParcelable nodeParcelable;
            switch (code) {
                case 1:
                    DataHolder zzak;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        zzak = DataHolder.CREATOR.zzak(data);
                    }
                    zzag(zzak);
                    return true;
                case 2:
                    MessageEventParcelable messageEventParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        messageEventParcelable = (MessageEventParcelable) MessageEventParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(messageEventParcelable);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(nodeParcelable);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(data);
                    }
                    zzb(nodeParcelable);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    onConnectedNodes(data.createTypedArrayList(NodeParcelable.CREATOR));
                    return true;
                case 6:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(ancsNotificationParcelable);
                    return true;
                case 7:
                    ChannelEventParcelable channelEventParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        channelEventParcelable = (ChannelEventParcelable) ChannelEventParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(channelEventParcelable);
                    return true;
                case 8:
                    CapabilityInfoParcelable capabilityInfoParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        capabilityInfoParcelable = (CapabilityInfoParcelable) CapabilityInfoParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(capabilityInfoParcelable);
                    return true;
                case 9:
                    AmsEntityUpdateParcelable amsEntityUpdateParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) AmsEntityUpdateParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(amsEntityUpdateParcelable);
                    return true;
                case 10:
                    LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        largeAssetQueueStateChangeParcelable = (LargeAssetQueueStateChangeParcelable) LargeAssetQueueStateChangeParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(largeAssetQueueStateChangeParcelable);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    zza(com.google.android.gms.wearable.internal.zzax.zza.zzen(data.readStrongBinder()), data.readString(), data.readInt());
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        largeAssetSyncRequestPayload = (LargeAssetSyncRequestPayload) LargeAssetSyncRequestPayload.CREATOR.createFromParcel(data);
                    }
                    zza(largeAssetSyncRequestPayload, com.google.android.gms.wearable.internal.zzay.zza.zzeo(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onConnectedNodes(List<NodeParcelable> list) throws RemoteException;

    void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException;

    void zza(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException;

    void zza(ChannelEventParcelable channelEventParcelable) throws RemoteException;

    void zza(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable) throws RemoteException;

    void zza(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) throws RemoteException;

    void zza(MessageEventParcelable messageEventParcelable) throws RemoteException;

    void zza(NodeParcelable nodeParcelable) throws RemoteException;

    void zza(zzax com_google_android_gms_wearable_internal_zzax, String str, int i) throws RemoteException;

    void zzag(DataHolder dataHolder) throws RemoteException;

    void zzb(NodeParcelable nodeParcelable) throws RemoteException;
}
