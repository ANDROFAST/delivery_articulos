package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzip {
    private static final String zzKI = AdView.class.getName();
    private static final String zzKJ = InterstitialAd.class.getName();
    private static final String zzKK = PublisherAdView.class.getName();
    private static final String zzKL = PublisherInterstitialAd.class.getName();
    private static final String zzKM = SearchAdView.class.getName();
    private static final String zzKN = AdLoader.class.getName();
    public static final Handler zzKO = new zzim(Looper.getMainLooper());
    private boolean zzKP = true;
    private boolean zzKQ = false;
    private String zzKi;
    private final Object zzpK = new Object();

    private final class zza extends BroadcastReceiver {
        final /* synthetic */ zzip zzKR;

        private zza(zzip com_google_android_gms_internal_zzip) {
            this.zzKR = com_google_android_gms_internal_zzip;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.zzKR.zzKP = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.zzKR.zzKP = false;
            }
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzKO.post(runnable);
        }
    }

    private JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : collection) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    private void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzf((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzz((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zza((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzf((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzz((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    static String zzb(String str, String str2, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = i - 1;
        if (i <= 0 || !stringTokenizer.hasMoreElements()) {
            return str;
        }
        stringBuilder.append(stringTokenizer.nextToken());
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0 && stringTokenizer.hasMoreElements()) {
                stringBuilder.append(".").append(stringTokenizer.nextToken());
                i2 = i3;
            }
        }
        return stringBuilder.toString();
    }

    private JSONObject zzf(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    public boolean zzJ(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzb.zzaH("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzb.zzaH(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzb.zzaH(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            zzb.zzaH(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            zzb.zzaH(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            zzb.zzaH(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            zzb.zzaH(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        zzb.zzaH(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean zzK(Context context) {
        if (this.zzKQ) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zza(), intentFilter);
        this.zzKQ = true;
        return true;
    }

    protected String zzL(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public Builder zzM(Context context) {
        return new Builder(context);
    }

    public zzbr zzN(Context context) {
        return new zzbr(context);
    }

    public String zzO(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    public boolean zzP(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && zzs(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap zzQ(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            View decorView = ((Activity) context).getWindow().getDecorView();
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            decorView.layout(0, 0, decorView.getWidth(), decorView.getHeight());
            decorView.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            zzb.zzb("Fail to capture screen shot", e);
            return null;
        }
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, AdSizeParcel adSizeParcel) {
        String str = null;
        if (((Boolean) zzbz.zzwe.get()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", adSizeParcel.width);
                jSONObject2.put("height", adSizeParcel.height);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", zzO(context));
                if (!adSizeParcel.zztW) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                zzb.zzd("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String zza(Context context, zzan com_google_android_gms_internal_zzan, String str) {
        if (com_google_android_gms_internal_zzan != null) {
            try {
                Uri parse = Uri.parse(str);
                if (com_google_android_gms_internal_zzan.zzc(parse)) {
                    parse = com_google_android_gms_internal_zzan.zza(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String zza(zzjn com_google_android_gms_internal_zzjn, String str) {
        return zza(com_google_android_gms_internal_zzjn.getContext(), com_google_android_gms_internal_zzjn.zzhE(), str);
    }

    public String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public String zza(StackTraceElement[] stackTraceElementArr, String str) {
        if (((Boolean) zzbz.zzwx.get()).booleanValue()) {
            String className;
            for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
                StackTraceElement stackTraceElement = stackTraceElementArr[i];
                String className2 = stackTraceElement.getClassName();
                if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzKI.equalsIgnoreCase(className2) || zzKJ.equalsIgnoreCase(className2) || zzKK.equalsIgnoreCase(className2) || zzKL.equalsIgnoreCase(className2) || zzKM.equalsIgnoreCase(className2) || zzKN.equalsIgnoreCase(className2))) {
                    className = stackTraceElementArr[i + 1].getClassName();
                    break;
                }
            }
            className = null;
            if (str != null) {
                CharSequence zzb = zzb(str, ".", 3);
                if (!(className == null || className.contains(zzb))) {
                    return className;
                }
            }
        }
        return null;
    }

    JSONArray zza(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : objArr) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    public void zza(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void zza(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzd(context, str));
    }

    public void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("device", zzp.zzbx().zzhb());
            bundle.putString("appid", applicationContext.getPackageName());
            bundle.putString("eids", TextUtils.join(",", zzbz.zzdl()));
            if (str != null) {
                bundle.putString("js", str);
            } else {
                bundle.putString("gmscore_version", Integer.toString(GooglePlayServicesUtil.zzan(context)));
            }
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzp.zzbx().zzc(context, str, appendQueryParameter.toString());
    }

    public void zza(Context context, String str, List<String> list) {
        for (String com_google_android_gms_internal_zziw : list) {
            new zziw(context, str, com_google_android_gms_internal_zziw).zzgX();
        }
    }

    public void zza(Context context, String str, List<String> list, String str2) {
        for (String com_google_android_gms_internal_zziw : list) {
            new zziw(context, str, com_google_android_gms_internal_zziw, str2).zzgX();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzd(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean zza(Context context, Bitmap bitmap, String str) {
        zzx.zzcy("saveImageToFile must not be called on the main UI thread.");
        try {
            OutputStream openFileOutput = context.openFileOutput(str, 0);
            bitmap.compress(CompressFormat.PNG, 100, openFileOutput);
            openFileOutput.close();
            bitmap.recycle();
            return true;
        } catch (Throwable e) {
            zzb.zzb("Fail to save file", e);
            return false;
        }
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public int zzaA(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            zzb.zzaH("Could not parse value:" + e);
            return 0;
        }
    }

    public boolean zzaB(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public String zzaz(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public void zzb(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void zzb(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
    }

    public void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzbz.zzws.get()).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    public void zzc(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public String zzd(final Context context, String str) {
        String str2;
        synchronized (this.zzpK) {
            if (this.zzKi != null) {
                str2 = this.zzKi;
            } else {
                try {
                    this.zzKi = zzp.zzbz().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzKi)) {
                    if (zzl.zzcN().zzhr()) {
                        try {
                            this.zzKi = zzL(context);
                        } catch (Exception e2) {
                            this.zzKi = zzgZ();
                        }
                    } else {
                        this.zzKi = null;
                        zzKO.post(new Runnable(this) {
                            final /* synthetic */ zzip zzKR;

                            public void run() {
                                synchronized (this.zzKR.zzpK) {
                                    this.zzKR.zzKi = this.zzKR.zzL(context);
                                    this.zzKR.zzpK.notifyAll();
                                }
                            }
                        });
                        while (this.zzKi == null) {
                            try {
                                this.zzpK.wait();
                            } catch (InterruptedException e3) {
                                this.zzKi = zzgZ();
                                zzb.zzaH("Interrupted, use default user agent: " + this.zzKi);
                            }
                        }
                    }
                }
                this.zzKi += " (Mobile; " + str + ")";
                str2 = this.zzKi;
            }
        }
        return str2;
    }

    public Bitmap zze(Context context, String str) {
        zzx.zzcy("getBackgroundImage must not be called on the main UI thread.");
        try {
            InputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            return decodeStream;
        } catch (Exception e) {
            zzb.m6e("Fail to get background image");
            return null;
        }
    }

    public Map<String, String> zze(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzp.zzbz().zzf(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public void zzf(Context context, String str) {
        zzx.zzcy("deleteFile must not be called on the main UI thread.");
        context.deleteFile(str);
    }

    public int[] zzg(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzhc();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public boolean zzgY() {
        return this.zzKP;
    }

    String zzgZ() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public int[] zzh(Activity activity) {
        int[] zzg = zzg(activity);
        return new int[]{zzl.zzcN().zzc(activity, zzg[0]), zzl.zzcN().zzc(activity, zzg[1])};
    }

    public String zzha() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public String zzhb() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    protected int[] zzhc() {
        return new int[]{0, 0};
    }

    public int[] zzi(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzhc();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public int[] zzj(Activity activity) {
        int[] zzi = zzi(activity);
        return new int[]{zzl.zzcN().zzc(activity, zzi[0]), zzl.zzcN().zzc(activity, zzi[1])};
    }

    public Bitmap zzl(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public JSONObject zzz(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }
}
