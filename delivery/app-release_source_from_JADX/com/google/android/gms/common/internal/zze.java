package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zze {
    public static final zze zzaiV = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(' ', ' '));
    public static final zze zzaiW = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
    public static final zze zzaiX = zza('\u0000', '');
    public static final zze zzaiY;
    public static final zze zzaiZ = zza('\t', '\r').zza(zza('\u001c', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
    public static final zze zzaja = new C06451();
    public static final zze zzajb = new C06495();
    public static final zze zzajc = new C06506();
    public static final zze zzajd = new C06517();
    public static final zze zzaje = new C06528();
    public static final zze zzajf = zza('\u0000', '\u001f').zza(zza('', ''));
    public static final zze zzajg = zza('\u0000', ' ').zza(zza('', ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza('?', '')).zza(zza((CharSequence) "﻿￹￺￻"));
    public static final zze zzajh = zza('\u0000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza('ﭐ', '﷿')).zza(zza('ﹰ', '﻿')).zza(zza('｡', 'ￜ'));
    public static final zze zzaji = new C06539();
    public static final zze zzajj = new zze() {
        public zze zza(zze com_google_android_gms_common_internal_zze) {
            return (zze) zzx.zzy(com_google_android_gms_common_internal_zze);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };

    static class C06451 extends zze {
        C06451() {
        }

        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    }

    static class C06495 extends zze {
        C06495() {
        }

        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    }

    static class C06506 extends zze {
        C06506() {
        }

        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    static class C06517 extends zze {
        C06517() {
        }

        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    }

    static class C06528 extends zze {
        C06528() {
        }

        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    }

    static class C06539 extends zze {
        C06539() {
        }

        public zze zza(zze com_google_android_gms_common_internal_zze) {
            zzx.zzy(com_google_android_gms_common_internal_zze);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzx.zzy(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    }

    private static class zza extends zze {
        List<zze> zzajq;

        zza(List<zze> list) {
            this.zzajq = list;
        }

        public zze zza(zze com_google_android_gms_common_internal_zze) {
            List arrayList = new ArrayList(this.zzajq);
            arrayList.add(zzx.zzy(com_google_android_gms_common_internal_zze));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zze zzd : this.zzajq) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zze zza = zza('0', '9');
        zze com_google_android_gms_common_internal_zze = zza;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            com_google_android_gms_common_internal_zze = com_google_android_gms_common_internal_zze.zza(zza(c, (char) (c + 9)));
        }
        zzaiY = com_google_android_gms_common_internal_zze;
    }

    public static zze zza(final char c, final char c2) {
        zzx.zzab(c2 >= c);
        return new zze() {
            public boolean zzd(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    public static zze zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return zzajj;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new zze() {
                    public boolean zzd(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new zze() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(toCharArray, c) >= 0;
                    }
                };
        }
    }

    public static zze zzc(final char c) {
        return new zze() {
            public zze zza(zze com_google_android_gms_common_internal_zze) {
                return com_google_android_gms_common_internal_zze.zzd(c) ? com_google_android_gms_common_internal_zze : super.zza(com_google_android_gms_common_internal_zze);
            }

            public boolean zzd(char c) {
                return c == c;
            }
        };
    }

    public zze zza(zze com_google_android_gms_common_internal_zze) {
        return new zza(Arrays.asList(new zze[]{this, (zze) zzx.zzy(com_google_android_gms_common_internal_zze)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
