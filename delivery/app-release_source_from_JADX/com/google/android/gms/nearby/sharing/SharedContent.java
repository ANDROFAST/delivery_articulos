package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class SharedContent implements SafeParcelable {
    public static final Creator<SharedContent> CREATOR = new zzc();
    private final int versionCode;
    @Deprecated
    private String zzaXT;
    private ViewableItem[] zzaXU;
    private LocalContent[] zzaXV;

    private SharedContent() {
        this.versionCode = 2;
    }

    SharedContent(int versionCode, String uri, ViewableItem[] viewableItems, LocalContent[] localContents) {
        this.versionCode = versionCode;
        this.zzaXT = uri;
        this.zzaXU = viewableItems;
        this.zzaXV = localContents;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) o;
        return zzw.equal(this.zzaXU, sharedContent.zzaXU) && zzw.equal(this.zzaXV, sharedContent.zzaXV) && zzw.equal(this.zzaXT, sharedContent.zzaXT);
    }

    public String getUri() {
        return this.zzaXT;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaXU, this.zzaXV, this.zzaXT);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.zzaXU) + ", localContents=" + Arrays.toString(this.zzaXV) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public ViewableItem[] zzCQ() {
        return this.zzaXU;
    }

    public LocalContent[] zzCR() {
        return this.zzaXV;
    }
}
