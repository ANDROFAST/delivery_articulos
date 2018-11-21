package com.google.android.gms.vision.face;

import android.graphics.PointF;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private int mId;
    private float zzaQo;
    private float zzaQp;
    private PointF zzbit;
    private float zzbiu;
    private float zzbiv;
    private List<Landmark> zzbiw;
    private float zzbix;
    private float zzbiy;
    private float zzbiz;

    public Face(int id, PointF position, float width, float height, float yawDegrees, float rollDegrees, Landmark[] landmarks, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.mId = id;
        this.zzbit = position;
        this.zzaQo = width;
        this.zzaQp = height;
        this.zzbiu = yawDegrees;
        this.zzbiv = rollDegrees;
        this.zzbiw = Arrays.asList(landmarks);
        if (isLeftEyeOpenScore < 0.0f || isLeftEyeOpenScore > TextTrackStyle.DEFAULT_FONT_SCALE) {
            this.zzbix = -1.0f;
        } else {
            this.zzbix = isLeftEyeOpenScore;
        }
        if (isRightEyeOpenScore < 0.0f || isRightEyeOpenScore > TextTrackStyle.DEFAULT_FONT_SCALE) {
            this.zzbiy = -1.0f;
        } else {
            this.zzbiy = isRightEyeOpenScore;
        }
        if (this.zzbiz < 0.0f || this.zzbiz > TextTrackStyle.DEFAULT_FONT_SCALE) {
            this.zzbiz = -1.0f;
        } else {
            this.zzbiz = isSmilingScore;
        }
    }

    public float getEulerY() {
        return this.zzbiu;
    }

    public float getEulerZ() {
        return this.zzbiv;
    }

    public float getHeight() {
        return this.zzaQp;
    }

    public int getId() {
        return this.mId;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzbix;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzbiy;
    }

    public float getIsSmilingProbability() {
        return this.zzbiz;
    }

    public List<Landmark> getLandmarks() {
        return this.zzbiw;
    }

    public PointF getPosition() {
        return new PointF(this.zzbit.x - (this.zzaQo / 2.0f), this.zzbit.y - (this.zzaQp / 2.0f));
    }

    public float getWidth() {
        return this.zzaQo;
    }
}
