package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.Status;

public class zzkl implements AppInviteInvitationResult {
    private final Status zzTA;
    private final Intent zzTB;

    public zzkl(Status status, Intent intent) {
        this.zzTA = status;
        this.zzTB = intent;
    }

    public Intent getInvitationIntent() {
        return this.zzTB;
    }

    public Status getStatus() {
        return this.zzTA;
    }
}
