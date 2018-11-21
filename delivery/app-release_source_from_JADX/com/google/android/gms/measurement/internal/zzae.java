package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzqq.zzb;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.internal.zztd;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zzae extends zzv {
    zzae(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Double) {
            return Float.valueOf((float) ((Double) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return null;
            }
            String valueOf = String.valueOf(obj);
            return valueOf.length() > i ? z ? valueOf.substring(0, i) : null : valueOf;
        }
    }

    private void zza(String str, String str2, int i, Object obj) {
        if (obj == null) {
            zzzz().zzBo().zzj(str + " value can't be null. Ignoring " + str, str2);
        } else if (!(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.length() > i) {
                    zzzz().zzBo().zze("Ignoring " + str + ". Value is too long. name, value length", str2, Integer.valueOf(valueOf.length()));
                }
            }
        }
    }

    public static boolean zza(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean zza(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    private int zzeH(String str) {
        return "_ldl".equals(str) ? zzAX().zzAy() : zzAX().zzAx();
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

    public void zza(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            zzzz().zzBo().zze("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public void zza(zzb com_google_android_gms_internal_zzqq_zzb, Object obj) {
        zzx.zzy(obj);
        com_google_android_gms_internal_zzqq_zzb.zzakS = null;
        com_google_android_gms_internal_zzqq_zzb.zzaVo = null;
        com_google_android_gms_internal_zzqq_zzb.zzaVi = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzqq_zzb.zzakS = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzqq_zzb.zzaVo = (Long) obj;
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzqq_zzb.zzaVi = (Float) obj;
        } else {
            zzzz().zzBl().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zze com_google_android_gms_internal_zzqq_zze, Object obj) {
        zzx.zzy(obj);
        com_google_android_gms_internal_zzqq_zze.zzakS = null;
        com_google_android_gms_internal_zzqq_zze.zzaVo = null;
        com_google_android_gms_internal_zzqq_zze.zzaVi = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzqq_zze.zzakS = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzqq_zze.zzaVo = (Long) obj;
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzqq_zze.zzaVi = (Float) obj;
        } else {
            zzzz().zzBl().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public byte[] zza(zzc com_google_android_gms_internal_zzqq_zzc) {
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzqq_zzc.getSerializedSize()];
            zztd zzD = zztd.zzD(bArr);
            com_google_android_gms_internal_zzqq_zzc.writeTo(zzD);
            zzD.zzHy();
            return bArr;
        } catch (IOException e) {
            zzzz().zzBl().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public boolean zzbh(String str) {
        zziS();
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    void zzc(String str, int i, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(str + " name is required and can't be null");
        } else if (str2.length() == 0) {
            throw new IllegalArgumentException(str + " name is required and can't be empty");
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i2 = 1;
                while (i2 < str2.length()) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(str + " name must consist of letters, digits or _ (underscores)");
                    }
                }
                if (str2.length() > i) {
                    throw new IllegalArgumentException(str + " name is too long. The maximum supported length is " + i);
                }
                return;
            }
            throw new IllegalArgumentException(str + " name must start with a letter or _");
        }
    }

    public boolean zzc(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zziT().currentTimeMillis() - j) > j2;
    }

    public void zzeE(String str) {
        zzc("event", zzAX().zzAt(), str);
    }

    public void zzeF(String str) {
        zzc("user attribute", zzAX().zzAu(), str);
    }

    public void zzeG(String str) {
        zzc("event param", zzAX().zzAu(), str);
    }

    public byte[] zzg(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzzz().zzBl().zzj("Failed to gzip content", e);
            throw e;
        }
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

    public Object zzk(String str, Object obj) {
        int zzAv = (TextUtils.isEmpty(str) || !str.startsWith("_")) ? zzAX().zzAv() : zzAX().zzAw();
        return zza(zzAv, obj, false);
    }

    public void zzl(String str, Object obj) {
        if ("_ldl".equals(str)) {
            zza("user attribute referrer", str, zzeH(str), obj);
        } else {
            zza("user attribute", str, zzeH(str), obj);
        }
    }

    public Object zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzeH(str), obj, true) : zza(zzeH(str), obj, false);
    }

    public byte[] zzq(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            zzzz().zzBl().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
