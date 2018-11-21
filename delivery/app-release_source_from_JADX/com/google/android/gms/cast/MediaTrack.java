package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzTC;
    private int zzZU;
    private int zzZV;
    private String zzZe;
    private String zzZg;
    private String zzZi;
    private JSONObject zzZn;

    public static class Builder {
        private final MediaTrack zzZW;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.zzZW = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.zzZW;
        }

        public Builder setContentId(String contentId) {
            this.zzZW.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.zzZW.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzZW.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.zzZW.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzZW.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.zzZW.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.zzZW.zzbe(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.zzTC = id;
        if (type <= 0 || type > 3) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.zzZU = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        zzf(json);
    }

    private void clear() {
        this.zzTC = 0;
        this.zzZU = 0;
        this.zzZg = null;
        this.mName = null;
        this.zzZe = null;
        this.zzZV = -1;
        this.zzZn = null;
    }

    private void zzf(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzTC = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzZU = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzZU = 2;
        } else if ("VIDEO".equals(string)) {
            this.zzZU = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.zzZg = jSONObject.optString("trackContentId", null);
        this.zzZi = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzZe = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.zzZV = 1;
            } else if ("CAPTIONS".equals(string)) {
                this.zzZV = 2;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.zzZV = 3;
            } else if ("CHAPTERS".equals(string)) {
                this.zzZV = 4;
            } else if ("METADATA".equals(string)) {
                this.zzZV = 5;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.zzZV = 0;
        this.zzZn = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.zzZn == null) != (mediaTrack.zzZn == null)) {
            return false;
        }
        if (this.zzZn != null && mediaTrack.zzZn != null && !zznu.zze(this.zzZn, mediaTrack.zzZn)) {
            return false;
        }
        if (!(this.zzTC == mediaTrack.zzTC && this.zzZU == mediaTrack.zzZU && zzf.zza(this.zzZg, mediaTrack.zzZg) && zzf.zza(this.zzZi, mediaTrack.zzZi) && zzf.zza(this.mName, mediaTrack.mName) && zzf.zza(this.zzZe, mediaTrack.zzZe) && this.zzZV == mediaTrack.zzZV)) {
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

    public long getId() {
        return this.zzTC;
    }

    public String getLanguage() {
        return this.zzZe;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzZV;
    }

    public int getType() {
        return this.zzZU;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzTC), Integer.valueOf(this.zzZU), this.zzZg, this.zzZi, this.mName, this.zzZe, Integer.valueOf(this.zzZV), this.zzZn);
    }

    public void setContentId(String contentId) {
        this.zzZg = contentId;
    }

    public void setContentType(String contentType) {
        this.zzZi = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzZn = customData;
    }

    void setLanguage(String language) {
        this.zzZe = language;
    }

    void setName(String name) {
        this.mName = name;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzTC);
            switch (this.zzZU) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzZg != null) {
                jSONObject.put("trackContentId", this.zzZg);
            }
            if (this.zzZi != null) {
                jSONObject.put("trackContentType", this.zzZi);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzZe)) {
                jSONObject.put("language", this.zzZe);
            }
            switch (this.zzZV) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzZn != null) {
                jSONObject.put("customData", this.zzZn);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzbe(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.zzZU == 1) {
            this.zzZV = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }
}
