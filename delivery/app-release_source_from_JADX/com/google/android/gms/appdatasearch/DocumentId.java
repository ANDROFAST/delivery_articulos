package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzSp;
    final String zzSq;
    final String zzSr;

    DocumentId(int versionCode, String packageName, String corpusName, String uri) {
        this.mVersionCode = versionCode;
        this.zzSp = packageName;
        this.zzSq = corpusName;
        this.zzSr = uri;
    }

    public DocumentId(String packageName, String corpusName, String uri) {
        this(1, packageName, corpusName, uri);
    }

    public int describeContents() {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zzSp, this.zzSq, this.zzSr});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        zzc.zza(this, dest, flags);
    }
}
