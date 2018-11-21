package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzp {
    private static final String TAG = zzp.class.getSimpleName();
    private static final long zzaOa = TimeUnit.SECONDS.toMillis(1);
    private static zzp zzaOb;
    private final Context mContext;
    private final Handler mHandler;
    private final Runnable zzaOc;
    private ArrayList<String> zzaOd;
    private ArrayList<String> zzaOe;
    private final Object zzpK;

    private class zza implements Runnable {
        final /* synthetic */ zzp zzaOf;

        private zza(zzp com_google_android_gms_location_places_internal_zzp) {
            this.zzaOf = com_google_android_gms_location_places_internal_zzp;
        }

        public void run() {
            synchronized (this.zzaOf.zzpK) {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", this.zzaOf.zzaOd);
                intent.putStringArrayListExtra("METHOD_NAMES", this.zzaOf.zzaOe);
                intent.putExtra("PACKAGE_NAME", this.zzaOf.mContext.getPackageName());
                intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                this.zzaOf.mContext.sendBroadcast(intent);
                this.zzaOf.zzaOd = null;
                this.zzaOf.zzaOe = null;
            }
        }
    }

    private zzp(Context context) {
        this((Context) zzx.zzy(context), new Handler(Looper.getMainLooper()));
    }

    zzp(Context context, Handler handler) {
        this.zzaOc = new zza();
        this.zzpK = new Object();
        this.zzaOd = null;
        this.zzaOe = null;
        this.mContext = context;
        this.mHandler = handler;
    }

    public static synchronized zzp zzaN(Context context) {
        zzp com_google_android_gms_location_places_internal_zzp;
        synchronized (zzp.class) {
            zzx.zzy(context);
            if (VERSION.SDK_INT < 14) {
                com_google_android_gms_location_places_internal_zzp = null;
            } else {
                if (zzaOb == null) {
                    zzaOb = new zzp(context.getApplicationContext());
                }
                com_google_android_gms_location_places_internal_zzp = zzaOb;
            }
        }
        return com_google_android_gms_location_places_internal_zzp;
    }

    public void zzH(String str, String str2) {
        synchronized (this.zzpK) {
            if (this.zzaOd == null) {
                this.zzaOd = new ArrayList();
                this.zzaOe = new ArrayList();
                this.mHandler.postDelayed(this.zzaOc, zzaOa);
            }
            this.zzaOd.add(str);
            this.zzaOe.add(str2);
            if (this.zzaOd.size() >= StatusCodes.AUTH_DISABLED) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Event buffer full, flushing");
                }
                this.zzaOc.run();
                this.mHandler.removeCallbacks(this.zzaOc);
                return;
            }
        }
    }
}
