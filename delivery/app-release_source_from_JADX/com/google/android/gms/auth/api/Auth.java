package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzd;
import com.google.android.gms.auth.api.credentials.internal.zzf;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.auth.api.signin.internal.zzl;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzlb;
import java.util.Collections;
import java.util.List;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzUd, zzTX);
    public static final CredentialsApi CredentialsApi = new zzd();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzUh, zzUa);
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final Api<zza> PROXY_API = new Api("Auth.PROXY_API", zzUc, zzTW);
    public static final ProxyApi ProxyApi = new zzlb();
    public static final Api.zzc<zzkx> zzTW = new Api.zzc();
    public static final Api.zzc<zzf> zzTX = new Api.zzc();
    public static final Api.zzc<zzkq> zzTY = new Api.zzc();
    public static final Api.zzc<zzl> zzTZ = new Api.zzc();
    public static final Api.zzc<com.google.android.gms.auth.api.signin.internal.zzd> zzUa = new Api.zzc();
    public static final Api.zzc<zzku> zzUb = new Api.zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzkx, zza> zzUc = new C06281();
    private static final com.google.android.gms.common.api.Api.zza<zzf, AuthCredentialsOptions> zzUd = new C06292();
    private static final com.google.android.gms.common.api.Api.zza<zzkq, NoOptions> zzUe = new C06303();
    private static final com.google.android.gms.common.api.Api.zza<zzku, NoOptions> zzUf = new C06314();
    private static final com.google.android.gms.common.api.Api.zza<zzl, zzh> zzUg = new C06325();
    private static final com.google.android.gms.common.api.Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> zzUh = new C06336();
    public static final Api<zzh> zzUi = new Api("Auth.SIGN_IN_API", zzUg, zzTZ);
    public static final Api<NoOptions> zzUj = new Api("Auth.ACCOUNT_STATUS_API", zzUe, zzTY);
    public static final Api<NoOptions> zzUk = new Api("Auth.CONSENT_API", zzUf, zzUb);
    public static final zzko zzUl = new zzkp();
    public static final zzg zzUm = new zzk();
    public static final com.google.android.gms.auth.api.consent.zza zzUn = new zzkt();

    static class C06281 extends com.google.android.gms.common.api.Api.zza<zzkx, zza> {
        C06281() {
        }

        public zzkx zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_auth_api_Auth_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkx(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_Auth_zza, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06292 extends com.google.android.gms.common.api.Api.zza<zzf, AuthCredentialsOptions> {
        C06292() {
        }

        public zzf zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzf(context, looper, com_google_android_gms_common_internal_zzf, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06303 extends com.google.android.gms.common.api.Api.zza<zzkq, NoOptions> {
        C06303() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzkq zzc(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkq(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06314 extends com.google.android.gms.common.api.Api.zza<zzku, NoOptions> {
        C06314() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzd(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzku zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzku(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06325 extends com.google.android.gms.common.api.Api.zza<zzl, zzh> {
        C06325() {
        }

        public zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zzh com_google_android_gms_auth_api_signin_zzh, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_signin_zzh, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static class C06336 extends com.google.android.gms.common.api.Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> {
        C06336() {
        }

        public com.google.android.gms.auth.api.signin.internal.zzd zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.auth.api.signin.internal.zzd(context, looper, com_google_android_gms_common_internal_zzf, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public List<Scope> zza(GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzmu();
        }

        public /* synthetic */ List zzn(Object obj) {
            return zza((GoogleSignInOptions) obj);
        }
    }

    public static final class AuthCredentialsOptions implements Optional {
        private final String zzUo;
        private final PasswordSpecification zzUp;

        public static class Builder {
            private PasswordSpecification zzUp = PasswordSpecification.zzUO;
        }

        public Bundle zzlU() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzUo);
            bundle.putParcelable("password_specification", this.zzUp);
            return bundle;
        }

        public PasswordSpecification zzma() {
            return this.zzUp;
        }
    }

    public static final class zza implements Optional {
        private final Bundle zzUq;

        public Bundle zzmb() {
            return new Bundle(this.zzUq);
        }
    }

    private Auth() {
    }
}
