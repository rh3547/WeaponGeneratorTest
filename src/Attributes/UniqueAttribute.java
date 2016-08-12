package Attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Hochmuth on 8/7/2016.
 */
public class UniqueAttribute extends Attribute {
    private int rarity;

    public UniqueAttribute(String name, String description, int rarity) {
        super(name, description);
        this.rarity = rarity;
    }

    public UniqueAttribute(String name, String description, int rarity, List<String> exceptions) {
        super(name, description, exceptions);
        this.rarity = rarity;
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
}
