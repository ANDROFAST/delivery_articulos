package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvy();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzafC, this.zzaBi, "card_actions", this.zzahw);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzafC, this.zzaBi, "card_data", this.zzahw);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) zzvy()).writeToParcel(dest, flags);
    }

    public List<AppContentCondition> zzvj() {
        return AppContentUtils.zzc(this.zzafC, this.zzaBi, "card_conditions", this.zzahw);
    }

    public String zzvk() {
        return getString("card_content_description");
    }

    public List<AppContentAnnotation> zzvu() {
        return AppContentUtils.zzb(this.zzafC, this.zzaBi, "card_annotations", this.zzahw);
    }

    public int zzvv() {
        return getInteger("card_current_steps");
    }

    public String zzvw() {
        return getString("card_subtitle");
    }

    public int zzvx() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zzvy() {
        return new AppContentCardEntity(this);
    }
}
