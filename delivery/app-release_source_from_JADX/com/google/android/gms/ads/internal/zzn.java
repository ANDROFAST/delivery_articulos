package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzip;
import java.util.List;

@zzha
public class zzn extends zzb {
    public zzn(Context context, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzew, versionInfoParcel, null);
    }

    private static zzd zza(zzfa com_google_android_gms_internal_zzfa) throws RemoteException {
        return new zzd(com_google_android_gms_internal_zzfa.getHeadline(), com_google_android_gms_internal_zzfa.getImages(), com_google_android_gms_internal_zzfa.getBody(), com_google_android_gms_internal_zzfa.zzdD() != null ? com_google_android_gms_internal_zzfa.zzdD() : null, com_google_android_gms_internal_zzfa.getCallToAction(), com_google_android_gms_internal_zzfa.getStarRating(), com_google_android_gms_internal_zzfa.getStore(), com_google_android_gms_internal_zzfa.getPrice(), null, com_google_android_gms_internal_zzfa.getExtras());
    }

    private static zze zza(zzfb com_google_android_gms_internal_zzfb) throws RemoteException {
        return new zze(com_google_android_gms_internal_zzfb.getHeadline(), com_google_android_gms_internal_zzfb.getImages(), com_google_android_gms_internal_zzfb.getBody(), com_google_android_gms_internal_zzfb.zzdH() != null ? com_google_android_gms_internal_zzfb.zzdH() : null, com_google_android_gms_internal_zzfb.getCallToAction(), com_google_android_gms_internal_zzfb.getAdvertiser(), null, com_google_android_gms_internal_zzfb.getExtras());
    }

    private void zza(final zzd com_google_android_gms_ads_internal_formats_zzd) {
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzn zzqi;

            public void run() {
                try {
                    this.zzqi.zzoZ.zzrf.zza(com_google_android_gms_ads_internal_formats_zzd);
                } catch (Throwable e) {
                    zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final zze com_google_android_gms_ads_internal_formats_zze) {
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzn zzqi;

            public void run() {
                try {
                    this.zzqi.zzoZ.zzrg.zza(com_google_android_gms_ads_internal_formats_zze);
                } catch (Throwable e) {
                    zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final zzie com_google_android_gms_internal_zzie, final String str) {
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzn zzqi;

            public void run() {
                try {
                    ((zzda) this.zzqi.zzoZ.zzri.get(str)).zza((zzf) com_google_android_gms_internal_zzie.zzJJ);
                } catch (Throwable e) {
                    zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void recordImpression() {
        zza(this.zzoZ.zzqW, false);
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(SimpleArrayMap<String, zzda> simpleArrayMap) {
        zzx.zzcx("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzoZ.zzri = simpleArrayMap;
    }

    public void zza(zzh com_google_android_gms_ads_internal_formats_zzh) {
        if (this.zzoZ.zzqW.zzJE != null) {
            zzp.zzbA().zzgR().zza(this.zzoZ.zzqV, this.zzoZ.zzqW, com_google_android_gms_ads_internal_formats_zzh);
        }
    }

    public void zza(zzcl com_google_android_gms_internal_zzcl) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(zzgc com_google_android_gms_internal_zzgc) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(final zza com_google_android_gms_internal_zzie_zza, zzch com_google_android_gms_internal_zzch) {
        if (com_google_android_gms_internal_zzie_zza.zzqV != null) {
            this.zzoZ.zzqV = com_google_android_gms_internal_zzie_zza.zzqV;
        }
        if (com_google_android_gms_internal_zzie_zza.errorCode != -2) {
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzn zzqi;

                public void run() {
                    this.zzqi.zzb(new zzie(com_google_android_gms_internal_zzie_zza, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzoZ.zzrp = 0;
        this.zzoZ.zzqU = zzp.zzbw().zza(this.zzoZ.context, this, com_google_android_gms_internal_zzie_zza, this.zzoZ.zzqQ, null, this.zzpd, this, com_google_android_gms_internal_zzch);
        zzb.zzaF("AdRenderer: " + this.zzoZ.zzqU.getClass().getName());
    }

    public void zza(List<String> list) {
        zzx.zzcx("setNativeTemplates must be called on the main UI thread.");
        this.zzoZ.zzrl = list;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzie com_google_android_gms_internal_zzie, boolean z) {
        return this.zzoY.zzbr();
    }

    protected boolean zza(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2) {
        zza(null);
        if (this.zzoZ.zzbQ()) {
            if (com_google_android_gms_internal_zzie2.zzGN) {
                try {
                    zzfa zzeu = com_google_android_gms_internal_zzie2.zzBq.zzeu();
                    zzfb zzev = com_google_android_gms_internal_zzie2.zzBq.zzev();
                    if (zzeu != null) {
                        zzd zza = zza(zzeu);
                        zza.zzb(new zzg(this.zzoZ.context, this, this.zzoZ.zzqQ, zzeu));
                        zza(zza);
                    } else if (zzev != null) {
                        zze zza2 = zza(zzev);
                        zza2.zzb(new zzg(this.zzoZ.context, this, this.zzoZ.zzqQ, zzev));
                        zza(zza2);
                    } else {
                        zzb.zzaH("No matching mapper for retrieved native ad template.");
                        zzf(0);
                        return false;
                    }
                } catch (Throwable e) {
                    zzb.zzd("Failed to get native ad mapper", e);
                }
            } else {
                zzh.zza com_google_android_gms_ads_internal_formats_zzh_zza = com_google_android_gms_internal_zzie2.zzJJ;
                if ((com_google_android_gms_ads_internal_formats_zzh_zza instanceof zze) && this.zzoZ.zzrg != null) {
                    zza((zze) com_google_android_gms_internal_zzie2.zzJJ);
                } else if ((com_google_android_gms_ads_internal_formats_zzh_zza instanceof zzd) && this.zzoZ.zzrf != null) {
                    zza((zzd) com_google_android_gms_internal_zzie2.zzJJ);
                } else if (!(com_google_android_gms_ads_internal_formats_zzh_zza instanceof zzf) || this.zzoZ.zzri == null || this.zzoZ.zzri.get(((zzf) com_google_android_gms_ads_internal_formats_zzh_zza).getCustomTemplateId()) == null) {
                    zzb.zzaH("No matching listener for retrieved native ad template.");
                    zzf(0);
                    return false;
                } else {
                    zza(com_google_android_gms_internal_zzie2, ((zzf) com_google_android_gms_ads_internal_formats_zzh_zza).getCustomTemplateId());
                }
            }
            return super.zza(com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzie2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public void zzb(SimpleArrayMap<String, zzcz> simpleArrayMap) {
        zzx.zzcx("setOnCustomClickListener must be called on the main UI thread.");
        this.zzoZ.zzrh = simpleArrayMap;
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzx.zzcx("setNativeAdOptions must be called on the main UI thread.");
        this.zzoZ.zzrj = nativeAdOptionsParcel;
    }

    public void zzb(zzcx com_google_android_gms_internal_zzcx) {
        zzx.zzcx("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzoZ.zzrf = com_google_android_gms_internal_zzcx;
    }

    public void zzb(zzcy com_google_android_gms_internal_zzcy) {
        zzx.zzcx("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzoZ.zzrg = com_google_android_gms_internal_zzcy;
    }

    public SimpleArrayMap<String, zzda> zzbq() {
        zzx.zzcx("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzoZ.zzri;
    }

    public zzcz zzr(String str) {
        zzx.zzcx("getOnCustomClickListener must be called on the main UI thread.");
        return (zzcz) this.zzoZ.zzrh.get(str);
    }
}
