package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Callback {
    private final Handler mHandler;
    private final zza zzajZ;
    private final ArrayList<ConnectionCallbacks> zzaka = new ArrayList();
    final ArrayList<ConnectionCallbacks> zzakb = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> zzakc = new ArrayList();
    private volatile boolean zzakd = false;
    private final AtomicInteger zzake = new AtomicInteger(0);
    private boolean zzakf = false;
    private final Object zzpK = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zznQ();
    }

    public zzk(Looper looper, zza com_google_android_gms_common_internal_zzk_zza) {
        this.zzajZ = com_google_android_gms_common_internal_zzk_zza;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message msg) {
        if (msg.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) msg.obj;
            synchronized (this.zzpK) {
                if (this.zzakd && this.zzajZ.isConnected() && this.zzaka.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzajZ.zznQ());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + msg.what, new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        zzx.zzy(listener);
        synchronized (this.zzpK) {
            contains = this.zzaka.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        zzx.zzy(listener);
        synchronized (this.zzpK) {
            contains = this.zzakc.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        zzx.zzy(listener);
        synchronized (this.zzpK) {
            if (this.zzaka.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.zzaka.add(listener);
            }
        }
        if (this.zzajZ.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        zzx.zzy(listener);
        synchronized (this.zzpK) {
            if (this.zzakc.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.zzakc.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        zzx.zzy(listener);
        synchronized (this.zzpK) {
            if (!this.zzaka.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
            } else if (this.zzakf) {
                this.zzakb.add(listener);
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        zzx.zzy(listener);
        synchronized (this.zzpK) {
            if (!this.zzakc.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }

    public void zzbV(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpK) {
            this.zzakf = true;
            ArrayList arrayList = new ArrayList(this.zzaka);
            int i2 = this.zzake.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.zzakd || this.zzake.get() != i2) {
                    break;
                } else if (this.zzaka.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzakb.clear();
            this.zzakf = false;
        }
    }

    public void zzk(Bundle bundle) {
        boolean z = true;
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzpK) {
            zzx.zzaa(!this.zzakf);
            this.mHandler.removeMessages(1);
            this.zzakf = true;
            if (this.zzakb.size() != 0) {
                z = false;
            }
            zzx.zzaa(z);
            ArrayList arrayList = new ArrayList(this.zzaka);
            int i = this.zzake.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.zzakd || !this.zzajZ.isConnected() || this.zzake.get() != i) {
                    break;
                } else if (!this.zzakb.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzakb.clear();
            this.zzakf = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzl(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.mHandler;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.zzx.zza(r0, r2);
        r0 = r5.mHandler;
        r0.removeMessages(r1);
        r1 = r5.zzpK;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.zzakc;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.zzake;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.zzakd;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.zzake;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.zzakc;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.onConnectionFailed(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzk.zzl(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzqA() {
        this.zzakd = false;
        this.zzake.incrementAndGet();
    }

    public void zzqB() {
        this.zzakd = true;
    }
}
