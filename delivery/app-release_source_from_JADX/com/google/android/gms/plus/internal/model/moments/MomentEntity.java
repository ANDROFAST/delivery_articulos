package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
    final int mVersionCode;
    String zzIx;
    final Set<Integer> zzaZA;
    String zzban;
    ItemScopeEntity zzbav;
    ItemScopeEntity zzbaw;
    String zzxX;

    static {
        zzaZz.put("id", Field.zzl("id", 2));
        zzaZz.put("result", Field.zza("result", 4, ItemScopeEntity.class));
        zzaZz.put("startDate", Field.zzl("startDate", 5));
        zzaZz.put("target", Field.zza("target", 6, ItemScopeEntity.class));
        zzaZz.put("type", Field.zzl("type", 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
    }

    MomentEntity(Set<Integer> indicatorSet, int versionCode, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaZA = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzxX = id;
        this.zzbav = result;
        this.zzban = startDate;
        this.zzbaw = target;
        this.zzIx = type;
    }

    public MomentEntity(Set<Integer> indicatorSet, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaZA = indicatorSet;
        this.mVersionCode = 1;
        this.zzxX = id;
        this.zzbav = result;
        this.zzban = startDate;
        this.zzbaw = target;
        this.zzIx = type;
    }

    public int describeContents() {
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (Field field : zzaZz.values()) {
            if (zza(field)) {
                if (!momentEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(momentEntity.zzb(field))) {
                    return false;
                }
            } else if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzDs();
    }

    public String getId() {
        return this.zzxX;
    }

    public ItemScope getResult() {
        return this.zzbav;
    }

    public String getStartDate() {
        return this.zzban;
    }

    public ItemScope getTarget() {
        return this.zzbaw;
    }

    public String getType() {
        return this.zzIx;
    }

    public boolean hasId() {
        return this.zzaZA.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.zzaZA.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.zzaZA.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.zzaZA.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
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
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzDq() {
        return zzaZz;
    }

    public MomentEntity zzDs() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrc()) {
            case 2:
                return this.zzxX;
            case 4:
                return this.zzbav;
            case 5:
                return this.zzban;
            case 6:
                return this.zzbaw;
            case 7:
                return this.zzIx;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
        }
    }

    public /* synthetic */ Map zzqV() {
        return zzDq();
    }
}
