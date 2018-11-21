package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAdshieldEvent.AdShieldEvent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class zzal extends zzak {
    private static long startTime = 0;
    private static Method zznA;
    private static Method zznB;
    private static Method zznC;
    private static Method zznD;
    private static Method zznE;
    private static Method zznF;
    private static String zznG;
    private static String zznH;
    private static String zznI;
    private static zzar zznJ;
    static boolean zznK = false;
    protected static com.google.android.gms.clearcut.zza zznL = null;
    protected static AdShieldEvent zznM;
    protected static int zznN;
    private static Random zznO = new Random();
    private static GoogleApiAvailability zznP = GoogleApiAvailability.getInstance();
    private static boolean zznQ;
    protected static boolean zznR = false;
    protected static boolean zznS = false;
    protected static boolean zznT = false;
    protected static boolean zznU = false;
    private static Method zznt;
    private static Method zznu;
    private static Method zznv;
    private static Method zznw;
    private static Method zznx;
    private static Method zzny;
    private static Method zznz;

    static class zza extends Exception {
        public zza(Throwable th) {
            super(th);
        }
    }

    protected zzal(Context context, zzap com_google_android_gms_internal_zzap, zzaq com_google_android_gms_internal_zzaq) {
        super(context, com_google_android_gms_internal_zzap, com_google_android_gms_internal_zzaq);
        zznM = new AdShieldEvent();
        zznM.appId = context.getPackageName();
    }

    private void zzU() {
        if (zznU && zznL != null) {
            zznL.zza(zznr, 100, TimeUnit.MILLISECONDS);
            zznr.disconnect();
        }
    }

    static String zzV() throws zza {
        if (zznG != null) {
            return zznG;
        }
        throw new zza();
    }

    static Long zzW() throws zza {
        if (zznt == null) {
            throw new zza();
        }
        try {
            return (Long) zznt.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static String zzX() throws zza {
        if (zznv == null) {
            throw new zza();
        }
        try {
            return (String) zznv.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static Long zzY() throws zza {
        if (zznu == null) {
            throw new zza();
        }
        try {
            return (Long) zznu.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static String zza(Context context, zzap com_google_android_gms_internal_zzap) throws zza {
        if (zznH != null) {
            return zznH;
        }
        if (zznw == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznw.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zznH = com_google_android_gms_internal_zzap.zza(byteBuffer.array(), true);
            return zznH;
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zza {
        if (zznx == null || motionEvent == null) {
            throw new zza();
        }
        try {
            return (ArrayList) zznx.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    protected static void zza(int i, int i2) throws IOException {
        if (zznU && zznR && zznL != null) {
            com.google.android.gms.clearcut.zza.zza zzi = zznL.zzi(zztk.toByteArray(zznM));
            zzi.zzbr(i2);
            zzi.zzbq(i);
            zzi.zzc(zznr);
        }
    }

    protected static synchronized void zza(String str, Context context, zzap com_google_android_gms_internal_zzap) {
        boolean z = true;
        synchronized (zzal.class) {
            if (!zznK) {
                try {
                    zznJ = new zzar(com_google_android_gms_internal_zzap, null);
                    zznG = str;
                    zzbz.initialize(context);
                    zzm(context);
                    startTime = zzW().longValue();
                    zznO = new Random();
                    try {
                        zznr = new Builder(context).addApi(com.google.android.gms.clearcut.zza.API).build();
                        zznP = GoogleApiAvailability.getInstance();
                        if (zznP.isGooglePlayServicesAvailable(context) != 0) {
                            z = false;
                        }
                        zznQ = z;
                        zzbz.initialize(context);
                        zznR = ((Boolean) zzbz.zzwD.get()).booleanValue();
                        zznL = new com.google.android.gms.clearcut.zza(context, "ADSHIELD", null, null);
                    } catch (NoClassDefFoundError e) {
                    }
                    zznK = true;
                } catch (zza e2) {
                } catch (UnsupportedOperationException e3) {
                }
            }
        }
    }

    static String zzb(Context context, zzap com_google_android_gms_internal_zzap) throws zza {
        if (zznI != null) {
            return zznI;
        }
        if (zznz == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznz.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zznI = com_google_android_gms_internal_zzap.zza(byteBuffer.array(), true);
            return zznI;
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    private static String zzb(byte[] bArr, String str) throws zza {
        try {
            return new String(zznJ.zzc(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    private void zze(Context context) {
        if (zznQ) {
            zznr.connect();
            zznU = true;
            return;
        }
        zznU = false;
    }

    static String zzf(Context context) throws zza {
        if (zzny == null) {
            throw new zza();
        }
        try {
            String str = (String) zzny.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new zza();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static String zzg(Context context) throws zza {
        if (zznC == null) {
            throw new zza();
        }
        try {
            return (String) zznC.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static Long zzh(Context context) throws zza {
        if (zznD == null) {
            throw new zza();
        }
        try {
            return (Long) zznD.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zzi(Context context) throws zza {
        if (zznA == null) {
            throw new zza();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) zznA.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new zza();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static int[] zzj(Context context) throws zza {
        if (zznB == null) {
            throw new zza();
        }
        try {
            return (int[]) zznB.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static int zzk(Context context) throws zza {
        if (zznE == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznE.invoke(null, new Object[]{context})).intValue();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static int zzl(Context context) throws zza {
        if (zznF == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznF.invoke(null, new Object[]{context})).intValue();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    private static void zzm(Context context) throws zza {
        File file;
        File createTempFile;
        try {
            byte[] zzl = zznJ.zzl(zzat.getKey());
            byte[] zzc = zznJ.zzc(zzl, zzat.zzae());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new zza();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(zzb(zzl, zzat.zzan()));
            Class loadClass2 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaB()));
            Class loadClass3 = dexClassLoader.loadClass(zzb(zzl, zzat.zzav()));
            Class loadClass4 = dexClassLoader.loadClass(zzb(zzl, zzat.zzar()));
            Class loadClass5 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaD()));
            Class loadClass6 = dexClassLoader.loadClass(zzb(zzl, zzat.zzap()));
            Class loadClass7 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaz()));
            Class loadClass8 = dexClassLoader.loadClass(zzb(zzl, zzat.zzax()));
            Class loadClass9 = dexClassLoader.loadClass(zzb(zzl, zzat.zzal()));
            Class loadClass10 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaj()));
            Class loadClass11 = dexClassLoader.loadClass(zzb(zzl, zzat.zzah()));
            Class loadClass12 = dexClassLoader.loadClass(zzb(zzl, zzat.zzat()));
            Class loadClass13 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaf()));
            zznt = loadClass.getMethod(zzb(zzl, zzat.zzao()), new Class[0]);
            zznu = loadClass2.getMethod(zzb(zzl, zzat.zzaC()), new Class[0]);
            zznv = loadClass3.getMethod(zzb(zzl, zzat.zzaw()), new Class[0]);
            zznw = loadClass4.getMethod(zzb(zzl, zzat.zzas()), new Class[]{Context.class});
            zznx = loadClass5.getMethod(zzb(zzl, zzat.zzaE()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            zzny = loadClass6.getMethod(zzb(zzl, zzat.zzaq()), new Class[]{Context.class});
            zznz = loadClass7.getMethod(zzb(zzl, zzat.zzaA()), new Class[]{Context.class});
            zznA = loadClass8.getMethod(zzb(zzl, zzat.zzay()), new Class[]{Context.class});
            zznB = loadClass9.getMethod(zzb(zzl, zzat.zzam()), new Class[]{Context.class});
            zznC = loadClass10.getMethod(zzb(zzl, zzat.zzak()), new Class[]{Context.class});
            zznD = loadClass11.getMethod(zzb(zzl, zzat.zzai()), new Class[]{Context.class});
            zznE = loadClass12.getMethod(zzb(zzl, zzat.zzau()), new Class[]{Context.class});
            zznF = loadClass13.getMethod(zzb(zzl, zzat.zzag()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        } catch (Throwable e22) {
            throw new zza(e22);
        } catch (Throwable e222) {
            throw new zza(e222);
        } catch (Throwable e2222) {
            throw new zza(e2222);
        } catch (Throwable e22222) {
            throw new zza(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    protected void zzc(Context context) {
        try {
            zze(context);
            zznN = zznO.nextInt();
            zza(0, zznN);
            try {
                zza(1, zzX());
                zza(1, zznN);
            } catch (zza e) {
            }
            try {
                zza(2, zzV());
                zza(2, zznN);
            } catch (zza e2) {
            }
            try {
                long longValue = zzW().longValue();
                zza(25, longValue);
                if (startTime != 0) {
                    zza(17, longValue - startTime);
                    zza(23, startTime);
                }
                zza(25, zznN);
            } catch (zza e3) {
            }
            try {
                ArrayList zzi = zzi(context);
                zza(31, ((Long) zzi.get(0)).longValue());
                zza(32, ((Long) zzi.get(1)).longValue());
                zza(31, zznN);
            } catch (zza e4) {
            }
            try {
                zza(33, zzY().longValue());
                zza(33, zznN);
            } catch (zza e5) {
            }
            try {
                if (!(zznS && zznT)) {
                    zza(27, zza(context, this.zznq));
                }
                zza(27, zznN);
            } catch (zza e6) {
            }
            try {
                zza(29, zzb(context, this.zznq));
                zza(29, zznN);
            } catch (zza e7) {
            }
            try {
                int[] zzj = zzj(context);
                zza(5, (long) zzj[0]);
                zza(6, (long) zzj[1]);
                zza(5, zznN);
            } catch (zza e8) {
            }
            try {
                zza(12, (long) zzk(context));
                zza(12, zznN);
            } catch (zza e9) {
            }
            try {
                zza(3, (long) zzl(context));
                zza(3, zznN);
            } catch (zza e10) {
            }
            try {
                zza(34, zzg(context));
                zza(34, zznN);
            } catch (zza e11) {
            }
            try {
                zza(35, zzh(context).longValue());
                zza(35, zznN);
            } catch (zza e12) {
            }
            zzU();
        } catch (IOException e13) {
        }
    }

    protected void zzd(Context context) {
        try {
            zze(context);
            zznN = zznO.nextInt();
            try {
                zza(2, zzV());
            } catch (zza e) {
            }
            try {
                zza(1, zzX());
            } catch (zza e2) {
            }
            try {
                zza(25, zzW().longValue());
            } catch (zza e3) {
            }
            zza(0, zznN);
            try {
                ArrayList zza = zza(this.zzno, this.zznp);
                zza(14, ((Long) zza.get(0)).longValue());
                zza(15, ((Long) zza.get(1)).longValue());
                if (zza.size() >= 3) {
                    zza(16, ((Long) zza.get(2)).longValue());
                }
                zza(14, zznN);
            } catch (zza e4) {
            }
            try {
                zza(34, zzg(context));
            } catch (zza e5) {
            }
            try {
                zza(35, zzh(context).longValue());
            } catch (zza e6) {
            }
            zzU();
        } catch (IOException e7) {
        }
    }
}
