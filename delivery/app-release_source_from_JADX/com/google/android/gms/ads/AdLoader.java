package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdd;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzev;

public class AdLoader {
    private final Context mContext;
    private final zzh zzoq;
    private final zzp zzor;

    public static class Builder {
        private final Context mContext;
        private final zzq zzos;

        Builder(Context context, zzq builder) {
            this.mContext = context;
            this.zzos = builder;
        }

        public Builder(Context context, String adUnitID) {
            this((Context) zzx.zzb((Object) context, (Object) "context cannot be null"), zzd.zza(context, adUnitID, new zzev()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzos.zzbm());
            } catch (Throwable e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener listener) {
            try {
                this.zzos.zza(new zzdc(listener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(OnContentAdLoadedListener listener) {
            try {
                this.zzos.zza(new zzdd(listener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String templateId, OnCustomTemplateAdLoadedListener adLoadedListener, OnCustomClickListener customClickListener) {
            try {
                this.zzos.zza(templateId, new zzdf(adLoadedListener), customClickListener == null ? null : new zzde(customClickListener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener listener) {
            try {
                this.zzos.zzb(new zzc(listener));
            } catch (Throwable e) {
                zzb.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(Correlator correlator) {
            zzx.zzy(correlator);
            try {
                this.zzos.zzb(correlator.zzaH());
            } catch (Throwable e) {
                zzb.zzd("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions options) {
            try {
                this.zzos.zza(new NativeAdOptionsParcel(options));
            } catch (Throwable e) {
                zzb.zzd("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzp adLoader) {
        this(context, adLoader, zzh.zzcJ());
    }

    AdLoader(Context context, zzp adLoader, zzh parcelFactory) {
        this.mContext = context;
        this.zzor = adLoader;
        this.zzoq = parcelFactory;
    }

    private void zza(zzy com_google_android_gms_ads_internal_client_zzy) {
        try {
            this.zzor.zzf(this.zzoq.zza(this.mContext, com_google_android_gms_ads_internal_client_zzy));
        } catch (Throwable e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zzor.getMediationAdapterClassName();
        } catch (Throwable e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzor.isLoading();
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzaG());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzaG());
    }
}
