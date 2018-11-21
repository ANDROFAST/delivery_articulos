package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        private static class zza implements zzd {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(GetPermissionStatusRequest getPermissionStatusRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (getPermissionStatusRequest != null) {
                        obtain.writeInt(1);
                        getPermissionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PublishRequest publishRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (publishRequest != null) {
                        obtain.writeInt(1);
                        publishRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (registerStatusCallbackRequest != null) {
                        obtain.writeInt(1);
                        registerStatusCallbackRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SubscribeRequest subscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnpublishRequest unpublishRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (unpublishRequest != null) {
                        obtain.writeInt(1);
                        unpublishRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (unsubscribeRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzeN(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    obtain.writeString(str);
                    this.zzoo.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdv(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            RegisterStatusCallbackRequest registerStatusCallbackRequest = null;
            switch (code) {
                case 1:
                    PublishRequest publishRequest;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        publishRequest = (PublishRequest) PublishRequest.CREATOR.createFromParcel(data);
                    }
                    zza(publishRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    UnpublishRequest unpublishRequest;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        unpublishRequest = (UnpublishRequest) UnpublishRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unpublishRequest);
                    reply.writeNoException();
                    return true;
                case 3:
                    SubscribeRequest subscribeRequest;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        subscribeRequest = (SubscribeRequest) SubscribeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(subscribeRequest);
                    reply.writeNoException();
                    return true;
                case 4:
                    UnsubscribeRequest unsubscribeRequest;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        unsubscribeRequest = (UnsubscribeRequest) UnsubscribeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unsubscribeRequest);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    zzeN(data.readString());
                    reply.writeNoException();
                    return true;
                case 7:
                    GetPermissionStatusRequest getPermissionStatusRequest;
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        getPermissionStatusRequest = (GetPermissionStatusRequest) GetPermissionStatusRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getPermissionStatusRequest);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (data.readInt() != 0) {
                        registerStatusCallbackRequest = (RegisterStatusCallbackRequest) RegisterStatusCallbackRequest.CREATOR.createFromParcel(data);
                    }
                    zza(registerStatusCallbackRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(GetPermissionStatusRequest getPermissionStatusRequest) throws RemoteException;

    void zza(PublishRequest publishRequest) throws RemoteException;

    void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest) throws RemoteException;

    void zza(SubscribeRequest subscribeRequest) throws RemoteException;

    void zza(UnpublishRequest unpublishRequest) throws RemoteException;

    void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException;

    void zzeN(String str) throws RemoteException;
}
