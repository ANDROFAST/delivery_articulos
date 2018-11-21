package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzcn extends IInterface {

    public static abstract class zza extends Binder implements zzcn {

        private static class zza implements zzcn {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public double getScale() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    double readDouble = obtain2.readDouble();
                    return readDouble;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Uri getUri() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return uri;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzdC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(obtain2.readStrongBinder());
                    return zzbs;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        }

        public static zzcn zzt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzcn)) ? new zza(iBinder) : (zzcn) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzd zzdC = zzdC();
                    reply.writeNoException();
                    reply.writeStrongBinder(zzdC != null ? zzdC.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    Uri uri = getUri();
                    reply.writeNoException();
                    if (uri != null) {
                        reply.writeInt(1);
                        uri.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    double scale = getScale();
                    reply.writeNoException();
                    reply.writeDouble(scale);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    double getScale() throws RemoteException;

    Uri getUri() throws RemoteException;

    zzd zzdC() throws RemoteException;
}
