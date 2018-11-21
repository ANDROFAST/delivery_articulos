package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsy.zza;
import com.google.android.gms.internal.zztk;

public class PutDataMapRequest {
    private final DataMap zzblU = new DataMap();
    private final PutDataRequest zzblV;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.zzblV = putDataRequest;
        if (dataMap != null) {
            this.zzblU.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String path) {
        return new PutDataMapRequest(PutDataRequest.create(path), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem source) {
        return new PutDataMapRequest(PutDataRequest.zzr(source.getUri()), source.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String pathPrefix) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(pathPrefix), null);
    }

    public PutDataRequest asPutDataRequest() {
        zza zza = zzsy.zza(this.zzblU);
        this.zzblV.setData(zztk.toByteArray(zza.zzbpf));
        int size = zza.zzbpg.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) zza.zzbpg.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.zzblV.putAsset(num, asset);
                i++;
            }
        }
        return this.zzblV;
    }

    public DataMap getDataMap() {
        return this.zzblU;
    }

    public Uri getUri() {
        return this.zzblV.getUri();
    }

    public boolean isUrgent() {
        return this.zzblV.isUrgent();
    }

    public PutDataMapRequest setUrgent() {
        this.zzblV.setUrgent();
        return this;
    }
}
