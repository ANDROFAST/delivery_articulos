package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaFragment extends Fragment {
    private StreetViewPanorama zzaPA;
    private final zzb zzaPz = new zzb(this);

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        private final List<OnStreetViewPanoramaReadyCallback> zzaPE = new ArrayList();
        protected zzf<zza> zzaPj;
        private final Fragment zzatC;

        zzb(Fragment fragment) {
            this.zzatC = fragment;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
            zzzh();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (zzts() != null) {
                ((zza) zzts()).getStreetViewPanoramaAsync(callback);
            } else {
                this.zzaPE.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaFragment_zza) {
            this.zzaPj = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaFragment_zza;
            zzzh();
        }

        public void zzzh() {
            if (this.mActivity != null && this.zzaPj != null && zzts() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    this.zzaPj.zza(new zza(this.zzatC, zzy.zzaP(this.mActivity).zzu(zze.zzB(this.mActivity))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.zzaPE) {
                        ((zza) zzts()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.zzaPE.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final IStreetViewPanoramaFragmentDelegate zzaPB;
        private final Fragment zzatC;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.zzaPB = (IStreetViewPanoramaFragmentDelegate) zzx.zzy(iStreetViewPanoramaFragmentDelegate);
            this.zzatC = (Fragment) zzx.zzy(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaPB.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzv.zza(this) {
                    final /* synthetic */ zza zzaPD;

                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
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
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                com.google.android.gms.maps.internal.zzx.zza(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.zzaPB.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzaPB.onCreateView(zze.zzB(inflater), zze.zzB(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaPB.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaPB.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaPB.onInflate(zze.zzB(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaPB.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaPB.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaPB.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaPB.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaFragmentDelegate zzzk() {
            return this.zzaPB;
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate zzzk = zzzk();
        if (zzzk == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = zzzk.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.zzaPA == null || this.zzaPA.zzzj().asBinder() != streetViewPanorama.asBinder()) {
                this.zzaPA = new StreetViewPanorama(streetViewPanorama);
            }
            return this.zzaPA;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        zzx.zzcx("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaPz.getStreetViewPanoramaAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaPz.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaPz.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaPz.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.zzaPz.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaPz.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaPz.setActivity(activity);
        this.zzaPz.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaPz.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaPz.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaPz.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaPz.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IStreetViewPanoramaFragmentDelegate zzzk() {
        this.zzaPz.zzzh();
        return this.zzaPz.zzts() == null ? null : ((zza) this.zzaPz.zzts()).zzzk();
    }
}
