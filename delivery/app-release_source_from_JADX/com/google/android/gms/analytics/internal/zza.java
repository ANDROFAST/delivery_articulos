package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public class zza extends zzd {
    public static boolean zzOB;
    private Info zzOC;
    private final zzaj zzOD;
    private String zzOE;
    private boolean zzOF = false;
    private Object zzOG = new Object();

    zza(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.zzOD = new zzaj(com_google_android_gms_analytics_internal_zzf.zziT());
    }

    private boolean zza(Info info, Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzjT = zziZ().zzjT();
        synchronized (this.zzOG) {
            if (!this.zzOF) {
                this.zzOE = zziJ();
                this.zzOF = true;
            } else if (TextUtils.isEmpty(this.zzOE)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    boolean zzaZ = zzaZ(id + zzjT);
                    return zzaZ;
                }
                this.zzOE = zzaY(str + zzjT);
            }
            Object zzaY = zzaY(id + zzjT);
            if (TextUtils.isEmpty(zzaY)) {
                return false;
            } else if (zzaY.equals(this.zzOE)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.zzOE)) {
                    str = zzjT;
                } else {
                    zzba("Resetting the client id because Advertising Id changed.");
                    str = zziZ().zzjU();
                    zza("New client Id", str);
                }
                zzaZ = zzaZ(id + str);
                return zzaZ;
            }
        }
    }

    private static String zzaY(String str) {
        if (zzam.zzbs("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzam.zzbs("MD5").digest(str.getBytes()))});
    }

    private boolean zzaZ(String str) {
        try {
            String zzaY = zzaY(str);
            zzba("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzaY.getBytes());
            openFileOutput.close();
            this.zzOE = zzaY;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private synchronized Info zziH() {
        if (this.zzOD.zzv(1000)) {
            this.zzOD.start();
            Info zziI = zziI();
            if (zza(this.zzOC, zziI)) {
                this.zzOC = zziI;
            } else {
                zzbe("Failed to reset client id on adid change. Not using adid");
                this.zzOC = new Info("", false);
            }
        }
        return this.zzOC;
    }

    public boolean zziC() {
        zzje();
        Info zziH = zziH();
        return (zziH == null || zziH.isLimitAdTrackingEnabled()) ? false : true;
    }

    public String zziG() {
        zzje();
        Info zziH = zziH();
        CharSequence id = zziH != null ? zziH.getId() : null;
        return TextUtils.isEmpty(id) ? null : id;
    }

    protected Info zziI() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException e) {
            zzbd("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!zzOB) {
                zzOB = true;
                zzd("Error getting advertiser id", th);
            }
        }
        return info;
    }

    protected String zziJ() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzbd("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzba("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    zzd("Error reading Hash file, deleting it", obj);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            zzd("Error reading Hash file, deleting it", obj);
            getContext().deleteFile("gaClientIdData");
            return str;
        }
    }

    protected void zzir() {
    }
}
