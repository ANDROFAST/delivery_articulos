package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzc {
    static String zzaKt = null;
    static int zzaKu = 0;
    static int zzaKv = 0;
    static int zzaKw = 0;
    Context context;
    PendingIntent zzaJc;
    Messenger zzaJg;
    long zzaKA;
    long zzaKB;
    int zzaKC;
    int zzaKD;
    long zzaKE;
    Map<String, Object> zzaKx = new HashMap();
    Messenger zzaKy;
    MessengerCompat zzaKz;

    public zzc(Context context) {
        this.context = context;
    }

    private void zzD(Object obj) {
        synchronized (getClass()) {
            for (String str : this.zzaKx.keySet()) {
                Object obj2 = this.zzaKx.get(str);
                this.zzaKx.put(str, obj);
                zzg(obj2, obj);
            }
        }
    }

    static String zza(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = InstanceID.zzn(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    public static String zzaM(Context context) {
        if (zzaKt != null) {
            return zzaKt;
        }
        zzaKu = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    zzaKv = applicationInfo.uid;
                    zzaKt = resolveInfo.serviceInfo.packageName;
                    return zzaKt;
                } catch (NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares " + "com.google.android.c2dm.intent.REGISTER" + " without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            zzaKt = applicationInfo2.packageName;
            zzaKv = applicationInfo2.uid;
            return zzaKt;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                zzaKt = applicationInfo2.packageName;
                zzaKv = applicationInfo2.uid;
                return zzaKt;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    private Intent zzb(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzxT = zzxT();
        synchronized (getClass()) {
            this.zzaKx.put(zzxT, conditionVariable);
        }
        zza(bundle, keyPair, zzxT);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.zzaKx.remove(zzxT);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                Log.w("InstanceID/Rpc", "No response " + remove);
                throw new IOException(InstanceID.ERROR_TIMEOUT);
            }
        }
        return intent;
    }

    private void zzdK(String str) {
        if ("com.google.android.gsf".equals(zzaKt)) {
            this.zzaKC++;
            if (this.zzaKC >= 3) {
                if (this.zzaKC == 3) {
                    this.zzaKD = new Random().nextInt(1000) + 1000;
                }
                this.zzaKD *= 2;
                this.zzaKE = SystemClock.elapsedRealtime() + ((long) this.zzaKD);
                Log.w("InstanceID/Rpc", "Backoff due to " + str + " for " + this.zzaKD);
            }
        }
    }

    private void zzg(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void zzi(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzaKx.get(str);
            this.zzaKx.put(str, obj);
            zzg(obj2, obj);
        }
    }

    public static synchronized String zzxT() {
        String num;
        synchronized (zzc.class) {
            int i = zzaKw;
            zzaKw = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent zza(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent zzb = zzb(bundle, keyPair);
        return (zzb == null || !zzb.hasExtra("google.messenger")) ? zzb : zzb(bundle, keyPair);
    }

    void zza(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzaKE == 0 || elapsedRealtime > this.zzaKE) {
            zzxS();
            if (zzaKt == null) {
                throw new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
            }
            this.zzaKA = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaKt);
            bundle.putString("gmsv", Integer.toString(GoogleCloudMessaging.zzaJ(this.context)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(InstanceID.zzaK(this.context)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", InstanceID.zza(keyPair));
            bundle.putString("pub2", InstanceID.zzn(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", zza(keyPair, this.context.getPackageName(), r1));
            intent.putExtras(bundle);
            zzu(intent);
            zzb(intent, str);
            return;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.zzaKE - elapsedRealtime) + " interval: " + this.zzaKD);
        throw new IOException(InstanceID.ERROR_BACKOFF);
    }

    protected void zzb(Intent intent, String str) {
        this.zzaKA = SystemClock.elapsedRealtime();
        intent.putExtra("kid", "|ID|" + str + "|");
        intent.putExtra("X-kid", "|ID|" + str + "|");
        boolean equals = "com.google.android.gsf".equals(zzaKt);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Sending " + intent.getExtras());
        }
        if (this.zzaKy != null) {
            intent.putExtra("google.messenger", this.zzaJg);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.zzaKy.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.context.getPackageName());
            intent2.putExtra("GSF", intent);
            this.context.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.zzaJg);
        intent.putExtra("messenger2", "1");
        if (this.zzaKz != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.zzaKz.send(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.context.startService(intent);
    }

    public void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzaKz = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzaKy = (Messenger) parcelableExtra;
                    }
                }
                zzx((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    synchronized void zzu(Intent intent) {
        if (this.zzaJc == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaJc = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzaJc);
    }

    String zzv(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            if (stringExtra == null) {
                return stringExtra;
            }
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                throw new IOException(stringExtra);
            }
            Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } else if (stringExtra == null) {
            return stringExtra;
        } else {
            stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException(stringExtra);
        }
    }

    void zzw(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
        }
        String str = null;
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
            }
            if (split.length > 2) {
                str = split[2];
                stringExtra = split[3];
                if (stringExtra.startsWith(":")) {
                    stringExtra = stringExtra.substring(1);
                }
            } else {
                stringExtra = "UNKNOWN";
            }
            intent.putExtra("error", stringExtra);
        }
        if (str == null) {
            zzD(stringExtra);
        } else {
            zzi(str, stringExtra);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.zzaKB = SystemClock.elapsedRealtime();
            this.zzaKD = ((int) longExtra) * 1000;
            this.zzaKE = SystemClock.elapsedRealtime() + ((long) this.zzaKD);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.zzaKD);
        } else if ("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) {
            zzdK(stringExtra);
        }
    }

    void zzx(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                action = intent.getStringExtra("registration_id");
                String stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
                if (stringExtra == null) {
                    zzw(intent);
                    return;
                }
                this.zzaKA = SystemClock.elapsedRealtime();
                this.zzaKE = 0;
                this.zzaKC = 0;
                this.zzaKD = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "AppIDResponse: " + stringExtra + " " + intent.getExtras());
                }
                action = null;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
                    }
                    stringExtra = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            InstanceIDListenerService.zzaL(this.context);
                        } else if ("RST".equals(split[3])) {
                            InstanceIDListenerService.zza(this.context, InstanceID.getInstance(this.context).zzxP());
                            intent.removeExtra("registration_id");
                            zzi(stringExtra, intent);
                            return;
                        }
                    }
                    action = split[split.length - 1];
                    if (action.startsWith(":")) {
                        action = action.substring(1);
                    }
                    intent.putExtra("registration_id", action);
                    action = stringExtra;
                }
                if (action == null) {
                    zzD(intent);
                } else {
                    zzi(action, intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }

    void zzxS() {
        if (this.zzaJg == null) {
            zzaM(this.context);
            this.zzaJg = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ zzc zzaKF;

                public void handleMessage(Message msg) {
                    this.zzaKF.zze(msg);
                }
            });
        }
    }
}
