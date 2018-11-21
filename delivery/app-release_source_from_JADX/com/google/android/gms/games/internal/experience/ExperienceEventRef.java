package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef zzaFA;

    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        if (zzcv("external_game_id")) {
            this.zzaFA = null;
        } else {
            this.zzaFA = new GameRef(this.zzafC, this.zzahw);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
