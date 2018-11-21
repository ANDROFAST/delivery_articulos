package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzrx extends IInterface {

    public static abstract class zza extends Binder implements zzrx {

        private static class zza implements zzrx {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzrw com_google_android_gms_internal_zzrw, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrw != null ? com_google_android_gms_internal_zzrw.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzrw com_google_android_gms_internal_zzrw, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrw != null ? com_google_android_gms_internal_zzrw.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzrx zzdT(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrx)) ? new zza(iBinder) : (zzrx) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
                    zza(com.google.android.gms.internal.zzrw.zza.zzdS(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
                    zzb(com.google.android.gms.internal.zzrw.zza.zzdS(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.search.internal.ISearchAuthService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzrw com_google_android_gms_internal_zzrw, String str, String str2) throws RemoteException;

    void zzb(zzrw com_google_android_gms_internal_zzrw, String str, String str2) throws RemoteException;
}
