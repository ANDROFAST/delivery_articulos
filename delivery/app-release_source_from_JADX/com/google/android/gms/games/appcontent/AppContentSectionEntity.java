package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzIx;
    private final String zzaAR;
    private final ArrayList<AppContentAnnotationEntity> zzaBa;
    private final String zzaBc;
    private final ArrayList<AppContentCardEntity> zzaBj;
    private final String zzaBk;
    private final String zzank;
    private final String zzxX;

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaBa = annotations;
        this.zzaBj = cards;
        this.zzaBk = cardType;
        this.zzaAR = contentDescription;
        this.mExtras = extras;
        this.zzxX = id;
        this.zzaBc = subtitle;
        this.zzank = title;
        this.zzIx = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        int i;
        int i2 = 0;
        this.mVersionCode = 5;
        this.zzaBk = section.zzvF();
        this.zzaAR = section.zzvk();
        this.mExtras = section.getExtras();
        this.zzxX = section.getId();
        this.zzaBc = section.zzvw();
        this.zzank = section.getTitle();
        this.zzIx = section.getType();
        List actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = section.zzvE();
        size = actions.size();
        this.zzaBj = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaBj.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zzvu = section.zzvu();
        int size2 = zzvu.size();
        this.zzaBa = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaBa.add((AppContentAnnotationEntity) ((AppContentAnnotation) zzvu.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zzvu(), appContentSection.zzvE(), appContentSection.zzvF(), appContentSection.zzvk(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzvw(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zzvu(), appContentSection.zzvu()) && zzw.equal(appContentSection2.zzvE(), appContentSection.zzvE()) && zzw.equal(appContentSection2.zzvF(), appContentSection.zzvF()) && zzw.equal(appContentSection2.zzvk(), appContentSection.zzvk()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zzvw(), appContentSection.zzvw()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzx(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzvu()).zzg("Cards", appContentSection.zzvE()).zzg("CardType", appContentSection.zzvF()).zzg("ContentDescription", appContentSection.zzvk()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzvw()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvG();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
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
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    public List<AppContentCard> zzvE() {
        return new ArrayList(this.zzaBj);
    }

    public String zzvF() {
        return this.zzaBk;
    }

    public AppContentSection zzvG() {
        return this;
    }

    public String zzvk() {
        return this.zzaAR;
    }

    public List<AppContentAnnotation> zzvu() {
        return new ArrayList(this.zzaBa);
    }

    public String zzvw() {
        return this.zzaBc;
    }
}
