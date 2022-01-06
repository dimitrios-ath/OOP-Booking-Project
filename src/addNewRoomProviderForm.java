import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.Map;
import java.util.Objects;
/*
 * Created by JFormDesigner on Thu Jan 06 12:20:00 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class addNewRoomProviderForm extends JPanel {
    JFrame jframe;
    addNewRoomProviderForm currentForm;
    private Provider provider;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

    public void setCurrentForm(addNewRoomProviderForm currentForm) {
        this.currentForm = currentForm;
    }

    public addNewRoomProviderForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                  Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                                  Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Provider provider) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.provider = provider;
        initComponents();
    }

    private void addRoomClick(ActionEvent e) {
        String type = "";
        boolean validInput = true;
        if (comboBox1.getSelectedItem() == "-") {
            comboBox1.setForeground(Color.red);
            validInput = false;
        }
        else {
            if (comboBox1.getSelectedItem() == "Hotel") {
                type = "hotel";
            } else if (comboBox1.getSelectedItem() == "Room") {
                type = "room";
            } else {type = "apartment";}
            comboBox1.setForeground(null);
        }

        String name = textField1.getText();
        if (Objects.equals(name, "")){
            textField1.setForeground(Color.red);
            validInput = false;
        } else {
            textField1.setForeground(null);
        }

        double price = 0;
        try {
            double scannedPrice = Double.parseDouble(textField2.getText());
            textField2.setForeground(null);
            price = scannedPrice;
        } catch (NumberFormatException ignored) {
            textField2.setForeground(Color.red);
            validInput = false;
        }

        int size = 0;
        try {
            int scannedSize = Integer.parseInt(textField3.getText());
            textField3.setForeground(null);
            size = scannedSize;
        } catch (NumberFormatException ignored) {
            textField3.setForeground(Color.red);
            validInput = false;
        }

        int capacity = 0;
        try {
            int scannedCapacity = Integer.parseInt(textField4.getText());
            textField4.setForeground(null);
            capacity = scannedCapacity;
        } catch (NumberFormatException ignored) {
            textField4.setForeground(Color.red);
            validInput = false;
        }

        boolean longTime = checkBox1.isSelected();
        boolean wifi = checkBox2.isSelected();
        boolean parking = checkBox3.isSelected();
        boolean airCondition = checkBox4.isSelected();
        boolean balcony = checkBox5.isSelected();
        boolean fridge = checkBox6.isSelected();
        boolean kitchen = checkBox7.isSelected();
        boolean tv = checkBox8.isSelected();
        boolean smoking = checkBox9.isSelected();
        boolean pets = checkBox10.isSelected();

        boolean addedToHashMap = false;
        int i=1;
        while(!addedToHashMap && i<1000) {
            if (!rooms.containsKey(i)) {
                rooms.put(i, new Room(i, provider.getUsername(), name, type, longTime, capacity, price, size, wifi, parking,
                        airCondition, balcony, fridge, kitchen, tv, smoking, pets));
                addedToHashMap = true;
                providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.provider);
                providerForm.setCurrentForm(providerForm);
                this.jframe.add(providerForm);
                this.currentForm.setVisible(false);
            }
            else {i++;}
        }
    }

    private void cancelClick(ActionEvent e) {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox<>();
        label3 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField2 = new JTextField();
        label6 = new JLabel();
        textField3 = new JTextField();
        label16 = new JLabel();
        textField4 = new JTextField();
        label4 = new JLabel();
        checkBox1 = new JCheckBox();
        label7 = new JLabel();
        checkBox2 = new JCheckBox();
        label8 = new JLabel();
        checkBox3 = new JCheckBox();
        label9 = new JLabel();
        checkBox4 = new JCheckBox();
        label10 = new JLabel();
        checkBox5 = new JCheckBox();
        label11 = new JLabel();
        checkBox6 = new JCheckBox();
        label12 = new JLabel();
        checkBox7 = new JCheckBox();
        label13 = new JLabel();
        checkBox8 = new JCheckBox();
        label14 = new JLabel();
        checkBox9 = new JCheckBox();
        label15 = new JLabel();
        checkBox10 = new JCheckBox();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
        ,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red),
         getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Add new Room");
        add(label1, "cell 2 0");

        //---- label2 ----
        label2.setText("Type:");
        add(label2, "cell 1 2");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "-",
            "Hotel",
            "Room",
            "Apartment"
        }));
        add(comboBox1, "cell 2 2");

        //---- label3 ----
        label3.setText("Name:");
        add(label3, "cell 1 3");
        add(textField1, "cell 2 3");

        //---- label5 ----
        label5.setText("Price:");
        add(label5, "cell 1 4");
        add(textField2, "cell 2 4");

        //---- label6 ----
        label6.setText("Size:");
        add(label6, "cell 1 5");
        add(textField3, "cell 2 5");

        //---- label16 ----
        label16.setText("Capacity:");
        add(label16, "cell 1 6");
        add(textField4, "cell 2 6");

        //---- label4 ----
        label4.setText("Long term reservation:");
        add(label4, "cell 1 7");
        add(checkBox1, "cell 2 7");

        //---- label7 ----
        label7.setText("Free WiFi:");
        add(label7, "cell 1 8");
        add(checkBox2, "cell 2 8");

        //---- label8 ----
        label8.setText("Free Parking:");
        add(label8, "cell 1 9");
        add(checkBox3, "cell 2 9");

        //---- label9 ----
        label9.setText("Air condition:");
        add(label9, "cell 1 10");
        add(checkBox4, "cell 2 10");

        //---- label10 ----
        label10.setText("Balcony:");
        add(label10, "cell 1 11");
        add(checkBox5, "cell 2 11");

        //---- label11 ----
        label11.setText("Fridge:");
        add(label11, "cell 1 12");
        add(checkBox6, "cell 2 12");

        //---- label12 ----
        label12.setText("Kitchen:");
        add(label12, "cell 1 13");
        add(checkBox7, "cell 2 13");

        //---- label13 ----
        label13.setText("TV:");
        add(label13, "cell 1 14");
        add(checkBox8, "cell 2 14");

        //---- label14 ----
        label14.setText("Smoking allowed:");
        add(label14, "cell 1 15");
        add(checkBox9, "cell 2 15");

        //---- label15 ----
        label15.setText("Pets allowed:");
        add(label15, "cell 1 16");
        add(checkBox10, "cell 2 16");

        //---- button2 ----
        button2.setText("Cancel");
        button2.addActionListener(e -> cancelClick(e));
        add(button2, "cell 1 17");

        //---- button1 ----
        button1.setText("Add");
        button1.addActionListener(e -> addRoomClick(e));
        add(button1, "cell 3 17");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JLabel label2;
    private JComboBox<String> comboBox1;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label5;
    private JTextField textField2;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label16;
    private JTextField textField4;
    private JLabel label4;
    private JCheckBox checkBox1;
    private JLabel label7;
    private JCheckBox checkBox2;
    private JLabel label8;
    private JCheckBox checkBox3;
    private JLabel label9;
    private JCheckBox checkBox4;
    private JLabel label10;
    private JCheckBox checkBox5;
    private JLabel label11;
    private JCheckBox checkBox6;
    private JLabel label12;
    private JCheckBox checkBox7;
    private JLabel label13;
    private JCheckBox checkBox8;
    private JLabel label14;
    private JCheckBox checkBox9;
    private JLabel label15;
    private JCheckBox checkBox10;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
