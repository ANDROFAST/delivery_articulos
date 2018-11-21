package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public interface zzkz extends IInterface {

    public static abstract class zza extends Binder implements zzkz {

        private static class zza implements zzkz {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzky com_google_android_gms_internal_zzky, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzky != null ? com_google_android_gms_internal_zzky.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        obtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(obtain, 0);
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

            public void zza(zzky com_google_android_gms_internal_zzky, ProxyRequest proxyRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzky != null ? com_google_android_gms_internal_zzky.asBinder() : null);
                    if (proxyRequest != null) {
                        obtain.writeInt(1);
                        proxyRequest.writeToParcel(obtain, 0);
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
        }

        public static zzkz zzaA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkz)) ? new zza(iBinder) : (zzkz) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ProxyGrpcRequest proxyGrpcRequest = null;
            zzky zzaz;
            switch (code) {
                case 1:
                    ProxyRequest proxyRequest;
                    data.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zzaz = com.google.android.gms.internal.zzky.zza.zzaz(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        proxyRequest = (ProxyRequest) ProxyRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaz, proxyRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zzaz = com.google.android.gms.internal.zzky.zza.zzaz(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        proxyGrpcRequest = (ProxyGrpcRequest) ProxyGrpcRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzaz, proxyGrpcRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzky com_google_android_gms_internal_zzky, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zzky com_google_android_gms_internal_zzky, ProxyRequest proxyRequest) throws RemoteException;
}
