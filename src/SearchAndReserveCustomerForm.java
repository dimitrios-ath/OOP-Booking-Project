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
 * Created by JFormDesigner on Thu Jan 06 14:04:23 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class SearchAndReserveCustomerForm extends JPanel {
    JFrame jframe;
    SearchAndReserveCustomerForm currentForm;
    private Room room;
    private Customer customer;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

    public void setCurrentForm(SearchAndReserveCustomerForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public SearchAndReserveCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                        Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                                        Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Customer customer,Room room) {
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
        this.room=room;
        initComponents();
    }

    private void backClick(ActionEvent e) {
        customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.customer);
        customerForm.setCurrentForm(customerForm);
        this.jframe.add(customerForm);
        this.currentForm.setVisible(false);
    }
    private void clearClick(ActionEvent e){
        textCheckout.setText("");
        textCheckin.setText("");

    }
    private void searchClick(ActionEvent e) {
        int guests = 0;
        String text = (String) BoxOfGuests.getSelectedItem();

        boolean validInput = true;
        if (text == "-") {
            BoxOfGuests.setForeground(Color.red);
            validInput = false;
        } else {
            guests = Integer.parseInt(text);
            BoxOfGuests.setForeground(null);
        }

        String dateIn = textCheckin.getText();
        LocalDate dateCheckin = LocalDate.of(1, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            dateCheckin = LocalDate.parse(dateIn, dtf);
            textCheckin.setForeground(null);
        } catch (java.time.format.DateTimeParseException ignored) {
            textCheckin.setForeground(Color.red);
            validInput = false;
        }

        String dateOut = textCheckout.getText();
        LocalDate dateCheckout = LocalDate.of(1, 1, 1);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                dateCheckout = LocalDate.parse(dateOut, df);
                if (dateCheckout.isAfter(dateCheckout)) {
                    validInput=true;
                    textCheckout.setForeground(null);
                }
                else
                    textCheckout.setForeground(Color.red);
            } catch (java.time.format.DateTimeParseException ignored) {
                textCheckout.setForeground(Color.red);
                validInput = false;
            }

        long nights = ChronoUnit.DAYS.between(dateCheckin, dateCheckout);
            if (dateCheckout.isAfter(dateCheckin)) {
                textCheckout.setForeground(null);
                SearchAndReserveSimpleList searchAndReserveSimpleList = new SearchAndReserveSimpleList(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.customer, guests, dateCheckin, dateCheckout);
                searchAndReserveSimpleList.setCurrentForm(searchAndReserveSimpleList);
                this.jframe.add(searchAndReserveSimpleList);
                this.currentForm.setVisible(false);
            }
    }

    private void FiltersButtonClick(ActionEvent e){
        FilteredSearchRoomCustomerForm filteredSearchRoomCustomerForm = new FilteredSearchRoomCustomerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
               this.providers, this.admins, this.messages, this.mainUI, this.customer);
        filteredSearchRoomCustomerForm.setCurrentForm(filteredSearchRoomCustomerForm);
        this.jframe.add(filteredSearchRoomCustomerForm);
        this.currentForm.setVisible(false);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        buttonSearch = new JButton();
        buttonClear = new JButton();
        labelGuests = new JLabel();
        label2 = new JLabel();
        labelCheckin = new JLabel();
        textCheckin = new JTextField();
        labelCheckout = new JLabel();
        textCheckout = new JTextField();
        buttonBack = new JButton();
        button1 = new JButton();
        BoxOfGuests = new JComboBox<>();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- buttonSearch ----
        buttonSearch.setText("search");
        buttonSearch.addActionListener(e-> searchClick(e));

        //---- buttonClear ----
        buttonClear.setText("clear");
        buttonClear.addActionListener(e->clearClick(e));

        //---- labelGuests ----
        labelGuests.setText("number of guests:");

        //---- label2 ----
        label2.setText("SEARCH N RESERVE A ROOM");

        //---- labelCheckin ----
        labelCheckin.setText("check-in:");

        //---- labelCheckout ----
        labelCheckout.setText("check-out:");

        //---- buttonBack ----
        buttonBack.setText("back");
        buttonBack.addActionListener(e->backClick(e));

        //---- button1 ----
        button1.setText("put some filters");
        button1.addActionListener(e->FiltersButtonClick(e));

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
            "10",
            "11",
            "12",
            "13",
            "14",
            "15"
        }));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonBack)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonClear)
                            .addGap(27, 27, 27)
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(buttonSearch, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(12, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(91, 91, 91)
                                    .addComponent(label2))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(textCheckin, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup()
                                            .addComponent(labelCheckin, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(labelGuests, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelCheckout)))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup()
                                            .addComponent(textCheckout, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BoxOfGuests, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(71, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelGuests)
                        .addComponent(BoxOfGuests, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelCheckin)
                            .addGap(24, 24, 24))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(textCheckin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(labelCheckout)
                        .addComponent(textCheckout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonBack)
                        .addComponent(buttonClear)
                        .addComponent(button1)
                        .addComponent(buttonSearch))
                    .addGap(43, 43, 43))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JButton buttonSearch;
    private JButton buttonClear;
    private JLabel labelGuests;
    private JLabel label2;
    private JLabel labelCheckin;
    private JTextField textCheckin;
    private JLabel labelCheckout;
    private JTextField textCheckout;
    private JButton buttonBack;
    private JButton button1;
    private JComboBox<String> BoxOfGuests;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
