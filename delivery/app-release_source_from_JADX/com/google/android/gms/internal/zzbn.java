package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzha
public class zzbn {
    private final int zzte;
    private final int zztf;
    private final int zztg;
    private final zzbm zzth = new zzbp();

    class C02731 implements Comparator<String> {
        final /* synthetic */ zzbn zzti;

        C02731(zzbn com_google_android_gms_internal_zzbn) {
            this.zzti = com_google_android_gms_internal_zzbn;
        }

        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }

    class C02742 implements Comparator<com.google.android.gms.internal.zzbq.zza> {
        final /* synthetic */ zzbn zzti;

        C02742(zzbn com_google_android_gms_internal_zzbn) {
            this.zzti = com_google_android_gms_internal_zzbn;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((com.google.android.gms.internal.zzbq.zza) x0, (com.google.android.gms.internal.zzbq.zza) x1);
        }

        public int zza(com.google.android.gms.internal.zzbq.zza com_google_android_gms_internal_zzbq_zza, com.google.android.gms.internal.zzbq.zza com_google_android_gms_internal_zzbq_zza2) {
            return (int) (com_google_android_gms_internal_zzbq_zza.value - com_google_android_gms_internal_zzbq_zza2.value);
        }
    }

    static class zza {
        ByteArrayOutputStream zztj = new ByteArrayOutputStream(4096);
        Base64OutputStream zztk = new Base64OutputStream(this.zztj, 10);

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.zztk.close();
            } catch (Throwable e) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zztj.close();
                byteArrayOutputStream = this.zztj.toString();
            } catch (Throwable e2) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.zztj = null;
                this.zztk = null;
            }
            return byteArrayOutputStream;
        }

        public void write(byte[] data) throws IOException {
            this.zztk.write(data);
        }
    }

    public zzbn(int i) {
        this.zztf = i;
        this.zzte = 6;
        this.zztg = 0;
    }

    private String zzA(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcH = zzcH();
        Arrays.sort(split, new C02731(this));
        int i = 0;
        while (i < split.length && i < this.zztf) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcH.write(this.zzth.zzz(split[i]));
                } catch (Throwable e) {
                    zzb.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzcH.toString();
    }

    String zzB(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcH = zzcH();
        PriorityQueue priorityQueue = new PriorityQueue(this.zztf, new C02742(this));
        for (String zzD : split) {
            String[] zzD2 = zzbo.zzD(zzD);
            if (zzD2.length >= this.zzte) {
                zzbq.zza(zzD2, this.zztf, this.zzte, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzcH.write(this.zzth.zzz(((com.google.android.gms.internal.zzbq.zza) it.next()).zztm));
            } catch (Throwable e) {
                zzb.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzcH.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zztg) {
            case 0:
                return zzB(stringBuffer.toString());
            case 1:
                return zzA(stringBuffer.toString());
            default:
                return "";
        }
    }

    zza zzcH() {
        return new zza();
    }
}
