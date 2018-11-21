package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private Boolean zzaOS;
    private Boolean zzaOY;
    private StreetViewPanoramaCamera zzaPF;
    private String zzaPG;
    private LatLng zzaPH;
    private Integer zzaPI;
    private Boolean zzaPJ;
    private Boolean zzaPK;
    private Boolean zzaPL;

    public StreetViewPanoramaOptions() {
        this.zzaPJ = Boolean.valueOf(true);
        this.zzaOY = Boolean.valueOf(true);
        this.zzaPK = Boolean.valueOf(true);
        this.zzaPL = Boolean.valueOf(true);
        this.mVersionCode = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.zzaPJ = Boolean.valueOf(true);
        this.zzaOY = Boolean.valueOf(true);
        this.zzaPK = Boolean.valueOf(true);
        this.zzaPL = Boolean.valueOf(true);
        this.mVersionCode = versionCode;
        this.zzaPF = camera;
        this.zzaPH = position;
        this.zzaPI = radius;
        this.zzaPG = panoId;
        this.zzaPJ = zza.zza(userNavigationEnabled);
        this.zzaOY = zza.zza(zoomGesturesEnabled);
        this.zzaPK = zza.zza(panningGesturesEnabled);
        this.zzaPL = zza.zza(streetNamesEnabled);
        this.zzaOS = zza.zza(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaPK;
    }

    public String getPanoramaId() {
        return this.zzaPG;
    }

    public LatLng getPosition() {
        return this.zzaPH;
    }

    public Integer getRadius() {
        return this.zzaPI;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaPL;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaPF;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaOS;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaPJ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaOY;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.zzaPK = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.zzaPF = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.zzaPG = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.zzaPH = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.zzaPH = position;
        this.zzaPI = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.zzaPL = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzaOS = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.zzaPJ = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.zzaOY = Boolean.valueOf(enabled);
        return this;
    }

    byte zzyW() {
        return zza.zze(this.zzaOS);
    }

    byte zzza() {
        return zza.zze(this.zzaOY);
    }

    byte zzzl() {
        return zza.zze(this.zzaPJ);
    }

    byte zzzm() {
        return zza.zze(this.zzaPK);
    }

    byte zzzn() {
        return zza.zze(this.zzaPL);
    }
}
