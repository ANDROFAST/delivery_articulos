package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        private static class zza implements zzb {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(MessageWrapper messageWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (messageWrapper != null) {
                        obtain.writeInt(1);
                        messageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(MessageWrapper messageWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (messageWrapper != null) {
                        obtain.writeInt(1);
                        messageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IMessageListener");
        }

        public static zzb zzdt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new zza(iBinder) : (zzb) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MessageWrapper messageWrapper = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (data.readInt() != 0) {
                        messageWrapper = MessageWrapper.CREATOR.zzfZ(data);
                    }
                    zza(messageWrapper);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (data.readInt() != 0) {
                        messageWrapper = MessageWrapper.CREATOR.zzfZ(data);
                    }
                    zzb(messageWrapper);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(MessageWrapper messageWrapper) throws RemoteException;

    void zzb(MessageWrapper messageWrapper) throws RemoteException;
}
