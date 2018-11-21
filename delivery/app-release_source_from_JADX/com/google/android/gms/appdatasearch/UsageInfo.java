package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzSY;
    final long zzSZ;
    int zzTa;
    final DocumentContents zzTb;
    final boolean zzTc;
    int zzTd;
    int zzTe;
    public final String zzuU;

    public static final class zza {
        private String zzNp;
        private DocumentId zzSY;
        private long zzSZ = -1;
        private int zzTa = -1;
        private DocumentContents zzTb;
        private boolean zzTc = false;
        private int zzTd = -1;
        private int zzTe = 0;

        public zza zzO(boolean z) {
            this.zzTc = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzTb = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzSY = documentId;
            return this;
        }

        public zza zzar(int i) {
            this.zzTa = i;
            return this;
        }

        public zza zzas(int i) {
            this.zzTe = i;
            return this;
        }

        public UsageInfo zzlR() {
            return new UsageInfo(this.zzSY, this.zzSZ, this.zzTa, this.zzNp, this.zzTb, this.zzTc, this.zzTd, this.zzTe);
        }

        public zza zzw(long j) {
            this.zzSZ = j;
            return this;
        }
    }

    UsageInfo(int versionCode, DocumentId documentId, long timestamp, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this.mVersionCode = versionCode;
        this.zzSY = documentId;
        this.zzSZ = timestamp;
        this.zzTa = usageType;
        this.zzuU = query;
        this.zzTb = document;
        this.zzTc = isDeviceOnly;
        this.zzTd = taskPosition;
        this.zzTe = eventStatus;
    }

    private UsageInfo(DocumentId documentId, long timestampMs, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this(1, documentId, timestampMs, usageType, query, document, isDeviceOnly, taskPosition, eventStatus);
    }

    public UsageInfo(String packageName, Intent viewIntent, String title, Uri webUrl, String schemaOrgType, List<AppIndexingLink> outLinks, int eventStatus) {
        this(1, zza(packageName, viewIntent), System.currentTimeMillis(), 0, null, zza(viewIntent, title, webUrl, schemaOrgType, outLinks).zzlN(), false, -1, eventStatus);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza com_google_android_gms_appdatasearch_DocumentContents_zza = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzbA(str));
        if (uri != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzi(uri));
        }
        if (list != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_extra_data", action));
            }
        }
        return com_google_android_gms_appdatasearch_DocumentContents_zza.zzbw(str2).zzL(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzo(str, zzg(intent));
    }

    private static DocumentSection zzbA(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzap(1).zzN(true).zzbz("name").zzlQ(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzap(4).zzM(true).zzbz(PlusShare.KEY_CALL_TO_ACTION_URL).zzlQ());
    }

    private static DocumentId zzo(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzp(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzM(true).zzlQ(), str);
    }

    private static DocumentSection zzq(List<AppIndexingLink> list) {
        zztk com_google_android_gms_internal_zzqd_zza = new com.google.android.gms.internal.zzqd.zza();
        com.google.android.gms.internal.zzqd.zza.zza[] com_google_android_gms_internal_zzqd_zza_zzaArr = new com.google.android.gms.internal.zzqd.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zzqd_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zzqd_zza_zzaArr[i] = new com.google.android.gms.internal.zzqd.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zzqd_zza_zzaArr[i].zzaJC = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zzqd_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zzqd_zza_zzaArr[i].zzaJD = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zzqd_zza.zzaJA = com_google_android_gms_internal_zzqd_zza_zzaArr;
        return new DocumentSection(zztk.toByteArray(com_google_android_gms_internal_zzqd_zza), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzM(true).zzbz(".private:outLinks").zzby("blob").zzlQ());
    }

    public int describeContents() {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzSY, Long.valueOf(this.zzSZ), Integer.valueOf(this.zzTa), Integer.valueOf(this.zzTe)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        zzj.zza(this, dest, flags);
    }
}
