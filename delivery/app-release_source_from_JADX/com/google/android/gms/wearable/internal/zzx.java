package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzx implements DataApi {

    public static class zza implements DataItemResult {
        private final Status zzTA;
        private final DataItem zzbnq;

        public zza(Status status, DataItem dataItem) {
            this.zzTA = status;
            this.zzbnq = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzbnq;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    public static class zzb implements DeleteDataItemsResult {
        private final Status zzTA;
        private final int zzbnr;

        public zzb(Status status, int i) {
            this.zzTA = status;
            this.zzbnr = i;
        }

        public int getNumDeleted() {
            return this.zzbnr;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    public static class zzc implements GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzTA;
        private volatile InputStream zzbnc;
        private volatile ParcelFileDescriptor zzbns;

        public zzc(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzTA = status;
            this.zzbns = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzbns;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzbns == null) {
                return null;
            } else {
                if (this.zzbnc == null) {
                    this.zzbnc = new AutoCloseInputStream(this.zzbns);
                }
                return this.zzbnc;
            }
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            if (this.zzbns != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzbnc != null) {
                        this.zzbnc.close();
                    } else {
                        this.zzbns.close();
                    }
                    this.mClosed = true;
                    this.zzbns = null;
                    this.zzbnc = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), dataListener);
    }

    private static zza<DataListener> zza(final IntentFilter[] intentFilterArr) {
        return new zza<DataListener>() {
            public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, DataListener dataListener, zzmn<DataListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_DataApi_DataListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, dataListener, (zzmn) com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_DataApi_DataListener, intentFilterArr);
            }
        };
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, new IntentFilter[]{zzcc.zzfY(DataApi.ACTION_DATA_CHANGED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener, Uri uri, int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzcc.zza(DataApi.ACTION_DATA_CHANGED, uri, filterType)});
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (filterType == 0 || filterType == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return client.zza(new zzi<DeleteDataItemsResult>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzb(this, uri, filterType);
            }

            protected DeleteDataItemsResult zzbt(Status status) {
                return new zzb(status, 0);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbt(status);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzi<DataItemResult>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, uri);
            }

            protected DataItemResult zzbr(Status status) {
                return new zza(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbr(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzi<DataItemBuffer>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzo(this);
            }

            protected DataItemBuffer zzbs(Status status) {
                return new DataItemBuffer(DataHolder.zzbJ(status.getStatusCode()));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbs(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (filterType == 0 || filterType == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return client.zza(new zzi<DataItemBuffer>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, uri, filterType);
            }

            protected DataItemBuffer zzbs(Status status) {
                return new DataItemBuffer(DataHolder.zzbJ(status.getStatusCode()));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbs(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzi<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, asset);
            }

            protected GetFdForAssetResult zzbu(Status status) {
                return new zzc(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbu(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzi<GetFdForAssetResult>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, asset);
            }

            protected GetFdForAssetResult zzbu(Status status) {
                return new zzc(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbu(status);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzi<DataItemResult>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, request);
            }

            public DataItemResult zzbr(Status status) {
                return new zza(status, null);
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzbr(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.zza(new zzi<Status>(this, client) {
            final /* synthetic */ zzx zzbnl;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, listener);
            }

            public Status zzb(Status status) {
                return status;
            }

            public /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }
}
