package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public static final PasswordSpecification zzUO = new zza().zzh(12, 16).zzbD("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzmj();
    public static final PasswordSpecification zzUP = new zza().zzh(12, 16).zzbD("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzmj();
    final int mVersionCode;
    final String zzUQ;
    final List<String> zzUR;
    final List<Integer> zzUS;
    final int zzUT;
    final int zzUU;
    private final int[] zzUV = zzmi();
    private final Random zzuj = new SecureRandom();

    public static class zza {
        private final List<String> zzUR = new ArrayList();
        private final List<Integer> zzUS = new ArrayList();
        private int zzUT = 12;
        private int zzUU = 16;
        private final TreeSet<Character> zzUW = new TreeSet();

        private void zzmk() {
            int i = 0;
            for (Integer intValue : this.zzUS) {
                i = intValue.intValue() + i;
            }
            if (i > this.zzUU) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void zzml() {
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.zzUR) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        throw new zzb("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - 32] = true;
                }
            }
        }

        private TreeSet<Character> zzr(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zzb(c, 32, TransportMediator.KEYCODE_MEDIA_PLAY)) {
                    throw new zzb(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public zza zzbD(String str) {
            this.zzUW.addAll(zzr(str, "allowedChars"));
            return this;
        }

        public zza zze(String str, int i) {
            if (i < 1) {
                throw new zzb("count must be at least 1");
            }
            this.zzUR.add(PasswordSpecification.zzb(zzr(str, "requiredChars")));
            this.zzUS.add(Integer.valueOf(i));
            return this;
        }

        public zza zzh(int i, int i2) {
            if (i < 1) {
                throw new zzb("minimumSize must be at least 1");
            } else if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            } else {
                this.zzUT = i;
                this.zzUU = i2;
                return this;
            }
        }

        public PasswordSpecification zzmj() {
            if (this.zzUW.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            zzmk();
            zzml();
            return new PasswordSpecification(1, PasswordSpecification.zzb(this.zzUW), this.zzUR, this.zzUS, this.zzUT, this.zzUU);
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(int version, String allowedChars, List<String> requiredCharSets, List<Integer> requiredCharCounts, int minimumSize, int maximumSize) {
        this.mVersionCode = version;
        this.zzUQ = allowedChars;
        this.zzUR = Collections.unmodifiableList(requiredCharSets);
        this.zzUS = Collections.unmodifiableList(requiredCharCounts);
        this.zzUT = minimumSize;
        this.zzUU = maximumSize;
    }

    private int zza(char c) {
        return c - 32;
    }

    private static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    private static boolean zzb(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    private int[] zzmi() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.zzUR) {
            for (char zza : toCharArray.toCharArray()) {
                iArr[zza(zza)] = i;
            }
            i++;
        }
        return iArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }
}
