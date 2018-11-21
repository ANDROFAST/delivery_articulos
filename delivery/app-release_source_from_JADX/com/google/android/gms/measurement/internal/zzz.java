package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.List;

public class zzz extends zzw {
    private final zza zzaUS;
    private zzl zzaUT;
    private Boolean zzaUU;
    private final zze zzaUV;
    private final zzaa zzaUW;
    private final List<Runnable> zzaUX = new ArrayList();
    private final zze zzaUY;

    class C03943 implements Runnable {
        final /* synthetic */ zzz zzaUZ;

        C03943(zzz com_google_android_gms_measurement_internal_zzz) {
            this.zzaUZ = com_google_android_gms_measurement_internal_zzz;
        }

        public void run() {
            zzl zzc = this.zzaUZ.zzaUT;
            if (zzc == null) {
                this.zzaUZ.zzzz().zzBl().zzez("Failed to send measurementEnabled to service");
                return;
            }
            try {
                zzc.zzb(this.zzaUZ.zzAS().zzex(this.zzaUZ.zzzz().zzBs()));
                this.zzaUZ.zzjr();
            } catch (RemoteException e) {
                this.zzaUZ.zzzz().zzBl().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
            }
        }
    }

    class C03976 implements Runnable {
        final /* synthetic */ zzz zzaUZ;

        C03976(zzz com_google_android_gms_measurement_internal_zzz) {
            this.zzaUZ = com_google_android_gms_measurement_internal_zzz;
        }

        public void run() {
            zzl zzc = this.zzaUZ.zzaUT;
            if (zzc == null) {
                this.zzaUZ.zzzz().zzBl().zzez("Discarding data. Failed to send app launch");
                return;
            }
            try {
                zzc.zza(this.zzaUZ.zzAS().zzex(this.zzaUZ.zzzz().zzBs()));
                this.zzaUZ.zzjr();
            } catch (RemoteException e) {
                this.zzaUZ.zzzz().zzBl().zzj("Failed to send app launch to AppMeasurementService", e);
            }
        }
    }

    class C03987 implements ServiceConnection {
        final /* synthetic */ zzz zzaUZ;

        C03987(zzz com_google_android_gms_measurement_internal_zzz) {
            this.zzaUZ = com_google_android_gms_measurement_internal_zzz;
        }

        public void onServiceConnected(ComponentName name, IBinder binder) {
        }

        public void onServiceDisconnected(ComponentName name) {
        }
    }

    protected class zza implements ServiceConnection, ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzz zzaUZ;
        private volatile boolean zzaVa;
        private volatile zzn zzaVb;

        class C04024 implements Runnable {
            final /* synthetic */ zza zzaVd;

            C04024(zza com_google_android_gms_measurement_internal_zzz_zza) {
                this.zzaVd = com_google_android_gms_measurement_internal_zzz_zza;
            }

            public void run() {
                this.zzaVd.zzaUZ.onServiceDisconnected(new ComponentName(this.zzaVd.zzaUZ.getContext(), AppMeasurementService.class));
            }
        }

        protected zza(zzz com_google_android_gms_measurement_internal_zzz) {
            this.zzaUZ = com_google_android_gms_measurement_internal_zzz;
        }

        public void onConnected(Bundle connectionHint) {
            zzx.zzcx("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                this.zzaVa = false;
                try {
                    final zzl com_google_android_gms_measurement_internal_zzl = (zzl) this.zzaVb.zzqs();
                    this.zzaVb = null;
                    this.zzaUZ.zzAV().zzg(new Runnable(this) {
                        final /* synthetic */ zza zzaVd;

                        public void run() {
                            if (!this.zzaVd.zzaUZ.isConnected()) {
                                this.zzaVd.zzaUZ.zzzz().zzBq().zzez("Connected to remote service");
                                this.zzaVd.zzaUZ.zza(com_google_android_gms_measurement_internal_zzl);
                            }
                        }
                    });
                } catch (DeadObjectException e) {
                    this.zzaVb = null;
                } catch (IllegalStateException e2) {
                    this.zzaVb = null;
                }
            }
        }

        public void onConnectionFailed(ConnectionResult result) {
            zzx.zzcx("MeasurementServiceConnection.onConnectionFailed");
            this.zzaUZ.zzzz().zzBm().zzj("Service connection failed", result);
            synchronized (this) {
                this.zzaVa = false;
                this.zzaVb = null;
            }
        }

        public void onConnectionSuspended(int cause) {
            zzx.zzcx("MeasurementServiceConnection.onConnectionSuspended");
            this.zzaUZ.zzzz().zzBq().zzez("Service connection suspended");
            this.zzaUZ.zzAV().zzg(new C04024(this));
        }

        public void onServiceConnected(ComponentName name, IBinder binder) {
            zzx.zzcx("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                this.zzaVa = false;
                if (binder == null) {
                    this.zzaUZ.zzzz().zzBl().zzez("Service connected with null binder");
                    return;
                }
                zzl com_google_android_gms_measurement_internal_zzl = null;
                try {
                    String interfaceDescriptor = binder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        com_google_android_gms_measurement_internal_zzl = com.google.android.gms.measurement.internal.zzl.zza.zzdi(binder);
                        this.zzaUZ.zzzz().zzBr().zzez("Bound to IMeasurementService interface");
                    } else {
                        this.zzaUZ.zzzz().zzBl().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.zzaUZ.zzzz().zzBl().zzez("Service connect failed to get IMeasurementService");
                }
                if (com_google_android_gms_measurement_internal_zzl == null) {
                    try {
                        zzb.zzrz().zza(this.zzaUZ.getContext(), this.zzaUZ.zzaUS);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.zzaUZ.zzAV().zzg(new Runnable(this) {
                        final /* synthetic */ zza zzaVd;

                        public void run() {
                            if (!this.zzaVd.zzaUZ.isConnected()) {
                                this.zzaVd.zzaUZ.zzzz().zzBq().zzez("Connected to service");
                                this.zzaVd.zzaUZ.zza(com_google_android_gms_measurement_internal_zzl);
                            }
                        }
                    });
                }
            }
        }

        public void onServiceDisconnected(final ComponentName name) {
            zzx.zzcx("MeasurementServiceConnection.onServiceDisconnected");
            this.zzaUZ.zzzz().zzBq().zzez("Service disconnected");
            this.zzaUZ.zzAV().zzg(new Runnable(this) {
                final /* synthetic */ zza zzaVd;

                public void run() {
                    this.zzaVd.zzaUZ.onServiceDisconnected(name);
                }
            });
        }

        public void zzA(Intent intent) {
            this.zzaUZ.zziS();
            Context context = this.zzaUZ.getContext();
            zzb zzrz = zzb.zzrz();
            synchronized (this) {
                if (this.zzaVa) {
                    this.zzaUZ.zzzz().zzBr().zzez("Connection attempt already in progress");
                    return;
                }
                this.zzaVa = true;
                zzrz.zza(context, intent, this.zzaUZ.zzaUS, 129);
            }
        }

        public void zzCa() {
            this.zzaUZ.zziS();
            Context context = this.zzaUZ.getContext();
            synchronized (this) {
                if (this.zzaVa) {
                    this.zzaUZ.zzzz().zzBr().zzez("Connection attempt already in progress");
                } else if (this.zzaVb != null) {
                    this.zzaUZ.zzzz().zzBr().zzez("Already awaiting connection attempt");
                } else {
                    this.zzaVb = new zzn(context, Looper.getMainLooper(), zzf.zzas(context), this, this);
                    this.zzaUZ.zzzz().zzBr().zzez("Connecting to remote service");
                    this.zzaVa = true;
                    this.zzaVb.zzqp();
                }
            }
        }
    }

    protected zzz(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
        this.zzaUW = new zzaa(com_google_android_gms_measurement_internal_zzt.zziT());
        this.zzaUS = new zza(this);
        this.zzaUV = new zze(this, com_google_android_gms_measurement_internal_zzt) {
            final /* synthetic */ zzz zzaUZ;

            public void run() {
                this.zzaUZ.zzjs();
            }
        };
        this.zzaUY = new zze(this, com_google_android_gms_measurement_internal_zzt) {
            final /* synthetic */ zzz zzaUZ;

            public void run() {
                this.zzaUZ.zzzz().zzBm().zzez("Tasks have been queued for a long time");
            }
        };
    }

    private void onServiceDisconnected(ComponentName name) {
        zziS();
        if (this.zzaUT != null) {
            this.zzaUT = null;
            zzzz().zzBr().zzj("Disconnected from device MeasurementService", name);
            zzBY();
        }
    }

    private boolean zzBW() {
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent(getContext(), AppMeasurementService.class), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private boolean zzBX() {
        zziS();
        zzje();
        if (zzAX().zzka()) {
            return true;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.measurement.service.MeasurementBrokerService"));
        zzb zzrz = zzb.zzrz();
        zzzz().zzBr().zzez("Checking service availability");
        if (!zzrz.zza(getContext(), intent, new C03987(this), 0)) {
            return false;
        }
        zzzz().zzBr().zzez("Service available");
        return true;
    }

    private void zzBY() {
        zziS();
        zzjG();
    }

    private void zzBZ() {
        zziS();
        zzzz().zzBr().zzj("Processing queued up service tasks", Integer.valueOf(this.zzaUX.size()));
        for (Runnable zzg : this.zzaUX) {
            zzAV().zzg(zzg);
        }
        this.zzaUX.clear();
        this.zzaUY.cancel();
    }

    private void zza(zzl com_google_android_gms_measurement_internal_zzl) {
        zziS();
        zzx.zzy(com_google_android_gms_measurement_internal_zzl);
        this.zzaUT = com_google_android_gms_measurement_internal_zzl;
        zzjr();
        zzBZ();
    }

    private void zzi(Runnable runnable) throws IllegalStateException {
        zziS();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzaUX.size()) >= zzAX().zzAH()) {
            zzzz().zzBl().zzez("Discarding data. Max runnable queue size reached");
        } else {
            this.zzaUX.add(runnable);
            if (!this.zzaQX.zzBI()) {
                this.zzaUY.zzt(60000);
            }
            zzjG();
        }
    }

    private void zzjG() {
        zziS();
        zzje();
        if (!isConnected()) {
            if (this.zzaUU == null) {
                this.zzaUU = zzAW().zzBx();
                if (this.zzaUU == null) {
                    zzzz().zzBr().zzez("State of service unknown");
                    this.zzaUU = Boolean.valueOf(zzBX());
                    zzAW().zzap(this.zzaUU.booleanValue());
                }
            }
            if (this.zzaUU.booleanValue()) {
                zzzz().zzBr().zzez("Using measurement service");
                this.zzaUS.zzCa();
            } else if (zzBW() && !this.zzaQX.zzBI()) {
                zzzz().zzBr().zzez("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), AppMeasurementService.class));
                this.zzaUS.zzA(intent);
            } else if (zzAX().zzkb()) {
                zzzz().zzBr().zzez("Using direct local measurement implementation");
                zza(new zzu(this.zzaQX, true));
            } else {
                zzzz().zzBl().zzez("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    private void zzjr() {
        zziS();
        this.zzaUW.start();
        if (!this.zzaQX.zzBI()) {
            this.zzaUV.zzt(zzAX().zzkv());
        }
    }

    private void zzjs() {
        zziS();
        if (isConnected()) {
            zzzz().zzBr().zzez("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    public void disconnect() {
        zziS();
        zzje();
        try {
            zzb.zzrz().zza(getContext(), this.zzaUS);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.zzaUT = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public boolean isConnected() {
        zziS();
        zzje();
        return this.zzaUT != null;
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

    protected void zzBS() {
        zziS();
        zzje();
        zzi(new C03976(this));
    }

    protected void zzBV() {
        zziS();
        zzje();
        zzi(new C03943(this));
    }

    protected void zza(final UserAttributeParcel userAttributeParcel) {
        zziS();
        zzje();
        zzi(new Runnable(this) {
            final /* synthetic */ zzz zzaUZ;

            public void run() {
                zzl zzc = this.zzaUZ.zzaUT;
                if (zzc == null) {
                    this.zzaUZ.zzzz().zzBl().zzez("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    zzc.zza(userAttributeParcel, this.zzaUZ.zzAS().zzex(this.zzaUZ.zzzz().zzBs()));
                    this.zzaUZ.zzjr();
                } catch (RemoteException e) {
                    this.zzaUZ.zzzz().zzBl().zzj("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    protected void zzb(final EventParcel eventParcel, final String str) {
        zzx.zzy(eventParcel);
        zziS();
        zzje();
        zzi(new Runnable(this) {
            final /* synthetic */ zzz zzaUZ;

            public void run() {
                zzl zzc = this.zzaUZ.zzaUT;
                if (zzc == null) {
                    this.zzaUZ.zzzz().zzBl().zzez("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        zzc.zza(eventParcel, this.zzaUZ.zzAS().zzex(this.zzaUZ.zzzz().zzBs()));
                    } else {
                        zzc.zza(eventParcel, str, this.zzaUZ.zzzz().zzBs());
                    }
                    this.zzaUZ.zzjr();
                } catch (RemoteException e) {
                    this.zzaUZ.zzzz().zzBl().zzj("Failed to send event to AppMeasurementService", e);
                }
            }
        });
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
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
