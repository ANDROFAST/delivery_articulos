package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private Long zzaId;
        private Long zzaIe;
        private BitmapTeleporter zzaIf;
        private Uri zzaIg;
        private String zzavc;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzavc, this.zzaId, this.zzaIf, this.zzaIg, this.zzaIe);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.zzavc = metadata.getDescription();
            this.zzaId = Long.valueOf(metadata.getPlayedTime());
            this.zzaIe = Long.valueOf(metadata.getProgressValue());
            if (this.zzaId.longValue() == -1) {
                this.zzaId = null;
            }
            this.zzaIg = metadata.getCoverImageUri();
            if (this.zzaIg != null) {
                this.zzaIf = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.zzaIf = new BitmapTeleporter(coverImage);
            this.zzaIg = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzavc = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.zzaId = Long.valueOf(playedTimeMillis);
            return this;
        }

        public Builder setProgressValue(long progressValue) {
            this.zzaIe = Long.valueOf(progressValue);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zzxn();
}
