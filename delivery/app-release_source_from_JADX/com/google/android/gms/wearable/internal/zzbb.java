package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzbb extends IInterface {

    public static abstract class zza extends Binder implements zzbb {

        private static class zza implements zzbb {
            private IBinder zzoo;

            zza(IBinder iBinder) {
                this.zzoo = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoo;
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeByte(b);
                    this.zzoo.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoo.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
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

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
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

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetEnqueueRequest largeAssetEnqueueRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (largeAssetEnqueueRequest != null) {
                        obtain.writeInt(1);
                        largeAssetEnqueueRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetQuery largeAssetQuery) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (largeAssetQuery != null) {
                        obtain.writeInt(1);
                        largeAssetQuery.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetRemoveRequest largeAssetRemoveRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (largeAssetRemoveRequest != null) {
                        obtain.writeInt(1);
                        largeAssetRemoveRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzaw != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzaw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzoo.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoo.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoo.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzoo.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoo.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zzoo.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoo.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
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

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzaw != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzaw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzoo.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoo.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoo.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzaz com_google_android_gms_wearable_internal_zzaz, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoo.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zzc(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoo.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzq(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzaz != null ? com_google_android_gms_wearable_internal_zzaz.asBinder() : null);
                    this.zzoo.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzbb zzer(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzbb)) ? new zza(iBinder) : (zzbb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            ConnectionConfiguration connectionConfiguration = null;
            zzaz zzep;
            Uri uri;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zzb(zzep, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzo(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzp(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzq(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, putDataRequest);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, uri);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzep, uri);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzc(zzep, uri);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 13:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, asset);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    AddListenerRequest addListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        addListenerRequest = (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, addListenerRequest);
                    reply.writeNoException();
                    return true;
                case 17:
                    RemoveListenerRequest removeListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        removeListenerRequest = (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, removeListenerRequest);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, ancsNotificationParcelable);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzaw.zza.zzem(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzaw.zza.zzem(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    ParcelFileDescriptor parcelFileDescriptor;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, readString, parcelFileDescriptor);
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null, data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzep, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzaz zzep2 = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzep2, z);
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzm(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 52:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzn(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()), data.readByte());
                    reply.writeNoException();
                    return true;
                case 54:
                    LargeAssetEnqueueRequest largeAssetEnqueueRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        largeAssetEnqueueRequest = (LargeAssetEnqueueRequest) LargeAssetEnqueueRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, largeAssetEnqueueRequest);
                    reply.writeNoException();
                    return true;
                case 55:
                    LargeAssetRemoveRequest largeAssetRemoveRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        largeAssetRemoveRequest = (LargeAssetRemoveRequest) LargeAssetRemoveRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, largeAssetRemoveRequest);
                    reply.writeNoException();
                    return true;
                case 56:
                    LargeAssetQuery largeAssetQuery;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzep = com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        largeAssetQuery = (LargeAssetQuery) LargeAssetQuery.CREATOR.createFromParcel(data);
                    }
                    zza(zzep, largeAssetQuery);
                    reply.writeNoException();
                    return true;
                case 57:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzaz.zza.zzep(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, byte b) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, int i) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, Asset asset) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetEnqueueRequest largeAssetEnqueueRequest) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetQuery largeAssetQuery) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, LargeAssetRemoveRequest largeAssetRemoveRequest) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, int i) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri, int i) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, zzaw com_google_android_gms_wearable_internal_zzaw, String str) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, String str, int i) throws RemoteException;

    void zzb(zzaz com_google_android_gms_wearable_internal_zzaz, boolean z) throws RemoteException;

    void zzc(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzc(zzaz com_google_android_gms_wearable_internal_zzaz, int i) throws RemoteException;

    void zzc(zzaz com_google_android_gms_wearable_internal_zzaz, Uri uri) throws RemoteException;

    void zzc(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException;

    void zzd(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzd(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException;

    void zze(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zze(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException;

    void zzf(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzf(zzaz com_google_android_gms_wearable_internal_zzaz, String str) throws RemoteException;

    void zzg(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzh(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzi(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzj(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzk(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzl(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzm(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzn(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzo(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzp(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;

    void zzq(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException;
}
