package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate zzaOx;

    private CameraUpdateFactory() {
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(zzyT().newCameraPosition(cameraPosition));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        try {
            return new CameraUpdate(zzyT().newLatLng(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds bounds, int padding) {
        try {
            return new CameraUpdate(zzyT().newLatLngBounds(bounds, padding));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds bounds, int width, int height, int padding) {
        try {
            return new CameraUpdate(zzyT().newLatLngBoundsWithSize(bounds, width, height, padding));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float zoom) {
        try {
            return new CameraUpdate(zzyT().newLatLngZoom(latLng, zoom));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate scrollBy(float xPixel, float yPixel) {
        try {
            return new CameraUpdate(zzyT().scrollBy(xPixel, yPixel));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomBy(float amount) {
        try {
            return new CameraUpdate(zzyT().zoomBy(amount));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomBy(float amount, Point focus) {
        try {
            return new CameraUpdate(zzyT().zoomByWithFocus(amount, focus.x, focus.y));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(zzyT().zoomIn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(zzyT().zoomOut());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomTo(float zoom) {
        try {
            return new CameraUpdate(zzyT().zoomTo(zoom));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void zza(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        zzaOx = (ICameraUpdateFactoryDelegate) zzx.zzy(iCameraUpdateFactoryDelegate);
    }

    private static ICameraUpdateFactoryDelegate zzyT() {
        return (ICameraUpdateFactoryDelegate) zzx.zzb(zzaOx, (Object) "CameraUpdateFactory is not initialized");
    }
}
