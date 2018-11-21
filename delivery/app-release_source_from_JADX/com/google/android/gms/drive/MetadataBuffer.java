package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzof;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzanf;

    private static class zza extends Metadata {
        private final DataHolder zzafC;
        private final int zzahx;
        private final int zzang;

        public zza(DataHolder dataHolder, int i) {
            this.zzafC = dataHolder;
            this.zzang = i;
            this.zzahx = dataHolder.zzbI(i);
        }

        public /* synthetic */ Object freeze() {
            return zzso();
        }

        public boolean isDataValid() {
            return !this.zzafC.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzafC, this.zzang, this.zzahx);
        }

        public Metadata zzso() {
            MetadataBundle zztf = MetadataBundle.zztf();
            for (MetadataField metadataField : zze.zztd()) {
                if (metadataField != zzof.zzart) {
                    metadataField.zza(this.zzafC, zztf, this.zzang, this.zzahx);
                }
            }
            return new zzp(zztf);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zzpH().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza com_google_android_gms_drive_MetadataBuffer_zza = this.zzanf;
        if (com_google_android_gms_drive_MetadataBuffer_zza != null && com_google_android_gms_drive_MetadataBuffer_zza.zzang == row) {
            return com_google_android_gms_drive_MetadataBuffer_zza;
        }
        Metadata com_google_android_gms_drive_MetadataBuffer_zza2 = new zza(this.zzafC, row);
        this.zzanf = com_google_android_gms_drive_MetadataBuffer_zza2;
        return com_google_android_gms_drive_MetadataBuffer_zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzafC != null) {
            zze.zza(this.zzafC);
        }
        super.release();
    }
}
