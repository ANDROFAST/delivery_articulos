package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

public class zzsu extends zzj<zzsp> {
    private final Context mContext;
    private final int mTheme;
    private final String zzTD;
    private final int zzbkD;
    private final boolean zzbkE;

    private static class zza extends com.google.android.gms.internal.zzss.zza {
        private zza() {
        }

        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void zza(int i, boolean z, Bundle bundle) {
        }

        public void zza(Status status, Bundle bundle) {
        }

        public void zza(Status status, GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Bundle bundle) {
        }

        public void zza(Status status, GetInstrumentsResponse getInstrumentsResponse, Bundle bundle) {
        }

        public void zzb(int i, boolean z, Bundle bundle) {
        }

        public void zzj(int i, Bundle bundle) {
        }
    }

    static final class zzb extends zza {
        private final int zzaeU;
        private final WeakReference<Activity> zzblt;

        public zzb(Context context, int i) {
            super();
            this.zzblt = new WeakReference((Activity) context);
            this.zzaeU = i;
        }

        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
            Activity activity = (Activity) this.zzblt.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
                return;
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzaeU);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = activity.createPendingResult(this.zzaeU, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
            Activity activity = (Activity) this.zzblt.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
                return;
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzaeU);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = activity.createPendingResult(this.zzaeU, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void zza(int i, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzblt.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzaeU, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void zzb(int i, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzblt.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_NEW_USER, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzaeU, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void zzj(int i, Bundle bundle) {
            zzx.zzb((Object) bundle, (Object) "Bundle should not be null");
            Activity activity = (Activity) this.zzblt.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzaeU);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzaeU, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public zzsu(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, int i2, boolean z) {
        super(context, looper, 4, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzbkD = i;
        this.zzTD = com_google_android_gms_common_internal_zzf.getAccountName();
        this.mTheme = i2;
        this.zzbkE = z;
    }

    private Bundle zzGs() {
        return zza(this.zzbkD, this.mContext.getPackageName(), this.zzTD, this.mTheme, this.zzbkE);
    }

    public static Bundle zza(int i, String str, String str2, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", z);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzek(iBinder);
    }

    public void zza(FullWalletRequest fullWalletRequest, int i) {
        zzss com_google_android_gms_internal_zzsu_zzb = new zzb(this.mContext, i);
        try {
            ((zzsp) zzqs()).zza(fullWalletRequest, zzGs(), com_google_android_gms_internal_zzsu_zzb);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            com_google_android_gms_internal_zzsu_zzb.zza(8, null, Bundle.EMPTY);
        }
    }

    public void zza(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle zzGs = zzGs();
        zzss com_google_android_gms_internal_zzsu_zzb = new zzb(this.mContext, i);
        try {
            ((zzsp) zzqs()).zza(maskedWalletRequest, zzGs, com_google_android_gms_internal_zzsu_zzb);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            com_google_android_gms_internal_zzsu_zzb.zza(8, null, Bundle.EMPTY);
        }
    }

    public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((zzsp) zzqs()).zza(notifyTransactionStatusRequest, zzGs());
        } catch (RemoteException e) {
        }
    }

    protected zzsp zzek(IBinder iBinder) {
        return com.google.android.gms.internal.zzsp.zza.zzeg(iBinder);
    }

    public void zzf(String str, String str2, int i) {
        Bundle zzGs = zzGs();
        Object com_google_android_gms_internal_zzsu_zzb = new zzb(this.mContext, i);
        try {
            ((zzsp) zzqs()).zza(str, str2, zzGs, com_google_android_gms_internal_zzsu_zzb);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            com_google_android_gms_internal_zzsu_zzb.zza(8, null, Bundle.EMPTY);
        }
    }

    protected String zzgh() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String zzgi() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void zzkV(int i) {
        Bundle zzGs = zzGs();
        zzss com_google_android_gms_internal_zzsu_zzb = new zzb(this.mContext, i);
        try {
            ((zzsp) zzqs()).zza(zzGs, com_google_android_gms_internal_zzsu_zzb);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            com_google_android_gms_internal_zzsu_zzb.zza(8, false, Bundle.EMPTY);
        }
    }

    public void zzkW(int i) {
        Bundle zzGs = zzGs();
        Object com_google_android_gms_internal_zzsu_zzb = new zzb(this.mContext, i);
        try {
            ((zzsp) zzqs()).zzb(zzGs, com_google_android_gms_internal_zzsu_zzb);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during isNewUser", e);
            com_google_android_gms_internal_zzsu_zzb.zzb(8, false, Bundle.EMPTY);
        }
    }

    public boolean zzqu() {
        return true;
    }
}
