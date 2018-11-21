package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.text.TextUtils;
import android.util.Log;

public abstract class GcmListenerService extends Service {
    private static boolean zzaIK = false;
    private int zzaII;
    private int zzaIJ = 0;
    private final Object zzpK = new Object();

    private void zzm(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.google.android.gms.gcm.PENDING_INTENT");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException e) {
                Log.e("GcmListenerService", "Notification pending intent canceled");
            }
        }
        zza.zzf(this, intent);
    }

    private void zzn(final Intent intent) {
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
                final /* synthetic */ GcmListenerService zzaIL;

                public void run() {
                    this.zzaIL.zzo(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ GcmListenerService zzaIL;

                protected /* synthetic */ Object doInBackground(Object[] x0) {
                    return zzb((Void[]) x0);
                }

                protected Void zzb(Void... voidArr) {
                    this.zzaIL.zzo(intent);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzo(android.content.Intent r4) {
        /*
        r3 = this;
        r1 = r4.getAction();	 Catch:{ all -> 0x004a }
        r0 = -1;
        r2 = r1.hashCode();	 Catch:{ all -> 0x004a }
        switch(r2) {
            case 214175003: goto L_0x003c;
            case 366519424: goto L_0x0032;
            default: goto L_0x000c;
        };	 Catch:{ all -> 0x004a }
    L_0x000c:
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x004f;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x004a }
    L_0x000f:
        r0 = "GcmListenerService";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004a }
        r1.<init>();	 Catch:{ all -> 0x004a }
        r2 = "Unknown intent action: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r2 = r4.getAction();	 Catch:{ all -> 0x004a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r1 = r1.toString();	 Catch:{ all -> 0x004a }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x004a }
    L_0x002b:
        r3.zzxv();	 Catch:{ all -> 0x004a }
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r4);
        return;
    L_0x0032:
        r2 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x000c;
    L_0x003a:
        r0 = 0;
        goto L_0x000c;
    L_0x003c:
        r2 = "com.google.android.gms.gcm.NOTIFICATION_DISMISS";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x000c;
    L_0x0044:
        r0 = 1;
        goto L_0x000c;
    L_0x0046:
        r3.zzp(r4);	 Catch:{ all -> 0x004a }
        goto L_0x002b;
    L_0x004a:
        r0 = move-exception;
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r4);
        throw r0;
    L_0x004f:
        com.google.android.gms.gcm.zza.zzg(r3, r4);	 Catch:{ all -> 0x004a }
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmListenerService.zzo(android.content.Intent):void");
    }

    private void zzp(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
        }
        Object obj = -1;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                    obj = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                    obj = null;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                    obj = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (zzr(intent)) {
                    zza.zze(this, intent);
                }
                zzq(intent);
                return;
            case 1:
                onDeletedMessages();
                return;
            case 2:
                onMessageSent(intent.getStringExtra("google.message_id"));
                return;
            case 3:
                onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
                return;
            default:
                Log.w("GcmListenerService", "Received message with unknown type: " + stringExtra);
                return;
        }
    }

    private void zzq(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (zzb.zzx(extras)) {
            if (zzb.zzaH(this)) {
                zzb.zzy(extras);
                if (zzr(intent)) {
                    zza.zzh(this, intent);
                }
            } else {
                zzb.zzc((Context) this, getClass()).zzz(extras);
                return;
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        onMessageReceived(string, extras);
    }

    static boolean zzr(Intent intent) {
        return zzaIK && !TextUtils.isEmpty(intent.getStringExtra("gcm.a.campaign"));
    }

    static boolean zzw(Bundle bundle) {
        return zzaIK && !TextUtils.isEmpty(bundle.getString("gcm.a.campaign"));
    }

    private void zzxv() {
        synchronized (this.zzpK) {
            this.zzaIJ--;
            if (this.zzaIJ == 0) {
                zzgU(this.zzaII);
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String from, Bundle data) {
    }

    public void onMessageSent(String msgId) {
    }

    public void onSendError(String msgId, String error) {
    }

    public final int onStartCommand(Intent intent, int flags, int startId) {
        synchronized (this.zzpK) {
            this.zzaII = startId;
            this.zzaIJ++;
        }
        if ("com.google.android.gms.gcm.NOTIFICATION_OPEN".equals(intent.getAction())) {
            zzm(intent);
            zzxv();
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        } else {
            zzn(intent);
        }
        return 3;
    }

    boolean zzgU(int i) {
        return stopSelfResult(i);
    }
}
