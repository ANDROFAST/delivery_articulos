package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzm extends zzc {
    private static final String NAMESPACE = zzf.zzcc("com.google.cast.media");
    private final List<zzp> zzaaT = new ArrayList();
    private long zzacB;
    private MediaStatus zzacC;
    private final zzp zzacD = new zzp(86400000);
    private final zzp zzacE = new zzp(86400000);
    private final zzp zzacF = new zzp(86400000);
    private final zzp zzacG = new zzp(86400000);
    private final zzp zzacH = new zzp(86400000);
    private final zzp zzacI = new zzp(86400000);
    private final zzp zzacJ = new zzp(86400000);
    private final zzp zzacK = new zzp(86400000);
    private final zzp zzacL = new zzp(86400000);
    private final zzp zzacM = new zzp(86400000);
    private final zzp zzacN = new zzp(86400000);
    private final zzp zzacO = new zzp(86400000);
    private final zzp zzacP = new zzp(86400000);
    private final zzp zzacQ = new zzp(86400000);

    public zzm(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000);
        this.zzaaT.add(this.zzacD);
        this.zzaaT.add(this.zzacE);
        this.zzaaT.add(this.zzacF);
        this.zzaaT.add(this.zzacG);
        this.zzaaT.add(this.zzacH);
        this.zzaaT.add(this.zzacI);
        this.zzaaT.add(this.zzacJ);
        this.zzaaT.add(this.zzacK);
        this.zzaaT.add(this.zzacL);
        this.zzaaT.add(this.zzacM);
        this.zzaaT.add(this.zzacN);
        this.zzaaT.add(this.zzacO);
        this.zzaaT.add(this.zzacP);
        this.zzaaT.add(this.zzacQ);
        zzog();
    }

    private void zza(long j, JSONObject jSONObject) throws JSONException {
        int i = 1;
        boolean zzB = this.zzacD.zzB(j);
        int i2 = (!this.zzacH.zzoi() || this.zzacH.zzB(j)) ? 0 : 1;
        if ((!this.zzacI.zzoi() || this.zzacI.zzB(j)) && (!this.zzacJ.zzoi() || this.zzacJ.zzB(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (zzB || this.zzacC == null) {
            this.zzacC = new MediaStatus(jSONObject);
            this.zzacB = SystemClock.elapsedRealtime();
            i2 = 31;
        } else {
            i2 = this.zzacC.zza(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.zzacB = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.zzacB = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        if ((i2 & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((i2 & 16) != 0) {
            onPreloadStatusUpdated();
        }
        for (zzp zzc : this.zzaaT) {
            zzc.zzc(j, 0);
        }
    }

    private void zzog() {
        this.zzacB = 0;
        this.zzacC = null;
        for (zzp clear : this.zzaaT) {
            clear.clear();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzacB == 0) {
            return 0;
        }
        double playbackRate = this.zzacC.getPlaybackRate();
        long streamPosition = this.zzacC.getStreamPosition();
        int playerState = this.zzacC.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzacB;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (elapsedRealtime <= 0 || streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.zzacC == null ? null : this.zzacC.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzacC;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onPreloadStatusUpdated() {
    }

    protected void onQueueStatusUpdated() {
    }

    protected void onStatusUpdated() {
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zznO = zznO();
        this.zzacK.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject.put("requestId", zznO);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzacC != null) {
                jSONObject.put("mediaSessionId", this.zzacC.zznw());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacI.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zznw());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, int i, long j, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) throws IOException, IllegalStateException {
        if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zznO = zznO();
            this.zzacO.zza(zznO, com_google_android_gms_cast_internal_zzo);
            zzW(true);
            try {
                jSONObject2.put("requestId", zznO);
                jSONObject2.put("type", "QUEUE_UPDATE");
                jSONObject2.put("mediaSessionId", zznw());
                if (i != 0) {
                    jSONObject2.put("currentItemId", i);
                }
                if (i2 != 0) {
                    jSONObject2.put("jump", i2);
                }
                if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                        jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                    }
                    jSONObject2.put("items", jSONArray);
                }
                if (num != null) {
                    switch (num.intValue()) {
                        case 0:
                            jSONObject2.put("repeatMode", "REPEAT_OFF");
                            break;
                        case 1:
                            jSONObject2.put("repeatMode", "REPEAT_ALL");
                            break;
                        case 2:
                            jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                            break;
                        case 3:
                            jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                            break;
                    }
                }
                if (j != -1) {
                    jSONObject2.put("currentTime", zzf.zzA(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zznO, null);
            return zznO;
        }
        throw new IllegalArgumentException("playPosition cannot be negative: " + j);
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacH.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", zznw());
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacD.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zznO = zznO();
        this.zzacM.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject.put("requestId", zznO);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zznw());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacE.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zznw());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacJ.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zznw());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, int[] iArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacQ.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zznw());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, int[] iArr, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacP.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zznw());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zznO = zznO();
        this.zzacL.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject.put("requestId", zznO);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zznw());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zznO, null);
        return zznO;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, MediaQueueItem[] mediaQueueItemArr, int i, int i2, int i3, long j, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalStateException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        } else if (i2 != 0 && i3 != -1) {
            throw new IllegalArgumentException("can not set both currentItemId and currentItemIndexInItemsToInsert");
        } else if (i3 != -1 && (i3 < 0 || i3 >= mediaQueueItemArr.length)) {
            throw new IllegalArgumentException(String.format("currentItemIndexInItemsToInsert %d out of range [0, %d).", new Object[]{Integer.valueOf(i3), Integer.valueOf(mediaQueueItemArr.length)}));
        } else if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zznO = zznO();
            this.zzacN.zza(zznO, com_google_android_gms_cast_internal_zzo);
            zzW(true);
            try {
                jSONObject2.put("requestId", zznO);
                jSONObject2.put("type", "QUEUE_INSERT");
                jSONObject2.put("mediaSessionId", zznw());
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < mediaQueueItemArr.length; i4++) {
                    jSONArray.put(i4, mediaQueueItemArr[i4].toJson());
                }
                jSONObject2.put("items", jSONArray);
                if (i != 0) {
                    jSONObject2.put("insertBefore", i);
                }
                if (i2 != 0) {
                    jSONObject2.put("currentItemId", i2);
                }
                if (i3 != -1) {
                    jSONObject2.put("currentItemIndex", i3);
                }
                if (j != -1) {
                    jSONObject2.put("currentTime", zzf.zzA(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zznO, null);
            return zznO;
        } else {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IOException, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        } else if (i < 0 || i >= mediaQueueItemArr.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        } else if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zznO = zznO();
            this.zzacD.zza(zznO, com_google_android_gms_cast_internal_zzo);
            zzW(true);
            try {
                jSONObject2.put("requestId", zznO);
                jSONObject2.put("type", "QUEUE_LOAD");
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
                switch (i2) {
                    case 0:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case 1:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case 2:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case 3:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid repeat mode: " + i2);
                }
                jSONObject2.put("startIndex", i);
                if (j != -1) {
                    jSONObject2.put("currentTime", zzf.zzA(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zznO, null);
            return zznO;
        } else {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
    }

    public long zzb(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacG.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zznw());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public void zzb(long j, int i) {
        for (zzp zzc : this.zzaaT) {
            zzc.zzc(j, i);
        }
    }

    public final void zzbZ(String str) {
        this.zzabN.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    zza(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzacC = null;
                onStatusUpdated();
                onMetadataUpdated();
                onQueueStatusUpdated();
                onPreloadStatusUpdated();
                this.zzacK.zzc(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzabN.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzp zzc : this.zzaaT) {
                    zzc.zzc(optLong, 2100, r1);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.zzacD.zzc(optLong, 2100, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zzacD.zzc(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.zzabN.zzf("received unexpected error: Invalid Request.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzp zzc2 : this.zzaaT) {
                    zzc2.zzc(optLong, 2100, r1);
                }
            }
        } catch (JSONException e) {
            this.zzabN.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zzc(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zznO = zznO();
        this.zzacF.zza(zznO, com_google_android_gms_cast_internal_zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zznO);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zznw());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zznO, null);
        return zznO;
    }

    public void zznN() {
        super.zznN();
        zzog();
    }

    public long zznw() throws IllegalStateException {
        if (this.zzacC != null) {
            return this.zzacC.zznw();
        }
        throw new IllegalStateException("No current media session");
    }

    protected boolean zzz(long j) {
        boolean z;
        for (zzp zzd : this.zzaaT) {
            zzd.zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzp.zzacU) {
            for (zzp zzd2 : this.zzaaT) {
                if (zzd2.zzoi()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
