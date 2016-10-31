package Weapons;

import Attributes.Attribute;
import Attributes.UniqueAttribute;
import Main.WeaponConfig;
import Parts.*;

import java.security.KeyStore;
import java.util.*;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class Weapon {
    private String mainNames = "";
    private String preNames = "";
    private String postNames = "";
    private int level = 1;
    private WeaponType type;
    private BodyPart bodyPart;
    private StockPart stockPart;
    private SightPart sightPart;
    private MagazinePart magazinePart;
    private BarrelPart barrelPart;
    private WeaponStats stats = new WeaponStats();

    public Weapon(int level) {
        this.level = generateWeaponLevel(level);
    }

    private int generateWeaponLevel(int level) {
        int range = WeaponConfig.WEAPON_LEVEL_RANGE;

        if (level > range) {
            Random rand = WeaponConfig.getRandom();
            int num = rand.nextInt(5) - range;

            return level + num;
        }
        else
            return level;
    }

    public void generateWeapon(boolean generateName) {
        Random rand = WeaponConfig.getRandom();

        PartModel bodyModel = PartHandler.instance.getBodyPart(rand.nextInt(WeaponConfig.NUM_BODY_PARTS));
        PartModel stockModel = PartHandler.instance.getStockPart(rand.nextInt(WeaponConfig.NUM_STOCK_PARTS));
        PartModel sightModel = PartHandler.instance.getSightPart(rand.nextInt(WeaponConfig.NUM_SIGHT_PARTS));
        PartModel magazineModel = PartHandler.instance.getMagazinePart(rand.nextInt(WeaponConfig.NUM_MAGAZINE_PARTS));
        PartModel barrelModel = PartHandler.instance.getBarrelPart(rand.nextInt(WeaponConfig.NUM_BARREL_PARTS));

        type = bodyModel.getType();

        BodyPart body = new BodyPart(bodyModel.getName(), level, bodyModel, bodyModel.getType());
        body.generateAttributes();
        StockPart stock = new StockPart(stockModel.getName(), level, stockModel);
        stock.generateAttributes();
        SightPart sight = new SightPart(sightModel.getName(), level, sightModel);
        sight.generateAttributes();
        MagazinePart magazine = new MagazinePart(magazineModel.getName(), level, magazineModel);
        magazine.generateAttributes();
        BarrelPart barrel = new BarrelPart(barrelModel.getName(), level, barrelModel);
        barrel.generateAttributes();

        switch(type) {
            case Pistol:
                addMainName("Pistol");
                break;

            case SMG:
                addMainName("SMG");
                break;

            case Shotgun:
                addMainName("Shotgun");
                break;

            case AssaultRifle:
                addMainName("Assault Rifle");
                break;

            case LMG:
                addMainName("LMG");
                break;

            case Sniper:
                addMainName("Sniper");
                break;
        }

        bodyPart = body;
        stockPart = stock;
        sightPart = sight;
        magazinePart = magazine;
        barrelPart = barrel;

        determineNames();
        rollStats();
        rollEpic();
    }

    // Sniper (30): 4756214015878680209
    // LMG (30): -752195636100200995
    // Assault Rifle (30): -3364550138670294764
    // SMG (30: -658748952693826620
    // Pistol (30): 1257008339778747470
    private void rollStats() {
        stats = WeaponConfig.rollBaseStats(this);

        addPartAttributeStatBoosts(bodyPart.getAttributes());
        addPartAttributeStatBoosts(stockPart.getAttributes());
        addPartAttributeStatBoosts(sightPart.getAttributes());
        addPartAttributeStatBoosts(magazinePart.getAttributes());
        addPartAttributeStatBoosts(barrelPart.getAttributes());

        calculateAttributeStatBoosts();

        calculatePartCriticalDamageBoost(bodyPart.getAttributes());
        calculatePartCriticalDamageBoost(stockPart.getAttributes());
        calculatePartCriticalDamageBoost(sightPart.getAttributes());
        calculatePartCriticalDamageBoost(magazinePart.getAttributes());
        calculatePartCriticalDamageBoost(barrelPart.getAttributes());
    }

    private void addPartAttributeStatBoosts(List<Attribute> attributes) {
        for (Attribute attribute : attributes) {
            switch(attribute.getName()) {

                case "Damage":
                    stats.addDamageBoost(attribute.getValue());
                    break;

                case "Accuracy":
                    stats.addAccuracyBoost(attribute.getValue());
                    break;

                case "Fire Rate":
                    stats.addFireRateBoost(attribute.getValue());
                    break;

                case "Magazine Capacity":
                    stats.addMagCapacityBoost(attribute.getValue());
                    break;

                case "Reload Speed":
                    stats.addReloadSpeedBoost(attribute.getValue());
                    break;

                case "Range":
                    stats.addRangeBoost(attribute.getValue());
                    break;

                case "Spread":
                    stats.addSpreadBoost(attribute.getValue());
                    break;

                case "Weight":
                    stats.addWeightBoost(attribute.getValue());
                    break;

                case "Penetration":
                    stats.addPenetrationBoost(attribute.getValue());
                    break;

                case "Critical Chance":
                    stats.addCriticalChanceBoost(attribute.getValue());
                    break;

                case "Critical Damage":
                    stats.addCriticalDamageBoost(attribute.getValue());
                    break;
            }
        }
    }

    private void calculateAttributeStatBoosts() {
        stats.setDamage((int)Math.round(calculateSingleAttributeStatBoost(stats.getDamage(), stats.getDamageBoost(), false)));

        int accuracy = (int)Math.round(calculateSingleAttributeStatBoost(stats.getAccuracy(), stats.getAccuracyBoost(), false));
        stats.setAccuracy(accuracy > 100 ? 100 : accuracy);

        stats.setFireRate((int)Math.round(calculateSingleAttributeStatBoost(stats.getFireRate(), stats.getFireRateBoost(), false)));
        stats.setMagCapacity((int)Math.round(calculateSingleAttributeStatBoost(stats.getMagCapacity(), stats.getMagCapacityBoost(), false)));
        stats.setReloadSpeed(calculateSingleAttributeStatBoost(stats.getReloadSpeed(), stats.getReloadSpeedBoost(), true));
        stats.setRange((int)Math.round(calculateSingleAttributeStatBoost(stats.getRange(), stats.getRangeBoost(), false)));
        stats.setSpread((int)Math.round(calculateSingleAttributeStatBoost(stats.getSpread(), stats.getSpreadBoost(), false)));
        stats.setWeight(calculateSingleAttributeStatBoost(stats.getWeight(), stats.getWeightBoost(), false));

        int penetration = (int)Math.round(calculateSingleAttributeStatBoost(stats.getPenetration(), stats.getPenetrationBoost(), false));
        stats.setPenetration(penetration);

        int critChance = (int)Math.ceil(calculateSingleAttributeStatBoost(stats.getCriticalChance(), stats.getCriticalChanceBoost(), false));
        stats.setCriticalChance(critChance > WeaponConfig.MAX_CRIT_CHANCE ? WeaponConfig.MAX_CRIT_CHANCE : critChance);

        int critDamage = (int)Math.round(calculateSingleAttributeStatBoost(stats.getCriticalDamage(), stats.getCriticalDamageBoost(), false));
        stats.setCriticalDamage(critDamage);
    }

    private double calculateSingleAttributeStatBoost(double currentValue, double boost, boolean negate) {
        double newValue;

        if (negate) {
            newValue = currentValue - (currentValue * (boost / 100));
        }
        else {
            newValue = currentValue + (currentValue * (boost / 100));
        }

        if (newValue < 0) newValue = 0;

        return newValue;
    }

    private void calculatePartCriticalDamageBoost(List<Attribute> attributes) {

    }

    private void rollEpic() {
        int roll = WeaponConfig.getRandom().nextInt(100);

        if (roll <= WeaponConfig.GODLY_CHANCE) {
            boostAllStats(15);
            this.preNames = "Godly " + preNames;
        }
        else if (roll <= WeaponConfig.LEGENDARY_CHANCE) {
            boostAllStats(10);
            this.preNames = "Legendary " + preNames;
        }
        else if (roll <= WeaponConfig.EPIC_CHANCE) {
            boostAllStats(5);
            this.preNames = "Epic " + preNames;
        }
    }

    private void boostAllStats(int boost) {
        stats.setDamage((int)Math.round(calculateSingleAttributeStatBoost(stats.getDamage(), boost, false)));

        int accuracy = (int)Math.round(calculateSingleAttributeStatBoost(stats.getAccuracy(), boost, false));
        stats.setAccuracy(accuracy > 100 ? 100 : accuracy);

        stats.setFireRate((int)Math.round(calculateSingleAttributeStatBoost(stats.getFireRate(), boost, false)));
        stats.setMagCapacity((int)Math.round(calculateSingleAttributeStatBoost(stats.getMagCapacity(), boost, false)));
        stats.setReloadSpeed(calculateSingleAttributeStatBoost(stats.getReloadSpeed(), boost, true));
        stats.setRange((int)Math.round(calculateSingleAttributeStatBoost(stats.getRange(), boost, false)));
        stats.setSpread((int)Math.round(calculateSingleAttributeStatBoost(stats.getSpread(), boost, false)));
        stats.setWeight(calculateSingleAttributeStatBoost(stats.getWeight(), -boost, false));

        int penetration = (int)Math.round(calculateSingleAttributeStatBoost(stats.getPenetration(), boost, false));
        stats.setPenetration(penetration);

        int critChance = (int)Math.ceil(calculateSingleAttributeStatBoost(stats.getCriticalChance(), boost, false));
        stats.setCriticalChance(critChance > WeaponConfig.MAX_CRIT_CHANCE ? WeaponConfig.MAX_CRIT_CHANCE : critChance);

        int critDamage = (int)Math.round(calculateSingleAttributeStatBoost(stats.getCriticalDamage(), boost, false));
        stats.setCriticalDamage(critDamage);
    }

    private void determineNames() {
        List<UniqueAttribute> attributeList = new ArrayList<>();

        for (Attribute attr : bodyPart.getAttributes()) {
            if (attr instanceof UniqueAttribute)
                attributeList.add((UniqueAttribute)attr);
        }

        for (Attribute attr : stockPart.getAttributes()) {
            if (attr instanceof UniqueAttribute)
                attributeList.add((UniqueAttribute)attr);
        }

        for (Attribute attr : sightPart.getAttributes()) {
            if (attr instanceof UniqueAttribute)
                attributeList.add((UniqueAttribute)attr);
        }

        for (Attribute attr : magazinePart.getAttributes()) {
            if (attr instanceof UniqueAttribute)
                attributeList.add((UniqueAttribute)attr);
        }

        for (Attribute attr : barrelPart.getAttributes()) {
            if (attr instanceof UniqueAttribute)
                attributeList.add((UniqueAttribute)attr);
        }

        Collections.sort(attributeList, new Comparator<UniqueAttribute>() {
            @Override
            public int compare(UniqueAttribute o1, UniqueAttribute o2) {
                if (o1.getRarity() > o2.getRarity())
                    return 1;
                else if (o1.getRarity() < o2.getRarity())
                    return -1;

                return 0;
            }
        });

        int numPreNames = 0;
        int maxPreNames = 2;
        int numMidNames = 0;
        int maxMidNames = 1;
        int numPostNames = 0;
        int maxPostNames = 1;

        for (UniqueAttribute attr : attributeList) {
            switch(attr.getNameType()) {
                case WeaponConfig.UNIQUE_NAME_NONE:
                    break;

                case WeaponConfig.UNIQUE_NAME_PRE:
                    if (numPreNames < maxPreNames) {
                        addPreName(attr.getName());
                        numPreNames++;
                    }
                    break;

                case WeaponConfig.UNIQUE_NAME_MID:
                    if (numMidNames < maxMidNames) {
                        addMainName(attr.getName());
                        numMidNames++;
                    }
                    break;

                case WeaponConfig.UNIQUE_NAME_POST:
                    if (numPostNames < maxPostNames) {
                        addPostName(attr.getName());
                        numPostNames++;
                    }
                    break;

                default:
                    break;
            }
        }
    }

    public String getName() {
        if (preNames.equals("") && postNames.equals(""))
            return mainNames;
        else if (preNames.equals("") && !postNames.equals(""))
            return mainNames + " " + postNames;
        else if (!preNames.equals("") && postNames.equals(""))
            return preNames + " " + mainNames;
        else
            return preNames + " " + mainNames + " " + postNames;
    }

    public void addPreName(String name) {
        if (preNames.equals(""))
            preNames = name;
        else
            preNames += " " + name;
    }

    public void addMainName(String name) {
        if (mainNames.equals(""))
            mainNames = name;
        else
            mainNames = name + " " + mainNames;
    }

    public void addPostName(String name) {
        if (postNames.equals(""))
            postNames = "of " + name;
        else
            postNames += " " + name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public StockPart getStockPart() {
        return stockPart;
    }

    public SightPart getSightPart() {
        return sightPart;
    }

    public MagazinePart getMagazinePart() {
        return magazinePart;
    }

    public BarrelPart getBarrelPart() {
        return barrelPart;
    }

    public WeaponStats getStats() {
        return stats;
    }
}
