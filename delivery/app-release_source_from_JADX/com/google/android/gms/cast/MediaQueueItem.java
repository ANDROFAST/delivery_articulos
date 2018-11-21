package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaQueueItem {
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    private double zzZA;
    private double zzZB;
    private long[] zzZC;
    private JSONObject zzZn;
    private MediaInfo zzZw;
    private int zzZx;
    private boolean zzZy;
    private double zzZz;

    public static class Builder {
        private final MediaQueueItem zzZD;

        public Builder(MediaInfo media) throws IllegalArgumentException {
            this.zzZD = new MediaQueueItem(media);
        }

        public Builder(MediaQueueItem item) throws IllegalArgumentException {
            this.zzZD = new MediaQueueItem();
        }

        public Builder(JSONObject json) throws JSONException {
            this.zzZD = new MediaQueueItem(json);
        }

        public MediaQueueItem build() {
            this.zzZD.zznv();
            return this.zzZD;
        }

        public Builder clearItemId() {
            this.zzZD.zzba(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] activeTrackIds) {
            this.zzZD.zza(activeTrackIds);
            return this;
        }

        public Builder setAutoplay(boolean autoplay) {
            this.zzZD.zzV(autoplay);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzZD.setCustomData(customData);
            return this;
        }

        public Builder setPlaybackDuration(double playbackDuration) {
            this.zzZD.zzd(playbackDuration);
            return this;
        }

        public Builder setPreloadTime(double preloadTime) throws IllegalArgumentException {
            this.zzZD.zze(preloadTime);
            return this;
        }

        public Builder setStartTime(double startTime) throws IllegalArgumentException {
            this.zzZD.zzc(startTime);
            return this;
        }
    }

    private MediaQueueItem(MediaInfo media) throws IllegalArgumentException {
        this.zzZx = 0;
        this.zzZy = true;
        this.zzZA = DEFAULT_PLAYBACK_DURATION;
        if (media == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzZw = media;
    }

    private MediaQueueItem(MediaQueueItem item) throws IllegalArgumentException {
        this.zzZx = 0;
        this.zzZy = true;
        this.zzZA = DEFAULT_PLAYBACK_DURATION;
        this.zzZw = item.getMedia();
        if (this.zzZw == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzZx = item.getItemId();
        this.zzZy = item.getAutoplay();
        this.zzZz = item.getStartTime();
        this.zzZA = item.getPlaybackDuration();
        this.zzZB = item.getPreloadTime();
        this.zzZC = item.getActiveTrackIds();
        this.zzZn = item.getCustomData();
    }

    MediaQueueItem(JSONObject json) throws JSONException {
        this.zzZx = 0;
        this.zzZy = true;
        this.zzZA = DEFAULT_PLAYBACK_DURATION;
        zzg(json);
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) other;
        if ((this.zzZn == null) != (mediaQueueItem.zzZn == null)) {
            return false;
        }
        if (this.zzZn != null && mediaQueueItem.zzZn != null && !zznu.zze(this.zzZn, mediaQueueItem.zzZn)) {
            return false;
        }
        if (!(zzf.zza(this.zzZw, mediaQueueItem.zzZw) && this.zzZx == mediaQueueItem.zzZx && this.zzZy == mediaQueueItem.zzZy && this.zzZz == mediaQueueItem.zzZz && this.zzZA == mediaQueueItem.zzZA && this.zzZB == mediaQueueItem.zzZB && zzf.zza(this.zzZC, mediaQueueItem.zzZC))) {
            z = false;
        }
        return z;
    }

    public long[] getActiveTrackIds() {
        return this.zzZC;
    }

    public boolean getAutoplay() {
        return this.zzZy;
    }

    public JSONObject getCustomData() {
        return this.zzZn;
    }

    public int getItemId() {
        return this.zzZx;
    }

    public MediaInfo getMedia() {
        return this.zzZw;
    }

    public double getPlaybackDuration() {
        return this.zzZA;
    }

    public double getPreloadTime() {
        return this.zzZB;
    }

    public double getStartTime() {
        return this.zzZz;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzZw, Integer.valueOf(this.zzZx), Boolean.valueOf(this.zzZy), Double.valueOf(this.zzZz), Double.valueOf(this.zzZA), Double.valueOf(this.zzZB), this.zzZC, String.valueOf(this.zzZn));
    }

    void setCustomData(JSONObject customData) {
        this.zzZn = customData;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzZw.toJson());
            if (this.zzZx != 0) {
                jSONObject.put("itemId", this.zzZx);
            }
            jSONObject.put("autoplay", this.zzZy);
            jSONObject.put("startTime", this.zzZz);
            if (this.zzZA != DEFAULT_PLAYBACK_DURATION) {
                jSONObject.put("playbackDuration", this.zzZA);
            }
            jSONObject.put("preloadTime", this.zzZB);
            if (this.zzZC != null) {
                JSONArray jSONArray = new JSONArray();
                for (long put : this.zzZC) {
                    jSONArray.put(put);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            if (this.zzZn != null) {
                jSONObject.put("customData", this.zzZn);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzV(boolean z) {
        this.zzZy = z;
    }

    void zza(long[] jArr) {
        this.zzZC = jArr;
    }

    void zzba(int i) {
        this.zzZx = i;
    }

    void zzc(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        this.zzZz = d;
    }

    void zzd(double d) throws IllegalArgumentException {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        this.zzZA = d;
    }

    void zze(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        }
        this.zzZB = d;
    }

    public boolean zzg(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        double d;
        long[] jArr;
        if (jSONObject.has("media")) {
            this.zzZw = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId")) {
            int i = jSONObject.getInt("itemId");
            if (this.zzZx != i) {
                this.zzZx = i;
                z = true;
            }
        }
        if (jSONObject.has("autoplay")) {
            z2 = jSONObject.getBoolean("autoplay");
            if (this.zzZy != z2) {
                this.zzZy = z2;
                z = true;
            }
        }
        if (jSONObject.has("startTime")) {
            d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzZz) > 1.0E-7d) {
                this.zzZz = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.zzZA) > 1.0E-7d) {
                this.zzZA = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            d = jSONObject.getDouble("preloadTime");
            if (Math.abs(d - this.zzZB) > 1.0E-7d) {
                this.zzZB = d;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            int i2;
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i2 = 0; i2 < length; i2++) {
                jArr2[i2] = jSONArray.getLong(i2);
            }
            if (this.zzZC == null) {
                jArr = jArr2;
                z2 = true;
            } else if (this.zzZC.length != length) {
                jArr = jArr2;
                z2 = true;
            } else {
                for (i2 = 0; i2 < length; i2++) {
                    if (this.zzZC[i2] != jArr2[i2]) {
                        jArr = jArr2;
                        z2 = true;
                        break;
                    }
                }
                long[] jArr3 = jArr2;
                z2 = false;
                jArr = jArr3;
            }
        } else {
            z2 = false;
            jArr = null;
        }
        if (z2) {
            this.zzZC = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzZn = jSONObject.getJSONObject("customData");
        return true;
    }

    void zznv() throws IllegalArgumentException {
        if (this.zzZw == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (Double.isNaN(this.zzZz) || this.zzZz < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzZA)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzZB) || this.zzZB < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }
}
