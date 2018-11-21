package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenRequest;
import com.google.android.gms.wallet.firstparty.GetInstrumentsRequest;
import com.google.android.gms.wallet.firstparty.InitializeBuyFlowRequest;

public interface zzsp extends IInterface {

    public static abstract class zza extends Binder implements zzsp {

        private static class zza implements zzsp {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zzH(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzI(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (createWalletObjectsRequest != null) {
                        obtain.writeInt(1);
                        createWalletObjectsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzsr com_google_android_gms_internal_zzsr) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzsr != null) {
                        iBinder = com_google_android_gms_internal_zzsr.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (getBuyFlowInitializationTokenRequest != null) {
                        obtain.writeInt(1);
                        getBuyFlowInitializationTokenRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetInstrumentsRequest getInstrumentsRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (getInstrumentsRequest != null) {
                        obtain.writeInt(1);
                        getInstrumentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (initializeBuyFlowRequest != null) {
                        obtain.writeInt(1);
                        initializeBuyFlowRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzss != null) {
                        iBinder = com_google_android_gms_internal_zzss.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzsp zzeg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzsp)) ? new zza(iBinder) : (zzsp) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (CreateWalletObjectsRequest) CreateWalletObjectsRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzsr.zza.zzei(data.readStrongBinder()));
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (GetInstrumentsRequest) GetInstrumentsRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzH(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzI(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzb(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (GetBuyFlowInitializationTokenRequest) GetBuyFlowInitializationTokenRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (InitializeBuyFlowRequest) InitializeBuyFlowRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzss.zza.zzej(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzH(Bundle bundle) throws RemoteException;

    void zzI(Bundle bundle) throws RemoteException;

    void zza(Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzsr com_google_android_gms_internal_zzsr) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(GetInstrumentsRequest getInstrumentsRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;

    void zzb(Bundle bundle, zzss com_google_android_gms_internal_zzss) throws RemoteException;
}
