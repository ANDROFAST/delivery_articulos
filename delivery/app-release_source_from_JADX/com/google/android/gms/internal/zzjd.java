package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzha
public class zzjd {

    public interface zza<D, R> {
        R zze(D d);
    }

    public static <A, B> zzje<B> zza(final zzje<A> com_google_android_gms_internal_zzje_A, final zza<A, B> com_google_android_gms_internal_zzjd_zza_A__B) {
        final zzje com_google_android_gms_internal_zzjb = new zzjb();
        com_google_android_gms_internal_zzje_A.zzb(new Runnable() {
            public void run() {
                try {
                    com_google_android_gms_internal_zzjb.zzf(com_google_android_gms_internal_zzjd_zza_A__B.zze(com_google_android_gms_internal_zzje_A.get()));
                    return;
                } catch (CancellationException e) {
                } catch (InterruptedException e2) {
                } catch (ExecutionException e3) {
                }
                com_google_android_gms_internal_zzjb.cancel(true);
            }
        });
        return com_google_android_gms_internal_zzjb;
    }

    public static <V> zzje<List<V>> zzj(final List<zzje<V>> list) {
        final zzje com_google_android_gms_internal_zzjb = new zzjb();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzje zzb : list) {
            zzb.zzb(new Runnable() {
                public void run() {
                    Throwable e;
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            com_google_android_gms_internal_zzjb.zzf(zzjd.zzk(list));
                            return;
                        } catch (ExecutionException e2) {
                            e = e2;
                        } catch (InterruptedException e3) {
                            e = e3;
                        }
                    } else {
                        return;
                    }
                    zzb.zzd("Unable to convert list of futures to a future of list", e);
                }
            });
        }
        return com_google_android_gms_internal_zzjb;
    }

    private static <V> List<V> zzk(List<zzje<V>> list) throws ExecutionException, InterruptedException {
        List<V> arrayList = new ArrayList();
        for (zzje com_google_android_gms_internal_zzje : list) {
            Object obj = com_google_android_gms_internal_zzje.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
