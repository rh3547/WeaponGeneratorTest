package Parts;

import Attributes.Attribute;
import Attributes.AttributeHandler;
import Attributes.UniqueAttribute;
import Main.WeaponConfig;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class MagazinePart extends Part {

    public MagazinePart(String name, int level, PartModel model) {
        super(name, level, model);
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
                    attr = AttributeHandler.instance.getNormalMagazineAttribute();
                }
                else {
                    boolean uniqueGet = false;

                    while (!uniqueGet) {
                        attr = AttributeHandler.instance.getUniqueMagazineAttribute();

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
}
