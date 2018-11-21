package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzcu extends zzct {
    private static final Object zzbfI = new Object();
    private static zzcu zzbfT;
    private boolean connected = true;
    private Handler handler;
    private Context zzbfJ;
    private zzau zzbfK;
    private volatile zzas zzbfL;
    private int zzbfM = 1800000;
    private boolean zzbfN = true;
    private boolean zzbfO = false;
    private boolean zzbfP = true;
    private zzav zzbfQ = new C07921(this);
    private zzbl zzbfR;
    private boolean zzbfS = false;

    class C04242 implements Callback {
        final /* synthetic */ zzcu zzbfU;

        C04242(zzcu com_google_android_gms_tagmanager_zzcu) {
            this.zzbfU = com_google_android_gms_tagmanager_zzcu;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && zzcu.zzbfI.equals(msg.obj)) {
                this.zzbfU.dispatch();
                if (this.zzbfU.zzbfM > 0 && !this.zzbfU.zzbfS) {
                    this.zzbfU.handler.sendMessageDelayed(this.zzbfU.handler.obtainMessage(1, zzcu.zzbfI), (long) this.zzbfU.zzbfM);
                }
            }
            return true;
        }
    }

    class C04253 implements Runnable {
        final /* synthetic */ zzcu zzbfU;

        C04253(zzcu com_google_android_gms_tagmanager_zzcu) {
            this.zzbfU = com_google_android_gms_tagmanager_zzcu;
        }

        public void run() {
            this.zzbfU.zzbfK.dispatch();
        }
    }

    class C07921 implements zzav {
        final /* synthetic */ zzcu zzbfU;

        C07921(zzcu com_google_android_gms_tagmanager_zzcu) {
            this.zzbfU = com_google_android_gms_tagmanager_zzcu;
        }

        public void zzav(boolean z) {
            this.zzbfU.zzd(z, this.zzbfU.connected);
        }
    }

    private zzcu() {
    }

    public static zzcu zzFs() {
        if (zzbfT == null) {
            zzbfT = new zzcu();
        }
        return zzbfT;
    }

    private void zzFt() {
        this.zzbfR = new zzbl(this);
        this.zzbfR.zzba(this.zzbfJ);
    }

    private void zzFu() {
        this.handler = new Handler(this.zzbfJ.getMainLooper(), new C04242(this));
        if (this.zzbfM > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbfI), (long) this.zzbfM);
        }
    }

    public synchronized void dispatch() {
        if (this.zzbfO) {
            this.zzbfL.zzj(new C04253(this));
        } else {
            zzbg.m10v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbfN = true;
        }
    }

    synchronized zzau zzFv() {
        if (this.zzbfK == null) {
            if (this.zzbfJ == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzbfK = new zzby(this.zzbfQ, this.zzbfJ);
        }
        if (this.handler == null) {
            zzFu();
        }
        this.zzbfO = true;
        if (this.zzbfN) {
            dispatch();
            this.zzbfN = false;
        }
        if (this.zzbfR == null && this.zzbfP) {
            zzFt();
        }
        return this.zzbfK;
    }

    synchronized void zza(Context context, zzas com_google_android_gms_tagmanager_zzas) {
        if (this.zzbfJ == null) {
            this.zzbfJ = context.getApplicationContext();
            if (this.zzbfL == null) {
                this.zzbfL = com_google_android_gms_tagmanager_zzas;
            }
        }
    }

    public synchronized void zzaw(boolean z) {
        zzd(this.zzbfS, z);
    }

    synchronized void zzd(boolean z, boolean z2) {
        if (!(this.zzbfS == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.zzbfM > 0) {
                    this.handler.removeMessages(1, zzbfI);
                }
            }
            if (!z && z2 && this.zzbfM > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbfI), (long) this.zzbfM);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            zzbg.m10v(append.append(str).toString());
            this.zzbfS = z;
            this.connected = z2;
        }
    }

    public synchronized void zziO() {
        if (!this.zzbfS && this.connected && this.zzbfM > 0) {
            this.handler.removeMessages(1, zzbfI);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzbfI));
        }
    }
}
