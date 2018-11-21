package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;

public interface zzs extends IInterface {

    public static abstract class zza extends Binder implements zzs {

        private static class zza implements zzs {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getMediationAdapterClassName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isReady() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setManualImpressionsEnabled(boolean manualImpressionsEnabled) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (manualImpressionsEnabled) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzn com_google_android_gms_ads_internal_client_zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzn != null ? com_google_android_gms_ads_internal_client_zzn.asBinder() : null);
                    this.zzoo.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzo com_google_android_gms_ads_internal_client_zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzo != null ? com_google_android_gms_ads_internal_client_zzo.asBinder() : null);
                    this.zzoo.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzu com_google_android_gms_ads_internal_client_zzu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzu != null ? com_google_android_gms_ads_internal_client_zzu.asBinder() : null);
                    this.zzoo.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzv com_google_android_gms_ads_internal_client_zzv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzv != null ? com_google_android_gms_ads_internal_client_zzv.asBinder() : null);
                    this.zzoo.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcl com_google_android_gms_internal_zzcl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzcl != null ? com_google_android_gms_internal_zzcl.asBinder() : null);
                    this.zzoo.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzgc com_google_android_gms_internal_zzgc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzgc != null ? com_google_android_gms_internal_zzgc.asBinder() : null);
                    this.zzoo.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzgg com_google_android_gms_internal_zzgg, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzgg != null ? com_google_android_gms_internal_zzgg.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzaO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(obtain2.readStrongBinder());
                    return zzbs;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AdSizeParcel zzaP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    AdSizeParcel zzc = obtain2.readInt() != 0 ? AdSizeParcel.CREATOR.zzc(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzc;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzoo.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static zzs zzk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new zza(iBinder) : (zzs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AdSizeParcel adSizeParcel = null;
            int i = 0;
            boolean isReady;
            switch (code) {
                case 1:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zzd zzaO = zzaO();
                    reply.writeNoException();
                    if (zzaO != null) {
                        asBinder = zzaO.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    destroy();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    isReady = isReady();
                    reply.writeNoException();
                    reply.writeInt(isReady ? 1 : 0);
                    return true;
                case 4:
                    AdRequestParcel zzb;
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (data.readInt() != 0) {
                        zzb = AdRequestParcel.CREATOR.zzb(data);
                    }
                    isReady = zzb(zzb);
                    reply.writeNoException();
                    if (isReady) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    pause();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    resume();
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzo.zza.zzg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzu.zza.zzm(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    stopLoading();
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zzaR();
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    adSizeParcel = zzaP();
                    reply.writeNoException();
                    if (adSizeParcel != null) {
                        reply.writeInt(1);
                        adSizeParcel.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (data.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.zzc(data);
                    }
                    zza(adSizeParcel);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.internal.zzgc.zza.zzP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.internal.zzgg.zza.zzT(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    reply.writeNoException();
                    reply.writeString(mediationAdapterClassName);
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.internal.zzcl.zza.zzs(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzn.zza.zzf(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzv.zza.zzn(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 22:
                    boolean z;
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setManualImpressionsEnabled(z);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    isReady = isLoading();
                    reply.writeNoException();
                    if (isReady) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void destroy() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(AdSizeParcel adSizeParcel) throws RemoteException;

    void zza(zzn com_google_android_gms_ads_internal_client_zzn) throws RemoteException;

    void zza(zzo com_google_android_gms_ads_internal_client_zzo) throws RemoteException;

    void zza(zzu com_google_android_gms_ads_internal_client_zzu) throws RemoteException;

    void zza(zzv com_google_android_gms_ads_internal_client_zzv) throws RemoteException;

    void zza(zzcl com_google_android_gms_internal_zzcl) throws RemoteException;

    void zza(zzgc com_google_android_gms_internal_zzgc) throws RemoteException;

    void zza(zzgg com_google_android_gms_internal_zzgg, String str) throws RemoteException;

    zzd zzaO() throws RemoteException;

    AdSizeParcel zzaP() throws RemoteException;

    void zzaR() throws RemoteException;

    boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException;
}
