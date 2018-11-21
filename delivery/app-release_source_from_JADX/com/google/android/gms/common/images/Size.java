package com.google.android.gms.common.images;

public final class Size {
    private final int zzov;
    private final int zzow;

    public Size(int width, int height) {
        this.zzov = width;
        this.zzow = height;
    }

    public static Size parseSize(String string) throws NumberFormatException {
        if (string == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = string.indexOf(42);
        if (indexOf < 0) {
            indexOf = string.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzcw(string);
        }
        try {
            return new Size(Integer.parseInt(string.substring(0, indexOf)), Integer.parseInt(string.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcw(string);
        }
    }

    private static NumberFormatException zzcw(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.zzov == size.zzov && this.zzow == size.zzow)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.zzow;
    }

    public int getWidth() {
        return this.zzov;
    }

    public int hashCode() {
        return this.zzow ^ ((this.zzov << 16) | (this.zzov >>> 16));
    }

    public String toString() {
        return this.zzov + "x" + this.zzow;
    }
}
