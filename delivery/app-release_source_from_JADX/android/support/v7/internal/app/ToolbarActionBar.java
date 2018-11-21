package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.WindowCallbackWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

public class ToolbarActionBar extends ActionBar {
    private DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private ListMenuPresenter mListMenuPresenter;
    private boolean mMenuCallbackSet;
    private final OnMenuItemClickListener mMenuClicker = new C05922();
    private final Runnable mMenuInvalidator = new C00971();
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    private Toolbar mToolbar;
    private boolean mToolbarMenuPrepared;
    private Window mWindow;
    private WindowCallback mWindowCallback;

    class C00971 implements Runnable {
        C00971() {
        }

        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    }

    class C05922 implements OnMenuItemClickListener {
        C05922() {
        }

        public boolean onMenuItemClick(MenuItem item) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, item);
        }
    }

    private final class ActionMenuPresenterCallback implements Callback {
        private boolean mClosingActionMenu;

        private ActionMenuPresenterCallback() {
        }

        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (ToolbarActionBar.this.mWindowCallback == null) {
                return false;
            }
            ToolbarActionBar.this.mWindowCallback.onMenuOpened(8, subMenu);
            return true;
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            if (!this.mClosingActionMenu) {
                this.mClosingActionMenu = true;
                ToolbarActionBar.this.mToolbar.dismissPopupMenus();
                if (ToolbarActionBar.this.mWindowCallback != null) {
                    ToolbarActionBar.this.mWindowCallback.onPanelClosed(8, menu);
                }
                this.mClosingActionMenu = false;
            }
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        private MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            return false;
        }

        public void onMenuModeChange(MenuBuilder menu) {
            if (ToolbarActionBar.this.mWindowCallback == null) {
                return;
            }
            if (ToolbarActionBar.this.mToolbar.isOverflowMenuShowing()) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(8, menu);
            } else if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(0, null, menu)) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(8, menu);
            }
        }
    }

    private final class PanelMenuPresenterCallback implements Callback {
        private PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            if (ToolbarActionBar.this.mWindowCallback != null) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(0, menu);
            }
            ToolbarActionBar.this.mWindow.closePanel(0);
        }

        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (subMenu == null && ToolbarActionBar.this.mWindowCallback != null) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(0, subMenu);
            }
            return true;
        }
    }

    private class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public ToolbarCallbackWrapper(WindowCallback wrapped) {
            super(wrapped);
        }

        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            boolean result = super.onPreparePanel(featureId, view, menu);
            if (result && !ToolbarActionBar.this.mToolbarMenuPrepared) {
                ToolbarActionBar.this.mDecorToolbar.setMenuPrepared();
                ToolbarActionBar.this.mToolbarMenuPrepared = true;
            }
            return result;
        }

        public View onCreatePanelView(int featureId) {
            switch (featureId) {
                case 0:
                    if (!ToolbarActionBar.this.mToolbarMenuPrepared) {
                        ToolbarActionBar.this.populateOptionsMenu();
                        ToolbarActionBar.this.mToolbar.removeCallbacks(ToolbarActionBar.this.mMenuInvalidator);
                    }
                    if (ToolbarActionBar.this.mToolbarMenuPrepared && ToolbarActionBar.this.mWindowCallback != null) {
                        Menu menu = ToolbarActionBar.this.getMenu();
                        if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(featureId, null, menu) && ToolbarActionBar.this.mWindowCallback.onMenuOpened(featureId, menu)) {
                            return ToolbarActionBar.this.getListMenuView(menu);
                        }
                    }
            }
            return super.onCreatePanelView(featureId);
        }
    }

    void populateOptionsMenu() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.getMenu();
        r2 = r1 instanceof android.support.v7.internal.view.menu.MenuBuilder;
        if (r2 == 0) goto L_0x000d;
    L_0x0009:
        r2 = r1;
        r2 = (android.support.v7.internal.view.menu.MenuBuilder) r2;
        r0 = r2;
    L_0x000d:
        if (r0 == 0) goto L_0x0012;
    L_0x000f:
        r0.stopDispatchingItemsChanged();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0031 }
        r2 = r5.mWindowCallback;	 Catch:{ all -> 0x0031 }
        r3 = 0;	 Catch:{ all -> 0x0031 }
        r2 = r2.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ all -> 0x0031 }
    L_0x001e:
        r2 = r5.mWindowCallback;	 Catch:{ all -> 0x0031 }
        r3 = 0;	 Catch:{ all -> 0x0031 }
        r4 = 0;	 Catch:{ all -> 0x0031 }
        r2 = r2.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0031 }
        if (r2 != 0) goto L_0x002b;	 Catch:{ all -> 0x0031 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0031 }
    L_0x002b:
        if (r0 == 0) goto L_0x0030;
    L_0x002d:
        r0.startDispatchingItemsChanged();
    L_0x0030:
        return;
    L_0x0031:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0037;
    L_0x0034:
        r0.startDispatchingItemsChanged();
    L_0x0037:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.app.ToolbarActionBar.populateOptionsMenu():void");
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence title, Window window, WindowCallback windowCallback) {
        this.mToolbar = toolbar;
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        this.mWindowCallback = new ToolbarCallbackWrapper(windowCallback);
        this.mDecorToolbar.setWindowCallback(this.mWindowCallback);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(title);
        this.mWindow = window;
    }

    public WindowCallback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    public void setCustomView(View view) {
        setCustomView(view, new LayoutParams(-2, -2));
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(resId, this.mToolbar, false));
    }

    public void setIcon(int resId) {
        this.mDecorToolbar.setIcon(resId);
    }

    public void setIcon(Drawable icon) {
        this.mDecorToolbar.setIcon(icon);
    }

    public void setLogo(int resId) {
        this.mDecorToolbar.setLogo(resId);
    }

    public void setLogo(Drawable logo) {
        this.mDecorToolbar.setLogo(logo);
    }

    public void setStackedBackgroundDrawable(Drawable d) {
    }

    public void setSplitBackgroundDrawable(Drawable d) {
    }

    public void setHomeButtonEnabled(boolean enabled) {
    }

    public void setElevation(float elevation) {
        ViewCompat.setElevation(this.mToolbar, elevation);
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mToolbar);
    }

    public Context getThemedContext() {
        return this.mToolbar.getContext();
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        this.mToolbar.setNavigationIcon(indicator);
    }

    public void setHomeAsUpIndicator(int resId) {
        this.mToolbar.setNavigationIcon(resId);
    }

    public void setHomeActionContentDescription(CharSequence description) {
        this.mDecorToolbar.setNavigationContentDescription(description);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean enabled) {
    }

    public void setHomeActionContentDescription(int resId) {
        this.mDecorToolbar.setNavigationContentDescription(resId);
    }

    public void setShowHideAnimationEnabled(boolean enabled) {
    }

    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mWindowCallback.startActionMode(callback);
    }

    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        this.mDecorToolbar.setDropdownParams(adapter, new NavItemSelectedListener(callback));
    }

    public void setSelectedNavigationItem(int position) {
        switch (this.mDecorToolbar.getNavigationMode()) {
            case 1:
                this.mDecorToolbar.setDropdownSelectedPosition(position);
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public void setTitle(CharSequence title) {
        this.mDecorToolbar.setTitle(title);
    }

    public void setTitle(int resId) {
        this.mDecorToolbar.setTitle(resId != 0 ? this.mDecorToolbar.getContext().getText(resId) : null);
    }

    public void setWindowTitle(CharSequence title) {
        this.mDecorToolbar.setWindowTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mDecorToolbar.setSubtitle(subtitle);
    }

    public void setSubtitle(int resId) {
        this.mDecorToolbar.setSubtitle(resId != 0 ? this.mDecorToolbar.getContext().getText(resId) : null);
    }

    public void setDisplayOptions(int options) {
        setDisplayOptions(options, -1);
    }

    public void setDisplayOptions(int options, int mask) {
        this.mDecorToolbar.setDisplayOptions((options & mask) | ((mask ^ -1) & this.mDecorToolbar.getDisplayOptions()));
    }

    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? 1 : 0, 1);
    }

    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? 2 : 0, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? 4 : 0, 4);
    }

    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? 8 : 0, 8);
    }

    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? 16 : 0, 16);
    }

    public void setBackgroundDrawable(@Nullable Drawable d) {
        this.mToolbar.setBackgroundDrawable(d);
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    public int getNavigationMode() {
        return 0;
    }

    public void setNavigationMode(int mode) {
        if (mode == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.mDecorToolbar.setNavigationMode(mode);
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab, boolean setSelected) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab, int position) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab tab, int position, boolean setSelected) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTab(Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int position) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void selectTab(Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public Tab getTabAt(int index) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    public void show() {
        this.mToolbar.setVisibility(0);
    }

    public void hide() {
        this.mToolbar.setVisibility(8);
    }

    public boolean isShowing() {
        return this.mToolbar.getVisibility() == 0;
    }

    public boolean openOptionsMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public boolean invalidateOptionsMenu() {
        this.mToolbar.removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mToolbar, this.mMenuInvalidator);
        return true;
    }

    public boolean collapseActionView() {
        if (!this.mToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mToolbar.collapseActionView();
        return true;
    }

    public boolean onMenuKeyEvent(KeyEvent event) {
        if (event.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.add(listener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.remove(listener);
    }

    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        if (isVisible != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = isVisible;
            int count = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < count; i++) {
                ((OnMenuVisibilityListener) this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(isVisible);
            }
        }
    }

    private View getListMenuView(Menu menu) {
        if (menu == null || this.mListMenuPresenter == null || this.mListMenuPresenter.getAdapter().getCount() <= 0) {
            return null;
        }
        return (View) this.mListMenuPresenter.getMenuView(this.mToolbar);
    }

    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.mMenuCallbackSet = true;
        }
        return this.mToolbar.getMenu();
    }

    public void setListMenuPresenter(ListMenuPresenter listMenuPresenter) {
        Menu menu = getMenu();
        if (menu instanceof MenuBuilder) {
            MenuBuilder mb = (MenuBuilder) menu;
            if (this.mListMenuPresenter != null) {
                this.mListMenuPresenter.setCallback(null);
                mb.removeMenuPresenter(this.mListMenuPresenter);
            }
            this.mListMenuPresenter = listMenuPresenter;
            if (listMenuPresenter != null) {
                listMenuPresenter.setCallback(new PanelMenuPresenterCallback());
                mb.addMenuPresenter(listMenuPresenter);
            }
        }
    }
}
