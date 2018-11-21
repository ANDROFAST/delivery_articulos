package com.paypal.android.sdk;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C0500V {
    private boolean f33a = false;
    private boolean f34b = false;
    private File f35c;

    public C0500V() {
        String externalStorageState = Environment.getExternalStorageState();
        boolean z = true;
        switch (externalStorageState.hashCode()) {
            case 1242932856:
                if (externalStorageState.equals("mounted")) {
                    z = false;
                    break;
                }
                break;
            case 1299749220:
                if (externalStorageState.equals("mounted_ro")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.f34b = true;
                this.f33a = true;
                break;
            case true:
                this.f33a = true;
                this.f34b = false;
                break;
            default:
                this.f34b = false;
                this.f33a = false;
                break;
        }
        this.f35c = Environment.getExternalStorageDirectory();
    }

    public static void m37a(Activity activity) {
        if (C0500V.m41b()) {
            activity.requestWindowFeature(8);
        }
    }

    public static void m38a(Activity activity, TextView textView, String str, String str2, Drawable drawable) {
        activity.setTitle(str2 + str);
        if (C0500V.m41b()) {
            if (activity.getActionBar() != null) {
                ActionBar actionBar = activity.getActionBar();
                actionBar.setBackgroundDrawable(dE.f628b);
                actionBar.setTitle(str);
                TextView textView2 = (TextView) activity.findViewById(Resources.getSystem().getIdentifier("action_bar_title", "id", "android"));
                if (textView2 != null) {
                    textView2.setTextColor(-1);
                }
                actionBar.setDisplayHomeAsUpEnabled(false);
                if (drawable == null || VERSION.SDK_INT < 14) {
                    actionBar.setDisplayShowHomeEnabled(false);
                } else {
                    actionBar.setIcon(drawable);
                }
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
        }
        if (textView != null) {
            textView.setText(str);
        }
    }

    public static boolean m39a() {
        return VERSION.SDK_INT >= 11;
    }

    public static void m40b(Activity activity) {
        if (VERSION.SDK_INT >= 11) {
            activity.getWindow().addFlags(8192);
        }
    }

    private static boolean m41b() {
        return VERSION.SDK_INT >= 11;
    }

    public final void m42a(String str) {
        this.f35c = new File(str);
    }

    public final void m43a(String str, byte[] bArr) {
        Throwable th;
        if (this.f33a && this.f34b) {
            Closeable closeable = null;
            Closeable fileOutputStream;
            try {
                if (this.f35c.mkdirs() || this.f35c.isDirectory()) {
                    fileOutputStream = new FileOutputStream(new File(this.f35c, str));
                    try {
                        fileOutputStream.write(bArr);
                        closeable = fileOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        C0510f.m457a(fileOutputStream);
                        throw th;
                    }
                }
                C0510f.m457a(closeable);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileOutputStream = null;
                th = th4;
                C0510f.m457a(fileOutputStream);
                throw th;
            }
        }
    }

    public final String m44b(String str) {
        Closeable fileInputStream;
        String str2;
        Throwable th;
        byte[] bArr = new byte[1024];
        if (this.f34b) {
            try {
                fileInputStream = new FileInputStream(new File(this.f35c, str));
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = fileInputStream.read(bArr, 0, 1024); read != -1; read = fileInputStream.read(bArr, 0, 1024)) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    C0510f.m457a(fileInputStream);
                } catch (IOException e) {
                    str2 = "";
                    C0510f.m457a(fileInputStream);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    C0510f.m457a(fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                fileInputStream = null;
                str2 = "";
                C0510f.m457a(fileInputStream);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                C0510f.m457a(fileInputStream);
                throw th;
            }
        }
        return new String(bArr, "UTF-8");
    }
}
