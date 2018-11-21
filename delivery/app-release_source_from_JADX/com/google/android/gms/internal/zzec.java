package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

@zzha
class zzec {
    zzo zzpz;
    zzu zzzM;
    zzgc zzzN;
    zzcl zzzO;
    zzn zzzP;

    private class zza extends com.google.android.gms.ads.internal.client.zzo.zza {
        zzo zzzQ;
        final /* synthetic */ zzec zzzR;

        zza(zzec com_google_android_gms_internal_zzec, zzo com_google_android_gms_ads_internal_client_zzo) {
            this.zzzR = com_google_android_gms_internal_zzec;
            this.zzzQ = com_google_android_gms_ads_internal_client_zzo;
        }

        public void onAdClosed() throws RemoteException {
            this.zzzQ.onAdClosed();
            zzp.zzbI().zzdX();
        }

        public void onAdFailedToLoad(int errorCode) throws RemoteException {
            this.zzzQ.onAdFailedToLoad(errorCode);
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzzQ.onAdLeftApplication();
        }

        public void onAdLoaded() throws RemoteException {
            this.zzzQ.onAdLoaded();
        }

        public void onAdOpened() throws RemoteException {
            this.zzzQ.onAdOpened();
        }
    }

    zzec() {
    }

    void zzc(zzk com_google_android_gms_ads_internal_zzk) {
        if (this.zzpz != null) {
            com_google_android_gms_ads_internal_zzk.zza(new zza(this, this.zzpz));
        }
        if (this.zzzM != null) {
            com_google_android_gms_ads_internal_zzk.zza(this.zzzM);
        }
        if (this.zzzN != null) {
            com_google_android_gms_ads_internal_zzk.zza(this.zzzN);
        }
        if (this.zzzO != null) {
            com_google_android_gms_ads_internal_zzk.zza(this.zzzO);
        }
        if (this.zzzP != null) {
            com_google_android_gms_ads_internal_zzk.zza(this.zzzP);
        }
    }
}
