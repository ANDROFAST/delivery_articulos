package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoj;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zze {
    private static final Map<String, MetadataField<?>> zzaqJ = new HashMap();
    private static final Map<String, zza> zzaqK = new HashMap();

    public interface zza {
        void zzb(DataHolder dataHolder);

        String zzte();
    }

    static {
        zzb(zzof.zzaqO);
        zzb(zzof.zzaru);
        zzb(zzof.zzarl);
        zzb(zzof.zzars);
        zzb(zzof.zzarv);
        zzb(zzof.zzarb);
        zzb(zzof.zzara);
        zzb(zzof.zzarc);
        zzb(zzof.zzard);
        zzb(zzof.zzare);
        zzb(zzof.zzaqY);
        zzb(zzof.zzarg);
        zzb(zzof.zzarh);
        zzb(zzof.zzari);
        zzb(zzof.zzarq);
        zzb(zzof.zzaqP);
        zzb(zzof.zzarn);
        zzb(zzof.zzaqR);
        zzb(zzof.zzaqZ);
        zzb(zzof.zzaqS);
        zzb(zzof.zzaqT);
        zzb(zzof.zzaqU);
        zzb(zzof.zzaqV);
        zzb(zzof.zzark);
        zzb(zzof.zzarf);
        zzb(zzof.zzarm);
        zzb(zzof.zzaro);
        zzb(zzof.zzarp);
        zzb(zzof.zzarr);
        zzb(zzof.zzarw);
        zzb(zzof.zzarx);
        zzb(zzof.zzaqX);
        zzb(zzof.zzaqW);
        zzb(zzof.zzart);
        zzb(zzof.zzarj);
        zzb(zzof.zzaqQ);
        zzb(zzof.zzary);
        zzb(zzof.zzarz);
        zzb(zzof.zzarA);
        zzb(zzof.zzarB);
        zzb(zzof.zzarC);
        zzb(zzof.zzarD);
        zzb(zzof.zzarE);
        zzb(zzoh.zzarG);
        zzb(zzoh.zzarI);
        zzb(zzoh.zzarJ);
        zzb(zzoh.zzarK);
        zzb(zzoh.zzarH);
        zzb(zzoh.zzarL);
        zzb(zzoj.zzarN);
        zzb(zzoj.zzarO);
        zzl com_google_android_gms_drive_metadata_internal_zzl = zzof.zzarq;
        zza(zzl.zzaqN);
        zza(zzog.zzarF);
    }

    public static void zza(DataHolder dataHolder) {
        for (zza zzb : zzaqK.values()) {
            zzb.zzb(dataHolder);
        }
    }

    private static void zza(zza com_google_android_gms_drive_metadata_internal_zze_zza) {
        if (zzaqK.put(com_google_android_gms_drive_metadata_internal_zze_zza.zzte(), com_google_android_gms_drive_metadata_internal_zze_zza) != null) {
            throw new IllegalStateException("A cleaner for key " + com_google_android_gms_drive_metadata_internal_zze_zza.zzte() + " has already been registered");
        }
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzaqJ.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        zzaqJ.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzcU(String str) {
        return (MetadataField) zzaqJ.get(str);
    }

    public static Collection<MetadataField<?>> zztd() {
        return Collections.unmodifiableCollection(zzaqJ.values());
    }
}
