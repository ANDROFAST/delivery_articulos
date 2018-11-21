package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzha
class zzeh {
    final String zzpH;
    final AdRequestParcel zzqo;

    zzeh(AdRequestParcel adRequestParcel, String str) {
        this.zzqo = adRequestParcel;
        this.zzpH = str;
    }

    zzeh(String str) throws IOException {
        String[] split = str.split("\u0000");
        if (split.length != 2) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            this.zzpH = new String(Base64.decode(split[0], 0), "UTF-8");
            byte[] decode = Base64.decode(split[1], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            this.zzqo = AdRequestParcel.CREATOR.zzb(obtain);
            obtain.recycle();
        } catch (IllegalArgumentException e) {
            throw new IOException("Malformed QueueSeed encoding.");
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    String zzef() {
        String encodeToString;
        Parcel obtain = Parcel.obtain();
        try {
            encodeToString = Base64.encodeToString(this.zzpH.getBytes("UTF-8"), 0);
            this.zzqo.writeToParcel(obtain, 0);
            encodeToString = encodeToString + "\u0000" + Base64.encodeToString(obtain.marshall(), 0);
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            zzb.m6e(encodeToString);
            return "";
        } finally {
            obtain.recycle();
        }
    }
}
