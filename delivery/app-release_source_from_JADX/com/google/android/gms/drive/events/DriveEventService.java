package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzaiR;
    private CountDownLatch zzanP;
    zza zzanQ;
    boolean zzanR;

    final class zza extends Handler {
        final /* synthetic */ DriveEventService zzanT;

        zza(DriveEventService driveEventService) {
            this.zzanT = driveEventService;
        }

        private Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message zzsz() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            zzz.zzz("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    this.zzanT.zza((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    zzz.zzA("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzao.zza {
        final /* synthetic */ DriveEventService zzanT;

        zzb(DriveEventService driveEventService) {
            this.zzanT = driveEventService;
        }

        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.zzanT) {
                zzz.zzz("DriveEventService", "onEvent: " + onEventResponse);
                this.zzanT.zzsy();
                if (this.zzanT.zzanQ != null) {
                    this.zzanT.zzanQ.sendMessage(this.zzanT.zzanQ.zzb(onEventResponse));
                } else {
                    zzz.zzB("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.zzanR = false;
        this.zzaiR = -1;
        this.mName = name;
    }

    private void zza(OnEventResponse onEventResponse) {
        DriveEvent zzsT = onEventResponse.zzsT();
        zzz.zzz("DriveEventService", "handleEventMessage: " + zzsT);
        try {
            switch (zzsT.getType()) {
                case 1:
                    onChange((ChangeEvent) zzsT);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzsT);
                    return;
                case 4:
                    zza((ChangesAvailableEvent) zzsT);
                    return;
                default:
                    zzz.zzA(this.mName, "Unhandled event: " + zzsT);
                    return;
            }
        } catch (Throwable e) {
            zzz.zza(this.mName, e, "Error handling event: " + zzsT);
        }
        zzz.zza(this.mName, e, "Error handling event: " + zzsT);
    }

    private void zzsy() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzaiR) {
            if (GooglePlayServicesUtil.zze(this, callingUid)) {
                this.zzaiR = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzanQ == null && !this.zzanR) {
                this.zzanR = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzanP = new CountDownLatch(1);
                new Thread(this) {
                    final /* synthetic */ DriveEventService zzanT;

                    public void run() {
                        try {
                            Looper.prepare();
                            this.zzanT.zzanQ = new zza(this.zzanT);
                            this.zzanT.zzanR = false;
                            countDownLatch.countDown();
                            zzz.zzz("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            zzz.zzz("DriveEventService", "Finished loop");
                        } finally {
                            if (this.zzanT.zzanP != null) {
                                this.zzanT.zzanP.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzz.zzB("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new zzb(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent event) {
        zzz.zzA(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        zzz.zzA(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        zzz.zzz("DriveEventService", "onDestroy");
        if (this.zzanQ != null) {
            this.zzanQ.sendMessage(this.zzanQ.zzsz());
            this.zzanQ = null;
            try {
                if (!this.zzanP.await(5000, TimeUnit.MILLISECONDS)) {
                    zzz.zzA("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzanP = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzz.zzA(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }
}
