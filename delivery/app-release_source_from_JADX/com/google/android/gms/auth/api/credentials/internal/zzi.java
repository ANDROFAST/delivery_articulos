package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public interface zzi extends IInterface {

    public static abstract class zza extends Binder implements zzi {

        private static class zza implements zzi {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_credentials_internal_zzh != null ? com_google_android_gms_auth_api_credentials_internal_zzh.asBinder() : null);
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh, CredentialRequest credentialRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_credentials_internal_zzh != null ? com_google_android_gms_auth_api_credentials_internal_zzh.asBinder() : null);
                    if (credentialRequest != null) {
                        obtain.writeInt(1);
                        credentialRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh, DeleteRequest deleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_credentials_internal_zzh != null ? com_google_android_gms_auth_api_credentials_internal_zzh.asBinder() : null);
                    if (deleteRequest != null) {
                        obtain.writeInt(1);
                        deleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh, SaveRequest saveRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_credentials_internal_zzh != null ? com_google_android_gms_auth_api_credentials_internal_zzh.asBinder() : null);
                    if (saveRequest != null) {
                        obtain.writeInt(1);
                        saveRequest.writeToParcel(obtain, 0);
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

        public static zzi zzax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new zza(iBinder) : (zzi) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DeleteRequest deleteRequest = null;
            zzh zzaw;
            switch (code) {
                case 1:
                    CredentialRequest credentialRequest;
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzaw = com.google.android.gms.auth.api.credentials.internal.zzh.zza.zzaw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        credentialRequest = (CredentialRequest) CredentialRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaw, credentialRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    SaveRequest saveRequest;
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzaw = com.google.android.gms.auth.api.credentials.internal.zzh.zza.zzaw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        saveRequest = (SaveRequest) SaveRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaw, saveRequest);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zzaw = com.google.android.gms.auth.api.credentials.internal.zzh.zza.zzaw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        deleteRequest = (DeleteRequest) DeleteRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaw, deleteRequest);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    zza(com.google.android.gms.auth.api.credentials.internal.zzh.zza.zzaw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException;

    void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh, CredentialRequest credentialRequest) throws RemoteException;

    void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh, DeleteRequest deleteRequest) throws RemoteException;

    void zza(zzh com_google_android_gms_auth_api_credentials_internal_zzh, SaveRequest saveRequest) throws RemoteException;
}
