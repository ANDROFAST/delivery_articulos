package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.games.quest.Quests;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        private static class zza implements zzg {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzf com_google_android_gms_auth_api_signin_internal_zzf, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzf != null ? com_google_android_gms_auth_api_signin_internal_zzf.asBinder() : null);
                    if (googleSignInOptions != null) {
                        obtain.writeInt(1);
                        googleSignInOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(Quests.SELECT_COMPLETED_UNCLAIMED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_auth_api_signin_internal_zzf, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzf != null ? com_google_android_gms_auth_api_signin_internal_zzf.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
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

            public void zza(zzf com_google_android_gms_auth_api_signin_internal_zzf, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzf != null ? com_google_android_gms_auth_api_signin_internal_zzf.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (signInAccount != null) {
                        obtain.writeInt(1);
                        signInAccount.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_auth_api_signin_internal_zzf, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzf != null ? com_google_android_gms_auth_api_signin_internal_zzf.asBinder() : null);
                    if (googleSignInOptions != null) {
                        obtain.writeInt(1);
                        googleSignInOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzf com_google_android_gms_auth_api_signin_internal_zzf, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzf != null ? com_google_android_gms_auth_api_signin_internal_zzf.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
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

            public void zzc(zzf com_google_android_gms_auth_api_signin_internal_zzf, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zzf != null ? com_google_android_gms_auth_api_signin_internal_zzf.asBinder() : null);
                    if (googleSignInOptions != null) {
                        obtain.writeInt(1);
                        googleSignInOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(Quests.SELECT_RECENTLY_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzg zzaD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new zza(iBinder) : (zzg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(com.google.android.gms.auth.api.signin.internal.zzf.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(com.google.android.gms.auth.api.signin.internal.zzf.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(com.google.android.gms.auth.api.signin.internal.zzf.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (SignInAccount) SignInAccount.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    return true;
                case Quests.SELECT_COMPLETED_UNCLAIMED /*101*/:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(com.google.android.gms.auth.api.signin.internal.zzf.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 102:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(com.google.android.gms.auth.api.signin.internal.zzf.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Quests.SELECT_RECENTLY_FAILED /*103*/:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzc(com.google.android.gms.auth.api.signin.internal.zzf.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzf com_google_android_gms_auth_api_signin_internal_zzf, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void zza(zzf com_google_android_gms_auth_api_signin_internal_zzf, SignInConfiguration signInConfiguration) throws RemoteException;

    void zza(zzf com_google_android_gms_auth_api_signin_internal_zzf, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) throws RemoteException;

    void zzb(zzf com_google_android_gms_auth_api_signin_internal_zzf, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void zzb(zzf com_google_android_gms_auth_api_signin_internal_zzf, SignInConfiguration signInConfiguration) throws RemoteException;

    void zzc(zzf com_google_android_gms_auth_api_signin_internal_zzf, GoogleSignInOptions googleSignInOptions) throws RemoteException;
}
