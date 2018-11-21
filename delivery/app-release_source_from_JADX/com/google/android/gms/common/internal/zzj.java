package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza {
    public static final String[] zzajS = new String[]{"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzSo;
    private final Set<Scope> zzVH;
    private final Looper zzaeK;
    private final GoogleApiAvailability zzaeL;
    private final zzf zzafT;
    private final zzl zzajH;
    private zzs zzajI;
    private com.google.android.gms.common.api.GoogleApiClient.zza zzajJ;
    private T zzajK;
    private final ArrayList<zzc<?>> zzajL;
    private zze zzajM;
    private int zzajN;
    private final ConnectionCallbacks zzajO;
    private final OnConnectionFailedListener zzajP;
    private final int zzajQ;
    protected AtomicInteger zzajR;
    private final Object zzpK;

    final class zzb extends Handler {
        final /* synthetic */ zzj zzajU;

        public zzb(zzj com_google_android_gms_common_internal_zzj, Looper looper) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            super(looper);
        }

        private void zza(Message message) {
            zzc com_google_android_gms_common_internal_zzj_zzc = (zzc) message.obj;
            com_google_android_gms_common_internal_zzj_zzc.zzqw();
            com_google_android_gms_common_internal_zzj_zzc.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public void handleMessage(Message msg) {
            if (this.zzajU.zzajR.get() != msg.arg1) {
                if (zzb(msg)) {
                    zza(msg);
                }
            } else if ((msg.what == 1 || msg.what == 5 || msg.what == 6) && !this.zzajU.isConnecting()) {
                zza(msg);
            } else if (msg.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(msg.arg2, null);
                this.zzajU.zzajJ.zza(connectionResult);
                this.zzajU.onConnectionFailed(connectionResult);
            } else if (msg.what == 4) {
                this.zzajU.zzb(4, null);
                if (this.zzajU.zzajO != null) {
                    this.zzajU.zzajO.onConnectionSuspended(msg.arg2);
                }
                this.zzajU.onConnectionSuspended(msg.arg2);
                this.zzajU.zza(4, 1, null);
            } else if (msg.what == 2 && !this.zzajU.isConnected()) {
                zza(msg);
            } else if (zzb(msg)) {
                ((zzc) msg.obj).zzqx();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + msg.what, new Exception());
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        final /* synthetic */ zzj zzajU;
        private boolean zzajV = false;

        public zzc(zzj com_google_android_gms_common_internal_zzj, TListener tListener) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            this.mListener = tListener;
        }

        public void unregister() {
            zzqy();
            synchronized (this.zzajU.zzajL) {
                this.zzajU.zzajL.remove(this);
            }
        }

        protected abstract void zzqw();

        public void zzqx() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.zzajV) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    zzv(obj);
                } catch (RuntimeException e) {
                    zzqw();
                    throw e;
                }
            }
            zzqw();
            synchronized (this) {
                this.zzajV = true;
            }
            unregister();
        }

        public void zzqy() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        protected abstract void zzv(TListener tListener);
    }

    public final class zze implements ServiceConnection {
        final /* synthetic */ zzj zzajU;
        private final int zzajX;

        public zze(zzj com_google_android_gms_common_internal_zzj, int i) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            this.zzajX = i;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb((Object) binder, (Object) "Expecting a valid IBinder");
            this.zzajU.zzajI = com.google.android.gms.common.internal.zzs.zza.zzaS(binder);
            this.zzajU.zzbU(this.zzajX);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.zzajU.mHandler.sendMessage(this.zzajU.mHandler.obtainMessage(4, this.zzajX, 1));
        }
    }

    private abstract class zza extends zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzajT;
        final /* synthetic */ zzj zzajU;

        protected zza(zzj com_google_android_gms_common_internal_zzj, int i, Bundle bundle) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, Boolean.valueOf(true));
            this.statusCode = i;
            this.zzajT = bundle;
        }

        protected void zzc(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.zzajU.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzqv()) {
                        this.zzajU.zzb(1, null);
                        zzk(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.zzajU.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.zzajU.zzb(1, null);
                    if (this.zzajT != null) {
                        pendingIntent = (PendingIntent) this.zzajT.getParcelable("pendingIntent");
                    }
                    zzk(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected abstract void zzk(ConnectionResult connectionResult);

        protected abstract boolean zzqv();

        protected void zzqw() {
        }

        protected /* synthetic */ void zzv(Object obj) {
            zzc((Boolean) obj);
        }
    }

    protected class zzf implements com.google.android.gms.common.api.GoogleApiClient.zza {
        final /* synthetic */ zzj zzajU;

        public zzf(zzj com_google_android_gms_common_internal_zzj) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
        }

        public void zza(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.zzajU.zza(null, this.zzajU.zzVH);
            } else if (this.zzajU.zzajP != null) {
                this.zzajU.zzajP.onConnectionFailed(connectionResult);
            }
        }

        public void zzb(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    public static final class zzd extends com.google.android.gms.common.internal.zzr.zza {
        private zzj zzajW;
        private final int zzajX;

        public zzd(zzj com_google_android_gms_common_internal_zzj, int i) {
            this.zzajW = com_google_android_gms_common_internal_zzj;
            this.zzajX = i;
        }

        private void zzqz() {
            this.zzajW = null;
        }

        public void zza(int i, IBinder iBinder, Bundle bundle) {
            zzx.zzb(this.zzajW, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzajW.zza(i, iBinder, bundle, this.zzajX);
            zzqz();
        }

        public void zzb(int i, Bundle bundle) {
            zzx.zzb(this.zzajW, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
            this.zzajW.zza(i, bundle, this.zzajX);
            zzqz();
        }
    }

    protected final class zzg extends zza {
        final /* synthetic */ zzj zzajU;
        public final IBinder zzajY;

        public zzg(zzj com_google_android_gms_common_internal_zzj, int i, IBinder iBinder, Bundle bundle) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, i, bundle);
            this.zzajY = iBinder;
        }

        protected void zzk(ConnectionResult connectionResult) {
            if (this.zzajU.zzajP != null) {
                this.zzajU.zzajP.onConnectionFailed(connectionResult);
            }
            this.zzajU.onConnectionFailed(connectionResult);
        }

        protected boolean zzqv() {
            try {
                String interfaceDescriptor = this.zzajY.getInterfaceDescriptor();
                if (this.zzajU.zzgi().equals(interfaceDescriptor)) {
                    IInterface zzW = this.zzajU.zzW(this.zzajY);
                    if (zzW == null || !this.zzajU.zza(2, 3, zzW)) {
                        return false;
                    }
                    Bundle zznQ = this.zzajU.zznQ();
                    if (this.zzajU.zzajO != null) {
                        this.zzajU.zzajO.onConnected(zznQ);
                    }
                    return true;
                }
                Log.e("GmsClient", "service descriptor mismatch: " + this.zzajU.zzgi() + " vs. " + interfaceDescriptor);
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zza {
        final /* synthetic */ zzj zzajU;

        public zzh(zzj com_google_android_gms_common_internal_zzj) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, 0, null);
        }

        protected void zzk(ConnectionResult connectionResult) {
            this.zzajU.zzajJ.zza(connectionResult);
            this.zzajU.onConnectionFailed(connectionResult);
        }

        protected boolean zzqv() {
            this.zzajU.zzajJ.zza(ConnectionResult.zzadR);
            return true;
        }
    }

    protected final class zzi extends zza {
        final /* synthetic */ zzj zzajU;

        public zzi(zzj com_google_android_gms_common_internal_zzj, int i, Bundle bundle) {
            this.zzajU = com_google_android_gms_common_internal_zzj;
            super(com_google_android_gms_common_internal_zzj, i, bundle);
        }

        protected void zzk(ConnectionResult connectionResult) {
            this.zzajU.zzajJ.zzb(connectionResult);
            this.zzajU.onConnectionFailed(connectionResult);
        }

        protected boolean zzqv() {
            this.zzajU.zzajJ.zzb(ConnectionResult.zzadR);
            return true;
        }
    }

    protected zzj(Context context, Looper looper, int i, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzat(context), GoogleApiAvailability.getInstance(), i, com_google_android_gms_common_internal_zzf, (ConnectionCallbacks) zzx.zzy(connectionCallbacks), (OnConnectionFailedListener) zzx.zzy(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl com_google_android_gms_common_internal_zzl, GoogleApiAvailability googleApiAvailability, int i, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.zzpK = new Object();
        this.zzajL = new ArrayList();
        this.zzajN = 1;
        this.zzajR = new AtomicInteger(0);
        this.mContext = (Context) zzx.zzb((Object) context, (Object) "Context must not be null");
        this.zzaeK = (Looper) zzx.zzb((Object) looper, (Object) "Looper must not be null");
        this.zzajH = (zzl) zzx.zzb((Object) com_google_android_gms_common_internal_zzl, (Object) "Supervisor must not be null");
        this.zzaeL = (GoogleApiAvailability) zzx.zzb((Object) googleApiAvailability, (Object) "API availability must not be null");
        this.mHandler = new zzb(this, looper);
        this.zzajQ = i;
        this.zzafT = (zzf) zzx.zzy(com_google_android_gms_common_internal_zzf);
        this.zzSo = com_google_android_gms_common_internal_zzf.getAccount();
        this.zzVH = zza(com_google_android_gms_common_internal_zzf.zzqb());
        this.zzajO = connectionCallbacks;
        this.zzajP = onConnectionFailedListener;
    }

    private Set<Scope> zza(Set<Scope> set) {
        Set<Scope> zzb = zzb((Set) set);
        if (zzb == null) {
            return zzb;
        }
        for (Scope contains : zzb) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzb;
    }

    private boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzpK) {
            if (this.zzajN != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzab(z);
        synchronized (this.zzpK) {
            this.zzajN = i;
            this.zzajK = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzqo();
                    break;
                case 2:
                    zzqn();
                    break;
                case 3:
                    zzqm();
                    break;
            }
        }
    }

    private void zzqn() {
        if (this.zzajM != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgh());
            this.zzajH.zzb(zzgh(), this.zzajM, zzql());
            this.zzajR.incrementAndGet();
        }
        this.zzajM = new zze(this, this.zzajR.get());
        if (!this.zzajH.zza(zzgh(), this.zzajM, zzql())) {
            Log.e("GmsClient", "unable to connect to service: " + zzgh());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzajR.get(), 9));
        }
    }

    private void zzqo() {
        if (this.zzajM != null) {
            this.zzajH.zzb(zzgh(), this.zzajM, zzql());
            this.zzajM = null;
        }
    }

    public void disconnect() {
        this.zzajR.incrementAndGet();
        synchronized (this.zzajL) {
            int size = this.zzajL.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.zzajL.get(i)).zzqy();
            }
            this.zzajL.clear();
        }
        zzb(1, null);
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        synchronized (this.zzpK) {
            int i = this.zzajN;
            IInterface iInterface = this.zzajK;
        }
        writer.append(prefix).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (iInterface == null) {
            writer.println("null");
        } else {
            writer.append(zzgi()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzaeK;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzajN == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzajN == 2;
        }
        return z;
    }

    protected void onConnectionFailed(ConnectionResult result) {
    }

    protected void onConnectionSuspended(int cause) {
    }

    protected abstract T zzW(IBinder iBinder);

    protected void zza(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzi(this, i, bundle)));
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(this, i, iBinder, bundle)));
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        this.zzajJ = (com.google.android.gms.common.api.GoogleApiClient.zza) zzx.zzb((Object) com_google_android_gms_common_api_GoogleApiClient_zza, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzp com_google_android_gms_common_internal_zzp) {
        try {
            this.zzajI.zza(new zzd(this, this.zzajR.get()), new ValidateAccountRequest(com_google_android_gms_common_internal_zzp, (Scope[]) this.zzVH.toArray(new Scope[this.zzVH.size()]), this.mContext.getPackageName(), zzqt()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbT(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void zza(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set) {
        try {
            GetServiceRequest zzj = new GetServiceRequest(this.zzajQ).zzcA(this.mContext.getPackageName()).zzj(zzlU());
            if (set != null) {
                zzj.zzd(set);
            }
            if (zzmn()) {
                zzj.zzc(zzpY()).zzc(com_google_android_gms_common_internal_zzp);
            } else if (zzqu()) {
                zzj.zzc(this.zzSo);
            }
            this.zzajI.zza(new zzd(this, this.zzajR.get()), zzj);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbT(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected Set<Scope> zzb(Set<Scope> set) {
        return set;
    }

    public void zzbT(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzajR.get(), i));
    }

    protected void zzbU(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, i, -1, new zzh(this)));
    }

    protected void zzc(int i, T t) {
    }

    protected abstract String zzgh();

    protected abstract String zzgi();

    protected Bundle zzlU() {
        return new Bundle();
    }

    public boolean zzmJ() {
        return false;
    }

    public Intent zzmK() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public boolean zzmn() {
        return false;
    }

    public Bundle zznQ() {
        return null;
    }

    public IBinder zzoC() {
        return this.zzajI == null ? null : this.zzajI.asBinder();
    }

    public final Account zzpY() {
        return this.zzSo != null ? this.zzSo : new Account("<<default account>>", GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    protected final String zzql() {
        return this.zzafT.zzqe();
    }

    protected void zzqm() {
    }

    public void zzqp() {
        int isGooglePlayServicesAvailable = this.zzaeL.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, null);
            this.zzajJ = new zzf(this);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzajR.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza(new zzf(this));
    }

    protected final zzf zzqq() {
        return this.zzafT;
    }

    protected final void zzqr() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzqs() throws DeadObjectException {
        T t;
        synchronized (this.zzpK) {
            if (this.zzajN == 4) {
                throw new DeadObjectException();
            }
            zzqr();
            zzx.zza(this.zzajK != null, (Object) "Client is connected but service is null");
            t = this.zzajK;
        }
        return t;
    }

    protected Bundle zzqt() {
        return null;
    }

    public boolean zzqu() {
        return false;
    }
}
