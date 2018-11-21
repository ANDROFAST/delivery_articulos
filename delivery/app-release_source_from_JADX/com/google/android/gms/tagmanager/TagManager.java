package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzbgg;
    private final Context mContext;
    private final DataLayer zzbcG;
    private final zzs zzbfa;
    private final zza zzbgd;
    private final zzct zzbge;
    private final ConcurrentMap<zzo, Boolean> zzbgf;

    class C04163 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager zzbgh;

        C04163(TagManager tagManager) {
            this.zzbgh = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzbgh.dispatch();
            }
        }
    }

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs);
    }

    class C07831 implements zzb {
        final /* synthetic */ TagManager zzbgh;

        C07831(TagManager tagManager) {
            this.zzbgh = tagManager;
        }

        public void zzJ(Map<String, Object> map) {
            Object obj = map.get("event");
            if (obj != null) {
                this.zzbgh.zzfB(obj.toString());
            }
        }
    }

    static class C07842 implements zza {
        C07842() {
        }

        public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
            return new zzp(context, tagManager, looper, str, i, com_google_android_gms_tagmanager_zzs);
        }
    }

    TagManager(Context context, zza containerHolderLoaderProvider, DataLayer dataLayer, zzct serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzbge = serviceManager;
        this.zzbgd = containerHolderLoaderProvider;
        this.zzbgf = new ConcurrentHashMap();
        this.zzbcG = dataLayer;
        this.zzbcG.zza(new C07831(this));
        this.zzbcG.zza(new zzd(this.mContext));
        this.zzbfa = new zzs();
        zzFx();
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzbgg == null) {
                if (context == null) {
                    zzbg.m9e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzbgg = new TagManager(context, new C07842(), new DataLayer(new zzw(context)), zzcu.zzFs());
            }
            tagManager = zzbgg;
        }
        return tagManager;
    }

    private void zzFx() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C04163(this));
        }
    }

    private void zzfB(String str) {
        for (zzo zzfd : this.zzbgf.keySet()) {
            zzfd.zzfd(str);
        }
    }

    public void dispatch() {
        this.zzbge.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzbcG;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzbgd.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzbfa);
        zza.zzEk();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzbgd.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzbfa);
        zza.zzEk();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzbgd.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzbfa);
        zza.zzEm();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzbgd.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzbfa);
        zza.zzEm();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzbgd.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzbfa);
        zza.zzEl();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzbgd.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzbfa);
        zza.zzEl();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        zzbg.setLogLevel(enableVerboseLogging ? 2 : 5);
    }

    public void zza(zzo com_google_android_gms_tagmanager_zzo) {
        this.zzbgf.put(com_google_android_gms_tagmanager_zzo, Boolean.valueOf(true));
    }

    public boolean zzb(zzo com_google_android_gms_tagmanager_zzo) {
        return this.zzbgf.remove(com_google_android_gms_tagmanager_zzo) != null;
    }

    synchronized boolean zzp(Uri uri) {
        boolean z;
        zzcb zzEY = zzcb.zzEY();
        if (zzEY.zzp(uri)) {
            String containerId = zzEY.getContainerId();
            switch (zzEY.zzEZ()) {
                case NONE:
                    for (zzo com_google_android_gms_tagmanager_zzo : this.zzbgf.keySet()) {
                        if (com_google_android_gms_tagmanager_zzo.getContainerId().equals(containerId)) {
                            com_google_android_gms_tagmanager_zzo.zzff(null);
                            com_google_android_gms_tagmanager_zzo.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo com_google_android_gms_tagmanager_zzo2 : this.zzbgf.keySet()) {
                        if (com_google_android_gms_tagmanager_zzo2.getContainerId().equals(containerId)) {
                            com_google_android_gms_tagmanager_zzo2.zzff(zzEY.zzFa());
                            com_google_android_gms_tagmanager_zzo2.refresh();
                        } else if (com_google_android_gms_tagmanager_zzo2.zzEh() != null) {
                            com_google_android_gms_tagmanager_zzo2.zzff(null);
                            com_google_android_gms_tagmanager_zzo2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
