import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Thu Jan 06 16:19:49 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class ShowAllReservationsCustomerForm extends JPanel {
    JFrame jframe;
    ShowAllReservationsCustomerForm currentForm;
    private Customer customer;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
    private ArrayList<Integer> idsInList;
    DefaultListModel<String> model;
    private static DecimalFormat df;
    private MainUI mainui;

    public void setCurrentForm(ShowAllReservationsCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    public ShowAllReservationsCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        this.customer=customer;
        initComponents();


        idsInList = new ArrayList<>() ;
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<String>();
        AtomicBoolean noRoomsForCustomer = new AtomicBoolean(true);

        this.reservations.forEach((id, reservation) -> {
            if (Objects.equals(reservation.getUsername(),this.customer.getUsername())){
                model.addElement("Reservation ID: \"" + reservation.getReservationID()
                        +", Guest number: \"" + reservation.getGuestNumber()+", Total nights: \"" + reservation.getTotalNights()+
                        ", Room id: \"" + reservation.getRoomID() +", Check in: \"" + reservation.getCheckIn() + ", Check out: \"" +
                        reservation.getCheckOut() +", Customer: \"" + reservation.getUsername() + ", Price/night: \"" +
                        df.format(reservation.getTotalNights()/reservation.getTotalNights()) + ", Total cost: \"" +
                        df.format(reservation.getTotalPrice()));
                idsInList.add(id);
                noRoomsForCustomer.set(false);


            }

        });
        if (noRoomsForCustomer.get()){
            model.addElement("No reservations found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }
    private void cancelClick(ActionEvent e){
        customerForm customerForm= new customerForm(this.jframe,this.reservations,this.rooms,this.users,this.customers,this.providers,this.admins,
                this.messages,this.mainui,this.customer);
        customerForm.setCurrentForm(customerForm);
        this.jframe.add(customerForm);
        this.currentForm.setVisible(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("cancel");
        button1.addActionListener(e->cancelClick(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(152, 152, 152)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(96, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(71, 71, 71)
                    .addComponent(button1)
                    .addGap(25, 25, 25))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
