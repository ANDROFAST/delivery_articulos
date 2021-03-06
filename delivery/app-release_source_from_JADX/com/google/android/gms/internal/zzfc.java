package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzha
public final class zzfc implements MediationAdRequest {
    private final int zzBH;
    private final Date zzaW;
    private final Set<String> zzaY;
    private final boolean zzaZ;
    private final Location zzba;
    private final int zztH;
    private final boolean zztT;

    public zzfc(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.zzaW = date;
        this.zztH = i;
        this.zzaY = set;
        this.zzba = location;
        this.zzaZ = z;
        this.zzBH = i2;
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
