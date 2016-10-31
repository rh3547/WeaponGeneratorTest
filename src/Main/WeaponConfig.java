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
    public static final int MAX_CRIT_CHANCE = 60;
    public static final int EPIC_CHANCE = 5;
    public static final int LEGENDARY_CHANCE = 2;
    public static final int GODLY_CHANCE = 1;

    private static final int NORMAL_ATTRIBUTE_CHANCE = 90;
    private static final int ATTRIBUTE_VALUE_MODIFIER = 2;
    private static final int POSITIVE_CHANCE = 65;
    private static final int HEALTH_BASE = 200;
    private static final int HEALTH_GAIN = 25;

    private static final boolean CALCULATE_DELTAS = false;
    private static final int SNIPER_HITS = 2;
    private static final double SNIPER_ACCURACY_BASE = .9;
    private static final double SNIPER_ACCURACY_GAIN = .0005;
    private static final double SNIPER_ACCURACY_DELTA = .02;
    private static final int SNIPER_FIRERATE_BASE = 75;
    private static final double SNIPER_FIRERATE_GAIN = .4;
    private static final int SNIPER_FIRERATE_DELTA = 20;
    private static final int SNIPER_MAGCAP_BASE = 10;
    private static final double SNIPER_MAGCAP_GAIN = .1;
    private static final int SNIPER_MAGCAP_DELTA = 5;
    private static final double SNIPER_RELOAD_BASE = 3.5;
    private static final int SNIPER_RELOAD_GAIN = 0;
    private static final double SNIPER_RELOAD_DELTA = .2;
    private static final int SNIPER_RANGE_BASE = 750;
    private static final int SNIPER_RANGE_GAIN = 0;
    private static final int SNIPER_RANGE_DELTA = 50;
    private static final int SNIPER_SPREAD_BASE = 1;
    private static final int SNIPER_SPREAD_GAIN = 0;
    private static final int SNIPER_SPREAD_DELTA = 0;
    private static final int SNIPER_WEIGHT_BASE = 20;
    private static final double SNIPER_WEIGHT_GAIN = -.05;
    private static final int SNIPER_WEIGHT_DELTA = 2;
    private static final double SNIPER_PENETRATION_BASE = .6;
    private static final double SNIPER_PENETRATION_GAIN = .001;
    private static final double SNIPER_PENETRATION_DELTA = .05;
    private static final double SNIPER_CRITCHANCE_BASE = .08;
    private static final double SNIPER_CRITCHANCE_GAIN = .0005;
    private static final double SNIPER_CRITCHANCE_DELTA = .02;
    private static final double SNIPER_CRITDAMAGE_BASE = .4;
    private static final double SNIPER_CRITDAMAGE_GAIN = .001;
    private static final double SNIPER_CRITDAMAGE_DELTA = .05;

    private static final int SHOTGUN_HITS = 2;
    private static final double SHOTGUN_ACCURACY_BASE = .45;
    private static final double SHOTGUN_ACCURACY_GAIN = .001;
    private static final double SHOTGUN_ACCURACY_DELTA = .05;
    private static final int SHOTGUN_FIRERATE_BASE = 100;
    private static final double SHOTGUN_FIRERATE_GAIN = .5;
    private static final int SHOTGUN_FIRERATE_DELTA = 30;
    private static final int SHOTGUN_MAGCAP_BASE = 10;
    private static final double SHOTGUN_MAGCAP_GAIN = .1;
    private static final int SHOTGUN_MAGCAP_DELTA = 3;
    private static final double SHOTGUN_RELOAD_BASE = 3.7;
    private static final int SHOTGUN_RELOAD_GAIN = 0;
    private static final double SHOTGUN_RELOAD_DELTA = .3;
    private static final int SHOTGUN_RANGE_BASE = 75;
    private static final int SHOTGUN_RANGE_GAIN = 0;
    private static final int SHOTGUN_RANGE_DELTA = 30;
    private static final int SHOTGUN_SPREAD_BASE = 30;
    private static final int SHOTGUN_SPREAD_GAIN = 0;
    private static final int SHOTGUN_SPREAD_DELTA = 15;
    private static final int SHOTGUN_WEIGHT_BASE = 12;
    private static final double SHOTGUN_WEIGHT_GAIN = -.05;
    private static final int SHOTGUN_WEIGHT_DELTA = 2;
    private static final double SHOTGUN_PENETRATION_BASE = .3;
    private static final double SHOTGUN_PENETRATION_GAIN = .001;
    private static final double SHOTGUN_PENETRATION_DELTA = .05;
    private static final double SHOTGUN_CRITCHANCE_BASE = .08;
    private static final double SHOTGUN_CRITCHANCE_GAIN = .0005;
    private static final double SHOTGUN_CRITCHANCE_DELTA = .02;
    private static final double SHOTGUN_CRITDAMAGE_BASE = .18;
    private static final double SHOTGUN_CRITDAMAGE_GAIN = .001;
    private static final double SHOTGUN_CRITDAMAGE_DELTA = .02;

    private static final int AR_HITS = 10;
    private static final double AR_ACCURACY_BASE = .8;
    private static final double AR_ACCURACY_GAIN = .0005;
    private static final double AR_ACCURACY_DELTA = .03;
    private static final int AR_FIRERATE_BASE = 650;
    private static final double AR_FIRERATE_GAIN = .4;
    private static final int AR_FIRERATE_DELTA = 50;
    private static final int AR_MAGCAP_BASE = 30;
    private static final double AR_MAGCAP_GAIN = .15;
    private static final int AR_MAGCAP_DELTA = 5;
    private static final double AR_RELOAD_BASE = 2.4;
    private static final int AR_RELOAD_GAIN = 0;
    private static final double AR_RELOAD_DELTA = .2;
    private static final int AR_RANGE_BASE = 350;
    private static final int AR_RANGE_GAIN = 0;
    private static final int AR_RANGE_DELTA = 50;
    private static final int AR_SPREAD_BASE = 1;
    private static final int AR_SPREAD_GAIN = 0;
    private static final int AR_SPREAD_DELTA = 0;
    private static final int AR_WEIGHT_BASE = 15;
    private static final double AR_WEIGHT_GAIN = -.05;
    private static final int AR_WEIGHT_DELTA = 2;
    private static final double AR_PENETRATION_BASE = .4;
    private static final double AR_PENETRATION_GAIN = .001;
    private static final double AR_PENETRATION_DELTA = .05;
    private static final double AR_CRITCHANCE_BASE = .08;
    private static final double AR_CRITCHANCE_GAIN = .0005;
    private static final double AR_CRITCHANCE_DELTA = .02;
    private static final double AR_CRITDAMAGE_BASE = .3;
    private static final double AR_CRITDAMAGE_GAIN = .001;
    private static final double AR_CRITDAMAGE_DELTA = .05;

    private static final int LMG_HITS = 10;
    private static final double LMG_ACCURACY_BASE = .65;
    private static final double LMG_ACCURACY_GAIN = .001;
    private static final double LMG_ACCURACY_DELTA = .03;
    private static final int LMG_FIRERATE_BASE = 550;
    private static final double LMG_FIRERATE_GAIN = .5;
    private static final int LMG_FIRERATE_DELTA = 50;
    private static final int LMG_MAGCAP_BASE = 55;
    private static final double LMG_MAGCAP_GAIN = .1;
    private static final int LMG_MAGCAP_DELTA = 5;
    private static final double LMG_RELOAD_BASE = 4.5;
    private static final int LMG_RELOAD_GAIN = 0;
    private static final double LMG_RELOAD_DELTA = .3;
    private static final int LMG_RANGE_BASE = 450;
    private static final int LMG_RANGE_GAIN = 0;
    private static final int LMG_RANGE_DELTA = 25;
    private static final int LMG_SPREAD_BASE = 3;
    private static final int LMG_SPREAD_GAIN = 0;
    private static final int LMG_SPREAD_DELTA = 3;
    private static final int LMG_WEIGHT_BASE = 28;
    private static final double LMG_WEIGHT_GAIN = -.05;
    private static final int LMG_WEIGHT_DELTA = 5;
    private static final double LMG_PENETRATION_BASE = .5;
    private static final double LMG_PENETRATION_GAIN = .0005;
    private static final double LMG_PENETRATION_DELTA = .05;
    private static final double LMG_CRITCHANCE_BASE = .08;
    private static final double LMG_CRITCHANCE_GAIN = .0005;
    private static final double LMG_CRITCHANCE_DELTA = .02;
    private static final double LMG_CRITDAMAGE_BASE = .25;
    private static final double LMG_CRITDAMAGE_GAIN = .001;
    private static final double LMG_CRITDAMAGE_DELTA = .02;

    private static final int SMG_HITS = 16;
    private static final double SMG_ACCURACY_BASE = .7;
    private static final double SMG_ACCURACY_GAIN = .001;
    private static final double SMG_ACCURACY_DELTA = .01;
    private static final int SMG_FIRERATE_BASE = 800;
    private static final double SMG_FIRERATE_GAIN = .5;
    private static final int SMG_FIRERATE_DELTA = 50;
    private static final int SMG_MAGCAP_BASE = 30;
    private static final double SMG_MAGCAP_GAIN = .1;
    private static final int SMG_MAGCAP_DELTA = 5;
    private static final double SMG_RELOAD_BASE = 2.4;
    private static final int SMG_RELOAD_GAIN = 0;
    private static final double SMG_RELOAD_DELTA = .2;
    private static final int SMG_RANGE_BASE = 220;
    private static final int SMG_RANGE_GAIN = 0;
    private static final int SMG_RANGE_DELTA = 30;
    private static final int SMG_SPREAD_BASE = 2;
    private static final int SMG_SPREAD_GAIN = 0;
    private static final int SMG_SPREAD_DELTA = 2;
    private static final int SMG_WEIGHT_BASE = 6;
    private static final double SMG_WEIGHT_GAIN = -.02;
    private static final int SMG_WEIGHT_DELTA = 3;
    private static final double SMG_PENETRATION_BASE = .2;
    private static final double SMG_PENETRATION_GAIN = .001;
    private static final double SMG_PENETRATION_DELTA = .05;
    private static final double SMG_CRITCHANCE_BASE = .08;
    private static final double SMG_CRITCHANCE_GAIN = .0005;
    private static final double SMG_CRITCHANCE_DELTA = .02;
    private static final double SMG_CRITDAMAGE_BASE = .25;
    private static final double SMG_CRITDAMAGE_GAIN = .001;
    private static final double SMG_CRITDAMAGE_DELTA = .02;

    private static final int PISTOL_HITS = 16;
    private static final double PISTOL_ACCURACY_BASE = .8;
    private static final double PISTOL_ACCURACY_GAIN = .0005;
    private static final double PISTOL_ACCURACY_DELTA = .03;
    private static final int PISTOL_FIRERATE_BASE = 250;
    private static final double PISTOL_FIRERATE_GAIN = .25;
    private static final int PISTOL_FIRERATE_DELTA = 25;
    private static final int PISTOL_MAGCAP_BASE = 15;
    private static final double PISTOL_MAGCAP_GAIN = .1;
    private static final int PISTOL_MAGCAP_DELTA = 2;
    private static final double PISTOL_RELOAD_BASE = 0;
    private static final int PISTOL_RELOAD_GAIN = 0;
    private static final double PISTOL_RELOAD_DELTA = 0;
    private static final int PISTOL_RANGE_BASE = 100;
    private static final int PISTOL_RANGE_GAIN = 0;
    private static final int PISTOL_RANGE_DELTA = 20;
    private static final int PISTOL_SPREAD_BASE = 1;
    private static final int PISTOL_SPREAD_GAIN = 0;
    private static final int PISTOL_SPREAD_DELTA = 0;
    private static final int PISTOL_WEIGHT_BASE = 4;
    private static final double PISTOL_WEIGHT_GAIN = -.05;
    private static final int PISTOL_WEIGHT_DELTA = 2;
    private static final double PISTOL_PENETRATION_BASE = .2;
    private static final double PISTOL_PENETRATION_GAIN = .001;
    private static final double PISTOL_PENETRATION_DELTA = .05;
    private static final double PISTOL_CRITCHANCE_BASE = .08;
    private static final double PISTOL_CRITCHANCE_GAIN = .0005;
    private static final double PISTOL_CRITCHANCE_DELTA = .02;
    private static final double PISTOL_CRITDAMAGE_BASE = .18;
    private static final double PISTOL_CRITDAMAGE_GAIN = .001;
    private static final double PISTOL_CRITDAMAGE_DELTA = .02;

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

    public static int getAttributePositiveStepTwo(String attrName, int base, int level) {
        if (attrName.equals("Accuracy"))
            return base;

        double newValue = base + ((getLevelBracket(level) - 1) * ATTRIBUTE_VALUE_MODIFIER);

        return newValue < base ? base : (int)Math.round(newValue);
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
        double spread = 0;
        double weight = 0;
        double penetration = 0;
        double critChance = 0;
        double critDamage = 0;

        switch(weapon.getType()) {
            case Pistol:
                damage = (int)Math.round(baseEnemyHealth / PISTOL_HITS);

                accuracy = calculateBaseStat(level, PISTOL_ACCURACY_BASE, PISTOL_ACCURACY_GAIN, PISTOL_ACCURACY_DELTA, true, true);
                accuracy = (int)Math.round((accuracy * 100));

                fireRate = calculateBaseStat(level, PISTOL_FIRERATE_BASE, PISTOL_FIRERATE_GAIN, PISTOL_FIRERATE_DELTA, false, false);
                fireRate = (int)Math.round(fireRate);

                magCapacity = calculateBaseStat(level, PISTOL_MAGCAP_BASE, PISTOL_MAGCAP_GAIN, PISTOL_MAGCAP_DELTA, false, false);
                magCapacity = (int)Math.round(magCapacity);

                reloadSpeed = calculateBaseStat(level, PISTOL_RELOAD_BASE, PISTOL_RELOAD_GAIN, PISTOL_RELOAD_DELTA, true, false);

                range = calculateBaseStat(level, PISTOL_RANGE_BASE, PISTOL_RANGE_GAIN, PISTOL_RANGE_DELTA, false, false);
                range = (int)Math.round(range);

                spread = calculateBaseStat(level, PISTOL_SPREAD_BASE, PISTOL_SPREAD_GAIN, PISTOL_SPREAD_DELTA, false, false);
                spread = (int)Math.round(spread);

                weight = calculateBaseStat(level, PISTOL_WEIGHT_BASE, PISTOL_WEIGHT_GAIN, PISTOL_WEIGHT_DELTA, false, false);

                penetration = calculateBaseStat(level, PISTOL_PENETRATION_BASE, PISTOL_PENETRATION_GAIN, PISTOL_PENETRATION_DELTA, true, true);
                penetration = (int)Math.round((penetration * 100));

                critChance = calculateBaseStat(level, PISTOL_CRITCHANCE_BASE, PISTOL_CRITCHANCE_GAIN, PISTOL_CRITCHANCE_DELTA, true, true);
                critChance = (int)Math.round((critChance * 100));

                critDamage = calculateBaseStat(level, PISTOL_CRITDAMAGE_BASE, PISTOL_CRITDAMAGE_GAIN, PISTOL_CRITDAMAGE_DELTA, true, true);
                critDamage = (int)Math.round((critDamage * 100));
                break;

            case SMG:
                damage = (int)Math.round(baseEnemyHealth / SMG_HITS);

                accuracy = calculateBaseStat(level, SMG_ACCURACY_BASE, SMG_ACCURACY_GAIN, SMG_ACCURACY_DELTA, true, true);
                accuracy = (int)Math.round((accuracy * 100));

                fireRate = calculateBaseStat(level, SMG_FIRERATE_BASE, SMG_FIRERATE_GAIN, SMG_FIRERATE_DELTA, false, false);
                fireRate = (int)Math.round(fireRate);

                magCapacity = calculateBaseStat(level, SMG_MAGCAP_BASE, SMG_MAGCAP_GAIN, SMG_MAGCAP_DELTA, false, false);
                magCapacity = (int)Math.round(magCapacity);

                reloadSpeed = calculateBaseStat(level, SMG_RELOAD_BASE, SMG_RELOAD_GAIN, SMG_RELOAD_DELTA, true, false);

                range = calculateBaseStat(level, SMG_RANGE_BASE, SMG_RANGE_GAIN, SMG_RANGE_DELTA, false, false);
                range = (int)Math.round(range);

                spread = calculateBaseStat(level, SMG_SPREAD_BASE, SMG_SPREAD_GAIN, SMG_SPREAD_DELTA, false, false);
                spread = (int)Math.round(spread);

                weight = calculateBaseStat(level, SMG_WEIGHT_BASE, SMG_WEIGHT_GAIN, SMG_WEIGHT_DELTA, false, false);

                penetration = calculateBaseStat(level, SMG_PENETRATION_BASE, SMG_PENETRATION_GAIN, SMG_PENETRATION_DELTA, true, true);
                penetration = (int)Math.round((penetration * 100));

                critChance = calculateBaseStat(level, SMG_CRITCHANCE_BASE, SMG_CRITCHANCE_GAIN, SMG_CRITCHANCE_DELTA, true, true);
                critChance = (int)Math.round((critChance * 100));

                critDamage = calculateBaseStat(level, SMG_CRITDAMAGE_BASE, SMG_CRITDAMAGE_GAIN, SMG_CRITDAMAGE_DELTA, true, true);
                critDamage = (int)Math.round((critDamage * 100));
                break;

            case Shotgun:
                damage = (int)Math.round(baseEnemyHealth / SHOTGUN_HITS);

                accuracy = calculateBaseStat(level, SHOTGUN_ACCURACY_BASE, SHOTGUN_ACCURACY_GAIN, SHOTGUN_ACCURACY_DELTA, true, true);
                accuracy = (int)Math.round((accuracy * 100));

                fireRate = calculateBaseStat(level, SHOTGUN_FIRERATE_BASE, SHOTGUN_FIRERATE_GAIN, SHOTGUN_FIRERATE_DELTA, false, false);
                fireRate = (int)Math.round(fireRate);

                magCapacity = calculateBaseStat(level, SHOTGUN_MAGCAP_BASE, SHOTGUN_MAGCAP_GAIN, SHOTGUN_MAGCAP_DELTA, false, false);
                magCapacity = (int)Math.round(magCapacity);

                reloadSpeed = calculateBaseStat(level, SHOTGUN_RELOAD_BASE, SHOTGUN_RELOAD_GAIN, SHOTGUN_RELOAD_DELTA, true, false);

                range = calculateBaseStat(level, SHOTGUN_RANGE_BASE, SHOTGUN_RANGE_GAIN, SHOTGUN_RANGE_DELTA, false, false);
                range = (int)Math.round(range);

                spread = calculateBaseStat(level, SHOTGUN_SPREAD_BASE, SHOTGUN_SPREAD_GAIN, SHOTGUN_SPREAD_DELTA, false, false);
                spread = (int)Math.round(spread);

                weight = calculateBaseStat(level, SHOTGUN_WEIGHT_BASE, SHOTGUN_WEIGHT_GAIN, SHOTGUN_WEIGHT_DELTA, false, false);

                penetration = calculateBaseStat(level, SHOTGUN_PENETRATION_BASE, SHOTGUN_PENETRATION_GAIN, SHOTGUN_PENETRATION_DELTA, true, true);
                penetration = (int)Math.round((penetration * 100));

                critChance = calculateBaseStat(level, SHOTGUN_CRITCHANCE_BASE, SHOTGUN_CRITCHANCE_GAIN, SHOTGUN_CRITCHANCE_DELTA, true, true);
                critChance = (int)Math.round((critChance * 100));

                critDamage = calculateBaseStat(level, SHOTGUN_CRITDAMAGE_BASE, SHOTGUN_CRITDAMAGE_GAIN, SHOTGUN_CRITDAMAGE_DELTA, true, true);
                critDamage = (int)Math.round((critDamage * 100));
                break;

            case AssaultRifle:
                damage = (int)Math.round(baseEnemyHealth / AR_HITS);

                accuracy = calculateBaseStat(level, AR_ACCURACY_BASE, AR_ACCURACY_GAIN, AR_ACCURACY_DELTA, true, true);
                accuracy = (int)Math.round((accuracy * 100));

                fireRate = calculateBaseStat(level, AR_FIRERATE_BASE, AR_FIRERATE_GAIN, AR_FIRERATE_DELTA, false, false);
                fireRate = (int)Math.round(fireRate);

                magCapacity = calculateBaseStat(level, AR_MAGCAP_BASE, AR_MAGCAP_GAIN, AR_MAGCAP_DELTA, false, false);
                magCapacity = (int)Math.round(magCapacity);

                reloadSpeed = calculateBaseStat(level, AR_RELOAD_BASE, AR_RELOAD_GAIN, AR_RELOAD_DELTA, true, false);

                range = calculateBaseStat(level, AR_RANGE_BASE, AR_RANGE_GAIN, AR_RANGE_DELTA, false, false);
                range = (int)Math.round(range);

                spread = calculateBaseStat(level, AR_SPREAD_BASE, AR_SPREAD_GAIN, AR_SPREAD_DELTA, false, false);
                spread = (int)Math.round(spread);

                weight = calculateBaseStat(level, AR_WEIGHT_BASE, AR_WEIGHT_GAIN, AR_WEIGHT_DELTA, false, false);

                penetration = calculateBaseStat(level, AR_PENETRATION_BASE, AR_PENETRATION_GAIN, AR_PENETRATION_DELTA, true, true);
                penetration = (int)Math.round((penetration * 100));

                critChance = calculateBaseStat(level, AR_CRITCHANCE_BASE, AR_CRITCHANCE_GAIN, AR_CRITCHANCE_DELTA, true, true);
                critChance = (int)Math.round((critChance * 100));

                critDamage = calculateBaseStat(level, AR_CRITDAMAGE_BASE, AR_CRITDAMAGE_GAIN, AR_CRITDAMAGE_DELTA, true, true);
                critDamage = (int)Math.round((critDamage * 100));
                break;

            case LMG:
                damage = (int)Math.round(baseEnemyHealth / LMG_HITS);

                accuracy = calculateBaseStat(level, LMG_ACCURACY_BASE, LMG_ACCURACY_GAIN, LMG_ACCURACY_DELTA, true, true);
                accuracy = (int)Math.round((accuracy * 100));

                fireRate = calculateBaseStat(level, LMG_FIRERATE_BASE, LMG_FIRERATE_GAIN, LMG_FIRERATE_DELTA, false, false);
                fireRate = (int)Math.round(fireRate);

                magCapacity = calculateBaseStat(level, LMG_MAGCAP_BASE, LMG_MAGCAP_GAIN, LMG_MAGCAP_DELTA, false, false);
                magCapacity = (int)Math.round(magCapacity);

                reloadSpeed = calculateBaseStat(level, LMG_RELOAD_BASE, LMG_RELOAD_GAIN, LMG_RELOAD_DELTA, true, false);

                range = calculateBaseStat(level, LMG_RANGE_BASE, LMG_RANGE_GAIN, LMG_RANGE_DELTA, false, false);
                range = (int)Math.round(range);

                spread = calculateBaseStat(level, LMG_SPREAD_BASE, LMG_SPREAD_GAIN, LMG_SPREAD_DELTA, false, false);
                spread = (int)Math.round(spread);

                weight = calculateBaseStat(level, LMG_WEIGHT_BASE, LMG_WEIGHT_GAIN, LMG_WEIGHT_DELTA, false, false);

                penetration = calculateBaseStat(level, LMG_PENETRATION_BASE, LMG_PENETRATION_GAIN, LMG_PENETRATION_DELTA, true, true);
                penetration = (int)Math.round((penetration * 100));

                critChance = calculateBaseStat(level, LMG_CRITCHANCE_BASE, LMG_CRITCHANCE_GAIN, LMG_CRITCHANCE_DELTA, true, true);
                critChance = (int)Math.round((critChance * 100));

                critDamage = calculateBaseStat(level, LMG_CRITDAMAGE_BASE, LMG_CRITDAMAGE_GAIN, LMG_CRITDAMAGE_DELTA, true, true);
                critDamage = (int)Math.round((critDamage * 100));
                break;

            case Sniper:
                damage = (int)Math.round(baseEnemyHealth / SNIPER_HITS);

                accuracy = calculateBaseStat(level, SNIPER_ACCURACY_BASE, SNIPER_ACCURACY_GAIN, SNIPER_ACCURACY_DELTA, true, true);
                accuracy = (int)Math.round((accuracy * 100));

                fireRate = calculateBaseStat(level, SNIPER_FIRERATE_BASE, SNIPER_FIRERATE_GAIN, SNIPER_FIRERATE_DELTA, false, false);
                fireRate = (int)Math.round(fireRate);

                magCapacity = calculateBaseStat(level, SNIPER_MAGCAP_BASE, SNIPER_MAGCAP_GAIN, SNIPER_MAGCAP_DELTA, false, false);
                magCapacity = (int)Math.round(magCapacity);

                reloadSpeed = calculateBaseStat(level, SNIPER_RELOAD_BASE, SNIPER_RELOAD_GAIN, SNIPER_RELOAD_DELTA, true, false);

                range = calculateBaseStat(level, SNIPER_RANGE_BASE, SNIPER_RANGE_GAIN, SNIPER_RANGE_DELTA, false, false);
                range = (int)Math.round(range);

                spread = calculateBaseStat(level, SNIPER_SPREAD_BASE, SNIPER_SPREAD_GAIN, SNIPER_SPREAD_DELTA, false, false);
                spread = (int)Math.round(spread);

                weight = calculateBaseStat(level, SNIPER_WEIGHT_BASE, SNIPER_WEIGHT_GAIN, SNIPER_WEIGHT_DELTA, false, false);

                penetration = calculateBaseStat(level, SNIPER_PENETRATION_BASE, SNIPER_PENETRATION_GAIN, SNIPER_PENETRATION_DELTA, true, true);
                penetration = (int)Math.round((penetration * 100));

                critChance = calculateBaseStat(level, SNIPER_CRITCHANCE_BASE, SNIPER_CRITCHANCE_GAIN, SNIPER_CRITCHANCE_DELTA, true, true);
                critChance = (int)Math.round((critChance * 100));

                critDamage = calculateBaseStat(level, SNIPER_CRITDAMAGE_BASE, SNIPER_CRITDAMAGE_GAIN, SNIPER_CRITDAMAGE_DELTA, true, true);
                critDamage = (int)Math.round((critDamage * 100));
                break;
        }

        baseStats.setDamage(damage);
        baseStats.setAccuracy(accuracy);
        baseStats.setFireRate(fireRate);
        baseStats.setMagCapacity(magCapacity);
        baseStats.setReloadSpeed(reloadSpeed);
        baseStats.setRange(range);
        baseStats.setSpread(spread);
        baseStats.setWeight(weight);
        baseStats.setPenetration(penetration);
        baseStats.setCriticalChance(critChance);
        baseStats.setCriticalDamage(critDamage);

        return baseStats;
    }

    private static double calculateBaseStat(int level, double base, double gain, double delta, boolean decimalDelta, boolean percent) {
        double stat;

        stat = base + ((level - 1) * gain);

        if (CALCULATE_DELTAS) {
            if (delta <= 0)
                return stat;

            if (decimalDelta) {
                if (percent) {
                    int newDelta = (int) (delta * 100);
                    stat = stat + ((getRandom().nextInt(2 * newDelta) - newDelta) / 100.0);
                } else {
                    int newDelta = (int) (delta * 10);
                    stat = stat + ((getRandom().nextInt(2 * newDelta) - newDelta) / 10.0);
                }
            } else {
                int newDelta = (int) delta;
                stat = stat + ((getRandom().nextInt(2 * newDelta) - newDelta));
            }
        }

        return stat;
    }
}
