package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzmi implements zzmm {
    private final Context mContext;
    private final GoogleApiAvailability zzaeL;
    final com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> zzaeM;
    final zzf zzafT;
    final Map<Api<?>, Integer> zzafU;
    final zzmg zzafp;
    private final Lock zzafz;
    private final Condition zzagH;
    private final zzb zzagI;
    final Map<zzc<?>, ConnectionResult> zzagJ = new HashMap();
    private volatile zzmh zzagK;
    private ConnectionResult zzagL = null;
    int zzagM;
    final com.google.android.gms.internal.zzmm.zza zzagN;
    final Map<zzc<?>, com.google.android.gms.common.api.Api.zzb> zzagp;

    static abstract class zza {
        private final zzmh zzagO;

        protected zza(zzmh com_google_android_gms_internal_zzmh) {
            this.zzagO = com_google_android_gms_internal_zzmh;
        }

        public final void zzd(zzmi com_google_android_gms_internal_zzmi) {
            com_google_android_gms_internal_zzmi.zzafz.lock();
            try {
                if (com_google_android_gms_internal_zzmi.zzagK == this.zzagO) {
                    zzpc();
                    com_google_android_gms_internal_zzmi.zzafz.unlock();
                }
            } finally {
                com_google_android_gms_internal_zzmi.zzafz.unlock();
            }
        }

        protected abstract void zzpc();
    }

    final class zzb extends Handler {
        final /* synthetic */ zzmi zzagP;

        zzb(zzmi com_google_android_gms_internal_zzmi, Looper looper) {
            this.zzagP = com_google_android_gms_internal_zzmi;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    ((zza) msg.obj).zzd(this.zzagP);
                    return;
                case 2:
                    throw ((RuntimeException) msg.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    public zzmi(Context context, zzmg com_google_android_gms_internal_zzmg, Lock lock, Looper looper, GoogleApiAvailability googleApiAvailability, Map<zzc<?>, com.google.android.gms.common.api.Api.zzb> map, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, ArrayList<zzlz> arrayList, com.google.android.gms.internal.zzmm.zza com_google_android_gms_internal_zzmm_zza) {
        this.mContext = context;
        this.zzafz = lock;
        this.zzaeL = googleApiAvailability;
        this.zzagp = map;
        this.zzafT = com_google_android_gms_common_internal_zzf;
        this.zzafU = map2;
        this.zzaeM = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd;
        this.zzafp = com_google_android_gms_internal_zzmg;
        this.zzagN = com_google_android_gms_internal_zzmm_zza;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zzlz) it.next()).zza(this);
        }
        this.zzagI = new zzb(this, looper);
        this.zzagH = lock.newCondition();
        this.zzagK = new zzmf(this);
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzagH.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.zzadR : this.zzagL != null ? this.zzagL : new ConnectionResult(13, null);
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        connect();
        long toNanos = unit.toNanos(timeout);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    return new ConnectionResult(14, null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            toNanos = this.zzagH.awaitNanos(toNanos);
        }
        if (isConnected()) {
            return ConnectionResult.zzadR;
        }
        return this.zzagL != null ? this.zzagL : new ConnectionResult(13, null);
    }

    public void connect() {
        this.zzagK.connect();
    }

    public void disconnect() {
        this.zzagJ.clear();
        this.zzagK.disconnect();
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String str = prefix + "  ";
        for (Api api : this.zzafU.keySet()) {
            writer.append(prefix).append(api.getName()).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.zzagp.get(api.zzoA())).dump(str, fd, writer, args);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        zzc zzoA = api.zzoA();
        if (this.zzagp.containsKey(zzoA)) {
            if (((com.google.android.gms.common.api.Api.zzb) this.zzagp.get(zzoA)).isConnected()) {
                return ConnectionResult.zzadR;
            }
            if (this.zzagJ.containsKey(zzoA)) {
                return (ConnectionResult) this.zzagJ.get(zzoA);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.zzagK instanceof zzmd;
    }

    public boolean isConnecting() {
        return this.zzagK instanceof zzme;
    }

    public void onConnected(Bundle connectionHint) {
        this.zzafz.lock();
        try {
            this.zzagK.onConnected(connectionHint);
        } finally {
            this.zzafz.unlock();
        }
    }

    public void onConnectionSuspended(int cause) {
        this.zzafz.lock();
        try {
            this.zzagK.onConnectionSuspended(cause);
        } finally {
            this.zzafz.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T zza(T t) {
        return this.zzagK.zza(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        this.zzafz.lock();
        try {
            this.zzagK.zza(connectionResult, api, i);
        } finally {
            this.zzafz.unlock();
        }
    }

    void zza(zza com_google_android_gms_internal_zzmi_zza) {
        this.zzagI.sendMessage(this.zzagI.obtainMessage(1, com_google_android_gms_internal_zzmi_zza));
    }

    void zza(RuntimeException runtimeException) {
        this.zzagI.sendMessage(this.zzagI.obtainMessage(2, runtimeException));
    }

    public boolean zza(zzmp com_google_android_gms_internal_zzmp) {
        return false;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T zzb(T t) {
        return this.zzagK.zzb(t);
    }

    void zzj(ConnectionResult connectionResult) {
        this.zzafz.lock();
        try {
            this.zzagL = connectionResult;
            this.zzagK = new zzmf(this);
            this.zzagK.begin();
            this.zzagH.signalAll();
        } finally {
            this.zzafz.unlock();
        }
    }

    public void zzoF() {
    }

    void zzpw() {
        this.zzafz.lock();
        try {
            this.zzagK = new zzme(this, this.zzafT, this.zzafU, this.zzaeL, this.zzaeM, this.zzafz, this.mContext);
            this.zzagK.begin();
            this.zzagH.signalAll();
        } finally {
            this.zzafz.unlock();
        }
    }

    void zzpx() {
        this.zzafz.lock();
        try {
            this.zzafp.zzps();
            this.zzagK = new zzmd(this);
            this.zzagK.begin();
            this.zzagH.signalAll();
        } finally {
            this.zzafz.unlock();
        }
    }

    void zzpy() {
        for (com.google.android.gms.common.api.Api.zzb disconnect : this.zzagp.values()) {
            disconnect.disconnect();
        }
    }
}
