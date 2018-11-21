package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zznn;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final Creator<QuestEntity> CREATOR = new QuestEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzZU;
    private final long zzaAO;
    private final GameEntity zzaGU;
    private final String zzaHM;
    private final long zzaHN;
    private final Uri zzaHO;
    private final String zzaHP;
    private final long zzaHQ;
    private final Uri zzaHR;
    private final String zzaHS;
    private final long zzaHT;
    private final long zzaHU;
    private final ArrayList<MilestoneEntity> zzaHV;
    private final String zzavc;

    QuestEntity(int versionCode, GameEntity game, String questId, long acceptedTimestamp, Uri bannerImageUri, String bannerImageUrl, String description, long endTimestamp, long lastUpdatedTimestamp, Uri iconImageUri, String iconImageUrl, String name, long notifyTimestamp, long startTimestamp, int state, int type, ArrayList<MilestoneEntity> milestones) {
        this.mVersionCode = versionCode;
        this.zzaGU = game;
        this.zzaHM = questId;
        this.zzaHN = acceptedTimestamp;
        this.zzaHO = bannerImageUri;
        this.zzaHP = bannerImageUrl;
        this.zzavc = description;
        this.zzaHQ = endTimestamp;
        this.zzaAO = lastUpdatedTimestamp;
        this.zzaHR = iconImageUri;
        this.zzaHS = iconImageUrl;
        this.mName = name;
        this.zzaHT = notifyTimestamp;
        this.zzaHU = startTimestamp;
        this.mState = state;
        this.zzZU = type;
        this.zzaHV = milestones;
    }

    public QuestEntity(Quest quest) {
        this.mVersionCode = 2;
        this.zzaGU = new GameEntity(quest.getGame());
        this.zzaHM = quest.getQuestId();
        this.zzaHN = quest.getAcceptedTimestamp();
        this.zzavc = quest.getDescription();
        this.zzaHO = quest.getBannerImageUri();
        this.zzaHP = quest.getBannerImageUrl();
        this.zzaHQ = quest.getEndTimestamp();
        this.zzaHR = quest.getIconImageUri();
        this.zzaHS = quest.getIconImageUrl();
        this.zzaAO = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzaHT = quest.zzxl();
        this.zzaHU = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzZU = quest.getType();
        List zzxk = quest.zzxk();
        int size = zzxk.size();
        this.zzaHV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaHV.add((MilestoneEntity) ((Milestone) zzxk.get(i)).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzw.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzxk(), quest.getName(), Long.valueOf(quest.zzxl()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzw.equal(quest2.getGame(), quest.getGame()) && zzw.equal(quest2.getQuestId(), quest.getQuestId()) && zzw.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzw.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzw.equal(quest2.getDescription(), quest.getDescription()) && zzw.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzw.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzw.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzw.equal(quest2.zzxk(), quest.zzxk()) && zzw.equal(quest2.getName(), quest.getName()) && zzw.equal(Long.valueOf(quest2.zzxl()), Long.valueOf(quest.zzxl())) && zzw.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzw.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzw.zzx(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzxk()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzxl())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.zzaHN;
    }

    public Uri getBannerImageUri() {
        return this.zzaHO;
    }

    public String getBannerImageUrl() {
        return this.zzaHP;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzxk().get(0);
    }

    public String getDescription() {
        return this.zzavc;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzavc, dataOut);
    }

    public long getEndTimestamp() {
        return this.zzaHQ;
    }

    public Game getGame() {
        return this.zzaGU;
    }

    public Uri getIconImageUri() {
        return this.zzaHR;
    }

    public String getIconImageUrl() {
        return this.zzaHS;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaAO;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zznn.zzb(this.mName, dataOut);
    }

    public String getQuestId() {
        return this.zzaHM;
    }

    public long getStartTimestamp() {
        return this.zzaHU;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.zzZU;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isEndingSoon() {
        return this.zzaHT <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        QuestEntityCreator.zza(this, out, flags);
    }

    public List<Milestone> zzxk() {
        return new ArrayList(this.zzaHV);
    }

    public long zzxl() {
        return this.zzaHT;
    }
}
