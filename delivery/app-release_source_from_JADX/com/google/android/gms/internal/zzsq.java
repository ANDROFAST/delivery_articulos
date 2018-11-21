package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface zzsq extends IInterface {

    public static abstract class zza extends Binder implements zzsq {

        private static class zza implements zzsq {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public zzsn zza(zzd com_google_android_gms_dynamic_zzd, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzso com_google_android_gms_internal_zzso) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzc != null ? com_google_android_gms_dynamic_zzc.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzso != null) {
                        iBinder = com_google_android_gms_internal_zzso.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzsn zzee = com.google.android.gms.internal.zzsn.zza.zzee(obtain2.readStrongBinder());
                    return zzee;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzsq zzeh(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzsq)) ? new zza(iBinder) : (zzsq) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzsn zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()), com.google.android.gms.dynamic.zzc.zza.zzbr(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzso.zza.zzef(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzsn zza(zzd com_google_android_gms_dynamic_zzd, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzso com_google_android_gms_internal_zzso) throws RemoteException;
}
