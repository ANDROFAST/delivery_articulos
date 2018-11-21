package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsh.zzc;
import com.google.android.gms.internal.zzsh.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context mContext;
    private final String zzbcF;
    private final DataLayer zzbcG;
    private zzcp zzbcH;
    private Map<String, FunctionCallMacroCallback> zzbcI = new HashMap();
    private Map<String, FunctionCallTagCallback> zzbcJ = new HashMap();
    private volatile long zzbcK;
    private volatile String zzbcL = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements com.google.android.gms.tagmanager.zzt.zza {
        final /* synthetic */ Container zzbcM;

        private zza(Container container) {
            this.zzbcM = container;
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzfb = this.zzbcM.zzfb(str);
            return zzfb == null ? null : zzfb.getValue(str, map);
        }
    }

    private class zzb implements com.google.android.gms.tagmanager.zzt.zza {
        final /* synthetic */ Container zzbcM;

        private zzb(Container container) {
            this.zzbcM = container;
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzfc = this.zzbcM.zzfc(str);
            if (zzfc != null) {
                zzfc.execute(str, map);
            }
            return zzdf.zzFI();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzj resource) {
        this.mContext = context;
        this.zzbcG = dataLayer;
        this.zzbcF = containerId;
        this.zzbcK = lastRefreshTime;
        zza(resource.zzjl);
        if (resource.zzjk != null) {
            zza(resource.zzjk);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzc resource) {
        this.mContext = context;
        this.zzbcG = dataLayer;
        this.zzbcF = containerId;
        this.zzbcK = lastRefreshTime;
        zza(resource);
    }

    private synchronized zzcp zzEg() {
        return this.zzbcH;
    }

    private void zza(zzf com_google_android_gms_internal_zzaf_zzf) {
        if (com_google_android_gms_internal_zzaf_zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzsh.zzb(com_google_android_gms_internal_zzaf_zzf));
        } catch (zzg e) {
            zzbg.m9e("Not loading resource: " + com_google_android_gms_internal_zzaf_zzf + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzc com_google_android_gms_internal_zzsh_zzc) {
        this.zzbcL = com_google_android_gms_internal_zzsh_zzc.getVersion();
        zzc com_google_android_gms_internal_zzsh_zzc2 = com_google_android_gms_internal_zzsh_zzc;
        zza(new zzcp(this.mContext, com_google_android_gms_internal_zzsh_zzc2, this.zzbcG, new zza(), new zzb(), zzfe(this.zzbcL)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzbcG.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzbcF));
        }
    }

    private synchronized void zza(zzcp com_google_android_gms_tagmanager_zzcp) {
        this.zzbcH = com_google_android_gms_tagmanager_zzcp;
    }

    private void zza(zzi[] com_google_android_gms_internal_zzaf_zziArr) {
        List arrayList = new ArrayList();
        for (Object add : com_google_android_gms_internal_zzaf_zziArr) {
            arrayList.add(add);
        }
        zzEg().zzC(arrayList);
    }

    public boolean getBoolean(String key) {
        zzcp zzEg = zzEg();
        if (zzEg == null) {
            zzbg.m9e("getBoolean called for closed container.");
            return zzdf.zzFG().booleanValue();
        }
        try {
            return zzdf.zzk((com.google.android.gms.internal.zzag.zza) zzEg.zzfz(key).getObject()).booleanValue();
        } catch (Exception e) {
            zzbg.m9e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzFG().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzbcF;
    }

    public double getDouble(String key) {
        zzcp zzEg = zzEg();
        if (zzEg == null) {
            zzbg.m9e("getDouble called for closed container.");
            return zzdf.zzFF().doubleValue();
        }
        try {
            return zzdf.zzj((com.google.android.gms.internal.zzag.zza) zzEg.zzfz(key).getObject()).doubleValue();
        } catch (Exception e) {
            zzbg.m9e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzFF().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzbcK;
    }

    public long getLong(String key) {
        zzcp zzEg = zzEg();
        if (zzEg == null) {
            zzbg.m9e("getLong called for closed container.");
            return zzdf.zzFE().longValue();
        }
        try {
            return zzdf.zzi((com.google.android.gms.internal.zzag.zza) zzEg.zzfz(key).getObject()).longValue();
        } catch (Exception e) {
            zzbg.m9e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzFE().longValue();
        }
    }

    public String getString(String key) {
        zzcp zzEg = zzEg();
        if (zzEg == null) {
            zzbg.m9e("getString called for closed container.");
            return zzdf.zzFI();
        }
        try {
            return zzdf.zzg((com.google.android.gms.internal.zzag.zza) zzEg.zzfz(key).getObject());
        } catch (Exception e) {
            zzbg.m9e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzFI();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzbcI) {
            this.zzbcI.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzbcJ) {
            this.zzbcJ.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.zzbcH = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.zzbcI) {
            this.zzbcI.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.zzbcJ) {
            this.zzbcJ.remove(customTagName);
        }
    }

    public String zzEf() {
        return this.zzbcL;
    }

    FunctionCallMacroCallback zzfb(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzbcI) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzbcI.get(str);
        }
        return functionCallMacroCallback;
    }

    public FunctionCallTagCallback zzfc(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzbcJ) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzbcJ.get(str);
        }
        return functionCallTagCallback;
    }

    public void zzfd(String str) {
        zzEg().zzfd(str);
    }

    zzah zzfe(String str) {
        if (zzcb.zzEY().zzEZ().equals(zza.CONTAINER_DEBUG)) {
        }
        return new zzbo();
    }
}
