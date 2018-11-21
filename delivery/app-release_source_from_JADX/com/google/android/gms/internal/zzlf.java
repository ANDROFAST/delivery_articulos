package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld.zza;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlf extends zzle {
    public static final List<String> zzWA = Collections.singletonList("email");
    private Class<?> zzWB;
    private Class<?> zzWC;
    private Object zzWD;
    private Object zzWE;

    class C03551 implements InvocationHandler {
        final /* synthetic */ zzlf zzWF;

        C03551(zzlf com_google_android_gms_internal_zzlf) {
            this.zzWF = com_google_android_gms_internal_zzlf;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class cls = Class.forName("com.facebook.login.LoginResult");
            Class cls2 = Class.forName("com.facebook.FacebookException");
            Class[] parameterTypes = method.getParameterTypes();
            if (method.getName().equals("onSuccess") && parameterTypes.length == 1 && args[0].getClass() == cls) {
                this.zzWF.zznc().zzk(this.zzWF.zza(IdpTokenType.zzWc, (String) Class.forName("com.facebook.AccessToken").getMethod("getToken", new Class[0]).invoke(cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(args[0], new Object[0]), new Object[0]), this.zzWF.zznd()));
            } else if (method.getName().equals("onCancel") && parameterTypes.length == 0) {
                this.zzWF.zznc().zzmV();
            } else if (method.getName().equals("onError") && parameterTypes.length == 1 && parameterTypes[0] == cls2) {
                Log.e("AuthSignInClient", "facebook login error!", (Exception) args[0]);
                this.zzWF.zznc().zza((Exception) args[0]);
            } else {
                throw new ExceptionInInitializerError("Method not supported!");
            }
            return null;
        }
    }

    public zzlf(Activity activity, List<String> list) {
        super(activity, zzWA, list);
    }

    public static void zzag(Context context) throws IllegalStateException {
        zzx.zzy(context);
        Class cls;
        Throwable e;
        try {
            try {
                Class.forName("com.facebook.FacebookSdk").getDeclaredMethod("sdkInitialize", new Class[]{Context.class, Integer.TYPE}).invoke(null, new Object[]{context.getApplicationContext(), Integer.valueOf(64206)});
                cls = Class.forName("com.facebook.login.LoginManager");
                cls.getDeclaredMethod("logOut", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
                return;
            } catch (NoSuchMethodException e2) {
                e = e2;
            } catch (IllegalAccessException e3) {
                e = e3;
            } catch (InvocationTargetException e4) {
                e = e4;
            }
            Log.e("AuthSignInClient", "Facebook logout error.", e);
            throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
        } catch (ClassNotFoundException e5) {
            try {
                cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    cls.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(invoke, new Object[0]);
                }
            } catch (ClassNotFoundException e6) {
                e = e6;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (NoSuchMethodException e7) {
                e = e7;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (IllegalAccessException e8) {
                e = e8;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (InvocationTargetException e9) {
                e = e9;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
    }

    private void zzne() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.zzWE != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class}).invoke(this.zzWE, new Object[]{this.mActivity, new ArrayList(zznb())});
            return;
        }
        Class cls = Class.forName("com.facebook.Session$OpenRequest");
        Object newInstance = cls.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.mActivity});
        cls.getDeclaredMethod("setPermissions", new Class[]{List.class}).invoke(newInstance, new Object[]{new ArrayList(zznb())});
        cls.getDeclaredMethod("setRequestCode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(64206)});
        Class cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")}).invoke(newInstance, new Object[]{zzng()});
        Object newInstance2 = cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mActivity});
        cls2.getDeclaredMethod("setActiveSession", new Class[]{cls2}).invoke(null, new Object[]{newInstance2});
        cls2.getDeclaredMethod("openForRead", new Class[]{cls}).invoke(newInstance2, new Object[]{newInstance});
    }

    private Object zznf() throws ClassNotFoundException {
        return Proxy.newProxyInstance(Class.forName("com.facebook.FacebookCallback").getClassLoader(), new Class[]{r0}, new C03551(this));
    }

    private Object zzng() throws ClassNotFoundException {
        final Class cls = Class.forName("com.facebook.Session");
        return Proxy.newProxyInstance(Class.forName("com.facebook.Session$StatusCallback").getClassLoader(), new Class[]{r1}, new InvocationHandler(this) {
            final /* synthetic */ zzlf zzWF;

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class cls = Class.forName("com.facebook.SessionState");
                Class[] parameterTypes = method.getParameterTypes();
                if (method.getName().equals("call") && parameterTypes.length == 3 && parameterTypes[0] == cls && parameterTypes[1] == cls && parameterTypes[2] == Exception.class) {
                    if (((Boolean) cls.getDeclaredMethod("isOpened", new Class[0]).invoke(args[0], new Object[0])).booleanValue()) {
                        this.zzWF.zznc().zzk(this.zzWF.zza(IdpTokenType.zzWc, (String) cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(args[0], new Object[0]), this.zzWF.zznd()));
                    }
                    return null;
                }
                throw new ExceptionInInitializerError("Method not supported!");
            }
        });
    }

    public void zza(zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        zzb(null, null, (zza) zzx.zzy(com_google_android_gms_internal_zzld_zza));
        try {
            zzne();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        zzb((String) zzx.zzy(str), null, (zza) zzx.zzy(com_google_android_gms_internal_zzld_zza));
        try {
            zzne();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, String str2, zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        zzb((String) zzx.zzy(str), (String) zzx.zzy(str2), (zza) zzx.zzy(com_google_android_gms_internal_zzld_zza));
        try {
            zzne();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public boolean zza(int i, int i2, Intent intent, zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        zzb(com_google_android_gms_internal_zzld_zza);
        if (i != 64206 && this.zzWB == null) {
            return false;
        }
        if (this.zzWB == null || this.zzWC == null || this.zzWD == null) {
            try {
                Class cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                Method declaredMethod = cls.getDeclaredMethod("onActivityResult", new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) declaredMethod.invoke(invoke, new Object[]{this.mActivity, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (InvocationTargetException e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        }
        try {
            if (!((Boolean) this.zzWB.getDeclaredMethod("isFacebookRequestCode", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)})).booleanValue()) {
                return false;
            }
            return ((Boolean) this.zzWC.getDeclaredMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(this.zzWD, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new RuntimeException(e);
        }
    }

    public void zzaf(Context context) {
        zzx.zzy(context);
        try {
            Throwable e;
            this.zzWB = Class.forName("com.facebook.FacebookSdk");
            try {
                this.zzWB.getDeclaredMethod("sdkInitialize", new Class[]{Context.class, Integer.TYPE}).invoke(null, new Object[]{context.getApplicationContext(), Integer.valueOf(64206)});
                this.zzWD = Class.forName("com.facebook.CallbackManager$Factory").getDeclaredMethod("create", new Class[0]).invoke(null, new Object[0]);
                Class cls = Class.forName("com.facebook.login.LoginManager");
                this.zzWE = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                this.zzWC = Class.forName("com.facebook.CallbackManager");
                Class cls2 = Class.forName("com.facebook.FacebookCallback");
                cls.getDeclaredMethod("registerCallback", new Class[]{this.zzWC, cls2}).invoke(this.zzWE, new Object[]{this.zzWD, zznf()});
                return;
            } catch (ClassNotFoundException e2) {
                e = e2;
            } catch (NoSuchMethodException e3) {
                e = e3;
            } catch (IllegalAccessException e4) {
                e = e4;
            } catch (InvocationTargetException e5) {
                e = e5;
            }
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e6) {
            try {
                Class.forName("com.facebook.Session");
            } catch (ClassNotFoundException e7) {
                throw new RuntimeException("No supported Facebook sdk found.");
            }
        }
    }

    public zze zzna() {
        return zze.FACEBOOK;
    }
}
