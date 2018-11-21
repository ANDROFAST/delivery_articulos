package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzb extends zza {
    private Fragment zzatC;

    private zzb(Fragment fragment) {
        this.zzatC = fragment;
    }

    public static zzb zza(Fragment fragment) {
        return fragment != null ? new zzb(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzatC.getArguments();
    }

    public int getId() {
        return this.zzatC.getId();
    }

    public boolean getRetainInstance() {
        return this.zzatC.getRetainInstance();
    }

    public String getTag() {
        return this.zzatC.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzatC.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzatC.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzB(this.zzatC.getView());
    }

    public boolean isAdded() {
        return this.zzatC.isAdded();
    }

    public boolean isDetached() {
        return this.zzatC.isDetached();
    }

    public boolean isHidden() {
        return this.zzatC.isHidden();
    }

    public boolean isInLayout() {
        return this.zzatC.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzatC.isRemoving();
    }

    public boolean isResumed() {
        return this.zzatC.isResumed();
    }

    public boolean isVisible() {
        return this.zzatC.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzatC.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzatC.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzatC.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzatC.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzatC.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzatC.startActivityForResult(intent, requestCode);
    }

    public void zzn(zzd com_google_android_gms_dynamic_zzd) {
        this.zzatC.registerForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public void zzo(zzd com_google_android_gms_dynamic_zzd) {
        this.zzatC.unregisterForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public zzd zztt() {
        return zze.zzB(this.zzatC.getActivity());
    }

    public zzc zztu() {
        return zza(this.zzatC.getParentFragment());
    }

    public zzd zztv() {
        return zze.zzB(this.zzatC.getResources());
    }

    public zzc zztw() {
        return zza(this.zzatC.getTargetFragment());
    }
}
