import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.Map;
import java.util.Objects;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import net.miginfocom.swing.*;
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
        jframe.setPreferredSize(new Dimension(430 , 510));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
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
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
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
        setBackground(new Color(51, 102, 255));
        setAlignmentX(0.1F);
        setAlignmentY(0.1F);
        setMaximumSize(null);
        setPreferredSize(new Dimension(150, 150));
        setMinimumSize(null);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Add new Room");
        label1.setFont(new Font("Century Gothic", Font.BOLD, 18));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(140, 10, 140, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Type:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(55, 65, 70, label2.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "-",
            "Hotel",
            "Room",
            "Apartment"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox1.setEditable(true);
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.black, Color.gray, Color.white, Color.lightGray));
        comboBox1.setForeground(new Color(51, 102, 255));
        add(comboBox1);
        comboBox1.setBounds(225, 65, 135, 25);

        //---- label3 ----
        label3.setText("Name:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(55, 105, 70, 15);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField1);
        textField1.setBounds(225, 105, 135, 25);

        //---- label5 ----
        label5.setText("Price:");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        add(label5);
        label5.setBounds(55, 145, 119, 15);

        //---- textField2 ----
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.black, Color.gray, Color.white, Color.lightGray));
        add(textField2);
        textField2.setBounds(225, 145, 135, 25);

        //---- label6 ----
        label6.setText("Size:");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        add(label6);
        label6.setBounds(55, 185, 105, 15);

        //---- textField3 ----
        textField3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.black, Color.gray, Color.white, Color.lightGray));
        add(textField3);
        textField3.setBounds(225, 185, 135, 25);

        //---- label16 ----
        label16.setText("Capacity:");
        label16.setFont(new Font("Tahoma", Font.BOLD, 14));
        label16.setForeground(Color.white);
        add(label16);
        label16.setBounds(50, 225, 119, 15);

        //---- textField4 ----
        textField4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.black, Color.gray, Color.white, Color.lightGray));
        add(textField4);
        textField4.setBounds(225, 225, 135, 25);

        //---- label4 ----
        label4.setText("Long term reservation:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        add(label4);
        label4.setBounds(50, 300, label4.getPreferredSize().width, 15);

        //---- checkBox1 ----
        checkBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox1.setBackground(new Color(51, 102, 255));
        add(checkBox1);
        checkBox1.setBounds(280, 265, 25, 20);

        //---- label7 ----
        label7.setText("Free WiFi:");
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.white);
        add(label7);
        label7.setBounds(50, 265, 119, 15);

        //---- checkBox2 ----
        checkBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox2.setBackground(new Color(51, 102, 255));
        add(checkBox2);
        checkBox2.setBounds(280, 295, 25, 29);

        //---- label8 ----
        label8.setText("Free Parking:");
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setForeground(Color.white);
        add(label8);
        label8.setBounds(50, 335, 119, label8.getPreferredSize().height);

        //---- checkBox3 ----
        checkBox3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox3.setBackground(new Color(51, 102, 255));
        add(checkBox3);
        checkBox3.setBounds(280, 320, 25, 39);

        //---- label9 ----
        label9.setText("Air condition:");
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        label9.setForeground(Color.white);
        add(label9);
        label9.setBounds(50, 365, 119, label9.getPreferredSize().height);

        //---- checkBox4 ----
        checkBox4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox4.setBackground(new Color(51, 102, 255));
        add(checkBox4);
        checkBox4.setBounds(280, 355, 25, 35);

        //---- label10 ----
        label10.setText("Balcony:");
        label10.setFont(new Font("Tahoma", Font.BOLD, 14));
        label10.setForeground(Color.white);
        add(label10);
        label10.setBounds(50, 395, 119, label10.getPreferredSize().height);

        //---- checkBox5 ----
        checkBox5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox5.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox5.setBackground(new Color(51, 102, 255));
        add(checkBox5);
        checkBox5.setBounds(280, 385, 25, 39);

        //---- label11 ----
        label11.setText("Fridge:");
        label11.setFont(new Font("Tahoma", Font.BOLD, 14));
        label11.setForeground(Color.white);
        add(label11);
        label11.setBounds(50, 425, 119, label11.getPreferredSize().height);

        //---- checkBox6 ----
        checkBox6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox6.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox6.setBackground(new Color(51, 102, 255));
        add(checkBox6);
        checkBox6.setBounds(280, 415, 25, 39);

        //---- label12 ----
        label12.setText("Kitchen:");
        label12.setFont(new Font("Tahoma", Font.BOLD, 14));
        label12.setForeground(Color.white);
        add(label12);
        label12.setBounds(50, 455, 119, label12.getPreferredSize().height);

        //---- checkBox7 ----
        checkBox7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox7.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox7.setBackground(new Color(51, 102, 255));
        add(checkBox7);
        checkBox7.setBounds(280, 450, 25, 35);

        //---- label13 ----
        label13.setText("TV:");
        label13.setFont(new Font("Tahoma", Font.BOLD, 14));
        label13.setForeground(Color.white);
        add(label13);
        label13.setBounds(50, 485, 119, label13.getPreferredSize().height);

        //---- checkBox8 ----
        checkBox8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox8.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox8.setBackground(new Color(51, 102, 255));
        add(checkBox8);
        checkBox8.setBounds(280, 485, 25, 30);

        //---- label14 ----
        label14.setText("Smoking allowed:");
        label14.setFont(new Font("Tahoma", Font.BOLD, 14));
        label14.setForeground(Color.white);
        add(label14);
        label14.setBounds(50, 515, 150, label14.getPreferredSize().height);

        //---- checkBox9 ----
        checkBox9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox9.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox9.setBackground(new Color(51, 102, 255));
        add(checkBox9);
        checkBox9.setBounds(280, 520, 25, 25);

        //---- label15 ----
        label15.setText("Pets allowed:");
        label15.setFont(new Font("Tahoma", Font.BOLD, 14));
        label15.setForeground(Color.white);
        add(label15);
        label15.setBounds(50, 555, 119, label15.getPreferredSize().height);

        //---- checkBox10 ----
        checkBox10.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkBox10.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.black, Color.white, Color.gray, Color.white));
        checkBox10.setBackground(new Color(51, 102, 255));
        add(checkBox10);
        checkBox10.setBounds(280, 545, 25, 30);

        //---- button2 ----
        button2.setText("Cancel");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> cancelClick(e));
        add(button2);
        button2.setBounds(50, 590, 95, 20);

        //---- button1 ----
        button1.setText("Add");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(0, 102, 255));
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> addRoomClick(e));
        add(button1);
        button1.setBounds(230, 590, 130, 20);

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
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
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
