package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import com.google.android.gms.analytics.internal.zzae;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler zzNG;
    private final Tracker zzNH;
    private ExceptionParser zzNI;
    private GoogleAnalytics zzNJ;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler originalHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.zzNG = originalHandler;
            this.zzNH = tracker;
            this.zzNI = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            zzae.m8v("ExceptionReporter created, original handler is " + (originalHandler == null ? "null" : originalHandler.getClass().getName()));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzNI;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzNI = exceptionParser;
    }

    public void uncaughtException(Thread t, Throwable e) {
        String str = "UncaughtException";
        if (this.zzNI != null) {
            str = this.zzNI.getDescription(t != null ? t.getName() : null, e);
        }
        zzae.m8v("Reporting uncaught exception: " + str);
        this.zzNH.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics zzik = zzik();
        zzik.dispatchLocalHits();
        zzik.zzio();
        if (this.zzNG != null) {
            zzae.m8v("Passing exception to the original handler");
            this.zzNG.uncaughtException(t, e);
        }
    }

    GoogleAnalytics zzik() {
        if (this.zzNJ == null) {
            this.zzNJ = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzNJ;
    }

    UncaughtExceptionHandler zzil() {
        return this.zzNG;
    }
}
