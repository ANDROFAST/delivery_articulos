package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdf {
    private static Double zzbgA = new Double(0.0d);
    private static zzde zzbgB = zzde.zzX(0);
    private static String zzbgC = new String("");
    private static Boolean zzbgD = new Boolean(false);
    private static List<Object> zzbgE = new ArrayList(0);
    private static Map<Object, Object> zzbgF = new HashMap();
    private static zza zzbgG = zzR(zzbgC);
    private static final Object zzbgy = null;
    private static Long zzbgz = new Long(0);

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        zzbg.m9e("getDouble received non-Number");
        return 0.0d;
    }

    public static Object zzFD() {
        return zzbgy;
    }

    public static Long zzFE() {
        return zzbgz;
    }

    public static Double zzFF() {
        return zzbgA;
    }

    public static Boolean zzFG() {
        return zzbgD;
    }

    public static zzde zzFH() {
        return zzbgB;
    }

    public static String zzFI() {
        return zzbgC;
    }

    public static zza zzFJ() {
        return zzbgG;
    }

    public static String zzM(Object obj) {
        return obj == null ? zzbgC : obj.toString();
    }

    public static zzde zzN(Object obj) {
        return obj instanceof zzde ? (zzde) obj : zzT(obj) ? zzde.zzX(zzU(obj)) : zzS(obj) ? zzde.zza(Double.valueOf(getDouble(obj))) : zzfG(zzM(obj));
    }

    public static Long zzO(Object obj) {
        return zzT(obj) ? Long.valueOf(zzU(obj)) : zzfH(zzM(obj));
    }

    public static Double zzP(Object obj) {
        return zzS(obj) ? Double.valueOf(getDouble(obj)) : zzfI(zzM(obj));
    }

    public static Boolean zzQ(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzfJ(zzM(obj));
    }

    public static zza zzR(Object obj) {
        boolean z = false;
        zza com_google_android_gms_internal_zzag_zza = new zza();
        if (obj instanceof zza) {
            return (zza) obj;
        }
        if (obj instanceof String) {
            com_google_android_gms_internal_zzag_zza.type = 1;
            com_google_android_gms_internal_zzag_zza.zzjo = (String) obj;
        } else if (obj instanceof List) {
            com_google_android_gms_internal_zzag_zza.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object zzR : list) {
                zza zzR2 = zzR(zzR);
                if (zzR2 == zzbgG) {
                    return zzbgG;
                }
                r0 = r1 || zzR2.zzjy;
                r5.add(zzR2);
                r1 = r0;
            }
            com_google_android_gms_internal_zzag_zza.zzjp = (zza[]) r5.toArray(new zza[0]);
            z = r1;
        } else if (obj instanceof Map) {
            com_google_android_gms_internal_zzag_zza.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                zza zzR3 = zzR(entry.getKey());
                zza zzR4 = zzR(entry.getValue());
                if (zzR3 == zzbgG || zzR4 == zzbgG) {
                    return zzbgG;
                }
                r0 = r1 || zzR3.zzjy || zzR4.zzjy;
                r5.add(zzR3);
                arrayList.add(zzR4);
                r1 = r0;
            }
            com_google_android_gms_internal_zzag_zza.zzjq = (zza[]) r5.toArray(new zza[0]);
            com_google_android_gms_internal_zzag_zza.zzjr = (zza[]) arrayList.toArray(new zza[0]);
            z = r1;
        } else if (zzS(obj)) {
            com_google_android_gms_internal_zzag_zza.type = 1;
            com_google_android_gms_internal_zzag_zza.zzjo = obj.toString();
        } else if (zzT(obj)) {
            com_google_android_gms_internal_zzag_zza.type = 6;
            com_google_android_gms_internal_zzag_zza.zzju = zzU(obj);
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzag_zza.type = 8;
            com_google_android_gms_internal_zzag_zza.zzjv = ((Boolean) obj).booleanValue();
        } else {
            zzbg.m9e("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return zzbgG;
        }
        com_google_android_gms_internal_zzag_zza.zzjy = z;
        return com_google_android_gms_internal_zzag_zza;
    }

    private static boolean zzS(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzFy());
    }

    private static boolean zzT(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzFz());
    }

    private static long zzU(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.m9e("getInt64 received non-Number");
        return 0;
    }

    public static zza zzfF(String str) {
        zza com_google_android_gms_internal_zzag_zza = new zza();
        com_google_android_gms_internal_zzag_zza.type = 5;
        com_google_android_gms_internal_zzag_zza.zzjt = str;
        return com_google_android_gms_internal_zzag_zza;
    }

    private static zzde zzfG(String str) {
        try {
            return zzde.zzfE(str);
        } catch (NumberFormatException e) {
            zzbg.m9e("Failed to convert '" + str + "' to a number.");
            return zzbgB;
        }
    }

    private static Long zzfH(String str) {
        zzde zzfG = zzfG(str);
        return zzfG == zzbgB ? zzbgz : Long.valueOf(zzfG.longValue());
    }

    private static Double zzfI(String str) {
        zzde zzfG = zzfG(str);
        return zzfG == zzbgB ? zzbgA : Double.valueOf(zzfG.doubleValue());
    }

    private static Boolean zzfJ(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzbgD;
    }

    public static String zzg(zza com_google_android_gms_internal_zzag_zza) {
        return zzM(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static zzde zzh(zza com_google_android_gms_internal_zzag_zza) {
        return zzN(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Long zzi(zza com_google_android_gms_internal_zzag_zza) {
        return zzO(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Double zzj(zza com_google_android_gms_internal_zzag_zza) {
        return zzP(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Boolean zzk(zza com_google_android_gms_internal_zzag_zza) {
        return zzQ(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Object zzl(zza com_google_android_gms_internal_zzag_zza) {
        int i = 0;
        if (com_google_android_gms_internal_zzag_zza == null) {
            return zzbgy;
        }
        zza[] com_google_android_gms_internal_zzag_zzaArr;
        int length;
        switch (com_google_android_gms_internal_zzag_zza.type) {
            case 1:
                return com_google_android_gms_internal_zzag_zza.zzjo;
            case 2:
                ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzag_zza.zzjp.length);
                com_google_android_gms_internal_zzag_zzaArr = com_google_android_gms_internal_zzag_zza.zzjp;
                length = com_google_android_gms_internal_zzag_zzaArr.length;
                while (i < length) {
                    Object zzl = zzl(com_google_android_gms_internal_zzag_zzaArr[i]);
                    if (zzl == zzbgy) {
                        return zzbgy;
                    }
                    arrayList.add(zzl);
                    i++;
                }
                return arrayList;
            case 3:
                if (com_google_android_gms_internal_zzag_zza.zzjq.length != com_google_android_gms_internal_zzag_zza.zzjr.length) {
                    zzbg.m9e("Converting an invalid value to object: " + com_google_android_gms_internal_zzag_zza.toString());
                    return zzbgy;
                }
                Map hashMap = new HashMap(com_google_android_gms_internal_zzag_zza.zzjr.length);
                while (i < com_google_android_gms_internal_zzag_zza.zzjq.length) {
                    Object zzl2 = zzl(com_google_android_gms_internal_zzag_zza.zzjq[i]);
                    Object zzl3 = zzl(com_google_android_gms_internal_zzag_zza.zzjr[i]);
                    if (zzl2 == zzbgy || zzl3 == zzbgy) {
                        return zzbgy;
                    }
                    hashMap.put(zzl2, zzl3);
                    i++;
                }
                return hashMap;
            case 4:
                zzbg.m9e("Trying to convert a macro reference to object");
                return zzbgy;
            case 5:
                zzbg.m9e("Trying to convert a function id to object");
                return zzbgy;
            case 6:
                return Long.valueOf(com_google_android_gms_internal_zzag_zza.zzju);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                com_google_android_gms_internal_zzag_zzaArr = com_google_android_gms_internal_zzag_zza.zzjw;
                length = com_google_android_gms_internal_zzag_zzaArr.length;
                while (i < length) {
                    String zzg = zzg(com_google_android_gms_internal_zzag_zzaArr[i]);
                    if (zzg == zzbgC) {
                        return zzbgy;
                    }
                    stringBuffer.append(zzg);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(com_google_android_gms_internal_zzag_zza.zzjv);
            default:
                zzbg.m9e("Failed to convert a value of type: " + com_google_android_gms_internal_zzag_zza.type);
                return zzbgy;
        }
    }
}
