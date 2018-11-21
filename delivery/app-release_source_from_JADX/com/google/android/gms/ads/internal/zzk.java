package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjn;

@zzha
public class zzk extends zzc implements zzdp {
    protected transient boolean zzpR = false;
    private boolean zzpS;
    private float zzpT;
    private String zzpU = ("background" + hashCode() + "." + "png");

    @zzha
    private class zza extends zzil {
        private final String zzpV;
        final /* synthetic */ zzk zzpW;

        public zza(zzk com_google_android_gms_ads_internal_zzk, String str) {
            this.zzpW = com_google_android_gms_ads_internal_zzk;
            this.zzpV = str;
        }

        public void onStop() {
        }

        public void zzbp() {
            zzp.zzbx().zzf(this.zzpW.zzoZ.context, this.zzpV);
        }
    }

    @zzha
    private class zzb extends zzil {
        private final String zzpV;
        final /* synthetic */ zzk zzpW;
        private final Bitmap zzpX;

        public zzb(zzk com_google_android_gms_ads_internal_zzk, Bitmap bitmap, String str) {
            this.zzpW = com_google_android_gms_ads_internal_zzk;
            this.zzpX = bitmap;
            this.zzpV = str;
        }

        public void onStop() {
        }

        public void zzbp() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzpW.zzoZ.zzqa, this.zzpW.zzbn(), this.zzpW.zzoZ.zzqa ? zzp.zzbx().zza(this.zzpW.zzoZ.context, this.zzpX, this.zzpV) : false ? this.zzpV : null, this.zzpW.zzpS, this.zzpW.zzpT);
            int requestedOrientation = this.zzpW.zzoZ.zzqW.zzDC.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzpW.zzoZ.zzqW.orientation;
            }
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this.zzpW, this.zzpW, this.zzpW, this.zzpW.zzoZ.zzqW.zzDC, requestedOrientation, this.zzpW.zzoZ.zzqR, this.zzpW.zzoZ.zzqW.zzGS, interstitialAdParameterParcel);
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzb zzpZ;

                public void run() {
                    zzp.zzbv().zza(this.zzpZ.zzpW.zzoZ.context, adOverlayInfoParcel);
                }
            });
        }
    }

    public zzk(Context context, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzew, versionInfoParcel, com_google_android_gms_ads_internal_zzd);
    }

    private void zzb(Bundle bundle) {
        zzp.zzbx().zzb(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, "gmob-apps", bundle, false);
    }

    public void showInterstitial() {
        zzx.zzcx("showInterstitial must be called on the main UI thread.");
        if (this.zzoZ.zzqW == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzbz.zzws.get()).booleanValue()) {
            Bundle bundle;
            String packageName = this.zzoZ.context.getApplicationContext() != null ? this.zzoZ.context.getApplicationContext().getPackageName() : this.zzoZ.context.getPackageName();
            if (!this.zzpR) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zzb(bundle);
            }
            if (!zzp.zzbx().zzP(this.zzoZ.context)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                zzb(bundle);
            }
        }
        if (!this.zzoZ.zzbR()) {
            if (this.zzoZ.zzqW.zzGN) {
                try {
                    this.zzoZ.zzqW.zzBq.showInterstitial();
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial.", e);
                    zzbo();
                }
            } else if (this.zzoZ.zzqW.zzDC == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("The interstitial failed to load.");
            } else if (this.zzoZ.zzqW.zzDC.zzhG()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("The interstitial is already showing.");
            } else {
                this.zzoZ.zzqW.zzDC.zzD(true);
                if (this.zzoZ.zzqW.zzJE != null) {
                    this.zzpb.zza(this.zzoZ.zzqV, this.zzoZ.zzqW);
                }
                Bitmap zzQ = this.zzoZ.zzqa ? zzp.zzbx().zzQ(this.zzoZ.context) : null;
                if (!((Boolean) zzbz.zzwI.get()).booleanValue() || zzQ == null) {
                    InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzoZ.zzqa, zzbn(), null, false, 0.0f);
                    int requestedOrientation = this.zzoZ.zzqW.zzDC.getRequestedOrientation();
                    if (requestedOrientation == -1) {
                        requestedOrientation = this.zzoZ.zzqW.orientation;
                    }
                    zzp.zzbv().zza(this.zzoZ.context, new AdOverlayInfoParcel(this, this, this, this.zzoZ.zzqW.zzDC, requestedOrientation, this.zzoZ.zzqR, this.zzoZ.zzqW.zzGS, interstitialAdParameterParcel));
                    return;
                }
                new zzb(this, zzQ, this.zzpU).zzgX();
            }
        }
    }

    protected zzjn zza(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, zze com_google_android_gms_ads_internal_zze) {
        zzjn zza = zzp.zzby().zza(this.zzoZ.context, this.zzoZ.zzqV, false, false, this.zzoZ.zzqQ, this.zzoZ.zzqR, this.zzoU, this.zzpc);
        zza.zzhC().zzb(this, null, this, this, ((Boolean) zzbz.zzwa.get()).booleanValue(), this, this, com_google_android_gms_ads_internal_zze, null);
        zza.zzaJ(com_google_android_gms_internal_zzie_zza.zzJK.zzGF);
        return zza;
    }

    public void zza(boolean z, float f) {
        this.zzpS = z;
        this.zzpT = f;
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzch com_google_android_gms_internal_zzch) {
        if (this.zzoZ.zzqW == null) {
            return super.zza(adRequestParcel, com_google_android_gms_internal_zzch);
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("An interstitial is already loading. Aborting.");
        return false;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzie com_google_android_gms_internal_zzie, boolean z) {
        if (this.zzoZ.zzbQ() && com_google_android_gms_internal_zzie.zzDC != null) {
            zzp.zzbz().zzf(com_google_android_gms_internal_zzie.zzDC);
        }
        return this.zzoY.zzbr();
    }

    public boolean zza(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2) {
        if (!super.zza(com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzie2)) {
            return false;
        }
        if (!(this.zzoZ.zzbQ() || this.zzoZ.zzro == null || com_google_android_gms_internal_zzie2.zzJE == null)) {
            this.zzpb.zza(this.zzoZ.zzqV, com_google_android_gms_internal_zzie2, this.zzoZ.zzro);
        }
        return true;
    }

    protected boolean zzaS() {
        zzbo();
        return super.zzaS();
    }

    protected boolean zzaV() {
        if (!super.zzaV()) {
            return false;
        }
        this.zzpR = true;
        return true;
    }

    public void zzaY() {
        recordImpression();
        super.zzaY();
    }

    protected boolean zzbn() {
        if (!(this.zzoZ.context instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzoZ.context).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void zzbo() {
        new zza(this, this.zzpU).zzgX();
        if (this.zzoZ.zzbQ()) {
            this.zzoZ.zzbN();
            this.zzoZ.zzqW = null;
            this.zzoZ.zzqa = false;
            this.zzpR = false;
        }
    }

    public void zzd(boolean z) {
        this.zzoZ.zzqa = z;
    }
}
