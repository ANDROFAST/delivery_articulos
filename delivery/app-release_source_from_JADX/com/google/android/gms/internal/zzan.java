package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class zzan {
    private static final String[] zzoh = new String[]{"/aclk", "/pcs/click"};
    private String zzod = "googleads.g.doubleclick.net";
    private String zzoe = "/pagead/ads";
    private String zzof = "ad.doubleclick.net";
    private String[] zzog = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzaj zzoi;

    public zzan(zzaj com_google_android_gms_internal_zzaj) {
        this.zzoi = com_google_android_gms_internal_zzaj;
    }

    private Uri zza(Uri uri, Context context, String str, boolean z) throws zzao {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzao("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzao("Query parameter already exists: ms");
            }
            String zzb = z ? this.zzoi.zzb(context, str) : this.zzoi.zzb(context);
            return zza ? zzb(uri, "dc_ms", zzb) : zza(uri, "ms", zzb);
        } catch (UnsupportedOperationException e) {
            throw new zzao("Provided Uri is not in a valid state");
        }
    }

    private Uri zza(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri zzb(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri zza(Uri uri, Context context) throws zzao {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new zzao("Provided Uri is not in a valid state");
        }
    }

    public void zza(MotionEvent motionEvent) {
        this.zzoi.zza(motionEvent);
    }

    public boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzof);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public zzaj zzac() {
        return this.zzoi;
    }

    public boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.zzog) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        if (!zzb(uri)) {
            return false;
        }
        for (String endsWith : zzoh) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
