package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzbl extends Thread {
    private boolean mStarted = false;
    private boolean zzam = false;
    private final Object zzpK;
    private final int zzsC;
    private final int zzsE;
    private boolean zzsO = false;
    private final zzbk zzsP;
    private final zzbj zzsQ;
    private final zzgz zzsR;
    private final int zzsS;
    private final int zzsT;
    private final int zzsU;

    @zzha
    class zza {
        final /* synthetic */ zzbl zzsW;
        final int zztb;
        final int zztc;

        zza(zzbl com_google_android_gms_internal_zzbl, int i, int i2) {
            this.zzsW = com_google_android_gms_internal_zzbl;
            this.zztb = i;
            this.zztc = i2;
        }
    }

    public zzbl(zzbk com_google_android_gms_internal_zzbk, zzbj com_google_android_gms_internal_zzbj, zzgz com_google_android_gms_internal_zzgz) {
        this.zzsP = com_google_android_gms_internal_zzbk;
        this.zzsQ = com_google_android_gms_internal_zzbj;
        this.zzsR = com_google_android_gms_internal_zzgz;
        this.zzpK = new Object();
        this.zzsC = ((Integer) zzbz.zzvP.get()).intValue();
        this.zzsT = ((Integer) zzbz.zzvQ.get()).intValue();
        this.zzsE = ((Integer) zzbz.zzvR.get()).intValue();
        this.zzsU = ((Integer) zzbz.zzvS.get()).intValue();
        this.zzsS = ((Integer) zzbz.zzvT.get()).intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzam) {
            try {
                if (zzcC()) {
                    Activity activity = this.zzsP.getActivity();
                    if (activity == null) {
                        zzb.zzaF("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzb.zzaF("ContentFetchTask: sleeping");
                    zzcE();
                }
                Thread.sleep((long) (this.zzsS * 1000));
            } catch (Throwable th) {
                zzb.zzb("Error in ContentFetchTask", th);
                this.zzsR.zza(th, true);
            }
            synchronized (this.zzpK) {
                while (this.zzsO) {
                    try {
                        zzb.zzaF("ContentFetchTask: waiting");
                        this.zzpK.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzpK) {
            this.zzsO = false;
            this.zzpK.notifyAll();
            zzb.zzaF("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzbi com_google_android_gms_internal_zzbi) {
        int i = 0;
        if (view == null) {
            return new zza(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(this, 0, 0);
            }
            com_google_android_gms_internal_zzbi.zzw(text.toString());
            return new zza(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzjn)) {
            com_google_android_gms_internal_zzbi.zzcx();
            return zza((WebView) view, com_google_android_gms_internal_zzbi) ? new zza(this, 0, 1) : new zza(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                zza zza = zza(viewGroup.getChildAt(i), com_google_android_gms_internal_zzbi);
                i3 += zza.zztb;
                i2 += zza.zztc;
                i++;
            }
            return new zza(this, i3, i2);
        }
    }

    void zza(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                zzf(view);
            }
        }
    }

    void zza(zzbi com_google_android_gms_internal_zzbi, WebView webView, String str) {
        com_google_android_gms_internal_zzbi.zzcw();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    com_google_android_gms_internal_zzbi.zzv(optString);
                } else {
                    com_google_android_gms_internal_zzbi.zzv(webView.getTitle() + "\n" + optString);
                }
            }
            if (com_google_android_gms_internal_zzbi.zzct()) {
                this.zzsQ.zzb(com_google_android_gms_internal_zzbi);
            }
        } catch (JSONException e) {
            zzb.zzaF("Json string may be malformed.");
        } catch (Throwable th) {
            zzb.zza("Failed to get webview content.", th);
            this.zzsR.zza(th, true);
        }
    }

    boolean zza(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean zza(final WebView webView, final zzbi com_google_android_gms_internal_zzbi) {
        if (!zznx.zzrU()) {
            return false;
        }
        com_google_android_gms_internal_zzbi.zzcx();
        webView.post(new Runnable(this) {
            final /* synthetic */ zzbl zzsW;
            ValueCallback<String> zzsX = new C02711(this);

            class C02711 implements ValueCallback<String> {
                final /* synthetic */ C02722 zzta;

                C02711(C02722 c02722) {
                    this.zzta = c02722;
                }

                public /* synthetic */ void onReceiveValue(Object x0) {
                    zzy((String) x0);
                }

                public void zzy(String str) {
                    this.zzta.zzsW.zza(com_google_android_gms_internal_zzbi, webView, str);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzsX);
                    } catch (Throwable th) {
                        this.zzsX.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcB() {
        synchronized (this.zzpK) {
            if (this.mStarted) {
                zzb.zzaF("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    boolean zzcC() {
        try {
            Context context = this.zzsP.getContext();
            if (context == null) {
                return false;
            }
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
                    if (zza(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && zzs(context)) {
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

    public zzbi zzcD() {
        return this.zzsQ.zzcA();
    }

    public void zzcE() {
        synchronized (this.zzpK) {
            this.zzsO = true;
            zzb.zzaF("ContentFetchThread: paused, mPause = " + this.zzsO);
        }
    }

    public boolean zzcF() {
        return this.zzsO;
    }

    boolean zzf(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ zzbl zzsW;

            public void run() {
                this.zzsW.zzg(view);
            }
        });
        return true;
    }

    void zzg(View view) {
        try {
            zzbi com_google_android_gms_internal_zzbi = new zzbi(this.zzsC, this.zzsT, this.zzsE, this.zzsU);
            zza zza = zza(view, com_google_android_gms_internal_zzbi);
            com_google_android_gms_internal_zzbi.zzcy();
            if (zza.zztb != 0 || zza.zztc != 0) {
                if (zza.zztc != 0 || com_google_android_gms_internal_zzbi.zzcz() != 0) {
                    if (zza.zztc != 0 || !this.zzsQ.zza(com_google_android_gms_internal_zzbi)) {
                        this.zzsQ.zzc(com_google_android_gms_internal_zzbi);
                    }
                }
            }
        } catch (Throwable e) {
            zzb.zzb("Exception in fetchContentOnUIThread", e);
            this.zzsR.zza(e, true);
        }
    }

    boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }
}
