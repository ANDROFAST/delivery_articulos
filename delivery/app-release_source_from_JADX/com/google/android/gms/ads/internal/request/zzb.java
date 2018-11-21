package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjh;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzb extends zzil implements com.google.android.gms.ads.internal.request.zzc.zza {
    private final Context mContext;
    zzen zzBf;
    private AdRequestInfoParcel zzBu;
    AdResponseParcel zzFd;
    private Runnable zzFe;
    private final Object zzFf = new Object();
    private final com.google.android.gms.ads.internal.request.zza.zza zzGd;
    private final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzGe;
    zzir zzGf;
    private final zzan zzxV;

    class C01601 implements Runnable {
        final /* synthetic */ zzb zzGg;

        C01601(zzb com_google_android_gms_ads_internal_request_zzb) {
            this.zzGg = com_google_android_gms_ads_internal_request_zzb;
        }

        public void run() {
            synchronized (this.zzGg.zzFf) {
                if (this.zzGg.zzGf == null) {
                    return;
                }
                this.zzGg.onStop();
                this.zzGg.zze(2, "Timed out waiting for ad response.");
            }
        }
    }

    @zzha
    static final class zza extends Exception {
        private final int zzFt;

        public zza(String str, int i) {
            super(str);
            this.zzFt = i;
        }

        public int getErrorCode() {
            return this.zzFt;
        }
    }

    public zzb(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, zzan com_google_android_gms_internal_zzan, com.google.android.gms.ads.internal.request.zza.zza com_google_android_gms_ads_internal_request_zza_zza) {
        this.zzGd = com_google_android_gms_ads_internal_request_zza_zza;
        this.mContext = context;
        this.zzGe = com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza;
        this.zzxV = com_google_android_gms_internal_zzan;
    }

    private void zze(int i, String str) {
        if (i == 3 || i == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG(str);
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(str);
        }
        if (this.zzFd == null) {
            this.zzFd = new AdResponseParcel(i);
        } else {
            this.zzFd = new AdResponseParcel(i, this.zzFd.zzAU);
        }
        this.zzGd.zza(new com.google.android.gms.internal.zzie.zza(this.zzBu != null ? this.zzBu : new AdRequestInfoParcel(this.zzGe, null, -1), this.zzFd, this.zzBf, null, i, -1, this.zzFd.zzGR, null));
    }

    public void onStop() {
        synchronized (this.zzFf) {
            if (this.zzGf != null) {
                this.zzGf.cancel();
            }
        }
    }

    zzir zza(VersionInfoParcel versionInfoParcel, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel) {
        return zzc.zza(this.mContext, versionInfoParcel, com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, this);
    }

    protected AdSizeParcel zzb(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzFd.zzGQ == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzFd.zzGQ.split("x");
        if (split.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzFd.zzGQ, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzqV.zztX) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / f) : adSizeParcel.width;
                int i2 = adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / f) : adSizeParcel.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzqV.zztX);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzFd.zzGQ, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzFd.zzGQ, 0);
        }
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received ad response.");
        this.zzFd = adResponseParcel;
        long elapsedRealtime = zzp.zzbB().elapsedRealtime();
        synchronized (this.zzFf) {
            this.zzGf = null;
        }
        try {
            if (this.zzFd.errorCode == -2 || this.zzFd.errorCode == -3) {
                JSONObject jSONObject;
                zzgd();
                AdSizeParcel zzb = this.zzBu.zzqV.zztX != null ? zzb(this.zzBu) : null;
                zzp.zzbA().zzB(this.zzFd.zzGX);
                if (!TextUtils.isEmpty(this.zzFd.zzGV)) {
                    try {
                        jSONObject = new JSONObject(this.zzFd.zzGV);
                    } catch (Throwable e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", e);
                    }
                    this.zzGd.zza(new com.google.android.gms.internal.zzie.zza(this.zzBu, this.zzFd, this.zzBf, zzb, -2, elapsedRealtime, this.zzFd.zzGR, jSONObject));
                    zzip.zzKO.removeCallbacks(this.zzFe);
                    return;
                }
                jSONObject = null;
                this.zzGd.zza(new com.google.android.gms.internal.zzie.zza(this.zzBu, this.zzFd, this.zzBf, zzb, -2, elapsedRealtime, this.zzFd.zzGR, jSONObject));
                zzip.zzKO.removeCallbacks(this.zzFe);
                return;
            }
            throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzFd.errorCode, this.zzFd.errorCode);
        } catch (zza e2) {
            zze(e2.getErrorCode(), e2.getMessage());
            zzip.zzKO.removeCallbacks(this.zzFe);
        }
    }

    public void zzbp() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdLoaderBackgroundTask started.");
        this.zzFe = new C01601(this);
        zzip.zzKO.postDelayed(this.zzFe, ((Long) zzbz.zzwB.get()).longValue());
        final zzjg com_google_android_gms_internal_zzjh = new zzjh();
        long elapsedRealtime = zzp.zzbB().elapsedRealtime();
        zzio.zza(new Runnable(this) {
            final /* synthetic */ zzb zzGg;

            public void run() {
                synchronized (this.zzGg.zzFf) {
                    this.zzGg.zzGf = this.zzGg.zza(this.zzGg.zzGe.zzqR, com_google_android_gms_internal_zzjh);
                    if (this.zzGg.zzGf == null) {
                        this.zzGg.zze(0, "Could not start the ad request service.");
                        zzip.zzKO.removeCallbacks(this.zzGg.zzFe);
                    }
                }
            }
        });
        this.zzBu = new AdRequestInfoParcel(this.zzGe, this.zzxV.zzac().zzb(this.mContext), elapsedRealtime);
        com_google_android_gms_internal_zzjh.zzg(this.zzBu);
    }

    protected void zzgd() throws zza {
        if (this.zzFd.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzFd.body)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzp.zzbA().zza(this.mContext, this.zzFd.zzGy);
            if (this.zzFd.zzGN) {
                try {
                    this.zzBf = new zzen(this.zzFd.body);
                } catch (JSONException e) {
                    throw new zza("Could not parse mediation config: " + this.zzFd.body, 0);
                }
            }
        }
    }
}
