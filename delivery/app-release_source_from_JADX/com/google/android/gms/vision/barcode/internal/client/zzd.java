package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd {
    private final Context mContext;
    private final BarcodeDetectorOptions zzbip;
    private zzb zzbir = null;
    private final Object zzpK = new Object();

    static class zza extends zzg<zzc> {
        private static zza zzbis;

        zza() {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }

        static zzb zza(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            if (zzbis == null) {
                zzbis = new zza();
            }
            return zzbis.zzb(context, barcodeDetectorOptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            try {
                return ((zzc) zzaA(context)).zza(zze.zzB(context), barcodeDetectorOptions);
            } catch (Throwable e) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e);
                return null;
            } catch (Throwable e2) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e2);
                return null;
            }
        }

        protected /* synthetic */ Object zzd(IBinder iBinder) {
            return zzea(iBinder);
        }

        protected zzc zzea(IBinder iBinder) {
            return com.google.android.gms.vision.barcode.internal.client.zzc.zza.zzdZ(iBinder);
        }
    }

    public zzd(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
        this.mContext = context;
        this.zzbip = barcodeDetectorOptions;
        zzGl();
    }

    private zzb zzGl() {
        zzb com_google_android_gms_vision_barcode_internal_client_zzb;
        synchronized (this.zzpK) {
            if (this.zzbir == null) {
                this.zzbir = zza.zza(this.mContext, this.zzbip);
            }
            com_google_android_gms_vision_barcode_internal_client_zzb = this.zzbir;
        }
        return com_google_android_gms_vision_barcode_internal_client_zzb;
    }

    public boolean isOperational() {
        return zzGl() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel frameMetadataParcel) {
        zzb zzGl = zzGl();
        if (zzGl == null) {
            return new Barcode[0];
        }
        try {
            return zzGl.zzb(zze.zzB(bitmap), frameMetadataParcel);
        } catch (Throwable e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public Barcode[] zza(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzb zzGl = zzGl();
        if (zzGl == null) {
            return new Barcode[0];
        }
        try {
            return zzGl.zza(zze.zzB(byteBuffer), frameMetadataParcel);
        } catch (Throwable e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }
}
