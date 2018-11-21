package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzha;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzha
public final class zzy {
    public static final String DEVICE_ID_EMULATOR = zzl.zzcN().zzaE("emulator");
    private final Date zzaW;
    private final Set<String> zzaY;
    private final Location zzba;
    private final boolean zzpt;
    private final int zztH;
    private final int zztK;
    private final String zztL;
    private final String zztN;
    private final Bundle zztP;
    private final String zztR;
    private final boolean zztT;
    private final Bundle zzul;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzum;
    private final SearchAdRequest zzun;
    private final Set<String> zzuo;
    private final Set<String> zzup;

    public static final class zza {
        private Date zzaW;
        private Location zzba;
        private boolean zzpt = false;
        private int zztH = -1;
        private int zztK = -1;
        private String zztL;
        private String zztN;
        private final Bundle zztP = new Bundle();
        private String zztR;
        private boolean zztT;
        private final Bundle zzul = new Bundle();
        private final HashSet<String> zzuq = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzur = new HashMap();
        private final HashSet<String> zzus = new HashSet();
        private final HashSet<String> zzut = new HashSet();

        public void setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.zzpt = manualImpressionsEnabled;
        }

        public void zzF(String str) {
            this.zzuq.add(str);
        }

        public void zzG(String str) {
            this.zzus.add(str);
        }

        public void zzH(String str) {
            this.zzus.remove(str);
        }

        public void zzI(String str) {
            this.zztN = str;
        }

        public void zzJ(String str) {
            this.zztL = str;
        }

        public void zzK(String str) {
            this.zztR = str;
        }

        public void zzL(String str) {
            this.zzut.add(str);
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.zzur.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzul.putBundle(cls.getName(), bundle);
        }

        public void zza(Date date) {
            this.zzaW = date;
        }

        public void zzb(Location location) {
            this.zzba = location;
        }

        public void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.zzul.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.zzul.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.zzul.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void zzb(String str, String str2) {
            this.zztP.putString(str, str2);
        }

        public void zzk(boolean z) {
            this.zztK = z ? 1 : 0;
        }

        public void zzl(boolean z) {
            this.zztT = z;
        }

        public void zzn(int i) {
            this.zztH = i;
        }
    }

    public zzy(zza com_google_android_gms_ads_internal_client_zzy_zza) {
        this(com_google_android_gms_ads_internal_client_zzy_zza, null);
    }

    public zzy(zza com_google_android_gms_ads_internal_client_zzy_zza, SearchAdRequest searchAdRequest) {
        this.zzaW = com_google_android_gms_ads_internal_client_zzy_zza.zzaW;
        this.zztN = com_google_android_gms_ads_internal_client_zzy_zza.zztN;
        this.zztH = com_google_android_gms_ads_internal_client_zzy_zza.zztH;
        this.zzaY = Collections.unmodifiableSet(com_google_android_gms_ads_internal_client_zzy_zza.zzuq);
        this.zzba = com_google_android_gms_ads_internal_client_zzy_zza.zzba;
        this.zzpt = com_google_android_gms_ads_internal_client_zzy_zza.zzpt;
        this.zzul = com_google_android_gms_ads_internal_client_zzy_zza.zzul;
        this.zzum = Collections.unmodifiableMap(com_google_android_gms_ads_internal_client_zzy_zza.zzur);
        this.zztL = com_google_android_gms_ads_internal_client_zzy_zza.zztL;
        this.zztR = com_google_android_gms_ads_internal_client_zzy_zza.zztR;
        this.zzun = searchAdRequest;
        this.zztK = com_google_android_gms_ads_internal_client_zzy_zza.zztK;
        this.zzuo = Collections.unmodifiableSet(com_google_android_gms_ads_internal_client_zzy_zza.zzus);
        this.zztP = com_google_android_gms_ads_internal_client_zzy_zza.zztP;
        this.zzup = Collections.unmodifiableSet(com_google_android_gms_ads_internal_client_zzy_zza.zzut);
        this.zztT = com_google_android_gms_ads_internal_client_zzy_zza.zztT;
    }

    public Date getBirthday() {
        return this.zzaW;
    }

    public String getContentUrl() {
        return this.zztN;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.zzul.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(adapterClass.getClass().getName()) : null;
    }

    public Bundle getCustomTargeting() {
        return this.zztP;
    }

    public int getGender() {
        return this.zztH;
    }

    public Set<String> getKeywords() {
        return this.zzaY;
    }

    public Location getLocation() {
        return this.zzba;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzpt;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.zzum.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.zzul.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.zztL;
    }

    public boolean isDesignedForFamilies() {
        return this.zztT;
    }

    public boolean isTestDevice(Context context) {
        return this.zzuo.contains(zzl.zzcN().zzS(context));
    }

    public String zzcT() {
        return this.zztR;
    }

    public SearchAdRequest zzcU() {
        return this.zzun;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> zzcV() {
        return this.zzum;
    }

    public Bundle zzcW() {
        return this.zzul;
    }

    public int zzcX() {
        return this.zztK;
    }

    public Set<String> zzcY() {
        return this.zzup;
    }
}
