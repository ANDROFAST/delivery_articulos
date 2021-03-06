package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.nearby.messages.Strategy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzha
public final class zzds implements zzdl {
    private final zze zzzb;
    private final zzfm zzzc;
    private final zzdn zzze;

    public static class zzb {
        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzb(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent zzd = zzd(parse);
            Intent zzd2 = zzd(build);
            ResolveInfo zza = zza(context, zzd, arrayList);
            if (zza != null) {
                return zza(zzd, zza);
            }
            if (zzd2 != null) {
                ResolveInfo zza2 = zza(context, zzd2);
                if (zza2 != null) {
                    Intent zza3 = zza(zzd, zza2);
                    if (zza(context, zza3) != null) {
                        return zza3;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return zzd;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return zza(zzd, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? zza(zzd, (ResolveInfo) arrayList.get(0)) : zzd;
        }

        public Intent zzd(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public static class zza extends zzil {
        private final String zzF;
        private final zzjn zzps;
        private final String zzzf = "play.google.com";
        private final String zzzg = "market";
        private final int zzzh = 10;

        public zza(zzjn com_google_android_gms_internal_zzjn, String str) {
            this.zzps = com_google_android_gms_internal_zzjn;
            this.zzF = str;
        }

        public void onStop() {
        }

        public Intent zzY(String str) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(parse);
            return intent;
        }

        public void zzbp() {
            String str;
            Throwable th;
            CharSequence charSequence;
            Throwable th2;
            int i = 0;
            String str2 = this.zzF;
            while (i < 10) {
                int i2 = i + 1;
                HttpURLConnection httpURLConnection;
                try {
                    URL url = new URL(str2);
                    if (!"play.google.com".equalsIgnoreCase(url.getHost())) {
                        if (!"market".equalsIgnoreCase(url.getProtocol())) {
                            CharSequence charSequence2;
                            CharSequence charSequence3;
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                            zzp.zzbx().zza(this.zzps.getContext(), this.zzps.zzhF().afmaVersion, false, httpURLConnection);
                            int responseCode = httpURLConnection.getResponseCode();
                            Map headerFields = httpURLConnection.getHeaderFields();
                            String str3 = "";
                            if (responseCode >= Strategy.TTL_SECONDS_DEFAULT && responseCode <= 399) {
                                List list = null;
                                if (headerFields.containsKey("Location")) {
                                    list = (List) headerFields.get("Location");
                                } else if (headerFields.containsKey("location")) {
                                    list = (List) headerFields.get("location");
                                }
                                if (list != null && list.size() > 0) {
                                    charSequence2 = (String) list.get(0);
                                    if (TextUtils.isEmpty(charSequence2)) {
                                        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                                        httpURLConnection.disconnect();
                                        str = str2;
                                        break;
                                    }
                                    try {
                                        httpURLConnection.disconnect();
                                        i = i2;
                                        charSequence3 = charSequence2;
                                    } catch (Throwable e) {
                                        th = e;
                                        charSequence = charSequence2;
                                        th2 = th;
                                    } catch (Throwable e2) {
                                        th = e2;
                                        charSequence = charSequence2;
                                        th2 = th;
                                    } catch (Throwable e22) {
                                        th = e22;
                                        charSequence = charSequence2;
                                        th2 = th;
                                    }
                                }
                            }
                            Object obj = str3;
                            if (TextUtils.isEmpty(charSequence2)) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                                httpURLConnection.disconnect();
                                str = str2;
                                break;
                            }
                            httpURLConnection.disconnect();
                            i = i2;
                            charSequence3 = charSequence2;
                        } else {
                            str = str2;
                            break;
                        }
                    }
                    str = str2;
                    break;
                } catch (Throwable e222) {
                    th2 = e222;
                    str = str2;
                } catch (Throwable e2222) {
                    th2 = e2222;
                    str = str2;
                } catch (Throwable e22222) {
                    th2 = e22222;
                    str = str2;
                } catch (Throwable th3) {
                    httpURLConnection.disconnect();
                }
            }
            str = str2;
            zzp.zzbx().zzb(this.zzps.getContext(), zzY(str));
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Error while pinging URL: " + str, th2);
            zzp.zzbx().zzb(this.zzps.getContext(), zzY(str));
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Error while parsing ping URL: " + str, th2);
            zzp.zzbx().zzb(this.zzps.getContext(), zzY(str));
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Error while pinging URL: " + str, th2);
            zzp.zzbx().zzb(this.zzps.getContext(), zzY(str));
        }
    }

    public zzds(zzdn com_google_android_gms_internal_zzdn, zze com_google_android_gms_ads_internal_zze, zzfm com_google_android_gms_internal_zzfm) {
        this.zzze = com_google_android_gms_internal_zzdn;
        this.zzzb = com_google_android_gms_ads_internal_zze;
        this.zzzc = com_google_android_gms_internal_zzfm;
    }

    private static void zza(Context context, Map<String, String> map) {
        if (TextUtils.isEmpty((String) map.get("u"))) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Destination url cannot be empty.");
            return;
        }
        try {
            zzp.zzbx().zzb(context, new zzb().zzb(context, map));
        } catch (ActivityNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(e.getMessage());
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzp.zzbz().zzhe();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzp.zzbz().zzhd();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzp.zzbz().zzhf();
            }
        }
        return -1;
    }

    private static void zze(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Destination url cannot be empty.");
        } else {
            new zza(com_google_android_gms_internal_zzjn, str).zzgX();
        }
    }

    private void zzo(boolean z) {
        if (this.zzzc != null) {
            this.zzzc.zzp(z);
        }
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Action missing from an open GMSG.");
        } else if (this.zzzb == null || this.zzzb.zzbg()) {
            zzjo zzhC = com_google_android_gms_internal_zzjn.zzhC();
            if ("expand".equalsIgnoreCase(str)) {
                if (com_google_android_gms_internal_zzjn.zzhG()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzo(false);
                zzhC.zza(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                zzo(false);
                if (str != null) {
                    zzhC.zza(zzc(map), zzd(map), str);
                } else {
                    zzhC.zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.zzze == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.zzze.zza(str, new ArrayList());
                } else {
                    this.zzze.zza(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("play_store"))) {
                zze(com_google_android_gms_internal_zzjn, map);
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                zza(com_google_android_gms_internal_zzjn.getContext(), (Map) map);
            } else {
                zzo(true);
                com_google_android_gms_internal_zzjn.zzhE();
                str = (String) map.get("u");
                zzhC.zza(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str) ? zzp.zzbx().zza(com_google_android_gms_internal_zzjn, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.zzzb.zzp((String) map.get("u"));
        }
    }
}
