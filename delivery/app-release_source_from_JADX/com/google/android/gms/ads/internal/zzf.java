package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import java.util.List;

@zzha
public class zzf extends zzc {
    private boolean zzpt;

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzew, versionInfoParcel, com_google_android_gms_ads_internal_zzd);
    }

    private AdSizeParcel zzb(zza com_google_android_gms_internal_zzie_zza) {
        if (com_google_android_gms_internal_zzie_zza.zzJL.zztZ) {
            return this.zzoZ.zzqV;
        }
        AdSize adSize;
        String str = com_google_android_gms_internal_zzie_zza.zzJL.zzGQ;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            adSize = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            adSize = this.zzoZ.zzqV.zzcL();
        }
        return new AdSizeParcel(this.zzoZ.context, adSize);
    }

    private boolean zzb(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2) {
        View view;
        if (com_google_android_gms_internal_zzie2.zzGN) {
            try {
                zzd view2 = com_google_android_gms_internal_zzie2.zzBq.getView();
                if (view2 == null) {
                    zzb.zzaH("View in mediation adapter is null.");
                    return false;
                }
                view = (View) zze.zzp(view2);
                View nextView = this.zzoZ.zzqS.getNextView();
                if (nextView != null) {
                    if (nextView instanceof zzjn) {
                        ((zzjn) nextView).destroy();
                    }
                    this.zzoZ.zzqS.removeView(nextView);
                }
                try {
                    zzb(view);
                } catch (Throwable th) {
                    zzb.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                zzb.zzd("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (!(com_google_android_gms_internal_zzie2.zzJG == null || com_google_android_gms_internal_zzie2.zzDC == null)) {
            com_google_android_gms_internal_zzie2.zzDC.zza(com_google_android_gms_internal_zzie2.zzJG);
            this.zzoZ.zzqS.removeAllViews();
            this.zzoZ.zzqS.setMinimumWidth(com_google_android_gms_internal_zzie2.zzJG.widthPixels);
            this.zzoZ.zzqS.setMinimumHeight(com_google_android_gms_internal_zzie2.zzJG.heightPixels);
            zzb(com_google_android_gms_internal_zzie2.zzDC.getView());
        }
        if (this.zzoZ.zzqS.getChildCount() > 1) {
            this.zzoZ.zzqS.showNext();
        }
        if (com_google_android_gms_internal_zzie != null) {
            view = this.zzoZ.zzqS.getNextView();
            if (view instanceof zzjn) {
                ((zzjn) view).zza(this.zzoZ.context, this.zzoZ.zzqV, this.zzoU);
            } else if (view != null) {
                this.zzoZ.zzqS.removeView(view);
            }
            this.zzoZ.zzbP();
        }
        this.zzoZ.zzqS.setVisibility(0);
        return true;
    }

    public void setManualImpressionsEnabled(boolean enabled) {
        zzx.zzcx("setManualImpressionsEnabled must be called from the main thread.");
        this.zzpt = enabled;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    protected zzjn zza(zza com_google_android_gms_internal_zzie_zza, zze com_google_android_gms_ads_internal_zze) {
        if (this.zzoZ.zzqV.zztZ) {
            this.zzoZ.zzqV = zzb(com_google_android_gms_internal_zzie_zza);
        }
        return super.zza(com_google_android_gms_internal_zzie_zza, com_google_android_gms_ads_internal_zze);
    }

    public boolean zza(zzie com_google_android_gms_internal_zzie, final zzie com_google_android_gms_internal_zzie2) {
        if (!super.zza(com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzie2)) {
            return false;
        }
        if (!this.zzoZ.zzbQ() || zzb(com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzie2)) {
            zza(com_google_android_gms_internal_zzie2, false);
            if (this.zzoZ.zzbQ()) {
                if (com_google_android_gms_internal_zzie2.zzDC != null) {
                    if (com_google_android_gms_internal_zzie2.zzJE != null) {
                        this.zzpb.zza(this.zzoZ.zzqV, com_google_android_gms_internal_zzie2);
                    }
                    if (com_google_android_gms_internal_zzie2.zzcb()) {
                        this.zzpb.zza(this.zzoZ.zzqV, com_google_android_gms_internal_zzie2).zza(com_google_android_gms_internal_zzie2.zzDC);
                    } else {
                        com_google_android_gms_internal_zzie2.zzDC.zzhC().zza(new zzjo.zzb(this) {
                            final /* synthetic */ zzf zzpv;

                            public void zzbh() {
                                this.zzpv.zzpb.zza(this.zzpv.zzoZ.zzqV, com_google_android_gms_internal_zzie2).zza(com_google_android_gms_internal_zzie2.zzDC);
                            }
                        });
                    }
                }
            } else if (!(this.zzoZ.zzro == null || com_google_android_gms_internal_zzie2.zzJE == null)) {
                this.zzpb.zza(this.zzoZ.zzqV, com_google_android_gms_internal_zzie2, this.zzoZ.zzro);
            }
            return true;
        }
        zzf(0);
        return false;
    }

    protected boolean zzaW() {
        boolean z = true;
        if (!zzp.zzbx().zza(this.zzoZ.context.getPackageManager(), this.zzoZ.context.getPackageName(), "android.permission.INTERNET")) {
            zzl.zzcN().zza(this.zzoZ.zzqS, this.zzoZ.zzqV, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzp.zzbx().zzJ(this.zzoZ.context)) {
            zzl.zzcN().zza(this.zzoZ.zzqS, this.zzoZ.zzqV, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.zzoZ.zzqS == null)) {
            this.zzoZ.zzqS.setVisibility(0);
        }
        return z;
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(zze(adRequestParcel));
    }

    AdRequestParcel zze(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zztv == this.zzpt) {
            return adRequestParcel;
        }
        int i = adRequestParcel.versionCode;
        long j = adRequestParcel.zztq;
        Bundle bundle = adRequestParcel.extras;
        int i2 = adRequestParcel.zztr;
        List list = adRequestParcel.zzts;
        boolean z = adRequestParcel.zztt;
        int i3 = adRequestParcel.zztu;
        boolean z2 = adRequestParcel.zztv || this.zzpt;
        return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, adRequestParcel.zztw, adRequestParcel.zztx, adRequestParcel.zzty, adRequestParcel.zztz, adRequestParcel.zztA, adRequestParcel.zztB, adRequestParcel.zztC, adRequestParcel.zztD, adRequestParcel.zztE, adRequestParcel.zztF);
    }
}
