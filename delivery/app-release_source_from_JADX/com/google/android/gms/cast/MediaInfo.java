package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzZg;
    private int zzZh;
    private String zzZi;
    private MediaMetadata zzZj;
    private long zzZk;
    private List<MediaTrack> zzZl;
    private TextTrackStyle zzZm;
    private JSONObject zzZn;

    public static class Builder {
        private final MediaInfo zzZo;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzZo = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzZo.zznv();
            return this.zzZo;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.zzZo.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzZo.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.zzZo.zzs(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.zzZo.zza(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.zzZo.zzx(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.zzZo.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzZo.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzZg = contentId;
        this.zzZh = -1;
        this.zzZk = -1;
    }

    MediaInfo(JSONObject json) throws JSONException {
        int i = 0;
        this.zzZg = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzZh = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzZh = 1;
        } else if ("LIVE".equals(string)) {
            this.zzZh = 2;
        } else {
            this.zzZh = -1;
        }
        this.zzZi = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.zzZj = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.zzZj.zzf(jSONObject);
        }
        this.zzZk = -1;
        if (json.has("duration") && !json.isNull("duration")) {
            double optDouble = json.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.zzZk = zzf.zzg(optDouble);
            }
        }
        if (json.has("tracks")) {
            this.zzZl = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.zzZl.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i++;
            }
        } else {
            this.zzZl = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzf(jSONObject2);
            this.zzZm = textTrackStyle;
        } else {
            this.zzZm = null;
        }
        this.zzZn = json.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.zzZn == null) != (mediaInfo.zzZn == null)) {
            return false;
        }
        if (this.zzZn != null && mediaInfo.zzZn != null && !zznu.zze(this.zzZn, mediaInfo.zzZn)) {
            return false;
        }
        if (!(zzf.zza(this.zzZg, mediaInfo.zzZg) && this.zzZh == mediaInfo.zzZh && zzf.zza(this.zzZi, mediaInfo.zzZi) && zzf.zza(this.zzZj, mediaInfo.zzZj) && this.zzZk == mediaInfo.zzZk)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.zzZg;
    }

    public String getContentType() {
        return this.zzZi;
    }

    public JSONObject getCustomData() {
        return this.zzZn;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzZl;
    }

    public MediaMetadata getMetadata() {
        return this.zzZj;
    }

    public long getStreamDuration() {
        return this.zzZk;
    }

    public int getStreamType() {
        return this.zzZh;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzZm;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzZg, Integer.valueOf(this.zzZh), this.zzZi, this.zzZj, Long.valueOf(this.zzZk), String.valueOf(this.zzZn));
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzZi = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzZn = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzZh = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzZm = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.zzZg);
            switch (this.zzZh) {
                case 1:
                    obj = "BUFFERED";
                    break;
                case 2:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.zzZi != null) {
                jSONObject.put("contentType", this.zzZi);
            }
            if (this.zzZj != null) {
                jSONObject.put("metadata", this.zzZj.toJson());
            }
            if (this.zzZk <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzZk));
            }
            if (this.zzZl != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.zzZl) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzZm != null) {
                jSONObject.put("textTrackStyle", this.zzZm.toJson());
            }
            if (this.zzZn != null) {
                jSONObject.put("customData", this.zzZn);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzZj = mediaMetadata;
    }

    void zznv() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzZg)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzZi)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzZh == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzs(List<MediaTrack> list) {
        this.zzZl = list;
    }

    void zzx(long j) throws IllegalArgumentException {
        if (j >= 0 || j == -1) {
            this.zzZk = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }
}
