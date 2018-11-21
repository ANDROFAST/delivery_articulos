package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzd;

public class AncsNotificationParcelable implements SafeParcelable, zzd {
    public static final Creator<AncsNotificationParcelable> CREATOR = new zzh();
    private int mId;
    final int mVersionCode;
    private String zzVu;
    private final String zzZa;
    private final String zzaBc;
    private final String zzaRd;
    private final String zzank;
    private final String zzbmC;
    private byte zzbmD;
    private byte zzbmE;
    private byte zzbmF;
    private byte zzbmG;

    AncsNotificationParcelable(int versionCode, int id, String appId, String dateTime, String notificationText, String title, String subtitle, String displayName, byte eventId, byte eventFlags, byte categoryId, byte categoryCount) {
        this.mId = id;
        this.mVersionCode = versionCode;
        this.zzaRd = appId;
        this.zzbmC = dateTime;
        this.zzZa = notificationText;
        this.zzank = title;
        this.zzaBc = subtitle;
        this.zzVu = displayName;
        this.zzbmD = eventId;
        this.zzbmE = eventFlags;
        this.zzbmF = categoryId;
        this.zzbmG = categoryCount;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) o;
        if (this.zzbmG != ancsNotificationParcelable.zzbmG) {
            return false;
        }
        if (this.zzbmF != ancsNotificationParcelable.zzbmF) {
            return false;
        }
        if (this.zzbmE != ancsNotificationParcelable.zzbmE) {
            return false;
        }
        if (this.zzbmD != ancsNotificationParcelable.zzbmD) {
            return false;
        }
        if (this.mId != ancsNotificationParcelable.mId) {
            return false;
        }
        if (this.mVersionCode != ancsNotificationParcelable.mVersionCode) {
            return false;
        }
        if (!this.zzaRd.equals(ancsNotificationParcelable.zzaRd)) {
            return false;
        }
        if (this.zzbmC == null ? ancsNotificationParcelable.zzbmC != null : !this.zzbmC.equals(ancsNotificationParcelable.zzbmC)) {
            return false;
        }
        if (!this.zzVu.equals(ancsNotificationParcelable.zzVu)) {
            return false;
        }
        if (!this.zzZa.equals(ancsNotificationParcelable.zzZa)) {
            return false;
        }
        if (this.zzaBc.equals(ancsNotificationParcelable.zzaBc)) {
            return this.zzank.equals(ancsNotificationParcelable.zzank);
        } else {
            return false;
        }
    }

    public String getDisplayName() {
        return this.zzVu == null ? this.zzaRd : this.zzVu;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.zzank;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzbmC != null ? this.zzbmC.hashCode() : 0) + (((((this.mVersionCode * 31) + this.mId) * 31) + this.zzaRd.hashCode()) * 31)) * 31) + this.zzZa.hashCode()) * 31) + this.zzank.hashCode()) * 31) + this.zzaBc.hashCode()) * 31) + this.zzVu.hashCode()) * 31) + this.zzbmD) * 31) + this.zzbmE) * 31) + this.zzbmF) * 31) + this.zzbmG;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.zzaRd + '\'' + ", mDateTime='" + this.zzbmC + '\'' + ", mNotificationText='" + this.zzZa + '\'' + ", mTitle='" + this.zzank + '\'' + ", mSubtitle='" + this.zzaBc + '\'' + ", mDisplayName='" + this.zzVu + '\'' + ", mEventId=" + this.zzbmD + ", mEventFlags=" + this.zzbmE + ", mCategoryId=" + this.zzbmF + ", mCategoryCount=" + this.zzbmG + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public String zzGE() {
        return this.zzbmC;
    }

    public String zzGF() {
        return this.zzZa;
    }

    public byte zzGG() {
        return this.zzbmD;
    }

    public byte zzGH() {
        return this.zzbmE;
    }

    public byte zzGI() {
        return this.zzbmF;
    }

    public byte zzGJ() {
        return this.zzbmG;
    }

    public String zzvw() {
        return this.zzaBc;
    }

    public String zzwg() {
        return this.zzaRd;
    }
}
