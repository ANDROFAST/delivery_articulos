package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzrs extends IInterface {

    public static abstract class zza extends Binder implements zzrs {

        private static class zza implements zzrs {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzrr com_google_android_gms_internal_zzrr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrr != null ? com_google_android_gms_internal_zzrr.asBinder() : null);
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzrr com_google_android_gms_internal_zzrr, String str, int[] iArr, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrr != null ? com_google_android_gms_internal_zzrr.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzrr com_google_android_gms_internal_zzrr, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzrr != null ? com_google_android_gms_internal_zzrr.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzrs zzdQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrs)) ? new zza(iBinder) : (zzrs) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzrr.zza.zzdP(data.readStrongBinder()), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzrr.zza.zzdP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzrr.zza.zzdP(data.readStrongBinder()), data.readString(), data.createIntArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzrr com_google_android_gms_internal_zzrr) throws RemoteException;

    void zza(zzrr com_google_android_gms_internal_zzrr, String str, int[] iArr, int i, String str2) throws RemoteException;

    void zza(zzrr com_google_android_gms_internal_zzrr, byte[] bArr) throws RemoteException;
}
