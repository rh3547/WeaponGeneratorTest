package Main;

import Attributes.Attribute;
import Attributes.NormalAttribute;
import Weapons.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private JTextArea resultTA;
    private JScrollPane scrollPane;
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

        resultTA = new JTextArea();
        resultTA.setEditable(false);
        resultTA.setLineWrap(false);
        resultTA.setMargin(new Insets(10,10,10,10));
        resultTA.setSize(windowWidth - 5 - 50, windowHeight - 200);

        scrollPane = new JScrollPane(resultTA);
        scrollPane.setSize(windowWidth - 5 - 50, windowHeight - 200);
        scrollPane.setLocation(25, 80);
        frame.add(scrollPane);

        generateBtn = new JButton();
        generateBtn.setText("Generate Weapon");
        generateBtn.setSize(150, 30);
        generateBtn.setLocation((windowWidth / 2) - (75), windowHeight - 90);
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
                    WeaponConfig.useSeed = true;
                    WeaponConfig.updateSeed(seed);
                }
                else {
                    seed = Long.parseLong(seedStr);
                    WeaponConfig.updateSeed(seed);
                    WeaponConfig.useSeed = true;
                }

                Weapon weapon = generateWeapon(lvl);

                String result = "Weapon:\n\n";
                result += "Seed: " + seed + "\n";
                result += "Level: " + weapon.getLevel() + "\n";
                result += weapon.getName() + "\n";

                result += "\n";

                result += "Body: " + weapon.getBodyPart().getName() + "\n";
                for (Attribute attr : weapon.getBodyPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        result += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        result += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                result += "\nStock: " + weapon.getStockPart().getName() + "\n";
                for (Attribute attr : weapon.getStockPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        result += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        result += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                result += "\nSight: " + weapon.getSightPart().getName() + "\n";
                for (Attribute attr : weapon.getSightPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        result += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        result += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                result += "\nMagazine: " + weapon.getMagazinePart().getName() + "\n";
                for (Attribute attr : weapon.getMagazinePart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        result += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        result += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                result += "\nBarrel: " + weapon.getBarrelPart().getName() + "\n";
                for (Attribute attr : weapon.getBarrelPart().getAttributes()) {
                    if (attr instanceof NormalAttribute) {
                        String sign = "+";
                        if (attr.getValue() < 0) sign = "-";
                        result += "    * " + attr.getName() + ":  " + sign + " " + Math.abs(attr.getValue()) + "% : " + attr.getDescription() + "\n";
                    }
                    else {
                        result += "    * " + attr.getName() + ": " + attr.getDescription() + "\n";
                    }
                }

                resultTA.setText(result);
            }
        }
    }
}
