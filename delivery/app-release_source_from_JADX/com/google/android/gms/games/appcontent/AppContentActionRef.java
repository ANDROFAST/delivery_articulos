package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvm();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzafC, this.zzaBi, "action_data", this.zzahw);
    }

    public String getId() {
        return getString("action_id");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) zzvm()).writeToParcel(dest, flags);
    }

    public AppContentAnnotation zzvi() {
        List zzb = AppContentUtils.zzb(this.zzafC, this.zzaBi, "action_annotation", this.zzahw);
        return zzb.size() == 1 ? (AppContentAnnotation) zzb.get(0) : null;
    }

    public List<AppContentCondition> zzvj() {
        return AppContentUtils.zzc(this.zzafC, this.zzaBi, "action_conditions", this.zzahw);
    }

    public String zzvk() {
        return getString("action_content_description");
    }

    public String zzvl() {
        return getString("overflow_text");
    }

    public AppContentAction zzvm() {
        return new AppContentActionEntity(this);
    }
}
