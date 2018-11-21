package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private float mAlpha;
    private final int mVersionCode;
    private LatLng zzaPH;
    private String zzaQB;
    private BitmapDescriptor zzaQC;
    private boolean zzaQD;
    private boolean zzaQE;
    private float zzaQF;
    private float zzaQG;
    private float zzaQH;
    private boolean zzaQk;
    private float zzaQs;
    private float zzaQt;
    private String zzank;

    public MarkerOptions() {
        this.zzaQs = 0.5f;
        this.zzaQt = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.zzaQk = true;
        this.zzaQE = false;
        this.zzaQF = 0.0f;
        this.zzaQG = 0.5f;
        this.zzaQH = 0.0f;
        this.mAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mVersionCode = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.zzaQs = 0.5f;
        this.zzaQt = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.zzaQk = true;
        this.zzaQE = false;
        this.zzaQF = 0.0f;
        this.zzaQG = 0.5f;
        this.zzaQH = 0.0f;
        this.mAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.mVersionCode = versionCode;
        this.zzaPH = position;
        this.zzank = title;
        this.zzaQB = snippet;
        this.zzaQC = wrappedIcon == null ? null : new BitmapDescriptor(zza.zzbs(wrappedIcon));
        this.zzaQs = anchorU;
        this.zzaQt = anchorV;
        this.zzaQD = draggable;
        this.zzaQk = visible;
        this.zzaQE = flat;
        this.zzaQF = rotation;
        this.zzaQG = infoWindowAnchorU;
        this.zzaQH = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.zzaQs = u;
        this.zzaQt = v;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.zzaQD = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.zzaQE = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.zzaQs;
    }

    public float getAnchorV() {
        return this.zzaQt;
    }

    public BitmapDescriptor getIcon() {
        return this.zzaQC;
    }

    public float getInfoWindowAnchorU() {
        return this.zzaQG;
    }

    public float getInfoWindowAnchorV() {
        return this.zzaQH;
    }

    public LatLng getPosition() {
        return this.zzaPH;
    }

    public float getRotation() {
        return this.zzaQF;
    }

    public String getSnippet() {
        return this.zzaQB;
    }

    public String getTitle() {
        return this.zzank;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.zzaQC = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.zzaQG = u;
        this.zzaQH = v;
        return this;
    }

    public boolean isDraggable() {
        return this.zzaQD;
    }

    public boolean isFlat() {
        return this.zzaQE;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public MarkerOptions position(LatLng position) {
        this.zzaPH = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.zzaQF = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.zzaQB = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.zzank = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.zzaQk = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    IBinder zzzv() {
        return this.zzaQC == null ? null : this.zzaQC.zzyS().asBinder();
    }
}
