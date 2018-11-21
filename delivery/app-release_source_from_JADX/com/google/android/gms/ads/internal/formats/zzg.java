package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzha
public class zzg extends zzh {
    private Object zzpK;
    private zzfa zzxN;
    private zzfb zzxO;
    private final zzn zzxP;
    private zzh zzxQ;
    private boolean zzxR;

    private zzg(Context context, zzn com_google_android_gms_ads_internal_zzn, zzan com_google_android_gms_internal_zzan) {
        super(context, com_google_android_gms_ads_internal_zzn, null, com_google_android_gms_internal_zzan, null, null, null);
        this.zzxR = false;
        this.zzpK = new Object();
        this.zzxP = com_google_android_gms_ads_internal_zzn;
    }

    public zzg(Context context, zzn com_google_android_gms_ads_internal_zzn, zzan com_google_android_gms_internal_zzan, zzfa com_google_android_gms_internal_zzfa) {
        this(context, com_google_android_gms_ads_internal_zzn, com_google_android_gms_internal_zzan);
        this.zzxN = com_google_android_gms_internal_zzfa;
    }

    public zzg(Context context, zzn com_google_android_gms_ads_internal_zzn, zzan com_google_android_gms_internal_zzan, zzfb com_google_android_gms_internal_zzfb) {
        this(context, com_google_android_gms_ads_internal_zzn, com_google_android_gms_internal_zzan);
        this.zzxO = com_google_android_gms_internal_zzfb;
    }

    public void recordImpression() {
        zzx.zzcx("recordImpression must be called on the main UI thread.");
        synchronized (this.zzpK) {
            zzn(true);
            if (this.zzxQ != null) {
                this.zzxQ.recordImpression();
            } else {
                try {
                    if (this.zzxN != null && !this.zzxN.getOverrideClickHandling()) {
                        this.zzxN.recordImpression();
                    } else if (!(this.zzxO == null || this.zzxO.getOverrideClickHandling())) {
                        this.zzxO.recordImpression();
                    }
                } catch (Throwable e) {
                    zzb.zzd("Failed to call recordImpression", e);
                }
            }
            this.zzxP.recordImpression();
        }
    }

    public zzb zza(OnClickListener onClickListener) {
        return null;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcx("performClick must be called on the main UI thread.");
        synchronized (this.zzpK) {
            if (this.zzxQ != null) {
                this.zzxQ.zza(view, map, jSONObject, jSONObject2, jSONObject3);
            } else {
                try {
                    if (!(this.zzxN == null || this.zzxN.getOverrideClickHandling())) {
                        this.zzxN.zzc(zze.zzB(view));
                    }
                    if (!(this.zzxO == null || this.zzxO.getOverrideClickHandling())) {
                        this.zzxN.zzc(zze.zzB(view));
                    }
                } catch (Throwable e) {
                    zzb.zzd("Failed to call performClick", e);
                }
            }
            this.zzxP.onAdClicked();
        }
    }

    public void zzc(zzh com_google_android_gms_ads_internal_formats_zzh) {
        synchronized (this.zzpK) {
            this.zzxQ = com_google_android_gms_ads_internal_formats_zzh;
        }
    }

    public boolean zzdI() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzxR;
        }
        return z;
    }

    public zzh zzdJ() {
        zzh com_google_android_gms_ads_internal_formats_zzh;
        synchronized (this.zzpK) {
            com_google_android_gms_ads_internal_formats_zzh = this.zzxQ;
        }
        return com_google_android_gms_ads_internal_formats_zzh;
    }

    public zzjn zzdK() {
        return null;
    }

    public void zzh(View view) {
        synchronized (this.zzpK) {
            this.zzxR = true;
            try {
                if (this.zzxN != null) {
                    this.zzxN.zzd(zze.zzB(view));
                } else if (this.zzxO != null) {
                    this.zzxO.zzd(zze.zzB(view));
                }
            } catch (Throwable e) {
                zzb.zzd("Failed to call prepareAd", e);
            }
            this.zzxR = false;
        }
    }
}
