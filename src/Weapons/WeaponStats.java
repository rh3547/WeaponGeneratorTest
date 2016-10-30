package Weapons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan Hochmuth on 8/9/2016.
 */
public class WeaponStats {

    private Map<String, Double> stats;

    public WeaponStats() {
        stats = new HashMap<>();
        stats.put("damage", 0.0);
        stats.put("accuracy", 0.0);
        stats.put("fireRate", 0.0);
        stats.put("range", 0.0);
        stats.put("spread", 0.0);
        stats.put("magCapacity", 0.0);
        stats.put("reloadSpeed", 0.0);
        stats.put("criticalChance", 0.0);
        stats.put("criticalDamage", 0.0);
        stats.put("weight", 0.0);
        stats.put("penetration", 0.0);
    }

    public WeaponStats(double damage, double accuracy, double fireRate, double range, double spread,
                       double magCapacity, double reloadSpeed, double criticalChance,
                       double criticalDamage, double weight, double penetration) {
        stats = new HashMap<>();
        stats.put("damage", damage);
        stats.put("accuracy", accuracy);
        stats.put("fireRate", fireRate);
        stats.put("range", range);
        stats.put("spread", spread);
        stats.put("magCapacity", magCapacity);
        stats.put("reloadSpeed", reloadSpeed);
        stats.put("criticalChance", criticalChance);
        stats.put("criticalDamage", criticalDamage);
        stats.put("weight", weight);
        stats.put("penetration", penetration);
    }

    public double getDamage() {
        return stats.get("damage");
    }

    public void setDamage(double value) {
        stats.replace("damage", value);
    }

    public double getAccuracy() {
        return stats.get("accuracy");
    }

    public void setAccuracy(double value) {
        stats.replace("accuracy", value);
    }

    public double getFireRate() {
        return stats.get("fireRate");
    }

    public void setFireRate(double value) {
        stats.replace("fireRate", value);
    }

    public double getRange() {
        return stats.get("range");
    }

    public void setRange(double value) {
        stats.replace("range", value);
    }

    public double getSpread() {
        return stats.get("spread");
    }

    public void setSpread(double value) {
        stats.replace("spread", value);
    }

    public double getMagCapacity() {
        return stats.get("magCapacity");
    }

    public void setMagCapacity(double value) {
        stats.replace("magCapacity", value);
    }

    public double getReloadSpeed() {
        return stats.get("reloadSpeed");
    }

    public void setReloadSpeed(double value) {
        stats.replace("reloadSpeed", value);
    }

    public double getCriticalChance() {
        return stats.get("criticalChance");
    }

    public void setCriticalChance(double value) {
        stats.replace("criticalChance", value);
    }

    public double getCriticalDamage() {
        return stats.get("criticalDamage");
    }

    public void setCriticalDamage(double value) {
        stats.replace("criticalDamage", value);
    }

    public double getWeight() {
        return stats.get("weight");
    }

    public void setWeight(double value) {
        stats.replace("weight", value);
    }

    public double getPenetration() {
        return stats.get("penetration");
    }

    public void setPenetration(double value) {
        stats.replace("penetration", value);
    }
}
