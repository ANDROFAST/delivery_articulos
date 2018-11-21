package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzs extends zzu implements Place {
    private final String zzaMO;
    private boolean zzaNP;
    private final zzp zzaNS;

    public zzs(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.zzaNS = context != null ? zzp.zzaN(context) : null;
        this.zzaNP = zzh("place_is_logging_enabled", false);
        this.zzaMO = zzI("place_id", "");
    }

    private void zzdW(String str) {
        if (this.zzaNP && this.zzaNS != null) {
            this.zzaNS.zzH(this.zzaMO, str);
        }
    }

    public /* synthetic */ Object freeze() {
        return zzyK();
    }

    public CharSequence getAddress() {
        zzdW("getAddress");
        return zzI("place_address", "");
    }

    public String getId() {
        zzdW("getId");
        return this.zzaMO;
    }

    public LatLng getLatLng() {
        zzdW("getLatLng");
        return (LatLng) zza("place_lat_lng", LatLng.CREATOR);
    }

    public Locale getLocale() {
        zzdW("getLocale");
        Object zzI = zzI("place_locale", "");
        return !TextUtils.isEmpty(zzI) ? new Locale(zzI) : Locale.getDefault();
    }

    public CharSequence getName() {
        zzdW("getName");
        return zzI("place_name", "");
    }

    public CharSequence getPhoneNumber() {
        zzdW("getPhoneNumber");
        return zzI("place_phone_number", "");
    }

    public List<Integer> getPlaceTypes() {
        zzdW("getPlaceTypes");
        return zza("place_types", Collections.emptyList());
    }

    public int getPriceLevel() {
        zzdW("getPriceLevel");
        return zzz("place_price_level", -1);
    }

    public float getRating() {
        zzdW("getRating");
        return zzb("place_rating", -1.0f);
    }

    public LatLngBounds getViewport() {
        zzdW("getViewport");
        return (LatLngBounds) zza("place_viewport", LatLngBounds.CREATOR);
    }

    public Uri getWebsiteUri() {
        zzdW("getWebsiteUri");
        String zzI = zzI("place_website_uri", null);
        return zzI == null ? null : Uri.parse(zzI);
    }

    public float zzyC() {
        zzdW("getLevelNumber");
        return zzb("place_level_number", 0.0f);
    }

    public boolean zzyF() {
        zzdW("isPermanentlyClosed");
        return zzh("place_is_permanently_closed", false);
    }

    public Place zzyK() {
        zza zzak = new zza().zzak(this.zzaNP);
        this.zzaNP = false;
        Place zzyL = zzak.zzdZ(getAddress().toString()).zzw(zzb("place_attributions", Collections.emptyList())).zzdX(getId()).zzaj(zzyF()).zza(getLatLng()).zzf(zzyC()).zzdY(getName().toString()).zzea(getPhoneNumber().toString()).zzhM(getPriceLevel()).zzg(getRating()).zzv(getPlaceTypes()).zza(getViewport()).zzo(getWebsiteUri()).zzyL();
        zzyL.setLocale(getLocale());
        zzyL.zza(this.zzaNS);
        return zzyL;
    }
}
