package io.card.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.paypal.android.sdk.C0500V;
import com.paypal.android.sdk.cZ;
import com.paypal.android.sdk.dF;
import com.paypal.android.sdk.da;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;

public final class CardIOActivity extends Activity {
    public static final String EXTRA_CAPTURED_CARD_IMAGE = "io.card.payment.capturedCardImage";
    public static final String EXTRA_GUIDE_COLOR = "io.card.payment.guideColor";
    public static final String EXTRA_HIDE_CARDIO_LOGO = "io.card.payment.hideLogo";
    public static final String EXTRA_KEEP_APPLICATION_THEME = "io.card.payment.keepApplicationTheme";
    public static final String EXTRA_LANGUAGE_OR_LOCALE = "io.card.payment.languageOrLocale";
    public static final String EXTRA_NO_CAMERA = "io.card.payment.noCamera";
    public static final String EXTRA_REQUIRE_CVV = "io.card.payment.requireCVV";
    public static final String EXTRA_REQUIRE_EXPIRY = "io.card.payment.requireExpiry";
    public static final String EXTRA_REQUIRE_POSTAL_CODE = "io.card.payment.requirePostalCode";
    public static final String EXTRA_RETURN_CARD_IMAGE = "io.card.payment.returnCardImage";
    public static final String EXTRA_SCAN_EXPIRY = "io.card.payment.scanExpiry";
    public static final String EXTRA_SCAN_INSTRUCTIONS = "io.card.payment.scanInstructions";
    public static final String EXTRA_SCAN_OVERLAY_LAYOUT_ID = "io.card.payment.scanOverlayLayoutId";
    public static final String EXTRA_SCAN_RESULT = "io.card.payment.scanResult";
    public static final String EXTRA_SUPPRESS_CONFIRMATION = "io.card.payment.suppressConfirmation";
    public static final String EXTRA_SUPPRESS_MANUAL_ENTRY = "io.card.payment.suppressManual";
    public static final String EXTRA_SUPPRESS_SCAN = "io.card.payment.suppressScan";
    public static final String EXTRA_USE_CARDIO_LOGO = "io.card.payment.useCardIOLogo";
    public static final String EXTRA_USE_PAYPAL_ACTIONBAR_ICON = "io.card.payment.intentSenderIsPayPal";
    public static final int RESULT_CARD_INFO = 13274384;
    public static final int RESULT_CONFIRMATION_SUPPRESSED;
    public static final int RESULT_ENTRY_CANCELED;
    public static final int RESULT_SCAN_NOT_AVAILABLE;
    public static final int RESULT_SCAN_SUPPRESSED;
    static Bitmap f1009a = null;
    private static int f1010b;
    private static final String f1011c = CardIOActivity.class.getSimpleName();
    private static final long[] f1012d = new long[]{0, 70, 10, 40};
    private static int f1013e;
    private static final int f1014f = 10;
    private static int f1015s = 0;
    private static /* synthetic */ boolean f1016v = (!CardIOActivity.class.desiredAssertionStatus());
    private C0563n f1017g;
    private OrientationEventListener f1018h;
    private C0564o f1019i;
    private CreditCard f1020j;
    private Rect f1021k;
    private int f1022l;
    private int f1023m;
    private boolean f1024n = false;
    private boolean f1025o = false;
    private LinearLayout f1026p;
    private RelativeLayout f1027q;
    private FrameLayout f1028r;
    private CardScanner f1029t;
    private boolean f1030u = false;

    static {
        f1010b = 13274384;
        f1010b = 13274385;
        int i = f1010b;
        f1010b = i + 1;
        RESULT_ENTRY_CANCELED = i;
        i = f1010b;
        f1010b = i + 1;
        RESULT_SCAN_NOT_AVAILABLE = i;
        i = f1010b;
        f1010b = i + 1;
        RESULT_SCAN_SUPPRESSED = i;
        i = f1010b;
        f1010b = i + 1;
        RESULT_CONFIRMATION_SUPPRESSED = i;
        f1013e = 10;
        f1013e = 11;
    }

    private void m800a(float f) {
        if (this.f1026p != null) {
            Animation rotateAnimation = new RotateAnimation(0.0f, f, (float) (this.f1026p.getWidth() / 2), (float) (this.f1026p.getHeight() / 2));
            rotateAnimation.setDuration(0);
            rotateAnimation.setRepeatCount(0);
            rotateAnimation.setFillAfter(true);
            this.f1026p.setAnimation(rotateAnimation);
        }
    }

    private void m801a(int i, Intent intent) {
        setResult(i, intent);
        f1009a = null;
        finish();
    }

    private void m803a(Exception exception) {
        CharSequence a = cZ.m419a(da.ERROR_CAMERA_UNEXPECTED_FAIL);
        Log.e("card.io", "Unkown exception - please send the stack trace to support@card.io", exception);
        Toast makeText = Toast.makeText(this, a, 1);
        makeText.setGravity(17, 0, -75);
        makeText.show();
        this.f1030u = true;
    }

    private void m804a(boolean z) {
        Object obj = (this.f1019i == null || this.f1017g == null || !this.f1029t.m826b(z)) ? null : 1;
        if (obj != null) {
            this.f1017g.m855b(z);
        }
    }

    private void m806b(int i) {
        if (i >= 0 && this.f1029t != null) {
            int i2;
            int rotation = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    rotation = 90;
                } else if (rotation == 2) {
                    rotation = 180;
                } else if (rotation == 3) {
                    rotation = 270;
                }
                rotation += i;
                i2 = rotation <= 360 ? rotation - 360 : rotation;
                rotation = -1;
                if (i2 >= 15 || i2 > 345) {
                    this.f1023m = 1;
                    rotation = 0;
                } else if (i2 > 75 && i2 < 105) {
                    this.f1023m = 4;
                    rotation = 90;
                } else if (i2 > 165 && i2 < 195) {
                    rotation = 180;
                    this.f1023m = 2;
                } else if (i2 > 255 && i2 < 285) {
                    this.f1023m = 3;
                    rotation = 270;
                }
                if (rotation >= 0 && rotation != this.f1022l) {
                    new StringBuilder("onOrientationChanged(").append(rotation).append(") calling setDeviceOrientation(").append(this.f1023m).append(")");
                    this.f1029t.m822a(this.f1023m);
                    m808c(rotation);
                    if (rotation == 90) {
                        m800a((float) BitmapDescriptorFactory.HUE_VIOLET);
                        return;
                    } else if (rotation == 270) {
                        m800a(90.0f);
                        return;
                    } else {
                        m800a((float) rotation);
                        return;
                    }
                }
            }
            rotation = 0;
            rotation += i;
            if (rotation <= 360) {
            }
            rotation = -1;
            if (i2 >= 15) {
            }
            this.f1023m = 1;
            rotation = 0;
            if (rotation >= 0) {
            }
        }
    }

    private void m808c(int i) {
        View a = this.f1019i.m859a();
        if (a == null) {
            Log.wtf("card.io", "surface view is null.. recovering... rotation might be weird.");
            return;
        }
        this.f1021k = this.f1029t.m821a(a.getWidth(), a.getHeight());
        Rect rect = this.f1021k;
        rect.top += a.getTop();
        rect = this.f1021k;
        rect.bottom = a.getTop() + rect.bottom;
        this.f1017g.m849a(this.f1021k, i);
        this.f1022l = i;
    }

    public static boolean canReadCardWithCamera() {
        boolean z = false;
        try {
            z = C0566q.m865a();
        } catch (CameraUnavailableException e) {
        } catch (RuntimeException e2) {
            Log.w(f1011c, "RuntimeException accessing Util.hardwareSupported()");
        }
        return z;
    }

    private void m811e() {
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra(EXTRA_SUPPRESS_CONFIRMATION, false)) {
            new Handler().post(new C0557c(this));
            return;
        }
        Intent intent2 = new Intent(this, DataEntryActivity.class);
        intent2.putExtra(EXTRA_SCAN_RESULT, this.f1020j);
        this.f1020j = null;
        if (!(!intent.getBooleanExtra(EXTRA_RETURN_CARD_IMAGE, false) || this.f1017g == null || this.f1017g.m845a() == null)) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f1017g.m845a().compress(CompressFormat.JPEG, 80, byteArrayOutputStream);
            intent2.putExtra(EXTRA_CAPTURED_CARD_IMAGE, byteArrayOutputStream.toByteArray());
        }
        m801a(RESULT_CONFIRMATION_SUPPRESSED, intent2);
    }

    private boolean m812f() {
        this.f1020j = null;
        if (f1016v || this.f1019i != null) {
            CardScanner cardScanner = this.f1029t;
            SurfaceHolder holder = this.f1019i.m859a().getHolder();
            if (C0564o.f1107a || holder != null) {
                boolean a = cardScanner.m824a(holder);
                if (a) {
                    this.f1027q.setVisibility(0);
                }
                return a;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Bitmap getCapturedCardImage(Intent intent) {
        return (intent == null || !intent.hasExtra(EXTRA_CAPTURED_CARD_IMAGE)) ? null : BitmapFactory.decodeStream(new ByteArrayInputStream(intent.getByteArrayExtra(EXTRA_CAPTURED_CARD_IMAGE)), null, new Options());
    }

    public static Date sdkBuildDate() {
        return new Date(BuildConfig.BUILD_TIME);
    }

    public static String sdkVersion() {
        return BuildConfig.PRODUCT_VERSION;
    }

    final void m813a() {
        m804a(!this.f1029t.m829e());
    }

    final void m814a(int i) {
        SurfaceView a = this.f1019i.m859a();
        if (this.f1017g != null) {
            this.f1017g.m848a(new Rect(a.getLeft(), a.getTop(), a.getRight(), a.getBottom()));
        }
        this.f1023m = 1;
        m808c(0);
        if (1 != this.f1023m) {
            Log.wtf("card.io", "the orientation of the scanner doesn't match the orientation of the activity");
        }
        m816a(new DetectionInfo());
    }

    final void m815a(Bitmap bitmap, DetectionInfo detectionInfo) {
        try {
            ((Vibrator) getSystemService("vibrator")).vibrate(f1012d, -1);
        } catch (SecurityException e) {
            Log.e("card.io", "Could not activate vibration feedback. Please add <uses-permission android:name=\"android.permission.VIBRATE\" /> to your application's manifest.");
        } catch (Throwable e2) {
            Log.w("card.io", "Exception while attempting to vibrate: ", e2);
        }
        this.f1029t.m827c();
        this.f1027q.setVisibility(4);
        if (detectionInfo.complete) {
            this.f1020j = detectionInfo.m836a();
            this.f1017g.m850a(this.f1020j);
        }
        float f = (this.f1023m == 1 || this.f1023m == 2) ? (((float) this.f1021k.right) / 428.0f) * 0.95f : (((float) this.f1021k.right) / 428.0f) * 1.15f;
        Matrix matrix = new Matrix();
        new StringBuilder("Scale factor: ").append(f);
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        this.f1017g.m847a(createBitmap);
        if (this.f1025o) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream);
            Intent intent = new Intent();
            if (getIntent() != null && getIntent().getBooleanExtra(EXTRA_RETURN_CARD_IMAGE, false)) {
                intent.putExtra(EXTRA_CAPTURED_CARD_IMAGE, byteArrayOutputStream.toByteArray());
            }
            m801a(RESULT_SCAN_SUPPRESSED, intent);
            return;
        }
        m811e();
    }

    final void m816a(DetectionInfo detectionInfo) {
        this.f1017g.m851a(detectionInfo);
    }

    final void m817b() {
        this.f1029t.m823a(true);
    }

    public final Rect getTorchRect() {
        return this.f1017g == null ? null : this.f1017g.m858d();
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String.format("onActivityResult(requestCode:%d, resultCode:%d, ...", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == RESULT_CARD_INFO || i2 == RESULT_ENTRY_CANCELED || this.f1030u) {
            if (intent != null && intent.hasExtra(EXTRA_SCAN_RESULT)) {
                new StringBuilder("data entry result: ").append(intent.getParcelableExtra(EXTRA_SCAN_RESULT));
            }
            m801a(i2, intent);
        } else if (this.f1027q != null) {
            this.f1027q.setVisibility(0);
        }
    }

    public final void onBackPressed() {
        if (!this.f1030u) {
            C0563n c0563n = this.f1017g;
        }
        if (this.f1029t != null) {
            super.onBackPressed();
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = f1015s + 1;
        f1015s = i;
        if (i != 1) {
            String.format("INTERNAL WARNING: There are %d (not 1) CardIOActivity allocations!", new Object[]{Integer.valueOf(f1015s)});
        }
        Intent intent = getIntent();
        intent.getBooleanExtra(EXTRA_KEEP_APPLICATION_THEME, false);
        cZ.m421a(intent);
        this.f1025o = intent.getBooleanExtra(EXTRA_SUPPRESS_SCAN, false);
        String a = C0566q.m863a(getPackageManager().resolveActivity(intent, 65536), CardIOActivity.class);
        if (a != null) {
            throw new RuntimeException(a);
        }
        this.f1024n = intent.getBooleanExtra(EXTRA_SUPPRESS_MANUAL_ENTRY, false);
        if (intent.getBooleanExtra(EXTRA_NO_CAMERA, false)) {
            this.f1030u = true;
        } else {
            da daVar;
            try {
                if (!C0566q.m865a()) {
                    daVar = da.ERROR_NO_DEVICE_SUPPORT;
                    Log.w("card.io", daVar + ": " + cZ.m419a(daVar));
                    this.f1030u = true;
                }
            } catch (CameraUnavailableException e) {
                daVar = da.ERROR_CAMERA_CONNECT_FAIL;
                CharSequence a2 = cZ.m419a(daVar);
                Log.e("card.io", daVar + ": " + a2);
                Toast makeText = Toast.makeText(this, a2, 1);
                makeText.setGravity(17, 0, -75);
                makeText.show();
                this.f1030u = true;
            } catch (Exception e2) {
                m803a(e2);
            }
        }
        if (!this.f1030u) {
            try {
                int intExtra;
                requestWindowFeature(1);
                this.f1021k = new Rect();
                this.f1023m = 1;
                if (!intent.getBooleanExtra("io.card.payment.cameraBypassTestMode", false)) {
                    this.f1029t = new CardScanner(this, this.f1023m);
                } else if (getPackageName().contentEquals("io.card.development")) {
                    this.f1029t = (CardScanner) Class.forName("io.card.payment.CardScannerTester").getConstructor(new Class[]{getClass(), Integer.TYPE}).newInstance(new Object[]{this, Integer.valueOf(this.f1023m)});
                } else {
                    Log.e(f1011c, getPackageName() + " is not correct");
                    throw new IllegalStateException("illegal access of private extra");
                }
                this.f1029t.m825b();
                this.f1028r = new FrameLayout(this);
                this.f1028r.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                this.f1028r.setLayoutParams(new LayoutParams(-1, -1));
                View frameLayout = new FrameLayout(this);
                frameLayout.setId(1);
                this.f1029t.getClass();
                this.f1029t.getClass();
                this.f1019i = new C0564o(this, null, 640, 480);
                this.f1019i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 48));
                frameLayout.addView(this.f1019i);
                this.f1017g = new C0563n(this, null, C0566q.m866a((Context) this));
                this.f1017g.setLayoutParams(new LayoutParams(-1, -1));
                if (getIntent() != null) {
                    this.f1017g.m857c(getIntent().getBooleanExtra(EXTRA_USE_CARDIO_LOGO, false));
                    intExtra = getIntent().getIntExtra(EXTRA_GUIDE_COLOR, 0);
                    if (intExtra != 0) {
                        int i2 = ViewCompat.MEASURED_STATE_MASK | intExtra;
                        if (intExtra != i2) {
                            Log.w("card.io", "Removing transparency from provided guide color.");
                        }
                        this.f1017g.m846a(i2);
                    } else {
                        this.f1017g.m846a(-16711936);
                    }
                    this.f1017g.m853a(getIntent().getBooleanExtra(EXTRA_HIDE_CARDIO_LOGO, false));
                    String stringExtra = getIntent().getStringExtra(EXTRA_SCAN_INSTRUCTIONS);
                    if (stringExtra != null) {
                        this.f1017g.m852a(stringExtra);
                    }
                }
                frameLayout.addView(this.f1017g);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                layoutParams.addRule(2, 2);
                this.f1028r.addView(frameLayout, layoutParams);
                this.f1027q = new RelativeLayout(this);
                this.f1027q.setGravity(80);
                LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f1027q.setLayoutParams(layoutParams2);
                this.f1027q.setId(2);
                this.f1027q.setGravity(85);
                if (!this.f1024n) {
                    View button = new Button(this);
                    button.setId(3);
                    button.setText(cZ.m419a(da.KEYBOARD));
                    button.setTextSize(12.0f);
                    button.setOnClickListener(new C0558d(this));
                    this.f1027q.addView(button);
                    dF.m443a(button, false, (Context) this);
                    button.setTextSize(14.0f);
                    button.setMinimumHeight(dF.m439a("42dip", this));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) button.getLayoutParams();
                    layoutParams3.width = -2;
                    layoutParams3.height = -2;
                    layoutParams3.addRule(12);
                    dF.m442a(button, "16dip", null, "16dip", null);
                    dF.m445b(button, "4dip", "4dip", "4dip", "4dip");
                }
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                intExtra = (int) ((getResources().getDisplayMetrics().density * 15.0f) + 0.5f);
                layoutParams2.setMargins(0, intExtra, 0, intExtra);
                this.f1028r.addView(this.f1027q, layoutParams2);
                if (getIntent() != null) {
                    if (this.f1026p != null) {
                        this.f1028r.removeView(this.f1026p);
                        this.f1026p = null;
                    }
                    i = getIntent().getIntExtra(EXTRA_SCAN_OVERLAY_LAYOUT_ID, -1);
                    if (i != -1) {
                        this.f1026p = new LinearLayout(this);
                        this.f1026p.setLayoutParams(new LayoutParams(-1, -1));
                        getLayoutInflater().inflate(i, this.f1026p);
                        this.f1028r.addView(this.f1026p);
                    }
                }
                setContentView(this.f1028r);
                this.f1018h = new C0556b(this, this, 2);
            } catch (Exception e22) {
                m803a(e22);
            }
        }
        if (this.f1030u && this.f1024n) {
            m801a(RESULT_SCAN_NOT_AVAILABLE, null);
        }
    }

    protected final void onDestroy() {
        this.f1017g = null;
        f1015s--;
        if (this.f1029t != null) {
            this.f1029t.m828d();
            this.f1029t = null;
        }
        super.onDestroy();
    }

    protected final void onPause() {
        super.onPause();
        if (this.f1018h != null) {
            this.f1018h.disable();
        }
        m804a(false);
        if (this.f1029t != null) {
            this.f1029t.m827c();
        } else if (!this.f1030u) {
            Log.wtf("card.io", "cardScanner is null in onPause()");
        }
    }

    protected final void onResume() {
        super.onResume();
        if (this.f1030u) {
            m811e();
            return;
        }
        C0566q.m867b();
        getWindow().addFlags(1024);
        getWindow().addFlags(128);
        C0500V.m40b((Activity) this);
        setRequestedOrientation(1);
        this.f1018h.enable();
        if (m812f()) {
            m804a(false);
        } else {
            Log.e(f1011c, "Could not connect to camera.");
            CharSequence a = cZ.m419a(da.ERROR_CAMERA_UNEXPECTED_FAIL);
            Log.e("card.io", "error display: " + a);
            Toast.makeText(this, a, 1).show();
            m811e();
        }
        m806b(this.f1022l);
    }
}
