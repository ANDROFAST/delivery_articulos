package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGamesClient extends IInterface {

    public static abstract class Stub extends Binder implements IGamesClient {

        private static class Proxy implements IGamesClient {
            private IBinder zzoo;

            Proxy(IBinder remote) {
                this.zzoo = remote;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public PopupLocationInfoParcelable zzvM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
                    this.zzoo.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                    PopupLocationInfoParcelable zzee = obtain2.readInt() != 0 ? PopupLocationInfoParcelable.CREATOR.zzee(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzee;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
        }

        public static IGamesClient zzbX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesClient)) ? new Proxy(iBinder) : (IGamesClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
                    PopupLocationInfoParcelable zzvM = zzvM();
                    reply.writeNoException();
                    if (zzvM != null) {
                        reply.writeInt(1);
                        zzvM.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesClient");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    PopupLocationInfoParcelable zzvM() throws RemoteException;
}
