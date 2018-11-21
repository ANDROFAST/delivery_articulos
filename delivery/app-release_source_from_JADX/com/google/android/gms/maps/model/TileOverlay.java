package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzh;

public final class TileOverlay {
    private final zzh zzaQQ;

    public TileOverlay(zzh delegate) {
        this.zzaQQ = (zzh) zzx.zzy(delegate);
    }

    public void clearTileCache() {
        try {
            this.zzaQQ.clearTileCache();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.zzaQQ.zza(((TileOverlay) other).zzaQQ);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean getFadeIn() {
        try {
            return this.zzaQQ.getFadeIn();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.zzaQQ.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQQ.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQQ.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQQ.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.zzaQQ.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFadeIn(boolean fadeIn) {
        try {
            this.zzaQQ.setFadeIn(fadeIn);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.zzaQQ.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float zIndex) {
        try {
            this.zzaQQ.setZIndex(zIndex);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
