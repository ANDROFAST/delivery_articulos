package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zznx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzahR = new Object();
    private static HashSet<Uri> zzahS = new HashSet();
    private static ImageManager zzahT;
    private static ImageManager zzahU;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzahV = Executors.newFixedThreadPool(4);
    private final zzb zzahW;
    private final zzmx zzahX;
    private final Map<zza, ImageReceiver> zzahY;
    private final Map<Uri, ImageReceiver> zzahZ;
    private final Map<Uri, Long> zzaia;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzaib = new ArrayList();
        final /* synthetic */ ImageManager zzaic;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzaic = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.zzaic.zzahV.execute(new zzc(this.zzaic, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzcx("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzaib.add(com_google_android_gms_common_images_zza);
        }

        public void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzcx("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzaib.remove(com_google_android_gms_common_images_zza);
        }

        public void zzpU() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzaic.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        final /* synthetic */ ImageManager zzaic;
        private final ParcelFileDescriptor zzaid;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzaic = imageManager;
            this.mUri = uri;
            this.zzaid = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcy("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzaid != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzaid.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzaid.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzaic.mHandler.post(new zzf(this.zzaic, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        final /* synthetic */ ImageManager zzaic;
        private final zza zzaie;

        public zzd(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.zzaic = imageManager;
            this.zzaie = com_google_android_gms_common_images_zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcx("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzaic.zzahY.get(this.zzaie);
            if (imageReceiver != null) {
                this.zzaic.zzahY.remove(this.zzaie);
                imageReceiver.zzc(this.zzaie);
            }
            zza com_google_android_gms_common_images_zza_zza = this.zzaie.zzaig;
            if (com_google_android_gms_common_images_zza_zza.uri == null) {
                this.zzaie.zza(this.zzaic.mContext, this.zzaic.zzahX, true);
                return;
            }
            Bitmap zza = this.zzaic.zza(com_google_android_gms_common_images_zza_zza);
            if (zza != null) {
                this.zzaie.zza(this.zzaic.mContext, zza, true);
                return;
            }
            Long l = (Long) this.zzaic.zzaia.get(com_google_android_gms_common_images_zza_zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzaie.zza(this.zzaic.mContext, this.zzaic.zzahX, true);
                    return;
                }
                this.zzaic.zzaia.remove(com_google_android_gms_common_images_zza_zza.uri);
            }
            this.zzaie.zza(this.zzaic.mContext, this.zzaic.zzahX);
            imageReceiver = (ImageReceiver) this.zzaic.zzahZ.get(com_google_android_gms_common_images_zza_zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzaic, com_google_android_gms_common_images_zza_zza.uri);
                this.zzaic.zzahZ.put(com_google_android_gms_common_images_zza_zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzaie);
            if (!(this.zzaie instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.zzaic.zzahY.put(this.zzaie, imageReceiver);
            }
            synchronized (ImageManager.zzahR) {
                if (!ImageManager.zzahS.contains(com_google_android_gms_common_images_zza_zza.uri)) {
                    ImageManager.zzahS.add(com_google_android_gms_common_images_zza_zza.uri);
                    imageReceiver.zzpU();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzahW;

        public zze(zzb com_google_android_gms_common_images_ImageManager_zzb) {
            this.zzahW = com_google_android_gms_common_images_ImageManager_zzb;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.zzahW.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.zzahW.evictAll();
            } else if (level >= 20) {
                this.zzahW.trimToSize(this.zzahW.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        final /* synthetic */ ImageManager zzaic;
        private boolean zzaif;
        private final CountDownLatch zzpy;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzaic = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzaif = z;
            this.zzpy = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzaib;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza com_google_android_gms_common_images_zza = (zza) zza.get(i);
                if (z) {
                    com_google_android_gms_common_images_zza.zza(this.zzaic.mContext, this.mBitmap, false);
                } else {
                    this.zzaic.zzaia.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    com_google_android_gms_common_images_zza.zza(this.zzaic.mContext, this.zzaic.zzahX, false);
                }
                if (!(com_google_android_gms_common_images_zza instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.zzaic.zzahY.remove(com_google_android_gms_common_images_zza);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzcx("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzaic.zzahW != null) {
                if (this.zzaif) {
                    this.zzaic.zzahW.evictAll();
                    System.gc();
                    this.zzaif = false;
                    this.zzaic.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzaic.zzahW.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzaic.zzahZ.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzpy.countDown();
            synchronized (ImageManager.zzahR) {
                ImageManager.zzahS.remove(this.mUri);
            }
        }
    }

    private static final class zzb extends LruCache<zza, Bitmap> {
        public zzb(Context context) {
            super(zzar(context));
        }

        private static int zzar(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !zznx.zzrN()) ? activityManager.getMemoryClass() : zza.zza(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            zza(x0, (zza) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((zza) x0, (Bitmap) x1);
        }

        protected int zza(zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean z, zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, com_google_android_gms_common_images_zza_zza, bitmap, bitmap2);
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.zzahW = new zzb(this.mContext);
            if (zznx.zzrQ()) {
                zzpR();
            }
        } else {
            this.zzahW = null;
        }
        this.zzahX = new zzmx();
        this.zzahY = new HashMap();
        this.zzahZ = new HashMap();
        this.zzaia = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzc(context, false);
    }

    private Bitmap zza(zza com_google_android_gms_common_images_zza_zza) {
        return this.zzahW == null ? null : (Bitmap) this.zzahW.get(com_google_android_gms_common_images_zza_zza);
    }

    public static ImageManager zzc(Context context, boolean z) {
        if (z) {
            if (zzahU == null) {
                zzahU = new ImageManager(context, true);
            }
            return zzahU;
        }
        if (zzahT == null) {
            zzahT = new ImageManager(context, false);
        }
        return zzahT;
    }

    private void zzpR() {
        this.mContext.registerComponentCallbacks(new zze(this.zzahW));
    }

    public void loadImage(ImageView imageView, int resId) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        zza com_google_android_gms_common_images_zza_zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        com_google_android_gms_common_images_zza_zzb.zzbN(defaultResId);
        zza(com_google_android_gms_common_images_zza_zzb);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        zza com_google_android_gms_common_images_zza_zzc = new com.google.android.gms.common.images.zza.zzc(listener, uri);
        com_google_android_gms_common_images_zza_zzc.zzbN(defaultResId);
        zza(com_google_android_gms_common_images_zza_zzc);
    }

    public void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzb.zzcx("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, com_google_android_gms_common_images_zza).run();
    }
}
