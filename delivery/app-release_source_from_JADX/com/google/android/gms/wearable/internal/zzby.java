package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzby implements ChannelListener {
    private final String zzTR;
    private final ChannelListener zzboG;

    zzby(String str, ChannelListener channelListener) {
        this.zzTR = (String) zzx.zzy(str);
        this.zzboG = (ChannelListener) zzx.zzy(channelListener);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzby)) {
            return false;
        }
        zzby com_google_android_gms_wearable_internal_zzby = (zzby) o;
        return this.zzboG.equals(com_google_android_gms_wearable_internal_zzby.zzboG) && this.zzTR.equals(com_google_android_gms_wearable_internal_zzby.zzTR);
    }

    public int hashCode() {
        return (this.zzTR.hashCode() * 31) + this.zzboG.hashCode();
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzboG.onChannelClosed(channel, closeReason, appSpecificErrorCode);
    }

    public void onChannelOpened(Channel channel) {
        this.zzboG.onChannelOpened(channel);
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzboG.onInputClosed(channel, closeReason, appSpecificErrorCode);
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzboG.onOutputClosed(channel, closeReason, appSpecificErrorCode);
    }
}
