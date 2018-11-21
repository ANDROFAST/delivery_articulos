package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzqk extends zze<zzqk> {
    private ProductAction zzNT;
    private final Map<String, List<Product>> zzNU = new HashMap();
    private final List<Promotion> zzNV = new ArrayList();
    private final List<Product> zzNW = new ArrayList();

    public String toString() {
        Map hashMap = new HashMap();
        if (!this.zzNW.isEmpty()) {
            hashMap.put("products", this.zzNW);
        }
        if (!this.zzNV.isEmpty()) {
            hashMap.put("promotions", this.zzNV);
        }
        if (!this.zzNU.isEmpty()) {
            hashMap.put("impressions", this.zzNU);
        }
        hashMap.put("productAction", this.zzNT);
        return zze.zzE(hashMap);
    }

    public ProductAction zzAf() {
        return this.zzNT;
    }

    public List<Product> zzAg() {
        return Collections.unmodifiableList(this.zzNW);
    }

    public Map<String, List<Product>> zzAh() {
        return this.zzNU;
    }

    public List<Promotion> zzAi() {
        return Collections.unmodifiableList(this.zzNV);
    }

    public void zza(Product product, String str) {
        if (product != null) {
            Object obj;
            if (str == null) {
                obj = "";
            }
            if (!this.zzNU.containsKey(obj)) {
                this.zzNU.put(obj, new ArrayList());
            }
            ((List) this.zzNU.get(obj)).add(product);
        }
    }

    public void zza(zzqk com_google_android_gms_internal_zzqk) {
        com_google_android_gms_internal_zzqk.zzNW.addAll(this.zzNW);
        com_google_android_gms_internal_zzqk.zzNV.addAll(this.zzNV);
        for (Entry entry : this.zzNU.entrySet()) {
            String str = (String) entry.getKey();
            for (Product zza : (List) entry.getValue()) {
                com_google_android_gms_internal_zzqk.zza(zza, str);
            }
        }
        if (this.zzNT != null) {
            com_google_android_gms_internal_zzqk.zzNT = this.zzNT;
        }
    }
}
