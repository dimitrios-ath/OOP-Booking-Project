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

public class customerReserveRoomFiltersForm extends JPanel {
    JFrame jframe;
    customerReserveRoomFiltersForm currentForm;
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(customerReserveRoomFiltersForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Returns to the previous form state, given previous attributes as parameters
     *
     * @param guests
     * @param checkIn
     * @param checkOut
     * @param maxPrice
     * @param typeFilter
     * @param previousFilters
     */
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

    /**
     * Constructor of customerReserveRoomFiltersForm
     *
     * @param jframe
     * @param reservations
     * @param rooms
     * @param users
     * @param customers
     * @param providers
     * @param admins
     * @param messages
     * @param mainUI
     * @param customer
     */
    public customerReserveRoomFiltersForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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

    /**
     * Returns to the customer panel
     */
    private void cancelButtonClick() {
        customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.customer);
        customerForm.setCurrentForm(customerForm);
        this.jframe.add(customerForm);
        this.currentForm.setVisible(false);
    }

    /**
     * Resets form
     */
    private void clearButtonClick() {
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

    /**
     *  If the form data are valid and sufficient, proceeds to customer reserve room form
     *  and passed filtered rooms as parameter
     */
    private void searchButtonClick() {
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
            customerReserveRoomForm customerReserveRoomForm = new customerReserveRoomForm(this.jframe,
                    this.reservations, this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                    this.mainUI, this.customer, guests, dateCheckIn, dateCheckOut, filteredRooms,
                    filtersToReturnToPreviousFormState, filters.get("Type"), filters.get("Price"));
            customerReserveRoomForm.setCurrentForm(customerReserveRoomForm);
            this.jframe.add(customerReserveRoomForm);
            this.currentForm.setVisible(false);
            filters.clear();
        }
    }

    private void textCheckinMouseClicked() {
        textCheckin.setText("");
        textCheckin.setForeground(Color.black);
    }

    private void textCheckoutMouseClicked() {
        textCheckout.setText("");
        textCheckout.setForeground(Color.black);
    }

    /**
     *   Form generator
     */
    private void initComponents() {
        JLabel label2 = new JLabel();
        JLabel labelGuests = new JLabel();
        BoxOfGuests = new JComboBox<>();
        JLabel labelCheckin = new JLabel();
        textCheckin = new JTextField();
        JLabel labelCheckout = new JLabel();
        textCheckout = new JTextField();
        JLabel label1 = new JLabel();
        JLabel label3 = new JLabel();
        spinner1 = new JSpinner();
        JLabel label4 = new JLabel();
        comboBox1 = new JComboBox<>();
        JLabel label5 = new JLabel();
        checkBox1 = new JCheckBox();
        JLabel label6 = new JLabel();
        checkBox2 = new JCheckBox();
        JLabel label7 = new JLabel();
        checkBox3 = new JCheckBox();
        JLabel label13 = new JLabel();
        checkBox10 = new JCheckBox();
        JLabel label8 = new JLabel();
        checkBox4 = new JCheckBox();
        JLabel label9 = new JLabel();
        checkBox9 = new JCheckBox();
        JLabel label10 = new JLabel();
        checkBox6 = new JCheckBox();
        JLabel label11 = new JLabel();
        checkBox7 = new JCheckBox();
        JLabel label12 = new JLabel();
        checkBox8 = new JCheckBox();
        JButton buttonBack = new JButton();
        JButton buttonClear = new JButton();
        JButton buttonSearch = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
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

        textCheckin.setText("dd-MM-yyyy");
        textCheckin.setForeground(Color.gray);
        textCheckin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textCheckinMouseClicked();
            }
        });
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

        textCheckout.setText("dd-MM-yyyy");
        textCheckout.setForeground(Color.gray);
        textCheckout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textCheckoutMouseClicked();
            }
        });
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
        buttonBack.setForeground(new Color(51, 102, 255));

        buttonBack.addActionListener(e -> cancelButtonClick());
        add(buttonBack);
        buttonBack.setBounds(20, 655, 120, 40);

        //---- buttonClear ----
        buttonClear.setText("Clear");
        buttonClear.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonClear.setForeground(new Color(51, 102, 255));

        buttonClear.addActionListener(e -> clearButtonClick());
        add(buttonClear);
        buttonClear.setBounds(155, 655, 120, 40);

        //---- buttonSearch ----
        buttonSearch.setText("Search");
        buttonSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonSearch.setForeground(new Color(51, 102, 255));

        buttonSearch.addActionListener(e -> searchButtonClick());
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
    }
    private JComboBox<String> BoxOfGuests;
    private JTextField textCheckin;
    private JTextField textCheckout;
    private JSpinner spinner1;
    private JComboBox<String> comboBox1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox10;
    private JCheckBox checkBox4;
    private JCheckBox checkBox9;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
}
