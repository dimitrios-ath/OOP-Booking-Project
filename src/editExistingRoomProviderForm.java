import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Objects;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 17:56:07 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class editExistingRoomProviderForm extends JPanel {
    JFrame jframe;
    editExistingRoomProviderForm currentForm;
    private final Provider provider;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    private final Integer idToEdit;

    public void setCurrentForm(editExistingRoomProviderForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public editExistingRoomProviderForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                Map<String,Authentication> users, Map<String,Customer> customers, Map<String, Provider> providers,
                Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Provider provider, Integer id) {
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
        this.idToEdit = id;
        jframe.setPreferredSize(new Dimension(357 , 511));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        initComponents();
        initComponents();
        
        if (Objects.equals(rooms.get(idToEdit).getType(), "hotel")) {
            comboBox1.setSelectedIndex(0);
        } else if (Objects.equals(rooms.get(idToEdit).getType(), "room")) {
            comboBox1.setSelectedIndex(1);
        } else {comboBox1.setSelectedIndex(2);}
        textField1.setText(rooms.get(idToEdit).getName());
        textField2.setText(rooms.get(idToEdit).getPrice().toString());
        textField3.setText(rooms.get(idToEdit).getM2().toString());
        textField4.setText(rooms.get(idToEdit).getCapacity().toString());
        if (rooms.get(idToEdit).getLongTime()) {checkBox1.setSelected(true);}
        if (rooms.get(idToEdit).getWifi()) {checkBox2.setSelected(true);}
        if (rooms.get(idToEdit).getParking()) {checkBox3.setSelected(true);}
        if (rooms.get(idToEdit).getAirCondition()) {checkBox4.setSelected(true);}
        if (rooms.get(idToEdit).getBalcony()) {checkBox5.setSelected(true);}
        if (rooms.get(idToEdit).getFridge()) {checkBox6.setSelected(true);}
        if (rooms.get(idToEdit).getKitchen()) {checkBox7.setSelected(true);}
        if (rooms.get(idToEdit).getTv()) {checkBox8.setSelected(true);}
        if (rooms.get(idToEdit).getSmoking()) {checkBox9.setSelected(true);}
        if (rooms.get(idToEdit).getPets()) {checkBox10.setSelected(true);}
        
    }

    private void cancelClick(ActionEvent e) {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    private void editRoomClick(ActionEvent e) {
        boolean validInput = true;

        String type;
        if (comboBox1.getSelectedItem() == "Hotel") {
            type = "hotel";
        } else if (comboBox1.getSelectedItem() == "Room") {
            type = "room";
        } else {type = "apartment";}

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
            rooms.put(idToEdit, new Room(idToEdit, provider.getUsername(), name, type, longTime, capacity, price,
                    size, wifi, parking, airCondition, balcony, fridge, kitchen, tv, smoking, pets));
            providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.provider);
            providerForm.setCurrentForm(providerForm);
            this.jframe.add(providerForm);
            this.currentForm.setVisible(false);
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label2 = new JLabel();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        label4 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField2 = new JTextField();
        label6 = new JLabel();
        textField3 = new JTextField();
        label16 = new JLabel();
        textField4 = new JTextField();
        label1 = new JLabel();
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
        setForeground(Color.white);
        setBackground(new Color(51, 102, 255));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label2 ----
        label2.setText("Edit existing room");
        label2.setFont(new Font("Tahoma", Font.BOLD, 22));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(new Rectangle(new Point(80, 5), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Type:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(34, 57, 103, label3.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Hotel",
            "Room",
            "Apartment"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(comboBox1);
        comboBox1.setBounds(215, 60, 115, comboBox1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Name:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        add(label4);
        label4.setBounds(34, 83, 51, label4.getPreferredSize().height);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField1);
        textField1.setBounds(215, 85, 115, textField1.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Price:");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        add(label5);
        label5.setBounds(34, 109, 76, label5.getPreferredSize().height);

        //---- textField2 ----
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField2);
        textField2.setBounds(215, 110, 115, textField2.getPreferredSize().height);

        //---- label6 ----
        label6.setText("Size:");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        add(label6);
        label6.setBounds(34, 135, 76, label6.getPreferredSize().height);

        //---- textField3 ----
        textField3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField3);
        textField3.setBounds(215, 135, 115, textField3.getPreferredSize().height);

        //---- label16 ----
        label16.setText("Capacity:");
        label16.setFont(new Font("Tahoma", Font.BOLD, 14));
        label16.setForeground(Color.white);
        add(label16);
        label16.setBounds(34, 161, 103, label16.getPreferredSize().height);

        //---- textField4 ----
        textField4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textField4);
        textField4.setBounds(215, 160, 115, textField4.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Long term reservation:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(34, 188), label1.getPreferredSize()));

        //---- checkBox1 ----
        checkBox1.setBackground(new Color(51, 102, 255));
        add(checkBox1);
        checkBox1.setBounds(260, 185, 30, checkBox1.getPreferredSize().height);

        //---- label7 ----
        label7.setText("Free WiFi:");
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.white);
        add(label7);
        label7.setBounds(34, 216, 103, label7.getPreferredSize().height);

        //---- checkBox2 ----
        checkBox2.setBackground(new Color(51, 102, 255));
        add(checkBox2);
        checkBox2.setBounds(260, 210, 25, checkBox2.getPreferredSize().height);

        //---- label8 ----
        label8.setText("Free Parking:");
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setForeground(Color.white);
        add(label8);
        label8.setBounds(34, 244, 103, label8.getPreferredSize().height);

        //---- checkBox3 ----
        checkBox3.setBackground(new Color(51, 102, 255));
        add(checkBox3);
        checkBox3.setBounds(260, 235, 20, checkBox3.getPreferredSize().height);

        //---- label9 ----
        label9.setText("Air condition:");
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        label9.setForeground(Color.white);
        add(label9);
        label9.setBounds(34, 272, 103, label9.getPreferredSize().height);

        //---- checkBox4 ----
        checkBox4.setBackground(new Color(51, 102, 255));
        add(checkBox4);
        checkBox4.setBounds(260, 260, 20, checkBox4.getPreferredSize().height);

        //---- label10 ----
        label10.setText("Balcony:");
        label10.setFont(new Font("Tahoma", Font.BOLD, 14));
        label10.setForeground(Color.white);
        add(label10);
        label10.setBounds(34, 300, 103, label10.getPreferredSize().height);

        //---- checkBox5 ----
        checkBox5.setBackground(new Color(51, 102, 255));
        add(checkBox5);
        checkBox5.setBounds(260, 290, 20, checkBox5.getPreferredSize().height);

        //---- label11 ----
        label11.setText("Fridge:");
        label11.setFont(new Font("Tahoma", Font.BOLD, 14));
        label11.setForeground(Color.white);
        add(label11);
        label11.setBounds(34, 328, 103, label11.getPreferredSize().height);

        //---- checkBox6 ----
        checkBox6.setBackground(new Color(51, 102, 255));
        add(checkBox6);
        checkBox6.setBounds(260, 315, 20, checkBox6.getPreferredSize().height);

        //---- label12 ----
        label12.setText("Kitchen:");
        label12.setFont(new Font("Tahoma", Font.BOLD, 14));
        label12.setForeground(Color.white);
        add(label12);
        label12.setBounds(34, 356, 103, label12.getPreferredSize().height);

        //---- checkBox7 ----
        checkBox7.setBackground(new Color(51, 102, 255));
        add(checkBox7);
        checkBox7.setBounds(260, 345, 20, checkBox7.getPreferredSize().height);

        //---- label13 ----
        label13.setText("TV:");
        label13.setFont(new Font("Tahoma", Font.BOLD, 14));
        label13.setForeground(Color.white);
        add(label13);
        label13.setBounds(34, 384, 103, label13.getPreferredSize().height);

        //---- checkBox8 ----
        checkBox8.setBackground(new Color(51, 102, 255));
        add(checkBox8);
        checkBox8.setBounds(260, 375, 20, checkBox8.getPreferredSize().height);

        //---- label14 ----
        label14.setText("Smoking allowed:");
        label14.setFont(new Font("Tahoma", Font.BOLD, 14));
        label14.setForeground(Color.white);
        add(label14);
        label14.setBounds(34, 412, 103, label14.getPreferredSize().height);

        //---- checkBox9 ----
        checkBox9.setBackground(new Color(51, 102, 255));
        add(checkBox9);
        checkBox9.setBounds(260, 400, 20, checkBox9.getPreferredSize().height);

        //---- label15 ----
        label15.setText("Pets allowed:");
        label15.setFont(new Font("Tahoma", Font.BOLD, 14));
        label15.setForeground(Color.white);
        add(label15);
        label15.setBounds(34, 440, 103, label15.getPreferredSize().height);

        //---- checkBox10 ----
        checkBox10.setBackground(new Color(51, 102, 255));
        add(checkBox10);
        checkBox10.setBounds(260, 430, 20, checkBox10.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Cancel");
        button2.setForeground(new Color(51, 102, 255));
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.addActionListener(e -> cancelClick(e));
        add(button2);
        button2.setBounds(35, 470, 103, button2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Edit");
        button1.setForeground(new Color(51, 102, 255));
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.addActionListener(e -> editRoomClick(e));
        add(button1);
        button1.setBounds(215, 470, 115, button1.getPreferredSize().height);

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
    private JLabel label2;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JLabel label4;
    private JTextField textField1;
    private JLabel label5;
    private JTextField textField2;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label16;
    private JTextField textField4;
    private JLabel label1;
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
