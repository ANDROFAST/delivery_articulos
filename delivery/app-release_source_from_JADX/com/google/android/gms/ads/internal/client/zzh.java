package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzha;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzha
public class zzh {
    public static final zzh zztU = new zzh();

    protected zzh() {
    }

    public static zzh zzcJ() {
        return zztU;
    }

    public AdRequestParcel zza(Context context, zzy com_google_android_gms_ads_internal_client_zzy) {
        Date birthday = com_google_android_gms_ads_internal_client_zzy.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = com_google_android_gms_ads_internal_client_zzy.getContentUrl();
        int gender = com_google_android_gms_ads_internal_client_zzy.getGender();
        Collection keywords = com_google_android_gms_ads_internal_client_zzy.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = com_google_android_gms_ads_internal_client_zzy.isTestDevice(context);
        int zzcX = com_google_android_gms_ads_internal_client_zzy.zzcX();
        Location location = com_google_android_gms_ads_internal_client_zzy.getLocation();
        Bundle networkExtrasBundle = com_google_android_gms_ads_internal_client_zzy.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = com_google_android_gms_ads_internal_client_zzy.getManualImpressionsEnabled();
        String publisherProvidedId = com_google_android_gms_ads_internal_client_zzy.getPublisherProvidedId();
        SearchAdRequest zzcU = com_google_android_gms_ads_internal_client_zzy.zzcU();
        SearchAdRequestParcel searchAdRequestParcel = zzcU != null ? new SearchAdRequestParcel(zzcU) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = zzp.zzbx().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzcX, manualImpressionsEnabled, publisherProvidedId, searchAdRequestParcel, location, contentUrl, com_google_android_gms_ads_internal_client_zzy.zzcW(), com_google_android_gms_ads_internal_client_zzy.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(com_google_android_gms_ads_internal_client_zzy.zzcY())), com_google_android_gms_ads_internal_client_zzy.zzcT(), str, com_google_android_gms_ads_internal_client_zzy.isDesignedForFamilies());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzy com_google_android_gms_ads_internal_client_zzy, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, com_google_android_gms_ads_internal_client_zzy), str);
    }
}
