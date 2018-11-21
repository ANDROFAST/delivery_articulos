package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzIx;
    private final ArrayList<AppContentConditionEntity> zzaAQ;
    private final String zzaAR;
    private final AppContentAnnotationEntity zzaAS;
    private final String zzaAT;
    private final String zzxX;

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String type, String id, AppContentAnnotationEntity annotation, String overflowText) {
        this.mVersionCode = versionCode;
        this.zzaAS = annotation;
        this.zzaAQ = conditions;
        this.zzaAR = contentDescription;
        this.mExtras = extras;
        this.zzxX = id;
        this.zzaAT = overflowText;
        this.zzIx = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.mVersionCode = 5;
        this.zzaAS = (AppContentAnnotationEntity) action.zzvi().freeze();
        this.zzaAR = action.zzvk();
        this.mExtras = action.getExtras();
        this.zzxX = action.getId();
        this.zzaAT = action.zzvl();
        this.zzIx = action.getType();
        List zzvj = action.zzvj();
        int size = zzvj.size();
        this.zzaAQ = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaAQ.add((AppContentConditionEntity) ((AppContentCondition) zzvj.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzw.hashCode(appContentAction.zzvi(), appContentAction.zzvj(), appContentAction.zzvk(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzvl(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.equal(appContentAction2.zzvi(), appContentAction.zzvi()) && zzw.equal(appContentAction2.zzvj(), appContentAction.zzvj()) && zzw.equal(appContentAction2.zzvk(), appContentAction.zzvk()) && zzw.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzw.equal(appContentAction2.getId(), appContentAction.getId()) && zzw.equal(appContentAction2.zzvl(), appContentAction.zzvl()) && zzw.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzw.zzx(appContentAction).zzg("Annotation", appContentAction.zzvi()).zzg("Conditions", appContentAction.zzvj()).zzg("ContentDescription", appContentAction.zzvk()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zzvl()).zzg("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvm();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzxX;
    }

    public String getType() {
        return this.zzIx;
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
        AppContentActionEntityCreator.zza(this, out, flags);
    }

    public AppContentAnnotation zzvi() {
        return this.zzaAS;
    }

    public List<AppContentCondition> zzvj() {
        return new ArrayList(this.zzaAQ);
    }

    public String zzvk() {
        return this.zzaAR;
    }

    public String zzvl() {
        return this.zzaAT;
    }

    public AppContentAction zzvm() {
        return this;
    }
}
