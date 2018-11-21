package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzha
public class zzj extends zza implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private FrameLayout zzoF;
    private final Object zzpK = new Object();
    private zzh zzxH;
    private final FrameLayout zzyf;
    private Map<String, WeakReference<View>> zzyg = new HashMap();
    private zzb zzyh;
    boolean zzyi = false;
    int zzyj;
    int zzyk;

    public zzj(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzyf = frameLayout;
        this.zzoF = frameLayout2;
        zzji.zza(this.zzyf, (OnGlobalLayoutListener) this);
        zzji.zza(this.zzyf, (OnScrollChangedListener) this);
        this.zzyf.setOnTouchListener(this);
    }

    public void destroy() {
        this.zzoF.removeAllViews();
        this.zzoF = null;
        this.zzyg = null;
        this.zzyh = null;
        this.zzxH = null;
    }

    int getMeasuredHeight() {
        return this.zzyf.getMeasuredHeight();
    }

    int getMeasuredWidth() {
        return this.zzyf.getMeasuredWidth();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r10) {
        /*
        r9 = this;
        r6 = r9.zzpK;
        monitor-enter(r6);
        r0 = r9.zzxH;	 Catch:{ all -> 0x0091 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r6);	 Catch:{ all -> 0x0091 }
    L_0x0008:
        return;
    L_0x0009:
        r3 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r3.<init>();	 Catch:{ all -> 0x0091 }
        r0 = r9.zzyg;	 Catch:{ all -> 0x0091 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0091 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0091 }
    L_0x0018:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0094;
    L_0x001e:
        r0 = r2.next();	 Catch:{ all -> 0x0091 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0091 }
        r1 = r0.getValue();	 Catch:{ all -> 0x0091 }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x0091 }
        r1 = r1.get();	 Catch:{ all -> 0x0091 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0091 }
        r4 = r9.zzk(r1);	 Catch:{ all -> 0x0091 }
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r5.<init>();	 Catch:{ all -> 0x0091 }
        r7 = "width";
        r8 = r1.getWidth();	 Catch:{ JSONException -> 0x0073 }
        r8 = r9.zzq(r8);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r7, r8);	 Catch:{ JSONException -> 0x0073 }
        r7 = "height";
        r1 = r1.getHeight();	 Catch:{ JSONException -> 0x0073 }
        r1 = r9.zzq(r1);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r7, r1);	 Catch:{ JSONException -> 0x0073 }
        r1 = "x";
        r7 = r4.x;	 Catch:{ JSONException -> 0x0073 }
        r7 = r9.zzq(r7);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r1, r7);	 Catch:{ JSONException -> 0x0073 }
        r1 = "y";
        r4 = r4.y;	 Catch:{ JSONException -> 0x0073 }
        r4 = r9.zzq(r4);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r1, r4);	 Catch:{ JSONException -> 0x0073 }
        r1 = r0.getKey();	 Catch:{ JSONException -> 0x0073 }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0073 }
        r3.put(r1, r5);	 Catch:{ JSONException -> 0x0073 }
        goto L_0x0018;
    L_0x0073:
        r1 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0091 }
        r1.<init>();	 Catch:{ all -> 0x0091 }
        r4 = "Unable to get view rectangle for view ";
        r1 = r1.append(r4);	 Catch:{ all -> 0x0091 }
        r0 = r0.getKey();	 Catch:{ all -> 0x0091 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0091 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0091 }
        r0 = r0.toString();	 Catch:{ all -> 0x0091 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x0018;
    L_0x0091:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0091 }
        throw r0;
    L_0x0094:
        r4 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r4.<init>();	 Catch:{ all -> 0x0091 }
        r0 = "x";
        r1 = r9.zzyj;	 Catch:{ JSONException -> 0x00e8 }
        r1 = r9.zzq(r1);	 Catch:{ JSONException -> 0x00e8 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x00e8 }
        r0 = "y";
        r1 = r9.zzyk;	 Catch:{ JSONException -> 0x00e8 }
        r1 = r9.zzq(r1);	 Catch:{ JSONException -> 0x00e8 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x00e8 }
    L_0x00af:
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r5.<init>();	 Catch:{ all -> 0x0091 }
        r0 = "width";
        r1 = r9.getMeasuredWidth();	 Catch:{ JSONException -> 0x00ef }
        r1 = r9.zzq(r1);	 Catch:{ JSONException -> 0x00ef }
        r5.put(r0, r1);	 Catch:{ JSONException -> 0x00ef }
        r0 = "height";
        r1 = r9.getMeasuredHeight();	 Catch:{ JSONException -> 0x00ef }
        r1 = r9.zzq(r1);	 Catch:{ JSONException -> 0x00ef }
        r5.put(r0, r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x00ce:
        r0 = r9.zzyh;	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00d2:
        r0 = r9.zzyh;	 Catch:{ all -> 0x0091 }
        r0 = r0.zzdB();	 Catch:{ all -> 0x0091 }
        r0 = r0.equals(r10);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00de:
        r0 = r9.zzxH;	 Catch:{ all -> 0x0091 }
        r1 = "1007";
        r0.zza(r1, r3, r4, r5);	 Catch:{ all -> 0x0091 }
    L_0x00e5:
        monitor-exit(r6);	 Catch:{ all -> 0x0091 }
        goto L_0x0008;
    L_0x00e8:
        r0 = move-exception;
        r0 = "Unable to get click location";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x00af;
    L_0x00ef:
        r0 = move-exception;
        r0 = "Unable to get native ad view bounding box";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x00ce;
    L_0x00f6:
        r0 = r9.zzxH;	 Catch:{ all -> 0x0091 }
        r2 = r9.zzyg;	 Catch:{ all -> 0x0091 }
        r1 = r10;
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0091 }
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.zzj.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.zzpK) {
            if (this.zzyi) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0)) {
                    this.zzoF.setLayoutParams(new LayoutParams(measuredWidth, measuredHeight));
                    this.zzyi = false;
                }
            }
            if (this.zzxH != null) {
                this.zzxH.zzi(this.zzyf);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.zzpK) {
            if (this.zzxH != null) {
                this.zzxH.zzi(this.zzyf);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.zzpK) {
            if (this.zzxH == null) {
            } else {
                Point zzc = zzc(motionEvent);
                this.zzyj = zzc.x;
                this.zzyk = zzc.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) zzc.x, (float) zzc.y);
                this.zzxH.zzb(obtain);
                obtain.recycle();
            }
        }
        return false;
    }

    public zzd zzU(String str) {
        zzd zzB;
        synchronized (this.zzpK) {
            Object obj;
            WeakReference weakReference = (WeakReference) this.zzyg.get(str);
            if (weakReference == null) {
                obj = null;
            } else {
                View view = (View) weakReference.get();
            }
            zzB = zze.zzB(obj);
        }
        return zzB;
    }

    public void zza(String str, zzd com_google_android_gms_dynamic_zzd) {
        View view = (View) zze.zzp(com_google_android_gms_dynamic_zzd);
        synchronized (this.zzpK) {
            if (view == null) {
                this.zzyg.remove(str);
            } else {
                this.zzyg.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setOnClickListener(this);
            }
        }
    }

    public void zzb(zzd com_google_android_gms_dynamic_zzd) {
        synchronized (this.zzpK) {
            this.zzyi = true;
            zzj(null);
            final zzh com_google_android_gms_ads_internal_formats_zzh = (zzh) zze.zzp(com_google_android_gms_dynamic_zzd);
            if ((this.zzxH instanceof zzg) && ((zzg) this.zzxH).zzdI()) {
                ((zzg) this.zzxH).zzc(com_google_android_gms_ads_internal_formats_zzh);
            } else {
                this.zzxH = com_google_android_gms_ads_internal_formats_zzh;
                if (this.zzxH instanceof zzg) {
                    ((zzg) this.zzxH).zzc(null);
                }
            }
            this.zzoF.removeAllViews();
            this.zzyh = zzg(com_google_android_gms_ads_internal_formats_zzh);
            if (this.zzyh != null) {
                this.zzyg.put("1007", new WeakReference(this.zzyh.zzdB()));
                this.zzoF.addView(this.zzyh);
            }
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzj zzym;

                public void run() {
                    zzjn zzdK = com_google_android_gms_ads_internal_formats_zzh.zzdK();
                    if (zzdK != null) {
                        this.zzym.zzoF.addView(zzdK.getView());
                    }
                }
            });
            com_google_android_gms_ads_internal_formats_zzh.zzh(this.zzyf);
            zzj(this.zzyf);
        }
    }

    Point zzc(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.zzyf.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    zzb zzg(zzh com_google_android_gms_ads_internal_formats_zzh) {
        return com_google_android_gms_ads_internal_formats_zzh.zza(this);
    }

    void zzj(View view) {
        if (this.zzxH != null) {
            zzh zzdJ = this.zzxH instanceof zzg ? ((zzg) this.zzxH).zzdJ() : this.zzxH;
            if (zzdJ != null) {
                zzdJ.zzj(view);
            }
        }
    }

    Point zzk(View view) {
        if (this.zzyh == null || !this.zzyh.zzdB().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.zzyf.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    int zzq(int i) {
        return zzl.zzcN().zzc(this.zzxH.getContext(), i);
    }
}
