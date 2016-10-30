package Parts;

import Attributes.Attribute;
import Attributes.AttributeHandler;
import Attributes.UniqueAttribute;
import Main.WeaponConfig;
import Weapons.WeaponType;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class BodyPart extends Part {
    private WeaponType type;

    public BodyPart(String name, int level, PartModel model, WeaponType type) {
        super(name, level, model);
        this.type = type;
    }

    @Override
    public void generateAttributes() {
        int bracket = WeaponConfig.getLevelBracket(getLevel());
        int numAttributes = WeaponConfig.getNumAttributes(bracket);

        for (int x = 0; x < numAttributes; x++) {
            Attribute attr = null;
            boolean chosen = false;
            int attempts = 0;

            while (!chosen) {
                if (WeaponConfig.isNormalAttribute()) {
                    attr = AttributeHandler.instance.getNormalBodyAttribute();
                }
                else {
                    boolean uniqueGet = false;

                    while (!uniqueGet) {
                        attr = AttributeHandler.instance.getUniqueBodyAttribute();

                        uniqueGet = rollUniqueChance((UniqueAttribute)attr);
                    }
                }

                if (!hasAttribute(attr.getName()) && !hasExceptionConflict(attr.getName()))
                    chosen = true;
                else {
                    if (attempts >= 5)
                        break;

                    attempts++;
                }
            }

            if (chosen) {
                attr.generateValue(getLevel());
                addAttribute(attr);
            }
        }
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }
}
