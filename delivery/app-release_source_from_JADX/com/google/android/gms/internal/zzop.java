package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.internal.zzoq.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class zzop {
    private static final Set<String> zzaxk = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{zzom.zzavz.name, zzom.zzavL.name})));

    public static String zzd(DataPoint dataPoint) {
        DataType dataType = dataPoint.getDataType();
        if (!zzon.zzdp(dataType.getName())) {
            return null;
        }
        for (Field field : dataType.getFields()) {
            Value value = dataPoint.getValue(field);
            if (value.isSet()) {
                double asInt;
                if (field.getFormat() == 1) {
                    asInt = (double) value.asInt();
                } else if (field.getFormat() == 2) {
                    asInt = (double) value.asFloat();
                } else {
                    continue;
                }
                zza zzdq = zzoq.zzud().zzdq(field.getName());
                if (zzdq != null && !zzdq.zzh(asInt)) {
                    return "Field out of range";
                }
                zza zzD = zzoq.zzud().zzD(dataType.getName(), field.getName());
                if (zzD != null) {
                    long timestampNanos = dataPoint.getTimestampNanos() - dataPoint.zztH();
                    if (timestampNanos == 0) {
                        return asInt == 0.0d ? null : "DataPoint out of range";
                    } else {
                        if (!zzD.zzh(asInt / ((double) timestampNanos))) {
                            return "DataPoint out of range";
                        }
                    }
                } else {
                    continue;
                }
            } else if (!zzaxk.contains(field.getName())) {
                return field.getName() + " not set";
            }
        }
        return null;
    }
}
