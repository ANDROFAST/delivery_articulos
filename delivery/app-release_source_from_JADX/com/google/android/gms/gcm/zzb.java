package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

class zzb {
    static zzb zzaIN;
    private final Context mContext;
    private final Class<? extends GcmListenerService> zzaIO;

    private class zza extends IllegalArgumentException {
        final /* synthetic */ zzb zzaIP;

        private zza(zzb com_google_android_gms_gcm_zzb, String str) {
            this.zzaIP = com_google_android_gms_gcm_zzb;
            super(str);
        }
    }

    private zzb(Context context, Class<? extends GcmListenerService> cls) {
        this.mContext = context.getApplicationContext();
        this.zzaIO = cls;
    }

    private Notification zzA(Bundle bundle) {
        PendingIntent pendingIntent = null;
        CharSequence zzd = zzd(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(zzd)) {
            throw new zza("Missing title");
        }
        CharSequence zzd2 = zzd(bundle, "gcm.n.body");
        int zzdH = zzdH(zzc(bundle, "gcm.n.icon"));
        Object zzc = zzc(bundle, "gcm.n.color");
        Uri zzdI = zzdI(zzc(bundle, "gcm.n.sound"));
        PendingIntent zzB = zzB(bundle);
        if (GcmListenerService.zzw(bundle)) {
            zzB = zza(bundle, zzB);
            pendingIntent = zzC(bundle);
        }
        Builder contentText = new Builder(this.mContext).setAutoCancel(true).setSmallIcon(zzdH).setContentTitle(zzd).setContentText(zzd2);
        if (!TextUtils.isEmpty(zzc)) {
            contentText.setColor(Color.parseColor(zzc));
        }
        if (zzdI != null) {
            contentText.setSound(zzdI);
        }
        if (zzB != null) {
            contentText.setContentIntent(zzB);
        }
        if (pendingIntent != null) {
            contentText.setDeleteIntent(pendingIntent);
        }
        return contentText.build();
    }

    private PendingIntent zzB(Bundle bundle) {
        Object zzc = zzc(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(zzc)) {
            return null;
        }
        Intent intent = new Intent(zzc);
        intent.setPackage(this.mContext.getPackageName());
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtras(bundle);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, zzxx(), intent, 1073741824);
    }

    private PendingIntent zzC(Bundle bundle) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
        zza(intent, bundle);
        return PendingIntent.getService(this.mContext, zzxx(), intent, 1073741824);
    }

    private PendingIntent zza(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
        zza(intent, bundle);
        intent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", pendingIntent);
        return PendingIntent.getService(this.mContext, zzxx(), intent, 1073741824);
    }

    private void zza(Intent intent, Bundle bundle) {
        intent.setClass(this.mContext, this.zzaIO);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void zza(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean zzaH(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    static synchronized zzb zzc(Context context, Class<? extends GcmListenerService> cls) {
        zzb com_google_android_gms_gcm_zzb;
        synchronized (zzb.class) {
            if (zzaIN == null) {
                zzaIN = new zzb(context, cls);
            }
            com_google_android_gms_gcm_zzb = zzaIN;
        }
        return com_google_android_gms_gcm_zzb;
    }

    static String zzc(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String zzd(Bundle bundle, String str) {
        Object zzc = zzc(bundle, str);
        if (!TextUtils.isEmpty(zzc)) {
            return zzc;
        }
        String zzc2 = zzc(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(zzc2)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(zzc2, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            throw new zza(zzdG(str + "_loc_key") + " resource not found: " + zzc2);
        }
        String zzc3 = zzc(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(zzc3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(zzc3);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            try {
                return resources.getString(identifier, strArr);
            } catch (MissingFormatArgumentException e) {
                throw new zza("Missing format argument for " + zzc2 + ": " + e);
            }
        } catch (JSONException e2) {
            throw new zza("Malformed " + zzdG(str + "_loc_args") + ": " + zzc3);
        }
    }

    private String zzdG(String str) {
        return str.substring("gcm.n.".length());
    }

    private int zzdH(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new zza("Missing icon");
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(str, "drawable", this.mContext.getPackageName());
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, "mipmap", this.mContext.getPackageName());
            if (identifier == 0) {
                throw new zza("Icon resource not found: " + str);
            }
        }
        return identifier;
    }

    private Uri zzdI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str)) {
            return RingtoneManager.getDefaultUri(2);
        }
        throw new zza("Invalid sound: " + str);
    }

    static boolean zzx(Bundle bundle) {
        return zzc(bundle, "gcm.n.icon") != null;
    }

    private int zzxx() {
        return (int) SystemClock.uptimeMillis();
    }

    static void zzy(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("gcm.n.")) {
                bundle2.putString(str.substring("gcm.n.".length()), bundle.getString(str));
                it.remove();
            } else if (str.startsWith("gcm.notification.")) {
                bundle2.putString(str.substring("gcm.notification.".length()), bundle.getString(str));
                it.remove();
            }
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("notification", bundle2);
        }
    }

    boolean zzz(Bundle bundle) {
        try {
            zza(zzc(bundle, "gcm.n.tag"), zzA(bundle));
            return true;
        } catch (zza e) {
            Log.w("GcmNotification", "Failed to show notification: " + e.getMessage());
            return false;
        }
    }
}
