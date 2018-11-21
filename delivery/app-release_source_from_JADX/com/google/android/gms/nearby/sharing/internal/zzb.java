package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

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

            public List<SharedContent> zzCT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    List<SharedContent> createTypedArrayList = obtain2.createTypedArrayList(SharedContent.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzb zzdB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new zza(iBinder) : (zzb) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    List zzCT = zzCT();
                    reply.writeNoException();
                    reply.writeTypedList(zzCT);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    List<SharedContent> zzCT() throws RemoteException;
}
