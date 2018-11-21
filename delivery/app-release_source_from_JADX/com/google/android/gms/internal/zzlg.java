package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.CastApi;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerResult;
import com.google.android.gms.cast.games.GameManagerClient.Listener;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class zzlg extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE = zzf.zzcc("com.google.cast.games");
    private static final zzl zzYy = new zzl("GameManagerChannel");
    private final Map<String, String> zzaaS = new ConcurrentHashMap();
    private final List<zzp> zzaaT;
    private final String zzaaU;
    private final CastApi zzaaV;
    private final GoogleApiClient zzaaW;
    private zzlh zzaaX;
    private boolean zzaaY = false;
    private GameManagerState zzaaZ;
    private GameManagerState zzaba;
    private String zzabb;
    private JSONObject zzabc;
    private long zzabd = 0;
    private Listener zzabe;
    private String zzabf;
    private final SharedPreferences zzvc;

    private static final class zzd implements GameManagerInstanceResult {
        private final Status zzTA;
        private final GameManagerClient zzabo;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzTA = status;
            this.zzabo = gameManagerClient;
        }

        public GameManagerClient getGameManagerClient() {
            return this.zzabo;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class zze implements GameManagerResult {
        private final Status zzTA;
        private final String zzabq;
        private final long zzabr;
        private final JSONObject zzabs;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzTA = status;
            this.zzabq = str;
            this.zzabr = j;
            this.zzabs = jSONObject;
        }

        public JSONObject getExtraMessageData() {
            return this.zzabs;
        }

        public String getPlayerId() {
            return this.zzabq;
        }

        public long getRequestId() {
            return this.zzabr;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected zzo zzaaF;
        final /* synthetic */ zzlg zzabg;

        public zzb(zzlg com_google_android_gms_internal_zzlg) {
            this.zzabg = com_google_android_gms_internal_zzlg;
            super(com_google_android_gms_internal_zzlg.zzaaW);
        }

        public abstract void execute();

        protected void zza(com.google.android.gms.cast.internal.zze com_google_android_gms_cast_internal_zze) {
            execute();
        }

        public zzo zznE() {
            return this.zzaaF;
        }
    }

    public abstract class zza extends zzb<GameManagerResult> {
        final /* synthetic */ zzlg zzabg;

        public zza(final zzlg com_google_android_gms_internal_zzlg) {
            this.zzabg = com_google_android_gms_internal_zzlg;
            super(com_google_android_gms_internal_zzlg);
            this.zzaaF = new zzo(this) {
                final /* synthetic */ zza zzabn;

                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            this.zzabn.zzb(new zze(new Status(i, null, null), null, j, null));
                            return;
                        } catch (ClassCastException e) {
                            this.zzabn.zzb(this.zzabn.zzr(new Status(13)));
                            return;
                        }
                    }
                    zzli com_google_android_gms_internal_zzli = (zzli) obj;
                    String playerId = com_google_android_gms_internal_zzli.getPlayerId();
                    if (i == 0 && playerId != null) {
                        this.zzabn.zzabg.zzabf = playerId;
                    }
                    this.zzabn.zzb(new zze(new Status(i, com_google_android_gms_internal_zzli.zznH(), null), playerId, com_google_android_gms_internal_zzli.getRequestId(), com_google_android_gms_internal_zzli.getExtraMessageData()));
                }

                public void zzy(long j) {
                    this.zzabn.zzb(this.zzabn.zzr(new Status(2103)));
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzr(status);
        }

        public GameManagerResult zzr(Status status) {
            return new zze(status, null, -1, null);
        }
    }

    public abstract class zzc extends zzb<GameManagerInstanceResult> {
        final /* synthetic */ zzlg zzabg;
        private GameManagerClient zzabo;

        public zzc(final zzlg com_google_android_gms_internal_zzlg, GameManagerClient gameManagerClient) {
            this.zzabg = com_google_android_gms_internal_zzlg;
            super(com_google_android_gms_internal_zzlg);
            this.zzabo = gameManagerClient;
            this.zzaaF = new zzo(this) {
                final /* synthetic */ zzc zzabp;

                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            this.zzabp.zzb(new zzd(new Status(i, null, null), this.zzabp.zzabo));
                            return;
                        } catch (ClassCastException e) {
                            this.zzabp.zzb(this.zzabp.zzs(new Status(13)));
                            return;
                        }
                    }
                    zzli com_google_android_gms_internal_zzli = (zzli) obj;
                    zzlh zznL = com_google_android_gms_internal_zzli.zznL();
                    if (zznL == null || zzf.zza("1.0.0", zznL.getVersion())) {
                        this.zzabp.zzb(new zzd(new Status(i, com_google_android_gms_internal_zzli.zznH(), null), this.zzabp.zzabo));
                        return;
                    }
                    this.zzabp.zzb(this.zzabp.zzs(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[]{zznL.getVersion(), "1.0.0"}))));
                    this.zzabp.zzabg.zzaaX = null;
                }

                public void zzy(long j) {
                    this.zzabp.zzb(this.zzabp.zzs(new Status(2103)));
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzs(status);
        }

        public GameManagerInstanceResult zzs(Status status) {
            return new zzd(status, null);
        }
    }

    public zzlg(GoogleApiClient googleApiClient, String str, CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        } else if (googleApiClient != null && googleApiClient.isConnected() && googleApiClient.hasConnectedApi(Cast.API)) {
            this.zzaaT = new ArrayList();
            this.zzaaU = str;
            this.zzaaV = castApi;
            this.zzaaW = googleApiClient;
            this.zzvc = r0.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", new Object[]{googleApiClient.getContext().getApplicationContext().getPackageName(), "game_manager_channel_data"}), 0);
            this.zzaba = null;
            this.zzaaZ = new zzlk(0, 0, "", null, new ArrayList(), "", -1);
        } else {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        }
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzbY(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzYy.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzli com_google_android_gms_internal_zzli) {
        Object obj = 1;
        synchronized (this) {
            if (com_google_android_gms_internal_zzli.zznG() != 1) {
                obj = null;
            }
            this.zzaba = this.zzaaZ;
            if (!(obj == null || com_google_android_gms_internal_zzli.zznL() == null)) {
                this.zzaaX = com_google_android_gms_internal_zzli.zznL();
            }
            if (isInitialized()) {
                Collection arrayList = new ArrayList();
                for (zzlm com_google_android_gms_internal_zzlm : com_google_android_gms_internal_zzli.zznI()) {
                    String playerId = com_google_android_gms_internal_zzlm.getPlayerId();
                    arrayList.add(new zzll(playerId, com_google_android_gms_internal_zzlm.getPlayerState(), com_google_android_gms_internal_zzlm.getPlayerData(), this.zzaaS.containsKey(playerId)));
                }
                this.zzaaZ = new zzlk(com_google_android_gms_internal_zzli.getLobbyState(), com_google_android_gms_internal_zzli.getGameplayState(), com_google_android_gms_internal_zzli.zznJ(), com_google_android_gms_internal_zzli.getGameData(), arrayList, this.zzaaX.zznF(), this.zzaaX.getMaxPlayers());
                PlayerInfo player = this.zzaaZ.getPlayer(com_google_android_gms_internal_zzli.getPlayerId());
                if (player != null && player.isControllable() && com_google_android_gms_internal_zzli.zznG() == 2) {
                    this.zzabb = com_google_android_gms_internal_zzli.getPlayerId();
                    this.zzabc = com_google_android_gms_internal_zzli.getExtraMessageData();
                }
            }
        }
    }

    private void zza(String str, int i, JSONObject jSONObject, zzo com_google_android_gms_cast_internal_zzo) {
        final long j = 1 + this.zzabd;
        this.zzabd = j;
        JSONObject zza = zza(j, str, i, jSONObject);
        if (zza == null) {
            com_google_android_gms_cast_internal_zzo.zza(-1, 2001, null);
            zzYy.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        zzp com_google_android_gms_cast_internal_zzp = new zzp(30000);
        com_google_android_gms_cast_internal_zzp.zza(j, com_google_android_gms_cast_internal_zzo);
        this.zzaaT.add(com_google_android_gms_cast_internal_zzp);
        zzW(true);
        this.zzaaV.sendMessage(this.zzaaW, getNamespace(), zza.toString()).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ zzlg zzabg;

            public /* synthetic */ void onResult(Result x0) {
                zzp((Status) x0);
            }

            public void zzp(Status status) {
                if (!status.isSuccess()) {
                    this.zzabg.zzb(j, status.getStatusCode());
                }
            }
        });
    }

    private void zzb(long j, int i, Object obj) {
        Iterator it = this.zzaaT.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private int zzbg(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2001;
            case 2:
                return CastStatusCodes.NOT_ALLOWED;
            case 3:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case 4:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzYy.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private void zznA() {
        if (this.zzabe != null) {
            if (!(this.zzaba == null || this.zzaaZ.equals(this.zzaba))) {
                this.zzabe.onStateChanged(this.zzaaZ, this.zzaba);
            }
            if (!(this.zzabc == null || this.zzabb == null)) {
                this.zzabe.onGameMessageReceived(this.zzabb, this.zzabc);
            }
        }
        this.zzaba = null;
        this.zzabb = null;
        this.zzabc = null;
    }

    private synchronized void zznB() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzaaU);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzaaS));
            this.zzvc.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzYy.zzf("Error while saving data: %s", e.getMessage());
        }
    }

    private synchronized void zznC() {
        String string = this.zzvc.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzaaU.equals(jSONObject.getString("castSessionId"))) {
                    jSONObject = jSONObject.getJSONObject("playerTokenMap");
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        string = (String) keys.next();
                        this.zzaaS.put(string, jSONObject.getString(string));
                    }
                    this.zzabd = 0;
                }
            } catch (JSONException e) {
                zzYy.zzf("Error while loading data: %s", e.getMessage());
            }
        }
    }

    private synchronized void zznz() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        } else if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzaaY) {
            this.zzaaZ = null;
            this.zzaba = null;
            this.zzabb = null;
            this.zzabc = null;
            this.zzaaY = true;
            try {
                this.zzaaV.removeMessageReceivedCallbacks(this.zzaaW, getNamespace());
            } catch (IOException e) {
                zzYy.zzf("Exception while detaching game manager channel.", e);
            }
        }
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zznz();
        return this.zzaaZ;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zznz();
        return this.zzabf;
    }

    public synchronized boolean isDisposed() {
        return this.zzaaY;
    }

    public synchronized boolean isInitialized() {
        return this.zzaaX != null;
    }

    public synchronized void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zznz();
        long j = 1 + this.zzabd;
        this.zzabd = j;
        JSONObject zza = zza(j, playerId, 7, extraMessageData);
        if (zza != null) {
            this.zzaaV.sendMessage(this.zzaaW, getNamespace(), zza.toString());
        }
    }

    public synchronized PendingResult<GameManagerResult> sendGameRequest(final String playerId, final JSONObject extraMessageData) throws IllegalStateException {
        zznz();
        return this.zzaaW.zzb(new zza(this) {
            final /* synthetic */ zzlg zzabg;

            public void execute() {
                this.zzabg.zza(playerId, 6, extraMessageData, zznE());
            }
        });
    }

    public synchronized void setListener(Listener listener) {
        this.zzabe = listener;
    }

    public synchronized PendingResult<GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        if (gameManagerClient == null) {
            throw new IllegalArgumentException("gameManagerClient can't be null.");
        }
        return this.zzaaW.zzb(new zzc(this, gameManagerClient) {
            final /* synthetic */ zzlg zzabg;

            class C07301 implements MessageReceivedCallback {
                final /* synthetic */ C14361 zzabh;

                C07301(C14361 c14361) {
                    this.zzabh = c14361;
                }

                public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
                    this.zzabh.zzabg.zzbZ(message);
                }
            }

            public void execute() {
                try {
                    this.zzabg.zzaaV.setMessageReceivedCallbacks(this.zzabg.zzaaW, this.zzabg.getNamespace(), new C07301(this));
                    this.zzabg.zznC();
                    this.zzabg.zznB();
                    this.zzabg.zza(null, 1100, null, zznE());
                } catch (IOException e) {
                    zznE().zza(-1, 8, null);
                } catch (IllegalStateException e2) {
                    zznE().zza(-1, 8, null);
                }
            }
        });
    }

    public synchronized PendingResult<GameManagerResult> zza(final String str, final int i, final JSONObject jSONObject) throws IllegalStateException {
        zznz();
        return this.zzaaW.zzb(new zza(this) {
            final /* synthetic */ zzlg zzabg;

            public void execute() {
                int zzbh = zzlj.zzbh(i);
                if (zzbh == 0) {
                    zznE().zza(-1, 2001, null);
                    zzlg.zzYy.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(i));
                    return;
                }
                this.zzabg.zza(str, zzbh, jSONObject, zznE());
            }
        });
    }

    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzbY(String str) throws IllegalStateException {
        return str == null ? null : (String) this.zzaaS.get(str);
    }

    public final void zzbZ(String str) {
        zzYy.zzb("message received: %s", str);
        try {
            zzli zzh = zzli.zzh(new JSONObject(str));
            if (zzh == null) {
                zzYy.zzf("Could not parse game manager message from string: %s", str);
            } else if ((isInitialized() || zzh.zznL() != null) && !isDisposed()) {
                int i = zzh.zznG() == 1 ? 1 : 0;
                if (!(i == 0 || TextUtils.isEmpty(zzh.zznK()))) {
                    this.zzaaS.put(zzh.getPlayerId(), zzh.zznK());
                    zznB();
                }
                if (zzh.getStatusCode() == 0) {
                    zza(zzh);
                } else {
                    zzYy.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzh.getStatusCode()));
                }
                int zzbg = zzbg(zzh.getStatusCode());
                if (i != 0) {
                    zzb(zzh.getRequestId(), zzbg, zzh);
                }
                if (isInitialized() && zzbg == 0) {
                    zznA();
                }
            }
        } catch (JSONException e) {
            zzYy.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    protected boolean zzz(long j) {
        boolean z;
        Iterator it = this.zzaaT.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (zzp.zzacU) {
            for (zzp zzoi : this.zzaaT) {
                if (zzoi.zzoi()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
