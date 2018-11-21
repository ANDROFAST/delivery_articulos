package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new zza();
    String mName;
    private final int mVersionCode;
    String zzXW;
    List<String> zzXX;
    String zzXY;
    Uri zzXZ;
    List<WebImage> zzxz;

    private ApplicationMetadata() {
        this.mVersionCode = 1;
        this.zzxz = new ArrayList();
        this.zzXX = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.mVersionCode = versionCode;
        this.zzXW = applicationId;
        this.mName = name;
        this.zzxz = images;
        this.zzXX = namespaces;
        this.zzXY = senderAppIdentifier;
        this.zzXZ = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.zzXX != null && this.zzXX.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.zza(this.zzXW, applicationMetadata.zzXW) && zzf.zza(this.zzxz, applicationMetadata.zzxz) && zzf.zza(this.mName, applicationMetadata.mName) && zzf.zza(this.zzXX, applicationMetadata.zzXX) && zzf.zza(this.zzXY, applicationMetadata.zzXY) && zzf.zza(this.zzXZ, applicationMetadata.zzXZ);
    }

    public String getApplicationId() {
        return this.zzXW;
    }

    public List<WebImage> getImages() {
        return this.zzxz;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzXY;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzXW, this.mName, this.zzxz, this.zzXX, this.zzXY, this.zzXZ);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.zzXX != null && this.zzXX.contains(namespace);
    }

    public String toString() {
        int i = 0;
        StringBuilder append = new StringBuilder().append("applicationId: ").append(this.zzXW).append(", name: ").append(this.mName).append(", images.count: ").append(this.zzxz == null ? 0 : this.zzxz.size()).append(", namespaces.count: ");
        if (this.zzXX != null) {
            i = this.zzXX.size();
        }
        return append.append(i).append(", senderAppIdentifier: ").append(this.zzXY).append(", senderAppLaunchUrl: ").append(this.zzXZ).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zznh() {
        return this.zzXZ;
    }
}
