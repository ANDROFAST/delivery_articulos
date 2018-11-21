package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new zzb();
    private final int mVersionCode;
    private final Uri zzair;
    private final int zzov;
    private final int zzow;

    WebImage(int versionCode, Uri url, int width, int height) {
        this.mVersionCode = versionCode;
        this.zzair = url;
        this.zzov = width;
        this.zzow = height;
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(zzi(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    private static Uri zzi(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) other;
        return zzw.equal(this.zzair, webImage.zzair) && this.zzov == webImage.zzov && this.zzow == webImage.zzow;
    }

    public int getHeight() {
        return this.zzow;
    }

    public Uri getUrl() {
        return this.zzair;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzov;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzair, Integer.valueOf(this.zzov), Integer.valueOf(this.zzow));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.zzair.toString());
            jSONObject.put("width", this.zzov);
            jSONObject.put("height", this.zzow);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.zzov), Integer.valueOf(this.zzow), this.zzair.toString()});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
