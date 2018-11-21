package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzg;
import java.util.List;

public final class Polygon {
    private final zzg zzaQK;

    public Polygon(zzg delegate) {
        this.zzaQK = (zzg) zzx.zzy(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Polygon)) {
            return false;
        }
        try {
            return this.zzaQK.zza(((Polygon) other).zzaQK);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFillColor() {
        try {
            return this.zzaQK.getFillColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<List<LatLng>> getHoles() {
        try {
            return this.zzaQK.getHoles();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.zzaQK.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.zzaQK.getPoints();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zzaQK.getStrokeColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zzaQK.getStrokeWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQK.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQK.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zzaQK.isGeodesic();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQK.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.zzaQK.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFillColor(int color) {
        try {
            this.zzaQK.setFillColor(color);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeodesic(boolean geodesic) {
        try {
            this.zzaQK.setGeodesic(geodesic);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setHoles(List<? extends List<LatLng>> holes) {
        try {
            this.zzaQK.setHoles(holes);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> points) {
        try {
            this.zzaQK.setPoints(points);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int color) {
        try {
            this.zzaQK.setStrokeColor(color);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float width) {
        try {
            this.zzaQK.setStrokeWidth(width);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.zzaQK.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float zIndex) {
        try {
            this.zzaQK.setZIndex(zIndex);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
