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

    public void setDamage(int damage) {
        stats.replace("damage", damage);
    }
}
