package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzSJ;
    public final boolean zzSK;
    public final boolean zzSL;
    public final String zzSM;
    public final Feature[] zzSN;
    final int[] zzSO;
    public final String zzSP;

    public static final class zza {
        private final String mName;
        private String zzSQ;
        private boolean zzSR;
        private int zzSS = 1;
        private boolean zzST;
        private String zzSU;
        private final List<Feature> zzSV = new ArrayList();
        private BitSet zzSW;
        private String zzSX;

        public zza(String str) {
            this.mName = str;
        }

        public zza zzM(boolean z) {
            this.zzSR = z;
            return this;
        }

        public zza zzN(boolean z) {
            this.zzST = z;
            return this;
        }

        public zza zzap(int i) {
            if (this.zzSW == null) {
                this.zzSW = new BitSet();
            }
            this.zzSW.set(i);
            return this;
        }

        public zza zzby(String str) {
            this.zzSQ = str;
            return this;
        }

        public zza zzbz(String str) {
            this.zzSX = str;
            return this;
        }

        public RegisterSectionInfo zzlQ() {
            int i = 0;
            int[] iArr = null;
            if (this.zzSW != null) {
                iArr = new int[this.zzSW.cardinality()];
                int nextSetBit = this.zzSW.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.zzSW.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            }
            return new RegisterSectionInfo(this.mName, this.zzSQ, this.zzSR, this.zzSS, this.zzST, this.zzSU, (Feature[]) this.zzSV.toArray(new Feature[this.zzSV.size()]), iArr, this.zzSX);
        }
    }

    RegisterSectionInfo(int versionCode, String name, String format, boolean noIndex, int weight, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzSJ = format;
        this.zzSK = noIndex;
        this.weight = weight;
        this.zzSL = indexPrefixes;
        this.zzSM = subsectionSeparator;
        this.zzSN = features;
        this.zzSO = semanticLabels;
        this.zzSP = schemaOrgProperty;
    }

    RegisterSectionInfo(String name, String format, boolean noIndex, int weight, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this(2, name, format, noIndex, weight, indexPrefixes, subsectionSeparator, features, semanticLabels, schemaOrgProperty);
    }

    public int describeContents() {
        zzi com_google_android_gms_appdatasearch_zzi = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi com_google_android_gms_appdatasearch_zzi = CREATOR;
        zzi.zza(this, out, flags);
    }
}
