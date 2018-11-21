package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzlr extends IInterface {

    public static abstract class zza extends Binder implements zzlr {

        private static class zza implements zzlr {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.zzoo.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.zzoo.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzlq com_google_android_gms_internal_zzlq) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    if (com_google_android_gms_internal_zzlq != null) {
                        iBinder = com_google_android_gms_internal_zzlq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoo.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzlq com_google_android_gms_internal_zzlq, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    if (com_google_android_gms_internal_zzlq != null) {
                        iBinder = com_google_android_gms_internal_zzlq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zzoo.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzlq com_google_android_gms_internal_zzlq, zzls com_google_android_gms_internal_zzls, String str, String str2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzlq != null ? com_google_android_gms_internal_zzlq.asBinder() : null);
                    if (com_google_android_gms_internal_zzls != null) {
                        iBinder = com_google_android_gms_internal_zzls.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoo.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzlr zzaI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlr)) ? new zza(iBinder) : (zzlr) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    destroy();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    disconnect();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzlq.zza.zzaH(data.readStrongBinder()), com.google.android.gms.internal.zzls.zza.zzaJ(data.readStrongBinder()), data.readString(), data.readString());
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzlq.zza.zzaH(data.readStrongBinder()), data.readInt());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzlq.zza.zzaH(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void destroy() throws RemoteException;

    void disconnect() throws RemoteException;

    void zza(zzlq com_google_android_gms_internal_zzlq) throws RemoteException;

    void zza(zzlq com_google_android_gms_internal_zzlq, int i) throws RemoteException;

    void zza(zzlq com_google_android_gms_internal_zzlq, zzls com_google_android_gms_internal_zzls, String str, String str2) throws RemoteException;
}
