package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsh.zze;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcp {
    private static final zzbw<com.google.android.gms.internal.zzag.zza> zzbfj = new zzbw(zzdf.zzFJ(), true);
    private final DataLayer zzbcG;
    private final com.google.android.gms.internal.zzsh.zzc zzbfk;
    private final zzah zzbfl;
    private final Map<String, zzak> zzbfm;
    private final Map<String, zzak> zzbfn;
    private final Map<String, zzak> zzbfo;
    private final zzl<com.google.android.gms.internal.zzsh.zza, zzbw<com.google.android.gms.internal.zzag.zza>> zzbfp;
    private final zzl<String, zzb> zzbfq;
    private final Set<zze> zzbfr;
    private final Map<String, zzc> zzbfs;
    private volatile String zzbft;
    private int zzbfu;

    interface zza {
        void zza(zze com_google_android_gms_internal_zzsh_zze, Set<com.google.android.gms.internal.zzsh.zza> set, Set<com.google.android.gms.internal.zzsh.zza> set2, zzck com_google_android_gms_tagmanager_zzck);
    }

    private static class zzb {
        private zzbw<com.google.android.gms.internal.zzag.zza> zzbfA;
        private com.google.android.gms.internal.zzag.zza zzbfB;

        public zzb(zzbw<com.google.android.gms.internal.zzag.zza> com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzbfA = com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza;
            this.zzbfB = com_google_android_gms_internal_zzag_zza;
        }

        public int getSize() {
            return (this.zzbfB == null ? 0 : this.zzbfB.getCachedSize()) + ((com.google.android.gms.internal.zzag.zza) this.zzbfA.getObject()).getCachedSize();
        }

        public zzbw<com.google.android.gms.internal.zzag.zza> zzFk() {
            return this.zzbfA;
        }

        public com.google.android.gms.internal.zzag.zza zzFl() {
            return this.zzbfB;
        }
    }

    private static class zzc {
        private final Map<zze, List<com.google.android.gms.internal.zzsh.zza>> zzbfC = new HashMap();
        private final Map<zze, List<com.google.android.gms.internal.zzsh.zza>> zzbfD = new HashMap();
        private final Map<zze, List<String>> zzbfE = new HashMap();
        private final Map<zze, List<String>> zzbfF = new HashMap();
        private com.google.android.gms.internal.zzsh.zza zzbfG;
        private final Set<zze> zzbfr = new HashSet();

        public Set<zze> zzFm() {
            return this.zzbfr;
        }

        public Map<zze, List<com.google.android.gms.internal.zzsh.zza>> zzFn() {
            return this.zzbfC;
        }

        public Map<zze, List<String>> zzFo() {
            return this.zzbfE;
        }

        public Map<zze, List<String>> zzFp() {
            return this.zzbfF;
        }

        public Map<zze, List<com.google.android.gms.internal.zzsh.zza>> zzFq() {
            return this.zzbfD;
        }

        public com.google.android.gms.internal.zzsh.zza zzFr() {
            return this.zzbfG;
        }

        public void zza(zze com_google_android_gms_internal_zzsh_zze) {
            this.zzbfr.add(com_google_android_gms_internal_zzsh_zze);
        }

        public void zza(zze com_google_android_gms_internal_zzsh_zze, com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza) {
            List list = (List) this.zzbfC.get(com_google_android_gms_internal_zzsh_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbfC.put(com_google_android_gms_internal_zzsh_zze, list);
            }
            list.add(com_google_android_gms_internal_zzsh_zza);
        }

        public void zza(zze com_google_android_gms_internal_zzsh_zze, String str) {
            List list = (List) this.zzbfE.get(com_google_android_gms_internal_zzsh_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbfE.put(com_google_android_gms_internal_zzsh_zze, list);
            }
            list.add(str);
        }

        public void zzb(com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza) {
            this.zzbfG = com_google_android_gms_internal_zzsh_zza;
        }

        public void zzb(zze com_google_android_gms_internal_zzsh_zze, com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza) {
            List list = (List) this.zzbfD.get(com_google_android_gms_internal_zzsh_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbfD.put(com_google_android_gms_internal_zzsh_zze, list);
            }
            list.add(com_google_android_gms_internal_zzsh_zza);
        }

        public void zzb(zze com_google_android_gms_internal_zzsh_zze, String str) {
            List list = (List) this.zzbfF.get(com_google_android_gms_internal_zzsh_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzbfF.put(com_google_android_gms_internal_zzsh_zze, list);
            }
            list.add(str);
        }
    }

    class C07881 implements com.google.android.gms.tagmanager.zzm.zza<com.google.android.gms.internal.zzsh.zza, zzbw<com.google.android.gms.internal.zzag.zza>> {
        final /* synthetic */ zzcp zzbfv;

        C07881(zzcp com_google_android_gms_tagmanager_zzcp) {
            this.zzbfv = com_google_android_gms_tagmanager_zzcp;
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((com.google.android.gms.internal.zzsh.zza) x0, (zzbw) x1);
        }

        public int zza(com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza, zzbw<com.google.android.gms.internal.zzag.zza> com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza) {
            return ((com.google.android.gms.internal.zzag.zza) com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza.getObject()).getCachedSize();
        }
    }

    class C07892 implements com.google.android.gms.tagmanager.zzm.zza<String, zzb> {
        final /* synthetic */ zzcp zzbfv;

        C07892(zzcp com_google_android_gms_tagmanager_zzcp) {
            this.zzbfv = com_google_android_gms_tagmanager_zzcp;
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((String) x0, (zzb) x1);
        }

        public int zza(String str, zzb com_google_android_gms_tagmanager_zzcp_zzb) {
            return str.length() + com_google_android_gms_tagmanager_zzcp_zzb.getSize();
        }
    }

    class C07914 implements zza {
        final /* synthetic */ zzcp zzbfv;

        C07914(zzcp com_google_android_gms_tagmanager_zzcp) {
            this.zzbfv = com_google_android_gms_tagmanager_zzcp;
        }

        public void zza(zze com_google_android_gms_internal_zzsh_zze, Set<com.google.android.gms.internal.zzsh.zza> set, Set<com.google.android.gms.internal.zzsh.zza> set2, zzck com_google_android_gms_tagmanager_zzck) {
            set.addAll(com_google_android_gms_internal_zzsh_zze.zzFV());
            set2.addAll(com_google_android_gms_internal_zzsh_zze.zzFW());
            com_google_android_gms_tagmanager_zzck.zzEP().zzc(com_google_android_gms_internal_zzsh_zze.zzFV(), com_google_android_gms_internal_zzsh_zze.zzGa());
            com_google_android_gms_tagmanager_zzck.zzEQ().zzc(com_google_android_gms_internal_zzsh_zze.zzFW(), com_google_android_gms_internal_zzsh_zze.zzGb());
        }
    }

    public zzcp(Context context, com.google.android.gms.internal.zzsh.zzc com_google_android_gms_internal_zzsh_zzc, DataLayer dataLayer, com.google.android.gms.tagmanager.zzt.zza com_google_android_gms_tagmanager_zzt_zza, com.google.android.gms.tagmanager.zzt.zza com_google_android_gms_tagmanager_zzt_zza2, zzah com_google_android_gms_tagmanager_zzah) {
        if (com_google_android_gms_internal_zzsh_zzc == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzbfk = com_google_android_gms_internal_zzsh_zzc;
        this.zzbfr = new HashSet(com_google_android_gms_internal_zzsh_zzc.zzFP());
        this.zzbcG = dataLayer;
        this.zzbfl = com_google_android_gms_tagmanager_zzah;
        this.zzbfp = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C07881(this));
        this.zzbfq = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C07892(this));
        this.zzbfm = new HashMap();
        zzb(new zzj(context));
        zzb(new zzt(com_google_android_gms_tagmanager_zzt_zza2));
        zzb(new zzx(dataLayer));
        zzb(new zzdg(context, dataLayer));
        zzb(new zzdb(context, dataLayer));
        this.zzbfn = new HashMap();
        zzc(new zzr());
        zzc(new zzae());
        zzc(new zzaf());
        zzc(new zzam());
        zzc(new zzan());
        zzc(new zzbc());
        zzc(new zzbd());
        zzc(new zzcf());
        zzc(new zzcy());
        this.zzbfo = new HashMap();
        zza(new zzb(context));
        zza(new zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzi(context));
        zza(new zzn());
        zza(new zzq(this.zzbfk.getVersion()));
        zza(new zzt(com_google_android_gms_tagmanager_zzt_zza));
        zza(new zzv(dataLayer));
        zza(new zzaa(context));
        zza(new zzab());
        zza(new zzad());
        zza(new zzai(this));
        zza(new zzao());
        zza(new zzap());
        zza(new zzaw(context));
        zza(new zzay());
        zza(new zzbb());
        zza(new zzbi());
        zza(new zzbk(context));
        zza(new zzbx());
        zza(new zzbz());
        zza(new zzcc());
        zza(new zzce());
        zza(new zzcg(context));
        zza(new zzcq());
        zza(new zzcr());
        zza(new zzda());
        zza(new zzdh());
        this.zzbfs = new HashMap();
        for (zze com_google_android_gms_internal_zzsh_zze : this.zzbfr) {
            if (com_google_android_gms_tagmanager_zzah.zzEE()) {
                zza(com_google_android_gms_internal_zzsh_zze.zzFX(), com_google_android_gms_internal_zzsh_zze.zzFY(), "add macro");
                zza(com_google_android_gms_internal_zzsh_zze.zzGc(), com_google_android_gms_internal_zzsh_zze.zzFZ(), "remove macro");
                zza(com_google_android_gms_internal_zzsh_zze.zzFV(), com_google_android_gms_internal_zzsh_zze.zzGa(), "add tag");
                zza(com_google_android_gms_internal_zzsh_zze.zzFW(), com_google_android_gms_internal_zzsh_zze.zzGb(), "remove tag");
            }
            int i = 0;
            while (i < com_google_android_gms_internal_zzsh_zze.zzFX().size()) {
                com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza = (com.google.android.gms.internal.zzsh.zza) com_google_android_gms_internal_zzsh_zze.zzFX().get(i);
                String str = "Unknown";
                if (com_google_android_gms_tagmanager_zzah.zzEE() && i < com_google_android_gms_internal_zzsh_zze.zzFY().size()) {
                    str = (String) com_google_android_gms_internal_zzsh_zze.zzFY().get(i);
                }
                zzc zzi = zzi(this.zzbfs, zza(com_google_android_gms_internal_zzsh_zza));
                zzi.zza(com_google_android_gms_internal_zzsh_zze);
                zzi.zza(com_google_android_gms_internal_zzsh_zze, com_google_android_gms_internal_zzsh_zza);
                zzi.zza(com_google_android_gms_internal_zzsh_zze, str);
                i++;
            }
            i = 0;
            while (i < com_google_android_gms_internal_zzsh_zze.zzGc().size()) {
                com_google_android_gms_internal_zzsh_zza = (com.google.android.gms.internal.zzsh.zza) com_google_android_gms_internal_zzsh_zze.zzGc().get(i);
                str = "Unknown";
                if (com_google_android_gms_tagmanager_zzah.zzEE() && i < com_google_android_gms_internal_zzsh_zze.zzFZ().size()) {
                    str = (String) com_google_android_gms_internal_zzsh_zze.zzFZ().get(i);
                }
                zzi = zzi(this.zzbfs, zza(com_google_android_gms_internal_zzsh_zza));
                zzi.zza(com_google_android_gms_internal_zzsh_zze);
                zzi.zzb(com_google_android_gms_internal_zzsh_zze, com_google_android_gms_internal_zzsh_zza);
                zzi.zzb(com_google_android_gms_internal_zzsh_zze, str);
                i++;
            }
        }
        for (Entry entry : this.zzbfk.zzFQ().entrySet()) {
            for (com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza2 : (List) entry.getValue()) {
                if (!zzdf.zzk((com.google.android.gms.internal.zzag.zza) com_google_android_gms_internal_zzsh_zza2.zzFM().get(zzae.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzi(this.zzbfs, (String) entry.getKey()).zzb(com_google_android_gms_internal_zzsh_zza2);
                }
            }
        }
    }

    private String zzFj() {
        if (this.zzbfu <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.zzbfu));
        for (int i = 2; i < this.zzbfu; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza, Set<String> set, zzdi com_google_android_gms_tagmanager_zzdi) {
        if (!com_google_android_gms_internal_zzag_zza.zzjy) {
            return new zzbw(com_google_android_gms_internal_zzag_zza, true);
        }
        com.google.android.gms.internal.zzag.zza zzo;
        int i;
        zzbw zza;
        switch (com_google_android_gms_internal_zzag_zza.type) {
            case 2:
                zzo = zzsh.zzo(com_google_android_gms_internal_zzag_zza);
                zzo.zzjp = new com.google.android.gms.internal.zzag.zza[com_google_android_gms_internal_zzag_zza.zzjp.length];
                for (i = 0; i < com_google_android_gms_internal_zzag_zza.zzjp.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzag_zza.zzjp[i], (Set) set, com_google_android_gms_tagmanager_zzdi.zzjQ(i));
                    if (zza == zzbfj) {
                        return zzbfj;
                    }
                    zzo.zzjp[i] = (com.google.android.gms.internal.zzag.zza) zza.getObject();
                }
                return new zzbw(zzo, false);
            case 3:
                zzo = zzsh.zzo(com_google_android_gms_internal_zzag_zza);
                if (com_google_android_gms_internal_zzag_zza.zzjq.length != com_google_android_gms_internal_zzag_zza.zzjr.length) {
                    zzbg.m9e("Invalid serving value: " + com_google_android_gms_internal_zzag_zza.toString());
                    return zzbfj;
                }
                zzo.zzjq = new com.google.android.gms.internal.zzag.zza[com_google_android_gms_internal_zzag_zza.zzjq.length];
                zzo.zzjr = new com.google.android.gms.internal.zzag.zza[com_google_android_gms_internal_zzag_zza.zzjq.length];
                for (i = 0; i < com_google_android_gms_internal_zzag_zza.zzjq.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzag_zza.zzjq[i], (Set) set, com_google_android_gms_tagmanager_zzdi.zzjR(i));
                    zzbw zza2 = zza(com_google_android_gms_internal_zzag_zza.zzjr[i], (Set) set, com_google_android_gms_tagmanager_zzdi.zzjS(i));
                    if (zza == zzbfj || zza2 == zzbfj) {
                        return zzbfj;
                    }
                    zzo.zzjq[i] = (com.google.android.gms.internal.zzag.zza) zza.getObject();
                    zzo.zzjr[i] = (com.google.android.gms.internal.zzag.zza) zza2.getObject();
                }
                return new zzbw(zzo, false);
            case 4:
                if (set.contains(com_google_android_gms_internal_zzag_zza.zzjs)) {
                    zzbg.m9e("Macro cycle detected.  Current macro reference: " + com_google_android_gms_internal_zzag_zza.zzjs + "." + "  Previous macro references: " + set.toString() + ".");
                    return zzbfj;
                }
                set.add(com_google_android_gms_internal_zzag_zza.zzjs);
                zzbw<com.google.android.gms.internal.zzag.zza> zza3 = zzdj.zza(zza(com_google_android_gms_internal_zzag_zza.zzjs, (Set) set, com_google_android_gms_tagmanager_zzdi.zzES()), com_google_android_gms_internal_zzag_zza.zzjx);
                set.remove(com_google_android_gms_internal_zzag_zza.zzjs);
                return zza3;
            case 7:
                zzo = zzsh.zzo(com_google_android_gms_internal_zzag_zza);
                zzo.zzjw = new com.google.android.gms.internal.zzag.zza[com_google_android_gms_internal_zzag_zza.zzjw.length];
                for (i = 0; i < com_google_android_gms_internal_zzag_zza.zzjw.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzag_zza.zzjw[i], (Set) set, com_google_android_gms_tagmanager_zzdi.zzjT(i));
                    if (zza == zzbfj) {
                        return zzbfj;
                    }
                    zzo.zzjw[i] = (com.google.android.gms.internal.zzag.zza) zza.getObject();
                }
                return new zzbw(zzo, false);
            default:
                zzbg.m9e("Unknown type: " + com_google_android_gms_internal_zzag_zza.type);
                return zzbfj;
        }
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(String str, Set<String> set, zzbj com_google_android_gms_tagmanager_zzbj) {
        this.zzbfu++;
        zzb com_google_android_gms_tagmanager_zzcp_zzb = (zzb) this.zzbfq.get(str);
        if (com_google_android_gms_tagmanager_zzcp_zzb == null || this.zzbfl.zzEE()) {
            zzc com_google_android_gms_tagmanager_zzcp_zzc = (zzc) this.zzbfs.get(str);
            if (com_google_android_gms_tagmanager_zzcp_zzc == null) {
                zzbg.m9e(zzFj() + "Invalid macro: " + str);
                this.zzbfu--;
                return zzbfj;
            }
            com.google.android.gms.internal.zzsh.zza zzFr;
            zzbw zza = zza(str, com_google_android_gms_tagmanager_zzcp_zzc.zzFm(), com_google_android_gms_tagmanager_zzcp_zzc.zzFn(), com_google_android_gms_tagmanager_zzcp_zzc.zzFo(), com_google_android_gms_tagmanager_zzcp_zzc.zzFq(), com_google_android_gms_tagmanager_zzcp_zzc.zzFp(), set, com_google_android_gms_tagmanager_zzbj.zzEu());
            if (((Set) zza.getObject()).isEmpty()) {
                zzFr = com_google_android_gms_tagmanager_zzcp_zzc.zzFr();
            } else {
                if (((Set) zza.getObject()).size() > 1) {
                    zzbg.zzaH(zzFj() + "Multiple macros active for macroName " + str);
                }
                zzFr = (com.google.android.gms.internal.zzsh.zza) ((Set) zza.getObject()).iterator().next();
            }
            if (zzFr == null) {
                this.zzbfu--;
                return zzbfj;
            }
            zzbw zza2 = zza(this.zzbfo, zzFr, (Set) set, com_google_android_gms_tagmanager_zzbj.zzEK());
            boolean z = zza.zzET() && zza2.zzET();
            zzbw<com.google.android.gms.internal.zzag.zza> com_google_android_gms_tagmanager_zzbw = zza2 == zzbfj ? zzbfj : new zzbw(zza2.getObject(), z);
            com.google.android.gms.internal.zzag.zza zzFl = zzFr.zzFl();
            if (com_google_android_gms_tagmanager_zzbw.zzET()) {
                this.zzbfq.zzh(str, new zzb(com_google_android_gms_tagmanager_zzbw, zzFl));
            }
            zza(zzFl, (Set) set);
            this.zzbfu--;
            return com_google_android_gms_tagmanager_zzbw;
        }
        zza(com_google_android_gms_tagmanager_zzcp_zzb.zzFl(), (Set) set);
        this.zzbfu--;
        return com_google_android_gms_tagmanager_zzcp_zzb.zzFk();
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(Map<String, zzak> map, com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza, Set<String> set, zzch com_google_android_gms_tagmanager_zzch) {
        boolean z = true;
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) com_google_android_gms_internal_zzsh_zza.zzFM().get(zzae.FUNCTION.toString());
        if (com_google_android_gms_internal_zzag_zza == null) {
            zzbg.m9e("No function id in properties");
            return zzbfj;
        }
        String str = com_google_android_gms_internal_zzag_zza.zzjt;
        zzak com_google_android_gms_tagmanager_zzak = (zzak) map.get(str);
        if (com_google_android_gms_tagmanager_zzak == null) {
            zzbg.m9e(str + " has no backing implementation.");
            return zzbfj;
        }
        zzbw<com.google.android.gms.internal.zzag.zza> com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza = (zzbw) this.zzbfp.get(com_google_android_gms_internal_zzsh_zza);
        if (com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza != null && !this.zzbfl.zzEE()) {
            return com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : com_google_android_gms_internal_zzsh_zza.zzFM().entrySet()) {
            zzbw zza = zza((com.google.android.gms.internal.zzag.zza) entry.getValue(), (Set) set, com_google_android_gms_tagmanager_zzch.zzfv((String) entry.getKey()).zze((com.google.android.gms.internal.zzag.zza) entry.getValue()));
            if (zza == zzbfj) {
                return zzbfj;
            }
            boolean z3;
            if (zza.zzET()) {
                com_google_android_gms_internal_zzsh_zza.zza((String) entry.getKey(), (com.google.android.gms.internal.zzag.zza) zza.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), zza.getObject());
            z2 = z3;
        }
        if (com_google_android_gms_tagmanager_zzak.zzf(hashMap.keySet())) {
            if (!(z2 && com_google_android_gms_tagmanager_zzak.zzEa())) {
                z = false;
            }
            com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza = new zzbw(com_google_android_gms_tagmanager_zzak.zzI(hashMap), z);
            if (z) {
                this.zzbfp.zzh(com_google_android_gms_internal_zzsh_zza, com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza);
            }
            com_google_android_gms_tagmanager_zzch.zzd((com.google.android.gms.internal.zzag.zza) com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza.getObject());
            return com_google_android_gms_tagmanager_zzbw_com_google_android_gms_internal_zzag_zza;
        }
        zzbg.m9e("Incorrect keys for function " + str + " required " + com_google_android_gms_tagmanager_zzak.zzEG() + " had " + hashMap.keySet());
        return zzbfj;
    }

    private zzbw<Set<com.google.android.gms.internal.zzsh.zza>> zza(Set<zze> set, Set<String> set2, zza com_google_android_gms_tagmanager_zzcp_zza, zzco com_google_android_gms_tagmanager_zzco) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (zze com_google_android_gms_internal_zzsh_zze : set) {
            zzck zzER = com_google_android_gms_tagmanager_zzco.zzER();
            zzbw zza = zza(com_google_android_gms_internal_zzsh_zze, (Set) set2, zzER);
            if (((Boolean) zza.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzcp_zza.zza(com_google_android_gms_internal_zzsh_zze, hashSet, hashSet2, zzER);
            }
            boolean z2 = z && zza.zzET();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        com_google_android_gms_tagmanager_zzco.zzg(hashSet);
        return new zzbw(hashSet, z);
    }

    private static String zza(com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza) {
        return zzdf.zzg((com.google.android.gms.internal.zzag.zza) com_google_android_gms_internal_zzsh_zza.zzFM().get(zzae.INSTANCE_NAME.toString()));
    }

    private void zza(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza, Set<String> set) {
        if (com_google_android_gms_internal_zzag_zza != null) {
            zzbw zza = zza(com_google_android_gms_internal_zzag_zza, (Set) set, new zzbu());
            if (zza != zzbfj) {
                Object zzl = zzdf.zzl((com.google.android.gms.internal.zzag.zza) zza.getObject());
                if (zzl instanceof Map) {
                    this.zzbcG.push((Map) zzl);
                } else if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            this.zzbcG.push((Map) zzl2);
                        } else {
                            zzbg.zzaH("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzbg.zzaH("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void zza(List<com.google.android.gms.internal.zzsh.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbg.zzaG("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzak> map, zzak com_google_android_gms_tagmanager_zzak) {
        if (map.containsKey(com_google_android_gms_tagmanager_zzak.zzEF())) {
            throw new IllegalArgumentException("Duplicate function type name: " + com_google_android_gms_tagmanager_zzak.zzEF());
        }
        map.put(com_google_android_gms_tagmanager_zzak.zzEF(), com_google_android_gms_tagmanager_zzak);
    }

    private static zzc zzi(Map<String, zzc> map, String str) {
        zzc com_google_android_gms_tagmanager_zzcp_zzc = (zzc) map.get(str);
        if (com_google_android_gms_tagmanager_zzcp_zzc != null) {
            return com_google_android_gms_tagmanager_zzcp_zzc;
        }
        com_google_android_gms_tagmanager_zzcp_zzc = new zzc();
        map.put(str, com_google_android_gms_tagmanager_zzcp_zzc);
        return com_google_android_gms_tagmanager_zzcp_zzc;
    }

    public synchronized void zzC(List<zzi> list) {
        for (zzi com_google_android_gms_internal_zzaf_zzi : list) {
            if (com_google_android_gms_internal_zzaf_zzi.name == null || !com_google_android_gms_internal_zzaf_zzi.name.startsWith("gaExperiment:")) {
                zzbg.m10v("Ignored supplemental: " + com_google_android_gms_internal_zzaf_zzi);
            } else {
                zzaj.zza(this.zzbcG, com_google_android_gms_internal_zzaf_zzi);
            }
        }
    }

    synchronized String zzFi() {
        return this.zzbft;
    }

    zzbw<Boolean> zza(com.google.android.gms.internal.zzsh.zza com_google_android_gms_internal_zzsh_zza, Set<String> set, zzch com_google_android_gms_tagmanager_zzch) {
        zzbw zza = zza(this.zzbfn, com_google_android_gms_internal_zzsh_zza, (Set) set, com_google_android_gms_tagmanager_zzch);
        Boolean zzk = zzdf.zzk((com.google.android.gms.internal.zzag.zza) zza.getObject());
        com_google_android_gms_tagmanager_zzch.zzd(zzdf.zzR(zzk));
        return new zzbw(zzk, zza.zzET());
    }

    zzbw<Boolean> zza(zze com_google_android_gms_internal_zzsh_zze, Set<String> set, zzck com_google_android_gms_tagmanager_zzck) {
        boolean z = true;
        for (com.google.android.gms.internal.zzsh.zza zza : com_google_android_gms_internal_zzsh_zze.zzFU()) {
            zzbw zza2 = zza(zza, (Set) set, com_google_android_gms_tagmanager_zzck.zzEL());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzck.zzf(zzdf.zzR(Boolean.valueOf(false)));
                return new zzbw(Boolean.valueOf(false), zza2.zzET());
            }
            boolean z2 = z && zza2.zzET();
            z = z2;
        }
        for (com.google.android.gms.internal.zzsh.zza zza3 : com_google_android_gms_internal_zzsh_zze.zzFT()) {
            zza2 = zza(zza3, (Set) set, com_google_android_gms_tagmanager_zzck.zzEM());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                z = z && zza2.zzET();
            } else {
                com_google_android_gms_tagmanager_zzck.zzf(zzdf.zzR(Boolean.valueOf(false)));
                return new zzbw(Boolean.valueOf(false), zza2.zzET());
            }
        }
        com_google_android_gms_tagmanager_zzck.zzf(zzdf.zzR(Boolean.valueOf(true)));
        return new zzbw(Boolean.valueOf(true), z);
    }

    zzbw<Set<com.google.android.gms.internal.zzsh.zza>> zza(String str, Set<zze> set, Map<zze, List<com.google.android.gms.internal.zzsh.zza>> map, Map<zze, List<String>> map2, Map<zze, List<com.google.android.gms.internal.zzsh.zza>> map3, Map<zze, List<String>> map4, Set<String> set2, zzco com_google_android_gms_tagmanager_zzco) {
        final Map<zze, List<com.google.android.gms.internal.zzsh.zza>> map5 = map;
        final Map<zze, List<String>> map6 = map2;
        final Map<zze, List<com.google.android.gms.internal.zzsh.zza>> map7 = map3;
        final Map<zze, List<String>> map8 = map4;
        return zza((Set) set, (Set) set2, new zza(this) {
            final /* synthetic */ zzcp zzbfv;

            public void zza(zze com_google_android_gms_internal_zzsh_zze, Set<com.google.android.gms.internal.zzsh.zza> set, Set<com.google.android.gms.internal.zzsh.zza> set2, zzck com_google_android_gms_tagmanager_zzck) {
                List list = (List) map5.get(com_google_android_gms_internal_zzsh_zze);
                List list2 = (List) map6.get(com_google_android_gms_internal_zzsh_zze);
                if (list != null) {
                    set.addAll(list);
                    com_google_android_gms_tagmanager_zzck.zzEN().zzc(list, list2);
                }
                list = (List) map7.get(com_google_android_gms_internal_zzsh_zze);
                list2 = (List) map8.get(com_google_android_gms_internal_zzsh_zze);
                if (list != null) {
                    set2.addAll(list);
                    com_google_android_gms_tagmanager_zzck.zzEO().zzc(list, list2);
                }
            }
        }, com_google_android_gms_tagmanager_zzco);
    }

    zzbw<Set<com.google.android.gms.internal.zzsh.zza>> zza(Set<zze> set, zzco com_google_android_gms_tagmanager_zzco) {
        return zza((Set) set, new HashSet(), new C07914(this), com_google_android_gms_tagmanager_zzco);
    }

    void zza(zzak com_google_android_gms_tagmanager_zzak) {
        zza(this.zzbfo, com_google_android_gms_tagmanager_zzak);
    }

    void zzb(zzak com_google_android_gms_tagmanager_zzak) {
        zza(this.zzbfm, com_google_android_gms_tagmanager_zzak);
    }

    void zzc(zzak com_google_android_gms_tagmanager_zzak) {
        zza(this.zzbfn, com_google_android_gms_tagmanager_zzak);
    }

    synchronized void zzfA(String str) {
        this.zzbft = str;
    }

    public synchronized void zzfd(String str) {
        zzfA(str);
        zzag zzfq = this.zzbfl.zzfq(str);
        zzu zzEC = zzfq.zzEC();
        for (com.google.android.gms.internal.zzsh.zza zza : (Set) zza(this.zzbfr, zzEC.zzEu()).getObject()) {
            zza(this.zzbfm, zza, new HashSet(), zzEC.zzEt());
        }
        zzfq.zzED();
        zzfA(null);
    }

    public zzbw<com.google.android.gms.internal.zzag.zza> zzfz(String str) {
        this.zzbfu = 0;
        zzag zzfp = this.zzbfl.zzfp(str);
        zzbw<com.google.android.gms.internal.zzag.zza> zza = zza(str, new HashSet(), zzfp.zzEB());
        zzfp.zzED();
        return zza;
    }
}
