package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzos.zzb;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpv;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqb;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API = null;
    public static final Api<NoOptions> BLE_API = new Api("Fitness.BLE_API", new zzb(), zzatF);
    public static final BleApi BleApi = zztx();
    public static final Api<NoOptions> CONFIG_API = new Api("Fitness.CONFIG_API", new zzot.zzb(), zzatG);
    public static final ConfigApi ConfigApi = new zzpu();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> HISTORY_API = new Api("Fitness.HISTORY_API", new zzou.zzb(), zzatH);
    public static final HistoryApi HistoryApi = new zzpv();
    public static final Api<NoOptions> RECORDING_API = new Api("Fitness.RECORDING_API", new zzow.zzb(), zzatJ);
    public static final RecordingApi RecordingApi = new zzpx();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final Scope SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    public static final Api<NoOptions> SENSORS_API = new Api("Fitness.SENSORS_API", new zzox.zzb(), zzatK);
    public static final Api<NoOptions> SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzoy.zzb(), zzatL);
    public static final SensorsApi SensorsApi = new zzpy();
    public static final SessionsApi SessionsApi = new zzpz();
    public static final Api<NoOptions> zzamM = new Api("Fitness.INTERNAL_API", new zza(), zzatI);
    public static final zzc<zzos> zzatF = new zzc();
    public static final zzc<zzot> zzatG = new zzc();
    public static final zzc<zzou> zzatH = new zzc();
    public static final zzc<zzov> zzatI = new zzc();
    public static final zzc<zzow> zzatJ = new zzc();
    public static final zzc<zzox> zzatK = new zzc();
    public static final zzc<zzoy> zzatL = new zzc();
    public static final zzpr zzatM = new zzpw();

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zztx() {
        return VERSION.SDK_INT >= 18 ? new zzpt() : new zzqb();
    }
}
