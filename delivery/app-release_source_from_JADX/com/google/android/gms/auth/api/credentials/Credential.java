package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    private final String mName;
    final int mVersionCode;
    private final String zzUA;
    private final String zzUB;
    private final String zzUC;
    private final String zzUD;
    private final Uri zzUy;
    private final List<IdToken> zzUz;
    private final String zzxX;

    public static class Builder {
        private String mName;
        private String zzUA;
        private String zzUB;
        private String zzUC;
        private String zzUD;
        private Uri zzUy;
        private List<IdToken> zzUz;
        private final String zzxX;

        public Builder(Credential credential) {
            this.zzxX = credential.zzxX;
            this.mName = credential.mName;
            this.zzUy = credential.zzUy;
            this.zzUz = credential.zzUz;
            this.zzUA = credential.zzUA;
            this.zzUB = credential.zzUB;
            this.zzUC = credential.zzUC;
            this.zzUD = credential.zzUD;
        }

        public Builder(String id) {
            this.zzxX = id;
        }

        public Credential build() {
            return new Credential(3, this.zzxX, this.mName, this.zzUy, this.zzUz, this.zzUA, this.zzUB, this.zzUC, this.zzUD);
        }

        public Builder setAccountType(String accountType) {
            this.zzUB = accountType;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.zzUA = password;
            return this;
        }

        public Builder setProfilePictureUri(Uri profilePictureUri) {
            this.zzUy = profilePictureUri;
            return this;
        }
    }

    Credential(int version, String id, String name, Uri profilePictureUri, List<IdToken> idTokens, String password, String accountType, String generatedPassword, String generatedHintId) {
        this.mVersionCode = version;
        String trim = ((String) zzx.zzb((Object) id, (Object) "credential identifier cannot be null")).trim();
        zzx.zzh(trim, "credential identifier cannot be empty");
        this.zzxX = trim;
        this.mName = name;
        this.zzUy = profilePictureUri;
        this.zzUz = idTokens == null ? Collections.emptyList() : Collections.unmodifiableList(idTokens);
        this.zzUA = password;
        if (password == null || !password.isEmpty()) {
            if (!TextUtils.isEmpty(accountType)) {
                trim = Uri.parse(accountType).getScheme();
                boolean z = "http".equalsIgnoreCase(trim) || "https".equalsIgnoreCase(trim);
                zzx.zzab(z);
            }
            this.zzUB = accountType;
            this.zzUC = generatedPassword;
            this.zzUD = generatedHintId;
            if (!TextUtils.isEmpty(this.zzUA) && !TextUtils.isEmpty(this.zzUB)) {
                throw new IllegalStateException("password and accountType cannot both be set");
            }
            return;
        }
        throw new IllegalArgumentException("password cannot be empty");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) other;
        return TextUtils.equals(this.zzxX, credential.zzxX) && TextUtils.equals(this.mName, credential.mName) && zzw.equal(this.zzUy, credential.zzUy) && TextUtils.equals(this.zzUA, credential.zzUA) && TextUtils.equals(this.zzUB, credential.zzUB) && TextUtils.equals(this.zzUC, credential.zzUC);
    }

    public String getAccountType() {
        return this.zzUB;
    }

    public String getGeneratedPassword() {
        return this.zzUC;
    }

    public String getId() {
        return this.zzxX;
    }

    public List<IdToken> getIdTokens() {
        return this.zzUz;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzUA;
    }

    public Uri getProfilePictureUri() {
        return this.zzUy;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzxX, this.mName, this.zzUy, this.zzUA, this.zzUB, this.zzUC);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzmg() {
        return this.zzUD;
    }
}
