package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
    final int mVersionCode;
    String zzF;
    String zzVu;
    String zzZe;
    final Set<Integer> zzaZA;
    String zzbaA;
    String zzbaB;
    int zzbaC;
    CoverEntity zzbaD;
    String zzbaE;
    ImageEntity zzbaF;
    boolean zzbaG;
    NameEntity zzbaH;
    String zzbaI;
    int zzbaJ;
    List<OrganizationsEntity> zzbaK;
    List<PlacesLivedEntity> zzbaL;
    int zzbaM;
    int zzbaN;
    String zzbaO;
    List<UrlsEntity> zzbaP;
    boolean zzbaQ;
    String zzbay;
    AgeRangeEntity zzbaz;
    int zztH;
    String zzxX;

    public static class zza {
        public static int zzeT(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzaZA;
        int zzbaR;
        int zzbaS;

        static {
            zzaZz.put("max", Field.zzi("max", 2));
            zzaZz.put("min", Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        AgeRangeEntity(Set<Integer> indicatorSet, int versionCode, int max, int min) {
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbaR = max;
            this.zzbaS = min;
        }

        public int describeContents() {
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!ageRangeEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(ageRangeEntity.zzb(field))) {
                        return false;
                    }
                } else if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDv();
        }

        public int getMax() {
            return this.zzbaR;
        }

        public int getMin() {
            return this.zzbaS;
        }

        public boolean hasMax() {
            return this.zzaZA.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.zzaZA.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            zzb.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        public AgeRangeEntity zzDv() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 2:
                    return Integer.valueOf(this.zzbaR);
                case 3:
                    return Integer.valueOf(this.zzbaS);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzaZA;
        CoverInfoEntity zzbaT;
        CoverPhotoEntity zzbaU;
        int zzbaV;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
            final int mVersionCode;
            final Set<Integer> zzaZA;
            int zzbaW;
            int zzbaX;

            static {
                zzaZz.put("leftImageOffset", Field.zzi("leftImageOffset", 2));
                zzaZz.put("topImageOffset", Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzaZA = new HashSet();
            }

            CoverInfoEntity(Set<Integer> indicatorSet, int versionCode, int leftImageOffset, int topImageOffset) {
                this.zzaZA = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzbaW = leftImageOffset;
                this.zzbaX = topImageOffset;
            }

            public int describeContents() {
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (Field field : zzaZz.values()) {
                    if (zza(field)) {
                        if (!coverInfoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverInfoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzDx();
            }

            public int getLeftImageOffset() {
                return this.zzbaW;
            }

            public int getTopImageOffset() {
                return this.zzbaX;
            }

            public boolean hasLeftImageOffset() {
                return this.zzaZA.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.zzaZA.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzaZz.values()) {
                    int hashCode;
                    if (zza(field)) {
                        hashCode = zzb(field).hashCode() + (i + field.zzrc());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                zzd.zza(this, out, flags);
            }

            public HashMap<String, Field<?, ?>> zzDq() {
                return zzaZz;
            }

            public CoverInfoEntity zzDx() {
                return this;
            }

            protected boolean zza(Field field) {
                return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
            }

            protected Object zzb(Field field) {
                switch (field.zzrc()) {
                    case 2:
                        return Integer.valueOf(this.zzbaW);
                    case 3:
                        return Integer.valueOf(this.zzbaX);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
                }
            }

            public /* synthetic */ Map zzqV() {
                return zzDq();
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
            final int mVersionCode;
            String zzF;
            final Set<Integer> zzaZA;
            int zzov;
            int zzow;

            static {
                zzaZz.put("height", Field.zzi("height", 2));
                zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzaZz.put("width", Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzaZA = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> indicatorSet, int versionCode, int height, String url, int width) {
                this.zzaZA = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzow = height;
                this.zzF = url;
                this.zzov = width;
            }

            public int describeContents() {
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (Field field : zzaZz.values()) {
                    if (zza(field)) {
                        if (!coverPhotoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverPhotoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzDy();
            }

            public int getHeight() {
                return this.zzow;
            }

            public String getUrl() {
                return this.zzF;
            }

            public int getWidth() {
                return this.zzov;
            }

            public boolean hasHeight() {
                return this.zzaZA.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.zzaZA.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.zzaZA.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzaZz.values()) {
                    int hashCode;
                    if (zza(field)) {
                        hashCode = zzb(field).hashCode() + (i + field.zzrc());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                zze.zza(this, out, flags);
            }

            public HashMap<String, Field<?, ?>> zzDq() {
                return zzaZz;
            }

            public CoverPhotoEntity zzDy() {
                return this;
            }

            protected boolean zza(Field field) {
                return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
            }

            protected Object zzb(Field field) {
                switch (field.zzrc()) {
                    case 2:
                        return Integer.valueOf(this.zzow);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zzov);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
                }
            }

            public /* synthetic */ Map zzqV() {
                return zzDq();
            }
        }

        static {
            zzaZz.put("coverInfo", Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzaZz.put("coverPhoto", Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzaZz.put("layout", Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        CoverEntity(Set<Integer> indicatorSet, int versionCode, CoverInfoEntity coverInfo, CoverPhotoEntity coverPhoto, int layout) {
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbaT = coverInfo;
            this.zzbaU = coverPhoto;
            this.zzbaV = layout;
        }

        public int describeContents() {
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!coverEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(coverEntity.zzb(field))) {
                        return false;
                    }
                } else if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDw();
        }

        public CoverInfo getCoverInfo() {
            return this.zzbaT;
        }

        public CoverPhoto getCoverPhoto() {
            return this.zzbaU;
        }

        public int getLayout() {
            return this.zzbaV;
        }

        public boolean hasCoverInfo() {
            return this.zzaZA.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.zzaZA.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.zzaZA.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            zzc.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        public CoverEntity zzDw() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 2:
                    return this.zzbaT;
                case 3:
                    return this.zzbaU;
                case 4:
                    return Integer.valueOf(this.zzbaV);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        final int mVersionCode;
        String zzF;
        final Set<Integer> zzaZA;

        static {
            zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        public ImageEntity(String url) {
            this.zzaZA = new HashSet();
            this.mVersionCode = 1;
            this.zzF = url;
            this.zzaZA.add(Integer.valueOf(2));
        }

        ImageEntity(Set<Integer> indicatorSet, int versionCode, String url) {
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzF = url;
        }

        public int describeContents() {
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!imageEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(imageEntity.zzb(field))) {
                        return false;
                    }
                } else if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDz();
        }

        public String getUrl() {
            return this.zzF;
        }

        public boolean hasUrl() {
            return this.zzaZA.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            zzf.zza(this, out, flags);
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        public ImageEntity zzDz() {
            return this;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 2:
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        final int mVersionCode;
        final Set<Integer> zzaZA;
        String zzaZY;
        String zzbaY;
        String zzbaZ;
        String zzbab;
        String zzbba;
        String zzbbb;

        static {
            zzaZz.put("familyName", Field.zzl("familyName", 2));
            zzaZz.put("formatted", Field.zzl("formatted", 3));
            zzaZz.put("givenName", Field.zzl("givenName", 4));
            zzaZz.put("honorificPrefix", Field.zzl("honorificPrefix", 5));
            zzaZz.put("honorificSuffix", Field.zzl("honorificSuffix", 6));
            zzaZz.put("middleName", Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        NameEntity(Set<Integer> indicatorSet, int versionCode, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, String middleName) {
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaZY = familyName;
            this.zzbaY = formatted;
            this.zzbab = givenName;
            this.zzbaZ = honorificPrefix;
            this.zzbba = honorificSuffix;
            this.zzbbb = middleName;
        }

        public int describeContents() {
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!nameEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(nameEntity.zzb(field))) {
                        return false;
                    }
                } else if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDA();
        }

        public String getFamilyName() {
            return this.zzaZY;
        }

        public String getFormatted() {
            return this.zzbaY;
        }

        public String getGivenName() {
            return this.zzbab;
        }

        public String getHonorificPrefix() {
            return this.zzbaZ;
        }

        public String getHonorificSuffix() {
            return this.zzbba;
        }

        public String getMiddleName() {
            return this.zzbbb;
        }

        public boolean hasFamilyName() {
            return this.zzaZA.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.zzaZA.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.zzaZA.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.zzaZA.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.zzaZA.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.zzaZA.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            zzg.zza(this, out, flags);
        }

        public NameEntity zzDA() {
            return this;
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 2:
                    return this.zzaZY;
                case 3:
                    return this.zzbaY;
                case 4:
                    return this.zzbab;
                case 5:
                    return this.zzbaZ;
                case 6:
                    return this.zzbba;
                case 7:
                    return this.zzbbb;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        String mName;
        final int mVersionCode;
        int zzZU;
        final Set<Integer> zzaZA;
        String zzaZX;
        String zzank;
        String zzavc;
        String zzban;
        String zzbbc;
        String zzbbd;
        boolean zzbbe;

        static {
            zzaZz.put("department", Field.zzl("department", 2));
            zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzaZz.put("endDate", Field.zzl("endDate", 4));
            zzaZz.put("location", Field.zzl("location", 5));
            zzaZz.put("name", Field.zzl("name", 6));
            zzaZz.put("primary", Field.zzk("primary", 7));
            zzaZz.put("startDate", Field.zzl("startDate", 8));
            zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzaZz.put("type", Field.zza("type", 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        OrganizationsEntity(Set<Integer> indicatorSet, int versionCode, String department, String description, String endDate, String location, String name, boolean primary, String startDate, String title, int type) {
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbbc = department;
            this.zzavc = description;
            this.zzaZX = endDate;
            this.zzbbd = location;
            this.mName = name;
            this.zzbbe = primary;
            this.zzban = startDate;
            this.zzank = title;
            this.zzZU = type;
        }

        public int describeContents() {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!organizationsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(organizationsEntity.zzb(field))) {
                        return false;
                    }
                } else if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDB();
        }

        public String getDepartment() {
            return this.zzbbc;
        }

        public String getDescription() {
            return this.zzavc;
        }

        public String getEndDate() {
            return this.zzaZX;
        }

        public String getLocation() {
            return this.zzbbd;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzban;
        }

        public String getTitle() {
            return this.zzank;
        }

        public int getType() {
            return this.zzZU;
        }

        public boolean hasDepartment() {
            return this.zzaZA.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.zzaZA.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.zzaZA.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.zzaZA.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.zzaZA.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.zzaZA.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.zzaZA.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.zzaZA.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.zzaZA.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzbbe;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            zzh.zza(this, out, flags);
        }

        public OrganizationsEntity zzDB() {
            return this;
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 2:
                    return this.zzbbc;
                case 3:
                    return this.zzavc;
                case 4:
                    return this.zzaZX;
                case 5:
                    return this.zzbbd;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzbbe);
                case 8:
                    return this.zzban;
                case 9:
                    return this.zzank;
                case 10:
                    return Integer.valueOf(this.zzZU);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzaZA;
        boolean zzbbe;

        static {
            zzaZz.put("primary", Field.zzk("primary", 2));
            zzaZz.put("value", Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> indicatorSet, int versionCode, boolean primary, String value) {
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzbbe = primary;
            this.mValue = value;
        }

        public int describeContents() {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!placesLivedEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(placesLivedEntity.zzb(field))) {
                        return false;
                    }
                } else if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDC();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzaZA.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzaZA.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzbbe;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            zzi.zza(this, out, flags);
        }

        public PlacesLivedEntity zzDC() {
            return this;
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 2:
                    return Boolean.valueOf(this.zzbbe);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
        String mValue;
        final int mVersionCode;
        int zzZU;
        String zzaRQ;
        final Set<Integer> zzaZA;
        private final int zzbbf;

        static {
            zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzaZz.put("type", Field.zza("type", 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh(FitnessActivities.OTHER, 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzaZz.put("value", Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzbbf = 4;
            this.mVersionCode = 1;
            this.zzaZA = new HashSet();
        }

        UrlsEntity(Set<Integer> indicatorSet, int versionCode, String label, int type, String value, int type_DEPRECATED_FENACHO) {
            this.zzbbf = 4;
            this.zzaZA = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaRQ = label;
            this.zzZU = type;
            this.mValue = value;
        }

        public int describeContents() {
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (Field field : zzaZz.values()) {
                if (zza(field)) {
                    if (!urlsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(urlsEntity.zzb(field))) {
                        return false;
                    }
                } else if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzDE();
        }

        public String getLabel() {
            return this.zzaRQ;
        }

        public int getType() {
            return this.zzZU;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzaZA.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.zzaZA.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzaZA.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaZz.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzrc());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            zzj.zza(this, out, flags);
        }

        @Deprecated
        public int zzDD() {
            return 4;
        }

        public UrlsEntity zzDE() {
            return this;
        }

        public HashMap<String, Field<?, ?>> zzDq() {
            return zzaZz;
        }

        protected boolean zza(Field field) {
            return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
        }

        protected Object zzb(Field field) {
            switch (field.zzrc()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaRQ;
                case 6:
                    return Integer.valueOf(this.zzZU);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            }
        }

        public /* synthetic */ Map zzqV() {
            return zzDq();
        }
    }

    static {
        zzaZz.put("aboutMe", Field.zzl("aboutMe", 2));
        zzaZz.put("ageRange", Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzaZz.put("birthday", Field.zzl("birthday", 4));
        zzaZz.put("braggingRights", Field.zzl("braggingRights", 5));
        zzaZz.put("circledByCount", Field.zzi("circledByCount", 6));
        zzaZz.put("cover", Field.zza("cover", 7, CoverEntity.class));
        zzaZz.put("currentLocation", Field.zzl("currentLocation", 8));
        zzaZz.put("displayName", Field.zzl("displayName", 9));
        zzaZz.put("gender", Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh(FitnessActivities.OTHER, 2), false));
        zzaZz.put("id", Field.zzl("id", 14));
        zzaZz.put("image", Field.zza("image", 15, ImageEntity.class));
        zzaZz.put("isPlusUser", Field.zzk("isPlusUser", 16));
        zzaZz.put("language", Field.zzl("language", 18));
        zzaZz.put("name", Field.zza("name", 19, NameEntity.class));
        zzaZz.put("nickname", Field.zzl("nickname", 20));
        zzaZz.put("objectType", Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzaZz.put("organizations", Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzaZz.put("placesLived", Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzaZz.put("plusOneCount", Field.zzi("plusOneCount", 24));
        zzaZz.put("relationshipStatus", Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzaZz.put("tagline", Field.zzl("tagline", 26));
        zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzaZz.put("urls", Field.zzb("urls", 28, UrlsEntity.class));
        zzaZz.put("verified", Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
    }

    public PersonEntity(String displayName, String id, ImageEntity image, int objectType, String url) {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
        this.zzVu = displayName;
        this.zzaZA.add(Integer.valueOf(9));
        this.zzxX = id;
        this.zzaZA.add(Integer.valueOf(14));
        this.zzbaF = image;
        this.zzaZA.add(Integer.valueOf(15));
        this.zzbaJ = objectType;
        this.zzaZA.add(Integer.valueOf(21));
        this.zzF = url;
        this.zzaZA.add(Integer.valueOf(27));
    }

    PersonEntity(Set<Integer> indicatorSet, int versionCode, String aboutMe, AgeRangeEntity ageRange, String birthday, String braggingRights, int circledByCount, CoverEntity cover, String currentLocation, String displayName, int gender, String id, ImageEntity image, boolean isPlusUser, String language, NameEntity name, String nickname, int objectType, List<OrganizationsEntity> organizations, List<PlacesLivedEntity> placesLived, int plusOneCount, int relationshipStatus, String tagline, String url, List<UrlsEntity> urls, boolean verified) {
        this.zzaZA = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzbay = aboutMe;
        this.zzbaz = ageRange;
        this.zzbaA = birthday;
        this.zzbaB = braggingRights;
        this.zzbaC = circledByCount;
        this.zzbaD = cover;
        this.zzbaE = currentLocation;
        this.zzVu = displayName;
        this.zztH = gender;
        this.zzxX = id;
        this.zzbaF = image;
        this.zzbaG = isPlusUser;
        this.zzZe = language;
        this.zzbaH = name;
        this.zzbaI = nickname;
        this.zzbaJ = objectType;
        this.zzbaK = organizations;
        this.zzbaL = placesLived;
        this.zzbaM = plusOneCount;
        this.zzbaN = relationshipStatus;
        this.zzbaO = tagline;
        this.zzF = url;
        this.zzbaP = urls;
        this.zzbaQ = verified;
    }

    public static PersonEntity zzu(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity zzgt = CREATOR.zzgt(obtain);
        obtain.recycle();
        return zzgt;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (Field field : zzaZz.values()) {
            if (zza(field)) {
                if (!personEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(personEntity.zzb(field))) {
                    return false;
                }
            } else if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzDu();
    }

    public String getAboutMe() {
        return this.zzbay;
    }

    public AgeRange getAgeRange() {
        return this.zzbaz;
    }

    public String getBirthday() {
        return this.zzbaA;
    }

    public String getBraggingRights() {
        return this.zzbaB;
    }

    public int getCircledByCount() {
        return this.zzbaC;
    }

    public Cover getCover() {
        return this.zzbaD;
    }

    public String getCurrentLocation() {
        return this.zzbaE;
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public int getGender() {
        return this.zztH;
    }

    public String getId() {
        return this.zzxX;
    }

    public Image getImage() {
        return this.zzbaF;
    }

    public String getLanguage() {
        return this.zzZe;
    }

    public Name getName() {
        return this.zzbaH;
    }

    public String getNickname() {
        return this.zzbaI;
    }

    public int getObjectType() {
        return this.zzbaJ;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.zzbaK;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbaL;
    }

    public int getPlusOneCount() {
        return this.zzbaM;
    }

    public int getRelationshipStatus() {
        return this.zzbaN;
    }

    public String getTagline() {
        return this.zzbaO;
    }

    public String getUrl() {
        return this.zzF;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.zzbaP;
    }

    public boolean hasAboutMe() {
        return this.zzaZA.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.zzaZA.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.zzaZA.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzaZA.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.zzaZA.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.zzaZA.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.zzaZA.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.zzaZA.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.zzaZA.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.zzaZA.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.zzaZA.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.zzaZA.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.zzaZA.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.zzaZA.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.zzaZA.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.zzaZA.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.zzaZA.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.zzaZA.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.zzaZA.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.zzaZA.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.zzaZA.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.zzaZA.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzaZA.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.zzaZA.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzaZz.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzrc());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.zzbaG;
    }

    public boolean isVerified() {
        return this.zzbaQ;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzDq() {
        return zzaZz;
    }

    public PersonEntity zzDu() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrc()) {
            case 2:
                return this.zzbay;
            case 3:
                return this.zzbaz;
            case 4:
                return this.zzbaA;
            case 5:
                return this.zzbaB;
            case 6:
                return Integer.valueOf(this.zzbaC);
            case 7:
                return this.zzbaD;
            case 8:
                return this.zzbaE;
            case 9:
                return this.zzVu;
            case 12:
                return Integer.valueOf(this.zztH);
            case 14:
                return this.zzxX;
            case 15:
                return this.zzbaF;
            case 16:
                return Boolean.valueOf(this.zzbaG);
            case 18:
                return this.zzZe;
            case 19:
                return this.zzbaH;
            case 20:
                return this.zzbaI;
            case 21:
                return Integer.valueOf(this.zzbaJ);
            case 22:
                return this.zzbaK;
            case 23:
                return this.zzbaL;
            case 24:
                return Integer.valueOf(this.zzbaM);
            case 25:
                return Integer.valueOf(this.zzbaN);
            case 26:
                return this.zzbaO;
            case 27:
                return this.zzF;
            case 28:
                return this.zzbaP;
            case 29:
                return Boolean.valueOf(this.zzbaQ);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
        }
    }

    public /* synthetic */ Map zzqV() {
        return zzDq();
    }
}
