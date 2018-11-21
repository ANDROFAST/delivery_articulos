package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;

public interface zzq extends IInterface {

    public static abstract class zza extends Binder implements zzq {

        private static class zza implements zzq {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcx com_google_android_gms_internal_zzcx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzcx != null ? com_google_android_gms_internal_zzcx.asBinder() : null);
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcy com_google_android_gms_internal_zzcy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzcy != null ? com_google_android_gms_internal_zzcy.asBinder() : null);
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzda com_google_android_gms_internal_zzda, zzcz com_google_android_gms_internal_zzcz) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzda != null ? com_google_android_gms_internal_zzda.asBinder() : null);
                    if (com_google_android_gms_internal_zzcz != null) {
                        iBinder = com_google_android_gms_internal_zzcz.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzo com_google_android_gms_ads_internal_client_zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzo != null ? com_google_android_gms_ads_internal_client_zzo.asBinder() : null);
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzv com_google_android_gms_ads_internal_client_zzv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzv != null ? com_google_android_gms_ads_internal_client_zzv.asBinder() : null);
                    this.zzoo.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzp zzbm() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzp zzh = com.google.android.gms.ads.internal.client.zzp.zza.zzh(obtain2.readStrongBinder());
                    return zzh;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static zzq zzi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzq)) ? new zza(iBinder) : (zzq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            NativeAdOptionsParcel nativeAdOptionsParcel = null;
            switch (code) {
                case 1:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzp zzbm = zzbm();
                    reply.writeNoException();
                    if (zzbm != null) {
                        asBinder = zzbm.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(com.google.android.gms.ads.internal.client.zzo.zza.zzg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(com.google.android.gms.internal.zzcx.zza.zzz(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(com.google.android.gms.internal.zzcy.zza.zzA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(data.readString(), com.google.android.gms.internal.zzda.zza.zzC(data.readStrongBinder()), com.google.android.gms.internal.zzcz.zza.zzB(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (data.readInt() != 0) {
                        nativeAdOptionsParcel = NativeAdOptionsParcel.CREATOR.zze(data);
                    }
                    zza(nativeAdOptionsParcel);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(com.google.android.gms.ads.internal.client.zzv.zza.zzn(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException;

    void zza(zzcx com_google_android_gms_internal_zzcx) throws RemoteException;

    void zza(zzcy com_google_android_gms_internal_zzcy) throws RemoteException;

    void zza(String str, zzda com_google_android_gms_internal_zzda, zzcz com_google_android_gms_internal_zzcz) throws RemoteException;

    void zzb(zzo com_google_android_gms_ads_internal_client_zzo) throws RemoteException;

    void zzb(zzv com_google_android_gms_ads_internal_client_zzv) throws RemoteException;

    zzp zzbm() throws RemoteException;
}
