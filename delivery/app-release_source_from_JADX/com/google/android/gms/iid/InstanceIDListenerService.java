package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String zzaIT = "gcm.googleapis.com/refresh";
    private static String zzaKl = "google.com/iid";
    private static String zzaKm = "CMD";
    MessengerCompat zzaKj = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ InstanceIDListenerService zzaKp;

        public void handleMessage(Message msg) {
            this.zzaKp.zza(msg, MessengerCompat.zzc(msg));
        }
    });
    BroadcastReceiver zzaKk = new C02592(this);
    int zzaKn;
    int zzaKo;

    class C02592 extends BroadcastReceiver {
        final /* synthetic */ InstanceIDListenerService zzaKp;

        C02592(InstanceIDListenerService instanceIDListenerService) {
            this.zzaKp = instanceIDListenerService;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            this.zzaKp.zzp(intent);
            this.zzaKp.stop();
        }
    }

    static void zza(Context context, zzd com_google_android_gms_iid_zzd) {
        com_google_android_gms_iid_zzd.zzxU();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzaKm, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    private void zza(Message message, int i) {
        zzc.zzaM(this);
        getPackageManager();
        if (i == zzc.zzaKv || i == zzc.zzaKu) {
            zzp((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaKu + " appid=" + zzc.zzaKv);
        }
    }

    static void zzaL(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzaKm, "SYNC");
        context.startService(intent);
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.zzaKj.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzaKk, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.zzaKk);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzhc(startId);
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                zzp(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    public void onTokenRefresh() {
    }

    void stop() {
        synchronized (this) {
            this.zzaKn--;
            if (this.zzaKn == 0) {
                stopSelf(this.zzaKo);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzaKn + " " + this.zzaKo);
            }
        }
    }

    public void zzah(boolean z) {
        onTokenRefresh();
    }

    void zzhc(int i) {
        synchronized (this) {
            this.zzaKn++;
            if (i > this.zzaKo) {
                this.zzaKo = i;
            }
        }
    }

    public void zzp(Intent intent) {
        InstanceID instance;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            instance = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            instance = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzaKm);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd zzxP = instance.zzxP();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                zzxP.zzdP(stringExtra);
                instance.zzxQ().zzx(intent);
                return;
            } else if (zzaIT.equals(intent.getStringExtra("from"))) {
                instance.zzxP().zzdP(stringExtra);
                zzah(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                instance.zzxO();
                zzah(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!instance.zzxP().isEmpty()) {
                    instance.zzxP().zzxU();
                    zzah(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                instance.zzxP().zzdP(stringExtra);
                zzah(false);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    GoogleCloudMessaging.getInstance(this).send(zzaKl, zzc.zzxT(), 0, intent.getExtras());
                    return;
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Register result in service " + stringExtra);
        }
        instance.zzxQ().zzx(intent);
    }
}
