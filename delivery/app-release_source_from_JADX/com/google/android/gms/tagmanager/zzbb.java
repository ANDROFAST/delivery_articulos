package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class zzbb extends zzak {
    private static final String ID = zzad.LANGUAGE.toString();

    public zzbb() {
        super(ID, new String[0]);
    }

    public /* bridge */ /* synthetic */ String zzEF() {
        return super.zzEF();
    }

    public /* bridge */ /* synthetic */ Set zzEG() {
        return super.zzEG();
    }

    public boolean zzEa() {
        return false;
    }

    public zza zzI(Map<String, zza> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzdf.zzFJ();
        }
        String language = locale.getLanguage();
        return language == null ? zzdf.zzFJ() : zzdf.zzR(language.toLowerCase());
    }
}
