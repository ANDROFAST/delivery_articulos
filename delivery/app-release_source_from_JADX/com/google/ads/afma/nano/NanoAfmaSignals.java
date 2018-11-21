package com.google.ads.afma.nano;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzti;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.internal.zztn;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface NanoAfmaSignals {

    public static final class AFMASignals extends zztk {
        public static final int DEVICE_IDENTIFIER_ADVERTISER_ID = 3;
        public static final int DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED = 4;
        public static final int DEVICE_IDENTIFIER_ANDROID_AD_ID = 5;
        public static final int DEVICE_IDENTIFIER_APP_SPECIFIC_ID = 1;
        public static final int DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID = 6;
        public static final int DEVICE_IDENTIFIER_GLOBAL_ID = 2;
        public static final int DEVICE_IDENTIFIER_NO_ID = 0;
        private static volatile AFMASignals[] zzaL;
        public Long actSignal;
        public Long acxSignal;
        public Long acySignal;
        public Long aczSignal;
        public String afmaVersion;
        public Long attSignal;
        public Long atvSignal;
        public Long btlSignal;
        public Long btsSignal;
        public String cerSignal;
        public Boolean didOptOut;
        public String didSignal;
        public String didSignalAndroidAdId;
        public Integer didSignalType;
        public Long evtTime;
        public String intSignal;
        public Long jbkSignal;
        public Long netSignal;
        public Long ornSignal;
        public String osVersion;
        public Long psnSignal;
        public Long reqType;
        public String stkSignal;
        public Long swzSignal;
        public Long tctSignal;
        public Long tcxSignal;
        public Long tcySignal;
        public Long uhSignal;
        public Long uptSignal;
        public Long usgSignal;
        public Long utzSignal;
        public Long uwSignal;
        public Long vcdSignal;
        public Long visSignal;
        public String vnmSignal;

        public AFMASignals() {
            clear();
        }

        public static AFMASignals[] emptyArray() {
            if (zzaL == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaL == null) {
                        zzaL = new AFMASignals[0];
                    }
                }
            }
            return zzaL;
        }

        public static AFMASignals parseFrom(zztc input) throws IOException {
            return new AFMASignals().mergeFrom(input);
        }

        public static AFMASignals parseFrom(byte[] data) throws zztj {
            return (AFMASignals) zztk.mergeFrom(new AFMASignals(), data);
        }

        public AFMASignals clear() {
            this.osVersion = null;
            this.afmaVersion = null;
            this.atvSignal = null;
            this.attSignal = null;
            this.btsSignal = null;
            this.btlSignal = null;
            this.acxSignal = null;
            this.acySignal = null;
            this.aczSignal = null;
            this.actSignal = null;
            this.netSignal = null;
            this.ornSignal = null;
            this.stkSignal = null;
            this.tcxSignal = null;
            this.tcySignal = null;
            this.tctSignal = null;
            this.uptSignal = null;
            this.visSignal = null;
            this.swzSignal = null;
            this.psnSignal = null;
            this.jbkSignal = null;
            this.usgSignal = null;
            this.intSignal = null;
            this.cerSignal = null;
            this.uwSignal = null;
            this.uhSignal = null;
            this.utzSignal = null;
            this.vnmSignal = null;
            this.vcdSignal = null;
            this.reqType = null;
            this.didSignal = null;
            this.didSignalType = null;
            this.didOptOut = null;
            this.didSignalAndroidAdId = null;
            this.evtTime = null;
            this.zzbqb = -1;
            return this;
        }

        public AFMASignals mergeFrom(zztc input) throws IOException {
            while (true) {
                int zzHi = input.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.osVersion = input.readString();
                        continue;
                    case 18:
                        this.afmaVersion = input.readString();
                        continue;
                    case 24:
                        this.atvSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 32:
                        this.attSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 40:
                        this.btsSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 48:
                        this.btlSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 56:
                        this.acxSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 64:
                        this.acySignal = Long.valueOf(input.zzHk());
                        continue;
                    case 72:
                        this.aczSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 80:
                        this.actSignal = Long.valueOf(input.zzHk());
                        continue;
                    case Place.TYPE_STORE /*88*/:
                        this.netSignal = Long.valueOf(input.zzHk());
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.ornSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 106:
                        this.stkSignal = input.readString();
                        continue;
                    case 112:
                        this.tcxSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 120:
                        this.tcySignal = Long.valueOf(input.zzHk());
                        continue;
                    case 128:
                        this.tctSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 136:
                        this.uptSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 144:
                        this.visSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 152:
                        this.swzSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 160:
                        this.psnSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 168:
                        this.reqType = Long.valueOf(input.zzHk());
                        continue;
                    case 176:
                        this.jbkSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 184:
                        this.usgSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 194:
                        this.didSignal = input.readString();
                        continue;
                    case 200:
                        this.evtTime = Long.valueOf(input.zzHk());
                        continue;
                    case 208:
                        zzHi = input.zzHl();
                        switch (zzHi) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.didSignalType = Integer.valueOf(zzHi);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.intSignal = input.readString();
                        continue;
                    case 224:
                        this.didOptOut = Boolean.valueOf(input.zzHm());
                        continue;
                    case 234:
                        this.cerSignal = input.readString();
                        continue;
                    case 242:
                        this.didSignalAndroidAdId = input.readString();
                        continue;
                    case 248:
                        this.uwSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 256:
                        this.uhSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 264:
                        this.utzSignal = Long.valueOf(input.zzHk());
                        continue;
                    case 274:
                        this.vnmSignal = input.readString();
                        continue;
                    case 280:
                        this.vcdSignal = Long.valueOf(input.zzHk());
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
            if (this.osVersion != null) {
                output.zzb(1, this.osVersion);
            }
            if (this.afmaVersion != null) {
                output.zzb(2, this.afmaVersion);
            }
            if (this.atvSignal != null) {
                output.zzb(3, this.atvSignal.longValue());
            }
            if (this.attSignal != null) {
                output.zzb(4, this.attSignal.longValue());
            }
            if (this.btsSignal != null) {
                output.zzb(5, this.btsSignal.longValue());
            }
            if (this.btlSignal != null) {
                output.zzb(6, this.btlSignal.longValue());
            }
            if (this.acxSignal != null) {
                output.zzb(7, this.acxSignal.longValue());
            }
            if (this.acySignal != null) {
                output.zzb(8, this.acySignal.longValue());
            }
            if (this.aczSignal != null) {
                output.zzb(9, this.aczSignal.longValue());
            }
            if (this.actSignal != null) {
                output.zzb(10, this.actSignal.longValue());
            }
            if (this.netSignal != null) {
                output.zzb(11, this.netSignal.longValue());
            }
            if (this.ornSignal != null) {
                output.zzb(12, this.ornSignal.longValue());
            }
            if (this.stkSignal != null) {
                output.zzb(13, this.stkSignal);
            }
            if (this.tcxSignal != null) {
                output.zzb(14, this.tcxSignal.longValue());
            }
            if (this.tcySignal != null) {
                output.zzb(15, this.tcySignal.longValue());
            }
            if (this.tctSignal != null) {
                output.zzb(16, this.tctSignal.longValue());
            }
            if (this.uptSignal != null) {
                output.zzb(17, this.uptSignal.longValue());
            }
            if (this.visSignal != null) {
                output.zzb(18, this.visSignal.longValue());
            }
            if (this.swzSignal != null) {
                output.zzb(19, this.swzSignal.longValue());
            }
            if (this.psnSignal != null) {
                output.zzb(20, this.psnSignal.longValue());
            }
            if (this.reqType != null) {
                output.zzb(21, this.reqType.longValue());
            }
            if (this.jbkSignal != null) {
                output.zzb(22, this.jbkSignal.longValue());
            }
            if (this.usgSignal != null) {
                output.zzb(23, this.usgSignal.longValue());
            }
            if (this.didSignal != null) {
                output.zzb(24, this.didSignal);
            }
            if (this.evtTime != null) {
                output.zzb(25, this.evtTime.longValue());
            }
            if (this.didSignalType != null) {
                output.zzG(26, this.didSignalType.intValue());
            }
            if (this.intSignal != null) {
                output.zzb(27, this.intSignal);
            }
            if (this.didOptOut != null) {
                output.zzb(28, this.didOptOut.booleanValue());
            }
            if (this.cerSignal != null) {
                output.zzb(29, this.cerSignal);
            }
            if (this.didSignalAndroidAdId != null) {
                output.zzb(30, this.didSignalAndroidAdId);
            }
            if (this.uwSignal != null) {
                output.zzb(31, this.uwSignal.longValue());
            }
            if (this.uhSignal != null) {
                output.zzb(32, this.uhSignal.longValue());
            }
            if (this.utzSignal != null) {
                output.zzb(33, this.utzSignal.longValue());
            }
            if (this.vnmSignal != null) {
                output.zzb(34, this.vnmSignal);
            }
            if (this.vcdSignal != null) {
                output.zzb(35, this.vcdSignal.longValue());
            }
            super.writeTo(output);
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.osVersion != null) {
                zzz += zztd.zzp(1, this.osVersion);
            }
            if (this.afmaVersion != null) {
                zzz += zztd.zzp(2, this.afmaVersion);
            }
            if (this.atvSignal != null) {
                zzz += zztd.zzd(3, this.atvSignal.longValue());
            }
            if (this.attSignal != null) {
                zzz += zztd.zzd(4, this.attSignal.longValue());
            }
            if (this.btsSignal != null) {
                zzz += zztd.zzd(5, this.btsSignal.longValue());
            }
            if (this.btlSignal != null) {
                zzz += zztd.zzd(6, this.btlSignal.longValue());
            }
            if (this.acxSignal != null) {
                zzz += zztd.zzd(7, this.acxSignal.longValue());
            }
            if (this.acySignal != null) {
                zzz += zztd.zzd(8, this.acySignal.longValue());
            }
            if (this.aczSignal != null) {
                zzz += zztd.zzd(9, this.aczSignal.longValue());
            }
            if (this.actSignal != null) {
                zzz += zztd.zzd(10, this.actSignal.longValue());
            }
            if (this.netSignal != null) {
                zzz += zztd.zzd(11, this.netSignal.longValue());
            }
            if (this.ornSignal != null) {
                zzz += zztd.zzd(12, this.ornSignal.longValue());
            }
            if (this.stkSignal != null) {
                zzz += zztd.zzp(13, this.stkSignal);
            }
            if (this.tcxSignal != null) {
                zzz += zztd.zzd(14, this.tcxSignal.longValue());
            }
            if (this.tcySignal != null) {
                zzz += zztd.zzd(15, this.tcySignal.longValue());
            }
            if (this.tctSignal != null) {
                zzz += zztd.zzd(16, this.tctSignal.longValue());
            }
            if (this.uptSignal != null) {
                zzz += zztd.zzd(17, this.uptSignal.longValue());
            }
            if (this.visSignal != null) {
                zzz += zztd.zzd(18, this.visSignal.longValue());
            }
            if (this.swzSignal != null) {
                zzz += zztd.zzd(19, this.swzSignal.longValue());
            }
            if (this.psnSignal != null) {
                zzz += zztd.zzd(20, this.psnSignal.longValue());
            }
            if (this.reqType != null) {
                zzz += zztd.zzd(21, this.reqType.longValue());
            }
            if (this.jbkSignal != null) {
                zzz += zztd.zzd(22, this.jbkSignal.longValue());
            }
            if (this.usgSignal != null) {
                zzz += zztd.zzd(23, this.usgSignal.longValue());
            }
            if (this.didSignal != null) {
                zzz += zztd.zzp(24, this.didSignal);
            }
            if (this.evtTime != null) {
                zzz += zztd.zzd(25, this.evtTime.longValue());
            }
            if (this.didSignalType != null) {
                zzz += zztd.zzI(26, this.didSignalType.intValue());
            }
            if (this.intSignal != null) {
                zzz += zztd.zzp(27, this.intSignal);
            }
            if (this.didOptOut != null) {
                zzz += zztd.zzc(28, this.didOptOut.booleanValue());
            }
            if (this.cerSignal != null) {
                zzz += zztd.zzp(29, this.cerSignal);
            }
            if (this.didSignalAndroidAdId != null) {
                zzz += zztd.zzp(30, this.didSignalAndroidAdId);
            }
            if (this.uwSignal != null) {
                zzz += zztd.zzd(31, this.uwSignal.longValue());
            }
            if (this.uhSignal != null) {
                zzz += zztd.zzd(32, this.uhSignal.longValue());
            }
            if (this.utzSignal != null) {
                zzz += zztd.zzd(33, this.utzSignal.longValue());
            }
            if (this.vnmSignal != null) {
                zzz += zztd.zzp(34, this.vnmSignal);
            }
            return this.vcdSignal != null ? zzz + zztd.zzd(35, this.vcdSignal.longValue()) : zzz;
        }
    }

    public static final class AdSignalsContainer extends zztk {
        private static volatile AdSignalsContainer[] zzaM;
        public byte[] encryptedDidSignal;
        public byte[] encryptedSpamSignals;

        public AdSignalsContainer() {
            clear();
        }

        public static AdSignalsContainer[] emptyArray() {
            if (zzaM == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaM == null) {
                        zzaM = new AdSignalsContainer[0];
                    }
                }
            }
            return zzaM;
        }

        public static AdSignalsContainer parseFrom(zztc input) throws IOException {
            return new AdSignalsContainer().mergeFrom(input);
        }

        public static AdSignalsContainer parseFrom(byte[] data) throws zztj {
            return (AdSignalsContainer) zztk.mergeFrom(new AdSignalsContainer(), data);
        }

        public AdSignalsContainer clear() {
            this.encryptedSpamSignals = null;
            this.encryptedDidSignal = null;
            this.zzbqb = -1;
            return this;
        }

        public AdSignalsContainer mergeFrom(zztc input) throws IOException {
            while (true) {
                int zzHi = input.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.encryptedSpamSignals = input.readBytes();
                        continue;
                    case 18:
                        this.encryptedDidSignal = input.readBytes();
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
            if (this.encryptedSpamSignals != null) {
                output.zza(1, this.encryptedSpamSignals);
            }
            if (this.encryptedDidSignal != null) {
                output.zza(2, this.encryptedDidSignal);
            }
            super.writeTo(output);
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.encryptedSpamSignals != null) {
                zzz += zztd.zzb(1, this.encryptedSpamSignals);
            }
            return this.encryptedDidSignal != null ? zzz + zztd.zzb(2, this.encryptedDidSignal) : zzz;
        }
    }
}
