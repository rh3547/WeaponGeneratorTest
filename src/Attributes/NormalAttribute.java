package Attributes;

import Main.WeaponConfig;

import java.util.List;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class NormalAttribute extends Attribute {
    private int positiveMinValue;
    private int positiveMaxValue;
    private int negativeMinValue;
    private int negativeMaxValue;
    private boolean negativeAllowed;
    private boolean positiveAllowed;

    public NormalAttribute(String name, String description, int positiveMinValue, int positiveMaxValue, int negativeMinValue, int negativeMaxValue, boolean positiveAllowed, boolean negativeAllowed) {
        super(name, description);

        this.positiveMaxValue = positiveMaxValue;
        this.negativeMinValue = negativeMinValue;
        this.positiveMinValue = positiveMinValue;
        this.negativeMaxValue = negativeMaxValue;
        this.positiveAllowed = positiveAllowed;
        this.negativeAllowed = negativeAllowed;
    }

    public NormalAttribute(String name, String description, int positiveMinValue, int positiveMaxValue, int negativeMinValue, int negativeMaxValue, boolean positiveAllowed,
                           boolean negativeAllowed, List<String> exceptions) {
        super(name, description, exceptions);

        this.positiveMinValue = positiveMinValue;
        this.positiveMaxValue = positiveMaxValue;
        this.negativeMinValue = negativeMinValue;
        this.negativeMaxValue = negativeMaxValue;
        this.positiveAllowed = positiveAllowed;
        this.negativeAllowed = negativeAllowed;
    }

    @Override
    public void generateValue(int level) {
        boolean isNegative = WeaponConfig.isAttributeNegative(this);
        int base = 0;
        int step2 = 0;

        if (!isNegative) {
            base = positiveMinValue + WeaponConfig.getRandom().nextInt((positiveMaxValue + 1) - positiveMinValue);
            step2 = WeaponConfig.getAttributePositiveStepTwo(base, level);
        }
        else {
            base = negativeMinValue + WeaponConfig.getRandom().nextInt((negativeMaxValue + 1) - negativeMinValue);
            step2 = WeaponConfig.getAttributeNegativeStepTwo(base, level);
        }

        int bracket = WeaponConfig.getLevelBracket(level);
        int step3 = step2 + WeaponConfig.getAttributeBoost(bracket);
        if (isNegative)
            step3 = step3 * -1;

        setValue(step3);
    }

    public int getPositiveMinValue() {
        return positiveMinValue;
    }

    public void setPositiveMinValue(int positiveMinValue) {
        this.positiveMinValue = positiveMinValue;
    }

    public int getPositiveMaxValue() {
        return positiveMaxValue;
    }

    public void setPositiveMaxValue(int positiveMaxValue) {
        this.positiveMaxValue = positiveMaxValue;
    }

    public boolean isNegativeAllowed() {
        return negativeAllowed;
    }

    public void setNegativeAllowed(boolean negativeAllowed) {
        this.negativeAllowed = negativeAllowed;
    }

    public boolean isPositiveAllowed() {
        return positiveAllowed;
    }

    public void setPositiveAllowed(boolean positiveAllowed) {
        this.positiveAllowed = positiveAllowed;
    }

    public int getNegativeMinValue() {
        return negativeMinValue;
    }

    public void setNegativeMinValue(int negativeMinValue) {
        this.negativeMinValue = negativeMinValue;
    }

    public int getNegativeMaxValue() {
        return negativeMaxValue;
    }

    public void setNegativeMaxValue(int negativeMaxValue) {
        this.negativeMaxValue = negativeMaxValue;
    }
}
