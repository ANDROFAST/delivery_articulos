package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zztf<M extends zzte<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbpR;
    protected final boolean zzbpS;

    private zztf(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbpR = cls;
        this.tag = i2;
        this.zzbpS = z;
    }

    private T zzH(List<zztm> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            zztm com_google_android_gms_internal_zztm = (zztm) list.get(i);
            if (com_google_android_gms_internal_zztm.zzbqc.length != 0) {
                zza(com_google_android_gms_internal_zztm, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.zzbpR.cast(Array.newInstance(this.zzbpR.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T zzI(List<zztm> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbpR.cast(zzE(zztc.zzC(((zztm) list.get(list.size() - 1)).zzbqc)));
    }

    public static <M extends zzte<M>, T extends zztk> zztf<M, T> zza(int i, Class<T> cls, long j) {
        return new zztf(i, cls, (int) j, false);
    }

    protected Object zzE(zztc com_google_android_gms_internal_zztc) {
        Class componentType = this.zzbpS ? this.zzbpR.getComponentType() : this.zzbpR;
        try {
            zztk com_google_android_gms_internal_zztk;
            switch (this.type) {
                case 10:
                    com_google_android_gms_internal_zztk = (zztk) componentType.newInstance();
                    com_google_android_gms_internal_zztc.zza(com_google_android_gms_internal_zztk, zztn.zzmG(this.tag));
                    return com_google_android_gms_internal_zztk;
                case 11:
                    com_google_android_gms_internal_zztk = (zztk) componentType.newInstance();
                    com_google_android_gms_internal_zztc.zza(com_google_android_gms_internal_zztk);
                    return com_google_android_gms_internal_zztk;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    final T zzG(List<zztm> list) {
        return list == null ? null : this.zzbpS ? zzH(list) : zzI(list);
    }

    int zzY(Object obj) {
        return this.zzbpS ? zzZ(obj) : zzaa(obj);
    }

    protected int zzZ(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzaa(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void zza(zztm com_google_android_gms_internal_zztm, List<Object> list) {
        list.add(zzE(zztc.zzC(com_google_android_gms_internal_zztm.zzbqc)));
    }

    void zza(Object obj, zztd com_google_android_gms_internal_zztd) throws IOException {
        if (this.zzbpS) {
            zzc(obj, com_google_android_gms_internal_zztd);
        } else {
            zzb(obj, com_google_android_gms_internal_zztd);
        }
    }

    protected int zzaa(Object obj) {
        int zzmG = zztn.zzmG(this.tag);
        switch (this.type) {
            case 10:
                return zztd.zzb(zzmG, (zztk) obj);
            case 11:
                return zztd.zzc(zzmG, (zztk) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zzb(Object obj, zztd com_google_android_gms_internal_zztd) {
        try {
            com_google_android_gms_internal_zztd.zzmy(this.tag);
            switch (this.type) {
                case 10:
                    zztk com_google_android_gms_internal_zztk = (zztk) obj;
                    int zzmG = zztn.zzmG(this.tag);
                    com_google_android_gms_internal_zztd.zzb(com_google_android_gms_internal_zztk);
                    com_google_android_gms_internal_zztd.zzK(zzmG, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_zztd.zzc((zztk) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void zzc(Object obj, zztd com_google_android_gms_internal_zztd) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, com_google_android_gms_internal_zztd);
            }
        }
    }
}
