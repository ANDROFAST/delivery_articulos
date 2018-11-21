package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Creator<Status> CREATOR = new zzd();
    public static final Status zzaeX = new Status(0);
    public static final Status zzaeY = new Status(14);
    public static final Status zzaeZ = new Status(8);
    public static final Status zzafa = new Status(15);
    public static final Status zzafb = new Status(16);
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzabx;
    private final String zzadS;

    public Status(int statusCode) {
        this(statusCode, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.mVersionCode = versionCode;
        this.zzabx = statusCode;
        this.zzadS = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage) {
        this(1, statusCode, statusMessage, null);
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    private String zzoO() {
        return this.zzadS != null ? this.zzadS : CommonStatusCodes.getStatusCodeString(this.zzabx);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.zzabx == status.zzabx && zzw.equal(this.zzadS, status.zzadS) && zzw.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzabx;
    }

    public String getStatusMessage() {
        return this.zzadS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzabx), this.zzadS, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzabx == 16;
    }

    public boolean isInterrupted() {
        return this.zzabx == 14;
    }

    public boolean isSuccess() {
        return this.zzabx <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzx(this).zzg("statusCode", zzoO()).zzg("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    PendingIntent zzoN() {
        return this.mPendingIntent;
    }
}
