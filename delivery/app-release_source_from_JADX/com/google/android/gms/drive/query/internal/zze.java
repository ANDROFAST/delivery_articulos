package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class zze {
    static MetadataField<?> zzb(MetadataBundle metadataBundle) {
        Set zztg = metadataBundle.zztg();
        if (zztg.size() == 1) {
            return (MetadataField) zztg.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
