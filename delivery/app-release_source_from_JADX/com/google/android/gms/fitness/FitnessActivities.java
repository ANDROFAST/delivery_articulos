package com.google.android.gms.fitness;

import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;

public class FitnessActivities {
    public static final String AEROBICS = "aerobics";
    public static final String BADMINTON = "badminton";
    public static final String BASEBALL = "baseball";
    public static final String BASKETBALL = "basketball";
    public static final String BIATHLON = "biathlon";
    public static final String BIKING = "biking";
    public static final String BIKING_HAND = "biking.hand";
    public static final String BIKING_MOUNTAIN = "biking.mountain";
    public static final String BIKING_ROAD = "biking.road";
    public static final String BIKING_SPINNING = "biking.spinning";
    public static final String BIKING_STATIONARY = "biking.stationary";
    public static final String BIKING_UTILITY = "biking.utility";
    public static final String BOXING = "boxing";
    public static final String CALISTHENICS = "calisthenics";
    public static final String CIRCUIT_TRAINING = "circuit_training";
    public static final String CRICKET = "cricket";
    public static final String CROSSFIT = "crossfit";
    public static final String CURLING = "curling";
    public static final String DANCING = "dancing";
    public static final String DIVING = "diving";
    public static final String ELEVATOR = "elevator";
    public static final String ELLIPTICAL = "elliptical";
    public static final String ERGOMETER = "ergometer";
    public static final String ESCALATOR = "escalator";
    public static final String EXTRA_STATUS = "actionStatus";
    public static final String FENCING = "fencing";
    public static final String FOOTBALL_AMERICAN = "football.american";
    public static final String FOOTBALL_AUSTRALIAN = "football.australian";
    public static final String FOOTBALL_SOCCER = "football.soccer";
    public static final String FRISBEE_DISC = "frisbee_disc";
    public static final String GARDENING = "gardening";
    public static final String GOLF = "golf";
    public static final String GYMNASTICS = "gymnastics";
    public static final String HANDBALL = "handball";
    public static final String HIGH_INTENSITY_INTERVAL_TRAINING = "interval_training.high_intensity";
    public static final String HIKING = "hiking";
    public static final String HOCKEY = "hockey";
    public static final String HORSEBACK_RIDING = "horseback_riding";
    public static final String HOUSEWORK = "housework";
    public static final String ICE_SKATING = "ice_skating";
    public static final String INTERVAL_TRAINING = "interval_training";
    public static final String IN_VEHICLE = "in_vehicle";
    public static final String JUMP_ROPE = "jump_rope";
    public static final String KAYAKING = "kayaking";
    public static final String KETTLEBELL_TRAINING = "kettlebell_training";
    public static final String KICKBOXING = "kickboxing";
    public static final String KICK_SCOOTER = "kick_scooter";
    public static final String KITESURFING = "kitesurfing";
    public static final String MARTIAL_ARTS = "martial_arts";
    public static final String MEDITATION = "meditation";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.activity/";
    public static final String MIXED_MARTIAL_ARTS = "martial_arts.mixed";
    public static final String ON_FOOT = "on_foot";
    public static final String OTHER = "other";
    public static final String P90X = "p90x";
    public static final String PARAGLIDING = "paragliding";
    public static final String PILATES = "pilates";
    public static final String POLO = "polo";
    public static final String RACQUETBALL = "racquetball";
    public static final String ROCK_CLIMBING = "rock_climbing";
    public static final String ROWING = "rowing";
    public static final String ROWING_MACHINE = "rowing.machine";
    public static final String RUGBY = "rugby";
    public static final String RUNNING = "running";
    public static final String RUNNING_JOGGING = "running.jogging";
    public static final String RUNNING_SAND = "running.sand";
    public static final String RUNNING_TREADMILL = "running.treadmill";
    public static final String SAILING = "sailing";
    public static final String SCUBA_DIVING = "scuba_diving";
    public static final String SKATEBOARDING = "skateboarding";
    public static final String SKATING = "skating";
    public static final String SKATING_CROSS = "skating.cross";
    public static final String SKATING_INDOOR = "skating.indoor";
    public static final String SKATING_INLINE = "skating.inline";
    public static final String SKIING = "skiing";
    public static final String SKIING_BACK_COUNTRY = "skiing.back_country";
    public static final String SKIING_CROSS_COUNTRY = "skiing.cross_country";
    public static final String SKIING_DOWNHILL = "skiing.downhill";
    public static final String SKIING_KITE = "skiing.kite";
    public static final String SKIING_ROLLER = "skiing.roller";
    public static final String SLEDDING = "sledding";
    public static final String SLEEP = "sleep";
    public static final String SLEEP_AWAKE = "sleep.awake";
    public static final String SLEEP_DEEP = "sleep.deep";
    public static final String SLEEP_LIGHT = "sleep.light";
    public static final String SLEEP_REM = "sleep.rem";
    public static final String SNOWBOARDING = "snowboarding";
    public static final String SNOWMOBILE = "snowmobile";
    public static final String SNOWSHOEING = "snowshoeing";
    public static final String SQUASH = "squash";
    public static final String STAIR_CLIMBING = "stair_climbing";
    public static final String STAIR_CLIMBING_MACHINE = "stair_climbing.machine";
    public static final String STANDUP_PADDLEBOARDING = "standup_paddleboarding";
    public static final String STATUS_ACTIVE = "ActiveActionStatus";
    public static final String STATUS_COMPLETED = "CompletedActionStatus";
    public static final String STILL = "still";
    public static final String STRENGTH_TRAINING = "strength_training";
    public static final String SURFING = "surfing";
    public static final String SWIMMING = "swimming";
    public static final String SWIMMING_OPEN_WATER = "swimming.open_water";
    public static final String SWIMMING_POOL = "swimming.pool";
    public static final String TABLE_TENNIS = "table_tennis";
    public static final String TEAM_SPORTS = "team_sports";
    public static final String TENNIS = "tennis";
    public static final String TILTING = "tilting";
    public static final String TREADMILL = "treadmill";
    public static final String UNKNOWN = "unknown";
    public static final String VOLLEYBALL = "volleyball";
    public static final String VOLLEYBALL_BEACH = "volleyball.beach";
    public static final String VOLLEYBALL_INDOOR = "volleyball.indoor";
    public static final String WAKEBOARDING = "wakeboarding";
    public static final String WALKING = "walking";
    public static final String WALKING_FITNESS = "walking.fitness";
    public static final String WALKING_NORDIC = "walking.nordic";
    public static final String WALKING_STROLLER = "walking.stroller";
    public static final String WALKING_TREADMILL = "walking.treadmill";
    public static final String WATER_POLO = "water_polo";
    public static final String WEIGHTLIFTING = "weightlifting";
    public static final String WHEELCHAIR = "wheelchair";
    public static final String WINDSURFING = "windsurfing";
    public static final String YOGA = "yoga";
    public static final String ZUMBA = "zumba";
    private static final String[] zzatN = new String[119];

    static {
        zzatN[9] = AEROBICS;
        zzatN[10] = BADMINTON;
        zzatN[11] = BASEBALL;
        zzatN[12] = BASKETBALL;
        zzatN[13] = BIATHLON;
        zzatN[1] = BIKING;
        zzatN[14] = BIKING_HAND;
        zzatN[15] = BIKING_MOUNTAIN;
        zzatN[16] = BIKING_ROAD;
        zzatN[17] = BIKING_SPINNING;
        zzatN[18] = BIKING_STATIONARY;
        zzatN[19] = BIKING_UTILITY;
        zzatN[20] = BOXING;
        zzatN[21] = CALISTHENICS;
        zzatN[22] = CIRCUIT_TRAINING;
        zzatN[23] = CRICKET;
        zzatN[113] = CROSSFIT;
        zzatN[106] = CURLING;
        zzatN[24] = DANCING;
        zzatN[102] = DIVING;
        zzatN[117] = ELEVATOR;
        zzatN[25] = ELLIPTICAL;
        zzatN[Quests.SELECT_RECENTLY_FAILED] = ERGOMETER;
        zzatN[118] = ESCALATOR;
        zzatN[6] = "exiting_vehicle";
        zzatN[26] = FENCING;
        zzatN[27] = FOOTBALL_AMERICAN;
        zzatN[28] = FOOTBALL_AUSTRALIAN;
        zzatN[29] = FOOTBALL_SOCCER;
        zzatN[30] = FRISBEE_DISC;
        zzatN[31] = GARDENING;
        zzatN[32] = GOLF;
        zzatN[33] = GYMNASTICS;
        zzatN[34] = HANDBALL;
        zzatN[114] = HIGH_INTENSITY_INTERVAL_TRAINING;
        zzatN[35] = HIKING;
        zzatN[36] = HOCKEY;
        zzatN[37] = HORSEBACK_RIDING;
        zzatN[38] = HOUSEWORK;
        zzatN[LocationRequest.PRIORITY_LOW_POWER] = ICE_SKATING;
        zzatN[0] = IN_VEHICLE;
        zzatN[115] = INTERVAL_TRAINING;
        zzatN[39] = JUMP_ROPE;
        zzatN[40] = KAYAKING;
        zzatN[41] = KETTLEBELL_TRAINING;
        zzatN[107] = KICK_SCOOTER;
        zzatN[42] = KICKBOXING;
        zzatN[43] = KITESURFING;
        zzatN[44] = MARTIAL_ARTS;
        zzatN[45] = MEDITATION;
        zzatN[46] = MIXED_MARTIAL_ARTS;
        zzatN[2] = ON_FOOT;
        zzatN[108] = OTHER;
        zzatN[47] = P90X;
        zzatN[48] = PARAGLIDING;
        zzatN[49] = PILATES;
        zzatN[50] = POLO;
        zzatN[51] = RACQUETBALL;
        zzatN[52] = ROCK_CLIMBING;
        zzatN[53] = ROWING;
        zzatN[54] = ROWING_MACHINE;
        zzatN[55] = RUGBY;
        zzatN[8] = RUNNING;
        zzatN[56] = RUNNING_JOGGING;
        zzatN[57] = RUNNING_SAND;
        zzatN[58] = RUNNING_TREADMILL;
        zzatN[59] = SAILING;
        zzatN[60] = SCUBA_DIVING;
        zzatN[61] = SKATEBOARDING;
        zzatN[62] = SKATING;
        zzatN[63] = SKATING_CROSS;
        zzatN[LocationRequest.PRIORITY_NO_POWER] = SKATING_INDOOR;
        zzatN[64] = SKATING_INLINE;
        zzatN[65] = SKIING;
        zzatN[66] = SKIING_BACK_COUNTRY;
        zzatN[67] = SKIING_CROSS_COUNTRY;
        zzatN[68] = SKIING_DOWNHILL;
        zzatN[69] = SKIING_KITE;
        zzatN[70] = SKIING_ROLLER;
        zzatN[71] = SLEDDING;
        zzatN[72] = SLEEP;
        zzatN[109] = SLEEP_LIGHT;
        zzatN[110] = SLEEP_DEEP;
        zzatN[111] = SLEEP_REM;
        zzatN[112] = SLEEP_AWAKE;
        zzatN[73] = SNOWBOARDING;
        zzatN[74] = SNOWMOBILE;
        zzatN[75] = SNOWSHOEING;
        zzatN[76] = SQUASH;
        zzatN[77] = STAIR_CLIMBING;
        zzatN[78] = STAIR_CLIMBING_MACHINE;
        zzatN[79] = STANDUP_PADDLEBOARDING;
        zzatN[3] = STILL;
        zzatN[80] = STRENGTH_TRAINING;
        zzatN[81] = SURFING;
        zzatN[82] = SWIMMING;
        zzatN[83] = SWIMMING_POOL;
        zzatN[84] = SWIMMING_OPEN_WATER;
        zzatN[85] = TABLE_TENNIS;
        zzatN[86] = TEAM_SPORTS;
        zzatN[87] = TENNIS;
        zzatN[5] = TILTING;
        zzatN[88] = TREADMILL;
        zzatN[4] = "unknown";
        zzatN[89] = VOLLEYBALL;
        zzatN[90] = VOLLEYBALL_BEACH;
        zzatN[91] = VOLLEYBALL_INDOOR;
        zzatN[92] = WAKEBOARDING;
        zzatN[7] = WALKING;
        zzatN[93] = WALKING_FITNESS;
        zzatN[94] = WALKING_NORDIC;
        zzatN[95] = WALKING_TREADMILL;
        zzatN[116] = WALKING_STROLLER;
        zzatN[96] = WATER_POLO;
        zzatN[97] = WEIGHTLIFTING;
        zzatN[98] = WHEELCHAIR;
        zzatN[99] = WINDSURFING;
        zzatN[100] = YOGA;
        zzatN[Quests.SELECT_COMPLETED_UNCLAIMED] = ZUMBA;
    }

    FitnessActivities() {
    }

    public static String getMimeType(String activity) {
        return MIME_TYPE_PREFIX + activity;
    }

    public static String getName(int activity) {
        if (activity < 0 || activity >= zzatN.length) {
            return "unknown";
        }
        String str = zzatN[activity];
        return str == null ? "unknown" : str;
    }

    public static int zzdd(String str) {
        for (int i = 0; i < zzatN.length; i++) {
            if (zzatN[i].equals(str)) {
                return i;
            }
        }
        return 4;
    }
}
