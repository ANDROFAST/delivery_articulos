package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzat extends Thread implements zzas {
    private static zzat zzbdU;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean zzQk = false;
    private final LinkedBlockingQueue<Runnable> zzbdT = new LinkedBlockingQueue();
    private volatile zzau zzbdV;

    private zzat(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzat zzaZ(Context context) {
        if (zzbdU == null) {
            zzbdU = new zzat(context);
        }
        return zzbdU;
    }

    private String zzd(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zzbdT.take();
                if (!this.zzQk) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzbg.zzaG(e.toString());
            } catch (Throwable th) {
                zzbg.m9e("Error on Google TagManager Thread: " + zzd(th));
                zzbg.m9e("Google TagManager is shutting down.");
                this.zzQk = true;
            }
        }
    }

    public void zzfs(String str) {
        zzk(str, System.currentTimeMillis());
    }

    public void zzj(Runnable runnable) {
        this.zzbdT.add(runnable);
    }

    void zzk(String str, long j) {
        final zzat com_google_android_gms_tagmanager_zzat = this;
        final long j2 = j;
        final String str2 = str;
        zzj(new Runnable(this) {
            final /* synthetic */ zzat zzbdY;

            public void run() {
                if (this.zzbdY.zzbdV == null) {
                    zzcu zzFs = zzcu.zzFs();
                    zzFs.zza(this.zzbdY.mContext, com_google_android_gms_tagmanager_zzat);
                    this.zzbdY.zzbdV = zzFs.zzFv();
                }
                this.zzbdY.zzbdV.zzg(j2, str2);
            }
        });
    }
}
