package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public interface zzay extends IInterface {

    public static abstract class zza extends Binder implements zzay {

        private static class zza implements zzay {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(ParcelFileDescriptor parcelFileDescriptor, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzli(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
                    obtain.writeInt(i);
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzay zzeo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzay)) ? new zza(iBinder) : (zzay) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
                    zzli(data.readInt());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
                    zza(data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null, data.readLong());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ParcelFileDescriptor parcelFileDescriptor, long j) throws RemoteException;

    void zzli(int i) throws RemoteException;
}
