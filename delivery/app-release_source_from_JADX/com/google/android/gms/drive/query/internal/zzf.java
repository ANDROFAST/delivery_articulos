package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import java.util.List;

public interface zzf<F> {
    F zzA(F f);

    <T> F zzb(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t);

    <T> F zzb(Operator operator, MetadataField<T> metadataField, T t);

    F zzb(Operator operator, List<F> list);

    <T> F zzd(MetadataField<T> metadataField, T t);

    F zzda(String str);

    F zze(MetadataField<?> metadataField);

    F zztn();

    F zzto();
}
