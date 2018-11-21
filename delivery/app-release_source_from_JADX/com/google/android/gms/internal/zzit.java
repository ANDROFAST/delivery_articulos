package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzit {
    private final String[] zzKZ;
    private final double[] zzLa;
    private final double[] zzLb;
    private final int[] zzLc;
    private int zzLd;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzLe;
        public final double zzLf;
        public final double zzLg;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzLf = d;
            this.zzLe = d2;
            this.zzLg = d3;
            this.count = i;
        }

        public boolean equals(Object other) {
            if (!(other instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzit_zza = (zza) other;
            return zzw.equal(this.name, com_google_android_gms_internal_zzit_zza.name) && this.zzLe == com_google_android_gms_internal_zzit_zza.zzLe && this.zzLf == com_google_android_gms_internal_zzit_zza.zzLf && this.count == com_google_android_gms_internal_zzit_zza.count && Double.compare(this.zzLg, com_google_android_gms_internal_zzit_zza.zzLg) == 0;
        }

        public int hashCode() {
            return zzw.hashCode(this.name, Double.valueOf(this.zzLe), Double.valueOf(this.zzLf), Double.valueOf(this.zzLg), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzw.zzx(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzLf)).zzg("maxBound", Double.valueOf(this.zzLe)).zzg("percent", Double.valueOf(this.zzLg)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzLh = new ArrayList();
        private final List<Double> zzLi = new ArrayList();
        private final List<Double> zzLj = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i = 0;
            while (i < this.zzLh.size()) {
                double doubleValue = ((Double) this.zzLj.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.zzLi.get(i)).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.zzLh.add(i, str);
            this.zzLj.add(i, Double.valueOf(d));
            this.zzLi.add(i, Double.valueOf(d2));
            return this;
        }

        public zzit zzhi() {
            return new zzit();
        }
    }

    private zzit(zzb com_google_android_gms_internal_zzit_zzb) {
        int size = com_google_android_gms_internal_zzit_zzb.zzLi.size();
        this.zzKZ = (String[]) com_google_android_gms_internal_zzit_zzb.zzLh.toArray(new String[size]);
        this.zzLa = zzi(com_google_android_gms_internal_zzit_zzb.zzLi);
        this.zzLb = zzi(com_google_android_gms_internal_zzit_zzb.zzLj);
        this.zzLc = new int[size];
        this.zzLd = 0;
    }

    private double[] zzi(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        List<zza> arrayList = new ArrayList(this.zzKZ.length);
        for (int i = 0; i < this.zzKZ.length; i++) {
            arrayList.add(new zza(this.zzKZ[i], this.zzLb[i], this.zzLa[i], ((double) this.zzLc[i]) / ((double) this.zzLd), this.zzLc[i]));
        }
        return arrayList;
    }

    public void zza(double d) {
        this.zzLd++;
        int i = 0;
        while (i < this.zzLb.length) {
            if (this.zzLb[i] <= d && d < this.zzLa[i]) {
                int[] iArr = this.zzLc;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzLb[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
