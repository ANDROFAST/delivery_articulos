package com.google.ads.afma.nano;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzti;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.internal.zztn;
import java.io.IOException;

public interface NanoAdshieldEvent {

    public static final class AdShieldEvent extends zztk {
        private static volatile AdShieldEvent[] zzaK;
        public String appId;

        public AdShieldEvent() {
            clear();
        }

        public static AdShieldEvent[] emptyArray() {
            if (zzaK == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaK == null) {
                        zzaK = new AdShieldEvent[0];
                    }
                }
            }
            return zzaK;
        }

        public static AdShieldEvent parseFrom(zztc input) throws IOException {
            return new AdShieldEvent().mergeFrom(input);
        }

        public static AdShieldEvent parseFrom(byte[] data) throws zztj {
            return (AdShieldEvent) zztk.mergeFrom(new AdShieldEvent(), data);
        }

        public AdShieldEvent clear() {
            this.appId = "";
            this.zzbqb = -1;
            return this;
        }

        public AdShieldEvent mergeFrom(zztc input) throws IOException {
            while (true) {
                int zzHi = input.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.appId = input.readString();
                        continue;
                    default:
                        if (!zztn.zzb(input, zzHi)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void writeTo(zztd output) throws IOException {
            if (!this.appId.equals("")) {
                output.zzb(1, this.appId);
            }
            super.writeTo(output);
        }

        protected int zzz() {
            int zzz = super.zzz();
            return !this.appId.equals("") ? zzz + zztd.zzp(1, this.appId) : zzz;
        }
    }
}
