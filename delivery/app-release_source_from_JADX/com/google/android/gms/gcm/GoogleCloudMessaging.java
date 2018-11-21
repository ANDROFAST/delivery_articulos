package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    public static int zzaIY = 5000000;
    public static int zzaIZ = 6500000;
    public static int zzaJa = 7000000;
    static GoogleCloudMessaging zzaJb;
    private static final AtomicInteger zzaJe = new AtomicInteger(1);
    private Context context;
    private PendingIntent zzaJc;
    private Map<String, Handler> zzaJd = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue<Intent> zzaJf = new LinkedBlockingQueue();
    final Messenger zzaJg = new Messenger(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ GoogleCloudMessaging zzaJh;

        public void handleMessage(Message msg) {
            if (msg == null || !(msg.obj instanceof Intent)) {
                Log.w(GoogleCloudMessaging.INSTANCE_ID_SCOPE, "Dropping invalid message");
            }
            Intent intent = (Intent) msg.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                this.zzaJh.zzaJf.add(intent);
            } else if (!this.zzaJh.zzs(intent)) {
                intent.setPackage(this.zzaJh.context.getPackageName());
                this.zzaJh.context.sendBroadcast(intent);
            }
        }
    });

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (zzaJb == null) {
                zzaJb = new GoogleCloudMessaging();
                zzaJb.context = context.getApplicationContext();
            }
            googleCloudMessaging = zzaJb;
        }
        return googleCloudMessaging;
    }

    static String zza(Intent intent, String str) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private void zza(String str, String str2, long j, int i, Bundle bundle) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zzt(intent);
        intent.setPackage(zzaI(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        if (zzaI(this.context).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            InstanceID.getInstance(this.context).zzc(INSTANCE_ID_SCOPE, "upstream", bundle2);
            return;
        }
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public static String zzaI(Context context) {
        return zzc.zzaM(context);
    }

    public static int zzaJ(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzaI(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private boolean zzs(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.zzaJd.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    private String zzxy() {
        return "google.rpc" + String.valueOf(zzaJe.getAndIncrement());
    }

    public void close() {
        zzaJb = null;
        zzb.zzaIN = null;
        zzxz();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    @Deprecated
    public synchronized String register(String... senderIds) throws IOException {
        String zzc;
        zzc = zzc(senderIds);
        Bundle bundle = new Bundle();
        if (zzaI(this.context).contains(".gsf")) {
            bundle.putString("legacy.sender", zzc);
            zzc = InstanceID.getInstance(this.context).getToken(zzc, INSTANCE_ID_SCOPE, bundle);
        } else {
            bundle.putString("sender", zzc);
            zzc = zza(zzD(bundle), "registration_id");
        }
        return zzc;
    }

    public void send(String to, String msgId, long timeToLive, Bundle data) throws IOException {
        zza(to, msgId, timeToLive, -1, data);
    }

    public void send(String to, String msgId, Bundle data) throws IOException {
        send(to, msgId, -1, data);
    }

    @Deprecated
    public synchronized void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        InstanceID.getInstance(this.context).deleteInstanceID();
    }

    @Deprecated
    Intent zzD(Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (zzaJ(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaI(this.context));
            zzt(intent);
            intent.putExtra("google.message_id", zzxy());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.zzaJg);
            this.context.startService(intent);
            try {
                return (Intent) this.zzaJf.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    String zzc(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    synchronized void zzt(Intent intent) {
        if (this.zzaJc == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaJc = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzaJc);
    }

    synchronized void zzxz() {
        if (this.zzaJc != null) {
            this.zzaJc.cancel();
            this.zzaJc = null;
        }
    }
}
