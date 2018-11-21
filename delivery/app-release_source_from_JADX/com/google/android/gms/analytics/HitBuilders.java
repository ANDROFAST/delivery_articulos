package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzNS = new HashMap();
        ProductAction zzNT;
        Map<String, List<Product>> zzNU = new HashMap();
        List<Promotion> zzNV = new ArrayList();
        List<Product> zzNW = new ArrayList();

        protected HitBuilder() {
        }

        public T addImpression(Product product, String impressionList) {
            if (product == null) {
                zzae.zzaH("product should be non-null");
            } else {
                if (impressionList == null) {
                    impressionList = "";
                }
                if (!this.zzNU.containsKey(impressionList)) {
                    this.zzNU.put(impressionList, new ArrayList());
                }
                ((List) this.zzNU.get(impressionList)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzae.zzaH("product should be non-null");
            } else {
                this.zzNW.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzaH("promotion should be non-null");
            } else {
                this.zzNV.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzNS);
            if (this.zzNT != null) {
                hashMap.putAll(this.zzNT.build());
            }
            int i = 1;
            for (Promotion zzaX : this.zzNV) {
                hashMap.putAll(zzaX.zzaX(zzc.zzZ(i)));
                i++;
            }
            i = 1;
            for (Product zzaX2 : this.zzNW) {
                hashMap.putAll(zzaX2.zzaX(zzc.zzX(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.zzNU.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzac = zzc.zzac(i2);
                int i3 = 1;
                for (Product zzaX3 : list) {
                    hashMap.putAll(zzaX3.zzaX(zzac + zzc.zzab(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(zzac + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String paramName) {
            return (String) this.zzNS.get(paramName);
        }

        public final T set(String paramName, String paramValue) {
            if (paramName != null) {
                this.zzNS.put(paramName, paramValue);
            } else {
                zzae.zzaH(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> params) {
            if (params != null) {
                this.zzNS.putAll(new HashMap(params));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String utmParams) {
            Object zzbr = zzam.zzbr(utmParams);
            if (!TextUtils.isEmpty(zzbr)) {
                Map zzbp = zzam.zzbp(zzbr);
                set("&cc", (String) zzbp.get("utm_content"));
                set("&cm", (String) zzbp.get("utm_medium"));
                set("&cn", (String) zzbp.get("utm_campaign"));
                set("&cs", (String) zzbp.get("utm_source"));
                set("&ck", (String) zzbp.get("utm_term"));
                set("&ci", (String) zzbp.get("utm_id"));
                set("&anid", (String) zzbp.get("anid"));
                set("&gclid", (String) zzbp.get("gclid"));
                set("&dclid", (String) zzbp.get("dclid"));
                set("&aclid", (String) zzbp.get("aclid"));
                set("&gmob_t", (String) zzbp.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int index, String dimension) {
            set(zzc.zzT(index), dimension);
            return this;
        }

        public T setCustomMetric(int index, float metric) {
            set(zzc.zzV(index), Float.toString(metric));
            return this;
        }

        protected T setHitType(String hitType) {
            set("&t", hitType);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean nonInteraction) {
            set("&ni", zzam.zzK(nonInteraction));
            return this;
        }

        public T setProductAction(ProductAction action) {
            this.zzNT = action;
            return this;
        }

        public T setPromotionAction(String action) {
            this.zzNS.put("&promoa", action);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", "event");
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set("&ea", action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set("&ec", category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set("&el", label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set("&ev", Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set("&exd", description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set("&exf", zzam.zzK(fatal));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set("&iv", category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set("&in", name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set("&ip", Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set("&iq", Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set("&ic", sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set("&sa", action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set("&sn", network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set("&st", target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set("&utc", category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set("&utl", label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set("&utt", Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set("&utv", variable);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set("&ta", affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set("&tr", Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set("&ts", Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set("&tt", Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }
}
