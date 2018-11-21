package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzIx;
    private final ArrayList<AppContentConditionEntity> zzaAQ;
    private final String zzaAR;
    private final ArrayList<AppContentAnnotationEntity> zzaBa;
    private final int zzaBb;
    private final String zzaBc;
    private final int zzaBd;
    private final String zzank;
    private final String zzavc;
    private final String zzxX;

    AppContentCardEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentAnnotationEntity> annotations, ArrayList<AppContentConditionEntity> conditions, String contentDescription, int currentProgress, String description, Bundle extras, String subtitle, String title, int totalProgress, String type, String id) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaBa = annotations;
        this.zzaAQ = conditions;
        this.zzaAR = contentDescription;
        this.zzaBb = currentProgress;
        this.zzavc = description;
        this.mExtras = extras;
        this.zzxX = id;
        this.zzaBc = subtitle;
        this.zzank = title;
        this.zzaBd = totalProgress;
        this.zzIx = type;
    }

    public AppContentCardEntity(AppContentCard card) {
        int i;
        int i2 = 0;
        this.mVersionCode = 4;
        this.zzaAR = card.zzvk();
        this.zzaBb = card.zzvv();
        this.zzavc = card.getDescription();
        this.mExtras = card.getExtras();
        this.zzxX = card.getId();
        this.zzank = card.getTitle();
        this.zzaBc = card.zzvw();
        this.zzaBd = card.zzvx();
        this.zzIx = card.getType();
        List actions = card.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = card.zzvu();
        size = actions.size();
        this.zzaBa = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaBa.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zzvj = card.zzvj();
        int size2 = zzvj.size();
        this.zzaAQ = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaAQ.add((AppContentConditionEntity) ((AppContentCondition) zzvj.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzvu(), appContentCard.zzvj(), appContentCard.zzvk(), Integer.valueOf(appContentCard.zzvv()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzvw(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzvx()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zzvu(), appContentCard.zzvu()) && zzw.equal(appContentCard2.zzvj(), appContentCard.zzvj()) && zzw.equal(appContentCard2.zzvk(), appContentCard.zzvk()) && zzw.equal(Integer.valueOf(appContentCard2.zzvv()), Integer.valueOf(appContentCard.zzvv())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zzvw(), appContentCard.zzvw()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzvx()), Integer.valueOf(appContentCard.zzvx())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzx(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzvu()).zzg("Conditions", appContentCard.zzvj()).zzg("ContentDescription", appContentCard.zzvk()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzvv())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzvw()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzvx())).zzg("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvy();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzavc;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzxX;
    }

    public String getTitle() {
        return this.zzank;
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
        AppContentCardEntityCreator.zza(this, out, flags);
    }

    public List<AppContentCondition> zzvj() {
        return new ArrayList(this.zzaAQ);
    }

    public String zzvk() {
        return this.zzaAR;
    }

    public List<AppContentAnnotation> zzvu() {
        return new ArrayList(this.zzaBa);
    }

    public int zzvv() {
        return this.zzaBb;
    }

    public String zzvw() {
        return this.zzaBc;
    }

    public int zzvx() {
        return this.zzaBd;
    }

    public AppContentCard zzvy() {
        return this;
    }
}
