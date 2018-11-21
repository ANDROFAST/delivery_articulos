package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final String packageName;
    public final int versionCode;
    public final String zzaYA;
    public final String zzaYB;
    public final boolean zzaYC;
    public final String zzaYD;
    public final boolean zzaYE;
    public final int zzaYF;
    public final int zzaYy;
    public final int zzaYz;

    public PlayLoggerContext(int versionCode, String packageName, int packageVersionCode, int logSource, String uploadAccountName, String loggingId, boolean logAndroidId, String logSourceName, boolean isAnonymous, int qosTier) {
        this.versionCode = versionCode;
        this.packageName = packageName;
        this.zzaYy = packageVersionCode;
        this.zzaYz = logSource;
        this.zzaYA = uploadAccountName;
        this.zzaYB = loggingId;
        this.zzaYC = logAndroidId;
        this.zzaYD = logSourceName;
        this.zzaYE = isAnonymous;
        this.zzaYF = qosTier;
    }

    public PlayLoggerContext(String packageName, int packageVersionCode, int logSource, String logSourceName, String uploadAccountName, String loggingId, boolean isAnonymous, int qosTier) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzy(packageName);
        this.zzaYy = packageVersionCode;
        this.zzaYz = logSource;
        this.zzaYD = logSourceName;
        this.zzaYA = uploadAccountName;
        this.zzaYB = loggingId;
        this.zzaYC = !isAnonymous;
        this.zzaYE = isAnonymous;
        this.zzaYF = qosTier;
    }

    @Deprecated
    public PlayLoggerContext(String packageName, int packageVersionCode, int logSource, String uploadAccountName, String loggingId, boolean logAndroidId) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzy(packageName);
        this.zzaYy = packageVersionCode;
        this.zzaYz = logSource;
        this.zzaYD = null;
        this.zzaYA = uploadAccountName;
        this.zzaYB = loggingId;
        this.zzaYC = logAndroidId;
        this.zzaYE = false;
        this.zzaYF = 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) object;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzaYy == playLoggerContext.zzaYy && this.zzaYz == playLoggerContext.zzaYz && zzw.equal(this.zzaYD, playLoggerContext.zzaYD) && zzw.equal(this.zzaYA, playLoggerContext.zzaYA) && zzw.equal(this.zzaYB, playLoggerContext.zzaYB) && this.zzaYC == playLoggerContext.zzaYC && this.zzaYE == playLoggerContext.zzaYE && this.zzaYF == playLoggerContext.zzaYF;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzaYy), Integer.valueOf(this.zzaYz), this.zzaYD, this.zzaYA, this.zzaYB, Boolean.valueOf(this.zzaYC), Boolean.valueOf(this.zzaYE), Integer.valueOf(this.zzaYF));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.zzaYy).append(',');
        stringBuilder.append("logSource=").append(this.zzaYz).append(',');
        stringBuilder.append("logSourceName=").append(this.zzaYD).append(',');
        stringBuilder.append("uploadAccount=").append(this.zzaYA).append(',');
        stringBuilder.append("loggingId=").append(this.zzaYB).append(',');
        stringBuilder.append("logAndroidId=").append(this.zzaYC).append(',');
        stringBuilder.append("isAnonymous=").append(this.zzaYE).append(',');
        stringBuilder.append("qosTier=").append(this.zzaYF);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
