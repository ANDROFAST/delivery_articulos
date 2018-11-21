package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int mVersionCode;
    private final Long zzaIe;
    private final Uri zzaIg;
    private final Long zzaIh;
    private BitmapTeleporter zzaIi;
    private final String zzavc;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        boolean z = true;
        this.mVersionCode = versionCode;
        this.zzavc = description;
        this.zzaIh = playedTimeMillis;
        this.zzaIi = coverImage;
        this.zzaIg = coverImageUri;
        this.zzaIe = progressValue;
        if (this.zzaIi != null) {
            if (this.zzaIg != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzaIg != null) {
            if (this.zzaIi != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this(5, description, playedTimeMillis, coverImage, coverImageUri, progressValue);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.zzaIi == null ? null : this.zzaIi.zzpI();
    }

    public Uri getCoverImageUri() {
        return this.zzaIg;
    }

    public String getDescription() {
        return this.zzavc;
    }

    public Long getPlayedTimeMillis() {
        return this.zzaIh;
    }

    public Long getProgressValue() {
        return this.zzaIe;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.zza(this, out, flags);
    }

    public BitmapTeleporter zzxn() {
        return this.zzaIi;
    }
}
