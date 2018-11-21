package com.myapps.delivery;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerFragment extends Fragment implements NavigationDrawerCallbacks {
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationDrawerCallbacks mCallbacks;
    private int mCurrentSelectedPosition = 0;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private View mFragmentContainerView;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;

    class C04762 implements Runnable {
        C04762() {
        }

        public void run() {
            NavigationDrawerFragment.this.mActionBarDrawerToggle.syncState();
        }
    }

    public static class RoundImage extends Drawable {
        private final Bitmap mBitmap;
        private final int mBitmapHeight;
        private final int mBitmapWidth;
        private final Paint mPaint = new Paint();
        private final RectF mRectF = new RectF();

        public RoundImage(Bitmap bitmap) {
            this.mBitmap = bitmap;
            this.mPaint.setAntiAlias(true);
            this.mPaint.setDither(true);
            this.mPaint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBitmapHeight = this.mBitmap.getHeight();
        }

        public void draw(Canvas canvas) {
            canvas.drawOval(this.mRectF, this.mPaint);
        }

        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            this.mRectF.set(bounds);
        }

        public void setAlpha(int alpha) {
            if (this.mPaint.getAlpha() != alpha) {
                this.mPaint.setAlpha(alpha);
                invalidateSelf();
            }
        }

        public void setColorFilter(ColorFilter cf) {
            this.mPaint.setColorFilter(cf);
        }

        public int getOpacity() {
            return -3;
        }

        public int getIntrinsicWidth() {
            return this.mBitmapWidth;
        }

        public int getIntrinsicHeight() {
            return this.mBitmapHeight;
        }

        public void setAntiAlias(boolean aa) {
            this.mPaint.setAntiAlias(aa);
            invalidateSelf();
        }

        public void setFilterBitmap(boolean filter) {
            this.mPaint.setFilterBitmap(filter);
            invalidateSelf();
        }

        public void setDither(boolean dither) {
            this.mPaint.setDither(dither);
            invalidateSelf();
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mUserLearnedDrawer = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean(PREF_USER_LEARNED_DRAWER, false);
        if (savedInstanceState != null) {
            this.mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            this.mFromSavedInstanceState = true;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0477R.layout.fragment_navigation_drawer, container, false);
        this.mDrawerList = (RecyclerView) view.findViewById(C0477R.id.drawerList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(1);
        this.mDrawerList.setLayoutManager(layoutManager);
        this.mDrawerList.setHasFixedSize(true);
        NavigationDrawerAdapter adapter = new NavigationDrawerAdapter(getMenu());
        adapter.setNavigationDrawerCallbacks(this);
        this.mDrawerList.setAdapter(adapter);
        selectItem(this.mCurrentSelectedPosition);
        return view;
    }

    public boolean isDrawerOpen() {
        return this.mDrawerLayout != null && this.mDrawerLayout.isDrawerOpen(this.mFragmentContainerView);
    }

    public ActionBarDrawerToggle getActionBarDrawerToggle() {
        return this.mActionBarDrawerToggle;
    }

    public DrawerLayout getDrawerLayout() {
        return this.mDrawerLayout;
    }

    public void onNavigationDrawerItemSelected(int position) {
        selectItem(position);
    }

    public List<NavigationItem> getMenu() {
        List<NavigationItem> items = new ArrayList();
        items.add(new NavigationItem(getString(C0477R.string.inicio), getResources().getDrawable(C0477R.mipmap.ic_inicio)));
        items.add(new NavigationItem(getString(C0477R.string.productos), getResources().getDrawable(C0477R.mipmap.ic_productos)));
        items.add(new NavigationItem(getString(C0477R.string.carrito), getResources().getDrawable(C0477R.mipmap.ic_carrito)));
        items.add(new NavigationItem(getString(C0477R.string.cerrar_sesion), getResources().getDrawable(C0477R.mipmap.ic_salir)));
        return items;
    }

    public void setup(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        this.mFragmentContainerView = (View) getActivity().findViewById(fragmentId).getParent();
        this.mDrawerLayout = drawerLayout;
        this.mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(C0477R.color.myPrimaryDarkColor));
        this.mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), this.mDrawerLayout, toolbar, C0477R.string.drawer_open, C0477R.string.drawer_close) {
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (NavigationDrawerFragment.this.isAdded()) {
                    NavigationDrawerFragment.this.getActivity().invalidateOptionsMenu();
                }
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (NavigationDrawerFragment.this.isAdded()) {
                    if (!NavigationDrawerFragment.this.mUserLearnedDrawer) {
                        NavigationDrawerFragment.this.mUserLearnedDrawer = true;
                        PreferenceManager.getDefaultSharedPreferences(NavigationDrawerFragment.this.getActivity()).edit().putBoolean(NavigationDrawerFragment.PREF_USER_LEARNED_DRAWER, true).apply();
                    }
                    NavigationDrawerFragment.this.getActivity().invalidateOptionsMenu();
                }
            }
        };
        if (!(this.mUserLearnedDrawer || this.mFromSavedInstanceState)) {
            this.mDrawerLayout.openDrawer(this.mFragmentContainerView);
        }
        this.mDrawerLayout.post(new C04762());
        this.mDrawerLayout.setDrawerListener(this.mActionBarDrawerToggle);
    }

    private void selectItem(int position) {
        this.mCurrentSelectedPosition = position;
        if (this.mDrawerLayout != null) {
            this.mDrawerLayout.closeDrawer(this.mFragmentContainerView);
        }
        if (this.mCallbacks != null) {
            this.mCallbacks.onNavigationDrawerItemSelected(position);
        }
        ((NavigationDrawerAdapter) this.mDrawerList.getAdapter()).selectPosition(position);
    }

    public void openDrawer() {
        this.mDrawerLayout.openDrawer(this.mFragmentContainerView);
    }

    public void closeDrawer() {
        this.mDrawerLayout.closeDrawer(this.mFragmentContainerView);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mCallbacks = null;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, this.mCurrentSelectedPosition);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void setUserData(String user, String email, Bitmap avatar) {
        ImageView avatarContainer = (ImageView) this.mFragmentContainerView.findViewById(C0477R.id.imgAvatar);
        ((TextView) this.mFragmentContainerView.findViewById(C0477R.id.txtUserEmail)).setText(email);
        ((TextView) this.mFragmentContainerView.findViewById(C0477R.id.txtUsername)).setText(user);
        avatarContainer.setImageDrawable(new RoundImage(avatar));
    }

    public View getGoogleDrawer() {
        return this.mFragmentContainerView.findViewById(C0477R.id.googleDrawer);
    }
}
