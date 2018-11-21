package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzc.zza;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zzny;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {
    private static final Object zzakg = new Object();
    private static Integer zzalE;
    private static zzb zzaly;
    private final List<String> zzalA;
    private final List<String> zzalB;
    private final List<String> zzalC;
    private zze zzalD;
    private zze zzalF;
    private final List<String> zzalz;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.zzalz = Collections.EMPTY_LIST;
            this.zzalA = Collections.EMPTY_LIST;
            this.zzalB = Collections.EMPTY_LIST;
            this.zzalC = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) zza.zzalJ.get();
        this.zzalz = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.zzalK.get();
        this.zzalA = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.zzalL.get();
        this.zzalB = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.zzalM.get();
        this.zzalC = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.zzalD = new zze(1024, ((Long) zza.zzalN.get()).longValue());
        this.zzalF = new zze(1024, ((Long) zza.zzalN.get()).longValue());
    }

    private static int getLogLevel() {
        if (zzalE == null) {
            try {
                zzalE = Integer.valueOf(zznk.zzka() ? ((Integer) zza.zzalI.get()).intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                zzalE = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return zzalE.intValue();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((getLogLevel() & zzd.zzalS) == 0 || i == 13)) {
            str6 = zzny.zzm(3, 5);
        }
        long j = 0;
        if ((getLogLevel() & zzd.zzalU) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.zzalO).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (zzrA() && this.zzalD != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo zzd = zzd(context, intent);
                if (zzd == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = zzd.processName;
                str5 = zzd.name;
                str3 = zzny.zzay(context);
                if (zzb(str3, str2, str4, str5)) {
                    this.zzalD.zzcM(str);
                } else {
                    return;
                }
            } else if (this.zzalD.zzcN(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            zza(context, str, i, str3, str2, str4, str5);
        }
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        return (this.zzalz.contains(str) || this.zzalA.contains(str2) || this.zzalB.contains(str3) || this.zzalC.contains(str4) || (str3.equals(str) && (getLogLevel() & zzd.zzalT) != 0)) ? false : true;
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return (component == null || (zzd.zzaiU && "com.google.android.gms".equals(component.getPackageName()))) ? false : zznk.zzj(context, component.getPackageName());
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzny.zzm(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzny.zzm(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private boolean zzrA() {
        return zzd.zzaiU && getLogLevel() != zzd.LOG_LEVEL_OFF;
    }

    public static zzb zzrz() {
        synchronized (zzakg) {
            if (zzaly == null) {
                zzaly = new zzb();
            }
        }
        return zzaly;
    }

    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), null, null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), null, null, 4);
    }
}
