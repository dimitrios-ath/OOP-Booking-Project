import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Thu Jan 06 18:18:46 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class FilteredSearchRoomCustomerForm extends JPanel {
    JFrame jframe;
    FilteredSearchRoomCustomerForm currentForm;
    private Customer customer;
    private Room room;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

    public void setCurrentForm(FilteredSearchRoomCustomerForm currentForm) {
        this.currentForm = currentForm;
    }


    public FilteredSearchRoomCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                        Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                        Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI,Customer customer) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.customer= customer;
        initComponents();
    }
    private void backButtonClick(ActionEvent e){
        SearchAndReserveCustomerForm searchAndReserveCustomerForm= new SearchAndReserveCustomerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.customer,this.room);
        searchAndReserveCustomerForm.setCurrentForm(searchAndReserveCustomerForm);
        this.jframe.add(searchAndReserveCustomerForm);
        this.currentForm.setVisible(false);
    }
    private void clearButtonClick(ActionEvent e){
        textFieldPrice.setText("");
    }
    private void searchButtonClick(ActionEvent e){
        Integer guests = 0;

        String text = (String)ComboBoxGuests.getSelectedItem();

        boolean validInput = true;
        if (text == "-") {
            ComboBoxGuests.setForeground(Color.red);
            validInput = false;
        } else {
            guests = Integer.parseInt(text);
            ComboBoxGuests.setForeground(null);
        }

        String dateIn=textFieldCheckin.getText();
        LocalDate dateCheckin= LocalDate.of(1, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            dateCheckin = LocalDate.parse(dateIn, dtf);
            textFieldCheckin.setForeground(null);
        } catch (java.time.format.DateTimeParseException ignored) {
            textFieldCheckin.setForeground(Color.red);
            validInput = false;
        }

        String dateOut=textFieldCheckout.getText();
        LocalDate dateCheckout= LocalDate.of(1, 1, 1);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            dateCheckout = LocalDate.parse(dateOut, df);
                if (dateCheckout.isAfter(dateCheckin)){
                textFieldCheckout.setForeground(null);
            }

        } catch (java.time.format.DateTimeParseException ignored) {
            textFieldCheckout.setForeground(Color.red);
            validInput = false;
        }
        
        double pricePerNight = 0;
        try {
            double Price= Double.parseDouble(textFieldPrice.getText());
            textFieldPrice.setForeground(null);
            pricePerNight=Price;
        }catch (NumberFormatException ignored){
            textFieldPrice.setForeground(Color.red);
            validInput = false;
        }
        int M2=0;
        try{
            int metres=Integer.parseInt(textFieldM2.getText());
            textFieldM2.setForeground(null);
            M2=metres;
        }catch(NumberFormatException ignored){
            textFieldM2.setForeground(Color.red);
            validInput = false;
        }
        
        String type = "";
        if (ComboBoxRoomType.getSelectedItem() == "-") {
            ComboBoxRoomType.setForeground(Color.red);
            validInput = false;
        }
        else {
            if (ComboBoxRoomType.getSelectedItem() == "Hotel") {
                type = "hotel";
            } else if (ComboBoxRoomType.getSelectedItem() == "Room") {
                type = "room";
            } else {type = "apartment";}
            ComboBoxRoomType.setForeground(null);
        }
        
        boolean balcony = CheckBoxBalcony.isSelected();
        boolean kitchen = checkBoxKitchen.isSelected();
        boolean wifi = checkBoxWifi.isSelected();
        boolean parking = checkBoxParking.isSelected();
        boolean airCondition = checkBoxAir.isSelected();
        boolean fridge = checkBoxFridge.isSelected();
        boolean tv = checkBoxTv.isSelected();
        boolean smoking = checkBoxSmoking.isSelected();
        boolean pets = checkBoxPetsAllowed.isSelected();
        boolean longAcc=checkBoxLongAccomond.isSelected();
       // if (validInput) {
        if (dateCheckout.isAfter(dateCheckin)) {
            textFieldCheckout.setForeground(null);
                FilteredSearchRoomList filteredSearchRoomList = new FilteredSearchRoomList(this.jframe, this.reservations,
                        this.rooms, this.users,
                        this.customers, this.providers, this.admins, this.messages, this.mainUI, this.customer, balcony, kitchen, wifi,
                        parking, airCondition, fridge, tv, smoking, longAcc, pets, guests, dateCheckin, dateCheckout, pricePerNight, M2);
                filteredSearchRoomList.setCurrentForm(filteredSearchRoomList);
                this.jframe.add(filteredSearchRoomList);
                this.currentForm.setVisible(false);
            }
        //}

        


    
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        labelOfclass = new JLabel();
        labelPrice = new JLabel();
        textFieldPrice = new JTextField();
        labaleRoomType = new JLabel();
        label3 = new JLabel();
        CheckBoxBalcony = new JCheckBox();
        label4 = new JLabel();
        ComboBoxRoomType = new JComboBox<>();
        checkBoxKitchen = new JCheckBox();
        label5 = new JLabel();
        checkBoxWifi = new JCheckBox();
        checkBoxParking = new JCheckBox();
        labelParking = new JLabel();
        labelAir = new JLabel();
        checkBoxAir = new JCheckBox();
        labelFridge = new JLabel();
        checkBoxFridge = new JCheckBox();
        labelTv = new JLabel();
        checkBoxTv = new JCheckBox();
        labelSmoking = new JLabel();
        checkBoxSmoking = new JCheckBox();
        labelPetsAllowed = new JLabel();
        checkBoxPetsAllowed = new JCheckBox();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        labelGuests = new JLabel();
        ComboBoxGuests = new JComboBox<>();
        labelCheckin = new JLabel();
        textFieldCheckin = new JTextField();
        labelCheckout = new JLabel();
        textFieldCheckout = new JTextField();
        labelLongAccomon = new JLabel();
        checkBoxLongAccomond = new JCheckBox();
        labelM2 = new JLabel();
        textFieldM2 = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- labelOfclass ----
        labelOfclass.setText("Filtered Search");

        //---- labelPrice ----
        labelPrice.setText("max price/night:");

        //---- labaleRoomType ----
        labaleRoomType.setText("room Type:");

        //---- label3 ----
        label3.setText("Balcony");

        //---- label4 ----
        label4.setText("Kitchen");

        //---- ComboBoxRoomType ----
        ComboBoxRoomType.setModel(new DefaultComboBoxModel<>(new String[] {
            "hotel",
            "room",
            "apartment"
        }));

        //---- label5 ----
        label5.setText("Free Wifi");

        //---- labelParking ----
        labelParking.setText("Free Parking");

        //---- labelAir ----
        labelAir.setText("Air Condition");

        //---- labelFridge ----
        labelFridge.setText("Fridge");

        //---- labelTv ----
        labelTv.setText("Tv");

        //---- labelSmoking ----
        labelSmoking.setText("Smoking Allowed");

        //---- labelPetsAllowed ----
        labelPetsAllowed.setText("Pets Allowed");

        //---- button1 ----
        button1.setText("Search");
        button1.addActionListener(e->searchButtonClick(e));

        //---- button2 ----
        button2.setText("Clear");
        button2.addActionListener(e->clearButtonClick(e));

        //---- button3 ----
        button3.setText("Back");
        button3.addActionListener(e ->backButtonClick(e));

        //---- labelGuests ----
        labelGuests.setText("number of guests");

        //---- ComboBoxGuests ----
        ComboBoxGuests.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15"
        }));

        //---- labelCheckin ----
        labelCheckin.setText("check in");

        //---- labelCheckout ----
        labelCheckout.setText("checkout");

        //---- labelLongAccomon ----
        labelLongAccomon.setText("long accommodation");

        //---- labelM2 ----
        labelM2.setText("larger than m2:");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(labelOfclass, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelLongAccomon, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                .addComponent(checkBoxLongAccomond, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(labelCheckin, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(labelCheckout, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                    .addComponent(labelGuests, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                                            .addGap(35, 35, 35))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup()
                                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup()
                                                        .addComponent(labelAir)
                                                        .addComponent(labelParking, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(5, 5, 5)
                                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(labaleRoomType, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
                                                    .addComponent(labelFridge, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelTv, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelSmoking, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelPetsAllowed, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(labelPrice, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                            .addGap(30, 30, 30)))
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(ComboBoxRoomType, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textFieldCheckin, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(ComboBoxGuests, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(textFieldCheckout, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                                        .addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(checkBoxKitchen)
                                                .addComponent(CheckBoxBalcony)
                                                .addComponent(checkBoxWifi)
                                                .addComponent(checkBoxParking)
                                                .addComponent(checkBoxAir)
                                                .addComponent(checkBoxFridge)
                                                .addComponent(checkBoxTv)
                                                .addComponent(checkBoxSmoking)
                                                .addComponent(checkBoxPetsAllowed)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelM2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(textFieldM2)))
                            .addGap(173, 173, 173))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelOfclass)
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelGuests)
                        .addComponent(ComboBoxGuests, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelCheckin)
                        .addComponent(textFieldCheckin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelCheckout)
                        .addComponent(textFieldCheckout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPrice)
                                        .addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labaleRoomType)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(CheckBoxBalcony))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelParking)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelAir)
                                            .addGap(14, 14, 14)
                                            .addComponent(labelFridge)
                                            .addGap(14, 14, 14)
                                            .addComponent(labelTv)
                                            .addGap(14, 14, 14)
                                            .addComponent(labelSmoking))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(checkBoxKitchen)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkBoxWifi)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkBoxParking)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkBoxAir)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(checkBoxFridge)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkBoxTv, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(checkBoxSmoking))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(ComboBoxRoomType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(16, 16, 16)
                            .addComponent(labelPetsAllowed))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(checkBoxPetsAllowed)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelLongAccomon)
                        .addComponent(checkBoxLongAccomond))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelM2)
                        .addComponent(textFieldM2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3))
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel labelOfclass;
    private JLabel labelPrice;
    private JTextField textFieldPrice;
    private JLabel labaleRoomType;
    private JLabel label3;
    private JCheckBox CheckBoxBalcony;
    private JLabel label4;
    private JComboBox<String> ComboBoxRoomType;
    private JCheckBox checkBoxKitchen;
    private JLabel label5;
    private JCheckBox checkBoxWifi;
    private JCheckBox checkBoxParking;
    private JLabel labelParking;
    private JLabel labelAir;
    private JCheckBox checkBoxAir;
    private JLabel labelFridge;
    private JCheckBox checkBoxFridge;
    private JLabel labelTv;
    private JCheckBox checkBoxTv;
    private JLabel labelSmoking;
    private JCheckBox checkBoxSmoking;
    private JLabel labelPetsAllowed;
    private JCheckBox checkBoxPetsAllowed;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel labelGuests;
    private JComboBox<String> ComboBoxGuests;
    private JLabel labelCheckin;
    private JTextField textFieldCheckin;
    private JLabel labelCheckout;
    private JTextField textFieldCheckout;
    private JLabel labelLongAccomon;
    private JCheckBox checkBoxLongAccomond;
    private JLabel labelM2;
    private JTextField textFieldM2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
