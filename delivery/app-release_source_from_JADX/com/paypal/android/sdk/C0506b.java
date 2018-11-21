package com.paypal.android.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.UUID;

public class C0506b {
    private static final String f261a = C0506b.class.getSimpleName();
    private Context f262b;
    private String f263c;
    private final C0513i f264d;

    public C0506b(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context == null");
        } else if (str == null) {
            throw new NullPointerException("prefs == null");
        } else {
            this.f262b = context;
            this.f263c = str;
            String a = C0510f.m452a(m184e());
            this.f264d = new C0513i(a + m181c());
        }
    }

    public final String m176a(String str) {
        return this.f264d.m477b(this.f262b.getSharedPreferences(this.f263c, 0).getString(str, null));
    }

    public final void m177a(String str, String str2) {
        Editor edit = this.f262b.getSharedPreferences(this.f263c, 0).edit();
        edit.putString(str, this.f264d.m476a(str2));
        edit.commit();
    }

    public final boolean m178a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f262b.getSystemService("connectivity");
        if (connectivityManager == null) {
            Log.w("paypal.sdk", "Unable to retrieve Context.CONNECTIVITY_SERVICE. Ignoring.");
            return true;
        } else if (connectivityManager.getAllNetworkInfo() == null) {
            Log.w("paypal.sdk", "ConnectivityManager.getAllNetworkInfo() returned null. Ignoring.");
            return true;
        } else {
            int i = 0;
            for (NetworkInfo isConnectedOrConnecting : connectivityManager.getAllNetworkInfo()) {
                if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                    i++;
                }
            }
            return i > 0;
        }
    }

    public final int m179b() {
        return ((TelephonyManager) this.f262b.getSystemService("phone")).getPhoneType();
    }

    public final String m180b(String str) {
        return this.f264d.m476a(str);
    }

    public final String m181c() {
        try {
            PackageManager packageManager = this.f262b.getPackageManager();
            return packageManager.getPackageInfo(this.f262b.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public final String m182c(String str) {
        return this.f264d.m477b(str);
    }

    public final String m183d() {
        try {
            return ((TelephonyManager) this.f262b.getSystemService("phone")).getSimOperatorName();
        } catch (SecurityException e) {
            e.toString();
            return null;
        }
    }

    public final String m184e() {
        String string = this.f262b.getSharedPreferences(this.f263c, 0).getString("InstallationGUID", null);
        if (string != null) {
            return string;
        }
        string = UUID.randomUUID().toString();
        Editor edit = this.f262b.getSharedPreferences(this.f263c, 0).edit();
        edit.putString("InstallationGUID", string);
        edit.commit();
        return string;
    }

    public final Context m185f() {
        return this.f262b;
    }
}
