package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

public interface zzpd extends IInterface {

    public static abstract class zza extends Binder implements zzpd {

        private static class zza implements zzpd {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(ClaimBleDeviceRequest claimBleDeviceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (claimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        claimBleDeviceRequest.writeToParcel(obtain, 0);
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

            public void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (listClaimedBleDevicesRequest != null) {
                        obtain.writeInt(1);
                        listClaimedBleDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
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

            public void zza(StopBleScanRequest stopBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (stopBleScanRequest != null) {
                        obtain.writeInt(1);
                        stopBleScanRequest.writeToParcel(obtain, 0);
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

            public void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (unclaimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        unclaimBleDeviceRequest.writeToParcel(obtain, 0);
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
        }

        public static zzpd zzbF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpd)) ? new zza(iBinder) : (zzpd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ListClaimedBleDevicesRequest listClaimedBleDevicesRequest = null;
            switch (code) {
                case 1:
                    StartBleScanRequest startBleScanRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(data);
                    }
                    zza(startBleScanRequest);
                    reply.writeNoException();
                    return true;
                case 2:
                    StopBleScanRequest stopBleScanRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        stopBleScanRequest = (StopBleScanRequest) StopBleScanRequest.CREATOR.createFromParcel(data);
                    }
                    zza(stopBleScanRequest);
                    reply.writeNoException();
                    return true;
                case 3:
                    ClaimBleDeviceRequest claimBleDeviceRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        claimBleDeviceRequest = (ClaimBleDeviceRequest) ClaimBleDeviceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(claimBleDeviceRequest);
                    reply.writeNoException();
                    return true;
                case 4:
                    UnclaimBleDeviceRequest unclaimBleDeviceRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        unclaimBleDeviceRequest = (UnclaimBleDeviceRequest) UnclaimBleDeviceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unclaimBleDeviceRequest);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        listClaimedBleDevicesRequest = (ListClaimedBleDevicesRequest) ListClaimedBleDevicesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(listClaimedBleDevicesRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ClaimBleDeviceRequest claimBleDeviceRequest) throws RemoteException;

    void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) throws RemoteException;

    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(StopBleScanRequest stopBleScanRequest) throws RemoteException;

    void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest) throws RemoteException;
}
