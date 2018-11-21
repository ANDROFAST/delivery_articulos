package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaBl;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.zzaBl = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvG();
    }

    public /* synthetic */ List getActions() {
        return zzvH();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzafC, this.zzaBi, "section_data", this.zzahw);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) zzvG()).writeToParcel(dest, flags);
    }

    public /* synthetic */ List zzvE() {
        return zzvJ();
    }

    public String zzvF() {
        return getString("section_card_type");
    }

    public AppContentSection zzvG() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzvH() {
        return AppContentUtils.zza(this.zzafC, this.zzaBi, "section_actions", this.zzahw);
    }

    public ArrayList<AppContentAnnotation> zzvI() {
        return AppContentUtils.zzb(this.zzafC, this.zzaBi, "section_annotations", this.zzahw);
    }

    public ArrayList<AppContentCard> zzvJ() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzaBl);
        for (int i = 0; i < this.zzaBl; i++) {
            arrayList.add(new AppContentCardRef(this.zzaBi, this.zzahw + i));
        }
        return arrayList;
    }

    public String zzvk() {
        return getString("section_content_description");
    }

    public /* synthetic */ List zzvu() {
        return zzvI();
    }

    public String zzvw() {
        return getString("section_subtitle");
    }
}
