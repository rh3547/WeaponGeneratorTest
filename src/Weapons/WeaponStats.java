package Weapons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan Hochmuth on 8/9/2016.
 */
public class WeaponStats {

    private Map<String, Integer> stats;

    public WeaponStats() {
        stats = new HashMap<>();
        stats.put("damage", 0);
        stats.put("accuracy", 0);
        stats.put("fireRate", 0);
        stats.put("range", 0);
        stats.put("spread", 0);
        stats.put("magCapacity", 0);
        stats.put("reloadSpeed", 0);
        stats.put("criticalChance", 0);
        stats.put("criticalDamage", 0);
        stats.put("weight", 0);
        stats.put("penetration", 0);
    }

    public WeaponStats(int damage, int accuracy, int fireRate, int range, int spread,
                       int magCapacity, int reloadSpeed, int criticalChance,
                       int criticalDamage, int weight, int penetration) {
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

    public int getDamage() {
        return stats.get("damage");
    }

    public void setDamage(int value) {
        stats.replace("damage", value);
    }

    public int getAccuracy() {
        return stats.get("accuracy");
    }

    public void setAccuracy(int value) {
        stats.replace("accuracy", value);
    }

    public int getFireRate() {
        return stats.get("fireRate");
    }

    public void setFireRate(int value) {
        stats.replace("fireRate", value);
    }

    public int getRange() {
        return stats.get("range");
    }

    public void setRange(int value) {
        stats.replace("range", value);
    }

    public int getSpread() {
        return stats.get("spread");
    }

    public void setSpread(int value) {
        stats.replace("spread", value);
    }

    public int getMagCapacity() {
        return stats.get("magCapacity");
    }

    public void setMagCapacity(int value) {
        stats.replace("magCapacity", value);
    }

    public int getReloadSpeed() {
        return stats.get("reloadSpeed");
    }

    public void setReloadSpeed(int value) {
        stats.replace("reloadSpeed", value);
    }

    public int getCriticalChance() {
        return stats.get("criticalChance");
    }

    public void setCriticalChance(int value) {
        stats.replace("criticalChance", value);
    }

    public int getCriticalDamage() {
        return stats.get("criticalDamage");
    }

    public void setCriticalDamage(int value) {
        stats.replace("criticalDamage", value);
    }

    public int getWeight() {
        return stats.get("weight");
    }

    public void setWeight(int value) {
        stats.replace("weight", value);
    }

    public int getPenetration() {
        return stats.get("penetration");
    }

    public void setPenetration(int value) {
        stats.replace("penetration", value);
    }
}
