package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zza.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zztp.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int versionCode;
    public final zzd zzadA;
    public final zzb zzadB;
    public final zzb zzadC;
    public PlayLoggerContext zzadx;
    public byte[] zzady;
    public int[] zzadz;

    LogEventParcelable(int versionCode, PlayLoggerContext playLoggerContext, byte[] logEventBytes, int[] testCodes) {
        this.versionCode = versionCode;
        this.zzadx = playLoggerContext;
        this.zzady = logEventBytes;
        this.zzadz = testCodes;
        this.zzadA = null;
        this.zzadB = null;
        this.zzadC = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzd logEvent, zzb extensionProducer, zzb clientVisualElementsProducer, int[] testCodes) {
        this.versionCode = 1;
        this.zzadx = playLoggerContext;
        this.zzadA = logEvent;
        this.zzadB = extensionProducer;
        this.zzadC = clientVisualElementsProducer;
        this.zzadz = testCodes;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) other;
        return this.versionCode == logEventParcelable.versionCode && zzw.equal(this.zzadx, logEventParcelable.zzadx) && Arrays.equals(this.zzady, logEventParcelable.zzady) && Arrays.equals(this.zzadz, logEventParcelable.zzadz) && zzw.equal(this.zzadA, logEventParcelable.zzadA) && zzw.equal(this.zzadB, logEventParcelable.zzadB) && zzw.equal(this.zzadC, logEventParcelable.zzadC);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.zzadx, this.zzady, this.zzadz, this.zzadA, this.zzadB, this.zzadC);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LogEventParcelable[");
        stringBuilder.append(this.versionCode);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzadx);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzady == null ? null : new String(this.zzady));
        stringBuilder.append(", ");
        stringBuilder.append(this.zzadz == null ? (String) null : zzv.zzcF(", ").zza(Arrays.asList(new int[][]{this.zzadz})));
        stringBuilder.append(", ");
        stringBuilder.append(this.zzadA);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzadB);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzadC);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
