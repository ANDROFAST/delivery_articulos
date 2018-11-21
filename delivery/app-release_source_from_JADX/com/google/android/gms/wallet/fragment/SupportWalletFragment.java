package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsv;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzajv = this;
    private zzb zzbkN;
    private final zzh zzbkO = zzh.zza(this);
    private final zzc zzbkP = new zzc();
    private zza zzbkQ = new zza(this);
    private WalletFragmentOptions zzbkR;
    private WalletFragmentInitParams zzbkS;
    private MaskedWalletRequest zzbkT;
    private MaskedWallet zzbkU;
    private Boolean zzbkV;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
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
        final /* synthetic */ SupportWalletFragment zzbkZ;

        private zzc(SupportWalletFragment supportWalletFragment) {
            this.zzbkZ = supportWalletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzbkZ.zzajv.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzbkZ.zzajv.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzbkZ.zzbkR != null) {
                WalletFragmentStyle fragmentStyle = this.zzbkZ.zzbkR.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzbkZ.zzajv.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb) {
            Activity activity = this.zzbkZ.zzajv.getActivity();
            if (this.zzbkZ.zzbkN == null && this.zzbkZ.mCreated && activity != null) {
                try {
                    this.zzbkZ.zzbkN = new zzb(zzsv.zza(activity, this.zzbkZ.zzbkO, this.zzbkZ.zzbkR, this.zzbkZ.zzbkQ));
                    this.zzbkZ.zzbkR = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb.zza(this.zzbkZ.zzbkN);
                    if (this.zzbkZ.zzbkS != null) {
                        this.zzbkZ.zzbkN.initialize(this.zzbkZ.zzbkS);
                        this.zzbkZ.zzbkS = null;
                    }
                    if (this.zzbkZ.zzbkT != null) {
                        this.zzbkZ.zzbkN.updateMaskedWalletRequest(this.zzbkZ.zzbkT);
                        this.zzbkZ.zzbkT = null;
                    }
                    if (this.zzbkZ.zzbkU != null) {
                        this.zzbkZ.zzbkN.updateMaskedWallet(this.zzbkZ.zzbkU);
                        this.zzbkZ.zzbkU = null;
                    }
                    if (this.zzbkZ.zzbkV != null) {
                        this.zzbkZ.zzbkN.setEnabled(this.zzbkZ.zzbkV.booleanValue());
                        this.zzbkZ.zzbkV = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzso.zza {
        private OnStateChangedListener zzbkW;
        private final SupportWalletFragment zzbkX;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzbkX = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbkW != null) {
                this.zzbkW.onStateChanged(this.zzbkX, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbkW = onStateChangedListener;
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzajv.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.zzbkN != null ? this.zzbkN.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzbkN != null) {
            this.zzbkN.initialize(initParams);
            this.zzbkS = null;
        } else if (this.zzbkS == null) {
            this.zzbkS = initParams;
            if (this.zzbkT != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbkU != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzbkN != null) {
            this.zzbkN.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbkS != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzajv.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzajv.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzbc(this.zzajv.getActivity());
                this.zzbkR = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzbkP.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzbkP.onCreateView(inflater, container, savedInstanceState);
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
        this.zzbkP.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzbkP.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzbkP.onResume();
        FragmentManager supportFragmentManager = this.zzajv.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzajv.getActivity()), this.zzajv.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbkP.onSaveInstanceState(outState);
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
        this.zzbkP.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzbkP.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzbkN != null) {
            this.zzbkN.setEnabled(enabled);
            this.zzbkV = null;
            return;
        }
        this.zzbkV = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzbkQ.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbkN != null) {
            this.zzbkN.updateMaskedWallet(maskedWallet);
            this.zzbkU = null;
            return;
        }
        this.zzbkU = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzbkN != null) {
            this.zzbkN.updateMaskedWalletRequest(request);
            this.zzbkT = null;
            return;
        }
        this.zzbkT = request;
    }
}
