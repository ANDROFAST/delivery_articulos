package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();
    private final int mVersionCode;
    private final String zzaBL;
    private final GameEntity zzaGU;
    private final Uri zzaIg;
    private final PlayerEntity zzaIj;
    private final String zzaIk;
    private final long zzaIl;
    private final long zzaIm;
    private final float zzaIn;
    private final String zzaIo;
    private final boolean zzaIp;
    private final long zzaIq;
    private final String zzaIr;
    private final String zzank;
    private final String zzavc;

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName, boolean changePending, long progressValue, String deviceName) {
        this.mVersionCode = versionCode;
        this.zzaGU = game;
        this.zzaIj = owner;
        this.zzaBL = snapshotId;
        this.zzaIg = coverImageUri;
        this.zzaIk = coverImageUrl;
        this.zzaIn = coverImageAspectRatio;
        this.zzank = title;
        this.zzavc = description;
        this.zzaIl = lastModifiedTimestamp;
        this.zzaIm = playedTime;
        this.zzaIo = uniqueName;
        this.zzaIp = changePending;
        this.zzaIq = progressValue;
        this.zzaIr = deviceName;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.mVersionCode = 6;
        this.zzaGU = new GameEntity(snapshotMetadata.getGame());
        this.zzaIj = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzaBL = snapshotMetadata.getSnapshotId();
        this.zzaIg = snapshotMetadata.getCoverImageUri();
        this.zzaIk = snapshotMetadata.getCoverImageUrl();
        this.zzaIn = snapshotMetadata.getCoverImageAspectRatio();
        this.zzank = snapshotMetadata.getTitle();
        this.zzavc = snapshotMetadata.getDescription();
        this.zzaIl = snapshotMetadata.getLastModifiedTimestamp();
        this.zzaIm = snapshotMetadata.getPlayedTime();
        this.zzaIo = snapshotMetadata.getUniqueName();
        this.zzaIp = snapshotMetadata.hasChangePending();
        this.zzaIq = snapshotMetadata.getProgressValue();
        this.zzaIr = snapshotMetadata.getDeviceName();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzw.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzw.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzw.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzw.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzw.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzw.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzw.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzw.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzw.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzw.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzw.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzw.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzw.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && zzw.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzw.zzx(snapshotMetadata).zzg("Game", snapshotMetadata.getGame()).zzg("Owner", snapshotMetadata.getOwner()).zzg("SnapshotId", snapshotMetadata.getSnapshotId()).zzg("CoverImageUri", snapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zzg("Description", snapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zzg("UniqueName", snapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).zzg("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzaIn;
    }

    public Uri getCoverImageUri() {
        return this.zzaIg;
    }

    public String getCoverImageUrl() {
        return this.zzaIk;
    }

    public String getDescription() {
        return this.zzavc;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzavc, dataOut);
    }

    public String getDeviceName() {
        return this.zzaIr;
    }

    public Game getGame() {
        return this.zzaGU;
    }

    public long getLastModifiedTimestamp() {
        return this.zzaIl;
    }

    public Player getOwner() {
        return this.zzaIj;
    }

    public long getPlayedTime() {
        return this.zzaIm;
    }

    public long getProgressValue() {
        return this.zzaIq;
    }

    public String getSnapshotId() {
        return this.zzaBL;
    }

    public String getTitle() {
        return this.zzank;
    }

    public String getUniqueName() {
        return this.zzaIo;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasChangePending() {
        return this.zzaIp;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataEntityCreator.zza(this, out, flags);
    }
}
