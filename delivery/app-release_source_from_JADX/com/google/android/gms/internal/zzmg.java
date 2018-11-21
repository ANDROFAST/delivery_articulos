package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzmg extends GoogleApiClient implements com.google.android.gms.internal.zzmm.zza {
    private final Context mContext;
    private final int zzaeI;
    private final Looper zzaeK;
    private final GoogleApiAvailability zzaeL;
    final com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> zzaeM;
    final zzf zzafT;
    final Map<Api<?>, Integer> zzafU;
    private final Lock zzafz;
    private final zzk zzagh;
    private zzmm zzagi = null;
    final Queue<com.google.android.gms.internal.zzlx.zza<?, ?>> zzagj = new LinkedList();
    private volatile boolean zzagk;
    private long zzagl = 120000;
    private long zzagm = 5000;
    private final zza zzagn;
    zzc zzago;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzagp;
    Set<Scope> zzagq = new HashSet();
    private final Set<zzmn<?>> zzagr = Collections.newSetFromMap(new WeakHashMap());
    final Set<zze<?>> zzags = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private com.google.android.gms.common.api.zza zzagt;
    private final ArrayList<zzlz> zzagu;
    private Integer zzagv = null;
    private final zzd zzagw = new C07411(this);
    private final com.google.android.gms.common.internal.zzk.zza zzagx = new C07422(this);

    final class zza extends Handler {
        final /* synthetic */ zzmg zzagy;

        zza(zzmg com_google_android_gms_internal_zzmg, Looper looper) {
            this.zzagy = com_google_android_gms_internal_zzmg;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzagy.zzpq();
                    return;
                case 2:
                    this.zzagy.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    interface zzd {
        void zzc(zze<?> com_google_android_gms_internal_zzmg_zze_);
    }

    interface zze<A extends com.google.android.gms.common.api.Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(zzd com_google_android_gms_internal_zzmg_zzd);

        void zzb(A a) throws DeadObjectException;

        com.google.android.gms.common.api.Api.zzc<A> zzoA();

        Integer zzoL();

        void zzoP();

        int zzoQ();

        void zzx(Status status);

        void zzy(Status status);
    }

    class C07411 implements zzd {
        final /* synthetic */ zzmg zzagy;

        C07411(zzmg com_google_android_gms_internal_zzmg) {
            this.zzagy = com_google_android_gms_internal_zzmg;
        }

        public void zzc(zze<?> com_google_android_gms_internal_zzmg_zze_) {
            this.zzagy.zzags.remove(com_google_android_gms_internal_zzmg_zze_);
            if (com_google_android_gms_internal_zzmg_zze_.zzoL() != null && this.zzagy.zzagt != null) {
                this.zzagy.zzagt.remove(com_google_android_gms_internal_zzmg_zze_.zzoL().intValue());
            }
        }
    }

    class C07422 implements com.google.android.gms.common.internal.zzk.zza {
        final /* synthetic */ zzmg zzagy;

        C07422(zzmg com_google_android_gms_internal_zzmg) {
            this.zzagy = com_google_android_gms_internal_zzmg;
        }

        public boolean isConnected() {
            return this.zzagy.isConnected();
        }

        public Bundle zznQ() {
            return null;
        }
    }

    private static class zzb implements DeathRecipient, zzd {
        private final WeakReference<zze<?>> zzagD;
        private final WeakReference<com.google.android.gms.common.api.zza> zzagE;
        private final WeakReference<IBinder> zzagF;

        private zzb(zze com_google_android_gms_internal_zzmg_zze, com.google.android.gms.common.api.zza com_google_android_gms_common_api_zza, IBinder iBinder) {
            this.zzagE = new WeakReference(com_google_android_gms_common_api_zza);
            this.zzagD = new WeakReference(com_google_android_gms_internal_zzmg_zze);
            this.zzagF = new WeakReference(iBinder);
        }

        private void zzpu() {
            zze com_google_android_gms_internal_zzmg_zze = (zze) this.zzagD.get();
            com.google.android.gms.common.api.zza com_google_android_gms_common_api_zza = (com.google.android.gms.common.api.zza) this.zzagE.get();
            if (!(com_google_android_gms_common_api_zza == null || com_google_android_gms_internal_zzmg_zze == null)) {
                com_google_android_gms_common_api_zza.remove(com_google_android_gms_internal_zzmg_zze.zzoL().intValue());
            }
            IBinder iBinder = (IBinder) this.zzagF.get();
            if (this.zzagF != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzpu();
        }

        public void zzc(zze<?> com_google_android_gms_internal_zzmg_zze_) {
            zzpu();
        }
    }

    static class zzc extends zzmk {
        private WeakReference<zzmg> zzagG;

        zzc(zzmg com_google_android_gms_internal_zzmg) {
            this.zzagG = new WeakReference(com_google_android_gms_internal_zzmg);
        }

        public void zzpv() {
            zzmg com_google_android_gms_internal_zzmg = (zzmg) this.zzagG.get();
            if (com_google_android_gms_internal_zzmg != null) {
                com_google_android_gms_internal_zzmg.resume();
            }
        }
    }

    public zzmg(Context context, Lock lock, Looper looper, zzf com_google_android_gms_common_internal_zzf, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, Map<Api<?>, Integer> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> map2, int i, int i2, ArrayList<zzlz> arrayList) {
        this.mContext = context;
        this.zzafz = lock;
        this.zzagh = new zzk(looper, this.zzagx);
        this.zzaeK = looper;
        this.zzagn = new zza(this, looper);
        this.zzaeL = googleApiAvailability;
        this.zzaeI = i;
        if (this.zzaeI >= 0) {
            this.zzagv = Integer.valueOf(i2);
        }
        this.zzafU = map;
        this.zzagp = map2;
        this.zzagu = arrayList;
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzagh.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzagh.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzafT = com_google_android_gms_common_internal_zzf;
        this.zzaeM = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd;
    }

    private void resume() {
        this.zzafz.lock();
        try {
            if (zzpo()) {
                zzpp();
            }
            this.zzafz.unlock();
        } catch (Throwable th) {
            this.zzafz.unlock();
        }
    }

    public static int zza(Iterable<com.google.android.gms.common.api.Api.zzb> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb : iterable) {
            if (com_google_android_gms_common_api_Api_zzb.zzmn()) {
                i2 = 1;
            }
            i = com_google_android_gms_common_api_Api_zzb.zzmJ() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private void zza(final GoogleApiClient googleApiClient, final zzmq com_google_android_gms_internal_zzmq, final boolean z) {
        zzmz.zzakJ.zze(googleApiClient).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ zzmg zzagy;

            public /* synthetic */ void onResult(Result x0) {
                zzp((Status) x0);
            }

            public void zzp(Status status) {
                zzn.zzae(this.zzagy.mContext).zzmZ();
                if (status.isSuccess() && this.zzagy.isConnected()) {
                    this.zzagy.reconnect();
                }
                com_google_android_gms_internal_zzmq.zzb(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zze<?> com_google_android_gms_internal_zzmg_zze_, com.google.android.gms.common.api.zza com_google_android_gms_common_api_zza, IBinder iBinder) {
        if (com_google_android_gms_internal_zzmg_zze_.isReady()) {
            com_google_android_gms_internal_zzmg_zze_.zza(new zzb(com_google_android_gms_internal_zzmg_zze_, com_google_android_gms_common_api_zza, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            com_google_android_gms_internal_zzmg_zze_.zza(null);
            com_google_android_gms_internal_zzmg_zze_.cancel();
            com_google_android_gms_common_api_zza.remove(com_google_android_gms_internal_zzmg_zze_.zzoL().intValue());
        } else {
            Object com_google_android_gms_internal_zzmg_zzb = new zzb(com_google_android_gms_internal_zzmg_zze_, com_google_android_gms_common_api_zza, iBinder);
            com_google_android_gms_internal_zzmg_zze_.zza(com_google_android_gms_internal_zzmg_zzb);
            try {
                iBinder.linkToDeath(com_google_android_gms_internal_zzmg_zzb, 0);
            } catch (RemoteException e) {
                com_google_android_gms_internal_zzmg_zze_.cancel();
                com_google_android_gms_common_api_zza.remove(com_google_android_gms_internal_zzmg_zze_.zzoL().intValue());
            }
        }
    }

    private void zzbC(int i) {
        if (this.zzagv == null) {
            this.zzagv = Integer.valueOf(i);
        } else if (this.zzagv.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zzbD(i) + ". Mode was already set to " + zzbD(this.zzagv.intValue()));
        }
        if (this.zzagi == null) {
            Object obj = null;
            Object obj2 = null;
            for (com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb : this.zzagp.values()) {
                if (com_google_android_gms_common_api_Api_zzb.zzmn()) {
                    obj2 = 1;
                }
                obj = com_google_android_gms_common_api_Api_zzb.zzmJ() ? 1 : obj;
            }
            switch (this.zzagv.intValue()) {
                case 1:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj2 != null) {
                        this.zzagi = new zzma(this.mContext, this, this.zzafz, this.zzaeK, this.zzaeL, this.zzagp, this.zzafT, this.zzafU, this.zzaeM, this.zzagu);
                        return;
                    }
                    break;
            }
            this.zzagi = new zzmi(this.mContext, this, this.zzafz, this.zzaeK, this.zzaeL, this.zzagp, this.zzafT, this.zzafU, this.zzaeM, this.zzagu, this);
        }
    }

    static String zzbD(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpp() {
        this.zzagh.zzqB();
        this.zzagi.connect();
    }

    private void zzpq() {
        this.zzafz.lock();
        try {
            if (zzps()) {
                zzpp();
            }
            this.zzafz.unlock();
        } catch (Throwable th) {
            this.zzafz.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzafz.lock();
        try {
            if (this.zzaeI >= 0) {
                if (this.zzagv == null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzagv == null) {
                this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
            } else if (this.zzagv.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbC(this.zzagv.intValue());
            this.zzagh.zzqB();
            ConnectionResult blockingConnect = this.zzagi.blockingConnect();
            return blockingConnect;
        } finally {
            this.zzafz.unlock();
        }
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzx.zzb((Object) unit, (Object) "TimeUnit must not be null");
        this.zzafz.lock();
        try {
            if (this.zzagv == null) {
                this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
            } else if (this.zzagv.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbC(this.zzagv.intValue());
            this.zzagh.zzqB();
            ConnectionResult blockingConnect = this.zzagi.blockingConnect(timeout, unit);
            return blockingConnect;
        } finally {
            this.zzafz.unlock();
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzx.zza(this.zzagv.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzmq com_google_android_gms_internal_zzmq = new zzmq((GoogleApiClient) this);
        if (this.zzagp.containsKey(zzmz.zzTo)) {
            zza((GoogleApiClient) this, com_google_android_gms_internal_zzmq, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new Builder(this.mContext).addApi(zzmz.API).addConnectionCallbacks(new ConnectionCallbacks(this) {
                final /* synthetic */ zzmg zzagy;

                public void onConnected(Bundle connectionHint) {
                    this.zzagy.zza((GoogleApiClient) atomicReference.get(), com_google_android_gms_internal_zzmq, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            }).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ zzmg zzagy;

                public void onConnectionFailed(ConnectionResult result) {
                    com_google_android_gms_internal_zzmq.zzb(new Status(8));
                }
            }).setHandler(this.zzagn).build();
            atomicReference.set(build);
            build.connect();
        }
        return com_google_android_gms_internal_zzmq;
    }

    public void connect() {
        boolean z = false;
        this.zzafz.lock();
        try {
            if (this.zzaeI >= 0) {
                if (this.zzagv != null) {
                    z = true;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzagv == null) {
                this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
            } else if (this.zzagv.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzagv.intValue());
        } finally {
            this.zzafz.unlock();
        }
    }

    public void connect(int signInMode) {
        boolean z = true;
        this.zzafz.lock();
        if (!(signInMode == 3 || signInMode == 1 || signInMode == 2)) {
            z = false;
        }
        try {
            zzx.zzb(z, "Illegal sign-in mode: " + signInMode);
            zzbC(signInMode);
            zzpp();
        } finally {
            this.zzafz.unlock();
        }
    }

    public void disconnect() {
        this.zzafz.lock();
        try {
            zzpm();
            if (this.zzagi == null) {
                zzpn();
                return;
            }
            zzps();
            this.zzagi.disconnect();
            this.zzagh.zzqA();
            this.zzafz.unlock();
        } finally {
            this.zzafz.unlock();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("mContext=").println(this.mContext);
        writer.append(prefix).append("mResuming=").print(this.zzagk);
        writer.append(" mWorkQueue.size()=").print(this.zzagj.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzags.size());
        if (this.zzagi != null) {
            this.zzagi.dump(prefix, fd, writer, args);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        this.zzafz.lock();
        try {
            if (!isConnected() && !zzpo()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzagp.containsKey(api.zzoA())) {
                ConnectionResult connectionResult = this.zzagi.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzafz.unlock();
                } else if (zzpo()) {
                    connectionResult = ConnectionResult.zzadR;
                } else {
                    Log.i("GoogleApiClientImpl", zzpt());
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed " + " connections map", new Exception());
                    connectionResult = new ConnectionResult(8, null);
                    this.zzafz.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.zzafz.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzaeK;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(Api<?> api) {
        com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb = (com.google.android.gms.common.api.Api.zzb) this.zzagp.get(api.zzoA());
        return com_google_android_gms_common_api_Api_zzb != null && com_google_android_gms_common_api_Api_zzb.isConnected();
    }

    public boolean isConnected() {
        return this.zzagi != null && this.zzagi.isConnected();
    }

    public boolean isConnecting() {
        return this.zzagi != null && this.zzagi.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zzagh.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zzagh.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzagh.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzagh.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(final FragmentActivity lifecycleActivity) {
        if (this.zzaeI >= 0) {
            zzmr zza = zzmr.zza(lifecycleActivity);
            if (zza == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ zzmg zzagy;

                    public void run() {
                        if (!lifecycleActivity.isFinishing() && !lifecycleActivity.getSupportFragmentManager().isDestroyed()) {
                            zzmr.zzb(lifecycleActivity).zzbE(this.zzagy.zzaeI);
                        }
                    }
                });
                return;
            } else {
                zza.zzbE(this.zzaeI);
                return;
            }
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzagh.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzagh.unregisterConnectionFailedListener(listener);
    }

    public <C extends com.google.android.gms.common.api.Api.zzb> C zza(com.google.android.gms.common.api.Api.zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (com.google.android.gms.common.api.Api.zzb) this.zzagp.get(com_google_android_gms_common_api_Api_zzc_C);
        zzx.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T zza(T t) {
        zzx.zzb(t.zzoA() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzagp.containsKey(t.zzoA()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzafz.lock();
        try {
            if (this.zzagi == null) {
                this.zzagj.add(t);
            } else {
                t = this.zzagi.zza((com.google.android.gms.internal.zzlx.zza) t);
                this.zzafz.unlock();
            }
            return t;
        } finally {
            this.zzafz.unlock();
        }
    }

    public boolean zza(Api<?> api) {
        return this.zzagp.containsKey(api.zzoA());
    }

    public boolean zza(zzmp com_google_android_gms_internal_zzmp) {
        return this.zzagi != null && this.zzagi.zza(com_google_android_gms_internal_zzmp);
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T zzb(T t) {
        zzx.zzb(t.zzoA() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzafz.lock();
        try {
            if (this.zzagi == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzpo()) {
                this.zzagj.add(t);
                while (!this.zzagj.isEmpty()) {
                    zze com_google_android_gms_internal_zzmg_zze = (zze) this.zzagj.remove();
                    zzb(com_google_android_gms_internal_zzmg_zze);
                    com_google_android_gms_internal_zzmg_zze.zzx(Status.zzaeZ);
                }
            } else {
                t = this.zzagi.zzb(t);
                this.zzafz.unlock();
            }
            return t;
        } finally {
            this.zzafz.unlock();
        }
    }

    <A extends com.google.android.gms.common.api.Api.zzb> void zzb(zze<A> com_google_android_gms_internal_zzmg_zze_A) {
        this.zzags.add(com_google_android_gms_internal_zzmg_zze_A);
        com_google_android_gms_internal_zzmg_zze_A.zza(this.zzagw);
    }

    public void zzbz(int i) {
        if (i == 1) {
            zzpr();
        }
        for (zze zzy : this.zzags) {
            zzy.zzy(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzagh.zzbV(i);
        this.zzagh.zzqA();
        if (i == 2) {
            zzpp();
        }
    }

    public void zze(ConnectionResult connectionResult) {
        if (!this.zzaeL.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzps();
        }
        if (!zzpo()) {
            this.zzagh.zzl(connectionResult);
            this.zzagh.zzqA();
        }
    }

    public void zzi(Bundle bundle) {
        while (!this.zzagj.isEmpty()) {
            zzb((com.google.android.gms.internal.zzlx.zza) this.zzagj.remove());
        }
        this.zzagh.zzk(bundle);
    }

    public void zzoF() {
        if (this.zzagi != null) {
            this.zzagi.zzoF();
        }
    }

    void zzpm() {
        for (zze com_google_android_gms_internal_zzmg_zze : this.zzags) {
            com_google_android_gms_internal_zzmg_zze.zza(null);
            if (com_google_android_gms_internal_zzmg_zze.zzoL() == null) {
                com_google_android_gms_internal_zzmg_zze.cancel();
            } else {
                com_google_android_gms_internal_zzmg_zze.zzoP();
                zza(com_google_android_gms_internal_zzmg_zze, this.zzagt, zza(com_google_android_gms_internal_zzmg_zze.zzoA()).zzoC());
            }
        }
        this.zzags.clear();
        for (zzmn clear : this.zzagr) {
            clear.clear();
        }
        this.zzagr.clear();
    }

    void zzpn() {
        for (zze com_google_android_gms_internal_zzmg_zze : this.zzagj) {
            com_google_android_gms_internal_zzmg_zze.zza(null);
            com_google_android_gms_internal_zzmg_zze.cancel();
        }
        this.zzagj.clear();
    }

    boolean zzpo() {
        return this.zzagk;
    }

    void zzpr() {
        if (!zzpo()) {
            this.zzagk = true;
            if (this.zzago == null) {
                this.zzago = (zzc) zzmk.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzaeL);
            }
            this.zzagn.sendMessageDelayed(this.zzagn.obtainMessage(1), this.zzagl);
            this.zzagn.sendMessageDelayed(this.zzagn.obtainMessage(2), this.zzagm);
        }
    }

    boolean zzps() {
        if (!zzpo()) {
            return false;
        }
        this.zzagk = false;
        this.zzagn.removeMessages(2);
        this.zzagn.removeMessages(1);
        if (this.zzago != null) {
            this.zzago.unregister();
            this.zzago = null;
        }
        return true;
    }

    String zzpt() {
        Writer stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public <L> zzmn<L> zzq(L l) {
        zzx.zzb((Object) l, (Object) "Listener must not be null");
        this.zzafz.lock();
        try {
            zzmn<L> com_google_android_gms_internal_zzmn = new zzmn(this.zzaeK, l);
            this.zzagr.add(com_google_android_gms_internal_zzmn);
            return com_google_android_gms_internal_zzmn;
        } finally {
            this.zzafz.unlock();
        }
    }
}
