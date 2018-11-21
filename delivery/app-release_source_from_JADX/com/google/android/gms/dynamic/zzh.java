package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzh extends zza {
    private Fragment zzajv;

    private zzh(Fragment fragment) {
        this.zzajv = fragment;
    }

    public static zzh zza(Fragment fragment) {
        return fragment != null ? new zzh(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzajv.getArguments();
    }

    public int getId() {
        return this.zzajv.getId();
    }

    public boolean getRetainInstance() {
        return this.zzajv.getRetainInstance();
    }

    public String getTag() {
        return this.zzajv.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzajv.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzajv.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzB(this.zzajv.getView());
    }

    public boolean isAdded() {
        return this.zzajv.isAdded();
    }

    public boolean isDetached() {
        return this.zzajv.isDetached();
    }

    public boolean isHidden() {
        return this.zzajv.isHidden();
    }

    public boolean isInLayout() {
        return this.zzajv.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzajv.isRemoving();
    }

    public boolean isResumed() {
        return this.zzajv.isResumed();
    }

    public boolean isVisible() {
        return this.zzajv.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzajv.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzajv.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzajv.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzajv.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzajv.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzajv.startActivityForResult(intent, requestCode);
    }

    public void zzn(zzd com_google_android_gms_dynamic_zzd) {
        this.zzajv.registerForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public void zzo(zzd com_google_android_gms_dynamic_zzd) {
        this.zzajv.unregisterForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public zzd zztt() {
        return zze.zzB(this.zzajv.getActivity());
    }

    public zzc zztu() {
        return zza(this.zzajv.getParentFragment());
    }

    public zzd zztv() {
        return zze.zzB(this.zzajv.getResources());
    }

    public zzc zztw() {
        return zza(this.zzajv.getTargetFragment());
    }
}
