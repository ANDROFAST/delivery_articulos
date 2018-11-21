package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;
    private final int mVersionCode;
    private float zzaQc;
    private float zzaQj;
    private boolean zzaQk;
    private BitmapDescriptor zzaQm;
    private LatLng zzaQn;
    private float zzaQo;
    private float zzaQp;
    private LatLngBounds zzaQq;
    private float zzaQr;
    private float zzaQs;
    private float zzaQt;

    public GroundOverlayOptions() {
        this.zzaQk = true;
        this.zzaQr = 0.0f;
        this.zzaQs = 0.5f;
        this.zzaQt = 0.5f;
        this.mVersionCode = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.zzaQk = true;
        this.zzaQr = 0.0f;
        this.zzaQs = 0.5f;
        this.zzaQt = 0.5f;
        this.mVersionCode = versionCode;
        this.zzaQm = new BitmapDescriptor(zza.zzbs(wrappedImage));
        this.zzaQn = location;
        this.zzaQo = width;
        this.zzaQp = height;
        this.zzaQq = bounds;
        this.zzaQc = bearing;
        this.zzaQj = zIndex;
        this.zzaQk = visible;
        this.zzaQr = transparency;
        this.zzaQs = anchorU;
        this.zzaQt = anchorV;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzaQn = latLng;
        this.zzaQo = f;
        this.zzaQp = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.zzaQs = u;
        this.zzaQt = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.zzaQc = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzaQs;
    }

    public float getAnchorV() {
        return this.zzaQt;
    }

    public float getBearing() {
        return this.zzaQc;
    }

    public LatLngBounds getBounds() {
        return this.zzaQq;
    }

    public float getHeight() {
        return this.zzaQp;
    }

    public BitmapDescriptor getImage() {
        return this.zzaQm;
    }

    public LatLng getLocation() {
        return this.zzaQn;
    }

    public float getTransparency() {
        return this.zzaQr;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getWidth() {
        return this.zzaQo;
    }

    public float getZIndex() {
        return this.zzaQj;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.zzaQm = image;
        return this;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        zzx.zza(this.zzaQq == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Width must be non-negative");
        return zza(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        zzx.zza(this.zzaQq == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(location != null, (Object) "Location must be specified");
        zzx.zzb(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Height must be non-negative");
        return zza(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        zzx.zza(this.zzaQn == null, "Position has already been set using position: " + this.zzaQn);
        this.zzaQq = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= TextTrackStyle.DEFAULT_FONT_SCALE;
        zzx.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.zzaQr = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.zzaQk = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.zzaQj = zIndex;
        return this;
    }

    IBinder zzzu() {
        return this.zzaQm.zzyS().asBinder();
    }
}
