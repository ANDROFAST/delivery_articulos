package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzha
public abstract class zzce {
    @zzha
    public static final zzce zzwU = new C06851();
    @zzha
    public static final zzce zzwV = new C06862();
    @zzha
    public static final zzce zzwW = new C06873();

    static class C06851 extends zzce {
        C06851() {
        }

        public String zzc(String str, String str2) {
            return str2;
        }
    }

    static class C06862 extends zzce {
        C06862() {
        }

        public String zzc(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    static class C06873 extends zzce {
        C06873() {
        }

        private String zzQ(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzc(String str, String str2) {
            String zzQ = zzQ(str);
            String zzQ2 = zzQ(str2);
            return TextUtils.isEmpty(zzQ) ? zzQ2 : TextUtils.isEmpty(zzQ2) ? zzQ : zzQ + "," + zzQ2;
        }
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzc((String) map.get(str), str2));
    }

    public abstract String zzc(String str, String str2);
}
