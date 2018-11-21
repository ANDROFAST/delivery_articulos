package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzha
public class zzdv implements Iterable<zzdu> {
    private final List<zzdu> zzzm = new LinkedList();

    private zzdu zzc(zzjn com_google_android_gms_internal_zzjn) {
        Iterator it = zzp.zzbL().iterator();
        while (it.hasNext()) {
            zzdu com_google_android_gms_internal_zzdu = (zzdu) it.next();
            if (com_google_android_gms_internal_zzdu.zzps == com_google_android_gms_internal_zzjn) {
                return com_google_android_gms_internal_zzdu;
            }
        }
        return null;
    }

    public Iterator<zzdu> iterator() {
        return this.zzzm.iterator();
    }

    public void zza(zzdu com_google_android_gms_internal_zzdu) {
        this.zzzm.add(com_google_android_gms_internal_zzdu);
    }

    public boolean zza(zzjn com_google_android_gms_internal_zzjn) {
        zzdu zzc = zzc(com_google_android_gms_internal_zzjn);
        if (zzc == null) {
            return false;
        }
        zzc.zzzj.abort();
        return true;
    }

    public void zzb(zzdu com_google_android_gms_internal_zzdu) {
        this.zzzm.remove(com_google_android_gms_internal_zzdu);
    }

    public boolean zzb(zzjn com_google_android_gms_internal_zzjn) {
        return zzc(com_google_android_gms_internal_zzjn) != null;
    }
}
