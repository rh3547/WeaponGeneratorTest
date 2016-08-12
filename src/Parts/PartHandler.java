package Parts;

import Weapons.WeaponType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class PartHandler {
    public static PartHandler instance = new PartHandler();

    private Map<Integer, PartModel> bodyList = new HashMap<>();
    private Map<Integer, PartModel> stockList = new HashMap<>();
    private Map<Integer, PartModel> sightList = new HashMap<>();
    private Map<Integer, PartModel> magazineList = new HashMap<>();
    private Map<Integer, PartModel> barrelList = new HashMap<>();

    private PartHandler() {
        addParts();
    }

    private void addParts() {
        bodyList.put(0, new PartModel("Pistol Body 1", WeaponType.Pistol));
        bodyList.put(1, new PartModel("Pistol Body 2", WeaponType.Pistol));
        bodyList.put(2, new PartModel("Pistol Body 3", WeaponType.Pistol));
        bodyList.put(3, new PartModel("SMG Body 1", WeaponType.SMG));
        bodyList.put(4, new PartModel("SMG Body 2", WeaponType.SMG));
        bodyList.put(5, new PartModel("SMG Body 3", WeaponType.SMG));
        bodyList.put(6, new PartModel("Shotgun Body 1", WeaponType.Shotgun));
        bodyList.put(7, new PartModel("Shotgun Body 2", WeaponType.Shotgun));
        bodyList.put(8, new PartModel("Shotgun Body 3", WeaponType.Shotgun));
        bodyList.put(9, new PartModel("Assault Rifle Body 1", WeaponType.AssaultRifle));
        bodyList.put(10, new PartModel("Assault Rifle Body 2", WeaponType.AssaultRifle));
        bodyList.put(11, new PartModel("Assault Rifle Body 3", WeaponType.AssaultRifle));
        bodyList.put(12, new PartModel("LMG Body 1", WeaponType.LMG));
        bodyList.put(13, new PartModel("LMG Body 2", WeaponType.LMG));
        bodyList.put(14, new PartModel("LMG Body 3", WeaponType.LMG));
        bodyList.put(15, new PartModel("Sniper Body 1", WeaponType.Sniper));
        bodyList.put(16, new PartModel("Sniper Body 2", WeaponType.Sniper));
        bodyList.put(17, new PartModel("Sniper Body 3", WeaponType.Sniper));

        stockList.put(0, new PartModel("Stock 1", null));
        stockList.put(1, new PartModel("Stock 2", null));
        stockList.put(2, new PartModel("Stock 3", null));
        stockList.put(3, new PartModel("Stock 4", null));
        stockList.put(4, new PartModel("Stock 5", null));
        stockList.put(5, new PartModel("Stock 6", null));
        stockList.put(6, new PartModel("Stock 7", null));
        stockList.put(7, new PartModel("Stock 8", null));
        stockList.put(8, new PartModel("Stock 9", null));
        stockList.put(9, new PartModel("Stock 10", null));
        stockList.put(10, new PartModel("Stock 11", null));
        stockList.put(11, new PartModel("Stock 12", null));
        stockList.put(12, new PartModel("Stock 13", null));
        stockList.put(13, new PartModel("Stock 14", null));
        stockList.put(14, new PartModel("Stock 15", null));
        stockList.put(15, new PartModel("Stock 16", null));
        stockList.put(16, new PartModel("Stock 17", null));
        stockList.put(17, new PartModel("Stock 18", null));

        sightList.put(0, new PartModel("Sight 1", null));
        sightList.put(1, new PartModel("Sight 2", null));
        sightList.put(2, new PartModel("Sight 3", null));
        sightList.put(3, new PartModel("Sight 4", null));
        sightList.put(4, new PartModel("Sight 5", null));
        sightList.put(5, new PartModel("Sight 6", null));
        sightList.put(6, new PartModel("Sight 7", null));
        sightList.put(7, new PartModel("Sight 8", null));
        sightList.put(8, new PartModel("Sight 9", null));
        sightList.put(9, new PartModel("Sight 10", null));
        sightList.put(10, new PartModel("Sight 11", null));
        sightList.put(11, new PartModel("Sight 12", null));
        sightList.put(12, new PartModel("Sight 13", null));
        sightList.put(13, new PartModel("Sight 14", null));
        sightList.put(14, new PartModel("Sight 15", null));
        sightList.put(15, new PartModel("Sight 16", null));
        sightList.put(16, new PartModel("Sight 17", null));
        sightList.put(17, new PartModel("Sight 18", null));

        magazineList.put(0, new PartModel("Magazine 1", null));
        magazineList.put(1, new PartModel("Magazine 2", null));
        magazineList.put(2, new PartModel("Magazine 3", null));
        magazineList.put(3, new PartModel("Magazine 4", null));
        magazineList.put(4, new PartModel("Magazine 5", null));
        magazineList.put(5, new PartModel("Magazine 6", null));
        magazineList.put(6, new PartModel("Magazine 7", null));
        magazineList.put(7, new PartModel("Magazine 8", null));
        magazineList.put(8, new PartModel("Magazine 9", null));
        magazineList.put(9, new PartModel("Magazine 10", null));
        magazineList.put(10, new PartModel("Magazine 11", null));
        magazineList.put(11, new PartModel("Magazine 12", null));
        magazineList.put(12, new PartModel("Magazine 13", null));
        magazineList.put(13, new PartModel("Magazine 14", null));
        magazineList.put(14, new PartModel("Magazine 15", null));
        magazineList.put(15, new PartModel("Magazine 16", null));
        magazineList.put(16, new PartModel("Magazine 17", null));
        magazineList.put(17, new PartModel("Magazine 18", null));

        barrelList.put(0, new PartModel("Barrel 1", null));
        barrelList.put(1, new PartModel("Barrel 2", null));
        barrelList.put(2, new PartModel("Barrel 3", null));
        barrelList.put(3, new PartModel("Barrel 4", null));
        barrelList.put(4, new PartModel("Barrel 5", null));
        barrelList.put(5, new PartModel("Barrel 6", null));
        barrelList.put(6, new PartModel("Barrel 7", null));
        barrelList.put(7, new PartModel("Barrel 8", null));
        barrelList.put(8, new PartModel("Barrel 9", null));
        barrelList.put(9, new PartModel("Barrel 10", null));
        barrelList.put(10, new PartModel("Barrel 11", null));
        barrelList.put(11, new PartModel("Barrel 12", null));
        barrelList.put(12, new PartModel("Barrel 13", null));
        barrelList.put(13, new PartModel("Barrel 14", null));
        barrelList.put(14, new PartModel("Barrel 15", null));
        barrelList.put(15, new PartModel("Barrel 16", null));
        barrelList.put(16, new PartModel("Barrel 17", null));
        barrelList.put(17, new PartModel("Barrel 18", null));
    }

    public PartModel getBodyPart(int num) {
        return instance.bodyList.get(num);
    }

    public PartModel getStockPart(int num) {
        return instance.stockList.get(num);
    }

    public PartModel getSightPart(int num) {
        return instance.sightList.get(num);
    }

    public PartModel getMagazinePart(int num) {
        return instance.magazineList.get(num);
    }

    public PartModel getBarrelPart(int num) {
        return instance.barrelList.get(num);
    }
}
