package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzy zzot;

    public static final class Builder {
        private final zza zzou = new zza();

        public Builder addCategoryExclusion(String categoryExclusion) {
            this.zzou.zzL(categoryExclusion);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zzou.zzb((Class) adapterClass, customEventExtras);
            return this;
        }

        public Builder addCustomTargeting(String key, String value) {
            this.zzou.zzb(key, value);
            return this;
        }

        public Builder addCustomTargeting(String key, List<String> values) {
            if (values != null) {
                this.zzou.zzb(key, zzv.zzcF(",").zza(values));
            }
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.zzou.zzF(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzou.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.zzou.zza(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.zzou.zzG(deviceId);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.zzou.zza(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            zzx.zzb((Object) contentUrl, (Object) "Content URL must be non-null.");
            zzx.zzh(contentUrl, "Content URL must be non-empty.");
            zzx.zzb(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(contentUrl.length()));
            this.zzou.zzI(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.zzou.zzn(gender);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean isDesignedForFamilies) {
            this.zzou.zzl(isDesignedForFamilies);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzou.zzb(location);
            return this;
        }

        @Deprecated
        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.zzou.setManualImpressionsEnabled(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.zzou.zzJ(publisherProvidedId);
            return this;
        }

        public Builder setRequestAgent(String requestAgent) {
            this.zzou.zzK(requestAgent);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.zzou.zzk(tagForChildDirectedTreatment);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzot = new zzy(builder.zzou);
    }

    public static void updateCorrelator() {
    }

    public Date getBirthday() {
        return this.zzot.getBirthday();
    }

    public String getContentUrl() {
        return this.zzot.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zzot.getCustomEventExtrasBundle(adapterClass);
    }

    public Bundle getCustomTargeting() {
        return this.zzot.getCustomTargeting();
    }

    public int getGender() {
        return this.zzot.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzot.getKeywords();
    }

    public Location getLocation() {
        return this.zzot.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzot.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.zzot.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zzot.getNetworkExtrasBundle(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.zzot.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.zzot.isTestDevice(context);
    }

    public zzy zzaG() {
        return this.zzot;
    }
}
