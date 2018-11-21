package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzq extends OutputStream {
    private volatile zzm zzbnf;
    private final OutputStream zzbnh;

    class C08131 implements zzu {
        final /* synthetic */ zzq zzbni;

        C08131(zzq com_google_android_gms_wearable_internal_zzq) {
            this.zzbni = com_google_android_gms_wearable_internal_zzq;
        }

        public void zzb(zzm com_google_android_gms_wearable_internal_zzm) {
            this.zzbni.zzc(com_google_android_gms_wearable_internal_zzm);
        }
    }

    public zzq(OutputStream outputStream) {
        this.zzbnh = (OutputStream) zzx.zzy(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzm com_google_android_gms_wearable_internal_zzm = this.zzbnf;
        if (com_google_android_gms_wearable_internal_zzm == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzm.zzbmV, com_google_android_gms_wearable_internal_zzm.zzbmW);
    }

    public void close() throws IOException {
        try {
            this.zzbnh.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzbnh.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzbnh.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer) throws IOException {
        try {
            this.zzbnh.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzbnh.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzu zzGL() {
        return new C08131(this);
    }

    void zzc(zzm com_google_android_gms_wearable_internal_zzm) {
        this.zzbnf = com_google_android_gms_wearable_internal_zzm;
    }
}
