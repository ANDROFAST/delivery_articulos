package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zzbdk = "gtm.lifetime".toString().split("\\.");
    private static final Pattern zzbdl = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzb, Integer> zzbdm;
    private final Map<String, Object> zzbdn;
    private final ReentrantLock zzbdo;
    private final LinkedList<Map<String, Object>> zzbdp;
    private final zzc zzbdq;
    private final CountDownLatch zzbdr;

    static final class zza {
        public final Object zzLI;
        public final String zzuX;

        zza(String str, Object obj) {
            this.zzuX = str;
            this.zzLI = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_tagmanager_DataLayer_zza = (zza) o;
            return this.zzuX.equals(com_google_android_gms_tagmanager_DataLayer_zza.zzuX) && this.zzLI.equals(com_google_android_gms_tagmanager_DataLayer_zza.zzLI);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zzuX.hashCode()), Integer.valueOf(this.zzLI.hashCode())});
        }

        public String toString() {
            return "Key: " + this.zzuX + " value: " + this.zzLI.toString();
        }
    }

    interface zzb {
        void zzJ(Map<String, Object> map);
    }

    interface zzc {

        public interface zza {
            void zzy(List<zza> list);
        }

        void zza(zza com_google_android_gms_tagmanager_DataLayer_zzc_zza);

        void zza(List<zza> list, long j);

        void zzfl(String str);
    }

    class C07811 implements zzc {
        C07811() {
        }

        public void zza(zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
            com_google_android_gms_tagmanager_DataLayer_zzc_zza.zzy(new ArrayList());
        }

        public void zza(List<zza> list, long j) {
        }

        public void zzfl(String str) {
        }
    }

    class C07822 implements zza {
        final /* synthetic */ DataLayer zzbds;

        C07822(DataLayer dataLayer) {
            this.zzbds = dataLayer;
        }

        public void zzy(List<zza> list) {
            for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
                this.zzbds.zzL(this.zzbds.zzn(com_google_android_gms_tagmanager_DataLayer_zza.zzuX, com_google_android_gms_tagmanager_DataLayer_zza.zzLI));
            }
            this.zzbds.zzbdr.countDown();
        }
    }

    DataLayer() {
        this(new C07811());
    }

    DataLayer(zzc persistentStore) {
        this.zzbdq = persistentStore;
        this.zzbdm = new ConcurrentHashMap();
        this.zzbdn = new HashMap();
        this.zzbdo = new ReentrantLock();
        this.zzbdp = new LinkedList();
        this.zzbdr = new CountDownLatch(1);
        zzEr();
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    private void zzEr() {
        this.zzbdq.zza(new C07822(this));
    }

    private void zzEs() {
        int i = 0;
        while (true) {
            Map map = (Map) this.zzbdp.poll();
            if (map != null) {
                zzQ(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    this.zzbdp.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    private void zzL(Map<String, Object> map) {
        this.zzbdo.lock();
        try {
            this.zzbdp.offer(map);
            if (this.zzbdo.getHoldCount() == 1) {
                zzEs();
            }
            zzM(map);
        } finally {
            this.zzbdo.unlock();
        }
    }

    private void zzM(Map<String, Object> map) {
        Long zzN = zzN(map);
        if (zzN != null) {
            List zzP = zzP(map);
            zzP.remove("gtm.lifetime");
            this.zzbdq.zza(zzP, zzN.longValue());
        }
    }

    private Long zzN(Map<String, Object> map) {
        Object zzO = zzO(map);
        return zzO == null ? null : zzfk(zzO.toString());
    }

    private Object zzO(Map<String, Object> map) {
        String[] strArr = zzbdk;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<zza> zzP(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        zza(map, "", arrayList);
        return arrayList;
    }

    private void zzQ(Map<String, Object> map) {
        synchronized (this.zzbdn) {
            for (String str : map.keySet()) {
                zzd(zzn(str, map.get(str)), this.zzbdn);
            }
        }
        zzR(map);
    }

    private void zzR(Map<String, Object> map) {
        for (zzb zzJ : this.zzbdm.keySet()) {
            zzJ.zzJ(map);
        }
    }

    private void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new zza(str2, entry.getValue()));
            }
        }
    }

    static Long zzfk(String str) {
        Matcher matcher = zzbdl.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                zzbg.zzaH("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                zzbg.zzaG("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    zzbg.zzaH("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        zzbg.zzaG("unknown _lifetime: " + str);
        return null;
    }

    public Object get(String key) {
        synchronized (this.zzbdn) {
            Map map = this.zzbdn;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(zzn(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.zzbdr.await();
        } catch (InterruptedException e) {
            zzbg.zzaH("DataLayer.push: unexpected InterruptedException");
        }
        zzL(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put("event", eventName);
        push(hashMap);
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.zzbdn) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.zzbdn.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    void zza(zzb com_google_android_gms_tagmanager_DataLayer_zzb) {
        this.zzbdm.put(com_google_android_gms_tagmanager_DataLayer_zzb, Integer.valueOf(0));
    }

    void zzb(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                zzb((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                zzd((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    void zzd(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zzd((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void zzfj(String str) {
        push(str, null);
        this.zzbdq.zzfl(str);
    }

    Map<String, Object> zzn(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }
}
