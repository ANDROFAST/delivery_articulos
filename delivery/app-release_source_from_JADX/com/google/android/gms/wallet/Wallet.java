package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zzsx;
import com.google.android.gms.wallet.wobs.zzj;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api("Wallet.API", zzTp, zzTo);
    public static final Payments Payments = new zzst();
    private static final zzc<zzsu> zzTo = new zzc();
    private static final com.google.android.gms.common.api.Api.zza<zzsu, WalletOptions> zzTp = new C07971();
    public static final zzj zzbkA = new zzsx();
    public static final com.google.android.gms.wallet.firstparty.zza zzbkB = new zzsw();

    static class C07971 extends com.google.android.gms.common.api.Api.zza<zzsu, WalletOptions> {
        C07971() {
        }

        public zzsu zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzsu(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, walletOptions.theme, walletOptions.zzbkC);
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;
        private final boolean zzbkC;

        public static final class Builder {
            private int mTheme = 0;
            private int zzbkD = 3;
            private boolean zzbkE = true;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1 || environment == 3) {
                    this.zzbkD = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }

            public Builder useGoogleWallet() {
                this.zzbkE = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzbkD;
            this.theme = builder.mTheme;
            this.zzbkC = builder.zzbkE;
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzsu> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzTo, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
