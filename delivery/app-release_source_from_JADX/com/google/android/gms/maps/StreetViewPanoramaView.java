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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama zzaPA;
    private final zzb zzaPM;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        private final List<OnStreetViewPanoramaReadyCallback> zzaPE = new ArrayList();
        private final StreetViewPanoramaOptions zzaPQ;
        protected zzf<zza> zzaPj;
        private final ViewGroup zzaPq;

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.zzaPq = viewGroup;
            this.mContext = context;
            this.zzaPQ = streetViewPanoramaOptions;
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (zzts() != null) {
                ((zza) zzts()).getStreetViewPanoramaAsync(callback);
            } else {
                this.zzaPE.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaView_zza) {
            this.zzaPj = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaView_zza;
            zzzh();
        }

        public void zzzh() {
            if (this.zzaPj != null && zzts() == null) {
                try {
                    this.zzaPj.zza(new zza(this.zzaPq, zzy.zzaP(this.mContext).zza(zze.zzB(this.mContext), this.zzaPQ)));
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
        private final IStreetViewPanoramaViewDelegate zzaPN;
        private View zzaPO;
        private final ViewGroup zzaPm;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.zzaPN = (IStreetViewPanoramaViewDelegate) zzx.zzy(iStreetViewPanoramaViewDelegate);
            this.zzaPm = (ViewGroup) zzx.zzy(viewGroup);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaPN.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzv.zza(this) {
                    final /* synthetic */ zza zzaPP;

                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaPN.onCreate(savedInstanceState);
                this.zzaPO = (View) zze.zzp(this.zzaPN.getView());
                this.zzaPm.removeAllViews();
                this.zzaPm.addView(this.zzaPO);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaPN.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaPN.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaPN.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaPN.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaPN.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaViewDelegate zzzo() {
            return this.zzaPN;
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.zzaPM = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaPM = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaPM = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.zzaPM = new zzb(this, context, options);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.zzaPA != null) {
            return this.zzaPA;
        }
        this.zzaPM.zzzh();
        if (this.zzaPM.zzts() == null) {
            return null;
        }
        try {
            this.zzaPA = new StreetViewPanorama(((zza) this.zzaPM.zzts()).zzzo().getStreetViewPanorama());
            return this.zzaPA;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        zzx.zzcx("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaPM.getStreetViewPanoramaAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaPM.onCreate(savedInstanceState);
        if (this.zzaPM.zzts() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaPM.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaPM.onLowMemory();
    }

    public final void onPause() {
        this.zzaPM.onPause();
    }

    public final void onResume() {
        this.zzaPM.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaPM.onSaveInstanceState(outState);
    }
}
