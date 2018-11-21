package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int zzSs = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzSt = new zza("SsbContext").zzM(true).zzby("blob").zzlQ();
    final int mVersionCode;
    public final String zzSu;
    final RegisterSectionInfo zzSv;
    public final int zzSw;
    public final byte[] zzSx;

    DocumentSection(int versionCode, String content, RegisterSectionInfo sectionInfo, int globalSearchSectionType, byte[] blobContent) {
        boolean z = globalSearchSectionType == zzSs || zzh.zzao(globalSearchSectionType) != null;
        zzx.zzb(z, "Invalid section type " + globalSearchSectionType);
        this.mVersionCode = versionCode;
        this.zzSu = content;
        this.zzSv = sectionInfo;
        this.zzSw = globalSearchSectionType;
        this.zzSx = blobContent;
        String zzlO = zzlO();
        if (zzlO != null) {
            throw new IllegalArgumentException(zzlO);
        }
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo) {
        this(1, content, sectionInfo, zzSs, null);
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo, String globalSearchSectionType) {
        this(1, content, sectionInfo, zzh.zzbx(globalSearchSectionType), null);
    }

    public DocumentSection(byte[] blobContent, RegisterSectionInfo sectionInfo) {
        this(1, null, sectionInfo, zzSs, blobContent);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzSt);
    }

    public int describeContents() {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        zzd.zza(this, dest, flags);
    }

    public String zzlO() {
        return (this.zzSw == zzSs || zzh.zzao(this.zzSw) != null) ? (this.zzSu == null || this.zzSx == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzSw;
    }
}
