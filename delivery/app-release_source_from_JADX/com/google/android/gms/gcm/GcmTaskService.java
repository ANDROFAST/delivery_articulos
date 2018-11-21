package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private final Set<String> zzaIU = new HashSet();
    private int zzaIV;

    private class zza extends Thread {
        private final Bundle mExtras;
        private final String mTag;
        private final zzc zzaIW;
        final /* synthetic */ GcmTaskService zzaIX;

        zza(GcmTaskService gcmTaskService, String str, IBinder iBinder, Bundle bundle) {
            this.zzaIX = gcmTaskService;
            this.mTag = str;
            this.zzaIW = com.google.android.gms.gcm.zzc.zza.zzbZ(iBinder);
            this.mExtras = bundle;
        }

        public void run() {
            Process.setThreadPriority(10);
            try {
                this.zzaIW.zzgV(this.zzaIX.onRunTask(new TaskParams(this.mTag, this.mExtras)));
            } catch (RemoteException e) {
                Log.e("GcmTaskService", "Error reporting result of operation to scheduler for " + this.mTag);
            } finally {
                this.zzaIX.zzdJ(this.mTag);
            }
        }
    }

    private void zzdJ(String str) {
        synchronized (this.zzaIU) {
            this.zzaIU.remove(str);
            if (this.zzaIU.size() == 0) {
                stopSelf(this.zzaIV);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    public int onStartCommand(Intent intent, int flags, int startId) {
        intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        if (SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("tag");
            Parcelable parcelableExtra = intent.getParcelableExtra("callback");
            Bundle bundle = (Bundle) intent.getParcelableExtra("extras");
            if (parcelableExtra == null || !(parcelableExtra instanceof PendingCallback)) {
                Log.e("GcmTaskService", getPackageName() + " " + stringExtra + ": Could not process request, invalid callback.");
            } else {
                synchronized (this.zzaIU) {
                    this.zzaIU.add(stringExtra);
                    stopSelf(this.zzaIV);
                    this.zzaIV = startId;
                }
                new zza(this, stringExtra, ((PendingCallback) parcelableExtra).getIBinder(), bundle).start();
            }
        } else if (SERVICE_ACTION_INITIALIZE.equals(intent.getAction())) {
            onInitializeTasks();
            synchronized (this.zzaIU) {
                this.zzaIV = startId;
                if (this.zzaIU.size() == 0) {
                    stopSelf(this.zzaIV);
                }
            }
        }
        return 2;
    }
}
