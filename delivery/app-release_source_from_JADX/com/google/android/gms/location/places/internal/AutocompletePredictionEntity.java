package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePrediction.Substring;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Creator<AutocompletePredictionEntity> CREATOR = new zza();
    private static final List<SubstringEntity> zzaNj = Collections.emptyList();
    final int mVersionCode;
    final String zzaMO;
    final List<Integer> zzaMp;
    final String zzaNk;
    final List<SubstringEntity> zzaNl;
    final int zzaNm;
    final String zzaNn;
    final List<SubstringEntity> zzaNo;
    final String zzaNp;
    final List<SubstringEntity> zzaNq;

    public static class SubstringEntity implements SafeParcelable, Substring {
        public static final Creator<SubstringEntity> CREATOR = new zzv();
        final int mLength;
        final int mOffset;
        final int mVersionCode;

        public SubstringEntity(int versionCode, int offset, int length) {
            this.mVersionCode = versionCode;
            this.mOffset = offset;
            this.mLength = length;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) object;
            return zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(substringEntity.mOffset)) && zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(substringEntity.mLength));
        }

        public int getLength() {
            return this.mLength;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength));
        }

        public String toString() {
            return zzw.zzx(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzv.zza(this, parcel, flags);
        }
    }

    AutocompletePredictionEntity(int versionCode, String placeId, List<Integer> placeTypes, int personalizationType, String fullText, List<SubstringEntity> fullTextMatchedSubstrings, String primaryText, List<SubstringEntity> primaryTextMatchedSubstrings, String secondaryText, List<SubstringEntity> secondaryTextMatchedSubstrings) {
        this.mVersionCode = versionCode;
        this.zzaMO = placeId;
        this.zzaMp = placeTypes;
        this.zzaNm = personalizationType;
        this.zzaNk = fullText;
        this.zzaNl = fullTextMatchedSubstrings;
        this.zzaNn = primaryText;
        this.zzaNo = primaryTextMatchedSubstrings;
        this.zzaNp = secondaryText;
        this.zzaNq = secondaryTextMatchedSubstrings;
    }

    public static AutocompletePredictionEntity zza(String str, List<Integer> list, int i, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        return new AutocompletePredictionEntity(0, str, list, i, (String) zzx.zzy(str2), list2, str3, list3, str4, list4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) object;
        return zzw.equal(this.zzaMO, autocompletePredictionEntity.zzaMO) && zzw.equal(this.zzaMp, autocompletePredictionEntity.zzaMp) && zzw.equal(Integer.valueOf(this.zzaNm), Integer.valueOf(autocompletePredictionEntity.zzaNm)) && zzw.equal(this.zzaNk, autocompletePredictionEntity.zzaNk) && zzw.equal(this.zzaNl, autocompletePredictionEntity.zzaNl) && zzw.equal(this.zzaNn, autocompletePredictionEntity.zzaNn) && zzw.equal(this.zzaNo, autocompletePredictionEntity.zzaNo) && zzw.equal(this.zzaNp, autocompletePredictionEntity.zzaNp) && zzw.equal(this.zzaNq, autocompletePredictionEntity.zzaNq);
    }

    public /* synthetic */ Object freeze() {
        return zzyt();
    }

    public String getDescription() {
        return this.zzaNk;
    }

    public CharSequence getFullText(CharacterStyle matchStyle) {
        return zzc.zza(this.zzaNk, this.zzaNl, matchStyle);
    }

    public List<? extends Substring> getMatchedSubstrings() {
        return this.zzaNl;
    }

    public String getPlaceId() {
        return this.zzaMO;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaMp;
    }

    public CharSequence getPrimaryText(CharacterStyle matchStyle) {
        return zzc.zza(this.zzaNn, this.zzaNo, matchStyle);
    }

    public CharSequence getSecondaryText(CharacterStyle matchStyle) {
        return zzc.zza(this.zzaNp, this.zzaNq, matchStyle);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMO, this.zzaMp, Integer.valueOf(this.zzaNm), this.zzaNk, this.zzaNl, this.zzaNn, this.zzaNo, this.zzaNp, this.zzaNq);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzx(this).zzg("placeId", this.zzaMO).zzg("placeTypes", this.zzaMp).zzg("fullText", this.zzaNk).zzg("fullTextMatchedSubstrings", this.zzaNl).zzg("primaryText", this.zzaNn).zzg("primaryTextMatchedSubstrings", this.zzaNo).zzg("secondaryText", this.zzaNp).zzg("secondaryTextMatchedSubstrings", this.zzaNq).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public AutocompletePrediction zzyt() {
        return this;
    }
}
