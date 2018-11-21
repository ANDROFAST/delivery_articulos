package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private final List<LatLng> zzaQL;
    private final List<List<LatLng>> zzaQM;
    private boolean zzaQN;
    private float zzaQg;
    private int zzaQh;
    private int zzaQi;
    private float zzaQj;
    private boolean zzaQk;

    public PolygonOptions() {
        this.zzaQg = 10.0f;
        this.zzaQh = ViewCompat.MEASURED_STATE_MASK;
        this.zzaQi = 0;
        this.zzaQj = 0.0f;
        this.zzaQk = true;
        this.zzaQN = false;
        this.mVersionCode = 1;
        this.zzaQL = new ArrayList();
        this.zzaQM = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.zzaQg = 10.0f;
        this.zzaQh = ViewCompat.MEASURED_STATE_MASK;
        this.zzaQi = 0;
        this.zzaQj = 0.0f;
        this.zzaQk = true;
        this.zzaQN = false;
        this.mVersionCode = versionCode;
        this.zzaQL = points;
        this.zzaQM = holes;
        this.zzaQg = strokeWidth;
        this.zzaQh = strokeColor;
        this.zzaQi = fillColor;
        this.zzaQj = zIndex;
        this.zzaQk = visible;
        this.zzaQN = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.zzaQL.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.zzaQL.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.zzaQL.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.zzaQM.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.zzaQi = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.zzaQN = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.zzaQi;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzaQM;
    }

    public List<LatLng> getPoints() {
        return this.zzaQL;
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

    public boolean isGeodesic() {
        return this.zzaQN;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public PolygonOptions strokeColor(int color) {
        this.zzaQh = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.zzaQg = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.zzaQk = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public PolygonOptions zIndex(float zIndex) {
        this.zzaQj = zIndex;
        return this;
    }

    List zzzw() {
        return this.zzaQM;
    }
}
