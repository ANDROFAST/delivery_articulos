package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzto.zzb;

public class zzom {
    public static final zzb zzavA = zzdk("distance");
    public static final zzb zzavB = zzdk("height");
    public static final zzb zzavC = zzdk("weight");
    public static final zzb zzavD = zzdk("circumference");
    public static final zzb zzavE = zzdk("percentage");
    public static final zzb zzavF = zzdk("speed");
    public static final zzb zzavG = zzdk("rpm");
    public static final zzb zzavH = zzdj("revolutions");
    public static final zzb zzavI = zzdk(Field.NUTRIENT_CALORIES);
    public static final zzb zzavJ = zzdk("watts");
    public static final zzb zzavK = zzdj("meal_type");
    public static final zzb zzavL = zzdl("food_item");
    public static final zzb zzavM = zzdm("nutrients");
    public static final zzb zzavN = zzdk("elevation.change");
    public static final zzb zzavO = zzdm("elevation.gain");
    public static final zzb zzavP = zzdm("elevation.loss");
    public static final zzb zzavQ = zzdk("floors");
    public static final zzb zzavR = zzdm("floor.gain");
    public static final zzb zzavS = zzdm("floor.loss");
    public static final zzb zzavT = zzdl("exercise");
    public static final zzb zzavU = zzdj("repetitions");
    public static final zzb zzavV = zzdk("resistance");
    public static final zzb zzavW = zzdj("resistance_type");
    public static final zzb zzavX = zzdj("num_segments");
    public static final zzb zzavY = zzdk("average");
    public static final zzb zzavZ = zzdk("max");
    public static final zzb zzavn = zzdj("activity");
    public static final zzb zzavo = zzdk("confidence");
    public static final zzb zzavp = zzdm("activity_confidence");
    public static final zzb zzavq = zzdj("steps");
    public static final zzb zzavr = zzdj("duration");
    public static final zzb zzavs = zzdm("activity_duration");
    public static final zzb zzavt = zzdm("activity_duration.ascending");
    public static final zzb zzavu = zzdm("activity_duration.descending");
    public static final zzb zzavv = zzdk("bpm");
    public static final zzb zzavw = zzdk("latitude");
    public static final zzb zzavx = zzdk("longitude");
    public static final zzb zzavy = zzdk("accuracy");
    public static final zzb zzavz = zzdk("altitude");
    public static final zzb zzawa = zzdk("min");
    public static final zzb zzawb = zzdk("low_latitude");
    public static final zzb zzawc = zzdk("low_longitude");
    public static final zzb zzawd = zzdk("high_latitude");
    public static final zzb zzawe = zzdk("high_longitude");
    public static final zzb zzawf = zzdk("x");
    public static final zzb zzawg = zzdk("y");
    public static final zzb zzawh = zzdk("z");
    public static final zzb zzawi = zzdn("timestamps");
    public static final zzb zzawj = zzdo("sensor_values");
    public static final zzb zzawk = zzdj("sensor_type");

    private static zzb zza(String str, int i, Boolean bool) {
        zzb com_google_android_gms_internal_zzto_zzb = new zzb();
        com_google_android_gms_internal_zzto_zzb.name = str;
        com_google_android_gms_internal_zzto_zzb.zzbql = Integer.valueOf(i);
        if (bool != null) {
            com_google_android_gms_internal_zzto_zzb.zzbqm = bool;
        }
        return com_google_android_gms_internal_zzto_zzb;
    }

    private static zzb zzdj(String str) {
        return zzo(str, 1);
    }

    private static zzb zzdk(String str) {
        return zzo(str, 2);
    }

    private static zzb zzdl(String str) {
        return zzo(str, 3);
    }

    private static zzb zzdm(String str) {
        return zzo(str, 4);
    }

    private static zzb zzdn(String str) {
        return zzo(str, 5);
    }

    private static zzb zzdo(String str) {
        return zzo(str, 6);
    }

    public static zzb zzo(String str, int i) {
        return zza(str, i, null);
    }
}
