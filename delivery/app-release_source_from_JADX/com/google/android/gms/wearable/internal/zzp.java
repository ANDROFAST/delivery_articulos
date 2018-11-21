package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzp extends InputStream {
    private final InputStream zzbne;
    private volatile zzm zzbnf;

    class C08121 implements zzu {
        final /* synthetic */ zzp zzbng;

        C08121(zzp com_google_android_gms_wearable_internal_zzp) {
            this.zzbng = com_google_android_gms_wearable_internal_zzp;
        }

        public void zzb(zzm com_google_android_gms_wearable_internal_zzm) {
            this.zzbng.zza(com_google_android_gms_wearable_internal_zzm);
        }
    }

    public zzp(InputStream inputStream) {
        this.zzbne = (InputStream) zzx.zzy(inputStream);
    }

    private int zzlt(int i) throws ChannelIOException {
        if (i == -1) {
            zzm com_google_android_gms_wearable_internal_zzm = this.zzbnf;
            if (com_google_android_gms_wearable_internal_zzm != null) {
                throw new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzm.zzbmV, com_google_android_gms_wearable_internal_zzm.zzbmW);
            }
        }
        return i;
    }

    public int available() throws IOException {
        return this.zzbne.available();
    }

    public void close() throws IOException {
        this.zzbne.close();
    }

    public void mark(int readlimit) {
        this.zzbne.mark(readlimit);
    }

    public boolean markSupported() {
        return this.zzbne.markSupported();
    }

    public int read() throws IOException {
        return zzlt(this.zzbne.read());
    }

    public int read(byte[] buffer) throws IOException {
        return zzlt(this.zzbne.read(buffer));
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzlt(this.zzbne.read(buffer, byteOffset, byteCount));
    }

    public void reset() throws IOException {
        this.zzbne.reset();
    }

    public long skip(long byteCount) throws IOException {
        return this.zzbne.skip(byteCount);
    }

    zzu zzGL() {
        return new C08121(this);
    }

    void zza(zzm com_google_android_gms_wearable_internal_zzm) {
        this.zzbnf = (zzm) zzx.zzy(com_google_android_gms_wearable_internal_zzm);
    }
}
