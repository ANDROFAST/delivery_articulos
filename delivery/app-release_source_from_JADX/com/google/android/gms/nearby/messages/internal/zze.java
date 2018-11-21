package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        private static class zza implements zze {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void onExpired() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IPublishCallback");
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IPublishCallback");
        }

        public static zze zzdw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new zza(iBinder) : (zze) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
                    onExpired();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.messages.internal.IPublishCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onExpired() throws RemoteException;
}
