package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzNd;
    private final int zzNe;
    private final int zzNf;
    private final int zzNg;
    private final int zzNh;
    private final int zzNi;
    private final int zzNj;
    private final String zzNk;
    private final int zzNl;
    private final String zzNm;
    private final int zzNn;
    private final int zzNo;
    private final String zzNp;
    private final zzy zzot;
    private final int zzxq;

    public static final class Builder {
        private int zzNd;
        private int zzNe;
        private int zzNf;
        private int zzNg;
        private int zzNh;
        private int zzNi = 0;
        private int zzNj;
        private String zzNk;
        private int zzNl;
        private String zzNm;
        private int zzNn;
        private int zzNo;
        private String zzNp;
        private final zza zzou = new zza();
        private int zzxq;

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zzou.zzb((Class) adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzou.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.zzou.zza(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.zzou.zzG(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.zzNd = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.zzxq = backgroundColor;
            this.zzNe = Color.argb(0, 0, 0, 0);
            this.zzNf = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.zzxq = Color.argb(0, 0, 0, 0);
            this.zzNe = bottom;
            this.zzNf = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.zzNg = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.zzNh = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.zzNi = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.zzNj = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.zzNk = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.zzNl = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.zzNm = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.zzNn = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.zzNo = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzou.zzb(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.zzNp = query;
            return this;
        }

        public Builder setRequestAgent(String requestAgent) {
            this.zzou.zzK(requestAgent);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.zzou.zzk(tagForChildDirectedTreatment);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.zzNd = builder.zzNd;
        this.zzxq = builder.zzxq;
        this.zzNe = builder.zzNe;
        this.zzNf = builder.zzNf;
        this.zzNg = builder.zzNg;
        this.zzNh = builder.zzNh;
        this.zzNi = builder.zzNi;
        this.zzNj = builder.zzNj;
        this.zzNk = builder.zzNk;
        this.zzNl = builder.zzNl;
        this.zzNm = builder.zzNm;
        this.zzNn = builder.zzNn;
        this.zzNo = builder.zzNo;
        this.zzNp = builder.zzNp;
        this.zzot = new zzy(builder.zzou, this);
    }

    public int getAnchorTextColor() {
        return this.zzNd;
    }

    public int getBackgroundColor() {
        return this.zzxq;
    }

    public int getBackgroundGradientBottom() {
        return this.zzNe;
    }

    public int getBackgroundGradientTop() {
        return this.zzNf;
    }

    public int getBorderColor() {
        return this.zzNg;
    }

    public int getBorderThickness() {
        return this.zzNh;
    }

    public int getBorderType() {
        return this.zzNi;
    }

    public int getCallButtonColor() {
        return this.zzNj;
    }

    public String getCustomChannels() {
        return this.zzNk;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zzot.getCustomEventExtrasBundle(adapterClass);
    }

    public int getDescriptionTextColor() {
        return this.zzNl;
    }

    public String getFontFace() {
        return this.zzNm;
    }

    public int getHeaderTextColor() {
        return this.zzNn;
    }

    public int getHeaderTextSize() {
        return this.zzNo;
    }

    public Location getLocation() {
        return this.zzot.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.zzot.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zzot.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.zzNp;
    }

    public boolean isTestDevice(Context context) {
        return this.zzot.isTestDevice(context);
    }

    zzy zzaG() {
        return this.zzot;
    }
}
