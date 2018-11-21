package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.internal.zzg.zza;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzd extends zzj<zzg> {
    private final GoogleSignInOptions zzVZ;

    public zzd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        if (googleSignInOptions == null) {
            googleSignInOptions = new Builder().build();
        }
        if (!com_google_android_gms_common_internal_zzf.zzqb().isEmpty()) {
            Builder builder = new Builder(googleSignInOptions);
            for (Scope requestScopes : com_google_android_gms_common_internal_zzf.zzqb()) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzVZ = googleSignInOptions;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaB(iBinder);
    }

    protected zzg zzaB(IBinder iBinder) {
        return zza.zzaD(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public boolean zzmJ() {
        return true;
    }

    public Intent zzmK() {
        Parcelable zzmF = new zzh.zza(getContext().getPackageName()).zzh(this.zzVZ).zzmG().zzmF();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(getContext(), SignInHubActivity.class);
        intent.putExtra("config", zzmF);
        return intent;
    }

    public GoogleSignInOptions zzmL() {
        return this.zzVZ;
    }
}
