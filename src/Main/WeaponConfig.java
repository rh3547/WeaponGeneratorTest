package Main;

import Attributes.NormalAttribute;
import Weapons.Weapon;
import Weapons.WeaponStats;

import java.util.Map;
import java.util.Random;

import static Weapons.WeaponType.*;

/**
 * Created by Ryan Hochmuth on 8/7/2016.
 */
public class WeaponConfig {

    public static final int WEAPON_LEVEL_RANGE = 2;
    public static final int NUM_BODY_PARTS = 18;
    public static final int NUM_STOCK_PARTS = 18;
    public static final int NUM_SIGHT_PARTS = 18;
    public static final int NUM_MAGAZINE_PARTS = 18;
    public static final int NUM_BARREL_PARTS = 18;
    public static final int RARITY_COMMON = 0;
    public static final int RARITY_UNCOMMON = 50;
    public static final int RARITY_RARE = 30;
    public static final int UNIQUE_NAME_PRE = 0;
    public static final int UNIQUE_NAME_POST = 1;
    public static final int UNIQUE_NAME_MID = 2;
    public static final int UNIQUE_NAME_NONE = 3;

    private static final int NORMAL_ATTRIBUTE_CHANCE = 90;
    private static final int ATTRIBUTE_VALUE_MODIFIER = 0;
    private static final int POSITIVE_CHANCE = 65;
    private static final int HEALTH_BASE = 200;
    private static final int HEALTH_GAIN = 25;

    private static final int SNIPER_HITS = 2;
    private static final double SNIPER_ACCURACY_BASE = .9;
    private static final double SNIPER_ACCURACY_GAIN = .0005;
    private static final int SNIPER_ACCURACY_DELTA = 2;

    private static final int SHOTGUN_HITS = 2;
    private static final double SHOTGUN_ACCURACY_BASE = .45;
    private static final double SHOTGUN_ACCURACY_GAIN = .001;
    private static final int SHOTGUN_ACCURACY_DELTA = 5;

    private static final int AR_HITS = 10;
    private static final double AR_ACCURACY_BASE = .8;
    private static final double AR_ACCURACY_GAIN = .0005;
    private static final int AR_ACCURACY_DELTA = 3;

    private static final int LMG_HITS = 10;
    private static final double LMG_ACCURACY_BASE = .65;
    private static final double LMG_ACCURACY_GAIN = .001;
    private static final int LMG_ACCURACY_DELTA = 3;

    private static final int SMG_HITS = 16;
    private static final double SMG_ACCURACY_BASE = .7;
    private static final double SMG_ACCURACY_GAIN = .001;
    private static final int SMG_ACCURACY_DELTA = 1;

    private static final int PISTOL_HITS = 16;
    private static final double PISTOL_ACCURACY_BASE = .8;
    private static final double PISTOL_ACCURACY_GAIN = .0005;
    private static final int PISTOL_ACCURACY_DELTA = 3;

    // Seed Fields
    private static long seed = 1;
    private static boolean useSeed = true;
    private static Random random = new Random();
    private static Random randomSeed = null;

    public static Random getRandom() {
        if (useSeed) return randomSeed;
        else return random;
    }

    public static void updateSeed(long seed) {
        WeaponConfig.seed = seed;
        randomSeed = new Random(seed);
    }

    public static void setUseSeed(boolean value) {
        useSeed = value;
    }

    public static int getLevelBracket(int level) {
        int div = level / 10;

        if (level >= 1 && level <= 10)
            return 1;
        else if (level >= (div * 10) + 1 && level <= (div * 10) + 10)
            return div + 1;
        else if (level % 10 == 0)
            return div;

        return -1;
    }

    public static int getAttributePositiveStepTwo(int base, int level) {
        return base * (getLevelBracket(level) + ATTRIBUTE_VALUE_MODIFIER);
    }

    public static int getAttributeNegativeStepTwo(int base, int level) {
        return base;
    }

    public static int getNumAttributes(int bracket) {
        int min = 0;
        int max = 1;

        switch(bracket) {
            case 1:
                min = 0;
                max = 1;
                break;

            case 2:
                min = 0;
                max = 2;
                break;

            case 3:
                min = 0;
                max = 3;
                break;

            case 4:
                min = 1;
                max = 3;
                break;

            case 5:
                min = 1;
                max = 4;
                break;

            default:
                min = (bracket / 2);
                max = (bracket - 1);
                break;
        }

        return getRandom().nextInt((max + 1) - min) + min;
    }

    public static boolean isNormalAttribute() {
        return getRandom().nextInt(100) <= NORMAL_ATTRIBUTE_CHANCE;
    }

    public static int getAttributeBoost(int bracket) {
        return 0;

//        switch(bracket) {
//            case 1:
//                return 0;
//
//            case 2:
//                return 5;
//
//            case 3:
//                return 10;
//
//            case 4:
//                return 18;
//
//            case 5:
//                return 25;
//
//            default:
//                return (bracket * 5);
//        }
    }

    public static boolean isAttributeNegative(NormalAttribute attr) {
        if (!attr.isNegativeAllowed() && attr.isPositiveAllowed())
            return false;
        else if (attr.isNegativeAllowed() && !attr.isPositiveAllowed())
            return true;
        else {
            if (getRandom().nextInt(100) <= POSITIVE_CHANCE)
                return false;
            else
                return true;
        }
    }

    public static WeaponStats rollBaseStats(Weapon weapon) {

        WeaponStats baseStats = weapon.getStats();
        int level = weapon.getLevel();
        double baseEnemyHealth = (HEALTH_BASE + (HEALTH_GAIN * (level - 1))) + (Math.pow(level, 3)) - 1;

        double damage = 0;
        double accuracy = 0;
        double fireRate = 0;
        double magCapacity = 0;
        double reloadSpeed = 0;
        double range = 0;

        switch(weapon.getType()) {
            case Pistol:
                damage = (int)Math.round(baseEnemyHealth / PISTOL_HITS);
                accuracy = PISTOL_ACCURACY_BASE + ((level - 1) * PISTOL_ACCURACY_GAIN);
                accuracy = accuracy + ((getRandom().nextInt(2 * PISTOL_ACCURACY_DELTA) - PISTOL_ACCURACY_DELTA) / 100.0);
                accuracy = (int)Math.round((accuracy * 100));
                break;

            case SMG:
                damage = (int)Math.round(baseEnemyHealth / SMG_HITS);
                accuracy = SMG_ACCURACY_BASE + ((level - 1) * SMG_ACCURACY_GAIN);
                accuracy = accuracy + ((getRandom().nextInt(2 * SMG_ACCURACY_DELTA) - SMG_ACCURACY_DELTA) / 100.0);
                accuracy = (int)Math.round((accuracy * 100));
                break;

            case Shotgun:
                damage = (int)Math.round(baseEnemyHealth / SHOTGUN_HITS);
                accuracy = SHOTGUN_ACCURACY_BASE + ((level - 1) * SHOTGUN_ACCURACY_GAIN);
                accuracy = accuracy + ((getRandom().nextInt(2 * SHOTGUN_ACCURACY_DELTA) - SHOTGUN_ACCURACY_DELTA) / 100.0);
                accuracy = (int)Math.round((accuracy * 100));
                break;

            case AssaultRifle:
                damage = (int)Math.round(baseEnemyHealth / AR_HITS);
                accuracy = AR_ACCURACY_BASE + ((level - 1) * AR_ACCURACY_GAIN);
                accuracy = accuracy + ((getRandom().nextInt(2 * AR_ACCURACY_DELTA) - AR_ACCURACY_DELTA) / 100.0);
                accuracy = (int)Math.round((accuracy * 100));
                break;

            case LMG:
                damage = (int)Math.round(baseEnemyHealth / LMG_HITS);
                accuracy = LMG_ACCURACY_BASE + ((level - 1) * LMG_ACCURACY_GAIN);
                accuracy = accuracy + ((getRandom().nextInt(2 * LMG_ACCURACY_DELTA) - LMG_ACCURACY_DELTA) / 100.0);
                accuracy = (int)Math.round((accuracy * 100));
                break;

            case Sniper:
                damage = (int)Math.round(baseEnemyHealth / SNIPER_HITS);
                accuracy = SNIPER_ACCURACY_BASE + ((level - 1) * SNIPER_ACCURACY_GAIN);
                accuracy = accuracy + ((getRandom().nextInt(2 * SNIPER_ACCURACY_DELTA) - SNIPER_ACCURACY_DELTA) / 100.0);
                accuracy = (int)Math.round((accuracy * 100));
                break;
        }

        baseStats.setDamage(damage);
        baseStats.setAccuracy(accuracy);

        return baseStats;
    }
}
