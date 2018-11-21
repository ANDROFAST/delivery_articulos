package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T zzatr;
    private Bundle zzats;
    private LinkedList<zza> zzatt;
    private final zzf<T> zzatu = new C06581(this);

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    class C06581 implements zzf<T> {
        final /* synthetic */ zza zzatv;

        C06581(zza com_google_android_gms_dynamic_zza) {
            this.zzatv = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.zzatv.zzatr = t;
            Iterator it = this.zzatv.zzatt.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzatv.zzatr);
            }
            this.zzatv.zzatt.clear();
            this.zzatv.zzats = null;
        }
    }

    class C06626 implements zza {
        final /* synthetic */ zza zzatv;

        C06626(zza com_google_android_gms_dynamic_zza) {
            this.zzatv = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzatv.zzatr.onStart();
        }
    }

    class C06637 implements zza {
        final /* synthetic */ zza zzatv;

        C06637(zza com_google_android_gms_dynamic_zza) {
            this.zzatv = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzatv.zzatr.onResume();
        }
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.zzatr != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.zzatr);
            return;
        }
        if (this.zzatt == null) {
            this.zzatt = new LinkedList();
        }
        this.zzatt.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.zzats == null) {
                this.zzats = (Bundle) bundle.clone();
            } else {
                this.zzats.putAll(bundle);
            }
        }
        zza(this.zzatu);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zzc = zzg.zzc(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzam(context));
        CharSequence zzh = zzg.zzh(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.zzbv(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzeF(int i) {
        while (!this.zzatt.isEmpty() && ((zza) this.zzatt.getLast()).getState() >= i) {
            this.zzatt.removeLast();
        }
    }

    public void onCreate(final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzatv;

            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzatv.zzatr.onCreate(savedInstanceState);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzatv;

            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.zzatv.zzatr.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzatr == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzatr != null) {
            this.zzatr.onDestroy();
        } else {
            zzeF(1);
        }
    }

    public void onDestroyView() {
        if (this.zzatr != null) {
            this.zzatr.onDestroyView();
        } else {
            zzeF(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzatv;

            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzatv.zzatr.onInflate(activity, attrs, savedInstanceState);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzatr != null) {
            this.zzatr.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzatr != null) {
            this.zzatr.onPause();
        } else {
            zzeF(5);
        }
    }

    public void onResume() {
        zza(null, new C06637(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzatr != null) {
            this.zzatr.onSaveInstanceState(outState);
        } else if (this.zzats != null) {
            outState.putAll(this.zzats);
        }
    }

    public void onStart() {
        zza(null, new C06626(this));
    }

    public void onStop() {
        if (this.zzatr != null) {
            this.zzatr.onStop();
        } else {
            zzeF(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public T zzts() {
        return this.zzatr;
    }
}
