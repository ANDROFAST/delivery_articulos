package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.PlatformType;

public final class GameInstanceRef extends zzc implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public String toString() {
        return zzw.zzx(this).zzg("ApplicationId", getApplicationId()).zzg("DisplayName", getDisplayName()).zzg("SupportsRealTime", Boolean.valueOf(zzwG())).zzg("SupportsTurnBased", Boolean.valueOf(zzwH())).zzg("PlatformType", PlatformType.zzgo(zztN())).zzg("PackageName", getPackageName()).zzg("PiracyCheckEnabled", Boolean.valueOf(zzwI())).zzg("Installed", Boolean.valueOf(zzwJ())).toString();
    }

    public int zztN() {
        return getInteger("platform_type");
    }

    public boolean zzwG() {
        return getInteger("real_time_support") > 0;
    }

    public boolean zzwH() {
        return getInteger("turn_based_support") > 0;
    }

    public boolean zzwI() {
        return getInteger("piracy_check") > 0;
    }

    public boolean zzwJ() {
        return getInteger("installed") > 0;
    }
}
