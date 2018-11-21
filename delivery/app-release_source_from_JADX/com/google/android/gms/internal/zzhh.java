package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzha
class zzhh {
    private final String zzDX;
    private String zzF;
    private int zzFt;
    private final List<String> zzIs;
    private final List<String> zzIt;
    private final String zzIu;
    private final String zzIv;
    private final String zzIw;
    private final String zzIx;
    private final boolean zzIy;
    private final boolean zzIz;

    public zzhh(int i, Map<String, String> map) {
        this.zzF = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        this.zzIv = (String) map.get("base_uri");
        this.zzIw = (String) map.get("post_parameters");
        this.zzIy = parseBoolean((String) map.get("drt_include"));
        this.zzIz = parseBoolean((String) map.get("pan_include"));
        this.zzIu = (String) map.get("activation_overlay_url");
        this.zzIt = zzau((String) map.get("check_packages"));
        this.zzDX = (String) map.get("request_id");
        this.zzIx = (String) map.get("type");
        this.zzIs = zzau((String) map.get("errors"));
        this.zzFt = i;
    }

    private static boolean parseBoolean(String bool) {
        return bool != null && (bool.equals("1") || bool.equals("true"));
    }

    private List<String> zzau(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzFt;
    }

    public String getRequestId() {
        return this.zzDX;
    }

    public String getType() {
        return this.zzIx;
    }

    public String getUrl() {
        return this.zzF;
    }

    public void setUrl(String url) {
        this.zzF = url;
    }

    public List<String> zzgr() {
        return this.zzIs;
    }

    public String zzgs() {
        return this.zzIw;
    }

    public boolean zzgt() {
        return this.zzIy;
    }

    public boolean zzgu() {
        return this.zzIz;
    }
}
