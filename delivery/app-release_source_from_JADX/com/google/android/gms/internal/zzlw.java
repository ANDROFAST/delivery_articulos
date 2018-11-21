package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;

public interface zzlw extends IInterface {

    public static abstract class zza extends Binder implements zzlw {

        private static class zza implements zzlw {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzlv com_google_android_gms_internal_zzlv, LogEventParcelable logEventParcelable) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (com_google_android_gms_internal_zzlv != null) {
                        iBinder = com_google_android_gms_internal_zzlv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (logEventParcelable != null) {
                        obtain.writeInt(1);
                        logEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzlw zzaM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlw)) ? new zza(iBinder) : (zzlw) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(com.google.android.gms.internal.zzlv.zza.zzaL(data.readStrongBinder()), data.readInt() != 0 ? LogEventParcelable.CREATOR.zzaf(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzlv com_google_android_gms_internal_zzlv, LogEventParcelable logEventParcelable) throws RemoteException;
}
