import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.*;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 14:04:23 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class reserveRoomForm extends JPanel {
    JFrame jframe;
    reserveRoomForm currentForm;
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(reserveRoomForm currentForm) {
        this.currentForm = currentForm;
    }

    public void returnToPreviousFormState(int guests, LocalDate checkIn, LocalDate checkOut,
                                          String maxPrice, String typeFilter, Map<String, Boolean> previousFilters) {
        BoxOfGuests.setSelectedIndex(guests-1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        textCheckin.setText(checkIn.format(dtf));
        textCheckout.setText(checkOut.format(dtf));
        double price = 0;
        int type = 0;
        if (Objects.equals(typeFilter, "1")) {
            type = 1;
        } else if (Objects.equals(typeFilter, "2")) {
            type = 2;
        } else if (Objects.equals(typeFilter, "3")) {
            type = 3;
        }
        try {
            price = Double.parseDouble(maxPrice);
        } catch (NumberFormatException ignored) {}
        spinner1.setValue(price);
        comboBox1.setSelectedIndex(type);
        checkBox1.setSelected(previousFilters.get("Balcony"));
        checkBox2.setSelected(previousFilters.get("Kitchen"));
        checkBox3.setSelected(previousFilters.get("Wifi"));
        checkBox4.setSelected(previousFilters.get("AirCondition"));
        checkBox6.setSelected(previousFilters.get("Tv"));
        checkBox7.setSelected(previousFilters.get("Smoking"));
        checkBox8.setSelected(previousFilters.get("Pets"));
        checkBox9.setSelected(previousFilters.get("Fridge"));
        checkBox10.setSelected(previousFilters.get("Parking"));
    }

    public reserveRoomForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                           Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                           Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Customer customer) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.customer=customer;
        initComponents();
        jframe.setPreferredSize(new Dimension(430, 750));
        jframe.pack();
    }
    
    private void cancelButtonClick(ActionEvent e) {
        customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.customer);
        customerForm.setCurrentForm(customerForm);
        this.jframe.add(customerForm);
        this.currentForm.setVisible(false);
    }

    private void clearButtonClick(ActionEvent e) {
        textCheckout.setText("");
        textCheckin.setText("");
        BoxOfGuests.setSelectedIndex(0);
        spinner1.setValue(0);
        comboBox1.setSelectedIndex(0);
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBox6.setSelected(false);
        checkBox7.setSelected(false);
        checkBox8.setSelected(false);
        checkBox9.setSelected(false);
        checkBox10.setSelected(false);


    }

    private void searchButtonClick(ActionEvent e) {
        int guests = BoxOfGuests.getSelectedIndex()+1;

        boolean validInput = true;
        String dateIn = textCheckin.getText();
        LocalDate dateCheckIn = LocalDate.of(1, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            dateCheckIn = LocalDate.parse(dateIn, dtf);
            textCheckin.setForeground(null);
        } catch (java.time.format.DateTimeParseException ignored) {
            textCheckin.setForeground(Color.red);
            validInput = false;
        }

        String dateOut = textCheckout.getText();
        LocalDate dateCheckOut = LocalDate.of(1, 1, 1);
        try {
            dateCheckOut = LocalDate.parse(dateOut, dtf);
            if (dateCheckOut.isAfter(dateCheckIn)) {
                textCheckout.setForeground(null);
            }
            else {
                textCheckout.setForeground(Color.red);
                validInput = false;
            }
        } catch (java.time.format.DateTimeParseException ignored) {
            textCheckout.setForeground(Color.red);
            validInput = false;
        }

        Map<String, String> filters = new HashMap<>();
        Map<String, Boolean> filtersToReturnToPreviousFormState = new HashMap<>();

        filters.put("Type","-");
        filters.put("Price","-");
        filters.put("Balcony","-");
        filtersToReturnToPreviousFormState.put("Balcony",false);
        filters.put("Kitchen","-");
        filtersToReturnToPreviousFormState.put("Kitchen",false);
        filters.put("Wifi","-");
        filtersToReturnToPreviousFormState.put("Wifi",false);
        filters.put("Parking","-");
        filtersToReturnToPreviousFormState.put("Parking",false);
        filters.put("AirCondition","-");
        filtersToReturnToPreviousFormState.put("AirCondition",false);
        filters.put("Fridge","-");
        filtersToReturnToPreviousFormState.put("Fridge",false);
        filters.put("Tv","-");
        filtersToReturnToPreviousFormState.put("Tv",false);
        filters.put("Smoking","-");
        filtersToReturnToPreviousFormState.put("Smoking",false);
        filters.put("Pets","-");
        filtersToReturnToPreviousFormState.put("Pets",false);

        switch (comboBox1.getSelectedIndex()) {
            case 1 -> filters.put("Type", "hotel");
            case 2 -> filters.put("Type", "room");
            case 3 -> filters.put("Type", "apartment");
        }
        if ((Double) spinner1.getValue() != 0) {
            try {
                double input = Double.parseDouble(Double.toString((Double) spinner1.getValue()));
                filters.put("Price", Double.toString(input));
                spinner1.setForeground(Color.BLACK);
            } catch (java.util.InputMismatchException ignored) {
                spinner1.setForeground(Color.red);
                validInput = false;
            }
        }

        if (checkBox1.isSelected()) {filters.put("Balcony", "yes"); filtersToReturnToPreviousFormState.put("Balcony",true);}
        if (checkBox2.isSelected()) {filters.put("Kitchen", "yes"); filtersToReturnToPreviousFormState.put("Kitchen",true);}
        if (checkBox3.isSelected()) {filters.put("Wifi", "yes"); filtersToReturnToPreviousFormState.put("Wifi",true);}
        if (checkBox4.isSelected()) {filters.put("AirCondition", "yes"); filtersToReturnToPreviousFormState.put("AirCondition",true);}
        if (checkBox6.isSelected()) {filters.put("Tv", "yes"); filtersToReturnToPreviousFormState.put("Tv",true);}
        if (checkBox7.isSelected()) {filters.put("Smoking", "yes"); filtersToReturnToPreviousFormState.put("Smoking",true);}
        if (checkBox8.isSelected()) {filters.put("Pets", "yes"); filtersToReturnToPreviousFormState.put("Pets",true);}
        if (checkBox9.isSelected()) {filters.put("Fridge", "yes"); filtersToReturnToPreviousFormState.put("Fridge",true);}
        if (checkBox10.isSelected()) {filters.put("Parking", "yes"); filtersToReturnToPreviousFormState.put("Parking",true);}

        AtomicBoolean matchingRoom = new AtomicBoolean(false);
        Map<Integer, Room> filteredRooms = new HashMap<>();
        this.rooms.forEach((roomID,room) -> {
            matchingRoom.set(true);
            filters.forEach((filter,value) -> {
                if (!Objects.equals(value, "-") && !Objects.equals(filter, "Price")) {
                    Method method = null;
                    boolean booleanValue = Objects.equals(value, "yes");
                    try {
                        method = Room.class.getDeclaredMethod("get" + filter);
                    } catch (NoSuchMethodException ignored) {
                    }
                    try {
                        assert method != null;
                        if (!Objects.equals(filter, "Type")){
                            if ((boolean) method.invoke(room) != booleanValue) {
                                matchingRoom.set(false);
                            }
                        }
                        else {
                            if (method.invoke(room) != value) {
                                matchingRoom.set(false);
                            }
                        }
                    } catch (IllegalAccessException | InvocationTargetException ignored) {}
                }
            });
            if (matchingRoom.get()){
                filteredRooms.put(room.getId(),room);
            }
        });

        HashSet<Integer> idsToRemove = new HashSet<>();
        filteredRooms.forEach((id, room) -> {
            if (!Objects.equals(filters.get("Price"), "-")) {
                if (room.getPrice() > Double.parseDouble(filters.get("Price"))) {
                    idsToRemove.add(id);
                }
            }
        });
        idsToRemove.forEach(filteredRooms::remove);
        idsToRemove.clear();

        filteredRooms.forEach((id, room) -> {
            if (room.getCapacity() < guests){
                idsToRemove.add(id);
            }
        });
        idsToRemove.forEach(filteredRooms::remove);
        idsToRemove.clear();

        LocalDate finalCheckIn = dateCheckIn;
        LocalDate finalCheckOut = dateCheckOut;
        filteredRooms.forEach((roomID, room) -> this.reservations.forEach((reservationID, reservation) -> {
            if (reservations.get(reservationID).getRoomID() == roomID){
                if ((finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckIn()))
                        || ( finalCheckIn.isBefore(reservation.getCheckOut()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isBefore(reservation.getCheckIn()) && finalCheckOut.isAfter(reservation.getCheckOut()))
                        || (finalCheckIn.isAfter(reservation.getCheckIn()) && finalCheckOut.isBefore(reservation.getCheckOut()))) {
                    idsToRemove.add(roomID);
                }
            }
        }));
        idsToRemove.forEach(filteredRooms::remove);

        if (validInput){
            reserveRoomCustomerForm reserveRoomCustomerForm = new reserveRoomCustomerForm(this.jframe,
                    this.reservations, this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                    this.mainUI, this.customer, guests, dateCheckIn, dateCheckOut, filteredRooms,
                    filtersToReturnToPreviousFormState, filters.get("Type"), filters.get("Price"));
            reserveRoomCustomerForm.setCurrentForm(reserveRoomCustomerForm);
            this.jframe.add(reserveRoomCustomerForm);
            this.currentForm.setVisible(false);
            filters.clear();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label2 = new JLabel();
        labelGuests = new JLabel();
        BoxOfGuests = new JComboBox<>();
        labelCheckin = new JLabel();
        textCheckin = new JTextField();
        labelCheckout = new JLabel();
        textCheckout = new JTextField();
        label1 = new JLabel();
        label3 = new JLabel();
        spinner1 = new JSpinner();
        label4 = new JLabel();
        comboBox1 = new JComboBox<>();
        label5 = new JLabel();
        checkBox1 = new JCheckBox();
        label6 = new JLabel();
        checkBox2 = new JCheckBox();
        label7 = new JLabel();
        checkBox3 = new JCheckBox();
        label13 = new JLabel();
        checkBox10 = new JCheckBox();
        label8 = new JLabel();
        checkBox4 = new JCheckBox();
        label9 = new JLabel();
        checkBox9 = new JCheckBox();
        label10 = new JLabel();
        checkBox6 = new JCheckBox();
        label11 = new JLabel();
        checkBox7 = new JCheckBox();
        label12 = new JLabel();
        checkBox8 = new JCheckBox();
        buttonBack = new JButton();
        buttonClear = new JButton();
        buttonSearch = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //---- label2 ----
        label2.setText("Room reservation");
        label2.setFont(new Font("Tahoma", Font.BOLD, 22));
        label2.setForeground(Color.white);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2);
        label2.setBounds(100, 15, 225, 40);

        //---- labelGuests ----
        labelGuests.setText("Total guests:");
        labelGuests.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGuests.setForeground(Color.white);
        labelGuests.setHorizontalAlignment(SwingConstants.RIGHT);
        add(labelGuests);
        labelGuests.setBounds(80, 65, 105, 25);

        //---- BoxOfGuests ----
        BoxOfGuests.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
        }));
        BoxOfGuests.setFont(new Font("Tahoma", Font.PLAIN, 14));
        BoxOfGuests.setForeground(Color.black);
        BoxOfGuests.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        add(BoxOfGuests);
        BoxOfGuests.setBounds(200, 65, 75, 25);

        //---- labelCheckin ----
        labelCheckin.setText("Check-in:");
        labelCheckin.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCheckin.setForeground(Color.white);
        labelCheckin.setHorizontalAlignment(SwingConstants.RIGHT);
        add(labelCheckin);
        labelCheckin.setBounds(80, 95, 105, 25);

        //---- textCheckin ----
        textCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textCheckin);
        textCheckin.setBounds(200, 95, 130, 25);

        //---- labelCheckout ----
        labelCheckout.setText("Check-out:");
        labelCheckout.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCheckout.setForeground(Color.white);
        labelCheckout.setHorizontalAlignment(SwingConstants.RIGHT);
        add(labelCheckout);
        labelCheckout.setBounds(80, 125, 105, 25);

        //---- textCheckout ----
        textCheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(textCheckout);
        textCheckout.setBounds(200, 125, 130, 25);

        //---- label1 ----
        label1.setText("Filters:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(180, 180, 60, 25);

        //---- label3 ----
        label3.setText("Max price ($/night):");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(45, 235, 150, 25);

        //---- spinner1 ----
        spinner1.setModel(new SpinnerNumberModel(0.0, 0.0, null, 5.0));
        spinner1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spinner1.setForeground(Color.black);
        spinner1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        add(spinner1);
        spinner1.setBounds(220, 235, 130, 25);

        //---- label4 ----
        label4.setText("Type:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        label4.setBounds(45, 270, 150, 25);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Hotel",
            "Room",
            "Apartment"
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox1.setForeground(Color.black);
        comboBox1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        add(comboBox1);
        comboBox1.setBounds(220, 270, 130, 25);

        //---- label5 ----
        label5.setText("Balcony:");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label5);
        label5.setBounds(45, 305, 150, 25);

        //---- checkBox1 ----
        checkBox1.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox1.setBackground(new Color(51, 102, 255));
        add(checkBox1);
        checkBox1.setBounds(215, 305, 20, checkBox1.getPreferredSize().height);

        //---- label6 ----
        label6.setText("Kitchen:");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label6);
        label6.setBounds(45, 340, 150, 25);

        //---- checkBox2 ----
        checkBox2.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox2.setBackground(new Color(51, 102, 255));
        add(checkBox2);
        checkBox2.setBounds(215, 340, 20, checkBox2.getPreferredSize().height);

        //---- label7 ----
        label7.setText("Free WiFi:");
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.white);
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label7);
        label7.setBounds(45, 375, 150, 25);

        //---- checkBox3 ----
        checkBox3.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox3.setBackground(new Color(51, 102, 255));
        add(checkBox3);
        checkBox3.setBounds(215, 375, 20, checkBox3.getPreferredSize().height);

        //---- label13 ----
        label13.setText("Free parking:");
        label13.setFont(new Font("Tahoma", Font.BOLD, 14));
        label13.setForeground(Color.white);
        label13.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label13);
        label13.setBounds(45, 410, 150, 25);

        //---- checkBox10 ----
        checkBox10.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox10.setBackground(new Color(51, 102, 255));
        add(checkBox10);
        checkBox10.setBounds(215, 410, 20, checkBox10.getPreferredSize().height);

        //---- label8 ----
        label8.setText("Air condition:");
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setForeground(Color.white);
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label8);
        label8.setBounds(45, 445, 150, 25);

        //---- checkBox4 ----
        checkBox4.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox4.setBackground(new Color(51, 102, 255));
        add(checkBox4);
        checkBox4.setBounds(215, 445, 20, checkBox4.getPreferredSize().height);

        //---- label9 ----
        label9.setText("Fridge:");
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        label9.setForeground(Color.white);
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label9);
        label9.setBounds(45, 480, 150, 25);

        //---- checkBox9 ----
        checkBox9.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox9.setBackground(new Color(51, 102, 255));
        add(checkBox9);
        checkBox9.setBounds(215, 480, 20, checkBox9.getPreferredSize().height);

        //---- label10 ----
        label10.setText("TV:");
        label10.setFont(new Font("Tahoma", Font.BOLD, 14));
        label10.setForeground(Color.white);
        label10.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label10);
        label10.setBounds(45, 515, 150, 25);

        //---- checkBox6 ----
        checkBox6.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox6.setBackground(new Color(51, 102, 255));
        add(checkBox6);
        checkBox6.setBounds(215, 515, 20, checkBox6.getPreferredSize().height);

        //---- label11 ----
        label11.setText("Smoking allowed:");
        label11.setFont(new Font("Tahoma", Font.BOLD, 14));
        label11.setForeground(Color.white);
        label11.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label11);
        label11.setBounds(45, 550, 150, 25);

        //---- checkBox7 ----
        checkBox7.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox7.setBackground(new Color(51, 102, 255));
        add(checkBox7);
        checkBox7.setBounds(215, 550, 20, checkBox7.getPreferredSize().height);

        //---- label12 ----
        label12.setText("Pets allowed:");
        label12.setFont(new Font("Tahoma", Font.BOLD, 14));
        label12.setForeground(Color.white);
        label12.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label12);
        label12.setBounds(45, 585, 150, 25);

        //---- checkBox8 ----
        checkBox8.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBox8.setBackground(new Color(51, 102, 255));
        add(checkBox8);
        checkBox8.setBounds(215, 585, 20, checkBox8.getPreferredSize().height);

        //---- buttonBack ----
        buttonBack.setText("Cancel");
        buttonBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonBack.setForeground(Color.white);
        buttonBack.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        buttonBack.addActionListener(e -> cancelButtonClick(e));
        add(buttonBack);
        buttonBack.setBounds(20, 655, 120, 40);

        //---- buttonClear ----
        buttonClear.setText("Clear");
        buttonClear.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonClear.setForeground(Color.white);
        buttonClear.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        buttonClear.addActionListener(e -> clearButtonClick(e));
        add(buttonClear);
        buttonClear.setBounds(155, 655, 120, 40);

        //---- buttonSearch ----
        buttonSearch.setText("Search");
        buttonSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonSearch.setForeground(Color.white);
        buttonSearch.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        buttonSearch.addActionListener(e -> searchButtonClick(e));
        add(buttonSearch);
        buttonSearch.setBounds(290, 655, 120, 40);

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
    private JLabel label2;
    private JLabel labelGuests;
    private JComboBox<String> BoxOfGuests;
    private JLabel labelCheckin;
    private JTextField textCheckin;
    private JLabel labelCheckout;
    private JTextField textCheckout;
    private JLabel label1;
    private JLabel label3;
    private JSpinner spinner1;
    private JLabel label4;
    private JComboBox<String> comboBox1;
    private JLabel label5;
    private JCheckBox checkBox1;
    private JLabel label6;
    private JCheckBox checkBox2;
    private JLabel label7;
    private JCheckBox checkBox3;
    private JLabel label13;
    private JCheckBox checkBox10;
    private JLabel label8;
    private JCheckBox checkBox4;
    private JLabel label9;
    private JCheckBox checkBox9;
    private JLabel label10;
    private JCheckBox checkBox6;
    private JLabel label11;
    private JCheckBox checkBox7;
    private JLabel label12;
    private JCheckBox checkBox8;
    private JButton buttonBack;
    private JButton buttonClear;
    private JButton buttonSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
