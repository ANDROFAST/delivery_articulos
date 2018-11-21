package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public interface zzax extends IInterface {

    public static abstract class zza extends Binder implements zzax {

        private static class zza implements zzax {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zzb(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IFileDescriptorReceiver");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzax zzen(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IFileDescriptorReceiver");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzax)) ? new zza(iBinder) : (zzax) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IFileDescriptorReceiver");
                    zzb(data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IFileDescriptorReceiver");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzb(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;
}
