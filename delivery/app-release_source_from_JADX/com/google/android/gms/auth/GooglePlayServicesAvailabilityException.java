package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzTQ;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.zzTQ = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.zzTQ;
    }
}
