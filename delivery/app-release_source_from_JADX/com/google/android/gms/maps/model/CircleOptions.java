package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private LatLng zzaQe;
    private double zzaQf;
    private float zzaQg;
    private int zzaQh;
    private int zzaQi;
    private float zzaQj;
    private boolean zzaQk;

    public CircleOptions() {
        this.zzaQe = null;
        this.zzaQf = 0.0d;
        this.zzaQg = 10.0f;
        this.zzaQh = ViewCompat.MEASURED_STATE_MASK;
        this.zzaQi = 0;
        this.zzaQj = 0.0f;
        this.zzaQk = true;
        this.mVersionCode = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.zzaQe = null;
        this.zzaQf = 0.0d;
        this.zzaQg = 10.0f;
        this.zzaQh = ViewCompat.MEASURED_STATE_MASK;
        this.zzaQi = 0;
        this.zzaQj = 0.0f;
        this.zzaQk = true;
        this.mVersionCode = versionCode;
        this.zzaQe = center;
        this.zzaQf = radius;
        this.zzaQg = strokeWidth;
        this.zzaQh = strokeColor;
        this.zzaQi = fillColor;
        this.zzaQj = zIndex;
        this.zzaQk = visible;
    }

    public CircleOptions center(LatLng center) {
        this.zzaQe = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.zzaQi = color;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaQe;
    }

    public int getFillColor() {
        return this.zzaQi;
    }

    public double getRadius() {
        return this.zzaQf;
    }

    public int getStrokeColor() {
        return this.zzaQh;
    }

    public float getStrokeWidth() {
        return this.zzaQg;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaQj;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public CircleOptions radius(double radius) {
        this.zzaQf = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.zzaQh = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.zzaQg = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.zzaQk = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public CircleOptions zIndex(float zIndex) {
        this.zzaQj = zIndex;
        return this;
    }
}
