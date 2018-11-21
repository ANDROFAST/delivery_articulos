package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzst implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzst zzbln;

            protected void zza(zzsu com_google_android_gms_internal_zzsu) {
                com_google_android_gms_internal_zzsu.zzf(str, str2, i);
                zzb(Status.zzaeX);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzst zzbln;

            protected void zza(zzsu com_google_android_gms_internal_zzsu) {
                com_google_android_gms_internal_zzsu.zzkV(requestCode);
                zzb(Status.zzaeX);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzst zzbln;

            protected void zza(zzsu com_google_android_gms_internal_zzsu) {
                com_google_android_gms_internal_zzsu.zzkW(requestCode);
                zzb(Status.zzaeX);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzst zzbln;

            protected void zza(zzsu com_google_android_gms_internal_zzsu) {
                com_google_android_gms_internal_zzsu.zza(request, requestCode);
                zzb(Status.zzaeX);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzst zzbln;

            protected void zza(zzsu com_google_android_gms_internal_zzsu) {
                com_google_android_gms_internal_zzsu.zza(request, requestCode);
                zzb(Status.zzaeX);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzst zzbln;

            protected void zza(zzsu com_google_android_gms_internal_zzsu) {
                com_google_android_gms_internal_zzsu.zza(request);
                zzb(Status.zzaeX);
            }
        });
    }
}
