package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzha
public final class zzfh implements NativeMediationAdRequest {
    private final int zzBH;
    private final Date zzaW;
    private final Set<String> zzaY;
    private final boolean zzaZ;
    private final Location zzba;
    private final NativeAdOptionsParcel zzpE;
    private final List<String> zzpF;
    private final int zztH;
    private final boolean zztT;

    public zzfh(Date date, int i, Set<String> set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.zzaW = date;
        this.zztH = i;
        this.zzaY = set;
        this.zzba = location;
        this.zzaZ = z;
        this.zzBH = i2;
        this.zzpE = nativeAdOptionsParcel;
        this.zzpF = list;
        this.zztT = z2;
    }

    public Date getBirthday() {
        return this.zzaW;
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

    public NativeAdOptions getNativeAdOptions() {
        return this.zzpE == null ? null : new Builder().setReturnUrlsForImageAssets(this.zzpE.zzyc).setImageOrientation(this.zzpE.zzyd).setRequestMultipleImages(this.zzpE.zzye).build();
    }

    public boolean isAppInstallAdRequested() {
        return this.zzpF != null && this.zzpF.contains("2");
    }

    public boolean isContentAdRequested() {
        return this.zzpF != null && this.zzpF.contains("1");
    }

    public boolean isDesignedForFamilies() {
        return this.zztT;
    }

    public boolean isTesting() {
        return this.zzaZ;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzBH;
    }
}
