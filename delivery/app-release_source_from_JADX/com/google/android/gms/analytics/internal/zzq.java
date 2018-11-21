package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class zzq<T extends zzp> extends zzc {
    zza<T> zzQd;

    public interface zza<U extends zzp> {
        void zzc(String str, int i);

        void zzc(String str, boolean z);

        U zzjZ();

        void zzk(String str, String str2);

        void zzl(String str, String str2);
    }

    public zzq(zzf com_google_android_gms_analytics_internal_zzf, zza<T> com_google_android_gms_analytics_internal_zzq_zza_T) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.zzQd = com_google_android_gms_analytics_internal_zzq_zza_T;
    }

    private T zza(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    Object attributeValue;
                    Object trim;
                    if (toLowerCase.equals("screenname")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            this.zzQd.zzk(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim2 == null)) {
                            this.zzQd.zzl(attributeValue, trim2);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.zzQd.zzc(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                zzc("Error parsing bool configuration value", trim, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.zzQd.zzc(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                zzc("Error parsing int configuration value", trim, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            zze("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            zze("Error parsing tracker configuration file", e4);
        }
        return this.zzQd.zzjZ();
    }

    public T zzah(int i) {
        try {
            return zza(zziQ().zzjg().getResources().getXml(i));
        } catch (NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
