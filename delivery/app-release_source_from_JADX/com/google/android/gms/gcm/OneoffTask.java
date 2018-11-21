package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new C02531();
    private final long zzaJi;
    private final long zzaJj;

    static class C02531 implements Creator<OneoffTask> {
        C02531() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzez(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgW(x0);
        }

        public OneoffTask zzez(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        public OneoffTask[] zzgW(int i) {
            return new OneoffTask[i];
        }
    }

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzaJk;
        private long zzaJl;

        public Builder() {
            this.zzaJk = -1;
            this.zzaJl = -1;
            this.isPersisted = false;
        }

        public OneoffTask build() {
            checkConditions();
            return new OneoffTask();
        }

        protected void checkConditions() {
            super.checkConditions();
            if (this.zzaJk == -1 || this.zzaJl == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            } else if (this.zzaJk >= this.zzaJl) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public Builder setExecutionWindow(long windowStartDelaySeconds, long windowEndDelaySeconds) {
            this.zzaJk = windowStartDelaySeconds;
            this.zzaJl = windowEndDelaySeconds;
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.extras = extras;
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
    private OneoffTask(Parcel in) {
        super(in);
        this.zzaJi = in.readLong();
        this.zzaJj = in.readLong();
    }

    private OneoffTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.zzaJi = builder.zzaJk;
        this.zzaJj = builder.zzaJl;
    }

    public long getWindowEnd() {
        return this.zzaJj;
    }

    public long getWindowStart() {
        return this.zzaJi;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzaJi);
        bundle.putLong("window_end", this.zzaJj);
    }

    public String toString() {
        return super.toString() + " " + "windowStart=" + getWindowStart() + " " + "windowEnd=" + getWindowEnd();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        super.writeToParcel(parcel, flags);
        parcel.writeLong(this.zzaJi);
        parcel.writeLong(this.zzaJj);
    }
}
