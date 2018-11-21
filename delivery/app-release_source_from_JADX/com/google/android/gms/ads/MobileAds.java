package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzac;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds {

    public static final class Settings {
        private final zzac zzoB = new zzac();

        @Deprecated
        public String getTrackingId() {
            return this.zzoB.getTrackingId();
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return this.zzoB.isGoogleAnalyticsEnabled();
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean enable) {
            this.zzoB.zzm(enable);
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String trackingId) {
            this.zzoB.zzO(trackingId);
            return this;
        }

        zzac zzaI() {
            return this.zzoB;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzab.zzdc().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        zzab.zzdc().initialize(context);
    }

    @Deprecated
    public static void initialize(Context context, String applicationCode) {
        initialize(context, applicationCode, null);
    }

    @Deprecated
    public static void initialize(Context context, String applicationCode, Settings settings) {
        zzab.zzdc().zza(context, applicationCode, settings == null ? null : settings.zzaI());
    }
}
