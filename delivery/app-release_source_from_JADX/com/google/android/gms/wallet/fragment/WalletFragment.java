package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsv;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzatC = this;
    private WalletFragmentOptions zzbkR;
    private WalletFragmentInitParams zzbkS;
    private MaskedWalletRequest zzbkT;
    private MaskedWallet zzbkU;
    private Boolean zzbkV;
    private zzb zzbla;
    private final com.google.android.gms.dynamic.zzb zzblb = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzblc = new zzc();
    private zza zzbld = new zza(this);

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    private static class zzb implements LifecycleDelegate {
        private final zzsn zzbkY;

        private zzb(zzsn com_google_android_gms_internal_zzsn) {
            this.zzbkY = com_google_android_gms_internal_zzsn;
        }

        private int getState() {
            try {
                return this.zzbkY.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzbkY.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzbkY.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.zzbkY.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzbkY.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzbkY.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzbkY.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzbkY.onCreateView(zze.zzB(inflater), zze.zzB(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzbkY.zza(zze.zzB(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzbkY.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzbkY.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzbkY.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzbkY.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzbkY.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        final /* synthetic */ WalletFragment zzblg;

        private zzc(WalletFragment walletFragment) {
            this.zzblg = walletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzblg.zzatC.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzblg.zzatC.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzblg.zzbkR != null) {
                WalletFragmentStyle fragmentStyle = this.zzblg.zzbkR.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzblg.zzatC.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb) {
            Activity activity = this.zzblg.zzatC.getActivity();
            if (this.zzblg.zzbla == null && this.zzblg.mCreated && activity != null) {
                try {
                    this.zzblg.zzbla = new zzb(zzsv.zza(activity, this.zzblg.zzblb, this.zzblg.zzbkR, this.zzblg.zzbld));
                    this.zzblg.zzbkR = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb.zza(this.zzblg.zzbla);
                    if (this.zzblg.zzbkS != null) {
                        this.zzblg.zzbla.initialize(this.zzblg.zzbkS);
                        this.zzblg.zzbkS = null;
                    }
                    if (this.zzblg.zzbkT != null) {
                        this.zzblg.zzbla.updateMaskedWalletRequest(this.zzblg.zzbkT);
                        this.zzblg.zzbkT = null;
                    }
                    if (this.zzblg.zzbkU != null) {
                        this.zzblg.zzbla.updateMaskedWallet(this.zzblg.zzbkU);
                        this.zzblg.zzbkU = null;
                    }
                    if (this.zzblg.zzbkV != null) {
                        this.zzblg.zzbla.setEnabled(this.zzblg.zzbkV.booleanValue());
                        this.zzblg.zzbkV = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzso.zza {
        private OnStateChangedListener zzble;
        private final WalletFragment zzblf;

        zza(WalletFragment walletFragment) {
            this.zzblf = walletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzble != null) {
                this.zzble.onStateChanged(this.zzblf, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzble = onStateChangedListener;
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzatC.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.zzbla != null ? this.zzbla.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzbla != null) {
            this.zzbla.initialize(initParams);
            this.zzbkS = null;
        } else if (this.zzbkS == null) {
            this.zzbkS = initParams;
            if (this.zzbkT != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbkU != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzbla != null) {
            this.zzbla.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbkS != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzbkS = walletFragmentInitParams;
            }
            if (this.zzbkT == null) {
                this.zzbkT = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzbkU == null) {
                this.zzbkU = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzbkR = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzbkV = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzatC.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzatC.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzbc(this.zzatC.getActivity());
                this.zzbkR = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzblc.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzblc.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzbkR == null) {
            this.zzbkR = WalletFragmentOptions.zzb((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzbkR);
        this.zzblc.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzblc.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzblc.onResume();
        FragmentManager fragmentManager = this.zzatC.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzatC.getActivity()), this.zzatC.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzblc.onSaveInstanceState(outState);
        if (this.zzbkS != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzbkS);
            this.zzbkS = null;
        }
        if (this.zzbkT != null) {
            outState.putParcelable("maskedWalletRequest", this.zzbkT);
            this.zzbkT = null;
        }
        if (this.zzbkU != null) {
            outState.putParcelable("maskedWallet", this.zzbkU);
            this.zzbkU = null;
        }
        if (this.zzbkR != null) {
            outState.putParcelable("walletFragmentOptions", this.zzbkR);
            this.zzbkR = null;
        }
        if (this.zzbkV != null) {
            outState.putBoolean("enabled", this.zzbkV.booleanValue());
            this.zzbkV = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzblc.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzblc.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzbla != null) {
            this.zzbla.setEnabled(enabled);
            this.zzbkV = null;
            return;
        }
        this.zzbkV = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzbld.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbla != null) {
            this.zzbla.updateMaskedWallet(maskedWallet);
            this.zzbkU = null;
            return;
        }
        this.zzbkU = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzbla != null) {
            this.zzbla.updateMaskedWalletRequest(request);
            this.zzbkT = null;
            return;
        }
        this.zzbkT = request;
    }
}
