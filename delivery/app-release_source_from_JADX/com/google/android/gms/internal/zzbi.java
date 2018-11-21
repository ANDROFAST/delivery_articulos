package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;

@zzha
public class zzbi {
    private final Object zzpK = new Object();
    private final int zzsC;
    private final int zzsD;
    private final int zzsE;
    private final zzbn zzsF;
    private ArrayList<String> zzsG = new ArrayList();
    private int zzsH = 0;
    private int zzsI = 0;
    private int zzsJ = 0;
    private int zzsK;
    private String zzsL = "";

    public zzbi(int i, int i2, int i3, int i4) {
        this.zzsC = i;
        this.zzsD = i2;
        this.zzsE = i3;
        this.zzsF = new zzbn(i4);
    }

    private String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void zzx(String str) {
        if (str != null && str.length() >= this.zzsE) {
            synchronized (this.zzpK) {
                this.zzsG.add(str);
                this.zzsH += str.length();
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbi)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzbi com_google_android_gms_internal_zzbi = (zzbi) obj;
        return com_google_android_gms_internal_zzbi.zzcu() != null && com_google_android_gms_internal_zzbi.zzcu().equals(zzcu());
    }

    public int getScore() {
        return this.zzsK;
    }

    public int hashCode() {
        return zzcu().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.zzsI + " score:" + this.zzsK + " total_length:" + this.zzsH + "\n text: " + zza(this.zzsG, 200) + "\n signture: " + this.zzsL;
    }

    int zzb(int i, int i2) {
        return (this.zzsC * i) + (this.zzsD * i2);
    }

    public boolean zzct() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzsJ == 0;
        }
        return z;
    }

    public String zzcu() {
        return this.zzsL;
    }

    public void zzcv() {
        synchronized (this.zzpK) {
            this.zzsK -= 100;
        }
    }

    public void zzcw() {
        synchronized (this.zzpK) {
            this.zzsJ--;
        }
    }

    public void zzcx() {
        synchronized (this.zzpK) {
            this.zzsJ++;
        }
    }

    public void zzcy() {
        synchronized (this.zzpK) {
            int zzb = zzb(this.zzsH, this.zzsI);
            if (zzb > this.zzsK) {
                this.zzsK = zzb;
                this.zzsL = this.zzsF.zza(this.zzsG);
            }
        }
    }

    int zzcz() {
        return this.zzsH;
    }

    public void zzh(int i) {
        this.zzsI = i;
    }

    public void zzv(String str) {
        zzx(str);
        synchronized (this.zzpK) {
            if (this.zzsJ < 0) {
                zzb.zzaF("ActivityContent: negative number of WebViews.");
            }
            zzcy();
        }
    }

    public void zzw(String str) {
        zzx(str);
    }
}
