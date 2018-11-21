package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    private final Strategy zzaWL;
    private final MessageFilter zzaWY;
    private final SubscribeCallback zzaWZ;

    public static class Builder {
        private Strategy zzaWL = Strategy.DEFAULT;
        private MessageFilter zzaWY = MessageFilter.INCLUDE_ALL_MY_TYPES;
        private SubscribeCallback zzaWZ;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zzaWL, this.zzaWY, this.zzaWZ);
        }

        public Builder setCallback(SubscribeCallback callback) {
            this.zzaWZ = (SubscribeCallback) zzx.zzy(callback);
            return this;
        }

        public Builder setFilter(MessageFilter filter) {
            this.zzaWY = filter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzaWL = strategy;
            return this;
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter filter, SubscribeCallback callback) {
        this.zzaWL = strategy;
        this.zzaWY = filter;
        this.zzaWZ = callback;
    }

    public SubscribeCallback getCallback() {
        return this.zzaWZ;
    }

    public MessageFilter getFilter() {
        return this.zzaWY;
    }

    public Strategy getStrategy() {
        return this.zzaWL;
    }
}
