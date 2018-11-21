package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzoh;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzanh = new MetadataChangeSet(MetadataBundle.zztf());
    private final MetadataBundle zzani;

    public static class Builder {
        private final MetadataBundle zzani = MetadataBundle.zztf();
        private zza zzanj;

        private int zzcS(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private void zzk(String str, int i, int i2) {
            zzx.zzb(i2 <= i, zzj(str, i, i2));
        }

        private zza zzsq() {
            if (this.zzanj == null) {
                this.zzanj = new zza();
            }
            return this.zzanj;
        }

        public MetadataChangeSet build() {
            if (this.zzanj != null) {
                this.zzani.zzb(zzof.zzaqQ, this.zzanj.zztb());
            }
            return new MetadataChangeSet(this.zzani);
        }

        public Builder deleteCustomProperty(CustomPropertyKey key) {
            zzx.zzb((Object) key, (Object) "key");
            zzsq().zza(key, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey key, String value) {
            zzx.zzb((Object) key, (Object) "key");
            zzx.zzb((Object) value, (Object) "value");
            zzk("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzcS(key.getKey()) + zzcS(value));
            zzsq().zza(key, value);
            return this;
        }

        public Builder setDescription(String description) {
            this.zzani.zzb(zzof.zzaqR, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            zzk("Indexable text size", 131072, zzcS(text));
            this.zzani.zzb(zzof.zzaqX, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzani.zzb(zzoh.zzarH, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.zzani.zzb(zzof.zzarl, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.zzani.zzb(zzof.zzard, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.zzani.zzb(zzof.zzars, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.zzani.zzb(zzof.zzaru, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.zzani.zzb(zzof.zzark, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.zzani = MetadataBundle.zza(bag);
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzani.zza(zzof.zzaqQ);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzta();
    }

    public String getDescription() {
        return (String) this.zzani.zza(zzof.zzaqR);
    }

    public String getIndexableText() {
        return (String) this.zzani.zza(zzof.zzaqX);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzani.zza(zzoh.zzarH);
    }

    public String getMimeType() {
        return (String) this.zzani.zza(zzof.zzarl);
    }

    public String getTitle() {
        return (String) this.zzani.zza(zzof.zzaru);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzani.zza(zzof.zzard);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzani.zza(zzof.zzars);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzani.zza(zzof.zzark);
    }

    public MetadataBundle zzsp() {
        return this.zzani;
    }
}
