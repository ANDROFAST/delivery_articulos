package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

public class zzy extends zzw {
    private zza zzaUI;
    private com.google.android.gms.measurement.AppMeasurement.zza zzaUJ;
    private boolean zzaUK;

    private class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzy zzaUM;

        private zza(zzy com_google_android_gms_measurement_internal_zzy) {
            this.zzaUM = com_google_android_gms_measurement_internal_zzy;
        }

        private boolean zzeD(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.zzaUM.zza("auto", "_ldl", str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            try {
                this.zzaUM.zzzz().zzBr().zzez("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.zzaUM.zzzz().zzBq().zzj("Activity created with referrer", queryParameter);
                                zzeD(queryParameter);
                                return;
                            }
                            this.zzaUM.zzzz().zzBq().zzez("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.zzaUM.zzzz().zzBl().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzy(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private void zzBT() {
        try {
            zzg(Class.forName(zzBU()));
        } catch (ClassNotFoundException e) {
            zzzz().zzBp().zzez("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzBU() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void zza(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        zzx.zzcG(str);
        zzx.zzcG(str2);
        zzx.zzy(bundle);
        zziS();
        zzje();
        if (zzAW().zzzC()) {
            if (!this.zzaUK) {
                this.zzaUK = true;
                zzBT();
            }
            if (z && this.zzaUJ != null) {
                zzzz().zzBq().zze("Passing event to registered event handler (FE)", str2, bundle);
                this.zzaUJ.zze(str, str2, bundle);
                return;
            } else if (this.zzaQX.zzBz()) {
                zzzz().zzBq().zze("Logging event (FE)", str2, bundle);
                zzAT().zzb(new EventParcel(str2, new EventParams(bundle), str, j), str3);
                return;
            } else {
                return;
            }
        }
        zzzz().zzBp().zzez("Event not sent since app measurement is disabled");
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, String str3) {
        zzx.zzcG(str);
        final long currentTimeMillis = zziT().currentTimeMillis();
        zzAU().zzeE(str2);
        final Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                zzAU().zzeG(str4);
                Object zzk = zzAU().zzk(str4, bundle.get(str4));
                if (zzk != null) {
                    zzAU().zza(bundle2, str4, zzk);
                }
            }
        }
        final String str5 = str;
        final String str6 = str2;
        final boolean z2 = z;
        final String str7 = str3;
        zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzy zzaUM;

            public void run() {
                this.zzaUM.zza(str5, str6, currentTimeMillis, bundle2, z2, str7);
            }
        });
    }

    private void zza(String str, String str2, Object obj, long j) {
        zzx.zzcG(str);
        zzx.zzcG(str2);
        zziS();
        zziR();
        zzje();
        if (!zzAW().zzzC()) {
            zzzz().zzBp().zzez("User attribute not set since app measurement is disabled");
        } else if (this.zzaQX.zzBz()) {
            zzzz().zzBq().zze("Setting user attribute (FE)", str2, obj);
            zzAT().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void zzaq(boolean z) {
        zziS();
        zziR();
        zzje();
        zzzz().zzBq().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzAW().setMeasurementEnabled(z);
        zzAT().zzBV();
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean enabled) {
        zzje();
        zziR();
        zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzy zzaUM;

            public void run() {
                this.zzaUM.zzaq(enabled);
            }
        });
    }

    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    public void zzBR() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzaUI == null) {
                this.zzaUI = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzaUI);
            application.registerActivityLifecycleCallbacks(this.zzaUI);
            zzzz().zzBr().zzez("Registered activity lifecycle callback");
        }
    }

    public void zzBS() {
        zziS();
        zziR();
        zzje();
        if (this.zzaQX.zzBz()) {
            zzAT().zzBS();
        }
    }

    public void zza(String str, String str2, Object obj) {
        zzx.zzcG(str);
        final long currentTimeMillis = zziT().currentTimeMillis();
        zzAU().zzeF(str2);
        if (obj != null) {
            zzAU().zzl(str2, obj);
            final Object zzm = zzAU().zzm(str2, obj);
            if (zzm != null) {
                final String str3 = str;
                final String str4 = str2;
                zzAV().zzg(new Runnable(this) {
                    final /* synthetic */ zzy zzaUM;

                    public void run() {
                        this.zzaUM.zza(str3, str4, zzm, currentTimeMillis);
                    }
                });
                return;
            }
            return;
        }
        str4 = str;
        final String str5 = str2;
        zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzy zzaUM;

            public void run() {
                this.zzaUM.zza(str4, str5, null, currentTimeMillis);
            }
        });
    }

    public void zze(String str, String str2, Bundle bundle) {
        zziR();
        zza(str, str2, bundle, true, null);
    }

    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzzz().zzBm().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    protected void zzir() {
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
