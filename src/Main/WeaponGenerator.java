package Main;

import Attributes.Attribute;
import Attributes.NormalAttribute;
import Weapons.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Ryan Hochmuth on 8/6/2016.
 */
public class WeaponGenerator implements ActionListener {

    private JFrame frame;
    private JLabel seedLbl;
    private JTextField seedField;
    private JLabel lvlLbl;
    private JTextField lvlField;
    private JLabel weaponLbl;
    private JTextArea weaponTA;
    private JScrollPane weaponScrollPane;
    private JLabel detailLbl;
    private JTextArea detailTA;
    private JScrollPane detailScrollPane;
    private JButton generateBtn;

    public WeaponGenerator() {
        setupGui();
        frame.setVisible(true);
    }

    private void setupGui() {
        int windowWidth = 1200;
        int windowHeight = 720;

        frame = new JFrame("Weapon Generator");
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lvlLbl = new JLabel();
        lvlLbl.setText("Character Level");
        lvlLbl.setSize(((windowWidth - 5 - 50) / 2) - 20, 30);
        lvlLbl.setLocation(25, 10);
        frame.add(lvlLbl);

        lvlField = new JTextField();
        lvlField.setSize(((windowWidth - 5 - 50) / 2) - 20, 30);
        lvlField.setLocation(25, 40);
        frame.add(lvlField);

        seedLbl = new JLabel();
        seedLbl.setText("Seed");
        seedLbl.setSize(((windowWidth - 5 - 50) / 2) + 5, 30);
        seedLbl.setLocation(((windowWidth - 5 - 50) / 2) + 20, 10);
        frame.add(seedLbl);

        seedField = new JTextField();
        seedField.setSize(((windowWidth - 5 - 50) / 2) + 5, 30);
        seedField.setLocation(((windowWidth - 5 - 50) / 2) + 20, 40);
        frame.add(seedField);

        weaponLbl = new JLabel();
        weaponLbl.setText("Weapon");
        weaponLbl.setSize(windowWidth - 5 - 50 - (windowWidth - 5 - 400), 30);
        weaponLbl.setLocation(25, 90);
        frame.add(weaponLbl);

        weaponTA = new JTextArea();
        weaponTA.setEditable(false);
        weaponTA.setLineWrap(false);
        weaponTA.setMargin(new Insets(10,10,10,10));
        weaponTA.setSize(windowWidth - 5 - 50 - (windowWidth - 5 - 400), windowHeight - 220);

        weaponScrollPane = new JScrollPane(weaponTA);
        weaponScrollPane.setSize(windowWidth - 5 - 50 - (windowWidth - 5 - 400), windowHeight - 220);
        weaponScrollPane.setLocation(25, 120);
        frame.add(weaponScrollPane);

        detailLbl = new JLabel();
        detailLbl.setText("Details");
        detailLbl.setSize(windowWidth - 5 - 400, 30);
        detailLbl.setLocation(25 + 400 - 50, 90);
        frame.add(detailLbl);

        detailTA = new JTextArea();
        detailTA.setEditable(false);
        detailTA.setLineWrap(false);
        detailTA.setMargin(new Insets(10,10,10,10));
        detailTA.setSize(windowWidth - 5 - 400, windowHeight - 220);

        detailScrollPane = new JScrollPane(detailTA);
        detailScrollPane.setSize(windowWidth - 5 - 400, windowHeight - 220);
        detailScrollPane.setLocation(25 + 400 - 50, 120);
        frame.add(detailScrollPane);

        generateBtn = new JButton();
        generateBtn.setText("Generate Weapon");
        generateBtn.setSize(150, 30);
        generateBtn.setLocation((windowWidth / 2) - (75), windowHeight - 80);
        generateBtn.addActionListener(this);
        frame.getRootPane().setDefaultButton(generateBtn);
        frame.add(generateBtn);
    }

    private Weapon generateWeapon(int level) {

        Weapon weapon = new Weapon(level);
        weapon.generateWeapon(true);

        return weapon;
    }

    public static void main(String[] args) {
        new WeaponGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateBtn) {
            String lvlStr = lvlField.getText();
            String seedStr = seedField.getText();
            boolean invalid = false;
            int lvl = 0;

            if (!lvlStr.equals("")) {
                try {
                    lvl = Integer.parseInt(lvlStr);
                }
                catch(NumberFormatException ex) {
                    invalid = true;
                }
            }
            else {
                invalid = true;
            }

            if (invalid) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number for the character level",
                        "Invalid Level",
                        JOptionPane.PLAIN_MESSAGE);
            }
            else {
                long seed = 0;
                if (seedStr.equals("")) {
                    seed = new Random().nextLong();
                    WeaponConfig.setUseSeed(true);
                    WeaponConfig.updateSeed(seed);
                }
                else {
                    seed = Long.parseLong(seedStr);
                    WeaponConfig.setUseSeed(true);
                    WeaponConfig.updateSeed(seed);
                }

                Weapon weapon = generateWeapon(lvl);

                /*
                Build the weapon result string
                 */
                DecimalFormat df = new DecimalFormat("###,###");
                String weaponResult = "";
                weaponResult += "Level: " + weapon.getLevel() + "\n";
                weaponResult += weapon.getName() + "\n";
                weaponResult += "\n";
                weaponResult += "Stats:\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Damage\t\t\t" + df.format(weapon.getStats().getDamage()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Accuracy\t\t\t" + df.format(weapon.getStats().getAccuracy()) + "%\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Fire Rate\t\t\t" + df.format(weapon.getStats().getFireRate()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Magazine Capacity\t\t" + df.format(weapon.getStats().getMagCapacity()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Reload Speed\t\t\t" + weapon.getStats().getReloadSpeed() + " sec.\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Effective Range\t\t\t" + df.format(weapon.getStats().getRange()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Spread\t\t\t" + df.format(weapon.getStats().getSpread()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Weight\t\t\t" + df.format(weapon.getStats().getWeight()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Penetration\t\t\t" + df.format(weapon.getStats().getPenetration()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Critical Hit Chance\t\t" + df.format(weapon.getStats().getCriticalChance()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";
                weaponResult += "Critical Damage\t\t" + df.format(weapon.getStats().getCriticalDamage()) + "\n";
                weaponResult += "---------------------------------------------------------------------------------\n";

                /*
                Build the detail result string
                 */
                String detailResult = "";
                detailResult += "Seed: " + seed + "\n";

                detailResult += "\n";

                detailResult += "Body: " + weapon.getBodyPart().getName() + "\n";
                for (Attribute attr : weapon.getBodyPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        detailResult += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        detailResult += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                detailResult += "\nStock: " + weapon.getStockPart().getName() + "\n";
                for (Attribute attr : weapon.getStockPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        detailResult += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        detailResult += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                detailResult += "\nSight: " + weapon.getSightPart().getName() + "\n";
                for (Attribute attr : weapon.getSightPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        detailResult += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        detailResult += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                detailResult += "\nMagazine: " + weapon.getMagazinePart().getName() + "\n";
                for (Attribute attr : weapon.getMagazinePart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        detailResult += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        detailResult += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                detailResult += "\nBarrel: " + weapon.getBarrelPart().getName() + "\n";
                for (Attribute attr : weapon.getBarrelPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        detailResult += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        detailResult += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                /*
                Add result strings to text areas
                 */
                weaponTA.setText(weaponResult);
                detailTA.setText(detailResult);
            }
        }
    }
}
