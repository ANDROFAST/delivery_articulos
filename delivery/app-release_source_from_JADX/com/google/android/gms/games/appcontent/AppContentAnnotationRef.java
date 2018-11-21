package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> dataHolders, int dataRow) {
        super(dataHolders, 2, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvt();
    }

    public String getDescription() {
        return getString("annotation_description");
    }

    public String getId() {
        return getString("annotation_id");
    }

    public String getTitle() {
        return getString("annotation_title");
    }

    public int hashCode() {
        return AppContentAnnotationEntity.zza(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentAnnotationEntity) zzvt()).writeToParcel(dest, flags);
    }

    public String zzvn() {
        return getString("annotation_image_default_id");
    }

    public int zzvo() {
        return getInteger("annotation_image_height");
    }

    public Uri zzvp() {
        return zzcu("annotation_image_uri");
    }

    public Bundle zzvq() {
        return AppContentUtils.zzd(this.zzafC, this.zzaBi, "annotation_modifiers", this.zzahw);
    }

    public int zzvr() {
        return getInteger("annotation_image_width");
    }

    public String zzvs() {
        return getString("annotation_layout_slot");
    }

    public AppContentAnnotation zzvt() {
        return new AppContentAnnotationEntity(this);
    }
}
