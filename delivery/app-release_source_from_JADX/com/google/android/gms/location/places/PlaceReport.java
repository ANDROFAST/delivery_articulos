package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class PlaceReport implements SafeParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaMO;
    private final String zzaMP;

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.mVersionCode = versionCode;
        this.zzaMO = placeId;
        this.mTag = tag;
        this.zzaMP = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzi(placeId, tag, "unknown");
    }

    private static boolean zzdV(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzx.zzy(str);
        zzx.zzcG(str2);
        zzx.zzcG(str3);
        zzx.zzb(zzdV(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzw.equal(this.zzaMO, placeReport.zzaMO) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaMP, placeReport.zzaMP);
    }

    public String getPlaceId() {
        return this.zzaMO;
    }

    public String getSource() {
        return this.zzaMP;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMO, this.mTag, this.zzaMP);
    }

    public String toString() {
        zza zzx = zzw.zzx(this);
        zzx.zzg("placeId", this.zzaMO);
        zzx.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzaMP)) {
            zzx.zzg("source", this.zzaMP);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
