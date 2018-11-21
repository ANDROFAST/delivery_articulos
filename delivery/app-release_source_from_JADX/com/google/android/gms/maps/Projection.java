package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate zzaPs;

    Projection(IProjectionDelegate delegate) {
        this.zzaPs = delegate;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.zzaPs.fromScreenLocation(zze.zzB(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.zzaPs.getVisibleRegion();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng location) {
        try {
            return (Point) zze.zzp(this.zzaPs.toScreenLocation(location));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
