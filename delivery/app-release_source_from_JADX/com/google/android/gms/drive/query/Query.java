package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new zza();
    final int mVersionCode;
    final List<DriveSpace> zzanF;
    private final Set<DriveSpace> zzanG;
    final boolean zzapH;
    final LogicalFilter zzarP;
    final String zzarQ;
    final SortOrder zzarR;
    final List<String> zzarS;
    final boolean zzarT;

    public static class Builder {
        private Set<DriveSpace> zzanG;
        private boolean zzapH;
        private String zzarQ;
        private SortOrder zzarR;
        private List<String> zzarS;
        private boolean zzarT;
        private final List<Filter> zzarU = new ArrayList();

        public Builder(Query query) {
            this.zzarU.add(query.getFilter());
            this.zzarQ = query.getPageToken();
            this.zzarR = query.getSortOrder();
            this.zzarS = query.zzth();
            this.zzarT = query.zzti();
            this.zzanG = query.zztj();
            this.zzapH = query.zztk();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzarU.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzasw, this.zzarU), this.zzarQ, this.zzarR, this.zzarS, this.zzarT, this.zzanG, this.zzapH);
        }

        @Deprecated
        public Builder setPageToken(String token) {
            this.zzarQ = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzarR = sortOrder;
            return this;
        }
    }

    private Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, List<DriveSpace> spacesList, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this.mVersionCode = versionCode;
        this.zzarP = clause;
        this.zzarQ = pageToken;
        this.zzarR = sortOrder;
        this.zzarS = requestedMetadataFields;
        this.zzarT = includeParents;
        this.zzanF = spacesList;
        this.zzanG = spaces;
        this.zzapH = includeUnsubscribed;
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, List<DriveSpace> spacesList, boolean includeUnsubscribed) {
        this(versionCode, clause, pageToken, sortOrder, requestedMetadataFields, includeParents, spacesList, spacesList == null ? null : new HashSet(spacesList), includeUnsubscribed);
    }

    private Query(LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean includeParents, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this(1, clause, pageToken, sortOrder, requestedMetadataFields, includeParents, spaces == null ? null : new ArrayList(spaces), spaces, includeUnsubscribed);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzarP;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzarQ;
    }

    public SortOrder getSortOrder() {
        return this.zzarR;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzarP, this.zzarR, this.zzarQ, this.zzanF});
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public List<String> zzth() {
        return this.zzarS;
    }

    public boolean zzti() {
        return this.zzarT;
    }

    public Set<DriveSpace> zztj() {
        return this.zzanG;
    }

    public boolean zztk() {
        return this.zzapH;
    }
}
