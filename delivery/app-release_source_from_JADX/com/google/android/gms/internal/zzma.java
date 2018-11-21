package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmm.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class zzma implements zzmm {
    private final Context mContext;
    private final Looper zzaeK;
    private int zzafA = 0;
    private final zzmg zzafp;
    private final zzmi zzafq;
    private final zzmi zzafr;
    private final Map<zzc<?>, zzmi> zzafs = new ArrayMap();
    private final Set<zzmp> zzaft = Collections.newSetFromMap(new WeakHashMap());
    private final zzb zzafu;
    private Bundle zzafv;
    private ConnectionResult zzafw = null;
    private ConnectionResult zzafx = null;
    private final AtomicInteger zzafy = new AtomicInteger(0);
    private final Lock zzafz;

    class C03583 implements Runnable {
        final /* synthetic */ zzma zzafB;

        C03583(zzma com_google_android_gms_internal_zzma) {
            this.zzafB = com_google_android_gms_internal_zzma;
        }

        public void run() {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zzoW();
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }
    }

    class C07351 implements zza {
        final /* synthetic */ zzma zzafB;

        C07351(zzma com_google_android_gms_internal_zzma) {
            this.zzafB = com_google_android_gms_internal_zzma;
        }

        public void zzbz(int i) {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zza(this.zzafB.zzafr, i);
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }

        public void zze(ConnectionResult connectionResult) {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zzafw = connectionResult;
                this.zzafB.zzoW();
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }

        public void zzi(Bundle bundle) {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zzh(bundle);
                this.zzafB.zzafw = ConnectionResult.zzadR;
                this.zzafB.zzoW();
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }
    }

    class C07362 implements zza {
        final /* synthetic */ zzma zzafB;

        C07362(zzma com_google_android_gms_internal_zzma) {
            this.zzafB = com_google_android_gms_internal_zzma;
        }

        public void zzbz(int i) {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zza(this.zzafB.zzafq, i);
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }

        public void zze(ConnectionResult connectionResult) {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zzafx = connectionResult;
                this.zzafB.zzoW();
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }

        public void zzi(Bundle bundle) {
            this.zzafB.zzafz.lock();
            try {
                this.zzafB.zzafx = ConnectionResult.zzadR;
                this.zzafB.zzoW();
            } finally {
                this.zzafB.zzafz.unlock();
            }
        }
    }

    public zzma(Context context, zzmg com_google_android_gms_internal_zzmg, Lock lock, Looper looper, GoogleApiAvailability googleApiAvailability, Map<zzc<?>, zzb> map, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, ArrayList<zzlz> arrayList) {
        this.mContext = context;
        this.zzafp = com_google_android_gms_internal_zzmg;
        this.zzafz = lock;
        this.zzaeK = looper;
        zzb com_google_android_gms_common_api_Api_zzb = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (zzc com_google_android_gms_common_api_Api_zzc : map.keySet()) {
            zzb com_google_android_gms_common_api_Api_zzb2 = (zzb) map.get(com_google_android_gms_common_api_Api_zzc);
            if (com_google_android_gms_common_api_Api_zzb2.zzmJ()) {
                com_google_android_gms_common_api_Api_zzb = com_google_android_gms_common_api_Api_zzb2;
            }
            if (com_google_android_gms_common_api_Api_zzb2.zzmn()) {
                arrayMap.put(com_google_android_gms_common_api_Api_zzc, com_google_android_gms_common_api_Api_zzb2);
            } else {
                arrayMap2.put(com_google_android_gms_common_api_Api_zzc, com_google_android_gms_common_api_Api_zzb2);
            }
        }
        this.zzafu = com_google_android_gms_common_api_Api_zzb;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzoA = api.zzoA();
            if (arrayMap.containsKey(zzoA)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(zzoA)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzlz com_google_android_gms_internal_zzlz = (zzlz) it.next();
            if (arrayMap3.containsKey(com_google_android_gms_internal_zzlz.zzafm)) {
                arrayList2.add(com_google_android_gms_internal_zzlz);
            } else if (arrayMap4.containsKey(com_google_android_gms_internal_zzlz.zzafm)) {
                arrayList3.add(com_google_android_gms_internal_zzlz);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        Context context2 = context;
        this.zzafq = new zzmi(context2, this.zzafp, lock, looper, googleApiAvailability, arrayMap2, null, arrayMap4, null, arrayList3, new C07351(this));
        Context context3 = context;
        this.zzafr = new zzmi(context3, this.zzafp, lock, looper, googleApiAvailability, arrayMap, com_google_android_gms_common_internal_zzf, arrayMap3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, arrayList2, new C07362(this));
        for (zzc com_google_android_gms_common_api_Api_zzc2 : arrayMap2.keySet()) {
            this.zzafs.put(com_google_android_gms_common_api_Api_zzc2, this.zzafq);
        }
        for (zzc com_google_android_gms_common_api_Api_zzc22 : arrayMap.keySet()) {
            this.zzafs.put(com_google_android_gms_common_api_Api_zzc22, this.zzafr);
        }
    }

    private void zza(zzmi com_google_android_gms_internal_zzmi, int i) {
        if (this.zzafy.getAndIncrement() % 2 == 1) {
            this.zzafp.zzbz(i);
        }
        com_google_android_gms_internal_zzmi.onConnectionSuspended(i);
        this.zzafx = null;
        this.zzafw = null;
    }

    private void zzc(ConnectionResult connectionResult) {
        switch (this.zzafA) {
            case 1:
                break;
            case 2:
                this.zzafp.zze(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzoY();
        this.zzafA = 0;
    }

    private boolean zzc(zzlx.zza<? extends Result, ? extends zzb> com_google_android_gms_internal_zzlx_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        zzc zzoA = com_google_android_gms_internal_zzlx_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.zzoA();
        zzx.zzb(this.zzafs.containsKey(zzoA), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzmi) this.zzafs.get(zzoA)).equals(this.zzafr);
    }

    private static boolean zzd(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private void zzh(Bundle bundle) {
        if (this.zzafv == null) {
            this.zzafv = bundle;
        } else if (bundle != null) {
            this.zzafv.putAll(bundle);
        }
    }

    private void zzoV() {
        this.zzafx = null;
        this.zzafw = null;
        this.zzafq.connect();
        this.zzafr.connect();
    }

    private void zzoW() {
        if (zzd(this.zzafw)) {
            if (zzd(this.zzafx) || zzoZ()) {
                zzoX();
            } else if (this.zzafx == null) {
            } else {
                if (this.zzafA == 1) {
                    zzoY();
                    return;
                }
                zzc(this.zzafx);
                this.zzafq.disconnect();
            }
        } else if (this.zzafw != null && zzd(this.zzafx)) {
            this.zzafr.disconnect();
            zzc(this.zzafw);
        } else if (this.zzafw != null && this.zzafx != null) {
            ConnectionResult connectionResult = this.zzafw;
            if (this.zzafr.zzagM < this.zzafq.zzagM) {
                connectionResult = this.zzafx;
            }
            zzc(connectionResult);
        }
    }

    private void zzoX() {
        switch (this.zzafA) {
            case 1:
                break;
            case 2:
                this.zzafp.zzi(this.zzafv);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzoY();
        this.zzafA = 0;
    }

    private void zzoY() {
        for (zzmp zzmI : this.zzaft) {
            zzmI.zzmI();
        }
        this.zzaft.clear();
    }

    private boolean zzoZ() {
        return this.zzafx != null && this.zzafx.getErrorCode() == 4;
    }

    private PendingIntent zzpa() {
        return this.zzafu == null ? null : PendingIntent.getActivity(this.mContext, this.zzafp.getSessionId(), this.zzafu.zzmK(), 134217728);
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.zzafA = 2;
        zzoV();
    }

    public void disconnect() {
        this.zzafx = null;
        this.zzafw = null;
        this.zzafA = 0;
        this.zzafq.disconnect();
        this.zzafr.disconnect();
        zzoY();
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("authClient").println(":");
        this.zzafr.dump(prefix + "  ", fd, writer, args);
        writer.append(prefix).append("unauthClient").println(":");
        this.zzafq.dump(prefix + "  ", fd, writer, args);
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        if (((zzmi) this.zzafs.get(api.zzoA())).equals(this.zzafr)) {
            return zzoZ() ? new ConnectionResult(4, zzpa()) : this.zzafr.getConnectionResult(api);
        } else {
            return this.zzafq.getConnectionResult(api);
        }
    }

    public boolean isConnected() {
        boolean z = true;
        this.zzafz.lock();
        try {
            if (!(this.zzafq.isConnected() && (zzoU() || zzoZ() || this.zzafA == 1))) {
                z = false;
            }
            this.zzafz.unlock();
            return z;
        } catch (Throwable th) {
            this.zzafz.unlock();
        }
    }

    public boolean isConnecting() {
        this.zzafz.lock();
        try {
            boolean z = this.zzafq.isConnecting() || (this.zzafr.isConnecting() && this.zzafA == 2);
            this.zzafz.unlock();
            return z;
        } catch (Throwable th) {
            this.zzafz.unlock();
        }
    }

    public <A extends zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T t) {
        if (t.zzoQ() == 1) {
            throw new IllegalStateException("ReportingServices.getReportingState is not supported with SIGN_IN_MODE_OPTIONAL.");
        } else if (!zzc((zzlx.zza) t)) {
            return this.zzafq.zza((zzlx.zza) t);
        } else {
            if (!zzoZ()) {
                return this.zzafr.zza((zzlx.zza) t);
            }
            t.zzx(new Status(4, null, zzpa()));
            return t;
        }
    }

    public boolean zza(zzmp com_google_android_gms_internal_zzmp) {
        this.zzafz.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzoU()) {
                this.zzaft.add(com_google_android_gms_internal_zzmp);
                if (this.zzafA == 0) {
                    this.zzafA = 1;
                }
                this.zzafx = null;
                this.zzafr.connect();
                return true;
            }
            this.zzafz.unlock();
            return false;
        } finally {
            this.zzafz.unlock();
        }
    }

    public <A extends zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T t) {
        if (!zzc((zzlx.zza) t)) {
            return this.zzafq.zzb((zzlx.zza) t);
        }
        if (!zzoZ()) {
            return this.zzafr.zzb((zzlx.zza) t);
        }
        t.zzx(new Status(4, null, zzpa()));
        return t;
    }

    public void zzoF() {
        this.zzafz.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzafr.disconnect();
            this.zzafx = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzaeK).post(new C03583(this));
            } else {
                zzoY();
            }
            this.zzafz.unlock();
        } catch (Throwable th) {
            this.zzafz.unlock();
        }
    }

    public boolean zzoU() {
        return this.zzafr.isConnected();
    }
}
