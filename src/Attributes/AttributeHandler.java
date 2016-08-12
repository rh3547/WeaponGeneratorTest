package Attributes;

import Main.WeaponConfig;

import java.util.*;

/**
 * Created by Ryan Hochmuth on 8/7/2016.
 */
public class AttributeHandler {
    public static AttributeHandler instance = new AttributeHandler();

    private Map<String, NormalAttribute> bodyNormalAttributes = new HashMap<>();
    private Map<String, UniqueAttribute> bodyUniqueAttributes = new HashMap<>();
    private Map<String, NormalAttribute> stockNormalAttributes = new HashMap<>();
    private Map<String, UniqueAttribute> stockUniqueAttributes = new HashMap<>();
    private Map<String, NormalAttribute> sightNormalAttributes = new HashMap<>();
    private Map<String, UniqueAttribute> sightUniqueAttributes = new HashMap<>();
    private Map<String, NormalAttribute> magazineNormalAttributes = new HashMap<>();
    private Map<String, UniqueAttribute> magazineUniqueAttributes = new HashMap<>();
    private Map<String, NormalAttribute> barrelNormalAttributes = new HashMap<>();
    private Map<String, UniqueAttribute> barrelUniqueAttributes = new HashMap<>();

    private AttributeHandler() {
        addBodyAttributes();
        addStockAttributes();
        addSightAttributes();
        addMagazineAttributes();
        addBarrelAttributes();
    }

    private void addBodyAttributes() {
        bodyNormalAttributes.put("damage", new NormalAttribute("Damage", "Determines the amount of damage your shots do", 3, 10, 5, 50, true, true));
        bodyNormalAttributes.put("criticalDamage", new NormalAttribute("Critical Damage", "Determines the damage of a critical hit", 3, 10, 3, 25, true, true));
        bodyNormalAttributes.put("fireRate", new NormalAttribute("Fire Rate", "Determines the rate at which the weapon fires", 3, 10, 10, 60, true, true));
        bodyNormalAttributes.put("weight", new NormalAttribute("Weight", "Determines the weight of the weapon, affecting the speed of the player", 3,15, 10, 25, true, true));

        bodyUniqueAttributes.put("accelerated", new UniqueAttribute("Accelerated", "The first half of your magazine shoots x% faster", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));
        bodyUniqueAttributes.put("wildcard", new UniqueAttribute("Wildcard", "A stat multiplier on the body is doubled, but another random stat is halved", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_NONE));
        bodyUniqueAttributes.put("anchored", new UniqueAttribute("Anchored", "This weapon is really heavy and will slow the player down, but will increase your accuracy by 50%", WeaponConfig.RARITY_COMMON, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> singleShotExceptions = new ArrayList<>(); singleShotExceptions.add("Burst"); singleShotExceptions.add("Automatic");
        bodyUniqueAttributes.put("singleShot", new UniqueAttribute("Single-Shot", "This weapon fires one shot at a time", WeaponConfig.RARITY_COMMON, singleShotExceptions, WeaponConfig.UNIQUE_NAME_MID));

        List<String> burstExceptions = new ArrayList<>(); burstExceptions.add("Single-Shot"); burstExceptions.add("Automatic");
        bodyUniqueAttributes.put("burst", new UniqueAttribute("Burst", "This weapon fires in short bursts", WeaponConfig.RARITY_UNCOMMON, burstExceptions, WeaponConfig.UNIQUE_NAME_MID));

        List<String> automaticExceptions = new ArrayList<>(); automaticExceptions.add("Single-Shot"); automaticExceptions.add("Burst");
        bodyUniqueAttributes.put("automatic", new UniqueAttribute("Automatic", "This weapon fires fully automatic", WeaponConfig.RARITY_COMMON, automaticExceptions, WeaponConfig.UNIQUE_NAME_MID));
        bodyUniqueAttributes.put("measured", new UniqueAttribute("Measured", "The fire rate of this weapon is reduced by 40% but weapon damage is increased by 40%", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));

        // Baked, put in here for now
        bodyUniqueAttributes.put("energetic", new UniqueAttribute("Energetic", "Each shot fired by this weapon charges the weapon.  Once it is fully charged, the next shot will release a beam of compressed energy in the direction you’re aiming", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_PRE));
    }

    private void addStockAttributes() {
        stockNormalAttributes.put("accuracy", new NormalAttribute("Accuracy", "Determines the likeliness of your shots hitting where you’re aiming", 2, 10, 10, 50, true, false));
        stockNormalAttributes.put("criticalChance", new NormalAttribute("Critical Chance", "Determines the chance that your shot will deal critical damage", 1, 5, 3, 15, true, true));
        stockNormalAttributes.put("criticalDamage", new NormalAttribute("Critical Damage", "Determines the damage of a critical hit", 3, 10, 5, 40, true, false));

        List<String> overheatedExceptions = new ArrayList<>(); overheatedExceptions.add("Unstable");
        stockUniqueAttributes.put("overheated", new UniqueAttribute("Overheated", "Accuracy decreases as you fire", WeaponConfig.RARITY_COMMON, overheatedExceptions, WeaponConfig.UNIQUE_NAME_PRE));
        stockUniqueAttributes.put("cushioned", new UniqueAttribute("Cushioned", "Every other shot has increased accuracy by x%", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> unstableExceptions = new ArrayList<>(); unstableExceptions.add("Overheated");
        stockUniqueAttributes.put("unstable", new UniqueAttribute("Unstable", "This weapon will have random spurts of low or high accuracy", WeaponConfig.RARITY_UNCOMMON, unstableExceptions, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> stimulatingExceptions = new ArrayList<>(); stimulatingExceptions.add("Over-Stimulating");
        stockUniqueAttributes.put("stimulating", new UniqueAttribute("Stimulating", "x% chance that a shot fired with this weapon will restore x% of the player’s shield", WeaponConfig.RARITY_UNCOMMON, stimulatingExceptions, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> overStimulatingExceptions = new ArrayList<>(); overStimulatingExceptions.add("Stimulating");
        stockUniqueAttributes.put("overStimulating", new UniqueAttribute("Over-Stimulating", "x% chance that a shot fired with this weapon will restore x% of the player’s shield.  If the shield is full, this can add to generating an overshield of up to half of the player’s total shield capacity", WeaponConfig.RARITY_RARE, overStimulatingExceptions, WeaponConfig.UNIQUE_NAME_PRE));
    }

    private void addSightAttributes() {
        sightNormalAttributes.put("penetration", new NormalAttribute("Penetration", "Determines the damage penalty for penetration shots", 5, 15, 10, 50, true, true));
        sightNormalAttributes.put("criticalChance", new NormalAttribute("Critical Chance", "Determines the chance that your shot will deal critical damage", 1, 5, 3, 15, true, false));
        sightNormalAttributes.put("accuracy", new NormalAttribute("Accuracy", "Determines the likeliness of your shots hitting where you’re aiming", 5, 15, 10, 30, true, true));

        sightUniqueAttributes.put("penetrating", new UniqueAttribute("Penetration", "Shots fired with this weapon have x% chance to penetrate what they hit", WeaponConfig.RARITY_COMMON, WeaponConfig.UNIQUE_NAME_POST));
        sightUniqueAttributes.put("oneShot", new UniqueAttribute("One-Shot", "The first shot after a fresh reload has 100% accuracy", WeaponConfig.RARITY_COMMON, WeaponConfig.UNIQUE_NAME_PRE));
        sightUniqueAttributes.put("analytical", new UniqueAttribute("Analytical", "Waiting x seconds after taking a shot with this weapon will cause the next shot to have critical chance increased by x%", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));
        sightUniqueAttributes.put("tracking", new UniqueAttribute("Tracking", "x% chance for your shot to lock onto an enemy and home to them", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_PRE));
        sightUniqueAttributes.put("blurry", new UniqueAttribute("Blurry", "Accuracy and critical chance stat of this gun randomly swap while sustaining fire.  Stats go back to normal after 2 seconds of not firing", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));
    }

    private void addMagazineAttributes() {
        magazineNormalAttributes.put("magCapacity", new NormalAttribute("Magazine Capacity", "Determines the number of rounds your magazine can hold", 10, 15, 15, 50, true, true));
        magazineNormalAttributes.put("reloadSpeed", new NormalAttribute("Reload Speed", "Determines the time it takes to reload your weapon", 15, 20, 15, 20, true, true));
        magazineNormalAttributes.put("fireRate", new NormalAttribute("Fire Rate", "Determines the rate at which the weapon fires", 10, 20, 10, 20, true, true));

        List<String> frugalExceptions = new ArrayList<>(); frugalExceptions.add("Wasteful");
        magazineUniqueAttributes.put("frugal", new UniqueAttribute("Frugal", "x% chance for a shot to not consume a round from the magazine", WeaponConfig.RARITY_COMMON, frugalExceptions, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> wastefulExceptions = new ArrayList<>(); wastefulExceptions.add("Frugal");
        magazineUniqueAttributes.put("wasteful", new UniqueAttribute("Wasteful", "Consumes x rounds per shot", WeaponConfig.RARITY_COMMON, wastefulExceptions, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> infernoExceptions = new ArrayList<>(); infernoExceptions.add("Heat Displacing");
        magazineUniqueAttributes.put("inferno", new UniqueAttribute("Inferno", "x% chance a shot will catch fire upon impact", WeaponConfig.RARITY_UNCOMMON, infernoExceptions, WeaponConfig.UNIQUE_NAME_POST));
        magazineUniqueAttributes.put("combustion", new UniqueAttribute("Combustion", "x% chance a shot will explode upon impact", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_POST));
        magazineUniqueAttributes.put("quickRelease", new UniqueAttribute("Quick Release", "x% chance to reload your weapon 50% faster when manually reloading", WeaponConfig.RARITY_COMMON, WeaponConfig.UNIQUE_NAME_PRE));
        magazineUniqueAttributes.put("looping", new UniqueAttribute("Looping", "x% chance that firing the last round in your magazine will instantly restore 25% of your magazine", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));
        magazineUniqueAttributes.put("discarding", new UniqueAttribute("Discarding", "When reloading this weapon the character throws the magazine forwards.  When it lands it explodes causing area damage equal to normal weapon damage plus an additional percentage of normal weapon damage based on the percent of ammo remaining in the magazine when it was thrown", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_PRE));

        // Baked, put in here for now
        magazineUniqueAttributes.put("prismatic", new UniqueAttribute("Prismatic", "This weapon fires lasers instead of bullets.  Also receives Penetrating: Shots fired with this weapon have x% chance to penetrate what they hit", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_PRE));
    }

    private void addBarrelAttributes() {
        barrelNormalAttributes.put("accuracy", new NormalAttribute("Accuracy", "Determines the likeliness of your shots hitting where you’re aiming", 10, 30, 5, 20, false, true));
        barrelNormalAttributes.put("fireRate", new NormalAttribute("Fire Rate", "Determines the rate at which the weapon fires", 5, 10, 10, 20, true, false));
        barrelNormalAttributes.put("damage", new NormalAttribute("Damage", "Determines the amount of damage your shots do", 5, 10, 10, 20, true, false));
        barrelNormalAttributes.put("range", new NormalAttribute("Range", "Determines the range your bullets travel before dropping off", 10, 20, 5, 20, true, true));
        barrelNormalAttributes.put("spread", new NormalAttribute("Spread", "Determines the spread between projectiles exiting your weapon", 5, 10, 5, 25, true, true));

        barrelUniqueAttributes.put("ricochet", new UniqueAttribute("Ricochet", "x% chance the shot will ricochet and damage another enemy for half damage", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_POST));
        barrelUniqueAttributes.put("overcharged", new UniqueAttribute("Overcharged", "This weapon will randomly become overcharged and temporarily enter a state of increased performance that increases accuracy by x% and critical damage by x%", WeaponConfig.RARITY_RARE, WeaponConfig.UNIQUE_NAME_PRE));

        List<String> heatDisplacingExceptions = new ArrayList<>(); heatDisplacingExceptions.add("Inferno");
        barrelUniqueAttributes.put("heatDisplacing", new UniqueAttribute("Heat-Displacing", "As this weapon fires, the barrel heats up eventually causing shots to catch fire as they leave the barrel for a short period of time", WeaponConfig.RARITY_UNCOMMON, heatDisplacingExceptions, WeaponConfig.UNIQUE_NAME_PRE));

        // Baked, put in here for now
        barrelUniqueAttributes.put("multiShot", new UniqueAttribute("Multi-Shot", "Shots fired from this weapon release multiple projectiles at once instead of one", WeaponConfig.RARITY_UNCOMMON, WeaponConfig.UNIQUE_NAME_PRE));
    }

    public NormalAttribute getNormalBodyAttribute() {
        List<String> keysAsArray = new ArrayList<>(bodyNormalAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyNormalAttribute(bodyNormalAttributes.get(key));
    }

    public UniqueAttribute getUniqueBodyAttribute() {
        List<String> keysAsArray = new ArrayList<>(bodyUniqueAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyUniqueAttribute(bodyUniqueAttributes.get(key));
    }

    public NormalAttribute getNormalStockAttribute() {
        List<String> keysAsArray = new ArrayList<>(stockNormalAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyNormalAttribute(stockNormalAttributes.get(key));
    }

    public UniqueAttribute getUniqueStockAttribute() {
        List<String> keysAsArray = new ArrayList<>(stockUniqueAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyUniqueAttribute(stockUniqueAttributes.get(key));
    }

    public NormalAttribute getNormalSightAttribute() {
        List<String> keysAsArray = new ArrayList<>(sightNormalAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyNormalAttribute(sightNormalAttributes.get(key));
    }

    public UniqueAttribute getUniqueSightAttribute() {
        List<String> keysAsArray = new ArrayList<>(sightUniqueAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyUniqueAttribute(sightUniqueAttributes.get(key));
    }

    public NormalAttribute getNormalMagazineAttribute() {
        List<String> keysAsArray = new ArrayList<>(magazineNormalAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyNormalAttribute(magazineNormalAttributes.get(key));
    }

    public UniqueAttribute getUniqueMagazineAttribute() {
        List<String> keysAsArray = new ArrayList<>(magazineUniqueAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyUniqueAttribute(magazineUniqueAttributes.get(key));
    }

    public NormalAttribute getNormalBarrelAttribute() {
        List<String> keysAsArray = new ArrayList<>(barrelNormalAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyNormalAttribute(barrelNormalAttributes.get(key));
    }

    public UniqueAttribute getUniqueBarrelAttribute() {
        List<String> keysAsArray = new ArrayList<>(barrelUniqueAttributes.keySet());
        int num = new Random().nextInt(keysAsArray.size());
        String key = keysAsArray.get(num);

        return copyUniqueAttribute(barrelUniqueAttributes.get(key));
    }

    private NormalAttribute copyNormalAttribute(NormalAttribute og) {
        return new NormalAttribute(og.getName(), og.getDescription(),
                og.getPositiveMinValue(),
                og.getPositiveMaxValue(),
                og.getNegativeMinValue(),
                og.getNegativeMaxValue(),
                og.isPositiveAllowed(),
                og.isNegativeAllowed());
    }

    private UniqueAttribute copyUniqueAttribute(UniqueAttribute og) {
        return new UniqueAttribute(og.getName(), og.getDescription(), og.getRarity(), og.getAttributeExceptions(),
                og.getNameType());
    }
}
