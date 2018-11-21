package com.google.android.gms.games.video;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class VideoBuffer extends AbstractDataBuffer<Video> {
    public VideoBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int x0) {
        return zzgP(x0);
    }

    public VideoRef zzgP(int i) {
        return new VideoRef(this.zzafC, i);
    }
}
