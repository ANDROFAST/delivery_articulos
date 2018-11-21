package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.Collections;
import java.util.List;

public class zzb extends zzu implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private List<SubstringEntity> zzyA() {
        return zza("ap_secondary_text_matched", SubstringEntity.CREATOR, Collections.emptyList());
    }

    private String zzyv() {
        return zzI("ap_description", "");
    }

    private String zzyw() {
        return zzI("ap_primary_text", "");
    }

    private String zzyx() {
        return zzI("ap_secondary_text", "");
    }

    private List<SubstringEntity> zzyy() {
        return zza("ap_matched_subscriptions", SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List<SubstringEntity> zzyz() {
        return zza("ap_primary_text_matched", SubstringEntity.CREATOR, Collections.emptyList());
    }

    public /* synthetic */ Object freeze() {
        return zzyt();
    }

    public String getDescription() {
        return zzyv();
    }

    public CharSequence getFullText(CharacterStyle matchStyle) {
        return zzc.zza(zzyv(), zzyy(), matchStyle);
    }

    public List<SubstringEntity> getMatchedSubstrings() {
        return zzyy();
    }

    public String getPlaceId() {
        return zzI("ap_place_id", null);
    }

    public List<Integer> getPlaceTypes() {
        return zza("ap_place_types", Collections.emptyList());
    }

    public CharSequence getPrimaryText(CharacterStyle matchStyle) {
        return zzc.zza(zzyw(), zzyz(), matchStyle);
    }

    public CharSequence getSecondaryText(CharacterStyle matchStyle) {
        return zzc.zza(zzyx(), zzyA(), matchStyle);
    }

    public AutocompletePrediction zzyt() {
        return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzyu(), zzyv(), zzyy(), zzyw(), zzyz(), zzyx(), zzyA());
    }

    public int zzyu() {
        return zzz("ap_personalization_type", 6);
    }
}
