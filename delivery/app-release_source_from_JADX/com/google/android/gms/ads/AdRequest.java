package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final zzy zzot;

    public static final class Builder {
        private final zza zzou = new zza();

        public Builder() {
            this.zzou.zzG(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zzou.zzb((Class) adapterClass, customEventExtras);
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
            if (adapterClass.equals(AdMobAdapter.class) && networkExtras.getBoolean("_emulatorLiveAds")) {
                this.zzou.zzH(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.zzou.zzG(deviceId);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
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

        public Builder setRequestAgent(String requestAgent) {
            this.zzou.zzK(requestAgent);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.zzou.zzk(tagForChildDirectedTreatment);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.zzot = new zzy(builder.zzou);
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

    public int getGender() {
        return this.zzot.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzot.getKeywords();
    }

    public Location getLocation() {
        return this.zzot.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.zzot.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zzot.getNetworkExtrasBundle(adapterClass);
    }

    public boolean isTestDevice(Context context) {
        return this.zzot.isTestDevice(context);
    }

    public zzy zzaG() {
        return this.zzot;
    }
}
