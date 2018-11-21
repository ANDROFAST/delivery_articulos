package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zzh;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzsh {

    public static class zza {
        private final com.google.android.gms.internal.zzag.zza zzbfB;
        private final Map<String, com.google.android.gms.internal.zzag.zza> zzbhc;

        private zza(Map<String, com.google.android.gms.internal.zzag.zza> map, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzbhc = map;
            this.zzbfB = com_google_android_gms_internal_zzag_zza;
        }

        public static zzb zzFL() {
            return new zzb();
        }

        public String toString() {
            return "Properties: " + zzFM() + " pushAfterEvaluate: " + this.zzbfB;
        }

        public Map<String, com.google.android.gms.internal.zzag.zza> zzFM() {
            return Collections.unmodifiableMap(this.zzbhc);
        }

        public com.google.android.gms.internal.zzag.zza zzFl() {
            return this.zzbfB;
        }

        public void zza(String str, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzbhc.put(str, com_google_android_gms_internal_zzag_zza);
        }
    }

    public static class zzb {
        private com.google.android.gms.internal.zzag.zza zzbfB;
        private final Map<String, com.google.android.gms.internal.zzag.zza> zzbhc;

        private zzb() {
            this.zzbhc = new HashMap();
        }

        public zza zzFN() {
            return new zza(this.zzbhc, this.zzbfB);
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzbhc.put(str, com_google_android_gms_internal_zzag_zza);
            return this;
        }

        public zzb zzq(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzbfB = com_google_android_gms_internal_zzag_zza;
            return this;
        }
    }

    public static class zzc {
        private final String zzabv;
        private final List<zze> zzbhd;
        private final Map<String, List<zza>> zzbhe;
        private final int zzbhf;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzbhd = Collections.unmodifiableList(list);
            this.zzbhe = Collections.unmodifiableMap(map);
            this.zzabv = str;
            this.zzbhf = i;
        }

        public static zzd zzFO() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzabv;
        }

        public String toString() {
            return "Rules: " + zzFP() + "  Macros: " + this.zzbhe;
        }

        public List<zze> zzFP() {
            return this.zzbhd;
        }

        public Map<String, List<zza>> zzFQ() {
            return this.zzbhe;
        }
    }

    public static class zzd {
        private String zzabv;
        private final List<zze> zzbhd;
        private final Map<String, List<zza>> zzbhe;
        private int zzbhf;

        private zzd() {
            this.zzbhd = new ArrayList();
            this.zzbhe = new HashMap();
            this.zzabv = "";
            this.zzbhf = 0;
        }

        public zzc zzFR() {
            return new zzc(this.zzbhd, this.zzbhe, this.zzabv, this.zzbhf);
        }

        public zzd zzb(zze com_google_android_gms_internal_zzsh_zze) {
            this.zzbhd.add(com_google_android_gms_internal_zzsh_zze);
            return this;
        }

        public zzd zzc(zza com_google_android_gms_internal_zzsh_zza) {
            String zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) com_google_android_gms_internal_zzsh_zza.zzFM().get(zzae.INSTANCE_NAME.toString()));
            List list = (List) this.zzbhe.get(zzg);
            if (list == null) {
                list = new ArrayList();
                this.zzbhe.put(zzg, list);
            }
            list.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }

        public zzd zzfP(String str) {
            this.zzabv = str;
            return this;
        }

        public zzd zzjX(int i) {
            this.zzbhf = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> zzbhg;
        private final List<zza> zzbhh;
        private final List<zza> zzbhi;
        private final List<zza> zzbhj;
        private final List<zza> zzbhk;
        private final List<zza> zzbhl;
        private final List<String> zzbhm;
        private final List<String> zzbhn;
        private final List<String> zzbho;
        private final List<String> zzbhp;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzbhg = Collections.unmodifiableList(list);
            this.zzbhh = Collections.unmodifiableList(list2);
            this.zzbhi = Collections.unmodifiableList(list3);
            this.zzbhj = Collections.unmodifiableList(list4);
            this.zzbhk = Collections.unmodifiableList(list5);
            this.zzbhl = Collections.unmodifiableList(list6);
            this.zzbhm = Collections.unmodifiableList(list7);
            this.zzbhn = Collections.unmodifiableList(list8);
            this.zzbho = Collections.unmodifiableList(list9);
            this.zzbhp = Collections.unmodifiableList(list10);
        }

        public static zzf zzFS() {
            return new zzf();
        }

        public String toString() {
            return "Positive predicates: " + zzFT() + "  Negative predicates: " + zzFU() + "  Add tags: " + zzFV() + "  Remove tags: " + zzFW() + "  Add macros: " + zzFX() + "  Remove macros: " + zzGc();
        }

        public List<zza> zzFT() {
            return this.zzbhg;
        }

        public List<zza> zzFU() {
            return this.zzbhh;
        }

        public List<zza> zzFV() {
            return this.zzbhi;
        }

        public List<zza> zzFW() {
            return this.zzbhj;
        }

        public List<zza> zzFX() {
            return this.zzbhk;
        }

        public List<String> zzFY() {
            return this.zzbhm;
        }

        public List<String> zzFZ() {
            return this.zzbhn;
        }

        public List<String> zzGa() {
            return this.zzbho;
        }

        public List<String> zzGb() {
            return this.zzbhp;
        }

        public List<zza> zzGc() {
            return this.zzbhl;
        }
    }

    public static class zzf {
        private final List<zza> zzbhg;
        private final List<zza> zzbhh;
        private final List<zza> zzbhi;
        private final List<zza> zzbhj;
        private final List<zza> zzbhk;
        private final List<zza> zzbhl;
        private final List<String> zzbhm;
        private final List<String> zzbhn;
        private final List<String> zzbho;
        private final List<String> zzbhp;

        private zzf() {
            this.zzbhg = new ArrayList();
            this.zzbhh = new ArrayList();
            this.zzbhi = new ArrayList();
            this.zzbhj = new ArrayList();
            this.zzbhk = new ArrayList();
            this.zzbhl = new ArrayList();
            this.zzbhm = new ArrayList();
            this.zzbhn = new ArrayList();
            this.zzbho = new ArrayList();
            this.zzbhp = new ArrayList();
        }

        public zze zzGd() {
            return new zze(this.zzbhg, this.zzbhh, this.zzbhi, this.zzbhj, this.zzbhk, this.zzbhl, this.zzbhm, this.zzbhn, this.zzbho, this.zzbhp);
        }

        public zzf zzd(zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbhg.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }

        public zzf zze(zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbhh.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }

        public zzf zzf(zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbhi.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }

        public zzf zzfQ(String str) {
            this.zzbho.add(str);
            return this;
        }

        public zzf zzfR(String str) {
            this.zzbhp.add(str);
            return this;
        }

        public zzf zzfS(String str) {
            this.zzbhm.add(str);
            return this;
        }

        public zzf zzfT(String str) {
            this.zzbhn.add(str);
            return this;
        }

        public zzf zzg(zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbhj.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }

        public zzf zzh(zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbhk.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }

        public zzf zzi(zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbhl.add(com_google_android_gms_internal_zzsh_zza);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzag.zza zza(int i, com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf, com.google.android.gms.internal.zzag.zza[] com_google_android_gms_internal_zzag_zzaArr, Set<Integer> set) throws zzg {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzfO("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) zza(com_google_android_gms_internal_zzaf_zzf.zziz, i, "values");
        if (com_google_android_gms_internal_zzag_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzag_zzaArr[i];
        }
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza2 = null;
        set.add(Integer.valueOf(i));
        zzh zzp;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (com_google_android_gms_internal_zzag_zza.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                com_google_android_gms_internal_zzag_zza2 = com_google_android_gms_internal_zzag_zza;
                break;
            case 2:
                zzp = zzp(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2.zzjp = new com.google.android.gms.internal.zzag.zza[zzp.zzja.length];
                iArr = zzp.zzja;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzag_zza2.zzjp[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                zzh zzp2 = zzp(com_google_android_gms_internal_zzag_zza);
                if (zzp2.zzjb.length != zzp2.zzjc.length) {
                    zzfO("Uneven map keys (" + zzp2.zzjb.length + ") and map values (" + zzp2.zzjc.length + ")");
                }
                com_google_android_gms_internal_zzag_zza2.zzjq = new com.google.android.gms.internal.zzag.zza[zzp2.zzjb.length];
                com_google_android_gms_internal_zzag_zza2.zzjr = new com.google.android.gms.internal.zzag.zza[zzp2.zzjb.length];
                int[] iArr2 = zzp2.zzjb;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    com_google_android_gms_internal_zzag_zza2.zzjq[i4] = zza(iArr2[i3], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = zzp2.zzjc;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzag_zza2.zzjr[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2.zzjs = zzdf.zzg(zza(zzp(com_google_android_gms_internal_zzag_zza).zzjf, com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set));
                break;
            case 7:
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                zzp = zzp(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2.zzjw = new com.google.android.gms.internal.zzag.zza[zzp.zzje.length];
                iArr = zzp.zzje;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzag_zza2.zzjw[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (com_google_android_gms_internal_zzag_zza2 == null) {
            zzfO("Invalid value: " + com_google_android_gms_internal_zzag_zza);
        }
        com_google_android_gms_internal_zzag_zzaArr[i] = com_google_android_gms_internal_zzag_zza2;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzag_zza2;
    }

    private static zza zza(com.google.android.gms.internal.zzaf.zzb com_google_android_gms_internal_zzaf_zzb, com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf, com.google.android.gms.internal.zzag.zza[] com_google_android_gms_internal_zzag_zzaArr, int i) throws zzg {
        zzb zzFL = zza.zzFL();
        for (int valueOf : com_google_android_gms_internal_zzaf_zzb.zzik) {
            com.google.android.gms.internal.zzaf.zze com_google_android_gms_internal_zzaf_zze = (com.google.android.gms.internal.zzaf.zze) zza(com_google_android_gms_internal_zzaf_zzf.zziA, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(com_google_android_gms_internal_zzaf_zzf.zziy, com_google_android_gms_internal_zzaf_zze.key, "keys");
            com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) zza(com_google_android_gms_internal_zzag_zzaArr, com_google_android_gms_internal_zzaf_zze.value, "values");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzFL.zzq(com_google_android_gms_internal_zzag_zza);
            } else {
                zzFL.zzb(str, com_google_android_gms_internal_zzag_zza);
            }
        }
        return zzFL.zzFN();
    }

    private static zze zza(com.google.android.gms.internal.zzaf.zzg com_google_android_gms_internal_zzaf_zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf) {
        zzf zzFS = zze.zzFS();
        for (int valueOf : com_google_android_gms_internal_zzaf_zzg.zziO) {
            zzFS.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : com_google_android_gms_internal_zzaf_zzg.zziP) {
            zzFS.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : com_google_android_gms_internal_zzaf_zzg.zziQ) {
            zzFS.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : com_google_android_gms_internal_zzaf_zzg.zziS) {
            zzFS.zzfQ(com_google_android_gms_internal_zzaf_zzf.zziz[Integer.valueOf(valueOf3).intValue()].zzjo);
        }
        for (int valueOf222 : com_google_android_gms_internal_zzaf_zzg.zziR) {
            zzFS.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : com_google_android_gms_internal_zzaf_zzg.zziT) {
            zzFS.zzfR(com_google_android_gms_internal_zzaf_zzf.zziz[Integer.valueOf(valueOf32).intValue()].zzjo);
        }
        for (int valueOf2222 : com_google_android_gms_internal_zzaf_zzg.zziU) {
            zzFS.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : com_google_android_gms_internal_zzaf_zzg.zziW) {
            zzFS.zzfS(com_google_android_gms_internal_zzaf_zzf.zziz[Integer.valueOf(valueOf322).intValue()].zzjo);
        }
        for (int valueOf22222 : com_google_android_gms_internal_zzaf_zzg.zziV) {
            zzFS.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : com_google_android_gms_internal_zzaf_zzg.zziX) {
            zzFS.zzfT(com_google_android_gms_internal_zzaf_zzf.zziz[Integer.valueOf(valueOf4).intValue()].zzjo);
        }
        return zzFS.zzGd();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzfO("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf) throws zzg {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzag.zza[] com_google_android_gms_internal_zzag_zzaArr = new com.google.android.gms.internal.zzag.zza[com_google_android_gms_internal_zzaf_zzf.zziz.length];
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zziz.length; i++) {
            zza(i, com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, new HashSet(0));
        }
        zzd zzFO = zzc.zzFO();
        List arrayList = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zziC.length; i++) {
            arrayList.add(zza(com_google_android_gms_internal_zzaf_zzf.zziC[i], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zziD.length; i++) {
            arrayList2.add(zza(com_google_android_gms_internal_zzaf_zzf.zziD[i], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zziB.length; i++) {
            zza zza = zza(com_google_android_gms_internal_zzaf_zzf.zziB[i], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, i);
            zzFO.zzc(zza);
            arrayList3.add(zza);
        }
        com.google.android.gms.internal.zzaf.zzg[] com_google_android_gms_internal_zzaf_zzgArr = com_google_android_gms_internal_zzaf_zzf.zziE;
        int length = com_google_android_gms_internal_zzaf_zzgArr.length;
        while (i2 < length) {
            zzFO.zzb(zza(com_google_android_gms_internal_zzaf_zzgArr[i2], arrayList, arrayList3, arrayList2, com_google_android_gms_internal_zzaf_zzf));
            i2++;
        }
        zzFO.zzfP(com_google_android_gms_internal_zzaf_zzf.version);
        zzFO.zzjX(com_google_android_gms_internal_zzaf_zzf.zziM);
        return zzFO.zzFR();
    }

    public static void zzb(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzfO(String str) throws zzg {
        zzbg.m9e(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzag.zza zzo(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza2 = new com.google.android.gms.internal.zzag.zza();
        com_google_android_gms_internal_zzag_zza2.type = com_google_android_gms_internal_zzag_zza.type;
        com_google_android_gms_internal_zzag_zza2.zzjx = (int[]) com_google_android_gms_internal_zzag_zza.zzjx.clone();
        if (com_google_android_gms_internal_zzag_zza.zzjy) {
            com_google_android_gms_internal_zzag_zza2.zzjy = com_google_android_gms_internal_zzag_zza.zzjy;
        }
        return com_google_android_gms_internal_zzag_zza2;
    }

    private static zzh zzp(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) throws zzg {
        if (((zzh) com_google_android_gms_internal_zzag_zza.zza(zzh.zziY)) == null) {
            zzfO("Expected a ServingValue and didn't get one. Value is: " + com_google_android_gms_internal_zzag_zza);
        }
        return (zzh) com_google_android_gms_internal_zzag_zza.zza(zzh.zziY);
    }
}
