package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzu;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzanc;
    private final boolean zzand;
    private final int zzane;

    public static final class Builder {
        private String zzanc;
        private boolean zzand;
        private int zzane = 0;

        public ExecutionOptions build() {
            if (this.zzane != 1 || this.zzand) {
                return new ExecutionOptions(this.zzanc, this.zzand, this.zzane);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int strategy) {
            if (ExecutionOptions.zzcz(strategy)) {
                this.zzane = strategy;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + strategy);
        }

        public Builder setNotifyOnCompletion(boolean notify) {
            this.zzand = notify;
            return this;
        }

        public Builder setTrackingTag(String trackingTag) {
            if (ExecutionOptions.zzcR(trackingTag)) {
                this.zzanc = trackingTag;
                return this;
            }
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{Integer.valueOf(65536)}));
        }
    }

    public ExecutionOptions(String trackingTag, boolean notifyOnCompletion, int conflictStrategy) {
        this.zzanc = trackingTag;
        this.zzand = notifyOnCompletion;
        this.zzane = conflictStrategy;
    }

    public static void zza(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) googleApiClient.zza(Drive.zzTo);
        if (executionOptions.zzsm() && !com_google_android_gms_drive_internal_zzu.zzsJ()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean zzcR(String str) {
        return (str == null || str.isEmpty() || str.length() > 65536) ? false : true;
    }

    public static boolean zzcy(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcz(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) o;
        return zzw.equal(this.zzanc, executionOptions.zzanc) && this.zzane == executionOptions.zzane && this.zzand == executionOptions.zzand;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanc, Integer.valueOf(this.zzane), Boolean.valueOf(this.zzand));
    }

    public String zzsl() {
        return this.zzanc;
    }

    public boolean zzsm() {
        return this.zzand;
    }

    public int zzsn() {
        return this.zzane;
    }
}
