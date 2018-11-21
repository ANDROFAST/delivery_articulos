package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzh;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaOy;
    private UiSettings zzaOz;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzaOQ;

        zza(CancelableCallback cancelableCallback) {
            this.zzaOQ = cancelableCallback;
        }

        public void onCancel() {
            this.zzaOQ.onCancel();
        }

        public void onFinish() {
            this.zzaOQ.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.zzaOy = (IGoogleMapDelegate) zzx.zzy(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.zzaOy.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            zzc addGroundOverlay = this.zzaOy.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            zzf addMarker = this.zzaOy.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.zzaOy.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.zzaOy.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            zzh addTileOverlay = this.zzaOy.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.zzaOy.animateCamera(update.zzyS());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.zzaOy.animateCameraWithDurationAndCallback(update.zzyS(), durationMs, callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.zzaOy.animateCameraWithCallback(update.zzyS(), callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzaOy.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaOy.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.zzaOy.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaOy.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaOy.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaOy.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaOy.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaOy.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaOz == null) {
                this.zzaOz = new UiSettings(this.zzaOy.getUiSettings());
            }
            return this.zzaOz;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaOy.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaOy.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaOy.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaOy.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.zzaOy.moveCamera(update.zzyS());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.zzaOy.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.zzaOy.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.zzaOy.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.zzaOy.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public com.google.android.gms.dynamic.zzd zzf(zzf com_google_android_gms_maps_model_internal_zzf) {
                return zze.zzB(adapter.getInfoWindow(new Marker(com_google_android_gms_maps_model_internal_zzf)));
            }

            public com.google.android.gms.dynamic.zzd zzg(zzf com_google_android_gms_maps_model_internal_zzf) {
                return zze.zzB(adapter.getInfoContents(new Marker(com_google_android_gms_maps_model_internal_zzf)));
            }
        });
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.zzaOy.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setLocationSource(new com.google.android.gms.maps.internal.ILocationSourceDelegate.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void activate(final com.google.android.gms.maps.internal.zzh listener) {
                source.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ C11576 zzaOI;

                    public void onLocationChanged(Location location) {
                        try {
                            listener.zzd(location);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                source.deactivate();
            }
        });
    }

    public final void setMapType(int type) {
        try {
            this.zzaOy.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.zzaOy.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zze.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void onCameraChange(CameraPosition position) {
                listener.onCameraChange(position);
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnIndoorStateChangeListener(new com.google.android.gms.maps.internal.zzf.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void onIndoorBuildingFocused() {
                listener.onIndoorBuildingFocused();
            }

            public void zza(zzd com_google_android_gms_maps_model_internal_zzd) {
                listener.onIndoorLevelActivated(new IndoorBuilding(com_google_android_gms_maps_model_internal_zzd));
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.zzg.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void zze(zzf com_google_android_gms_maps_model_internal_zzf) {
                listener.onInfoWindowClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMapClickListener(new com.google.android.gms.maps.internal.zzi.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void onMapClick(LatLng point) {
                listener.onMapClick(point);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.zzaOy.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMapLoadedCallback(new com.google.android.gms.maps.internal.zzj.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void onMapLoaded() throws RemoteException {
                callback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMapLongClickListener(new com.google.android.gms.maps.internal.zzk.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void onMapLongClick(LatLng point) {
                listener.onMapLongClick(point);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMarkerClickListener(new com.google.android.gms.maps.internal.zzm.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public boolean zza(zzf com_google_android_gms_maps_model_internal_zzf) {
                return listener.onMarkerClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMarkerDragListener(new com.google.android.gms.maps.internal.zzn.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void zzb(zzf com_google_android_gms_maps_model_internal_zzf) {
                listener.onMarkerDragStart(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }

            public void zzc(zzf com_google_android_gms_maps_model_internal_zzf) {
                listener.onMarkerDragEnd(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }

            public void zzd(zzf com_google_android_gms_maps_model_internal_zzf) {
                listener.onMarkerDrag(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMyLocationButtonClickListener(new com.google.android.gms.maps.internal.zzo.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public boolean onMyLocationButtonClick() throws RemoteException {
                return listener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaOy.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaOy.setOnMyLocationChangeListener(new com.google.android.gms.maps.internal.zzp.zza(this) {
            final /* synthetic */ GoogleMap zzaOB;

            public void zzq(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd) {
                listener.onMyLocationChange((Location) zze.zzp(com_google_android_gms_dynamic_zzd));
            }
        });
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.zzaOy.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.zzaOy.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.zzaOy.snapshot(new com.google.android.gms.maps.internal.zzw.zza(this) {
                final /* synthetic */ GoogleMap zzaOB;

                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }

                public void zzr(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) zze.zzp(com_google_android_gms_dynamic_zzd));
                }
            }, (zze) (bitmap != null ? zze.zzB(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaOy.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate zzyU() {
        return this.zzaOy;
    }
}
