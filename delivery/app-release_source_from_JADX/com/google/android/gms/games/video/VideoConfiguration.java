package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class VideoConfiguration implements SafeParcelable {
    public static final Creator<VideoConfiguration> CREATOR = new VideoConfigurationCreator();
    private final int mVersionCode;
    private final int zzaIB;
    private final int zzaIC;
    private final String zzaID;
    private final String zzaIE;

    public static final class Builder {
    }

    public VideoConfiguration(int versionCode, int qualityLevel, int captureMode, String streamUrl, String streamKey) {
        boolean z = true;
        this.mVersionCode = versionCode;
        zzx.zzab(zzgQ(qualityLevel));
        zzx.zzab(zzgR(captureMode));
        this.zzaIB = qualityLevel;
        this.zzaIC = captureMode;
        if (captureMode == 1) {
            this.zzaIE = streamKey;
            this.zzaID = streamUrl;
            return;
        }
        zzx.zzb(streamKey == null, (Object) "Stream key should be null when not streaming");
        if (streamUrl != null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Stream url should be null when not streaming");
        this.zzaIE = null;
        this.zzaID = null;
    }

    public static boolean zzgQ(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzgR(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getStreamUrl() {
        return this.zzaID;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        VideoConfigurationCreator.zza(this, out, flags);
    }

    public int zzxr() {
        return this.zzaIB;
    }

    public int zzxs() {
        return this.zzaIC;
    }

    public String zzxt() {
        return this.zzaIE;
    }
}
