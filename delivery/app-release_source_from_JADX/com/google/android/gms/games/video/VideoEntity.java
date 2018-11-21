package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;

public final class VideoEntity implements SafeParcelable, Video {
    public static final Creator<VideoEntity> CREATOR = new VideoEntityCreator();
    private final int mVersionCode;
    private final long zzBv;
    private final String zzSp;
    private final String zzaIF;
    private final long zzaIG;
    private final int zzaiv;

    VideoEntity(int versionCode, int duration, String filePath, long fileSize, long startTime, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaiv = duration;
        this.zzaIF = filePath;
        this.zzaIG = fileSize;
        this.zzBv = startTime;
        this.zzSp = packageName;
    }

    public VideoEntity(Video video) {
        this.mVersionCode = 1;
        this.zzaiv = video.getDuration();
        this.zzaIF = video.zzxq();
        this.zzaIG = video.getFileSize();
        this.zzBv = video.getStartTime();
        this.zzSp = video.getPackageName();
        zzb.zzu(this.zzaIF);
        zzb.zzu(this.zzSp);
    }

    static int zza(Video video) {
        return zzw.hashCode(Integer.valueOf(video.getDuration()), video.zzxq(), Long.valueOf(video.getFileSize()), Long.valueOf(video.getStartTime()), video.getPackageName());
    }

    static boolean zza(Video video, Object obj) {
        if (!(obj instanceof Video)) {
            return false;
        }
        if (video == obj) {
            return true;
        }
        Video video2 = (Video) obj;
        return zzw.equal(Integer.valueOf(video2.getDuration()), Integer.valueOf(video.getDuration())) && zzw.equal(video2.zzxq(), video.zzxq()) && zzw.equal(Long.valueOf(video2.getFileSize()), Long.valueOf(video.getFileSize())) && zzw.equal(Long.valueOf(video2.getStartTime()), Long.valueOf(video.getStartTime())) && zzw.equal(video2.getPackageName(), video.getPackageName());
    }

    static String zzb(Video video) {
        return zzw.zzx(video).zzg("Duration", Integer.valueOf(video.getDuration())).zzg("File path", video.zzxq()).zzg("File size", Long.valueOf(video.getFileSize())).zzg("Start time", Long.valueOf(video.getStartTime())).zzg("Package name", video.getPackageName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxu();
    }

    public int getDuration() {
        return this.zzaiv;
    }

    public long getFileSize() {
        return this.zzaIG;
    }

    public String getPackageName() {
        return this.zzSp;
    }

    public long getStartTime() {
        return this.zzBv;
    }

    public int getVersionCode() {
        return this.mVersionCode;
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

    public void writeToParcel(Parcel dest, int flags) {
        VideoEntityCreator.zza(this, dest, flags);
    }

    public String zzxq() {
        return this.zzaIF;
    }

    public Video zzxu() {
        return this;
    }
}
