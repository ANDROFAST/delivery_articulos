package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzl extends IInterface {

    public static abstract class zza extends Binder implements zzl {

        private static class zza implements zzl {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(AppMetadata appMetadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EventParcel eventParcel, AppMetadata appMetadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
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

            public void zza(EventParcel eventParcel, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoo.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (userAttributeParcel != null) {
                        obtain.writeInt(1);
                        userAttributeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
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

            public void zzb(AppMetadata appMetadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }

        public static zzl zzdi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzl)) ? new zza(iBinder) : (zzl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AppMetadata appMetadata = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    EventParcel zzfE = data.readInt() != 0 ? EventParcel.CREATOR.zzfE(data) : null;
                    if (data.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.zzfC(data);
                    }
                    zza(zzfE, appMetadata);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    UserAttributeParcel zzfF = data.readInt() != 0 ? UserAttributeParcel.CREATOR.zzfF(data) : null;
                    if (data.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.zzfC(data);
                    }
                    zza(zzfF, appMetadata);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (data.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.zzfC(data);
                    }
                    zza(appMetadata);
                    reply.writeNoException();
                    return true;
                case 5:
                    EventParcel zzfE2;
                    data.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (data.readInt() != 0) {
                        zzfE2 = EventParcel.CREATOR.zzfE(data);
                    }
                    zza(zzfE2, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (data.readInt() != 0) {
                        appMetadata = AppMetadata.CREATOR.zzfC(data);
                    }
                    zzb(appMetadata);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(AppMetadata appMetadata) throws RemoteException;

    void zza(EventParcel eventParcel, AppMetadata appMetadata) throws RemoteException;

    void zza(EventParcel eventParcel, String str, String str2) throws RemoteException;

    void zza(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) throws RemoteException;

    void zzb(AppMetadata appMetadata) throws RemoteException;
}
