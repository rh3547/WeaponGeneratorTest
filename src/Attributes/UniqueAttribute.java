package Attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Hochmuth on 8/7/2016.
 */
public class UniqueAttribute extends Attribute {
    private int rarity;
    private int nameType;

    public UniqueAttribute(String name, String description, int rarity, int nameType) {
        super(name, description);
        this.rarity = rarity;
        this.nameType = nameType;
    }

    public UniqueAttribute(String name, String description, int rarity, List<String> exceptions, int nameType) {
        super(name, description, exceptions);
        this.rarity = rarity;
        this.nameType = nameType;
    }

    @Override
    public void generateValue(int level) {

    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getNameType() {
        return nameType;
    }

    public void setNameType(int nameType) {
        this.nameType = nameType;
    }
}
