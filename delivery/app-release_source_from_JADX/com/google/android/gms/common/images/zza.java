package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

public abstract class zza {
    final zza zzaig;
    protected int zzaih = 0;
    protected int zzaii = 0;
    protected boolean zzaij = false;
    protected OnImageLoadedListener zzaik;
    private boolean zzail = true;
    private boolean zzaim = false;
    private boolean zzain = true;
    protected int zzaio;

    static final class zza {
        public final Uri uri;

        public zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof zza) {
                return this == obj ? true : zzw.equal(((zza) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzaip;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.zzaip = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.zzaip = new WeakReference(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof zzmw)) {
                int zzpX = ((zzmw) imageView).zzpX();
                if (this.zzaii != 0 && zzpX == this.zzaii) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            Drawable newDrawable = (!this.zzaij || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zzb) {
                newDrawable = zza(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof zzmw) {
                zzmw com_google_android_gms_internal_zzmw = (zzmw) imageView;
                com_google_android_gms_internal_zzmw.zzm(z3 ? this.zzaig.uri : null);
                com_google_android_gms_internal_zzmw.zzbP(obj != null ? this.zzaii : 0);
            }
            if (zzb) {
                ((zzmu) newDrawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzaip.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzaip.get();
            boolean z = (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzaip.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> zzaiq;

        public zzc(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(onImageLoadedListener);
            this.zzaiq = new WeakReference(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_common_images_zza_zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzaiq.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zza_zzc.zzaiq.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(com_google_android_gms_common_images_zza_zzc.zzaig, this.zzaig);
            return z;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzaig);
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzaiq.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.zzaig.uri, drawable, z3);
                }
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzaig = new zza(uri);
        this.zzaii = i;
    }

    private Drawable zza(Context context, zzmx com_google_android_gms_internal_zzmx, int i) {
        Resources resources = context.getResources();
        if (this.zzaio <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.internal.zzmx.zza com_google_android_gms_internal_zzmx_zza = new com.google.android.gms.internal.zzmx.zza(i, this.zzaio);
        Drawable drawable = (Drawable) com_google_android_gms_internal_zzmx.get(com_google_android_gms_internal_zzmx_zza);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.zzaio & 1) != 0) {
            drawable = zza(resources, drawable);
        }
        com_google_android_gms_internal_zzmx.put(com_google_android_gms_internal_zzmx_zza, drawable);
        return drawable;
    }

    protected Drawable zza(Resources resources, Drawable drawable) {
        return zzmv.zza(resources, drawable);
    }

    protected zzmu zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzmu) {
            drawable = ((zzmu) drawable).zzpV();
        }
        return new zzmu(drawable, drawable2);
    }

    void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzu(bitmap);
        if ((this.zzaio & 1) != 0) {
            bitmap = zzmv.zza(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzaik != null) {
            this.zzaik.onImageLoaded(this.zzaig.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    void zza(Context context, zzmx com_google_android_gms_internal_zzmx) {
        if (this.zzain) {
            Drawable drawable = null;
            if (this.zzaih != 0) {
                drawable = zza(context, com_google_android_gms_internal_zzmx, this.zzaih);
            }
            zza(drawable, false, true, false);
        }
    }

    void zza(Context context, zzmx com_google_android_gms_internal_zzmx, boolean z) {
        Drawable drawable = null;
        if (this.zzaii != 0) {
            drawable = zza(context, com_google_android_gms_internal_zzmx, this.zzaii);
        }
        if (this.zzaik != null) {
            this.zzaik.onImageLoaded(this.zzaig.uri, drawable, false);
        }
        zza(drawable, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzb(boolean z, boolean z2) {
        return this.zzail && !z2 && (!z || this.zzaim);
    }

    public void zzbN(int i) {
        this.zzaii = i;
    }
}
