package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zzqe extends zzj<zzqg> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzTD;
    private zza zzaJP;

    public static final class zza extends com.google.android.gms.internal.zzqf.zza {
        private Activity mActivity;
        private final int zzaeU;

        public zza(int i, Activity activity) {
            this.zzaeU = i;
            this.mActivity = activity;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void zzh(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.mActivity.createPendingResult(this.zzaeU, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.mActivity, this.zzaeU);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.mActivity.createPendingResult(this.zzaeU, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public zzqe(Activity activity, Looper looper, zzf com_google_android_gms_common_internal_zzf, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzTD = com_google_android_gms_common_internal_zzf.getAccountName();
        this.mActivity = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzaJP != null) {
            this.zzaJP.setActivity(null);
            this.zzaJP = null;
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzca(iBinder);
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzxL();
        this.zzaJP = new zza(i, this.mActivity);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzTD)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzTD, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzxK().zza(this.zzaJP, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzaJP.zzh(1, bundle);
        }
    }

    protected zzqg zzca(IBinder iBinder) {
        return com.google.android.gms.internal.zzqg.zza.zzcc(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String zzgi() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public boolean zzqu() {
        return true;
    }

    protected zzqg zzxK() throws DeadObjectException {
        return (zzqg) super.zzqs();
    }

    protected void zzxL() {
        super.zzqr();
    }
}
