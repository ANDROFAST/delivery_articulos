package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class zzoh {
    public static final zza zzarG = new zza("created", 4100000);
    public static final zzb zzarH = new zzb("lastOpenedTime", 4300000);
    public static final zzd zzarI = new zzd("modified", 4100000);
    public static final zzc zzarJ = new zzc("modifiedByMe", 4100000);
    public static final zzf zzarK = new zzf("sharedWithMe", 4100000);
    public static final zze zzarL = new zze("recency", 8000000);

    public static class zza extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zza(String str, int i) {
            super(str, i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }
}
