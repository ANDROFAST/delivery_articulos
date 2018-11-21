package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int mVersionCode;
    private final Uri zzaAU;
    private final String zzaAV;
    private final String zzaAW;
    private final int zzaAX;
    private final int zzaAY;
    private final Bundle zzaAZ;
    private final String zzank;
    private final String zzavc;
    private final String zzxX;

    AppContentAnnotationEntity(int versionCode, String description, Uri imageUri, String title, String id, String layoutSlot, String imageDefaultId, int imageHeight, int imageWidth, Bundle modifiers) {
        this.mVersionCode = versionCode;
        this.zzavc = description;
        this.zzxX = id;
        this.zzaAW = imageDefaultId;
        this.zzaAX = imageHeight;
        this.zzaAU = imageUri;
        this.zzaAY = imageWidth;
        this.zzaAV = layoutSlot;
        this.zzaAZ = modifiers;
        this.zzank = title;
    }

    public AppContentAnnotationEntity(AppContentAnnotation annotation) {
        this.mVersionCode = 4;
        this.zzavc = annotation.getDescription();
        this.zzxX = annotation.getId();
        this.zzaAW = annotation.zzvn();
        this.zzaAX = annotation.zzvo();
        this.zzaAU = annotation.zzvp();
        this.zzaAY = annotation.zzvr();
        this.zzaAV = annotation.zzvs();
        this.zzaAZ = annotation.zzvq();
        this.zzank = annotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzw.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzvn(), Integer.valueOf(appContentAnnotation.zzvo()), appContentAnnotation.zzvp(), Integer.valueOf(appContentAnnotation.zzvr()), appContentAnnotation.zzvs(), appContentAnnotation.zzvq(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzw.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzw.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzw.equal(appContentAnnotation2.zzvn(), appContentAnnotation.zzvn()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzvo()), Integer.valueOf(appContentAnnotation.zzvo())) && zzw.equal(appContentAnnotation2.zzvp(), appContentAnnotation.zzvp()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzvr()), Integer.valueOf(appContentAnnotation.zzvr())) && zzw.equal(appContentAnnotation2.zzvs(), appContentAnnotation.zzvs()) && zzw.equal(appContentAnnotation2.zzvq(), appContentAnnotation.zzvq()) && zzw.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzw.zzx(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zzvn()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zzvo())).zzg("ImageUri", appContentAnnotation.zzvp()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zzvr())).zzg("LayoutSlot", appContentAnnotation.zzvs()).zzg("Modifiers", appContentAnnotation.zzvq()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvt();
    }

    public String getDescription() {
        return this.zzavc;
    }

    public String getId() {
        return this.zzxX;
    }

    public String getTitle() {
        return this.zzank;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentAnnotationEntityCreator.zza(this, out, flags);
    }

    public String zzvn() {
        return this.zzaAW;
    }

    public int zzvo() {
        return this.zzaAX;
    }

    public Uri zzvp() {
        return this.zzaAU;
    }

    public Bundle zzvq() {
        return this.zzaAZ;
    }

    public int zzvr() {
        return this.zzaAY;
    }

    public String zzvs() {
        return this.zzaAV;
    }

    public AppContentAnnotation zzvt() {
        return this;
    }
}
