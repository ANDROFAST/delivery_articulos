package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzoi extends zzj<DriveId> {
    public static final zzoi zzarM = new zzoi();

    private zzoi() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String zzct : zzsZ()) {
            if (!dataHolder.zzct(zzct)) {
                return false;
            }
        }
        return true;
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzm(dataHolder, i, i2);
    }

    protected DriveId zzm(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.zzpH().getLong("dbInstanceId");
        int i3 = DriveFolder.MIME_TYPE.equals(dataHolder.zzd(zzof.zzarl.getName(), i, i2)) ? 1 : 0;
        String zzd = dataHolder.zzd("resourceId", i, i2);
        Long valueOf = Long.valueOf(dataHolder.zzb("sqlId", i, i2));
        if ("generated-android-null".equals(zzd)) {
            zzd = null;
        }
        return new DriveId(zzd, valueOf.longValue(), j, i3);
    }
}
