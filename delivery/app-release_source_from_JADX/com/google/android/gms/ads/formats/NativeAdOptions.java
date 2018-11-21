package com.google.android.gms.ads.formats;

public final class NativeAdOptions {
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzoC;
    private final int zzoD;
    private final boolean zzoE;

    public static final class Builder {
        private boolean zzoC = false;
        private int zzoD = 0;
        private boolean zzoE = false;

        public NativeAdOptions build() {
            return new NativeAdOptions();
        }

        public Builder setImageOrientation(int orientation) {
            this.zzoD = orientation;
            return this;
        }

        public Builder setRequestMultipleImages(boolean shouldRequestMultipleImages) {
            this.zzoE = shouldRequestMultipleImages;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean shouldReturnUrls) {
            this.zzoC = shouldReturnUrls;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zzoC = builder.zzoC;
        this.zzoD = builder.zzoD;
        this.zzoE = builder.zzoE;
    }

    public int getImageOrientation() {
        return this.zzoD;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzoE;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zzoC;
    }
}
