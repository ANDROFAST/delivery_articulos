package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private GoogleMap zzaPf;
    private final zzb zzaPl;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaPj;
        private final List<OnMapReadyCallback> zzaPk = new ArrayList();
        private final ViewGroup zzaPq;
        private final GoogleMapOptions zzaPr;

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.zzaPq = viewGroup;
            this.mContext = context;
            this.zzaPr = googleMapOptions;
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (zzts() != null) {
                ((zza) zzts()).getMapAsync(callback);
            } else {
                this.zzaPk.add(callback);
            }
        }

        public void onEnterAmbient(Bundle ambientDetails) {
            if (zzts() != null) {
                ((zza) zzts()).onEnterAmbient(ambientDetails);
            }
        }

        public void onExitAmbient() {
            if (zzts() != null) {
                ((zza) zzts()).onExitAmbient();
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza) {
            this.zzaPj = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza;
            zzzh();
        }

        public void zzzh() {
            if (this.zzaPj != null && zzts() == null) {
                try {
                    MapsInitializer.initialize(this.mContext);
                    IMapViewDelegate zza = zzy.zzaP(this.mContext).zza(zze.zzB(this.mContext), this.zzaPr);
                    if (zza != null) {
                        this.zzaPj.zza(new zza(this.zzaPq, zza));
                        for (OnMapReadyCallback mapAsync : this.zzaPk) {
                            ((zza) zzts()).getMapAsync(mapAsync);
                        }
                        this.zzaPk.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    static class zza implements MapLifecycleDelegate {
        private final ViewGroup zzaPm;
        private final IMapViewDelegate zzaPn;
        private View zzaPo;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.zzaPn = (IMapViewDelegate) zzx.zzy(iMapViewDelegate);
            this.zzaPm = (ViewGroup) zzx.zzy(viewGroup);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzaPn.getMapAsync(new com.google.android.gms.maps.internal.zzl.zza(this) {
                    final /* synthetic */ zza zzaPp;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaPn.onCreate(savedInstanceState);
                this.zzaPo = (View) zze.zzp(this.zzaPn.getView());
                this.zzaPm.removeAllViews();
                this.zzaPm.addView(this.zzaPo);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaPn.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onEnterAmbient(Bundle ambientDetails) {
            try {
                this.zzaPn.onEnterAmbient(ambientDetails);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onExitAmbient() {
            try {
                this.zzaPn.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaPn.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaPn.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaPn.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaPn.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapViewDelegate zzzi() {
            return this.zzaPn;
        }
    }

    public MapView(Context context) {
        super(context);
        this.zzaPl = new zzb(this, context, null);
        init();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaPl = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
        init();
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaPl = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
        init();
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.zzaPl = new zzb(this, context, options);
        init();
    }

    private void init() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.zzaPf != null) {
            return this.zzaPf;
        }
        this.zzaPl.zzzh();
        if (this.zzaPl.zzts() == null) {
            return null;
        }
        try {
            this.zzaPf = new GoogleMap(((zza) this.zzaPl.zzts()).zzzi().getMap());
            return this.zzaPf;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        zzx.zzcx("getMapAsync() must be called on the main thread");
        this.zzaPl.getMapAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaPl.onCreate(savedInstanceState);
        if (this.zzaPl.zzts() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaPl.onDestroy();
    }

    public final void onEnterAmbient(Bundle ambientDetails) {
        zzx.zzcx("onEnterAmbient() must be called on the main thread");
        this.zzaPl.onEnterAmbient(ambientDetails);
    }

    public final void onExitAmbient() {
        zzx.zzcx("onExitAmbient() must be called on the main thread");
        this.zzaPl.onExitAmbient();
    }

    public final void onLowMemory() {
        this.zzaPl.onLowMemory();
    }

    public final void onPause() {
        this.zzaPl.onPause();
    }

    public final void onResume() {
        this.zzaPl.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaPl.onSaveInstanceState(outState);
    }
}
