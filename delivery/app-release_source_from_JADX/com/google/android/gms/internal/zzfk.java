package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzha
public final class zzfk {

    static /* synthetic */ class C03061 {
        static final /* synthetic */ int[] zzBS = new int[Gender.values().length];

        static {
            zzBT = new int[ErrorCode.values().length];
            try {
                zzBT[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzBT[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzBT[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzBT[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzBS[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zzBS[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zzBS[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzb(AdSizeParcel adSizeParcel) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == adSizeParcel.width && adSizeArr[i].getHeight() == adSizeParcel.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zztV));
    }

    public static MediationAdRequest zzi(AdRequestParcel adRequestParcel) {
        return new MediationAdRequest(new Date(adRequestParcel.zztq), zzu(adRequestParcel.zztr), adRequestParcel.zzts != null ? new HashSet(adRequestParcel.zzts) : null, adRequestParcel.zztt, adRequestParcel.zzty);
    }

    public static Gender zzu(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
