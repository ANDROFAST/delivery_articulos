package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzip;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzha
public abstract class zzb extends zza implements zzg, zzj, zzdn, zzeo {
    private final Messenger mMessenger;
    protected final zzew zzpd;
    protected transient boolean zzpe;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        this(new zzq(context, adSizeParcel, str, versionInfoParcel), com_google_android_gms_internal_zzew, null, com_google_android_gms_ads_internal_zzd);
    }

    zzb(zzq com_google_android_gms_ads_internal_zzq, zzew com_google_android_gms_internal_zzew, zzo com_google_android_gms_ads_internal_zzo, zzd com_google_android_gms_ads_internal_zzd) {
        super(com_google_android_gms_ads_internal_zzq, com_google_android_gms_ads_internal_zzo, com_google_android_gms_ads_internal_zzd);
        this.zzpd = com_google_android_gms_internal_zzew;
        this.mMessenger = new Messenger(new zzfz(this.zzoZ.context));
        this.zzpe = false;
    }

    private zza zza(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        int i;
        ApplicationInfo applicationInfo = this.zzoZ.context.getApplicationInfo();
        try {
            packageInfo = this.zzoZ.context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzoZ.context.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzoZ.zzqS == null || this.zzoZ.zzqS.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzoZ.zzqS.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.zzoZ.zzqS.getWidth();
            int height = this.zzoZ.zzqS.getHeight();
            i = 0;
            if (this.zzoZ.zzqS.isShown() && i2 + width > 0 && i3 + height > 0 && i2 <= displayMetrics.widthPixels && i3 <= displayMetrics.heightPixels) {
                i = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i2);
            bundle2.putInt("y", i3);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i);
        }
        String zzgK = zzp.zzbA().zzgK();
        this.zzoZ.zzqY = new zzif(zzgK, this.zzoZ.zzqP);
        this.zzoZ.zzqY.zzj(adRequestParcel);
        String zza = zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqS, this.zzoZ.zzqV);
        long j = 0;
        if (this.zzoZ.zzrc != null) {
            try {
                j = this.zzoZ.zzrc.getValue();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzp.zzbA().zza(this.zzoZ.context, this, zzgK);
        List arrayList = new ArrayList();
        for (i = 0; i < this.zzoZ.zzri.size(); i++) {
            arrayList.add(this.zzoZ.zzri.keyAt(i));
        }
        boolean z = this.zzoZ.zzrd != null;
        boolean z2 = this.zzoZ.zzre != null && zzp.zzbA().zzgT();
        return new zza(bundle2, adRequestParcel, this.zzoZ.zzqV, this.zzoZ.zzqP, applicationInfo, packageInfo, zzgK, zzp.zzbA().getSessionId(), this.zzoZ.zzqR, zza2, this.zzoZ.zzrl, arrayList, bundle, zzp.zzbA().zzgO(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, j, uuid, zzbz.zzdl(), this.zzoZ.zzqO, this.zzoZ.zzrj, new CapabilityParcel(z, z2), this.zzoZ.zzbU());
    }

    public String getMediationAdapterClassName() {
        return this.zzoZ.zzqW == null ? null : this.zzoZ.zzqW.zzBr;
    }

    public void onAdClicked() {
        if (this.zzoZ.zzqW == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzoZ.zzqW.zzJF == null || this.zzoZ.zzqW.zzJF.zzAQ == null)) {
            zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzJF.zzAQ);
        }
        if (!(this.zzoZ.zzqW.zzBp == null || this.zzoZ.zzqW.zzBp.zzAJ == null)) {
            zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAJ);
        }
        super.onAdClicked();
    }

    public void pause() {
        zzx.zzcx("pause must be called on the main UI thread.");
        if (!(this.zzoZ.zzqW == null || this.zzoZ.zzqW.zzDC == null || !this.zzoZ.zzbQ())) {
            zzp.zzbz().zzf(this.zzoZ.zzqW.zzDC);
        }
        if (!(this.zzoZ.zzqW == null || this.zzoZ.zzqW.zzBq == null)) {
            try {
                this.zzoZ.zzqW.zzBq.pause();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not pause mediation adapter.");
            }
        }
        this.zzpb.zzg(this.zzoZ.zzqW);
        this.zzoY.pause();
    }

    public void resume() {
        zzx.zzcx("resume must be called on the main UI thread.");
        if (!(this.zzoZ.zzqW == null || this.zzoZ.zzqW.zzDC == null || !this.zzoZ.zzbQ())) {
            zzp.zzbz().zzg(this.zzoZ.zzqW.zzDC);
        }
        if (!(this.zzoZ.zzqW == null || this.zzoZ.zzqW.zzBq == null)) {
            try {
                this.zzoZ.zzqW.zzBq.resume();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not resume mediation adapter.");
            }
        }
        this.zzoY.resume();
        this.zzpb.zzh(this.zzoZ.zzqW);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzgc com_google_android_gms_internal_zzgc) {
        zzx.zzcx("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzoZ.zzrd = com_google_android_gms_internal_zzgc;
    }

    public void zza(zzgg com_google_android_gms_internal_zzgg, String str) {
        zzx.zzcx("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzoZ.zzrm = new zzk(str);
        this.zzoZ.zzre = com_google_android_gms_internal_zzgg;
        if (!zzp.zzbA().zzgN() && com_google_android_gms_internal_zzgg != null) {
            new zzc(this.zzoZ.context, this.zzoZ.zzre, this.zzoZ.zzrm).zzgX();
        }
    }

    protected void zza(zzie com_google_android_gms_internal_zzie, boolean z) {
        if (com_google_android_gms_internal_zzie == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(com_google_android_gms_internal_zzie);
        if (!(com_google_android_gms_internal_zzie.zzJF == null || com_google_android_gms_internal_zzie.zzJF.zzAR == null)) {
            zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, com_google_android_gms_internal_zzie, this.zzoZ.zzqP, z, com_google_android_gms_internal_zzie.zzJF.zzAR);
        }
        if (com_google_android_gms_internal_zzie.zzBp != null && com_google_android_gms_internal_zzie.zzBp.zzAK != null) {
            zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, com_google_android_gms_internal_zzie, this.zzoZ.zzqP, z, com_google_android_gms_internal_zzie.zzBp.zzAK);
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzgb com_google_android_gms_ads_internal_purchase_zzd = new zzd(str, arrayList, this.zzoZ.context, this.zzoZ.zzqR.afmaVersion);
        if (this.zzoZ.zzrd == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzl.zzcN().zzT(this.zzoZ.context)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.zzoZ.zzre == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.zzoZ.zzrm == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.zzoZ.zzrq) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.zzoZ.zzrq = true;
                try {
                    if (this.zzoZ.zzre.isValidPurchase(str)) {
                        zzp.zzbH().zza(this.zzoZ.context, this.zzoZ.zzqR.zzLH, new GInAppPurchaseManagerInfoParcel(this.zzoZ.context, this.zzoZ.zzrm, com_google_android_gms_ads_internal_purchase_zzd, this));
                        return;
                    } else {
                        this.zzoZ.zzrq = false;
                        return;
                    }
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
                    this.zzoZ.zzrq = false;
                    return;
                }
            }
        }
        try {
            this.zzoZ.zzrd.zza(com_google_android_gms_ads_internal_purchase_zzd);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        try {
            if (this.zzoZ.zzre != null) {
                this.zzoZ.zzre.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzoZ.context, str, z, i, intent, com_google_android_gms_ads_internal_purchase_zzf));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to invoke PlayStorePurchaseListener.");
        }
        zzip.zzKO.postDelayed(new Runnable(this) {
            final /* synthetic */ zzb zzpg;

            public void run() {
                int zzd = zzp.zzbH().zzd(intent);
                zzp.zzbH();
                if (!(zzd != 0 || this.zzpg.zzoZ.zzqW == null || this.zzpg.zzoZ.zzqW.zzDC == null || this.zzpg.zzoZ.zzqW.zzDC.zzhA() == null)) {
                    this.zzpg.zzoZ.zzqW.zzDC.zzhA().close();
                }
                this.zzpg.zzoZ.zzrq = false;
            }
        }, 500);
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzch com_google_android_gms_internal_zzch) {
        if (!zzaW()) {
            return false;
        }
        Bundle zza = zza(zzp.zzbA().zzG(this.zzoZ.context));
        this.zzoY.cancel();
        this.zzoZ.zzrp = 0;
        zza zza2 = zza(adRequestParcel, zza);
        com_google_android_gms_internal_zzch.zzd("seq_num", zza2.zzGt);
        com_google_android_gms_internal_zzch.zzd("request_id", zza2.zzGF);
        com_google_android_gms_internal_zzch.zzd("session_id", zza2.zzGu);
        if (zza2.zzGr != null) {
            com_google_android_gms_internal_zzch.zzd("app_version", String.valueOf(zza2.zzGr.versionCode));
        }
        this.zzoZ.zzqT = zzp.zzbt().zza(this.zzoZ.context, zza2, this.zzoZ.zzqQ, this);
        return true;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzie com_google_android_gms_internal_zzie, boolean z) {
        if (!z && this.zzoZ.zzbQ()) {
            if (com_google_android_gms_internal_zzie.zzAU > 0) {
                this.zzoY.zza(adRequestParcel, com_google_android_gms_internal_zzie.zzAU);
            } else if (com_google_android_gms_internal_zzie.zzJF != null && com_google_android_gms_internal_zzie.zzJF.zzAU > 0) {
                this.zzoY.zza(adRequestParcel, com_google_android_gms_internal_zzie.zzJF.zzAU);
            } else if (!com_google_android_gms_internal_zzie.zzGN && com_google_android_gms_internal_zzie.errorCode == 2) {
                this.zzoY.zzg(adRequestParcel);
            }
        }
        return this.zzoY.zzbr();
    }

    boolean zza(zzie com_google_android_gms_internal_zzie) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzpa != null) {
            adRequestParcel = this.zzpa;
            this.zzpa = null;
        } else {
            adRequestParcel = com_google_android_gms_internal_zzie.zzGq;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, com_google_android_gms_internal_zzie, z);
    }

    protected boolean zza(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2) {
        int i;
        int i2 = 0;
        if (!(com_google_android_gms_internal_zzie == null || com_google_android_gms_internal_zzie.zzBs == null)) {
            com_google_android_gms_internal_zzie.zzBs.zza(null);
        }
        if (com_google_android_gms_internal_zzie2.zzBs != null) {
            com_google_android_gms_internal_zzie2.zzBs.zza((zzeo) this);
        }
        if (com_google_android_gms_internal_zzie2.zzJF != null) {
            i = com_google_android_gms_internal_zzie2.zzJF.zzAZ;
            i2 = com_google_android_gms_internal_zzie2.zzJF.zzBa;
        } else {
            i = 0;
        }
        this.zzoZ.zzrn.zzg(i, i2);
        return true;
    }

    protected boolean zzaW() {
        return zzp.zzbx().zza(this.zzoZ.context.getPackageManager(), this.zzoZ.context.getPackageName(), "android.permission.INTERNET") && zzp.zzbx().zzJ(this.zzoZ.context);
    }

    public void zzaX() {
        this.zzpb.zze(this.zzoZ.zzqW);
        this.zzpe = false;
        zzaS();
        this.zzoZ.zzqY.zzgF();
    }

    public void zzaY() {
        this.zzpe = true;
        zzaU();
    }

    public void zzaZ() {
        onAdClicked();
    }

    public void zzb(zzie com_google_android_gms_internal_zzie) {
        super.zzb(com_google_android_gms_internal_zzie);
        if (com_google_android_gms_internal_zzie.errorCode == 3 && com_google_android_gms_internal_zzie.zzJF != null && com_google_android_gms_internal_zzie.zzJF.zzAS != null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging no fill URLs.");
            zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, com_google_android_gms_internal_zzie, this.zzoZ.zzqP, false, com_google_android_gms_internal_zzie.zzJF.zzAS);
        }
    }

    public void zzba() {
        zzaX();
    }

    public void zzbb() {
        zzaQ();
    }

    public void zzbc() {
        zzaY();
    }

    public void zzbd() {
        if (this.zzoZ.zzqW != null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Mediation adapter " + this.zzoZ.zzqW.zzBr + " refreshed, but mediation adapters should never refresh.");
        }
        zza(this.zzoZ.zzqW, true);
        zzaV();
    }

    protected boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzpe;
    }
}
