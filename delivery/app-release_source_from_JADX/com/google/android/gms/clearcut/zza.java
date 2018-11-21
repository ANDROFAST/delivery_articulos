package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zztp.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class zza {
    public static final Api<NoOptions> API = new Api("ClearcutLogger.API", zzTp, zzTo);
    public static final com.google.android.gms.common.api.Api.zzc<zzlu> zzTo = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzlu, NoOptions> zzTp = new C06421();
    public static final zzb zzadh = new zzlt();
    private final Context mContext;
    private final String zzSp;
    private final int zzadi;
    private String zzadj;
    private int zzadk;
    private String zzadl;
    private String zzadm;
    private final boolean zzadn;
    private int zzado;
    private final zzb zzadp;
    private zzc zzadq;
    private final zznl zzqD;

    public class zza {
        private String zzadj;
        private int zzadk;
        private String zzadl;
        private String zzadm;
        private int zzado;
        private final zzb zzadr;
        private zzb zzads;
        private ArrayList<Integer> zzadt;
        private final zzd zzadu;
        private boolean zzadv;
        final /* synthetic */ zza zzadw;

        private zza(zza com_google_android_gms_clearcut_zza, byte[] bArr) {
            this(com_google_android_gms_clearcut_zza, bArr, null);
        }

        private zza(zza com_google_android_gms_clearcut_zza, byte[] bArr, zzb com_google_android_gms_clearcut_zza_zzb) {
            this.zzadw = com_google_android_gms_clearcut_zza;
            this.zzadk = this.zzadw.zzadk;
            this.zzadj = this.zzadw.zzadj;
            this.zzadl = this.zzadw.zzadl;
            this.zzadm = this.zzadw.zzadm;
            this.zzado = this.zzadw.zzado;
            this.zzadt = null;
            this.zzadu = new zzd();
            this.zzadv = false;
            this.zzadl = com_google_android_gms_clearcut_zza.zzadl;
            this.zzadm = com_google_android_gms_clearcut_zza.zzadm;
            this.zzadu.zzbqw = com_google_android_gms_clearcut_zza.zzqD.currentTimeMillis();
            this.zzadu.zzbqx = com_google_android_gms_clearcut_zza.zzqD.elapsedRealtime();
            this.zzadu.zzbqI = com_google_android_gms_clearcut_zza.zzadq.zzC(this.zzadu.zzbqw);
            if (bArr != null) {
                this.zzadu.zzbqD = bArr;
            }
            this.zzadr = com_google_android_gms_clearcut_zza_zzb;
        }

        public zza zzbq(int i) {
            this.zzadu.zzbqz = i;
            return this;
        }

        public zza zzbr(int i) {
            this.zzadu.zznN = i;
            return this;
        }

        public PendingResult<Status> zzc(GoogleApiClient googleApiClient) {
            if (this.zzadv) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzadv = true;
            return this.zzadw.zzadp.zza(googleApiClient, zzom());
        }

        public LogEventParcelable zzom() {
            return new LogEventParcelable(new PlayLoggerContext(this.zzadw.zzSp, this.zzadw.zzadi, this.zzadk, this.zzadj, this.zzadl, this.zzadm, this.zzadw.zzadn, this.zzado), this.zzadu, this.zzadr, this.zzads, zza.zzb(this.zzadt));
        }
    }

    public interface zzb {
        byte[] zzon();
    }

    public static class zzc {
        public long zzC(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    static class C06421 extends com.google.android.gms.common.api.Api.zza<zzlu, NoOptions> {
        C06421() {
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zze(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzlu zze(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlu(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    zza(Context context, int i, String str, String str2, String str3, boolean z, zzb com_google_android_gms_clearcut_zzb, zznl com_google_android_gms_internal_zznl) {
        boolean z2 = false;
        this.zzadk = -1;
        this.zzado = 0;
        this.mContext = context.getApplicationContext();
        this.zzSp = context.getPackageName();
        this.zzadi = zzah(context);
        this.zzadk = i;
        this.zzadj = str;
        this.zzadl = str2;
        this.zzadm = str3;
        this.zzadn = z;
        this.zzadp = com_google_android_gms_clearcut_zzb;
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzadq = new zzc();
        this.zzado = 0;
        if (this.zzadn) {
            if (this.zzadl == null) {
                z2 = true;
            }
            zzx.zzb(z2, (Object) "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public zza(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, zzadh, zzno.zzrM());
    }

    private int zzah(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        return this.zzadp.zza(googleApiClient, j, timeUnit);
    }

    public zza zzi(byte[] bArr) {
        return new zza(bArr);
    }
}
