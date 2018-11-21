package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzakP;
    private final HashMap<Integer, String> zzakQ;
    private final ArrayList<Entry> zzakR;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzakS;
        final int zzakT;

        Entry(int versionCode, String stringValue, int intValue) {
            this.versionCode = versionCode;
            this.zzakS = stringValue;
            this.zzakT = intValue;
        }

        Entry(String stringValue, int intValue) {
            this.versionCode = 1;
            this.zzakS = stringValue;
            this.zzakT = intValue;
        }

        public int describeContents() {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            zzc.zza(this, out, flags);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzakP = new HashMap();
        this.zzakQ = new HashMap();
        this.zzakR = null;
    }

    StringToIntConverter(int versionCode, ArrayList<Entry> serializedMap) {
        this.mVersionCode = versionCode;
        this.zzakP = new HashMap();
        this.zzakQ = new HashMap();
        this.zzakR = null;
        zzd(serializedMap);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzh(entry.zzakS, entry.zzakT);
        }
    }

    public /* synthetic */ Object convertBack(Object x0) {
        return zzb((Integer) x0);
    }

    public int describeContents() {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public String zzb(Integer num) {
        String str = (String) this.zzakQ.get(num);
        return (str == null && this.zzakP.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzh(String str, int i) {
        this.zzakP.put(str, Integer.valueOf(i));
        this.zzakQ.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<Entry> zzqS() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.zzakP.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.zzakP.get(str)).intValue()));
        }
        return arrayList;
    }

    public int zzqT() {
        return 7;
    }

    public int zzqU() {
        return 0;
    }
}
