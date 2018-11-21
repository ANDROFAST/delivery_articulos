package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private Bitmap mBitmap;
    private Metadata zzbic;
    private ByteBuffer zzbid;

    public static class Builder {
        private Frame zzbie = new Frame();

        public Frame build() {
            if (this.zzbie.zzbid != null || this.zzbie.mBitmap != null) {
                return this.zzbie;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap image) {
            int width = image.getWidth();
            int height = image.getHeight();
            this.zzbie.mBitmap = image;
            Metadata metadata = this.zzbie.getMetadata();
            metadata.zzov = width;
            metadata.zzow = height;
            return this;
        }

        public Builder setId(int id) {
            this.zzbie.getMetadata().mId = id;
            return this;
        }

        public Builder setImageData(ByteBuffer data, int width, int height, int format) {
            if (data == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (data.capacity() < width * height) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else {
                switch (format) {
                    case 16:
                    case 17:
                    case 842094169:
                        this.zzbie.zzbid = data;
                        Metadata metadata = this.zzbie.getMetadata();
                        metadata.zzov = width;
                        metadata.zzow = height;
                        return this;
                    default:
                        throw new IllegalArgumentException("Unsupported image format: " + format);
                }
            }
        }

        public Builder setRotation(int rotation) {
            this.zzbie.getMetadata().zzCE = rotation;
            return this;
        }

        public Builder setTimestampMillis(long timestampMillis) {
            this.zzbie.getMetadata().zzaGy = timestampMillis;
            return this;
        }
    }

    public static class Metadata {
        private int mId;
        private int zzCE;
        private long zzaGy;
        private int zzov;
        private int zzow;

        public Metadata(Metadata metadata) {
            this.zzov = metadata.getWidth();
            this.zzow = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzaGy = metadata.getTimestampMillis();
            this.zzCE = metadata.getRotation();
        }

        public int getHeight() {
            return this.zzow;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzCE;
        }

        public long getTimestampMillis() {
            return this.zzaGy;
        }

        public int getWidth() {
            return this.zzov;
        }

        public void zzGk() {
            if (this.zzCE % 2 != 0) {
                int i = this.zzov;
                this.zzov = this.zzow;
                this.zzow = i;
            }
            this.zzCE = 0;
        }
    }

    private Frame() {
        this.zzbic = new Metadata();
        this.zzbid = null;
        this.mBitmap = null;
    }

    private ByteBuffer zzGj() {
        int i = 0;
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int[] iArr = new int[(width * height)];
        this.mBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[(width * height)];
        while (i < iArr.length) {
            bArr[i] = (byte) ((int) (((((float) Color.red(iArr[i])) * 0.299f) + (((float) Color.green(iArr[i])) * 0.587f)) + (((float) Color.blue(iArr[i])) * 0.114f)));
            i++;
        }
        return ByteBuffer.wrap(bArr);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        return this.mBitmap != null ? zzGj() : this.zzbid;
    }

    public Metadata getMetadata() {
        return this.zzbic;
    }
}
