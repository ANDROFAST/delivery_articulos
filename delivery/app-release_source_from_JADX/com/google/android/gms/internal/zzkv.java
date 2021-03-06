package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

public interface zzkv extends IInterface {

    public static abstract class zza extends Binder implements zzkv {

        private static class zza implements zzkv {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public Intent zza(GetConsentIntentRequest getConsentIntentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    if (getConsentIntentRequest != null) {
                        obtain.writeInt(1);
                        getConsentIntentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzkv zzau(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkv)) ? new zza(iBinder) : (zzkv) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    Intent zza = zza(data.readInt() != 0 ? (GetConsentIntentRequest) GetConsentIntentRequest.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Intent zza(GetConsentIntentRequest getConsentIntentRequest) throws RemoteException;
}
