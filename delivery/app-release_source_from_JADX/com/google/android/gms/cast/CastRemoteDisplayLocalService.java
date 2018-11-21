package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService extends Service {
    private static final Object zzYA = new Object();
    private static AtomicBoolean zzYB = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzYQ;
    private static final zzl zzYy = new zzl("CastRemoteDisplayLocalService");
    private static final int zzYz = R.id.cast_notification_id;
    private Handler mHandler;
    private Notification mNotification;
    private String zzXW;
    private GoogleApiClient zzYC;
    private CastRemoteDisplaySessionCallbacks zzYD;
    private Callbacks zzYE;
    private zzb zzYF;
    private NotificationSettings zzYG;
    private boolean zzYH;
    private PendingIntent zzYI;
    private CastDevice zzYJ;
    private Display zzYK;
    private Context zzYL;
    private ServiceConnection zzYM;
    private MediaRouter zzYN;
    private boolean zzYO = false;
    private final Callback zzYP = new C02081(this);
    private final IBinder zzYR = new zza();

    class C02081 extends Callback {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        C02081(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            this.zzYS.zzbb("onRouteUnselected");
            if (this.zzYS.zzYJ == null) {
                this.zzYS.zzbb("onRouteUnselected, no device was selected");
            } else if (CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(this.zzYS.zzYJ.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                this.zzYS.zzbb("onRouteUnselected, device does not match");
            }
        }
    }

    class C02093 implements Runnable {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        C02093(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        public void run() {
            this.zzYS.zzbb("onCreate after delay. The local service been started: " + this.zzYS.zzYO);
            if (!this.zzYS.zzYO) {
                this.zzYS.zzbe("The local service has not been been started, stopping it");
                this.zzYS.stopSelf();
            }
        }
    }

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzYY;
        private String zzYZ;
        private String zzZa;

        public static final class Builder {
            private NotificationSettings zzZb = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzZb.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzZb.zzYZ)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzZb.zzZa)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzZb.zzYY != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzZb.zzYZ) && TextUtils.isEmpty(this.zzZb.zzZa) && this.zzZb.zzYY == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzZb;
            }

            public Builder setNotification(Notification notification) {
                this.zzZb.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzZb.zzYY = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzZb.zzZa = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzZb.zzYZ = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzYY = newSettings.zzYY;
            this.zzYZ = newSettings.zzYZ;
            this.zzZa = newSettings.zzZa;
        }
    }

    private class zza extends Binder {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        private zza(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        CastRemoteDisplayLocalService zznu() {
            return this.zzYS;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzYy.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    class C06372 implements OnConnectionFailedListener {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        C06372(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.zzYS.zzbe("Connection failed: " + connectionResult);
            this.zzYS.zznm();
        }
    }

    class C06387 implements CastRemoteDisplaySessionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        C06387(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        public void onRemoteDisplayEnded(Status status) {
            CastRemoteDisplayLocalService.zzYy.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
            CastRemoteDisplayLocalService.zzS(false);
        }
    }

    class C06398 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        C06398(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result x0) {
            zza((CastRemoteDisplaySessionResult) x0);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zza(com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult r6) {
            /*
            r5 = this;
            r4 = 0;
            r3 = 0;
            r0 = r6.getStatus();
            r0 = r0.isSuccess();
            if (r0 != 0) goto L_0x001d;
        L_0x000c:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYy;
            r1 = "Connection was not successful";
            r2 = new java.lang.Object[r3];
            r0.zzc(r1, r2);
            r0 = r5.zzYS;
            r0.zznm();
        L_0x001c:
            return;
        L_0x001d:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYy;
            r1 = "startRemoteDisplay successful";
            r2 = new java.lang.Object[r3];
            r0.zzb(r1, r2);
            r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYA;
            monitor-enter(r1);
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYQ;	 Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0049;
        L_0x0033:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYy;	 Catch:{ all -> 0x0046 }
            r2 = "Remote Display started but session already cancelled";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0046 }
            r0.zzb(r2, r3);	 Catch:{ all -> 0x0046 }
            r0 = r5.zzYS;	 Catch:{ all -> 0x0046 }
            r0.zznm();	 Catch:{ all -> 0x0046 }
            monitor-exit(r1);	 Catch:{ all -> 0x0046 }
            goto L_0x001c;
        L_0x0046:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            monitor-exit(r1);	 Catch:{ all -> 0x0046 }
            r0 = r6.getPresentationDisplay();
            if (r0 == 0) goto L_0x0086;
        L_0x0050:
            r1 = r5.zzYS;
            r1.zza(r0);
        L_0x0055:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYB;
            r0.set(r3);
            r0 = r5.zzYS;
            r0 = r0.zzYL;
            if (r0 == 0) goto L_0x001c;
        L_0x0064:
            r0 = r5.zzYS;
            r0 = r0.zzYM;
            if (r0 == 0) goto L_0x001c;
        L_0x006c:
            r0 = r5.zzYS;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r0 = r0.zzYL;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r1 = r5.zzYS;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r1 = r1.zzYM;	 Catch:{ IllegalArgumentException -> 0x0092 }
            r0.unbindService(r1);	 Catch:{ IllegalArgumentException -> 0x0092 }
        L_0x007b:
            r0 = r5.zzYS;
            r0.zzYM = r4;
            r0 = r5.zzYS;
            r0.zzYL = r4;
            goto L_0x001c;
        L_0x0086:
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYy;
            r1 = "Cast Remote Display session created without display";
            r2 = new java.lang.Object[r3];
            r0.zzc(r1, r2);
            goto L_0x0055;
        L_0x0092:
            r0 = move-exception;
            r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzYy;
            r1 = "No need to unbind service, already unbound";
            r2 = new java.lang.Object[r3];
            r0.zzb(r1, r2);
            goto L_0x007b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.8.zza(com.google.android.gms.cast.CastRemoteDisplay$CastRemoteDisplaySessionResult):void");
        }
    }

    class C06409 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzYS;

        C06409(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzYS = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result x0) {
            zza((CastRemoteDisplaySessionResult) x0);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                this.zzYS.zzbb("remote display stopped");
            } else {
                this.zzYS.zzbb("Unable to stop the remote display, result unsuccessful");
            }
            this.zzYS.zzYK = null;
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzYA) {
            castRemoteDisplayLocalService = zzYQ;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzYy.zzY(true);
    }

    public static void startService(Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, String applicationId, CastDevice device, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzYy.zzb("Starting Service", new Object[0]);
        synchronized (zzYA) {
            if (zzYQ != null) {
                zzYy.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzS(true);
            }
        }
        zzb(activityContext, (Class) serviceClass);
        zzx.zzb((Object) activityContext, (Object) "activityContext is required.");
        zzx.zzb((Object) serviceClass, (Object) "serviceClass is required.");
        zzx.zzb((Object) applicationId, (Object) "applicationId is required.");
        zzx.zzb((Object) device, (Object) "device is required.");
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb((Object) callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzYY == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzYB.getAndSet(true)) {
            zzYy.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            final String str = applicationId;
            final CastDevice castDevice = device;
            final NotificationSettings notificationSettings2 = notificationSettings;
            final Context context = activityContext;
            final Callbacks callbacks2 = callbacks;
            activityContext.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName className, IBinder binder) {
                    CastRemoteDisplayLocalService zznu = ((zza) binder).zznu();
                    if (zznu == null || !zznu.zza(str, castDevice, notificationSettings2, context, this, callbacks2)) {
                        CastRemoteDisplayLocalService.zzYy.zzc("Connected but unable to get the service instance", new Object[0]);
                        callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                        CastRemoteDisplayLocalService.zzYB.set(false);
                        try {
                            context.unbindService(this);
                        } catch (IllegalArgumentException e) {
                            CastRemoteDisplayLocalService.zzYy.zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                    }
                }

                public void onServiceDisconnected(ComponentName arg0) {
                    CastRemoteDisplayLocalService.zzYy.zzb("onServiceDisconnected", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzYB.set(false);
                    try {
                        context.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzYy.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }
            }, 64);
        }
    }

    public static void stopService() {
        zzS(false);
    }

    private void zzQ(final boolean z) {
        if (this.mHandler == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ CastRemoteDisplayLocalService zzYS;

                public void run() {
                    this.zzYS.zzR(z);
                }
            });
        } else {
            zzR(z);
        }
    }

    private void zzR(boolean z) {
        zzbb("Stopping Service");
        zzx.zzcx("stopServiceInstanceInternal must be called on the main thread");
        if (!(z || this.zzYN == null)) {
            zzbb("Setting default route");
            this.zzYN.selectRoute(this.zzYN.getDefaultRoute());
        }
        if (this.zzYF != null) {
            zzbb("Unregistering notification receiver");
            unregisterReceiver(this.zzYF);
        }
        zznn();
        zzno();
        zznj();
        if (this.zzYC != null) {
            this.zzYC.disconnect();
            this.zzYC = null;
        }
        if (!(this.zzYL == null || this.zzYM == null)) {
            try {
                this.zzYL.unbindService(this.zzYM);
            } catch (IllegalArgumentException e) {
                zzbb("No need to unbind service, already unbound");
            }
            this.zzYM = null;
            this.zzYL = null;
        }
        this.zzXW = null;
        this.zzYC = null;
        this.mNotification = null;
        this.zzYK = null;
    }

    private static void zzS(boolean z) {
        zzYy.zzb("Stopping Service", new Object[0]);
        zzYB.set(false);
        synchronized (zzYA) {
            if (zzYQ == null) {
                zzYy.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzYQ;
            zzYQ = null;
            castRemoteDisplayLocalService.zzQ(z);
        }
    }

    private Notification zzT(boolean z) {
        int i;
        int i2;
        CharSequence string;
        zzbb("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        CharSequence zzc = this.zzYG.zzYZ;
        CharSequence zzd = this.zzYG.zzZa;
        if (z) {
            i = R.string.cast_notification_connected_message;
            i2 = R.drawable.cast_ic_notification_on;
        } else {
            i = R.string.cast_notification_connecting_message;
            i2 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzc)) {
            zzc = getString(i3);
        }
        if (TextUtils.isEmpty(zzd)) {
            string = getString(i, new Object[]{this.zzYJ.getFriendlyName()});
        } else {
            string = zzd;
        }
        return new Builder(this).setContentTitle(zzc).setContentText(string).setContentIntent(this.zzYG.zzYY).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(R.string.cast_notification_disconnect), zznp()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new ConnectionCallbacks(this) {
            final /* synthetic */ CastRemoteDisplayLocalService zzYS;

            {
                this.zzYS = r1;
            }

            public void onConnected(Bundle bundle) {
                this.zzYS.zzbb("onConnected");
                this.zzYS.zznk();
            }

            public void onConnectionSuspended(int cause) {
                CastRemoteDisplayLocalService.zzYy.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(cause)}), new Object[0]);
            }
        }, new C06372(this)).addApi(CastRemoteDisplay.API, new CastRemoteDisplayOptions.Builder(castDevice, this.zzYD).build()).build();
    }

    private void zza(Display display) {
        this.zzYK = display;
        if (this.zzYH) {
            this.mNotification = zzT(true);
            startForeground(zzYz, this.mNotification);
        }
        if (this.zzYE != null) {
            this.zzYE.onRemoteDisplaySessionStarted(this);
            this.zzYE = null;
        }
        onCreatePresentation(this.zzYK);
    }

    private void zza(NotificationSettings notificationSettings) {
        zzx.zzcx("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzYG == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzYH) {
            zzx.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzYG.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzYY != null) {
                this.zzYG.zzYY = notificationSettings.zzYY;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzYZ)) {
                this.zzYG.zzYZ = notificationSettings.zzYZ;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzZa)) {
                this.zzYG.zzZa = notificationSettings.zzZa;
            }
            this.mNotification = zzT(true);
        }
        startForeground(zzYz, this.mNotification);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean zza(java.lang.String r8, com.google.android.gms.cast.CastDevice r9, com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings r10, android.content.Context r11, android.content.ServiceConnection r12, com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks r13) {
        /*
        r7 = this;
        r6 = 0;
        r1 = 1;
        r0 = 0;
        r2 = "startRemoteDisplaySession";
        r7.zzbb(r2);
        r2 = "Starting the Cast Remote Display must be done on the main thread";
        com.google.android.gms.common.internal.zzx.zzcx(r2);
        r2 = zzYA;
        monitor-enter(r2);
        r3 = zzYQ;	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0020;
    L_0x0014:
        r1 = zzYy;	 Catch:{ all -> 0x00ac }
        r3 = "An existing service had not been stopped before starting one";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ac }
        r1.zzf(r3, r4);	 Catch:{ all -> 0x00ac }
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
    L_0x001f:
        return r0;
    L_0x0020:
        zzYQ = r7;	 Catch:{ all -> 0x00ac }
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
        r7.zzYE = r13;
        r7.zzXW = r8;
        r7.zzYJ = r9;
        r7.zzYL = r11;
        r7.zzYM = r12;
        r2 = r7.getApplicationContext();
        r2 = android.support.v7.media.MediaRouter.getInstance(r2);
        r7.zzYN = r2;
        r2 = new android.support.v7.media.MediaRouteSelector$Builder;
        r2.<init>();
        r3 = r7.zzXW;
        r3 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r3);
        r2 = r2.addControlCategory(r3);
        r2 = r2.build();
        r3 = "addMediaRouterCallback";
        r7.zzbb(r3);
        r3 = r7.zzYN;
        r4 = r7.zzYP;
        r5 = 4;
        r3.addCallback(r2, r4, r5);
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$7;
        r2.<init>(r7);
        r7.zzYD = r2;
        r2 = r10.mNotification;
        r7.mNotification = r2;
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb;
        r2.<init>();
        r7.zzYF = r2;
        r2 = r7.zzYF;
        r3 = new android.content.IntentFilter;
        r4 = "com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT";
        r3.<init>(r4);
        r7.registerReceiver(r2, r3);
        r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings;
        r2.<init>(r10);
        r7.zzYG = r2;
        r2 = r7.zzYG;
        r2 = r2.mNotification;
        if (r2 != 0) goto L_0x00af;
    L_0x0086:
        r7.zzYH = r1;
        r0 = r7.zzT(r0);
        r7.mNotification = r0;
    L_0x008e:
        r0 = zzYz;
        r2 = r7.mNotification;
        r7.startForeground(r0, r2);
        r0 = r7.zza(r9);
        r7.zzYC = r0;
        r0 = r7.zzYC;
        r0.connect();
        r0 = r7.zzYE;
        if (r0 == 0) goto L_0x00a9;
    L_0x00a4:
        r0 = r7.zzYE;
        r0.onServiceCreated(r7);
    L_0x00a9:
        r0 = r1;
        goto L_0x001f;
    L_0x00ac:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
        throw r0;
    L_0x00af:
        r7.zzYH = r0;
        r0 = r7.zzYG;
        r0 = r0.mNotification;
        r7.mNotification = r0;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zza(java.lang.String, com.google.android.gms.cast.CastDevice, com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings, android.content.Context, android.content.ServiceConnection, com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks):boolean");
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zzbb(String str) {
        zzYy.zzb("[Instance: %s] %s", this, str);
    }

    private void zzbe(String str) {
        zzYy.zzc("[Instance: %s] %s", this, str);
    }

    private void zznj() {
        if (this.zzYN != null) {
            zzx.zzcx("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbb("removeMediaRouterCallback");
            this.zzYN.removeCallback(this.zzYP);
        }
    }

    private void zznk() {
        zzbb("startRemoteDisplay");
        if (this.zzYC == null || !this.zzYC.isConnected()) {
            zzYy.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzYC, this.zzXW).setResultCallback(new C06398(this));
        }
    }

    private void zznl() {
        zzbb("stopRemoteDisplay");
        if (this.zzYC == null || !this.zzYC.isConnected()) {
            zzYy.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzYC).setResultCallback(new C06409(this));
        }
    }

    private void zznm() {
        if (this.zzYE != null) {
            this.zzYE.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzYE = null;
        }
        stopService();
    }

    private void zznn() {
        zzbb("stopRemoteDisplaySession");
        zznl();
        onDismissPresentation();
    }

    private void zzno() {
        zzbb("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zznp() {
        if (this.zzYI == null) {
            this.zzYI = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzYI;
    }

    protected Display getDisplay() {
        return this.zzYK;
    }

    public IBinder onBind(Intent intent) {
        zzbb("onBind");
        return this.zzYR;
    }

    public void onCreate() {
        zzbb("onCreate");
        super.onCreate();
        this.mHandler = new Handler(getMainLooper());
        this.mHandler.postDelayed(new C02093(this), 100);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzbb("onStartCommand");
        this.zzYO = true;
        return 2;
    }

    public void updateNotificationSettings(final NotificationSettings notificationSettings) {
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb(this.mHandler, (Object) "Service is not ready yet.");
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ CastRemoteDisplayLocalService zzYS;

            public void run() {
                this.zzYS.zza(notificationSettings);
            }
        });
    }
}
