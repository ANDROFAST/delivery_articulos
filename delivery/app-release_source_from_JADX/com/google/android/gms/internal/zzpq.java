package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SyncInfoResult;

public interface zzpq extends IInterface {

    public static abstract class zza extends Binder implements zzpq {

        private static class zza implements zzpq {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(SyncInfoResult syncInfoResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISyncInfoCallback");
                    if (syncInfoResult != null) {
                        obtain.writeInt(1);
                        syncInfoResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzpq zzbS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpq)) ? new zza(iBinder) : (zzpq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
                    zza(data.readInt() != 0 ? (SyncInfoResult) SyncInfoResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISyncInfoCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(SyncInfoResult syncInfoResult) throws RemoteException;
}
