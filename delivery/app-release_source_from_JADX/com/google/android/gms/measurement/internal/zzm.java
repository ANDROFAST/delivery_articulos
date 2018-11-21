package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.zza;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzm extends zzw {
    private static final X500Principal zzaTf = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String zzRk;
    private String zzRl;
    private String zzaRd;
    private String zzaSf;
    private String zzaSj;
    private long zzaTg;

    zzm(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    static long zzp(byte[] bArr) {
        long j = null;
        zzx.zzy(bArr);
        zzx.zzaa(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    String zzBi() {
        zzje();
        if (zzAX().zzka()) {
            return "";
        }
        if (this.zzaSf == null) {
            Status zzaS = zza.zzaS(getContext());
            if (zzaS == null || !zzaS.isSuccess()) {
                this.zzaSf = "";
                zzzz().zzBl().zzj("getGoogleAppId failed with status", Integer.valueOf(zzaS == null ? 0 : zzaS.getStatusCode()));
                if (!(zzaS == null || zzaS.getStatusMessage() == null)) {
                    zzzz().zzBq().zzez(zzaS.getStatusMessage());
                }
            } else {
                try {
                    if (zza.zzzC()) {
                        String zzzA = zza.zzzA();
                        if (TextUtils.isEmpty(zzzA)) {
                            zzzA = "";
                        }
                        this.zzaSf = zzzA;
                    } else {
                        this.zzaSf = "";
                    }
                } catch (IllegalStateException e) {
                    this.zzaSf = "";
                    zzzz().zzBl().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", e);
                }
            }
        }
        return this.zzaSf;
    }

    long zzBj() {
        zzje();
        return this.zzaTg;
    }

    boolean zzBk() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(zzaTf);
            }
        } catch (CertificateException e) {
            zzzz().zzBl().zzj("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzzz().zzBl().zzj("Package name not found", e2);
        }
        return true;
    }

    AppMetadata zzex(String str) {
        return new AppMetadata(this.zzaRd, zzBi(), this.zzRl, this.zzaSj, zzAX().zzAE(), zzBj(), str, zzAW().zzzC());
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    protected void zzir() {
        String str = "Unknown";
        String str2 = "Unknown";
        PackageManager packageManager = getContext().getPackageManager();
        String packageName = getContext().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if (GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE.equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            zzzz().zzBl().zzj("Error retrieving package info: appName", str2);
        }
        this.zzaRd = packageName;
        this.zzaSj = installerPackageName;
        this.zzRl = str;
        this.zzRk = str2;
        long j = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (!zzBk()) {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(getContext().getPackageName(), 64);
                if (!(instance == null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0)) {
                    j = zzp(instance.digest(packageInfo2.signatures[0].toByteArray()));
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            zzzz().zzBl().zzj("Could not get MD5 instance", e2);
        } catch (NameNotFoundException e3) {
            zzzz().zzBl().zzj("Package name not found", e3);
        }
        this.zzaTg = j;
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
