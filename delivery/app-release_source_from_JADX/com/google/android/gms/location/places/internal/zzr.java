package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

public class zzr extends zzu implements PlacePhotoMetadata {
    private final String zzaOg = getString("photo_fife_url");

    public zzr(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return zzyN();
    }

    public CharSequence getAttributions() {
        return zzI("photo_attributions", null);
    }

    public int getMaxHeight() {
        return zzz("photo_max_height", 0);
    }

    public int getMaxWidth() {
        return zzz("photo_max_width", 0);
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        return zzyN().getScaledPhoto(client, width, height);
    }

    public PlacePhotoMetadata zzyN() {
        return new zzq(this.zzaOg, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzahw);
    }
}
