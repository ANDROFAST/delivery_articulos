package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final Account account;
    final int mVersionCode;
    final DocumentSection[] zzSi;
    public final String zzSj;
    public final boolean zzSk;

    public static class zza {
        private List<DocumentSection> zzSl;
        private String zzSm;
        private boolean zzSn;
        private Account zzSo;

        public zza zzL(boolean z) {
            this.zzSn = z;
            return this;
        }

        public zza zza(DocumentSection documentSection) {
            if (this.zzSl == null) {
                this.zzSl = new ArrayList();
            }
            this.zzSl.add(documentSection);
            return this;
        }

        public zza zzb(Account account) {
            this.zzSo = account;
            return this;
        }

        public zza zzbw(String str) {
            this.zzSm = str;
            return this;
        }

        public DocumentContents zzlN() {
            return new DocumentContents(this.zzSm, this.zzSn, this.zzSo, this.zzSl != null ? (DocumentSection[]) this.zzSl.toArray(new DocumentSection[this.zzSl.size()]) : null);
        }
    }

    DocumentContents(int versionCode, DocumentSection[] sectionContents, String schemaOrgType, boolean globalSearchEnabled, Account account) {
        this.mVersionCode = versionCode;
        this.zzSi = sectionContents;
        this.zzSj = schemaOrgType;
        this.zzSk = globalSearchEnabled;
        this.account = account;
    }

    DocumentContents(String schemaOrgType, boolean globalSearchEnabled, Account account, DocumentSection... sections) {
        this(1, sections, schemaOrgType, globalSearchEnabled, account);
        BitSet bitSet = new BitSet(zzh.zzlP());
        for (DocumentSection documentSection : sections) {
            int i = documentSection.zzSw;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzao(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        zzb com_google_android_gms_appdatasearch_zzb = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb com_google_android_gms_appdatasearch_zzb = CREATOR;
        zzb.zza(this, dest, flags);
    }
}
