package Parts;

import Attributes.Attribute;
import Attributes.UniqueAttribute;
import Main.WeaponConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public abstract class Part {
    private String name;
    private int level;
    private PartModel model;
    private List<Attribute> attributes = new ArrayList<>();

    public Part(String name, int level, PartModel model) {
        this.name = name;
        this.level = level;
        this.model = model;
    }

    public abstract void generateAttributes();

    protected boolean hasAttribute(String name) {
        for (Attribute attr : getAttributes()) {
            if (attr.getName().equals(name))
                return true;
        }

        return false;
    }

    protected boolean hasExceptionConflict(String name) {
        for (Attribute attr : getAttributes()) {
            if (attr.getAttributeExceptions().contains(name))
                return true;
        }

        return false;
    }

    protected boolean rollUniqueChance(UniqueAttribute attr) {
        Random rand = WeaponConfig.getRandom();

        switch(attr.getRarity()) {
            case WeaponConfig.RARITY_COMMON:
                return true;

            case WeaponConfig.RARITY_UNCOMMON:
                if (rand.nextInt(100) < WeaponConfig.RARITY_UNCOMMON)
                    return true;
                else return false;

            case WeaponConfig.RARITY_RARE:
                if (rand.nextInt(100) < WeaponConfig.RARITY_RARE)
                    return true;
                else return false;

            default:
                return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PartModel getModel() {
        return model;
    }

    public void setModel(PartModel model) {
        this.model = model;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(Attribute attr) {
        attributes.add(attr);
    }
}
