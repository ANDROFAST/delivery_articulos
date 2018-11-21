package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int mVersionCode;
    private final String zzaBe;
    private final String zzaBf;
    private final String zzaBg;
    private final Bundle zzaBh;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.mVersionCode = versionCode;
        this.zzaBe = defaultValue;
        this.zzaBf = expectedValue;
        this.zzaBg = predicate;
        this.zzaBh = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.mVersionCode = 1;
        this.zzaBe = condition.zzvz();
        this.zzaBf = condition.zzvA();
        this.zzaBg = condition.zzvB();
        this.zzaBh = condition.zzvC();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zzvz(), appContentCondition.zzvA(), appContentCondition.zzvB(), appContentCondition.zzvC());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.equal(appContentCondition2.zzvz(), appContentCondition.zzvz()) && zzw.equal(appContentCondition2.zzvA(), appContentCondition.zzvA()) && zzw.equal(appContentCondition2.zzvB(), appContentCondition.zzvB()) && zzw.equal(appContentCondition2.zzvC(), appContentCondition.zzvC());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzx(appContentCondition).zzg("DefaultValue", appContentCondition.zzvz()).zzg("ExpectedValue", appContentCondition.zzvA()).zzg("Predicate", appContentCondition.zzvB()).zzg("PredicateParameters", appContentCondition.zzvC()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvD();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentConditionEntityCreator.zza(this, out, flags);
    }

    public String zzvA() {
        return this.zzaBf;
    }

    public String zzvB() {
        return this.zzaBg;
    }

    public Bundle zzvC() {
        return this.zzaBh;
    }

    public AppContentCondition zzvD() {
        return this;
    }

    public String zzvz() {
        return this.zzaBe;
    }
}
