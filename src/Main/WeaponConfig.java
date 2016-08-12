package Main;

import Attributes.NormalAttribute;

import java.util.Map;
import java.util.Random;

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
    public static final int NORMAL_ATTRIBUTE_CHANCE = 90;
    public static final int ATTRIBUTE_VALUE_MODIFIER = 0;
    public static final int POSITIVE_CHANCE = 65;
    public static final int RARITY_COMMON = 0;
    public static final int RARITY_UNCOMMON = 50;
    public static final int RARITY_RARE = 30;

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

        return new Random().nextInt((max + 1) - min) + min;
    }

    public static boolean isNormalAttribute() {
        return new Random().nextInt(100) <= NORMAL_ATTRIBUTE_CHANCE;
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
            if (new Random().nextInt(100) <= POSITIVE_CHANCE)
                return false;
            else
                return true;
        }
    }

    public static Map<String, Integer> rollBaseStats(Map<String, Integer> stats) {
        return null;
    }
}
