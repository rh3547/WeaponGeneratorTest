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
    }

    // Assault Rifle (30): -3364550138670294764
    // Sniper (30): 4756214015878680209
    private void rollStats() {
        stats = WeaponConfig.rollBaseStats(this);

        addPartAttributeStatBoosts(bodyPart.getAttributes());
        addPartAttributeStatBoosts(stockPart.getAttributes());
        addPartAttributeStatBoosts(sightPart.getAttributes());
        addPartAttributeStatBoosts(magazinePart.getAttributes());
        addPartAttributeStatBoosts(barrelPart.getAttributes());

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
                    stats.setDamage((int)(stats.getDamage() + (stats.getDamage() * (attribute.getValue() / 100))));
                    break;

                case "Accuracy":
                    stats.setAccuracy((int)(stats.getAccuracy() + (stats.getAccuracy() * (attribute.getValue() / 100))));
                    break;

                case "Fire Rate":
                    break;

                case "Magazine Capacity":
                    break;

                case "Reload Speed":
                    break;

                case "Range":
                    break;

                case "Spread":
                    break;

                case "Weight":
                    break;

                case "Penetration":
                    break;

                case "Critical Chance":
                    break;
            }
        }
    }

    private void calculatePartCriticalDamageBoost(List<Attribute> attributes) {
        for (Attribute attribute : attributes) {
            switch(attribute.getName()) {

                case "Critical Damage":
                    break;
            }
        }
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
