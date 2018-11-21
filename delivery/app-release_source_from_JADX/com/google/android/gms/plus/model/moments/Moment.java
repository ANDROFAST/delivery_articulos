package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String zzIx;
        private final Set<Integer> zzaZA = new HashSet();
        private String zzban;
        private ItemScopeEntity zzbav;
        private ItemScopeEntity zzbaw;
        private String zzxX;

        public Moment build() {
            return new MomentEntity(this.zzaZA, this.zzxX, this.zzbav, this.zzban, this.zzbaw, this.zzIx);
        }

        public Builder setId(String id) {
            this.zzxX = id;
            this.zzaZA.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.zzbav = (ItemScopeEntity) result;
            this.zzaZA.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzban = startDate;
            this.zzaZA.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.zzbaw = (ItemScopeEntity) target;
            this.zzaZA.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String type) {
            this.zzIx = type;
            this.zzaZA.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
