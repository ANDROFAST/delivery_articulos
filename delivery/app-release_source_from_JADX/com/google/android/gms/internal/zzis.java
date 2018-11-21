package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

@zzha
public class zzis {
    private final Context mContext;
    private int mState;
    private final float zzCB;
    private String zzKT;
    private float zzKU;
    private float zzKV;
    private float zzKW;

    class C03402 implements OnClickListener {
        final /* synthetic */ zzis zzKY;

        C03402(zzis com_google_android_gms_internal_zzis) {
            this.zzKY = com_google_android_gms_internal_zzis;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public zzis(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzCB = context.getResources().getDisplayMetrics().density;
    }

    public zzis(Context context, String str) {
        this(context);
        this.zzKT = str;
    }

    private void showDialog() {
        if (this.mContext instanceof Activity) {
            final Object zzaD = zzaD(this.zzKT);
            Builder builder = new Builder(this.mContext);
            builder.setMessage(zzaD);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new OnClickListener(this) {
                final /* synthetic */ zzis zzKY;

                public void onClick(DialogInterface dialog, int which) {
                    zzp.zzbx().zzb(this.zzKY.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", zzaD), "Share via"));
                }
            });
            builder.setNegativeButton("Close", new C03402(this));
            builder.create().show();
            return;
        }
        zzb.zzaG("Can not create dialog without Activity Context");
    }

    static String zzaD(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map zze = zzp.zzbx().zze(build);
        for (String str2 : zze.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) zze.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzKU = f;
            this.zzKV = f2;
            this.zzKW = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzKV) {
                    this.zzKV = f2;
                } else if (f2 < this.zzKW) {
                    this.zzKW = f2;
                }
                if (this.zzKV - this.zzKW > BitmapDescriptorFactory.HUE_ORANGE * this.zzCB) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzKU >= 50.0f * this.zzCB) {
                        this.zzKU = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzKU <= -50.0f * this.zzCB) {
                    this.zzKU = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzKU) {
                        this.zzKU = f;
                    }
                } else if (this.mState == 2 && f < this.zzKU) {
                    this.zzKU = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzaC(String str) {
        this.zzKT = str;
    }

    public void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
