package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgb.zza;
import com.google.android.gms.internal.zzha;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzha
public class zzd extends zza {
    private Context mContext;
    private String zzEH;
    private ArrayList<String> zzEI;
    private String zzrD;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzEH = str;
        this.zzEI = arrayList;
        this.zzrD = str2;
        this.mContext = context;
    }

    public String getProductId() {
        return this.zzEH;
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        if (billingResponseCode == 0) {
            zzfK();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(billingResponseCode));
        hashMap.put("sku", this.zzEH);
        hashMap.put("status", String.valueOf(zzB(billingResponseCode)));
        List linkedList = new LinkedList();
        Iterator it = this.zzEI.iterator();
        while (it.hasNext()) {
            linkedList.add(zza((String) it.next(), hashMap));
        }
        zzp.zzbx().zza(this.mContext, this.zzrD, linkedList);
    }

    public void recordResolution(int resolution) {
        if (resolution == 1) {
            zzfK();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(resolution));
        hashMap.put("sku", this.zzEH);
        List linkedList = new LinkedList();
        Iterator it = this.zzEI.iterator();
        while (it.hasNext()) {
            linkedList.add(zza((String) it.next(), hashMap));
        }
        zzp.zzbx().zza(this.mContext, this.zzrD, linkedList);
    }

    protected int zzB(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    protected String zza(String str, HashMap<String, String> hashMap) {
        Object obj;
        Object obj2 = "";
        try {
            obj = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            zzb.zzd("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzp.zzbA().zzgL().zzgV();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{zzp.zzbA().getSessionId()})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{r2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.zzrD})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    void zzfK() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.zzEH, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            zzb.zzaH("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzb.zzaH("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            zzb.zzd("Fail to report a conversion.", e3);
        }
    }
}
