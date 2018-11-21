package com.google.android.gms.internal;

import java.io.IOException;

class zzas implements zzaq {
    private zztd zzol;
    private byte[] zzom;
    private final int zzon;

    public zzas(int i) {
        this.zzon = i;
        reset();
    }

    public void reset() {
        this.zzom = new byte[this.zzon];
        this.zzol = zztd.zzD(this.zzom);
    }

    public byte[] zzad() throws IOException {
        int zzHx = this.zzol.zzHx();
        if (zzHx < 0) {
            throw new IOException();
        } else if (zzHx == 0) {
            return this.zzom;
        } else {
            Object obj = new byte[(this.zzom.length - zzHx)];
            System.arraycopy(this.zzom, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void zzb(int i, long j) throws IOException {
        this.zzol.zzb(i, j);
    }

    public void zzb(int i, String str) throws IOException {
        this.zzol.zzb(i, str);
    }
}
