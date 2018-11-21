package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzp extends Metadata {
    private final MetadataBundle zzaoy;

    public zzp(MetadataBundle metadataBundle) {
        this.zzaoy = metadataBundle;
    }

    public /* synthetic */ Object freeze() {
        return zzso();
    }

    public boolean isDataValid() {
        return this.zzaoy != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzaoy + "]";
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzaoy.zza((MetadataField) metadataField);
    }

    public Metadata zzso() {
        return new zzp(MetadataBundle.zza(this.zzaoy));
    }
}
