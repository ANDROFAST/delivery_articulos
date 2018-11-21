package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;

public interface zzqg extends IInterface {

    public static abstract class zza extends Binder implements zzqg {

        private static class zza implements zzqg {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzqf com_google_android_gms_internal_zzqf, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqf != null ? com_google_android_gms_internal_zzqf.asBinder() : null);
                    if (userAddressRequest != null) {
                        obtain.writeInt(1);
                        userAddressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzqg zzcc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqg)) ? new zza(iBinder) : (zzqg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                    zza(com.google.android.gms.internal.zzqf.zza.zzcb(data.readStrongBinder()), data.readInt() != 0 ? (UserAddressRequest) UserAddressRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzqf com_google_android_gms_internal_zzqf, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException;
}
