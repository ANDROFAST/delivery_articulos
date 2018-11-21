package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = zzof.zzard;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = zzoh.zzarH;
    public static final SearchableMetadataField<String> MIME_TYPE = zzof.zzarl;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = zzoh.zzarI;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = zzof.zzarq;
    public static final SearchableMetadataField<Boolean> STARRED = zzof.zzars;
    public static final SearchableMetadataField<String> TITLE = zzof.zzaru;
    public static final SearchableMetadataField<Boolean> TRASHED = zzof.zzarv;
    public static final SearchableOrderedMetadataField<Date> zzarV = zzoh.zzarK;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzarW = zzof.zzaqQ;
}
