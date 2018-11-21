package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] zzSH = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzSI = new HashMap(zzSH.length);

    static {
        int i = 0;
        while (i < zzSH.length) {
            zzSI.put(zzSH[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzao(int i) {
        return (i < 0 || i >= zzSH.length) ? null : zzSH[i];
    }

    public static int zzbx(String str) {
        Integer num = (Integer) zzSI.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzlP() {
        return zzSH.length;
    }
}
