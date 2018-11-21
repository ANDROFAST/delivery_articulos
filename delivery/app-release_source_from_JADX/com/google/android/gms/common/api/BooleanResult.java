package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult implements Result {
    private final Status zzTA;
    private final boolean zzaey;

    public BooleanResult(Status status, boolean value) {
        this.zzTA = (Status) zzx.zzb((Object) status, (Object) "Status must not be null");
        this.zzaey = value;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zzTA.equals(booleanResult.zzTA) && this.zzaey == booleanResult.zzaey;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public boolean getValue() {
        return this.zzaey;
    }

    public final int hashCode() {
        return (this.zzaey ? 1 : 0) + ((this.zzTA.hashCode() + 527) * 31);
    }
}
