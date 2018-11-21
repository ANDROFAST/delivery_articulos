package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface zzpo extends IInterface {

    public static abstract class zza extends Binder implements zzpo {

        private static class zza implements zzpo {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(SessionStopResult sessionStopResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    if (sessionStopResult != null) {
                        obtain.writeInt(1);
                        sessionStopResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionStopCallback");
        }

        public static zzpo zzbQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpo)) ? new zza(iBinder) : (zzpo) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    zza(data.readInt() != 0 ? (SessionStopResult) SessionStopResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(SessionStopResult sessionStopResult) throws RemoteException;
}
