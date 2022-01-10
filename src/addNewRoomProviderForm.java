import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.Map;
import java.util.Objects;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Jan 06 12:20:00 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class addNewRoomProviderForm extends JPanel {
    JFrame jframe;
    addNewRoomProviderForm currentForm;
    private final Provider provider;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

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
        this.jframe.setResizable(false);
        initComponents();
        jframe.setPreferredSize(new Dimension(400 , 680));
        jframe.pack();
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
            double scannedPrice = Double.parseDouble(spinner3.getValue().toString());
            spinner3.setForeground(null);
            price = scannedPrice;
        } catch (NumberFormatException ignored) {
            spinner3.setForeground(Color.red);
            validInput = false;
        }

        int size = 0;
        try {
            int scannedSize = Integer.parseInt(spinner2.getValue().toString());
            spinner2.setForeground(null);
            size = scannedSize;
        } catch (NumberFormatException ignored) {
            spinner2.setForeground(Color.red);
            validInput = false;
        }

        int capacity = 0;
        try {
            int scannedCapacity = Integer.parseInt(spinner1.getValue().toString());
            spinner1.setForeground(null);
            capacity = scannedCapacity;
        } catch (NumberFormatException ignored) {
            spinner1.setForeground(Color.red);
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

        if (validInput) {
            boolean addedToHashMap = false;
            int i = 1;
            while (!addedToHashMap && i < 1000) {
                if (!rooms.containsKey(i)) {
                    rooms.put(i, new Room(i, provider.getUsername(), name, type, longTime, capacity, price, size, wifi, parking,
                            airCondition, balcony, fridge, kitchen, tv, smoking, pets));
                    addedToHashMap = true;
                    providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                            this.providers, this.admins, this.messages, this.mainUI, this.provider);
                    providerForm.setCurrentForm(providerForm);
                    this.jframe.add(providerForm);
                    this.currentForm.setVisible(false);
                } else {
                    i++;
                }
            }
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
        label6 = new JLabel();
        label16 = new JLabel();
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
        spinner1 = new JSpinner();
        spinner2 = new JSpinner();
        spinner3 = new JSpinner();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setAlignmentX(0.1F);
        setAlignmentY(0.1F);
        setMaximumSize(null);
        setPreferredSize(new Dimension(150, 150));
        setMinimumSize(null);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
        EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing
        .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
        java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))
        throw new RuntimeException();}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Add new Room");
        label1.setFont(new Font("Century Gothic", Font.BOLD, 18));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(140, 20, 140, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Type:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label2);
        label2.setBounds(40, 75, 165, 25);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "-",
            "Hotel",
            "Room",
            "Apartment"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox1.setEditable(true);
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        comboBox1.setForeground(new Color(51, 102, 255));
        add(comboBox1);
        comboBox1.setBounds(215, 75, 135, 25);

        //---- label3 ----
        label3.setText("Name:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(40, 115, 165, 25);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        textField1.setForeground(Color.black);
        add(textField1);
        textField1.setBounds(215, 115, 135, 25);

        //---- label5 ----
        label5.setText("Price ($/night):");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label5);
        label5.setBounds(40, 155, 165, 25);

        //---- label6 ----
        label6.setText("Size (m2):");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label6);
        label6.setBounds(40, 195, 165, 25);

        //---- label16 ----
        label16.setText("Capacity:");
        label16.setFont(new Font("Tahoma", Font.BOLD, 14));
        label16.setForeground(Color.white);
        label16.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label16);
        label16.setBounds(40, 235, 165, 25);

        //---- label4 ----
        label4.setText("Long term reservation:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        label4.setBounds(40, 305, 165, 25);

        //---- checkBox1 ----
        checkBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox1.setBackground(new Color(51, 102, 255));
        add(checkBox1);
        checkBox1.setBounds(210, 275, 25, 20);

        //---- label7 ----
        label7.setText("Free WiFi:");
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.white);
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label7);
        label7.setBounds(40, 275, 165, 25);

        //---- checkBox2 ----
        checkBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox2.setBackground(new Color(51, 102, 255));
        add(checkBox2);
        checkBox2.setBounds(210, 305, 25, 29);

        //---- label8 ----
        label8.setText("Free Parking:");
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setForeground(Color.white);
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label8);
        label8.setBounds(40, 335, 165, 25);

        //---- checkBox3 ----
        checkBox3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox3.setBackground(new Color(51, 102, 255));
        add(checkBox3);
        checkBox3.setBounds(210, 330, 25, 39);

        //---- label9 ----
        label9.setText("Air condition:");
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        label9.setForeground(Color.white);
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label9);
        label9.setBounds(40, 365, 165, 25);

        //---- checkBox4 ----
        checkBox4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox4.setBackground(new Color(51, 102, 255));
        add(checkBox4);
        checkBox4.setBounds(210, 360, 25, 35);

        //---- label10 ----
        label10.setText("Balcony:");
        label10.setFont(new Font("Tahoma", Font.BOLD, 14));
        label10.setForeground(Color.white);
        label10.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label10);
        label10.setBounds(40, 395, 165, 25);

        //---- checkBox5 ----
        checkBox5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox5.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox5.setBackground(new Color(51, 102, 255));
        add(checkBox5);
        checkBox5.setBounds(210, 390, 25, 39);

        //---- label11 ----
        label11.setText("Fridge:");
        label11.setFont(new Font("Tahoma", Font.BOLD, 14));
        label11.setForeground(Color.white);
        label11.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label11);
        label11.setBounds(40, 425, 165, 25);

        //---- checkBox6 ----
        checkBox6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox6.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox6.setBackground(new Color(51, 102, 255));
        add(checkBox6);
        checkBox6.setBounds(210, 420, 25, 39);

        //---- label12 ----
        label12.setText("Kitchen:");
        label12.setFont(new Font("Tahoma", Font.BOLD, 14));
        label12.setForeground(Color.white);
        label12.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label12);
        label12.setBounds(40, 455, 165, 25);

        //---- checkBox7 ----
        checkBox7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox7.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox7.setBackground(new Color(51, 102, 255));
        add(checkBox7);
        checkBox7.setBounds(210, 450, 25, 35);

        //---- label13 ----
        label13.setText("TV:");
        label13.setFont(new Font("Tahoma", Font.BOLD, 14));
        label13.setForeground(Color.white);
        label13.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label13);
        label13.setBounds(40, 485, 165, 25);

        //---- checkBox8 ----
        checkBox8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox8.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox8.setBackground(new Color(51, 102, 255));
        add(checkBox8);
        checkBox8.setBounds(210, 480, 25, 30);

        //---- label14 ----
        label14.setText("Smoking allowed:");
        label14.setFont(new Font("Tahoma", Font.BOLD, 14));
        label14.setForeground(Color.white);
        label14.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label14);
        label14.setBounds(40, 515, 165, 25);

        //---- checkBox9 ----
        checkBox9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox9.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox9.setBackground(new Color(51, 102, 255));
        add(checkBox9);
        checkBox9.setBounds(210, 515, 25, 25);

        //---- label15 ----
        label15.setText("Pets allowed:");
        label15.setFont(new Font("Tahoma", Font.BOLD, 14));
        label15.setForeground(Color.white);
        label15.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label15);
        label15.setBounds(40, 545, 165, 25);

        //---- checkBox10 ----
        checkBox10.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox10.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox10.setBackground(new Color(51, 102, 255));
        add(checkBox10);
        checkBox10.setBounds(210, 540, 25, 30);

        //---- button2 ----
        button2.setText("Cancel");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> cancelClick(e));
        add(button2);
        button2.setBounds(55, 590, 125, 40);

        //---- button1 ----
        button1.setText("Add");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> addRoomClick(e));
        add(button1);
        button1.setBounds(220, 590, 125, 40);

        //---- spinner1 ----
        spinner1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        spinner1.setModel(new SpinnerNumberModel(1, 1, 99, 1));
        spinner1.setForeground(Color.black);
        spinner1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(spinner1);
        spinner1.setBounds(215, 235, 95, 25);

        //---- spinner2 ----
        spinner2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        spinner2.setModel(new SpinnerNumberModel(10, 1, 9999, 5));
        spinner2.setForeground(Color.black);
        spinner2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(spinner2);
        spinner2.setBounds(215, 195, 95, 25);

        //---- spinner3 ----
        spinner3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        spinner3.setModel(new SpinnerNumberModel(10.0, 0.01, 9999.0, 5.0));
        spinner3.setForeground(Color.black);
        spinner3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(spinner3);
        spinner3.setBounds(215, 155, 95, 25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
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
    private JLabel label6;
    private JLabel label16;
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
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
