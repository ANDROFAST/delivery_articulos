package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzew;

public interface zzt extends IInterface {

    public static abstract class zza extends Binder implements zzt {

        private static class zza implements zzt {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public IBinder zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzew != null) {
                        iBinder = com_google_android_gms_internal_zzew.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, int i, int i2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzew != null) {
                        iBinder = com_google_android_gms_internal_zzew.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzt zzl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzt)) ? new zza(iBinder) : (zzt) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AdSizeParcel adSizeParcel = null;
            zzd zzbs;
            IBinder zza;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.zzc(data);
                    }
                    zza = zza(zzbs, adSizeParcel, data.readString(), com.google.android.gms.internal.zzew.zza.zzE(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zza);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.zzc(data);
                    }
                    zza = zza(zzbs, adSizeParcel, data.readString(), com.google.android.gms.internal.zzew.zza.zzE(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zza);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IBinder zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, int i) throws RemoteException;

    IBinder zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, int i, int i2) throws RemoteException;
}
