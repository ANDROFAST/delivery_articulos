package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    private final Strategy zzaWL;
    private final PublishCallback zzaWM;

    public static class Builder {
        private Strategy zzaWL = Strategy.DEFAULT;
        private PublishCallback zzaWM;

        public PublishOptions build() {
            return new PublishOptions(this.zzaWL, this.zzaWM);
        }

        public Builder setCallback(PublishCallback callback) {
            this.zzaWM = (PublishCallback) zzx.zzy(callback);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzaWL = (Strategy) zzx.zzy(strategy);
            return this;
        }
    }

    private PublishOptions(Strategy strategy, PublishCallback callback) {
        this.zzaWL = strategy;
        this.zzaWM = callback;
    }

    public PublishCallback getCallback() {
        return this.zzaWM;
    }

    public Strategy getStrategy() {
        return this.zzaWL;
    }
}
