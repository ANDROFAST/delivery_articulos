package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public interface zzqt extends IInterface {

    public static abstract class zza extends Binder implements zzqt {

        private static class zza implements zzqt {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void onDisconnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    this.zzoo.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(int errorCode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeInt(errorCode);
                    this.zzoo.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzCl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    this.zzoo.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Device device, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzeI(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeString(str);
                    this.zzoo.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzeJ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    obtain.writeString(str);
                    this.zzoo.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzqt zzdl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqt)) ? new zza(iBinder) : (zzqt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zza(data.readInt() != 0 ? (Device) Device.CREATOR.createFromParcel(data) : null, data.createByteArray());
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    onDisconnected();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    onError(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzeI(data.readString());
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzCl();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    zzeJ(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onDisconnected() throws RemoteException;

    void onError(int i) throws RemoteException;

    void zzCl() throws RemoteException;

    void zza(Device device, byte[] bArr) throws RemoteException;

    void zzeI(String str) throws RemoteException;

    void zzeJ(String str) throws RemoteException;
}
