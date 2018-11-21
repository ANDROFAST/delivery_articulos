package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzsi {
    public static final Integer zzbhq = Integer.valueOf(0);
    public static final Integer zzbhr = Integer.valueOf(1);
    private final Context mContext;
    private final ExecutorService zzbfg;

    public zzsi(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzsi(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzbfg = executorService;
    }
}
