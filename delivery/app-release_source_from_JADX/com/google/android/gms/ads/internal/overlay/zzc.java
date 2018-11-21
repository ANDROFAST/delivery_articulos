package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzha
public class zzc extends zzi implements OnAudioFocusChangeListener, OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> zzCN = new HashMap();
    private final zzp zzCO;
    private int zzCP = 0;
    private int zzCQ = 0;
    private MediaPlayer zzCR;
    private Uri zzCS;
    private int zzCT;
    private int zzCU;
    private int zzCV;
    private int zzCW;
    private int zzCX;
    private float zzCY = TextTrackStyle.DEFAULT_FONT_SCALE;
    private boolean zzCZ;
    private boolean zzDa;
    private int zzDb;
    private zzh zzDc;

    class C01491 implements Runnable {
        final /* synthetic */ zzc zzDd;

        C01491(zzc com_google_android_gms_ads_internal_overlay_zzc) {
            this.zzDd = com_google_android_gms_ads_internal_overlay_zzc;
        }

        public void run() {
            if (this.zzDd.zzDc != null) {
                this.zzDd.zzDc.zzfo();
            }
        }
    }

    class C01502 implements Runnable {
        final /* synthetic */ zzc zzDd;

        C01502(zzc com_google_android_gms_ads_internal_overlay_zzc) {
            this.zzDd = com_google_android_gms_ads_internal_overlay_zzc;
        }

        public void run() {
            if (this.zzDd.zzDc != null) {
                this.zzDd.zzDc.zzfq();
            }
        }
    }

    class C01524 implements Runnable {
        final /* synthetic */ zzc zzDd;

        C01524(zzc com_google_android_gms_ads_internal_overlay_zzc) {
            this.zzDd = com_google_android_gms_ads_internal_overlay_zzc;
        }

        public void run() {
            if (this.zzDd.zzDc != null) {
                this.zzDd.zzDc.zzfn();
            }
        }
    }

    class C01535 implements Runnable {
        final /* synthetic */ zzc zzDd;

        C01535(zzc com_google_android_gms_ads_internal_overlay_zzc) {
            this.zzDd = com_google_android_gms_ads_internal_overlay_zzc;
        }

        public void run() {
            if (this.zzDd.zzDc != null) {
                this.zzDd.zzDc.onPaused();
                this.zzDd.zzDc.zzfr();
            }
        }
    }

    class C01546 implements Runnable {
        final /* synthetic */ zzc zzDd;

        C01546(zzc com_google_android_gms_ads_internal_overlay_zzc) {
            this.zzDd = com_google_android_gms_ads_internal_overlay_zzc;
        }

        public void run() {
            if (this.zzDd.zzDc != null) {
                this.zzDd.zzDc.zzfp();
            }
        }
    }

    class C01557 implements Runnable {
        final /* synthetic */ zzc zzDd;

        C01557(zzc com_google_android_gms_ads_internal_overlay_zzc) {
            this.zzDd = com_google_android_gms_ads_internal_overlay_zzc;
        }

        public void run() {
            if (this.zzDd.zzDc != null) {
                this.zzDd.zzDc.onPaused();
            }
        }
    }

    static {
        zzCN.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        zzCN.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        zzCN.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        zzCN.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        zzCN.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        zzCN.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        zzCN.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        zzCN.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzCN.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        zzCN.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        zzCN.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        zzCN.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        zzCN.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        zzCN.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        zzCN.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzCN.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, zzp com_google_android_gms_ads_internal_overlay_zzp) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzCO = com_google_android_gms_ads_internal_overlay_zzp;
        this.zzCO.zza((zzi) this);
    }

    private void zzb(float f) {
        if (this.zzCR != null) {
            try {
                this.zzCR.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        zzb.zzaH("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private void zzeP() {
        Throwable e;
        zzb.m7v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzCS != null && surfaceTexture != null) {
            zzv(false);
            try {
                this.zzCR = new MediaPlayer();
                this.zzCR.setOnBufferingUpdateListener(this);
                this.zzCR.setOnCompletionListener(this);
                this.zzCR.setOnErrorListener(this);
                this.zzCR.setOnInfoListener(this);
                this.zzCR.setOnPreparedListener(this);
                this.zzCR.setOnVideoSizeChangedListener(this);
                this.zzCV = 0;
                this.zzCR.setDataSource(getContext(), this.zzCS);
                this.zzCR.setSurface(new Surface(surfaceTexture));
                this.zzCR.setAudioStreamType(3);
                this.zzCR.setScreenOnWhilePlaying(true);
                this.zzCR.prepareAsync();
                zzw(1);
            } catch (IOException e2) {
                e = e2;
                zzb.zzd("Failed to initialize MediaPlayer at " + this.zzCS, e);
                onError(this.zzCR, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                zzb.zzd("Failed to initialize MediaPlayer at " + this.zzCS, e);
                onError(this.zzCR, 1, 0);
            }
        }
    }

    private void zzeQ() {
        if (zzeT() && this.zzCR.getCurrentPosition() > 0 && this.zzCQ != 3) {
            zzb.m7v("AdMediaPlayerView nudging MediaPlayer");
            zzb(0.0f);
            this.zzCR.start();
            int currentPosition = this.zzCR.getCurrentPosition();
            long currentTimeMillis = zzp.zzbB().currentTimeMillis();
            while (zzeT() && this.zzCR.getCurrentPosition() == currentPosition) {
                if (zzp.zzbB().currentTimeMillis() - currentTimeMillis > 250) {
                    break;
                }
            }
            this.zzCR.pause();
            zzeY();
        }
    }

    private void zzeR() {
        AudioManager zzeZ = zzeZ();
        if (zzeZ != null && !this.zzDa) {
            if (zzeZ.requestAudioFocus(this, 3, 2) == 1) {
                zzeW();
            } else {
                zzb.zzaH("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void zzeS() {
        zzb.m7v("AdMediaPlayerView abandon audio focus");
        AudioManager zzeZ = zzeZ();
        if (zzeZ != null && this.zzDa) {
            if (zzeZ.abandonAudioFocus(this) == 1) {
                this.zzDa = false;
            } else {
                zzb.zzaH("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean zzeT() {
        return (this.zzCR == null || this.zzCP == -1 || this.zzCP == 0 || this.zzCP == 1) ? false : true;
    }

    private void zzeW() {
        zzb.m7v("AdMediaPlayerView audio focus gained");
        this.zzDa = true;
        zzeY();
    }

    private void zzeX() {
        zzb.m7v("AdMediaPlayerView audio focus lost");
        this.zzDa = false;
        zzeY();
    }

    private void zzeY() {
        if (this.zzCZ || !this.zzDa) {
            zzb(0.0f);
        } else {
            zzb(this.zzCY);
        }
    }

    private AudioManager zzeZ() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzv(boolean z) {
        zzb.m7v("AdMediaPlayerView release");
        if (this.zzCR != null) {
            this.zzCR.reset();
            this.zzCR.release();
            this.zzCR = null;
            zzw(0);
            if (z) {
                this.zzCQ = 0;
                zzx(0);
            }
            zzeS();
        }
    }

    private void zzw(int i) {
        if (i == 3) {
            this.zzCO.zzfB();
        } else if (this.zzCP == 3 && i != 3) {
            this.zzCO.zzfC();
        }
        this.zzCP = i;
    }

    private void zzx(int i) {
        this.zzCQ = i;
    }

    public int getCurrentPosition() {
        return zzeT() ? this.zzCR.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return zzeT() ? this.zzCR.getDuration() : -1;
    }

    public int getVideoHeight() {
        return this.zzCR != null ? this.zzCR.getVideoHeight() : 0;
    }

    public int getVideoWidth() {
        return this.zzCR != null ? this.zzCR.getVideoWidth() : 0;
    }

    public void onAudioFocusChange(int focusChange) {
        if (focusChange > 0) {
            zzeW();
        } else if (focusChange < 0) {
            zzeX();
        }
    }

    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        this.zzCV = percent;
    }

    public void onCompletion(MediaPlayer mp) {
        zzb.m7v("AdMediaPlayerView completion");
        zzw(5);
        zzx(5);
        zzip.zzKO.post(new C01502(this));
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        final String str = (String) zzCN.get(Integer.valueOf(what));
        final String str2 = (String) zzCN.get(Integer.valueOf(extra));
        zzb.zzaH("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        zzw(-1);
        zzx(-1);
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzc zzDd;

            public void run() {
                if (this.zzDd.zzDc != null) {
                    this.zzDd.zzDc.zzg(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        String str = (String) zzCN.get(Integer.valueOf(extra));
        zzb.m7v("AdMediaPlayerView MediaPlayer info: " + ((String) zzCN.get(Integer.valueOf(what))) + ":" + str);
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = getDefaultSize(this.zzCT, widthMeasureSpec);
        int defaultSize2 = getDefaultSize(this.zzCU, heightMeasureSpec);
        if (this.zzCT > 0 && this.zzCU > 0) {
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            int size = MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = MeasureSpec.getMode(heightMeasureSpec);
            defaultSize2 = MeasureSpec.getSize(heightMeasureSpec);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzCT * defaultSize2 < this.zzCU * size) {
                    defaultSize = (this.zzCT * defaultSize2) / this.zzCU;
                } else if (this.zzCT * defaultSize2 > this.zzCU * size) {
                    defaultSize2 = (this.zzCU * size) / this.zzCT;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.zzCU * size) / this.zzCT;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzCT * defaultSize2) / this.zzCU;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i = this.zzCT;
                defaultSize = this.zzCU;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i;
                } else {
                    defaultSize = (this.zzCT * defaultSize2) / this.zzCU;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.zzCU * size) / this.zzCT;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (VERSION.SDK_INT == 16) {
            if ((this.zzCW > 0 && this.zzCW != defaultSize) || (this.zzCX > 0 && this.zzCX != defaultSize2)) {
                zzeQ();
            }
            this.zzCW = defaultSize;
            this.zzCX = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zzb.m7v("AdMediaPlayerView prepared");
        zzw(2);
        this.zzCO.zzfo();
        zzip.zzKO.post(new C01491(this));
        this.zzCT = mediaPlayer.getVideoWidth();
        this.zzCU = mediaPlayer.getVideoHeight();
        if (this.zzDb != 0) {
            seekTo(this.zzDb);
        }
        zzeQ();
        zzb.zzaG("AdMediaPlayerView stream dimensions: " + this.zzCT + " x " + this.zzCU);
        if (this.zzCQ == 3) {
            play();
        }
        zzeR();
        zzeY();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        zzb.m7v("AdMediaPlayerView surface created");
        zzeP();
        zzip.zzKO.post(new C01524(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        zzb.m7v("AdMediaPlayerView surface destroyed");
        if (this.zzCR != null && this.zzDb == 0) {
            this.zzDb = this.zzCR.getCurrentPosition();
        }
        zzip.zzKO.post(new C01535(this));
        zzv(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int w, int h) {
        Object obj = 1;
        zzb.m7v("AdMediaPlayerView surface changed");
        Object obj2 = this.zzCQ == 3 ? 1 : null;
        if (!(this.zzCT == w && this.zzCU == h)) {
            obj = null;
        }
        if (this.zzCR != null && obj2 != null && r1 != null) {
            if (this.zzDb != 0) {
                seekTo(this.zzDb);
            }
            play();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        this.zzCO.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        zzb.m7v("AdMediaPlayerView size changed: " + width + " x " + height);
        this.zzCT = mp.getVideoWidth();
        this.zzCU = mp.getVideoHeight();
        if (this.zzCT != 0 && this.zzCU != 0) {
            requestLayout();
        }
    }

    public void pause() {
        zzb.m7v("AdMediaPlayerView pause");
        if (zzeT() && this.zzCR.isPlaying()) {
            this.zzCR.pause();
            zzw(4);
            zzip.zzKO.post(new C01557(this));
        }
        zzx(4);
    }

    public void play() {
        zzb.m7v("AdMediaPlayerView play");
        if (zzeT()) {
            this.zzCR.start();
            zzw(3);
            zzip.zzKO.post(new C01546(this));
        }
        zzx(3);
    }

    public void seekTo(int millis) {
        zzb.m7v("AdMediaPlayerView seek " + millis);
        if (zzeT()) {
            this.zzCR.seekTo(millis);
            this.zzDb = 0;
            return;
        }
        this.zzDb = millis;
    }

    public void setMimeType(String mimeType) {
    }

    public void setVideoPath(String path) {
        setVideoURI(Uri.parse(path));
    }

    public void setVideoURI(Uri uri) {
        this.zzCS = uri;
        this.zzDb = 0;
        zzeP();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzb.m7v("AdMediaPlayerView stop");
        if (this.zzCR != null) {
            this.zzCR.stop();
            this.zzCR.release();
            this.zzCR = null;
            zzw(0);
            zzx(0);
            zzeS();
        }
        this.zzCO.onStop();
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public void zza(float f) {
        this.zzCY = f;
        zzeY();
    }

    public void zza(zzh com_google_android_gms_ads_internal_overlay_zzh) {
        this.zzDc = com_google_android_gms_ads_internal_overlay_zzh;
    }

    public String zzeO() {
        return "MediaPlayer";
    }

    public void zzeU() {
        this.zzCZ = true;
        zzeY();
    }

    public void zzeV() {
        this.zzCZ = false;
        zzeY();
    }
}
