package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public class zzcb {
    final Context mContext;
    final String zzrD;
    String zzwL;
    BlockingQueue<zzch> zzwN;
    ExecutorService zzwO;
    LinkedHashMap<String, String> zzwP = new LinkedHashMap();
    Map<String, zzce> zzwQ = new HashMap();
    private AtomicBoolean zzwR;
    private File zzwS;

    class C02781 implements Runnable {
        final /* synthetic */ zzcb zzwT;

        C02781(zzcb com_google_android_gms_internal_zzcb) {
            this.zzwT = com_google_android_gms_internal_zzcb;
        }

        public void run() {
            this.zzwT.zzdq();
        }
    }

    public zzcb(Context context, String str, String str2, Map<String, String> map) {
        this.mContext = context;
        this.zzrD = str;
        this.zzwL = str2;
        this.zzwR = new AtomicBoolean(false);
        this.zzwR.set(((Boolean) zzbz.zzvN.get()).booleanValue());
        if (this.zzwR.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.zzwS = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.zzwP.put(entry.getKey(), entry.getValue());
        }
        this.zzwN = new ArrayBlockingQueue(30);
        this.zzwO = Executors.newSingleThreadExecutor();
        this.zzwO.execute(new C02781(this));
        this.zzwQ.put("action", zzce.zzwV);
        this.zzwQ.put("ad_format", zzce.zzwV);
        this.zzwQ.put("e", zzce.zzwW);
    }

    private void zza(File file, String str) {
        Throwable e;
        if (file != null) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (Throwable e2) {
                            zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                            return;
                        }
                    }
                    return;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        zzb.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                zzb.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        zzb.zzaH("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void zzc(Map<String, String> map, String str) {
        String zza = zza(this.zzwL, map, str);
        if (this.zzwR.get()) {
            zza(this.zzwS, zza);
        } else {
            zzp.zzbx().zzc(this.mContext, this.zzrD, zza);
        }
    }

    private void zzdq() {
        while (true) {
            try {
                zzch com_google_android_gms_internal_zzch = (zzch) this.zzwN.take();
                Object zzdw = com_google_android_gms_internal_zzch.zzdw();
                if (!TextUtils.isEmpty(zzdw)) {
                    zzc(zza(this.zzwP, com_google_android_gms_internal_zzch.zzn()), zzdw);
                }
            } catch (Throwable e) {
                zzb.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public zzce zzP(String str) {
        zzce com_google_android_gms_internal_zzce = (zzce) this.zzwQ.get(str);
        return com_google_android_gms_internal_zzce != null ? com_google_android_gms_internal_zzce : zzce.zzwU;
    }

    String zza(String str, Map<String, String> map, String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
        stringBuilder.append("&").append("it").append("=").append(str2);
        return stringBuilder.toString();
    }

    Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzP(str).zzc(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public boolean zza(zzch com_google_android_gms_internal_zzch) {
        return this.zzwN.offer(com_google_android_gms_internal_zzch);
    }

    public void zzb(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.zzwP.put("e", TextUtils.join(",", list));
        }
    }
}
