package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznx;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzZn;
    private float zzaaH;
    private int zzaaI;
    private int zzaaJ;
    private int zzaaK;
    private int zzaaL;
    private int zzaaM;
    private int zzaaN;
    private String zzaaO;
    private int zzaaP;
    private int zzaaQ;
    private int zzxq;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzaaH = DEFAULT_FONT_SCALE;
        this.zzaaI = 0;
        this.zzxq = 0;
        this.zzaaJ = -1;
        this.zzaaK = 0;
        this.zzaaL = -1;
        this.zzaaM = 0;
        this.zzaaN = 0;
        this.zzaaO = null;
        this.zzaaP = -1;
        this.zzaaQ = -1;
        this.zzZn = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zznx.zzrU()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String zzL(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    private int zzbX(String str) {
        int i = 0;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.zzZn == null) != (textTrackStyle.zzZn == null)) {
            return false;
        }
        if (this.zzZn != null && textTrackStyle.zzZn != null && !zznu.zze(this.zzZn, textTrackStyle.zzZn)) {
            return false;
        }
        if (!(this.zzaaH == textTrackStyle.zzaaH && this.zzaaI == textTrackStyle.zzaaI && this.zzxq == textTrackStyle.zzxq && this.zzaaJ == textTrackStyle.zzaaJ && this.zzaaK == textTrackStyle.zzaaK && this.zzaaL == textTrackStyle.zzaaL && this.zzaaN == textTrackStyle.zzaaN && zzf.zza(this.zzaaO, textTrackStyle.zzaaO) && this.zzaaP == textTrackStyle.zzaaP && this.zzaaQ == textTrackStyle.zzaaQ)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.zzxq;
    }

    public JSONObject getCustomData() {
        return this.zzZn;
    }

    public int getEdgeColor() {
        return this.zzaaK;
    }

    public int getEdgeType() {
        return this.zzaaJ;
    }

    public String getFontFamily() {
        return this.zzaaO;
    }

    public int getFontGenericFamily() {
        return this.zzaaP;
    }

    public float getFontScale() {
        return this.zzaaH;
    }

    public int getFontStyle() {
        return this.zzaaQ;
    }

    public int getForegroundColor() {
        return this.zzaaI;
    }

    public int getWindowColor() {
        return this.zzaaM;
    }

    public int getWindowCornerRadius() {
        return this.zzaaN;
    }

    public int getWindowType() {
        return this.zzaaL;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaaH), Integer.valueOf(this.zzaaI), Integer.valueOf(this.zzxq), Integer.valueOf(this.zzaaJ), Integer.valueOf(this.zzaaK), Integer.valueOf(this.zzaaL), Integer.valueOf(this.zzaaM), Integer.valueOf(this.zzaaN), this.zzaaO, Integer.valueOf(this.zzaaP), Integer.valueOf(this.zzaaQ), this.zzZn);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.zzxq = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.zzZn = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.zzaaK = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzaaJ = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.zzaaO = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzaaP = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.zzaaH = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzaaQ = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.zzaaI = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.zzaaM = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzaaN = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzaaL = windowType;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzaaH);
            if (this.zzaaI != 0) {
                jSONObject.put("foregroundColor", zzL(this.zzaaI));
            }
            if (this.zzxq != 0) {
                jSONObject.put("backgroundColor", zzL(this.zzxq));
            }
            switch (this.zzaaJ) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzaaK != 0) {
                jSONObject.put("edgeColor", zzL(this.zzaaK));
            }
            switch (this.zzaaL) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzaaM != 0) {
                jSONObject.put("windowColor", zzL(this.zzaaM));
            }
            if (this.zzaaL == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzaaN);
            }
            if (this.zzaaO != null) {
                jSONObject.put("fontFamily", this.zzaaO);
            }
            switch (this.zzaaP) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzaaQ) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.zzZn != null) {
                jSONObject.put("customData", this.zzZn);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzf(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.zzaaH = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzaaI = zzbX(jSONObject.optString("foregroundColor"));
        this.zzxq = zzbX(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzaaJ = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzaaJ = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzaaJ = 2;
            } else if ("RAISED".equals(string)) {
                this.zzaaJ = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzaaJ = 4;
            }
        }
        this.zzaaK = zzbX(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.zzaaL = 0;
            } else if ("NORMAL".equals(string)) {
                this.zzaaL = 1;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.zzaaL = 2;
            }
        }
        this.zzaaM = zzbX(jSONObject.optString("windowColor"));
        if (this.zzaaL == 2) {
            this.zzaaN = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzaaO = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.zzaaP = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.zzaaP = 1;
            } else if ("SERIF".equals(string)) {
                this.zzaaP = 2;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.zzaaP = 3;
            } else if ("CASUAL".equals(string)) {
                this.zzaaP = 4;
            } else if ("CURSIVE".equals(string)) {
                this.zzaaP = 5;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.zzaaP = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.zzaaQ = 0;
            } else if ("BOLD".equals(string)) {
                this.zzaaQ = 1;
            } else if ("ITALIC".equals(string)) {
                this.zzaaQ = 2;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.zzaaQ = 3;
            }
        }
        this.zzZn = jSONObject.optJSONObject("customData");
    }
}
