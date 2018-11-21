package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;
import java.util.HashMap;
import java.util.Map;

@zzha
public class zzk extends FrameLayout implements zzh {
    private final FrameLayout zzDM;
    private final zzq zzDN;
    private zzi zzDO;
    private boolean zzDP;
    private boolean zzDQ;
    private TextView zzDR;
    private long zzDS;
    private long zzDT;
    private String zzDU;
    private final zzjn zzps;
    private String zzzk;

    public zzk(Context context, zzjn com_google_android_gms_internal_zzjn, int i, zzch com_google_android_gms_internal_zzch, zzcf com_google_android_gms_internal_zzcf) {
        super(context);
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzDM = new FrameLayout(context);
        addView(this.zzDM, new LayoutParams(-1, -1));
        zzb.zzu(com_google_android_gms_internal_zzjn.zzhz());
        this.zzDO = com_google_android_gms_internal_zzjn.zzhz().zzpn.zza(context, com_google_android_gms_internal_zzjn, i, com_google_android_gms_internal_zzch, com_google_android_gms_internal_zzcf);
        if (this.zzDO != null) {
            this.zzDM.addView(this.zzDO, new LayoutParams(-1, -1, 17));
        }
        this.zzDR = new TextView(context);
        this.zzDR.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        zzfv();
        this.zzDN = new zzq(this);
        this.zzDN.zzfD();
        if (this.zzDO != null) {
            this.zzDO.zza((zzh) this);
        }
        if (this.zzDO == null) {
            zzg("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private void zza(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.zzps.zzb("onVideoEvent", hashMap);
    }

    public static void zzd(zzjn com_google_android_gms_internal_zzjn) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        com_google_android_gms_internal_zzjn.zzb("onVideoEvent", hashMap);
    }

    private void zzfv() {
        if (!zzfx()) {
            this.zzDM.addView(this.zzDR, new LayoutParams(-1, -1));
            this.zzDM.bringChildToFront(this.zzDR);
        }
    }

    private void zzfw() {
        if (zzfx()) {
            this.zzDM.removeView(this.zzDR);
        }
    }

    private boolean zzfx() {
        return this.zzDR.getParent() != null;
    }

    private void zzfy() {
        if (this.zzps.zzhx() != null && !this.zzDP) {
            this.zzDQ = (this.zzps.zzhx().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzDQ) {
                this.zzps.zzhx().getWindow().addFlags(128);
                this.zzDP = true;
            }
        }
    }

    private void zzfz() {
        if (this.zzps.zzhx() != null && this.zzDP && !this.zzDQ) {
            this.zzps.zzhx().getWindow().clearFlags(128);
            this.zzDP = false;
        }
    }

    public void destroy() {
        this.zzDN.cancel();
        if (this.zzDO != null) {
            this.zzDO.stop();
        }
        zzfz();
    }

    public void onPaused() {
        zza("pause", new String[0]);
        zzfz();
    }

    public void pause() {
        if (this.zzDO != null) {
            this.zzDO.pause();
        }
    }

    public void play() {
        if (this.zzDO != null) {
            this.zzDO.play();
        }
    }

    public void seekTo(int millis) {
        if (this.zzDO != null) {
            this.zzDO.seekTo(millis);
        }
    }

    public void setMimeType(String mimeType) {
        this.zzDU = mimeType;
    }

    public void zza(float f) {
        if (this.zzDO != null) {
            this.zzDO.zza(f);
        }
    }

    public void zzao(String str) {
        this.zzzk = str;
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.zzDM.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void zzd(MotionEvent motionEvent) {
        if (this.zzDO != null) {
            this.zzDO.dispatchTouchEvent(motionEvent);
        }
    }

    public void zzeU() {
        if (this.zzDO != null) {
            this.zzDO.zzeU();
        }
    }

    public void zzeV() {
        if (this.zzDO != null) {
            this.zzDO.zzeV();
        }
    }

    public void zzfn() {
    }

    public void zzfo() {
        if (this.zzDO != null && this.zzDT == 0) {
            float duration = ((float) this.zzDO.getDuration()) / 1000.0f;
            int videoWidth = this.zzDO.getVideoWidth();
            int videoHeight = this.zzDO.getVideoHeight();
            zza("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void zzfp() {
        zzfy();
    }

    public void zzfq() {
        zza("ended", new String[0]);
        zzfz();
    }

    public void zzfr() {
        zzfv();
        this.zzDT = this.zzDS;
    }

    public void zzfs() {
        if (this.zzDO != null) {
            if (TextUtils.isEmpty(this.zzzk)) {
                zza("no_src", new String[0]);
                return;
            }
            this.zzDO.setMimeType(this.zzDU);
            this.zzDO.setVideoPath(this.zzzk);
        }
    }

    public void zzft() {
        if (this.zzDO != null) {
            View textView = new TextView(this.zzDO.getContext());
            textView.setText("AdMob - " + this.zzDO.zzeO());
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(-256);
            this.zzDM.addView(textView, new LayoutParams(-2, -2, 17));
            this.zzDM.bringChildToFront(textView);
        }
    }

    void zzfu() {
        if (this.zzDO != null) {
            long currentPosition = (long) this.zzDO.getCurrentPosition();
            if (this.zzDS != currentPosition && currentPosition > 0) {
                zzfw();
                float f = ((float) currentPosition) / 1000.0f;
                zza("timeupdate", "time", String.valueOf(f));
                this.zzDS = currentPosition;
            }
        }
    }

    public void zzg(String str, String str2) {
        zza("error", "what", str, "extra", str2);
    }
}
