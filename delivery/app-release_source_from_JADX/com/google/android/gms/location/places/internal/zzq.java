package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

public class zzq implements PlacePhotoMetadata {
    private int mIndex;
    private final int zzCF;
    private final int zzCG;
    private final String zzaOg;
    private final CharSequence zzaOh;

    public zzq(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaOg = str;
        this.zzCF = i;
        this.zzCG = i2;
        this.zzaOh = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzq)) {
            return false;
        }
        zzq com_google_android_gms_location_places_internal_zzq = (zzq) other;
        return com_google_android_gms_location_places_internal_zzq.zzCF == this.zzCF && com_google_android_gms_location_places_internal_zzq.zzCG == this.zzCG && zzw.equal(com_google_android_gms_location_places_internal_zzq.zzaOg, this.zzaOg) && zzw.equal(com_google_android_gms_location_places_internal_zzq.zzaOh, this.zzaOh);
    }

    public /* synthetic */ Object freeze() {
        return zzyN();
    }

    public CharSequence getAttributions() {
        return this.zzaOh;
    }

    public int getMaxHeight() {
        return this.zzCG;
    }

    public int getMaxWidth() {
        return this.zzCF;
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        final int i = width;
        final int i2 = height;
        return client.zza(new zza<zze>(this, Places.zzaMU, client) {
            final /* synthetic */ zzq zzaOk;

            protected void zza(zze com_google_android_gms_location_places_internal_zze) throws RemoteException {
                com_google_android_gms_location_places_internal_zze.zza(new zzf((zza) this), this.zzaOk.zzaOg, i, i2, this.zzaOk.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzCF), Integer.valueOf(this.zzCG), this.zzaOg, this.zzaOh);
    }

    public boolean isDataValid() {
        return true;
    }

    public PlacePhotoMetadata zzyN() {
        return this;
    }
}
