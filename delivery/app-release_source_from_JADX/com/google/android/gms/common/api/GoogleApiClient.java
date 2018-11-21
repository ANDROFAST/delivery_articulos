package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zzaez = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzSo;
        private String zzTz;
        private final Set<Scope> zzaeA;
        private final Set<Scope> zzaeB;
        private int zzaeC;
        private View zzaeD;
        private String zzaeE;
        private final Map<Api<?>, com.google.android.gms.common.internal.zzf.zza> zzaeF;
        private final Map<Api<?>, ApiOptions> zzaeG;
        private FragmentActivity zzaeH;
        private int zzaeI;
        private OnConnectionFailedListener zzaeJ;
        private Looper zzaeK;
        private GoogleApiAvailability zzaeL;
        private com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> zzaeM;
        private final ArrayList<ConnectionCallbacks> zzaeN;
        private final ArrayList<OnConnectionFailedListener> zzaeO;
        private zzsd zzaeP;

        public Builder(Context context) {
            this.zzaeA = new HashSet();
            this.zzaeB = new HashSet();
            this.zzaeF = new ArrayMap();
            this.zzaeG = new ArrayMap();
            this.zzaeI = -1;
            this.zzaeL = GoogleApiAvailability.getInstance();
            this.zzaeM = zzsa.zzTp;
            this.zzaeN = new ArrayList();
            this.zzaeO = new ArrayList();
            this.mContext = context;
            this.zzaeK = context.getMainLooper();
            this.zzTz = context.getPackageName();
            this.zzaeE = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            zzx.zzb((Object) connectedListener, (Object) "Must provide a connected listener");
            this.zzaeN.add(connectedListener);
            zzx.zzb((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzaeO.add(connectionFailedListener);
        }

        private static <C extends zzb, O> C zza(com.google.android.gms.common.api.Api.zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return com_google_android_gms_common_api_Api_zza_C__O.zza(context, looper, com_google_android_gms_common_internal_zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private static <C extends zzd, O> zzad zza(zze<C, O> com_google_android_gms_common_api_Api_zze_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, com_google_android_gms_common_api_Api_zze_C__O.zzoD(), connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_api_Api_zze_C__O.zzp(obj));
        }

        private <O extends ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            Set hashSet = new HashSet(api.zzoy().zzn(o));
            int length = scopeArr.length;
            while (i2 < length) {
                hashSet.add(scopeArr[i2]);
                i2++;
            }
            this.zzaeF.put(api, new com.google.android.gms.common.internal.zzf.zza(hashSet, z));
        }

        private void zza(zzmr com_google_android_gms_internal_zzmr, GoogleApiClient googleApiClient) {
            com_google_android_gms_internal_zzmr.zza(this.zzaeI, googleApiClient, this.zzaeJ);
        }

        private void zzd(final GoogleApiClient googleApiClient) {
            zzmr zza = zzmr.zza(this.zzaeH);
            if (zza == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ Builder zzaeQ;

                    public void run() {
                        if (!this.zzaeQ.zzaeH.isFinishing() && !this.zzaeQ.zzaeH.getSupportFragmentManager().isDestroyed()) {
                            this.zzaeQ.zza(zzmr.zzb(this.zzaeQ.zzaeH), googleApiClient);
                        }
                    }
                });
            } else {
                zza(zza, googleApiClient);
            }
        }

        private GoogleApiClient zzoI() {
            zzf zzoH = zzoH();
            Api api = null;
            Map zzqc = zzoH.zzqc();
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api2 = null;
            for (Api api3 : this.zzaeG.keySet()) {
                Api api32;
                zzb zza;
                Api api4;
                Object obj = this.zzaeG.get(api32);
                int i = 0;
                if (zzqc.get(api32) != null) {
                    i = ((com.google.android.gms.common.internal.zzf.zza) zzqc.get(api32)).zzaju ? 1 : 2;
                }
                arrayMap.put(api32, Integer.valueOf(i));
                ConnectionCallbacks com_google_android_gms_internal_zzlz = new zzlz(api32, i);
                arrayList.add(com_google_android_gms_internal_zzlz);
                Api api5;
                if (api32.zzoB()) {
                    zze zzoz = api32.zzoz();
                    api5 = zzoz.getPriority() == 1 ? api32 : api2;
                    zza = zza(zzoz, obj, this.mContext, this.zzaeK, zzoH, com_google_android_gms_internal_zzlz, (OnConnectionFailedListener) com_google_android_gms_internal_zzlz);
                    api4 = api5;
                } else {
                    com.google.android.gms.common.api.Api.zza zzoy = api32.zzoy();
                    api5 = zzoy.getPriority() == 1 ? api32 : api2;
                    zza = zza(zzoy, obj, this.mContext, this.zzaeK, zzoH, com_google_android_gms_internal_zzlz, (OnConnectionFailedListener) com_google_android_gms_internal_zzlz);
                    api4 = api5;
                }
                arrayMap2.put(api32.zzoA(), zza);
                if (!zza.zzmJ()) {
                    api32 = api;
                } else if (api != null) {
                    throw new IllegalStateException(api32.getName() + " cannot be used with " + api.getName());
                }
                api2 = api4;
                api = api32;
            }
            if (api != null) {
                if (api2 != null) {
                    throw new IllegalStateException(api.getName() + " cannot be used with " + api2.getName());
                }
                zzx.zza(this.zzSo == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                zzx.zza(this.zzaeA.equals(this.zzaeB), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
                zzx.zza(this.zzaeP == null, "Must not call requestServerAuthCode in GoogleApiClient.Builder when using %s. Call requestServerAuthCode in GoogleSignInOptions.Builder instead.", api.getName());
            }
            return new zzmg(this.mContext, new ReentrantLock(), this.zzaeK, zzoH, this.zzaeL, this.zzaeM, arrayMap, this.zzaeN, this.zzaeO, arrayMap2, this.zzaeI, zzmg.zza(arrayMap2.values(), true), arrayList);
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            this.zzaeG.put(api, null);
            Collection zzn = api.zzoy().zzn(null);
            this.zzaeB.addAll(zzn);
            this.zzaeA.addAll(zzn);
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O options) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            zzx.zzb((Object) options, (Object) "Null options are not permitted for this Api");
            this.zzaeG.put(api, options);
            Collection zzn = api.zzoy().zzn(options);
            this.zzaeB.addAll(zzn);
            this.zzaeA.addAll(zzn);
            return this;
        }

        public <O extends HasOptions> Builder addApiIfAvailable(Api<O> api, O options, Scope... scopes) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            zzx.zzb((Object) options, (Object) "Null options are not permitted for this Api");
            this.zzaeG.put(api, options);
            zza(api, options, 1, scopes);
            return this;
        }

        public Builder addApiIfAvailable(Api<? extends NotRequiredOptions> api, Scope... scopes) {
            zzx.zzb((Object) api, (Object) "Api must not be null");
            this.zzaeG.put(api, null);
            zza(api, null, 1, scopes);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            zzx.zzb((Object) listener, (Object) "Listener must not be null");
            this.zzaeN.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            zzx.zzb((Object) listener, (Object) "Listener must not be null");
            this.zzaeO.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            zzx.zzb((Object) scope, (Object) "Scope must not be null");
            this.zzaeA.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzaeG.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzoI = zzoI();
            synchronized (GoogleApiClient.zzaez) {
                GoogleApiClient.zzaez.add(zzoI);
            }
            if (this.zzaeI >= 0) {
                zzd(zzoI);
            }
            return zzoI;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int clientId, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            zzx.zzb(clientId >= 0, (Object) "clientId must be non-negative");
            this.zzaeI = clientId;
            this.zzaeH = (FragmentActivity) zzx.zzb((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.zzaeJ = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, unresolvedConnectionFailedListener);
        }

        @Deprecated
        public Builder requestServerAuthCode(String serverClientId, ServerAuthCodeCallbacks callbacks) {
            this.zzaeP = new com.google.android.gms.internal.zzsd.zza().zza(serverClientId, callbacks).zzDQ();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzSo = accountName == null ? null : new Account(accountName, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.zzaeC = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzx.zzb((Object) handler, (Object) "Handler must not be null");
            this.zzaeK = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            zzx.zzb((Object) viewForPopups, (Object) "View must not be null");
            this.zzaeD = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoH() {
            if (this.zzaeG.containsKey(zzsa.API)) {
                zzx.zza(this.zzaeP == null, (Object) "SignIn.API can't be used in conjunction with requestServerAuthCode.");
                this.zzaeP = (zzsd) this.zzaeG.get(zzsa.API);
            }
            return new zzf(this.zzSo, this.zzaeA, this.zzaeF, this.zzaeC, this.zzaeD, this.zzTz, this.zzaeE, this.zzaeP != null ? this.zzaeP : zzsd.zzbbH);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface ServerAuthCodeCallbacks {

        public static class CheckResult {
            private Set<Scope> zzVH;
            private boolean zzaeR;

            private CheckResult(boolean requiresNewAuthCode, Set<Scope> requiredScopes) {
                this.zzaeR = requiresNewAuthCode;
                this.zzVH = requiredScopes;
            }

            public static CheckResult newAuthNotRequiredResult() {
                return new CheckResult(false, null);
            }

            public static CheckResult newAuthRequiredResult(Set<Scope> requiredScopes) {
                boolean z = (requiredScopes == null || requiredScopes.isEmpty()) ? false : true;
                zzx.zzb(z, (Object) "A non-empty scope set is required if further auth is needed.");
                return new CheckResult(true, requiredScopes);
            }

            public boolean zzoJ() {
                return this.zzaeR;
            }

            public Set<Scope> zzoK() {
                return this.zzVH;
            }
        }

        CheckResult onCheckServerAuthorization(String str, Set<Scope> set);

        boolean onUploadServerAuthCode(String str, String str2);
    }

    public interface zza {
        void zza(ConnectionResult connectionResult);

        void zzb(ConnectionResult connectionResult);
    }

    public static void dumpAll(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        synchronized (zzaez) {
            String str = prefix + "  ";
            int i = 0;
            for (GoogleApiClient googleApiClient : zzaez) {
                int i2 = i + 1;
                writer.append(prefix).append("GoogleApiClient#").println(i);
                googleApiClient.dump(str, fd, writer, args);
                i = i2;
            }
        }
    }

    public static Set<GoogleApiClient> zzoE() {
        return zzaez;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int signInMode) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <C extends zzb> C zza(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T zza(T t) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzmp com_google_android_gms_internal_zzmp) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T zzb(T t) {
        throw new UnsupportedOperationException();
    }

    public void zzoF() {
        throw new UnsupportedOperationException();
    }

    public <L> zzmn<L> zzq(L l) {
        throw new UnsupportedOperationException();
    }
}
