package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzaW;
    private final Gender zzaX;
    private final Set<String> zzaY;
    private final boolean zzaZ;
    private final Location zzba;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.zzaW = birthday;
        this.zzaX = gender;
        this.zzaY = keywords;
        this.zzaZ = isTesting;
        this.zzba = location;
    }

    public Integer getAgeInYears() {
        if (this.zzaW == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzaW);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzaW;
    }

    public Gender getGender() {
        return this.zzaX;
    }

    public Set<String> getKeywords() {
        return this.zzaY;
    }

    public Location getLocation() {
        return this.zzba;
    }

    public boolean isTesting() {
        return this.zzaZ;
    }
}
