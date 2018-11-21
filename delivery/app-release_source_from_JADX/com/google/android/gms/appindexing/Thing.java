package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public class Thing {
    final Bundle zzTm;

    public static class Builder {
        final Bundle zzTn = new Bundle();

        public Thing build() {
            return new Thing(this.zzTn);
        }

        public Builder put(String key, Thing value) {
            zzx.zzy(key);
            if (value != null) {
                this.zzTn.putParcelable(key, value.zzTm);
            }
            return this;
        }

        public Builder put(String key, String value) {
            zzx.zzy(key);
            if (value != null) {
                this.zzTn.putString(key, value);
            }
            return this;
        }

        public Builder put(String key, Thing[] values) {
            zzx.zzy(key);
            if (values != null) {
                ArrayList arrayList = new ArrayList();
                for (Thing thing : values) {
                    if (thing != null) {
                        arrayList.add(thing.zzTm);
                    }
                }
                this.zzTn.putParcelableArray(key, (Parcelable[]) arrayList.toArray(new Bundle[arrayList.size()]));
            }
            return this;
        }

        public Builder put(String key, String[] values) {
            zzx.zzy(key);
            if (values != null) {
                this.zzTn.putStringArray(key, values);
            }
            return this;
        }

        public Builder setDescription(String description) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
            return this;
        }

        public Builder setId(String id) {
            if (id != null) {
                put("id", id);
            }
            return this;
        }

        public Builder setName(String name) {
            zzx.zzy(name);
            put("name", name);
            return this;
        }

        public Builder setType(String type) {
            put("type", type);
            return this;
        }

        public Builder setUrl(Uri url) {
            zzx.zzy(url);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, url.toString());
            return this;
        }
    }

    Thing(Bundle propertyBundle) {
        this.zzTm = propertyBundle;
    }

    public Bundle zzlT() {
        return this.zzTm;
    }
}