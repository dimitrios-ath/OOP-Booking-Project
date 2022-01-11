import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.*;

public class customerCancelReservationForm extends JPanel {
    JFrame jframe;
    customerCancelReservationForm currentForm;
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    private final ArrayList<Integer> idsInList;
    DefaultListModel<String> model;
    private static DecimalFormat df;

    public void setCurrentForm(customerCancelReservationForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of customerCancelReservationForm. Adds to displayed list all reservations
     * the authenticated customer made
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
    public customerCancelReservationForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(805 , 425));
        jframe.pack();

        idsInList = new ArrayList<>() ;
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        AtomicBoolean noRoomsForCustomer = new AtomicBoolean(true);

        this.reservations.forEach((reservationID, reservation) -> {
         if (Objects.equals(reservation.getUsername(),this.customer.getUsername())){
             model.addElement("Reservation ID: " + reservation.getReservationID()
                     + ", Guest number: " + reservation.getGuestNumber()+", Total nights: " + reservation.getTotalNights()+
                     ", Room id: " + reservation.getRoomID() + ", Room name: \"" + this.rooms.get(reservation.getRoomID()).getName() +
                     "\", Check in: " + reservation.getCheckIn() + ", Check out: " + reservation.getCheckOut() + ", Price/night: $" +
                     df.format(reservation.getTotalPrice()/reservation.getTotalNights()) + ", Total cost: $" +
                     df.format(reservation.getTotalPrice()));
             idsInList.add(reservationID);
             noRoomsForCustomer.set(false);
         }
        });
        if (noRoomsForCustomer.get()){
            model.addElement("No reservations found");
            list1.setEnabled(false);
        }
        list1.setModel(model);


    }

    /**
     * Cancels selected reservation and returns to the customer panel
     */
    private void cancelReservationButtonClick() {
       int id;
       if (!list1.isSelectionEmpty()){
           id=idsInList.get(list1.getSelectedIndex());
           if (reservations.containsKey(id) && Objects.equals(reservations.get(id).getUsername(),customer.getUsername())){
               reservations.remove(id);
               label1.setText("Successfully canceled reservation");
               label1.setForeground(Color.green);
               label1.setVisible(true);
               customerForm customerForm = new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                       this.providers, this.admins, this.messages, this.mainUI, this.customer);
               customerForm.setCurrentForm(customerForm);
               this.jframe.add(customerForm);
               this.currentForm.setVisible(false);
           }
           else{
               label1.setText("Failed to cancel this reservation");
               label1.setForeground(Color.red);
               label1.setVisible(true);
           }


       }
   }

    /**
     * Returns to the customer panel
     */
   private void returnButtonClick() {
       customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
               this.providers, this.admins, this.messages, this.mainUI, this.customer);
       customerForm.setCurrentForm(customerForm);
       this.jframe.add(customerForm);
       this.currentForm.setVisible(false);
   }

    /**
     *   Form generator
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        JLabel label2 = new JLabel();
        JButton buttonCancelReservation = new JButton();
        JButton buttonCancel = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Cancel Reservation");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(new Rectangle(new Point(300, 15), label1.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setModel(new AbstractListModel<>() {
                final String[] values = {
                        "Reservation ID: 123, Guests: 1, Check in: 01-03-2022, Check out: 03-03-2022, Total price: $80.00"
                };

                @Override
                public int getSize() {
                    return values.length;
                }

                @Override
                public String getElementAt(int i) {
                    return values[i];
                }
            });
            list1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(55, 85, 695, 235);

        //---- label2 ----
        label2.setText("Select a reservation:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(new Rectangle(new Point(335, 60), label2.getPreferredSize()));

        //---- buttonCancelReservation ----
        buttonCancelReservation.setText("Cancel");
        buttonCancelReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonCancelReservation.setForeground(new Color(51, 102, 255));
        buttonCancelReservation.addActionListener(e -> cancelReservationButtonClick());
        add(buttonCancelReservation);
        buttonCancelReservation.setBounds(475, 340, 125, 40);

        //---- buttonCancel ----
        buttonCancel.setText("Return");
        buttonCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonCancel.setForeground(new Color(51, 102, 255));
        buttonCancel.addActionListener(e -> returnButtonClick());
        add(buttonCancel);
        buttonCancel.setBounds(185, 340, 125, 40);

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
    private JLabel label1;
    private JList<String> list1;
}
