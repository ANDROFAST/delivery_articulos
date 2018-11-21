package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.DisconnectRequest;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;
import com.google.android.gms.nearby.bootstrap.request.StartScanRequest;
import com.google.android.gms.nearby.bootstrap.request.StopScanRequest;

public interface zzqw extends IInterface {

    public static abstract class zza extends Binder implements zzqw {

        private static class zza implements zzqw {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public String getToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    this.zzoo.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqv com_google_android_gms_internal_zzqv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzqv != null ? com_google_android_gms_internal_zzqv.asBinder() : null);
                    this.zzoo.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ConnectRequest connectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (connectRequest != null) {
                        obtain.writeInt(1);
                        connectRequest.writeToParcel(obtain, 0);
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

            public void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (continueConnectRequest != null) {
                        obtain.writeInt(1);
                        continueConnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisableTargetRequest disableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disableTargetRequest != null) {
                        obtain.writeInt(1);
                        disableTargetRequest.writeToParcel(obtain, 0);
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

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
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

            public void zza(EnableTargetRequest enableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (enableTargetRequest != null) {
                        obtain.writeInt(1);
                        enableTargetRequest.writeToParcel(obtain, 0);
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

            public void zza(SendDataRequest sendDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (sendDataRequest != null) {
                        obtain.writeInt(1);
                        sendDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(StartScanRequest startScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (startScanRequest != null) {
                        obtain.writeInt(1);
                        startScanRequest.writeToParcel(obtain, 0);
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

            public void zza(StopScanRequest stopScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (stopScanRequest != null) {
                        obtain.writeInt(1);
                        stopScanRequest.writeToParcel(obtain, 0);
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

        public static zzqw zzdo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqw)) ? new zza(iBinder) : (zzqw) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ContinueConnectRequest continueConnectRequest = null;
            switch (code) {
                case 1:
                    StartScanRequest zzfN;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfN = StartScanRequest.CREATOR.zzfN(data);
                    }
                    zza(zzfN);
                    reply.writeNoException();
                    return true;
                case 2:
                    StopScanRequest zzfO;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfO = StopScanRequest.CREATOR.zzfO(data);
                    }
                    zza(zzfO);
                    reply.writeNoException();
                    return true;
                case 3:
                    EnableTargetRequest zzfL;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfL = EnableTargetRequest.CREATOR.zzfL(data);
                    }
                    zza(zzfL);
                    reply.writeNoException();
                    return true;
                case 4:
                    DisableTargetRequest zzfJ;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfJ = DisableTargetRequest.CREATOR.zzfJ(data);
                    }
                    zza(zzfJ);
                    reply.writeNoException();
                    return true;
                case 5:
                    ConnectRequest zzfH;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfH = ConnectRequest.CREATOR.zzfH(data);
                    }
                    zza(zzfH);
                    reply.writeNoException();
                    return true;
                case 6:
                    DisconnectRequest zzfK;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfK = DisconnectRequest.CREATOR.zzfK(data);
                    }
                    zza(zzfK);
                    reply.writeNoException();
                    return true;
                case 7:
                    SendDataRequest zzfM;
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        zzfM = SendDataRequest.CREATOR.zzfM(data);
                    }
                    zza(zzfM);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (data.readInt() != 0) {
                        continueConnectRequest = ContinueConnectRequest.CREATOR.zzfI(data);
                    }
                    zza(continueConnectRequest);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    String token = getToken();
                    reply.writeNoException();
                    reply.writeString(token);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(com.google.android.gms.internal.zzqv.zza.zzdn(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getToken() throws RemoteException;

    void zza(zzqv com_google_android_gms_internal_zzqv) throws RemoteException;

    void zza(ConnectRequest connectRequest) throws RemoteException;

    void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException;

    void zza(DisableTargetRequest disableTargetRequest) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(EnableTargetRequest enableTargetRequest) throws RemoteException;

    void zza(SendDataRequest sendDataRequest) throws RemoteException;

    void zza(StartScanRequest startScanRequest) throws RemoteException;

    void zza(StopScanRequest stopScanRequest) throws RemoteException;
}
