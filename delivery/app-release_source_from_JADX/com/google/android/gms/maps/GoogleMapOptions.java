package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private Boolean zzaOR;
    private Boolean zzaOS;
    private int zzaOT;
    private CameraPosition zzaOU;
    private Boolean zzaOV;
    private Boolean zzaOW;
    private Boolean zzaOX;
    private Boolean zzaOY;
    private Boolean zzaOZ;
    private Boolean zzaPa;
    private Boolean zzaPb;
    private Boolean zzaPc;
    private Boolean zzaPd;

    public GoogleMapOptions() {
        this.zzaOT = -1;
        this.mVersionCode = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled, byte liteMode, byte mapToolbarEnabled, byte ambientEnabled) {
        this.zzaOT = -1;
        this.mVersionCode = versionCode;
        this.zzaOR = zza.zza(zOrderOnTop);
        this.zzaOS = zza.zza(useViewLifecycleInFragment);
        this.zzaOT = mapType;
        this.zzaOU = camera;
        this.zzaOV = zza.zza(zoomControlsEnabled);
        this.zzaOW = zza.zza(compassEnabled);
        this.zzaOX = zza.zza(scrollGesturesEnabled);
        this.zzaOY = zza.zza(zoomGesturesEnabled);
        this.zzaOZ = zza.zza(tiltGesturesEnabled);
        this.zzaPa = zza.zza(rotateGesturesEnabled);
        this.zzaPb = zza.zza(liteMode);
        this.zzaPc = zza.zza(mapToolbarEnabled);
        this.zzaPd = zza.zza(ambientEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions ambientEnabled(boolean enabled) {
        this.zzaPd = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.zzaOU = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.zzaOW = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getAmbientEnabled() {
        return this.zzaPd;
    }

    public CameraPosition getCamera() {
        return this.zzaOU;
    }

    public Boolean getCompassEnabled() {
        return this.zzaOW;
    }

    public Boolean getLiteMode() {
        return this.zzaPb;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaPc;
    }

    public int getMapType() {
        return this.zzaOT;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaPa;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaOX;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaOZ;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaOS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaOR;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaOV;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaOY;
    }

    public GoogleMapOptions liteMode(boolean enabled) {
        this.zzaPb = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean enabled) {
        this.zzaPc = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.zzaOT = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.zzaPa = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.zzaOX = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.zzaOZ = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzaOS = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.zzaOR = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.zzaOV = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.zzaOY = Boolean.valueOf(enabled);
        return this;
    }

    byte zzyV() {
        return zza.zze(this.zzaOR);
    }

    byte zzyW() {
        return zza.zze(this.zzaOS);
    }

    byte zzyX() {
        return zza.zze(this.zzaOV);
    }

    byte zzyY() {
        return zza.zze(this.zzaOW);
    }

    byte zzyZ() {
        return zza.zze(this.zzaOX);
    }

    byte zzza() {
        return zza.zze(this.zzaOY);
    }

    byte zzzb() {
        return zza.zze(this.zzaOZ);
    }

    byte zzzc() {
        return zza.zze(this.zzaPa);
    }

    byte zzzd() {
        return zza.zze(this.zzaPb);
    }

    byte zzze() {
        return zza.zze(this.zzaPc);
    }

    byte zzzf() {
        return zza.zze(this.zzaPd);
    }
}
