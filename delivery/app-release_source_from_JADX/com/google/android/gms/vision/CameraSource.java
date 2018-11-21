package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.Thread.State;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CameraSource {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private int zzCE;
    private boolean zzbhA;
    private SurfaceView zzbhB;
    private SurfaceTexture zzbhC;
    private boolean zzbhD;
    private Thread zzbhE;
    private zzb zzbhF;
    private Map<byte[], ByteBuffer> zzbhG;
    private final Object zzbht;
    private Camera zzbhu;
    private int zzbhv;
    private Size zzbhw;
    private float zzbhx;
    private int zzbhy;
    private int zzbhz;

    public static class Builder {
        private final Detector<?> zzbhH;
        private CameraSource zzbhI = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.zzbhH = detector;
                this.zzbhI.mContext = context;
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzbhI;
            CameraSource cameraSource2 = this.zzbhI;
            cameraSource2.getClass();
            cameraSource.zzbhF = new zzb(cameraSource2, this.zzbhH);
            return this.zzbhI;
        }

        public Builder setAutoFocusEnabled(boolean autoFocusEnabled) {
            this.zzbhI.zzbhA = autoFocusEnabled;
            return this;
        }

        public Builder setFacing(int facing) {
            if (facing == 0 || facing == 1) {
                this.zzbhI.zzbhv = facing;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + facing);
        }

        public Builder setRequestedFps(float fps) {
            if (fps <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + fps);
            }
            this.zzbhI.zzbhx = fps;
            return this;
        }

        public Builder setRequestedPreviewSize(int width, int height) {
            if (width <= 0 || width > 1000000 || height <= 0 || height > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + width + "x" + height);
            }
            this.zzbhI.zzbhy = width;
            this.zzbhI.zzbhz = height;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements PreviewCallback {
        final /* synthetic */ CameraSource zzbhJ;

        private zza(CameraSource cameraSource) {
            this.zzbhJ = cameraSource;
        }

        public void onPreviewFrame(byte[] data, Camera camera) {
            this.zzbhJ.zzbhF.zza(data, camera);
        }
    }

    private class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = (!CameraSource.class.desiredAssertionStatus());
        private long zzQj = SystemClock.elapsedRealtime();
        private Detector<?> zzbhH;
        final /* synthetic */ CameraSource zzbhJ;
        private boolean zzbhK = true;
        private long zzbhL;
        private int zzbhM = 0;
        private ByteBuffer zzbhN;
        private final Object zzpK = new Object();

        zzb(CameraSource cameraSource, Detector<?> detector) {
            this.zzbhJ = cameraSource;
            this.zzbhH = detector;
        }

        void release() {
            if ($assertionsDisabled || this.zzbhJ.zzbhE.getState() == State.TERMINATED) {
                this.zzbhH.release();
                this.zzbhH = null;
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
        L_0x0000:
            r1 = r6.zzpK;
            monitor-enter(r1);
            r0 = r6.zzbhK;	 Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0010;
        L_0x0007:
            r0 = r6.zzbhN;	 Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0010;
        L_0x000b:
            r0 = r6.zzpK;	 Catch:{ InterruptedException -> 0x0016 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0016 }
        L_0x0010:
            r0 = r6.zzbhK;	 Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0023;
        L_0x0014:
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
            r2 = "CameraSource";
            r3 = "Frame processing loop terminated.";
            android.util.Log.d(r2, r3, r0);	 Catch:{ all -> 0x0020 }
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            goto L_0x0015;
        L_0x0020:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            throw r0;
        L_0x0023:
            r0 = new com.google.android.gms.vision.Frame$Builder;	 Catch:{ all -> 0x0020 }
            r0.<init>();	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbhN;	 Catch:{ all -> 0x0020 }
            r3 = r6.zzbhJ;	 Catch:{ all -> 0x0020 }
            r3 = r3.zzbhw;	 Catch:{ all -> 0x0020 }
            r3 = r3.getWidth();	 Catch:{ all -> 0x0020 }
            r4 = r6.zzbhJ;	 Catch:{ all -> 0x0020 }
            r4 = r4.zzbhw;	 Catch:{ all -> 0x0020 }
            r4 = r4.getHeight();	 Catch:{ all -> 0x0020 }
            r5 = 17;
            r0 = r0.setImageData(r2, r3, r4, r5);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbhM;	 Catch:{ all -> 0x0020 }
            r0 = r0.setId(r2);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbhL;	 Catch:{ all -> 0x0020 }
            r0 = r0.setTimestampMillis(r2);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbhJ;	 Catch:{ all -> 0x0020 }
            r2 = r2.zzCE;	 Catch:{ all -> 0x0020 }
            r0 = r0.setRotation(r2);	 Catch:{ all -> 0x0020 }
            r0 = r0.build();	 Catch:{ all -> 0x0020 }
            r2 = r6.zzbhN;	 Catch:{ all -> 0x0020 }
            r3 = 0;
            r6.zzbhN = r3;	 Catch:{ all -> 0x0020 }
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            r1 = r6.zzbhH;	 Catch:{ Throwable -> 0x0077 }
            r1.receiveFrame(r0);	 Catch:{ Throwable -> 0x0077 }
            r0 = r6.zzbhJ;
            r0 = r0.zzbhu;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x0077:
            r0 = move-exception;
            r1 = "CameraSource";
            r3 = "Exception thrown from receiver.";
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x008e }
            r0 = r6.zzbhJ;
            r0 = r0.zzbhu;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x008e:
            r0 = move-exception;
            r1 = r6.zzbhJ;
            r1 = r1.zzbhu;
            r2 = r2.array();
            r1.addCallbackBuffer(r2);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        void setActive(boolean active) {
            synchronized (this.zzpK) {
                this.zzbhK = active;
                this.zzpK.notifyAll();
            }
        }

        void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpK) {
                if (this.zzbhN != null) {
                    camera.addCallbackBuffer(this.zzbhN.array());
                    this.zzbhN = null;
                }
                this.zzbhL = SystemClock.elapsedRealtime() - this.zzQj;
                this.zzbhM++;
                this.zzbhN = (ByteBuffer) this.zzbhJ.zzbhG.get(bArr);
                this.zzpK.notifyAll();
            }
        }
    }

    private class zzc implements android.hardware.Camera.PictureCallback {
        final /* synthetic */ CameraSource zzbhJ;
        private PictureCallback zzbhO;

        private zzc(CameraSource cameraSource) {
            this.zzbhJ = cameraSource;
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            if (this.zzbhO != null) {
                this.zzbhO.onPictureTaken(data);
            }
            synchronized (this.zzbhJ.zzbht) {
                if (this.zzbhJ.zzbhu != null) {
                    this.zzbhJ.zzbhu.startPreview();
                }
            }
        }
    }

    private class zzd implements android.hardware.Camera.ShutterCallback {
        final /* synthetic */ CameraSource zzbhJ;
        private ShutterCallback zzbhP;

        private zzd(CameraSource cameraSource) {
            this.zzbhJ = cameraSource;
        }

        public void onShutter() {
            if (this.zzbhP != null) {
                this.zzbhP.onShutter();
            }
        }
    }

    private static class zze {
        private Size zzbhQ;
        private Size zzbhR;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzbhQ = new Size(size.width, size.height);
            this.zzbhR = new Size(size2.width, size2.height);
        }

        public Size zzGh() {
            return this.zzbhQ;
        }

        public Size zzGi() {
            return this.zzbhR;
        }
    }

    private CameraSource() {
        this.zzbht = new Object();
        this.zzbhv = 0;
        this.zzbhx = BitmapDescriptorFactory.HUE_ORANGE;
        this.zzbhy = 1024;
        this.zzbhz = 768;
        this.zzbhA = false;
        this.zzbhG = new HashMap();
    }

    private Camera zzGg() {
        int zzjY = zzjY(this.zzbhv);
        if (zzjY == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(zzjY);
        zze zza = zza(open, this.zzbhy, this.zzbhz);
        if (zza == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size zzGi = zza.zzGi();
        this.zzbhw = zza.zzGh();
        int[] zza2 = zza(open, this.zzbhx);
        if (zza2 == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Parameters parameters = open.getParameters();
        parameters.setPictureSize(zzGi.getWidth(), zzGi.getHeight());
        parameters.setPreviewSize(this.zzbhw.getWidth(), this.zzbhw.getHeight());
        parameters.setPreviewFpsRange(zza2[0], zza2[1]);
        parameters.setPreviewFormat(17);
        zza(open, parameters, zzjY);
        if (this.zzbhA) {
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new zza());
        open.addCallbackBuffer(zza(this.zzbhw));
        open.addCallbackBuffer(zza(this.zzbhw));
        open.addCallbackBuffer(zza(this.zzbhw));
        open.addCallbackBuffer(zza(this.zzbhw));
        return open;
    }

    private static zze zza(Camera camera, int i, int i2) {
        zze com_google_android_gms_vision_CameraSource_zze = null;
        int i3 = Integer.MAX_VALUE;
        for (zze com_google_android_gms_vision_CameraSource_zze2 : zza(camera)) {
            zze com_google_android_gms_vision_CameraSource_zze3;
            int i4;
            Size zzGh = com_google_android_gms_vision_CameraSource_zze2.zzGh();
            int abs = Math.abs(zzGh.getHeight() - i2) + Math.abs(zzGh.getWidth() - i);
            if (abs < i3) {
                int i5 = abs;
                com_google_android_gms_vision_CameraSource_zze3 = com_google_android_gms_vision_CameraSource_zze2;
                i4 = i5;
            } else {
                i4 = i3;
                com_google_android_gms_vision_CameraSource_zze3 = com_google_android_gms_vision_CameraSource_zze;
            }
            i3 = i4;
            com_google_android_gms_vision_CameraSource_zze = com_google_android_gms_vision_CameraSource_zze3;
        }
        return com_google_android_gms_vision_CameraSource_zze;
    }

    private static List<zze> zza(Camera camera) {
        Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List supportedPictureSizes = parameters.getSupportedPictureSizes();
        List<zze> arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = ((float) size.width) / ((float) size.height);
            for (int size2 = supportedPictureSizes.size() - 1; size2 >= 0; size2--) {
                Camera.Size size3 = (Camera.Size) supportedPictureSizes.get(size2);
                if (Math.abs(f - (((float) size3.width) / ((float) size3.height))) < 0.01f) {
                    arrayList.add(new zze(size, size3));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size size4 : supportedPreviewSizes) {
                arrayList.add(new zze(size4, null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Parameters parameters, int i) {
        int i2;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                rotation = 0;
                break;
            case 1:
                rotation = 90;
                break;
            case 2:
                rotation = 180;
                break;
            case 3:
                rotation = 270;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                rotation = 0;
                break;
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i2 = (rotation + cameraInfo.orientation) % 360;
            rotation = (360 - i2) % 360;
        } else {
            rotation = ((cameraInfo.orientation - rotation) + 360) % 360;
            i2 = rotation;
        }
        this.zzCE = i2 / 90;
        camera.setDisplayOrientation(rotation);
        parameters.setRotation(i2);
    }

    private byte[] zza(Size size) {
        Object obj = new byte[(((int) Math.ceil(((double) ((long) (ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(obj);
        if (wrap.hasArray() && wrap.array() == obj) {
            this.zzbhG.put(obj, wrap);
            return obj;
        }
        throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }

    private int[] zza(Camera camera, float f) {
        int i = (int) (1000.0f * f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int[] iArr3;
            int i3;
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                int i4 = abs;
                iArr3 = iArr2;
                i3 = i4;
            } else {
                i3 = i2;
                iArr3 = iArr;
            }
            i2 = i3;
            iArr = iArr3;
        }
        return iArr;
    }

    private static int zzjY(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzbhv;
    }

    public Size getPreviewSize() {
        return this.zzbhw;
    }

    public void release() {
        synchronized (this.zzbht) {
            stop();
            this.zzbhF.release();
        }
    }

    public CameraSource start() throws IOException {
        synchronized (this.zzbht) {
            if (this.zzbhu != null) {
            } else {
                this.zzbhu = zzGg();
                if (VERSION.SDK_INT >= 11) {
                    this.zzbhC = new SurfaceTexture(100);
                    this.zzbhu.setPreviewTexture(this.zzbhC);
                    this.zzbhD = true;
                } else {
                    this.zzbhB = new SurfaceView(this.mContext);
                    this.zzbhu.setPreviewDisplay(this.zzbhB.getHolder());
                    this.zzbhD = false;
                }
                this.zzbhu.startPreview();
                this.zzbhE = new Thread(this.zzbhF);
                this.zzbhF.setActive(true);
                this.zzbhE.start();
            }
        }
        return this;
    }

    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzbht) {
            if (this.zzbhu != null) {
            } else {
                this.zzbhu = zzGg();
                this.zzbhu.setPreviewDisplay(surfaceHolder);
                this.zzbhu.startPreview();
                this.zzbhE = new Thread(this.zzbhF);
                this.zzbhF.setActive(true);
                this.zzbhE.start();
                this.zzbhD = false;
            }
        }
        return this;
    }

    public void stop() {
        synchronized (this.zzbht) {
            this.zzbhF.setActive(false);
            if (this.zzbhE != null) {
                try {
                    this.zzbhE.join();
                } catch (InterruptedException e) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzbhE = null;
            }
            if (this.zzbhu != null) {
                this.zzbhu.stopPreview();
                this.zzbhu.setPreviewCallbackWithBuffer(null);
                try {
                    if (this.zzbhD) {
                        this.zzbhu.setPreviewTexture(null);
                    } else {
                        this.zzbhu.setPreviewDisplay(null);
                    }
                } catch (Exception e2) {
                    Log.e("CameraSource", "Failed to clear camera preview: " + e2);
                }
                this.zzbhu.release();
                this.zzbhu = null;
            }
        }
    }

    public void takePicture(ShutterCallback shutter, PictureCallback jpeg) {
        synchronized (this.zzbht) {
            if (this.zzbhu != null) {
                android.hardware.Camera.ShutterCallback com_google_android_gms_vision_CameraSource_zzd = new zzd();
                com_google_android_gms_vision_CameraSource_zzd.zzbhP = shutter;
                android.hardware.Camera.PictureCallback com_google_android_gms_vision_CameraSource_zzc = new zzc();
                com_google_android_gms_vision_CameraSource_zzc.zzbhO = jpeg;
                this.zzbhu.takePicture(com_google_android_gms_vision_CameraSource_zzd, null, null, com_google_android_gms_vision_CameraSource_zzc);
            }
        }
    }
}
