package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzi extends zzj<zzf> implements zzsc {
    private final zzf zzafT;
    private Integer zzajt;
    private final Bundle zzbbG;
    private final boolean zzbbX;

    private static class zza extends com.google.android.gms.signin.internal.zzd.zza {
        private final zzsd zzaeP;
        private final ExecutorService zzbbY;

        public zza(zzsd com_google_android_gms_internal_zzsd, ExecutorService executorService) {
            this.zzaeP = com_google_android_gms_internal_zzsd;
            this.zzbbY = executorService;
        }

        private ServerAuthCodeCallbacks zzDN() throws RemoteException {
            return this.zzaeP.zzDN();
        }

        public void zza(final String str, final String str2, final zzf com_google_android_gms_signin_internal_zzf) throws RemoteException {
            this.zzbbY.submit(new Runnable(this) {
                final /* synthetic */ zza zzbcc;

                public void run() {
                    try {
                        com_google_android_gms_signin_internal_zzf.zzat(this.zzbcc.zzDN().onUploadServerAuthCode(str, str2));
                    } catch (Throwable e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
                    }
                }
            });
        }

        public void zza(final String str, final List<Scope> list, final zzf com_google_android_gms_signin_internal_zzf) throws RemoteException {
            this.zzbbY.submit(new Runnable(this) {
                final /* synthetic */ zza zzbcc;

                public void run() {
                    try {
                        CheckResult onCheckServerAuthorization = this.zzbcc.zzDN().onCheckServerAuthorization(str, Collections.unmodifiableSet(new HashSet(list)));
                        com_google_android_gms_signin_internal_zzf.zza(new CheckServerAuthResult(onCheckServerAuthorization.zzoJ(), onCheckServerAuthorization.zzoK()));
                    } catch (Throwable e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
                    }
                }
            });
        }
    }

    public zzi(Context context, Looper looper, boolean z, zzf com_google_android_gms_common_internal_zzf, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzbbX = z;
        this.zzafT = com_google_android_gms_common_internal_zzf;
        this.zzbbG = bundle;
        this.zzajt = com_google_android_gms_common_internal_zzf.zzqh();
    }

    public zzi(Context context, Looper looper, boolean z, zzf com_google_android_gms_common_internal_zzf, zzsd com_google_android_gms_internal_zzsd, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ExecutorService executorService) {
        this(context, looper, z, com_google_android_gms_common_internal_zzf, zza(com_google_android_gms_internal_zzsd, com_google_android_gms_common_internal_zzf.zzqh(), executorService), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(zzsd com_google_android_gms_internal_zzsd, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", com_google_android_gms_internal_zzsd.zzDM());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", com_google_android_gms_internal_zzsd.zzmy());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", com_google_android_gms_internal_zzsd.zzmB());
        if (com_google_android_gms_internal_zzsd.zzDN() != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(com_google_android_gms_internal_zzsd, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", com_google_android_gms_internal_zzsd.zzDO());
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", com_google_android_gms_internal_zzsd.zzmA());
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", com_google_android_gms_internal_zzsd.zzDP());
        return bundle;
    }

    public void connect() {
        zza(new zzf(this));
    }

    public void zzDL() {
        try {
            ((zzf) zzqs()).zzjL(this.zzajt.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdX(iBinder);
    }

    public void zza(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set, zze com_google_android_gms_signin_internal_zze) {
        zzx.zzb((Object) com_google_android_gms_signin_internal_zze, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zzf) zzqs()).zza(new AuthAccountRequest(com_google_android_gms_common_internal_zzp, set), com_google_android_gms_signin_internal_zze);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                com_google_android_gms_signin_internal_zze.zza(new ConnectionResult(8, null), new AuthAccountResult(8, null));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public void zza(zzp com_google_android_gms_common_internal_zzp, boolean z) {
        try {
            ((zzf) zzqs()).zza(com_google_android_gms_common_internal_zzp, this.zzajt.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzt com_google_android_gms_common_internal_zzt) {
        zzx.zzb((Object) com_google_android_gms_common_internal_zzt, (Object) "Expecting a valid IResolveAccountCallbacks");
        try {
            Account zzpY = this.zzafT.zzpY();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(zzpY.name)) {
                googleSignInAccount = zzn.zzae(getContext()).zzmW();
            }
            ((zzf) zzqs()).zza(new ResolveAccountRequest(zzpY, this.zzajt.intValue(), googleSignInAccount), com_google_android_gms_common_internal_zzt);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                com_google_android_gms_common_internal_zzt.zzb(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected zzf zzdX(IBinder iBinder) {
        return com.google.android.gms.signin.internal.zzf.zza.zzdW(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle zzlU() {
        if (!getContext().getPackageName().equals(this.zzafT.zzqd())) {
            this.zzbbG.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzafT.zzqd());
        }
        return this.zzbbG;
    }

    public boolean zzmn() {
        return this.zzbbX;
    }
}
