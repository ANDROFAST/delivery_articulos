package io.card.payment;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.util.Log;
import java.util.List;

class C0566q {
    private static final boolean f1116a = Build.MODEL.equals("DROID2");
    private static Boolean f1117b;

    static {
        C0566q.class.getSimpleName();
    }

    C0566q() {
    }

    public static Rect m862a(Point point, int i, int i2) {
        return new Rect(point.x - (i / 2), point.y - (i2 / 2), point.x + (i / 2), point.y + (i2 / 2));
    }

    public static String m863a(ResolveInfo resolveInfo, Class cls) {
        int i = 1;
        String str = null;
        if (resolveInfo == null) {
            str = String.format("Didn't find %s in the AndroidManifest.xml", new Object[]{cls.getName()});
        } else {
            if ((resolveInfo.activityInfo.configChanges & 128) != 128) {
                i = 0;
            }
            if (i == 0) {
                str = cls.getName() + " requires attribute android:configChanges=\"orientation\"";
            }
        }
        if (str != null) {
            Log.e("card.io", str);
        }
        return str;
    }

    public static void m864a(Paint paint) {
        paint.setColor(-1);
        paint.setStyle(Style.FILL);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        paint.setAntiAlias(true);
        paint.setShadowLayer(1.5f, 0.5f, 0.0f, Color.HSVToColor(200, new float[]{0.0f, 0.0f, 0.0f}));
    }

    public static boolean m865a() {
        if (f1117b == null) {
            f1117b = Boolean.valueOf(C0566q.m868c());
        }
        return f1117b.booleanValue();
    }

    public static boolean m866a(Context context) {
        return !f1116a && context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static void m867b() {
        new StringBuilder("Native memory stats: ").append("(free/alloc'd/total)" + Debug.getNativeHeapFreeSize() + "/" + Debug.getNativeHeapAllocatedSize() + "/" + Debug.getNativeHeapSize());
    }

    private static boolean m868c() {
        if (VERSION.SDK_INT < 8) {
            Log.w("card.io", "- Android SDK too old. Minimum Android 2.2 / API level 8+ (Froyo) required");
            return false;
        } else if (CardScanner.m818a()) {
            try {
                Camera open = Camera.open();
                if (open == null) {
                    Log.w("card.io", "- No camera found");
                    return false;
                }
                Object obj;
                List<Size> supportedPreviewSizes = open.getParameters().getSupportedPreviewSizes();
                open.release();
                for (Size size : supportedPreviewSizes) {
                    if (size.width == 640 && size.height == 480) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    return true;
                }
                Log.w("card.io", "- Camera resolution is insufficient");
                return false;
            } catch (RuntimeException e) {
                Log.w("card.io", "- Error opening camera: " + e);
                throw new CameraUnavailableException();
            }
        } else {
            Log.w("card.io", "- Processor type is not supported");
            return false;
        }
    }
}
