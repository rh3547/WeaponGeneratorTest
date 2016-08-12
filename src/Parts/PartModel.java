package Parts;

import Attributes.Attribute;
import Weapons.WeaponType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class PartModel {
    private String name;
    private WeaponType type;
    private List<Attribute> bakedAttributes = new ArrayList<>();

    public PartModel(String name, WeaponType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public List<Attribute> getBakedAttributes() {
        return bakedAttributes;
    }

    public void addBakedAttribute(Attribute attribute) {
        bakedAttributes.add(attribute);
    }
}
