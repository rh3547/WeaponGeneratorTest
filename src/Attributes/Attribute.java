package Attributes;

import Main.WeaponConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public abstract class Attribute {
    private String name;
    private String description;
    private float value = 0;
    private List<String> attributeExceptions = new ArrayList<>();

    public Attribute(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Attribute(String name, String description, List<String> exceptions) {
        this.name = name;
        this.description = description;
        this.attributeExceptions = exceptions;
    }

    public abstract void generateValue(int level);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public List<String> getAttributeExceptions() {
        return attributeExceptions;
    }

    public void addAttributeException(String exception) {
        getAttributeExceptions().add(exception);
    }
}
