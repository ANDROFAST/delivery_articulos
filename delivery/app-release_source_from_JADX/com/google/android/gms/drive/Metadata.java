package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoj;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public String getAlternateLink() {
        return (String) zza(zzof.zzaqP);
    }

    public int getContentAvailability() {
        Integer num = (Integer) zza(zzoj.zzarN);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) zza(zzoh.zzarG);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zzof.zzaqQ);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzta();
    }

    public String getDescription() {
        return (String) zza(zzof.zzaqR);
    }

    public DriveId getDriveId() {
        return (DriveId) zza(zzof.zzaqO);
    }

    public String getEmbedLink() {
        return (String) zza(zzof.zzaqS);
    }

    public String getFileExtension() {
        return (String) zza(zzof.zzaqT);
    }

    public long getFileSize() {
        return ((Long) zza(zzof.zzaqU)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) zza(zzoh.zzarH);
    }

    public String getMimeType() {
        return (String) zza(zzof.zzarl);
    }

    public Date getModifiedByMeDate() {
        return (Date) zza(zzoh.zzarJ);
    }

    public Date getModifiedDate() {
        return (Date) zza(zzoh.zzarI);
    }

    public String getOriginalFilename() {
        return (String) zza(zzof.zzarm);
    }

    public long getQuotaBytesUsed() {
        return ((Long) zza(zzof.zzarr)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) zza(zzoh.zzarK);
    }

    public String getTitle() {
        return (String) zza(zzof.zzaru);
    }

    public String getWebContentLink() {
        return (String) zza(zzof.zzarw);
    }

    public String getWebViewLink() {
        return (String) zza(zzof.zzarx);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zzof.zzara);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zzof.zzarb);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zzof.zzaqY);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zzoj.zzarO);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zzof.zzard);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zzof.zzarf);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) zza(zzof.zzarg);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zzof.zzars);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zzof.zzarj);
        return bool == null ? true : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zzof.zzarv);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zzof.zzark);
        return bool == null ? false : bool.booleanValue();
    }

    public abstract <T> T zza(MetadataField<T> metadataField);
}
