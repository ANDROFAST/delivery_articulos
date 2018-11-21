package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

public class zzab extends zzw {
    private boolean zzQn;
    private final AlarmManager zzQo = ((AlarmManager) getContext().getSystemService("alarm"));

    protected zzab(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private PendingIntent zzkM() {
        Intent intent = new Intent(getContext(), AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel() {
        zzje();
        this.zzQn = false;
        this.zzQo.cancel(zzkM());
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    protected void zzir() {
        this.zzQo.cancel(zzkM());
    }

    public void zzt(long j) {
        zzje();
        zzx.zzab(j > 0);
        zzx.zza(AppMeasurementReceiver.zzX(getContext()), (Object) "Receiver not registered/enabled");
        zzx.zza(AppMeasurementService.zzY(getContext()), (Object) "Service not registered/enabled");
        cancel();
        long elapsedRealtime = zziT().elapsedRealtime() + j;
        this.zzQn = true;
        this.zzQo.setInexactRepeating(2, elapsedRealtime, Math.max(zzAX().zzAN(), j), zzkM());
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
