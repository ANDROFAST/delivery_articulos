package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private Image zzMU;
    private String zzxA;
    private String zzxC;
    private double zzxD;
    private String zzxE;
    private String zzxF;
    private String zzxy;
    private List<Image> zzxz;

    public final String getBody() {
        return this.zzxA;
    }

    public final String getCallToAction() {
        return this.zzxC;
    }

    public final String getHeadline() {
        return this.zzxy;
    }

    public final Image getIcon() {
        return this.zzMU;
    }

    public final List<Image> getImages() {
        return this.zzxz;
    }

    public final String getPrice() {
        return this.zzxF;
    }

    public final double getStarRating() {
        return this.zzxD;
    }

    public final String getStore() {
        return this.zzxE;
    }

    public final void setBody(String body) {
        this.zzxA = body;
    }

    public final void setCallToAction(String callToAction) {
        this.zzxC = callToAction;
    }

    public final void setHeadline(String headline) {
        this.zzxy = headline;
    }

    public final void setIcon(Image icon) {
        this.zzMU = icon;
    }

    public final void setImages(List<Image> images) {
        this.zzxz = images;
    }

    public final void setPrice(String price) {
        this.zzxF = price;
    }

    public final void setStarRating(double starRating) {
        this.zzxD = starRating;
    }

    public final void setStore(String store) {
        this.zzxE = store;
    }
}
