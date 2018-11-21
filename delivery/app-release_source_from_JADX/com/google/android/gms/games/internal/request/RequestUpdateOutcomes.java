package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] zzaGn = new String[]{"requestId", "outcome"};
    private final HashMap<String, Integer> zzaGo;
    private final int zzabx;

    public static final class Builder {
        private HashMap<String, Integer> zzaGo = new HashMap();
        private int zzabx = 0;

        public Builder zzgy(int i) {
            this.zzabx = i;
            return this;
        }

        public Builder zzx(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzaGo.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public RequestUpdateOutcomes zzxa() {
            return new RequestUpdateOutcomes(this.zzabx, this.zzaGo);
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.zzabx = statusCode;
        this.zzaGo = outcomeMap;
    }

    public static RequestUpdateOutcomes zzab(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zzgy(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int zzbI = dataHolder.zzbI(i);
            builder.zzx(dataHolder.zzd("requestId", i, zzbI), dataHolder.zzc("outcome", i, zzbI));
        }
        return builder.zzxa();
    }

    public Set<String> getRequestIds() {
        return this.zzaGo.keySet();
    }

    public int getRequestOutcome(String requestId) {
        zzx.zzb(this.zzaGo.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.zzaGo.get(requestId)).intValue();
    }
}
