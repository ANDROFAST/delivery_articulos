package io.card.payment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.google.android.gms.fitness.FitnessStatusCodes;
import java.lang.ref.WeakReference;
import java.util.List;

class CardScanner implements AutoFocusCallback, PreviewCallback, Callback {
    private static final String f1031a = CardScanner.class.getSimpleName();
    private static boolean f1032c;
    private static boolean f1033s = false;
    private static /* synthetic */ boolean f1034t = (!CardScanner.class.desiredAssertionStatus());
    private Bitmap f1035b;
    private WeakReference f1036d;
    private boolean f1037e = false;
    private boolean f1038f;
    private int f1039g = 1;
    private boolean f1040h = true;
    private long f1041i = 0;
    private long f1042j = 0;
    private Camera f1043k = null;
    private byte[] f1044l;
    private boolean f1045m = true;
    private boolean f1046n = false;
    private int f1047o;
    private int f1048p;
    private int f1049q;
    private int f1050r;

    static {
        f1032c = false;
        try {
            System.loadLibrary("cardioDecider");
            new StringBuilder("Loaded card.io decider library.  nUseNeon():").append(nUseNeon()).append(",nUseTegra():").append(nUseTegra());
            if (nUseNeon() || nUseTegra()) {
                System.loadLibrary("opencv_core");
                System.loadLibrary("opencv_imgproc");
            }
            if (nUseNeon()) {
                System.loadLibrary("cardioRecognizer");
            } else if (nUseTegra()) {
                System.loadLibrary("cardioRecognizer_tegra2");
            } else {
                Log.w("card.io", "unsupported processor - card.io scanning requires ARMv7 architecture");
                f1032c = true;
            }
        } catch (UnsatisfiedLinkError e) {
            Log.e("card.io", "Failed to load native library: " + e.getMessage());
            f1032c = true;
        }
    }

    CardScanner(CardIOActivity cardIOActivity, int i) {
        boolean z = true;
        Intent intent = cardIOActivity.getIntent();
        if (intent != null) {
            this.f1037e = intent.getBooleanExtra(CardIOActivity.EXTRA_SUPPRESS_SCAN, false);
            if (!(intent.getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, false) && intent.getBooleanExtra(CardIOActivity.EXTRA_SCAN_EXPIRY, true))) {
                z = false;
            }
            this.f1038f = z;
        }
        this.f1036d = new WeakReference(cardIOActivity);
        this.f1039g = i;
        nSetup(this.f1037e, 6.0f);
    }

    static boolean m818a() {
        return !f1032c && (nUseNeon() || nUseTegra());
    }

    private Camera m819b(int i, int i2) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f1045m) {
            i3 = i2;
            do {
                try {
                    return Camera.open();
                } catch (RuntimeException e) {
                    try {
                        Log.w("card.io", "Wasn't able to connect to camera service. Waiting and trying again...");
                        Thread.sleep(50);
                    } catch (Throwable e2) {
                        Log.e("card.io", "Interrupted while waiting for camera", e2);
                    }
                } catch (Throwable e3) {
                    Log.e("card.io", "Unexpected exception. Please report it to support@card.io", e3);
                    i3 = 0;
                }
            } while (System.currentTimeMillis() - currentTimeMillis >= ((long) i3));
            Log.w(f1031a, "camera connect timeout");
            return null;
        }
        Log.w(f1031a, "camera connect timeout");
        return null;
        if (System.currentTimeMillis() - currentTimeMillis >= ((long) i3)) {
            Log.w(f1031a, "camera connect timeout");
            return null;
        }
    }

    private boolean m820b(SurfaceHolder surfaceHolder) {
        if (!f1034t && surfaceHolder == null) {
            throw new AssertionError();
        } else if (f1034t || surfaceHolder.getSurface() != null) {
            new StringBuilder("surfaceFrame: ").append(String.valueOf(surfaceHolder.getSurfaceFrame()));
            this.f1040h = true;
            if (this.f1045m) {
                try {
                    this.f1043k.setPreviewDisplay(surfaceHolder);
                    try {
                        this.f1043k.startPreview();
                        this.f1043k.autoFocus(this);
                    } catch (Throwable e) {
                        Log.e("card.io", "startPreview failed on camera. Error: ", e);
                        return false;
                    }
                } catch (Throwable e2) {
                    Log.e("card.io", "can't set preview display", e2);
                    return false;
                }
            }
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private native void nCleanup();

    private native void nGetGuideFrame(int i, int i2, int i3, Rect rect);

    private native int nGetNumFramesScanned();

    private native void nResetAnalytics();

    private native void nScanFrame(byte[] bArr, int i, int i2, int i3, DetectionInfo detectionInfo, Bitmap bitmap, boolean z);

    private native void nSetup(boolean z, float f);

    public static native boolean nUseNeon();

    public static native boolean nUseTegra();

    final Rect m821a(int i, int i2) {
        int i3 = this.f1039g;
        if (!m818a()) {
            return null;
        }
        Rect rect = new Rect();
        nGetGuideFrame(i3, i, i2, rect);
        return rect;
    }

    final void m822a(int i) {
        this.f1039g = i;
    }

    final void m823a(boolean z) {
        if (this.f1045m) {
            if ((this.f1042j < this.f1041i ? 1 : null) == null) {
                try {
                    this.f1041i = System.currentTimeMillis();
                    this.f1043k.autoFocus(this);
                    if (z) {
                        this.f1047o++;
                    } else {
                        this.f1048p++;
                    }
                } catch (RuntimeException e) {
                    Log.w(f1031a, "could not trigger auto focus: " + e);
                }
            }
        }
    }

    final boolean m824a(SurfaceHolder surfaceHolder) {
        new StringBuilder("resumeScanning(").append(surfaceHolder).append(")");
        if (this.f1043k == null) {
            m825b();
        }
        if (this.f1045m && this.f1043k == null) {
            return false;
        }
        if (f1034t || surfaceHolder != null) {
            if (this.f1045m && this.f1044l == null) {
                new StringBuilder("- mCamera:").append(this.f1043k);
                int previewFormat = this.f1043k.getParameters().getPreviewFormat();
                new StringBuilder("- preview format: ").append(previewFormat);
                previewFormat = ImageFormat.getBitsPerPixel(previewFormat) / 8;
                new StringBuilder("- bytes per pixel: ").append(previewFormat);
                previewFormat = (previewFormat * 307200) * 3;
                new StringBuilder("- buffer size: ").append(previewFormat);
                this.f1044l = new byte[previewFormat];
                this.f1043k.addCallbackBuffer(this.f1044l);
            }
            surfaceHolder.addCallback(this);
            surfaceHolder.setType(3);
            if (this.f1045m) {
                this.f1043k.setPreviewCallbackWithBuffer(this);
            }
            if (this.f1046n) {
                m820b(surfaceHolder);
            }
            m826b(false);
            System.currentTimeMillis();
            nResetAnalytics();
            return true;
        }
        throw new AssertionError();
    }

    final void m825b() {
        this.f1040h = true;
        this.f1041i = 0;
        this.f1042j = 0;
        this.f1047o = 0;
        this.f1048p = 0;
        this.f1049q = 0;
        this.f1050r = 0;
        if (this.f1045m && this.f1043k == null) {
            this.f1043k = m819b(50, FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
            if (this.f1043k == null) {
                Log.e("card.io", "prepare scanner couldn't connect to camera!");
                return;
            }
            this.f1043k.setDisplayOrientation(90);
            Parameters parameters = this.f1043k.getParameters();
            List<Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                for (Size size : supportedPreviewSizes) {
                    if (size.width == 640 && size.height == 480) {
                        break;
                    }
                }
                Size size2 = null;
                if (size2 == null) {
                    Log.w("card.io", "Didn't find a supported 640x480 resolution, so forcing");
                    size2 = (Size) supportedPreviewSizes.get(0);
                    size2.width = 640;
                    size2.height = 480;
                }
            }
            new StringBuilder("- parameters: ").append(parameters);
            parameters.setPreviewSize(640, 480);
            this.f1043k.setParameters(parameters);
        } else if (!this.f1045m) {
            Log.w(f1031a, "useCamera is false!");
        } else if (this.f1043k != null) {
            new StringBuilder("we already have a camera instance: ").append(this.f1043k);
        }
        if (this.f1035b == null) {
            this.f1035b = Bitmap.createBitmap(428, 270, Config.ARGB_8888);
        }
    }

    public final boolean m826b(boolean z) {
        if (this.f1043k != null) {
            new StringBuilder("setFlashOn: ").append(z);
            try {
                Parameters parameters = this.f1043k.getParameters();
                parameters.setFlashMode(z ? "torch" : "off");
                this.f1043k.setParameters(parameters);
                this.f1049q++;
                return true;
            } catch (RuntimeException e) {
                Log.w(f1031a, "Could not set flash mode: " + e);
            }
        }
        return false;
    }

    public final void m827c() {
        m826b(false);
        if (this.f1043k != null) {
            try {
                this.f1043k.stopPreview();
                this.f1043k.setPreviewDisplay(null);
            } catch (Throwable e) {
                Log.w("card.io", "can't stop preview display", e);
            }
            this.f1043k.setPreviewCallback(null);
            this.f1043k.release();
            this.f1044l = null;
            this.f1043k = null;
        }
    }

    public final void m828d() {
        if (this.f1043k != null) {
            m827c();
        }
        nCleanup();
        this.f1044l = null;
    }

    public final boolean m829e() {
        return !this.f1045m ? false : this.f1043k.getParameters().getFlashMode().equals("torch");
    }

    public void onAutoFocus(boolean z, Camera camera) {
        this.f1042j = System.currentTimeMillis();
    }

    void onEdgeUpdate(DetectionInfo detectionInfo) {
        ((CardIOActivity) this.f1036d.get()).m816a(detectionInfo);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreviewFrame(byte[] r11, android.hardware.Camera r12) {
        /*
        r10 = this;
        r8 = 1;
        r9 = 0;
        if (r11 != 0) goto L_0x000c;
    L_0x0004:
        r0 = f1031a;
        r1 = "frame is null! skipping";
        android.util.Log.w(r0, r1);
    L_0x000b:
        return;
    L_0x000c:
        r0 = f1033s;
        if (r0 == 0) goto L_0x0023;
    L_0x0010:
        r0 = f1031a;
        r1 = "processing in progress.... dropping frame";
        android.util.Log.e(r0, r1);
        r0 = r10.f1050r;
        r0 = r0 + 1;
        r10.f1050r = r0;
        if (r12 == 0) goto L_0x000b;
    L_0x001f:
        r12.addCallbackBuffer(r11);
        goto L_0x000b;
    L_0x0023:
        f1033s = r8;
        r0 = r10.f1040h;
        if (r0 == 0) goto L_0x0038;
    L_0x0029:
        r10.f1040h = r9;
        r10.f1039g = r8;
        r0 = r10.f1036d;
        r0 = r0.get();
        r0 = (io.card.payment.CardIOActivity) r0;
        r0.m814a(r8);
    L_0x0038:
        r5 = new io.card.payment.DetectionInfo;
        r5.<init>();
        r2 = 640; // 0x280 float:8.97E-43 double:3.16E-321;
        r3 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        r4 = r10.f1039g;
        r6 = r10.f1035b;
        r7 = r10.f1038f;
        r0 = r10;
        r1 = r11;
        r0.nScanFrame(r1, r2, r3, r4, r5, r6, r7);
        r0 = r5.focusScore;
        r1 = 1086324736; // 0x40c00000 float:6.0 double:5.367157323E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0062;
    L_0x0054:
        r0 = r8;
    L_0x0055:
        if (r0 != 0) goto L_0x0064;
    L_0x0057:
        r10.m823a(r9);
    L_0x005a:
        if (r12 == 0) goto L_0x005f;
    L_0x005c:
        r12.addCallbackBuffer(r11);
    L_0x005f:
        f1033s = r9;
        goto L_0x000b;
    L_0x0062:
        r0 = r9;
        goto L_0x0055;
    L_0x0064:
        r0 = r5.complete;
        if (r0 != 0) goto L_0x007f;
    L_0x0068:
        r0 = r10.f1037e;
        if (r0 == 0) goto L_0x005a;
    L_0x006c:
        r0 = r5.topEdge;
        if (r0 == 0) goto L_0x009b;
    L_0x0070:
        r0 = r5.bottomEdge;
        if (r0 == 0) goto L_0x009b;
    L_0x0074:
        r0 = r5.rightEdge;
        if (r0 == 0) goto L_0x009b;
    L_0x0078:
        r0 = r5.leftEdge;
        if (r0 == 0) goto L_0x009b;
    L_0x007c:
        r0 = r8;
    L_0x007d:
        if (r0 == 0) goto L_0x005a;
    L_0x007f:
        r0 = new java.lang.StringBuilder;
        r1 = "detected card: ";
        r0.<init>(r1);
        r1 = r5.m836a();
        r0.append(r1);
        r0 = r10.f1036d;
        r0 = r0.get();
        r0 = (io.card.payment.CardIOActivity) r0;
        r1 = r10.f1035b;
        r0.m815a(r1, r5);
        goto L_0x005a;
    L_0x009b:
        r0 = r9;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.card.payment.CardScanner.onPreviewFrame(byte[], android.hardware.Camera):void");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = "Preview.surfaceChanged(holder?:%b, f:%d, w:%d, h:%d )";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(surfaceHolder != null);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        String.format(str, objArr);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f1043k == null && this.f1045m) {
            Log.wtf("card.io", "CardScanner.surfaceCreated() - camera is null!");
            return;
        }
        this.f1046n = true;
        m820b(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.f1043k != null) {
            try {
                this.f1043k.stopPreview();
            } catch (Throwable e) {
                Log.e("card.io", "error stopping camera", e);
            }
        }
        this.f1046n = false;
    }
}
