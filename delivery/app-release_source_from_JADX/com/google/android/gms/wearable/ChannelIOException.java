package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException extends IOException {
    private final int zzblN;
    private final int zzblO;

    public ChannelIOException(String message, int closeReason, int appSpecificErrorCode) {
        super(message);
        this.zzblN = closeReason;
        this.zzblO = appSpecificErrorCode;
    }

    public int getAppSpecificErrorCode() {
        return this.zzblO;
    }

    public int getCloseReason() {
        return this.zzblN;
    }
}
