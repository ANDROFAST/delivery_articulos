package com.paypal.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class at {
    private static final boolean f252a = Boolean.valueOf(System.getProperty("dyson.debug.mode", Boolean.FALSE.toString())).booleanValue();
    private static final boolean f253b = Boolean.valueOf(System.getProperty("prd.debug.mode", Boolean.FALSE.toString())).booleanValue();
    private static final String f254c = (C0503Y.class.getSimpleName() + "." + at.class.getSimpleName());
    private static final Uri f255d;

    static {
        Uri parse;
        try {
            parse = Uri.parse("content://com.google.android.gsf.gservices");
        } catch (Exception e) {
            parse = null;
        }
        f255d = parse;
    }

    private at() {
    }

    public static Location m145a(LocationManager locationManager) {
        Location location = null;
        try {
            List providers = locationManager.getProviders(true);
            int size = providers.size() - 1;
            while (size >= 0) {
                try {
                    Location lastKnownLocation = locationManager.getLastKnownLocation((String) providers.get(size));
                    if (lastKnownLocation != null) {
                        return lastKnownLocation;
                    }
                    size--;
                    location = lastKnownLocation;
                } catch (RuntimeException e) {
                    return location;
                }
            }
            return location;
        } catch (RuntimeException e2) {
            return null;
        }
    }

    public static C0510f m146a(Context context) {
        C0510f c0510f = new C0510f();
        c0510f.m472b(context.getPackageName());
        try {
            c0510f.m473c(context.getPackageManager().getPackageInfo(c0510f.m470a(), 0).versionName);
        } catch (NameNotFoundException e) {
        }
        return c0510f;
    }

    public static Object m147a(Object obj, Class cls) {
        return (obj == null || !cls.isAssignableFrom(obj.getClass())) ? null : cls.cast(obj);
    }

    public static String m148a() {
        try {
            C0500V c0500v = new C0500V();
            c0500v.m42a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.ebay.lid/");
            String str = "fb.bin";
            String b = c0500v.m44b(str);
            if (!"".equals(b.trim())) {
                return b;
            }
            b = UUID.randomUUID().toString();
            c0500v.m43a(str, b.getBytes("UTF-8"));
            return b;
        } catch (Exception e) {
            return "";
        }
    }

    public static String m149a(Context context, C0502X c0502x) {
        try {
            if (VERSION.SDK_INT >= 9 && GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    return AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
                }
                new Thread(new au(context, c0502x)).start();
            }
        } catch (Throwable th) {
            th.getLocalizedMessage();
        }
        return null;
    }

    public static String m150a(Context context, String str, String str2) {
        try {
            new StringBuilder("entering getMetadata loading name=").append(str);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                new StringBuilder("leaving getMetadata successfully loading name=").append(str);
                return applicationInfo.metaData.getString(str);
            }
        } catch (NameNotFoundException e) {
            new StringBuilder("load metadata in manifest failed, name=").append(str);
        }
        new StringBuilder("leaving getMetadata with default value,name=").append(str);
        return null;
    }

    public static List m151a(boolean z) {
        List arrayList = new ArrayList();
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!(inetAddress instanceof Inet6Address)) {
                            arrayList.add(hostAddress);
                        } else if (z) {
                            arrayList.add(hostAddress);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public static void m152a(int i, String str, String str2) {
        if (f253b) {
            Log.println(i, str, str2);
        }
    }

    public static void m153a(int i, String str, String str2, Throwable th) {
        if (f253b) {
            Log.println(6, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public static void m154a(String str, String str2) {
    }

    public static void m155a(String str, String str2, Throwable th) {
    }

    public static void m156a(String str, JSONObject jSONObject) {
        if (f252a && jSONObject != null) {
            jSONObject.toString();
        }
    }

    public static boolean m157a(Context context, String str) {
        try {
            return context.getApplicationContext().checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m158a(PackageManager packageManager, Intent intent) {
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String m159b() {
        List a = m151a(false);
        return a.isEmpty() ? "" : (String) a.get(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m160b(android.content.Context r6) {
        /*
        r1 = 1;
        r2 = 0;
        r0 = f255d;
        if (r0 == 0) goto L_0x0023;
    L_0x0006:
        r0 = "com.google.android.providers.gsf.permission.READ_GSERVICES";
        r0 = m157a(r6, r0);
        if (r0 == 0) goto L_0x0023;
    L_0x000e:
        r4 = new java.lang.String[r1];
        r0 = 0;
        r1 = "android_id";
        r4[r0] = r1;
        r0 = r6.getContentResolver();
        r1 = f255d;
        r3 = r2;
        r5 = r2;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 != 0) goto L_0x0024;
    L_0x0023:
        return r2;
    L_0x0024:
        r0 = r1.moveToFirst();	 Catch:{ NumberFormatException -> 0x0046, all -> 0x004b }
        if (r0 == 0) goto L_0x0031;
    L_0x002a:
        r0 = r1.getColumnCount();	 Catch:{ NumberFormatException -> 0x0046, all -> 0x004b }
        r3 = 2;
        if (r0 >= r3) goto L_0x0035;
    L_0x0031:
        r1.close();
        goto L_0x0023;
    L_0x0035:
        r0 = 1;
        r0 = r1.getString(r0);	 Catch:{ NumberFormatException -> 0x0046, all -> 0x004b }
        r4 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0046, all -> 0x004b }
        r2 = java.lang.Long.toHexString(r4);	 Catch:{ NumberFormatException -> 0x0046, all -> 0x004b }
        r1.close();
        goto L_0x0023;
    L_0x0046:
        r0 = move-exception;
        r1.close();
        goto L_0x0023;
    L_0x004b:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.at.b(android.content.Context):java.lang.String");
    }

    public static String m161b(Context context, String str) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuilder.append(readLine);
            } else {
                bufferedReader.close();
                return new String(Base64.decode(stringBuilder.toString(), 0), "UTF-8");
            }
        }
    }

    public static boolean m162b(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        new StringBuilder("Cached version is ").append(str);
        new StringBuilder("default version is ").append(str2);
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equals(split2[i])) {
            i++;
        }
        Integer valueOf = (i >= split.length || i >= split2.length) ? Integer.valueOf(Integer.signum(split.length - split2.length)) : Integer.valueOf(Integer.signum(Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i]))));
        return valueOf.intValue() >= 0;
    }

    public static long m163c() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e) {
            e.getLocalizedMessage();
            return 0;
        }
    }

    public static String m164d() {
        if (VERSION.SDK_INT >= 14) {
            String property = System.getProperty("http.proxyHost");
            if (property != null) {
                String property2 = System.getProperty("http.proxyPort");
                if (property2 != null) {
                    return "host=" + property + ",port=" + property2;
                }
            }
        }
        return null;
    }

    public static String m165e() {
        try {
            String readLine;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ls /sys/class/net").getInputStream()));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return null;
                }
                if (readLine.startsWith("ppp") || readLine.startsWith("tun")) {
                    return readLine;
                }
            } while (!readLine.startsWith("tap"));
            return readLine;
        } catch (Exception e) {
        }
    }
}
