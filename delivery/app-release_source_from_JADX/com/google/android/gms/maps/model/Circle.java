package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzb;

public final class Circle {
    private final zzb zzaQd;

    public Circle(zzb delegate) {
        this.zzaQd = (zzb) zzx.zzy(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Circle)) {
            return false;
        }
        try {
            return this.zzaQd.zza(((Circle) other).zzaQd);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getCenter() {
        try {
            return this.zzaQd.getCenter();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFillColor() {
        try {
            return this.zzaQd.getFillColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.zzaQd.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public double getRadius() {
        try {
            return this.zzaQd.getRadius();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zzaQd.getStrokeColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zzaQd.getStrokeWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQd.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQd.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQd.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.zzaQd.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCenter(LatLng center) {
        try {
            this.zzaQd.setCenter(center);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFillColor(int color) {
        try {
            this.zzaQd.setFillColor(color);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRadius(double radius) {
        try {
            this.zzaQd.setRadius(radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int color) {
        try {
            this.zzaQd.setStrokeColor(color);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float width) {
        try {
            this.zzaQd.setStrokeWidth(width);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.zzaQd.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float zIndex) {
        try {
            this.zzaQd.setZIndex(zIndex);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
