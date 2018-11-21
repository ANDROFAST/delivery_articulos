package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
    private final zzb zzaPe = new zzb(this);
    private GoogleMap zzaPf;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        protected zzf<zza> zzaPj;
        private final List<OnMapReadyCallback> zzaPk = new ArrayList();
        private final Fragment zzatC;

        zzb(Fragment fragment) {
            this.zzatC = fragment;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
            zzzh();
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

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapFragment_zza) {
            this.zzaPj = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapFragment_zza;
            zzzh();
        }

        public void zzzh() {
            if (this.mActivity != null && this.zzaPj != null && zzts() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    IMapFragmentDelegate zzt = zzy.zzaP(this.mActivity).zzt(zze.zzB(this.mActivity));
                    if (zzt != null) {
                        this.zzaPj.zza(new zza(this.zzatC, zzt));
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
        private final IMapFragmentDelegate zzaPg;
        private final Fragment zzatC;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zzaPg = (IMapFragmentDelegate) zzx.zzy(iMapFragmentDelegate);
            this.zzatC = (Fragment) zzx.zzy(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzaPg.getMapAsync(new com.google.android.gms.maps.internal.zzl.zza(this) {
                    final /* synthetic */ zza zzaPi;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzatC.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                com.google.android.gms.maps.internal.zzx.zza(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.zzaPg.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzaPg.onCreateView(zze.zzB(inflater), zze.zzB(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaPg.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaPg.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onEnterAmbient(Bundle ambientDetails) {
            try {
                this.zzaPg.onEnterAmbient(ambientDetails);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onExitAmbient() {
            try {
                this.zzaPg.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaPg.onInflate(zze.zzB(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaPg.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaPg.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaPg.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaPg.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapFragmentDelegate zzzg() {
            return this.zzaPg;
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate zzzg = zzzg();
        if (zzzg == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = zzzg.getMap();
            if (map == null) {
                return null;
            }
            if (this.zzaPf == null || this.zzaPf.zzyU().asBinder() != map.asBinder()) {
                this.zzaPf = new GoogleMap(map);
            }
            return this.zzaPf;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        zzx.zzcx("getMapAsync must be called on the main thread.");
        this.zzaPe.getMapAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaPe.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaPe.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View onCreateView = this.zzaPe.onCreateView(inflater, container, savedInstanceState);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.zzaPe.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaPe.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle ambientDetails) {
        zzx.zzcx("onEnterAmbient must be called on the main thread.");
        this.zzaPe.onEnterAmbient(ambientDetails);
    }

    public final void onExitAmbient() {
        zzx.zzcx("onExitAmbient must be called on the main thread.");
        this.zzaPe.onExitAmbient();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaPe.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.zzaPe.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaPe.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaPe.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaPe.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaPe.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IMapFragmentDelegate zzzg() {
        this.zzaPe.zzzh();
        return this.zzaPe.zzts() == null ? null : ((zza) this.zzaPe.zzts()).zzzg();
    }
}
