package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzu extends zzc {
    private final String TAG = "SafeDataBufferRef";

    public zzu(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    protected String zzI(String str, String str2) {
        return (!zzct(str) || zzcv(str)) ? str2 : getString(str);
    }

    protected <E extends SafeParcelable> E zza(String str, Creator<E> creator) {
        byte[] zzc = zzc(str, null);
        return zzc == null ? null : com.google.android.gms.common.internal.safeparcel.zzc.zza(zzc, creator);
    }

    protected <E extends SafeParcelable> List<E> zza(String str, Creator<E> creator, List<E> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzta zzA = zzta.zzA(zzc);
            if (zzA.zzbpC == null) {
                return list;
            }
            List<E> arrayList = new ArrayList(zzA.zzbpC.length);
            for (byte[] zza : zzA.zzbpC) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(zza, creator));
            }
            return arrayList;
        } catch (Throwable e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected List<Integer> zza(String str, List<Integer> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzta zzA = zzta.zzA(zzc);
            if (zzA.zzbpB == null) {
                return list;
            }
            List<Integer> arrayList = new ArrayList(zzA.zzbpB.length);
            for (int valueOf : zzA.zzbpB) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList;
        } catch (Throwable e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected float zzb(String str, float f) {
        return (!zzct(str) || zzcv(str)) ? f : getFloat(str);
    }

    protected List<String> zzb(String str, List<String> list) {
        byte[] zzc = zzc(str, null);
        if (zzc != null) {
            try {
                zzta zzA = zzta.zzA(zzc);
                if (zzA.zzbpA != null) {
                    list = Arrays.asList(zzA.zzbpA);
                }
            } catch (Throwable e) {
                if (Log.isLoggable("SafeDataBufferRef", 6)) {
                    Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
                }
            }
        }
        return list;
    }

    protected byte[] zzc(String str, byte[] bArr) {
        return (!zzct(str) || zzcv(str)) ? bArr : getByteArray(str);
    }

    protected boolean zzh(String str, boolean z) {
        return (!zzct(str) || zzcv(str)) ? z : getBoolean(str);
    }

    protected int zzz(String str, int i) {
        return (!zzct(str) || zzcv(str)) ? i : getInteger(str);
    }
}