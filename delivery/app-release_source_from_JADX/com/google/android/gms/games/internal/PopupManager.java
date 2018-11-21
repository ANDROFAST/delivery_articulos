package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.zznx;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl zzaDb;
    protected PopupLocationInfo zzaDc;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzaDd;
        public int zzaDe;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.zzaDe = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.zzaDd = windowToken;
        }

        public Bundle zzwz() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzaDe);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean zzaBA = false;
        private WeakReference<View> zzaDf;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
        }

        private void zzq(View view) {
            int i = -1;
            if (zznx.zzrS()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzaDc.zzaDe = i;
            this.zzaDc.zzaDd = windowToken;
            this.zzaDc.left = iArr[0];
            this.zzaDc.top = iArr[1];
            this.zzaDc.right = iArr[0] + width;
            this.zzaDc.bottom = iArr[1] + height;
            if (this.zzaBA) {
                zzwA();
                this.zzaBA = false;
            }
        }

        public void onGlobalLayout() {
            if (this.zzaDf != null) {
                View view = (View) this.zzaDf.get();
                if (view != null) {
                    zzq(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            zzq(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.zzaDb.zzwn();
            v.removeOnAttachStateChangeListener(this);
        }

        protected void zzgn(int i) {
            this.zzaDc = new PopupLocationInfo(i, null);
        }

        public void zzp(View view) {
            View view2;
            Context context;
            this.zzaDb.zzwn();
            if (this.zzaDf != null) {
                view2 = (View) this.zzaDf.get();
                context = this.zzaDb.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zznx.zzrR()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzaDf = null;
            context = this.zzaDb.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.zzA("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = view2;
            }
            if (view != null) {
                zzq(view);
                this.zzaDf = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.zzB("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void zzwA() {
            if (this.zzaDc.zzaDd != null) {
                super.zzwA();
            } else {
                this.zzaBA = this.zzaDf != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.zzaDb = gamesClientImpl;
        zzgn(gravity);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zznx.zzrO() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int gravity) {
        this.zzaDc.gravity = gravity;
    }

    protected void zzgn(int i) {
        this.zzaDc = new PopupLocationInfo(i, new Binder());
    }

    public void zzp(View view) {
    }

    public void zzwA() {
        this.zzaDb.zza(this.zzaDc.zzaDd, this.zzaDc.zzwz());
    }

    public Bundle zzwB() {
        return this.zzaDc.zzwz();
    }

    public IBinder zzwC() {
        return this.zzaDc.zzaDd;
    }

    public PopupLocationInfo zzwD() {
        return this.zzaDc;
    }
}
