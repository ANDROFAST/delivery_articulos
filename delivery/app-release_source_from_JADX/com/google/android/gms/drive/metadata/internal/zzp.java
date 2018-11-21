package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp extends zzj<UserMetadata> {
    public zzp(String str, int i) {
        super(str, zzcX(str), Collections.emptyList(), i);
    }

    private static String zzC(String str, String str2) {
        return str + "." + str2;
    }

    private String zzcW(String str) {
        return zzC(getName(), str);
    }

    private static Collection<String> zzcX(String str) {
        return Arrays.asList(new String[]{zzC(str, "permissionId"), zzC(str, "displayName"), zzC(str, "picture"), zzC(str, "isAuthenticatedUser"), zzC(str, "emailAddress")});
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzct(zzcW("permissionId")) && !dataHolder.zzi(zzcW("permissionId"), i, i2);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzj(dataHolder, i, i2);
    }

    protected UserMetadata zzj(DataHolder dataHolder, int i, int i2) {
        String zzd = dataHolder.zzd(zzcW("permissionId"), i, i2);
        if (zzd == null) {
            return null;
        }
        String zzd2 = dataHolder.zzd(zzcW("displayName"), i, i2);
        String zzd3 = dataHolder.zzd(zzcW("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.zze(zzcW("isAuthenticatedUser"), i, i2));
        return new UserMetadata(zzd, zzd2, zzd3, valueOf.booleanValue(), dataHolder.zzd(zzcW("emailAddress"), i, i2));
    }
}
