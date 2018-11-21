package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ReadRawResult;

public interface zzpl extends IInterface {

    public static abstract class zza extends Binder implements zzpl {

        private static class zza implements zzpl {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(ReadRawResult readRawResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IReadRawCallback");
                    if (readRawResult != null) {
                        obtain.writeInt(1);
                        readRawResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzpl zzbN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IReadRawCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpl)) ? new zza(iBinder) : (zzpl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IReadRawCallback");
                    zza(data.readInt() != 0 ? (ReadRawResult) ReadRawResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IReadRawCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ReadRawResult readRawResult) throws RemoteException;
}
