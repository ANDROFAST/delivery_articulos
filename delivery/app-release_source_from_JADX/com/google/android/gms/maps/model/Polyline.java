package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

public final class Polyline {
    private final IPolylineDelegate zzaQO;

    public Polyline(IPolylineDelegate delegate) {
        this.zzaQO = (IPolylineDelegate) zzx.zzy(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Polyline)) {
            return false;
        }
        try {
            return this.zzaQO.equalsRemote(((Polyline) other).zzaQO);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getColor() {
        try {
            return this.zzaQO.getColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.zzaQO.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.zzaQO.getPoints();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.zzaQO.getWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQO.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQO.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zzaQO.isGeodesic();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQO.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.zzaQO.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setColor(int color) {
        try {
            this.zzaQO.setColor(color);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeodesic(boolean geodesic) {
        try {
            this.zzaQO.setGeodesic(geodesic);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> points) {
        try {
            this.zzaQO.setPoints(points);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.zzaQO.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float width) {
        try {
            this.zzaQO.setWidth(width);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float zIndex) {
        try {
            this.zzaQO.setZIndex(zIndex);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
