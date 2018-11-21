package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] zzZp = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
    private static final zza zzZq = new zza().zzc(KEY_CREATION_DATE, "creationDateTime", 4).zzc(KEY_RELEASE_DATE, "releaseDate", 4).zzc(KEY_BROADCAST_DATE, "originalAirdate", 4).zzc(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).zzc(KEY_SUBTITLE, "subtitle", 1).zzc(KEY_ARTIST, "artist", 1).zzc(KEY_ALBUM_ARTIST, "albumArtist", 1).zzc(KEY_ALBUM_TITLE, "albumName", 1).zzc(KEY_COMPOSER, "composer", 1).zzc(KEY_DISC_NUMBER, "discNumber", 2).zzc(KEY_TRACK_NUMBER, "trackNumber", 2).zzc(KEY_SEASON_NUMBER, "season", 2).zzc(KEY_EPISODE_NUMBER, "episode", 2).zzc(KEY_SERIES_TITLE, "seriesTitle", 1).zzc(KEY_STUDIO, "studio", 1).zzc(KEY_WIDTH, "width", 2).zzc(KEY_HEIGHT, "height", 2).zzc(KEY_LOCATION_NAME, "location", 1).zzc(KEY_LOCATION_LATITUDE, "latitude", 3).zzc(KEY_LOCATION_LONGITUDE, "longitude", 3);
    private final Bundle zzZr;
    private int zzZs;
    private final List<WebImage> zzxz;

    private static class zza {
        private final Map<String, String> zzZt = new HashMap();
        private final Map<String, String> zzZu = new HashMap();
        private final Map<String, Integer> zzZv = new HashMap();

        public String zzbU(String str) {
            return (String) this.zzZt.get(str);
        }

        public String zzbV(String str) {
            return (String) this.zzZu.get(str);
        }

        public int zzbW(String str) {
            Integer num = (Integer) this.zzZv.get(str);
            return num != null ? num.intValue() : 0;
        }

        public zza zzc(String str, String str2, int i) {
            this.zzZt.put(str, str2);
            this.zzZu.put(str2, str);
            this.zzZv.put(str, Integer.valueOf(i));
            return this;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.zzxz = new ArrayList();
        this.zzZr = new Bundle();
        this.zzZs = mediaType;
    }

    private void zza(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.zzZr.containsKey(str)) {
                    switch (zzZq.zzbW(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(zzZq.zzbU(str), this.zzZr.getString(str));
                            break;
                        case 2:
                            jSONObject.put(zzZq.zzbU(str), this.zzZr.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(zzZq.zzbU(str), this.zzZr.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.zzZr.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzZr.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private void zzb(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String zzbV = zzZq.zzbV(str);
                    if (zzbV == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.zzZr.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzZr.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzZr.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzbV)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (zzZq.zzbW(zzbV)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.zzZr.putString(zzbV, (String) obj2);
                                        break;
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.zzZr.putInt(zzbV, ((Integer) obj2).intValue());
                                        break;
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.zzZr.putDouble(zzbV, ((Double) obj2).doubleValue());
                                        break;
                                    case 4:
                                        if ((obj2 instanceof String) && zzln.zzci((String) obj2) != null) {
                                            this.zzZr.putString(zzbV, (String) obj2);
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private boolean zzb(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzb((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void zzf(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzbW = zzZq.zzbW(str);
        if (zzbW != i && zzbW != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + zzZp[i]);
        }
    }

    public void addImage(WebImage image) {
        this.zzxz.add(image);
    }

    public void clear() {
        this.zzZr.clear();
        this.zzxz.clear();
    }

    public void clearImages() {
        this.zzxz.clear();
    }

    public boolean containsKey(String key) {
        return this.zzZr.containsKey(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return zzb(this.zzZr, mediaMetadata.zzZr) && this.zzxz.equals(mediaMetadata.zzxz);
    }

    public Calendar getDate(String key) {
        zzf(key, 4);
        String string = this.zzZr.getString(key);
        return string != null ? zzln.zzci(string) : null;
    }

    public String getDateAsString(String key) {
        zzf(key, 4);
        return this.zzZr.getString(key);
    }

    public double getDouble(String key) {
        zzf(key, 3);
        return this.zzZr.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.zzxz;
    }

    public int getInt(String key) {
        zzf(key, 2);
        return this.zzZr.getInt(key);
    }

    public int getMediaType() {
        return this.zzZs;
    }

    public String getString(String key) {
        zzf(key, 1);
        return this.zzZr.getString(key);
    }

    public boolean hasImages() {
        return (this.zzxz == null || this.zzxz.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.zzZr.keySet()) {
            i *= 31;
            i = this.zzZr.get(str).hashCode() + i;
        }
        return (i * 31) + this.zzxz.hashCode();
    }

    public Set<String> keySet() {
        return this.zzZr.keySet();
    }

    public void putDate(String key, Calendar value) {
        zzf(key, 4);
        this.zzZr.putString(key, zzln.zza(value));
    }

    public void putDouble(String key, double value) {
        zzf(key, 3);
        this.zzZr.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        zzf(key, 2);
        this.zzZr.putInt(key, value);
    }

    public void putString(String key, String value) {
        zzf(key, 1);
        this.zzZr.putString(key, value);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzZs);
        } catch (JSONException e) {
        }
        zzln.zza(jSONObject, this.zzxz);
        switch (this.zzZs) {
            case 0:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                zza(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                zza(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                zza(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public void zzf(JSONObject jSONObject) {
        clear();
        this.zzZs = 0;
        try {
            this.zzZs = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzln.zza(this.zzxz, jSONObject);
        switch (this.zzZs) {
            case 0:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                zzb(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                zzb(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                zzb(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                zzb(jSONObject, new String[0]);
                return;
        }
    }
}
