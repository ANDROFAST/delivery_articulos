package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzml;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzd;
import java.util.List;

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

            public void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(PendingIntent pendingIntent, zzml com_google_android_gms_internal_zzml) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzml != null ? com_google_android_gms_internal_zzml.asBinder() : null);
                    this.zzoo.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzh != null ? com_google_android_gms_location_internal_zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzh != null ? com_google_android_gms_location_internal_zzh.asBinder() : null);
                    this.zzoo.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GestureRequest gestureRequest, PendingIntent pendingIntent, zzml com_google_android_gms_internal_zzml) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (gestureRequest != null) {
                        obtain.writeInt(1);
                        gestureRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzml != null ? com_google_android_gms_internal_zzml.asBinder() : null);
                    this.zzoo.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, zzd com_google_android_gms_location_zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_zzd != null ? com_google_android_gms_location_zzd.asBinder() : null);
                    this.zzoo.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, zzd com_google_android_gms_location_zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_zzd != null ? com_google_android_gms_location_zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationSettingsRequest locationSettingsRequest, zzj com_google_android_gms_location_internal_zzj, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationSettingsRequest != null) {
                        obtain.writeInt(1);
                        locationSettingsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzj != null ? com_google_android_gms_location_internal_zzj.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestInternal locationRequestInternal, zzd com_google_android_gms_location_zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_zzd != null ? com_google_android_gms_location_zzd.asBinder() : null);
                    this.zzoo.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestUpdateData != null) {
                        obtain.writeInt(1);
                        locationRequestUpdateData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
                    this.zzoo.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzh != null ? com_google_android_gms_location_internal_zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_location_zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(com_google_android_gms_location_zzd != null ? com_google_android_gms_location_zzd.asBinder() : null);
                    this.zzoo.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzh != null ? com_google_android_gms_location_internal_zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(com_google_android_gms_location_internal_zzh != null ? com_google_android_gms_location_internal_zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzai(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Status zzb(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                    Status status = obtain2.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return status;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Status zzc(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                    Status status = obtain2.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return status;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ActivityRecognitionResult zzdR(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzoo.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    ActivityRecognitionResult createFromParcel = obtain2.readInt() != 0 ? ActivityRecognitionResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzdS(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzoo.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LocationAvailability zzdT(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzoo.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    LocationAvailability createFromParcel = obtain2.readInt() != 0 ? LocationAvailability.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzyb() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.zzoo.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzi zzcj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new zza(iBinder) : (zzi) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            LocationRequestUpdateData locationRequestUpdateData = null;
            Location zzyb;
            LocationRequest createFromParcel;
            Status zzb;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.createTypedArrayList(ParcelableGeofence.CREATOR), data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.internal.zzh.zza.zzci(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.internal.zzh.zza.zzci(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.createStringArray(), com.google.android.gms.location.internal.zzh.zza.zzci(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(com.google.android.gms.location.internal.zzh.zza.zzci(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    long readLong = data.readLong();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(readLong, z, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzyb = zzyb();
                    reply.writeNoException();
                    if (zzyb != null) {
                        reply.writeInt(1);
                        zzyb.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createFromParcel, com.google.android.gms.location.zzd.zza.zzcf(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(com.google.android.gms.location.zzd.zza.zzcf(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzd(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzai(z);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzc(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createFromParcel, com.google.android.gms.location.zzd.zza.zzcf(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzyb = zzdS(data.readString());
                    reply.writeNoException();
                    if (zzyb != null) {
                        reply.writeInt(1);
                        zzyb.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationAvailability zzdT = zzdT(data.readString());
                    reply.writeNoException();
                    if (zzdT != null) {
                        reply.writeInt(1);
                        zzdT.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 52:
                    LocationRequestInternal zzeO;
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        zzeO = LocationRequestInternal.CREATOR.zzeO(data);
                    }
                    zza(zzeO, com.google.android.gms.location.zzd.zza.zzcf(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? LocationRequestInternal.CREATOR.zzeO(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 57:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? (GeofencingRequest) GeofencingRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.internal.zzh.zza.zzci(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 59:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        locationRequestUpdateData = LocationRequestUpdateData.CREATOR.zzeP(data);
                    }
                    zza(locationRequestUpdateData);
                    reply.writeNoException();
                    return true;
                case 60:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? GestureRequest.CREATOR.zzeH(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzml.zza.zzaN(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 61:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzml.zza.zzaN(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 63:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(data.readInt() != 0 ? (LocationSettingsRequest) LocationSettingsRequest.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.internal.zzj.zza.zzck(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 64:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ActivityRecognitionResult zzdR = zzdR(data.readString());
                    reply.writeNoException();
                    if (zzdR != null) {
                        reply.writeInt(1);
                        zzdR.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 65:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzb = zzb(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzb != null) {
                        reply.writeInt(1);
                        zzb.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 66:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zzb = zzc(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzb != null) {
                        reply.writeInt(1);
                        zzb.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 67:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    zza(com.google.android.gms.location.internal.zzg.zza.zzch(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzml com_google_android_gms_internal_zzml) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException;

    void zza(Location location, int i) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh) throws RemoteException;

    void zza(GestureRequest gestureRequest, PendingIntent pendingIntent, zzml com_google_android_gms_internal_zzml) throws RemoteException;

    void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequest locationRequest, zzd com_google_android_gms_location_zzd) throws RemoteException;

    void zza(LocationRequest locationRequest, zzd com_google_android_gms_location_zzd, String str) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzj com_google_android_gms_location_internal_zzj, String str) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, zzd com_google_android_gms_location_zzd) throws RemoteException;

    void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException;

    void zza(zzg com_google_android_gms_location_internal_zzg) throws RemoteException;

    void zza(zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException;

    void zza(zzd com_google_android_gms_location_zzd) throws RemoteException;

    void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException;

    void zza(String[] strArr, zzh com_google_android_gms_location_internal_zzh, String str) throws RemoteException;

    void zzai(boolean z) throws RemoteException;

    Status zzb(PendingIntent pendingIntent) throws RemoteException;

    Status zzc(PendingIntent pendingIntent) throws RemoteException;

    void zzc(Location location) throws RemoteException;

    void zzd(PendingIntent pendingIntent) throws RemoteException;

    ActivityRecognitionResult zzdR(String str) throws RemoteException;

    Location zzdS(String str) throws RemoteException;

    LocationAvailability zzdT(String str) throws RemoteException;

    Location zzyb() throws RemoteException;
}
