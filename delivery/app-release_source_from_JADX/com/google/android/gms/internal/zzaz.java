package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzaz implements OnGlobalLayoutListener, OnScrollChangedListener {
    private final Object zzpK = new Object();
    private boolean zzqq = false;
    private final Context zzrI;
    private final WeakReference<zzie> zzrK;
    private WeakReference<ViewTreeObserver> zzrL;
    private final zzbh zzrM;
    private final zzax zzrN;
    private final zzei zzrO;
    private final com.google.android.gms.internal.zzei.zzd zzrP;
    private boolean zzrQ;
    private final WindowManager zzrR;
    private final PowerManager zzrS;
    private final KeyguardManager zzrT;
    private zzba zzrU;
    private boolean zzrV;
    private boolean zzrW = false;
    private boolean zzrX;
    private boolean zzrY;
    BroadcastReceiver zzrZ;
    private zzix zzru;
    private final HashSet<zzaw> zzsa = new HashSet();
    private final zzdl zzsb = new C06756(this);
    private final zzdl zzsc = new C06767(this);
    private final zzdl zzsd = new C06778(this);

    class C02635 extends BroadcastReceiver {
        final /* synthetic */ zzaz zzsf;

        C02635(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void onReceive(Context context, Intent intent) {
            this.zzsf.zzh(false);
        }
    }

    class C06722 implements com.google.android.gms.internal.zzjg.zza {
        final /* synthetic */ zzaz zzsf;

        C06722(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void run() {
        }
    }

    class C06733 implements com.google.android.gms.internal.zzjg.zzc<zzbe> {
        final /* synthetic */ zzaz zzsf;

        C06733(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void zzb(zzbe com_google_android_gms_internal_zzbe) {
            this.zzsf.zzrQ = true;
            this.zzsf.zza(com_google_android_gms_internal_zzbe);
            this.zzsf.zzcd();
            this.zzsf.zzh(false);
        }

        public /* synthetic */ void zzc(Object obj) {
            zzb((zzbe) obj);
        }
    }

    class C06744 implements com.google.android.gms.internal.zzjg.zza {
        final /* synthetic */ zzaz zzsf;

        C06744(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void run() {
            this.zzsf.destroy();
        }
    }

    class C06756 implements zzdl {
        final /* synthetic */ zzaz zzsf;

        C06756(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            if (this.zzsf.zzb((Map) map)) {
                this.zzsf.zza(com_google_android_gms_internal_zzjn.getView(), (Map) map);
            }
        }
    }

    class C06767 implements zzdl {
        final /* synthetic */ zzaz zzsf;

        C06767(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            if (this.zzsf.zzb((Map) map)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received request to untrack: " + this.zzsf.zzrN.zzca());
                this.zzsf.destroy();
            }
        }
    }

    class C06778 implements zzdl {
        final /* synthetic */ zzaz zzsf;

        C06778(zzaz com_google_android_gms_internal_zzaz) {
            this.zzsf = com_google_android_gms_internal_zzaz;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            if (this.zzsf.zzb((Map) map) && map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.zzsf.zzg(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public static class zza implements zzbh {
        private WeakReference<zzh> zzsh;

        public zza(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzsh = new WeakReference(com_google_android_gms_ads_internal_formats_zzh);
        }

        public View zzcn() {
            zzh com_google_android_gms_ads_internal_formats_zzh = (zzh) this.zzsh.get();
            return com_google_android_gms_ads_internal_formats_zzh != null ? com_google_android_gms_ads_internal_formats_zzh.zzdL() : null;
        }

        public boolean zzco() {
            return this.zzsh.get() == null;
        }

        public zzbh zzcp() {
            return new zzb((zzh) this.zzsh.get());
        }
    }

    public static class zzb implements zzbh {
        private zzh zzsi;

        public zzb(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzsi = com_google_android_gms_ads_internal_formats_zzh;
        }

        public View zzcn() {
            return this.zzsi.zzdL();
        }

        public boolean zzco() {
            return this.zzsi == null;
        }

        public zzbh zzcp() {
            return this;
        }
    }

    public static class zzc implements zzbh {
        private final View mView;
        private final zzie zzsj;

        public zzc(View view, zzie com_google_android_gms_internal_zzie) {
            this.mView = view;
            this.zzsj = com_google_android_gms_internal_zzie;
        }

        public View zzcn() {
            return this.mView;
        }

        public boolean zzco() {
            return this.zzsj == null || this.mView == null;
        }

        public zzbh zzcp() {
            return this;
        }
    }

    public static class zzd implements zzbh {
        private final WeakReference<View> zzsk;
        private final WeakReference<zzie> zzsl;

        public zzd(View view, zzie com_google_android_gms_internal_zzie) {
            this.zzsk = new WeakReference(view);
            this.zzsl = new WeakReference(com_google_android_gms_internal_zzie);
        }

        public View zzcn() {
            return (View) this.zzsk.get();
        }

        public boolean zzco() {
            return this.zzsk.get() == null || this.zzsl.get() == null;
        }

        public zzbh zzcp() {
            return new zzc((View) this.zzsk.get(), (zzie) this.zzsl.get());
        }
    }

    public zzaz(Context context, AdSizeParcel adSizeParcel, zzie com_google_android_gms_internal_zzie, VersionInfoParcel versionInfoParcel, zzbh com_google_android_gms_internal_zzbh, zzei com_google_android_gms_internal_zzei) {
        zzbh zzcp = com_google_android_gms_internal_zzbh.zzcp();
        this.zzrO = com_google_android_gms_internal_zzei;
        this.zzrK = new WeakReference(com_google_android_gms_internal_zzie);
        this.zzrM = com_google_android_gms_internal_zzbh;
        this.zzrL = new WeakReference(null);
        this.zzrX = true;
        this.zzru = new zzix(200);
        this.zzrN = new zzax(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.zztV, com_google_android_gms_internal_zzie.zzJE, com_google_android_gms_internal_zzie.zzcb(), adSizeParcel.zztY);
        this.zzrP = this.zzrO.zzei();
        this.zzrR = (WindowManager) context.getSystemService("window");
        this.zzrS = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzrT = (KeyguardManager) context.getSystemService("keyguard");
        this.zzrI = context;
        try {
            final JSONObject zzd = zzd(zzcp.zzcn());
            this.zzrP.zza(new com.google.android.gms.internal.zzjg.zzc<zzbe>(this) {
                final /* synthetic */ zzaz zzsf;

                public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                    this.zzsf.zza(zzd);
                }

                public /* synthetic */ void zzc(Object obj) {
                    zzb((zzbe) obj);
                }
            }, new C06722(this));
        } catch (JSONException e) {
        } catch (Throwable e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failure while processing active view data.", e2);
        }
        this.zzrP.zza(new C06733(this), new C06744(this));
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Tracking ad unit: " + this.zzrN.zzca());
    }

    protected void destroy() {
        synchronized (this.zzpK) {
            zzcj();
            zzce();
            this.zzrX = false;
            zzcg();
            this.zzrP.release();
        }
    }

    boolean isScreenOn() {
        return this.zzrS.isScreenOn();
    }

    public void onGlobalLayout() {
        zzh(false);
    }

    public void onScrollChanged() {
        zzh(true);
    }

    public void pause() {
        synchronized (this.zzpK) {
            this.zzqq = true;
            zzh(false);
        }
    }

    public void resume() {
        synchronized (this.zzpK) {
            this.zzqq = false;
            zzh(false);
        }
    }

    public void stop() {
        synchronized (this.zzpK) {
            this.zzrW = true;
            zzh(false);
        }
    }

    protected int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected void zza(View view, Map<String, String> map) {
        zzh(false);
    }

    public void zza(zzaw com_google_android_gms_internal_zzaw) {
        this.zzsa.add(com_google_android_gms_internal_zzaw);
    }

    public void zza(zzba com_google_android_gms_internal_zzba) {
        synchronized (this.zzpK) {
            this.zzrU = com_google_android_gms_internal_zzba;
        }
    }

    protected void zza(zzbe com_google_android_gms_internal_zzbe) {
        com_google_android_gms_internal_zzbe.zza("/updateActiveView", this.zzsb);
        com_google_android_gms_internal_zzbe.zza("/untrackActiveViewUnit", this.zzsc);
        com_google_android_gms_internal_zzbe.zza("/visibilityChanged", this.zzsd);
    }

    protected void zza(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            final JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.zzrP.zza(new com.google.android.gms.internal.zzjg.zzc<zzbe>(this) {
                final /* synthetic */ zzaz zzsf;

                public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                    com_google_android_gms_internal_zzbe.zza("AFMA_updateActiveView", jSONObject2);
                }

                public /* synthetic */ void zzc(Object obj) {
                    zzb((zzbe) obj);
                }
            }, new com.google.android.gms.internal.zzjg.zzb());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Skipping active view message.", th);
        }
    }

    protected boolean zzb(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.zzrN.zzca());
        return z;
    }

    protected void zzcd() {
        synchronized (this.zzpK) {
            if (this.zzrZ != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.zzrZ = new C02635(this);
            this.zzrI.registerReceiver(this.zzrZ, intentFilter);
        }
    }

    protected void zzce() {
        synchronized (this.zzpK) {
            if (this.zzrZ != null) {
                try {
                    this.zzrI.unregisterReceiver(this.zzrZ);
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed trying to unregister the receiver", e);
                } catch (Throwable e2) {
                    zzp.zzbA().zzb(e2, true);
                }
                this.zzrZ = null;
            }
        }
    }

    public void zzcf() {
        synchronized (this.zzpK) {
            if (this.zzrX) {
                this.zzrY = true;
                try {
                    zza(zzcm());
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Failure while processing active view data.", e2);
                }
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Untracking ad unit: " + this.zzrN.zzca());
            }
        }
    }

    protected void zzcg() {
        if (this.zzrU != null) {
            this.zzrU.zza(this);
        }
    }

    public boolean zzch() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzrX;
        }
        return z;
    }

    protected void zzci() {
        View zzcn = this.zzrM.zzcp().zzcn();
        if (zzcn != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzrL.get();
            ViewTreeObserver viewTreeObserver2 = zzcn.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                zzcj();
                if (!this.zzrV || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.zzrV = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                this.zzrL = new WeakReference(viewTreeObserver2);
            }
        }
    }

    protected void zzcj() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzrL.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject zzck() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzrN.zzbY()).put("activeViewJSON", this.zzrN.zzbZ()).put("timestamp", zzp.zzbB().elapsedRealtime()).put("adFormat", this.zzrN.zzbX()).put("hashCode", this.zzrN.zzca()).put("isMraid", this.zzrN.zzcb()).put("isStopped", this.zzrW).put("isPaused", this.zzqq).put("isScreenOn", isScreenOn()).put("isNative", this.zzrN.zzcc());
        return jSONObject;
    }

    protected JSONObject zzcl() throws JSONException {
        return zzck().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
    }

    protected JSONObject zzcm() throws JSONException {
        JSONObject zzck = zzck();
        zzck.put("doneReasonCode", "u");
        return zzck;
    }

    protected JSONObject zzd(View view) throws JSONException {
        if (view == null) {
            return zzcl();
        }
        boolean isAttachedToWindow = zzp.zzbz().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zzrR.getDefaultDisplay().getWidth();
        rect2.bottom = this.zzrR.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject zzck = zzck();
        zzck.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zze(view));
        return zzck;
    }

    protected boolean zze(View view) {
        return view.getVisibility() == 0 && view.isShown() && isScreenOn() && (!this.zzrT.inKeyguardRestrictedInputMode() || zzp.zzbx().zzgY());
    }

    protected void zzg(boolean z) {
        Iterator it = this.zzsa.iterator();
        while (it.hasNext()) {
            ((zzaw) it.next()).zza(this, z);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzh(boolean r4) {
        /*
        r3 = this;
        r1 = r3.zzpK;
        monitor-enter(r1);
        r0 = r3.zzrQ;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.zzrX;	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
    L_0x000c:
        return;
    L_0x000d:
        if (r4 == 0) goto L_0x001c;
    L_0x000f:
        r0 = r3.zzru;	 Catch:{ all -> 0x0019 }
        r0 = r0.tryAcquire();	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x001c;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x000c;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
    L_0x001c:
        r0 = r3.zzrM;	 Catch:{ all -> 0x0019 }
        r0 = r0.zzco();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0029;
    L_0x0024:
        r3.zzcf();	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x000c;
    L_0x0029:
        r0 = r3.zzrM;	 Catch:{ JSONException -> 0x003e, RuntimeException -> 0x0045 }
        r0 = r0.zzcn();	 Catch:{ JSONException -> 0x003e, RuntimeException -> 0x0045 }
        r0 = r3.zzd(r0);	 Catch:{ JSONException -> 0x003e, RuntimeException -> 0x0045 }
        r3.zza(r0);	 Catch:{ JSONException -> 0x003e, RuntimeException -> 0x0045 }
    L_0x0036:
        r3.zzci();	 Catch:{ all -> 0x0019 }
        r3.zzcg();	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x000c;
    L_0x003e:
        r0 = move-exception;
    L_0x003f:
        r2 = "Active view update failed.";
        com.google.android.gms.ads.internal.util.client.zzb.zza(r2, r0);	 Catch:{ all -> 0x0019 }
        goto L_0x0036;
    L_0x0045:
        r0 = move-exception;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaz.zzh(boolean):void");
    }
}
