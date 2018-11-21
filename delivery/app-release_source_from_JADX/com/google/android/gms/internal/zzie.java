package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzha
public class zzie {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzAQ;
    public final List<String> zzAR;
    public final long zzAU;
    public final zzem zzBp;
    public final zzex zzBq;
    public final String zzBr;
    public final zzep zzBs;
    public final zzjn zzDC;
    public final long zzGM;
    public final boolean zzGN;
    public final long zzGO;
    public final List<String> zzGP;
    public final String zzGS;
    public final AdRequestParcel zzGq;
    public final String zzGt;
    public final JSONObject zzJE;
    public final zzen zzJF;
    public final AdSizeParcel zzJG;
    public final long zzJH;
    public final long zzJI;
    public final com.google.android.gms.ads.internal.formats.zzh.zza zzJJ;

    @zzha
    public static final class zza {
        public final int errorCode;
        public final JSONObject zzJE;
        public final zzen zzJF;
        public final long zzJH;
        public final long zzJI;
        public final AdRequestInfoParcel zzJK;
        public final AdResponseParcel zzJL;
        public final AdSizeParcel zzqV;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzen com_google_android_gms_internal_zzen, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzJK = adRequestInfoParcel;
            this.zzJL = adResponseParcel;
            this.zzJF = com_google_android_gms_internal_zzen;
            this.zzqV = adSizeParcel;
            this.errorCode = i;
            this.zzJH = j;
            this.zzJI = j2;
            this.zzJE = jSONObject;
        }
    }

    public zzie(AdRequestParcel adRequestParcel, zzjn com_google_android_gms_internal_zzjn, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzem com_google_android_gms_internal_zzem, zzex com_google_android_gms_internal_zzex, String str2, zzen com_google_android_gms_internal_zzen, zzep com_google_android_gms_internal_zzep, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, com.google.android.gms.ads.internal.formats.zzh.zza com_google_android_gms_ads_internal_formats_zzh_zza) {
        this.zzGq = adRequestParcel;
        this.zzDC = com_google_android_gms_internal_zzjn;
        this.zzAQ = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzAR = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzGP = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzAU = j;
        this.zzGt = str;
        this.zzGN = z;
        this.zzBp = com_google_android_gms_internal_zzem;
        this.zzBq = com_google_android_gms_internal_zzex;
        this.zzBr = str2;
        this.zzJF = com_google_android_gms_internal_zzen;
        this.zzBs = com_google_android_gms_internal_zzep;
        this.zzGO = j2;
        this.zzJG = adSizeParcel;
        this.zzGM = j3;
        this.zzJH = j4;
        this.zzJI = j5;
        this.zzGS = str3;
        this.zzJE = jSONObject;
        this.zzJJ = com_google_android_gms_ads_internal_formats_zzh_zza;
    }

    public zzie(zza com_google_android_gms_internal_zzie_zza, zzjn com_google_android_gms_internal_zzjn, zzem com_google_android_gms_internal_zzem, zzex com_google_android_gms_internal_zzex, String str, zzep com_google_android_gms_internal_zzep, com.google.android.gms.ads.internal.formats.zzh.zza com_google_android_gms_ads_internal_formats_zzh_zza) {
        this(com_google_android_gms_internal_zzie_zza.zzJK.zzGq, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzie_zza.zzJL.zzAQ, com_google_android_gms_internal_zzie_zza.errorCode, com_google_android_gms_internal_zzie_zza.zzJL.zzAR, com_google_android_gms_internal_zzie_zza.zzJL.zzGP, com_google_android_gms_internal_zzie_zza.zzJL.orientation, com_google_android_gms_internal_zzie_zza.zzJL.zzAU, com_google_android_gms_internal_zzie_zza.zzJK.zzGt, com_google_android_gms_internal_zzie_zza.zzJL.zzGN, com_google_android_gms_internal_zzem, com_google_android_gms_internal_zzex, str, com_google_android_gms_internal_zzie_zza.zzJF, com_google_android_gms_internal_zzep, com_google_android_gms_internal_zzie_zza.zzJL.zzGO, com_google_android_gms_internal_zzie_zza.zzqV, com_google_android_gms_internal_zzie_zza.zzJL.zzGM, com_google_android_gms_internal_zzie_zza.zzJH, com_google_android_gms_internal_zzie_zza.zzJI, com_google_android_gms_internal_zzie_zza.zzJL.zzGS, com_google_android_gms_internal_zzie_zza.zzJE, com_google_android_gms_ads_internal_formats_zzh_zza);
    }

    public boolean zzcb() {
        return (this.zzDC == null || this.zzDC.zzhC() == null) ? false : this.zzDC.zzhC().zzcb();
    }
}
