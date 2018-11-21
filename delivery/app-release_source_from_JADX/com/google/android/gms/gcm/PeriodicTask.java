package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new C02551();
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    static class C02551 implements Creator<PeriodicTask> {
        C02551() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzeB(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgY(x0);
        }

        public PeriodicTask zzeB(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        public PeriodicTask[] zzgY(int i) {
            return new PeriodicTask[i];
        }
    }

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzaJm;
        private long zzaJn;

        public Builder() {
            this.zzaJm = -1;
            this.zzaJn = -1;
            this.isPersisted = true;
        }

        public PeriodicTask build() {
            checkConditions();
            return new PeriodicTask();
        }

        protected void checkConditions() {
            super.checkConditions();
            if (this.zzaJm == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (this.zzaJm <= 0) {
                throw new IllegalArgumentException("Period set cannot be less or equal to 0: " + this.zzaJm);
            } else if (this.zzaJn == -1) {
                this.zzaJn = (long) (((float) this.zzaJm) * 0.1f);
            } else if (this.zzaJn > this.zzaJm) {
                this.zzaJn = this.zzaJm;
            }
        }

        public Builder setExtras(Bundle extras) {
            this.extras = extras;
            return this;
        }

        public Builder setFlex(long flexInSeconds) {
            this.zzaJn = flexInSeconds;
            return this;
        }

        public Builder setPeriod(long periodInSeconds) {
            this.zzaJm = periodInSeconds;
            return this;
        }

        public Builder setPersisted(boolean isPersisted) {
            this.isPersisted = isPersisted;
            return this;
        }

        public Builder setRequiredNetwork(int requiredNetworkState) {
            this.requiredNetworkState = requiredNetworkState;
            return this;
        }

        public Builder setRequiresCharging(boolean requiresCharging) {
            this.requiresCharging = requiresCharging;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> gcmTaskService) {
            this.gcmTaskService = gcmTaskService.getName();
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setUpdateCurrent(boolean updateCurrent) {
            this.updateCurrent = updateCurrent;
            return this;
        }
    }

    @Deprecated
    private PeriodicTask(Parcel in) {
        super(in);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = in.readLong();
        this.mFlexInSeconds = Math.min(in.readLong(), this.mIntervalInSeconds);
    }

    private PeriodicTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = builder.zzaJm;
        this.mFlexInSeconds = Math.min(builder.zzaJn, this.mIntervalInSeconds);
    }

    public long getFlex() {
        return this.mFlexInSeconds;
    }

    public long getPeriod() {
        return this.mIntervalInSeconds;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("period", this.mIntervalInSeconds);
        bundle.putLong("period_flex", this.mFlexInSeconds);
    }

    public String toString() {
        return super.toString() + " " + "period=" + getPeriod() + " " + "flex=" + getFlex();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        super.writeToParcel(parcel, flags);
        parcel.writeLong(this.mIntervalInSeconds);
        parcel.writeLong(this.mFlexInSeconds);
    }
}
