import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Thu Jan 06 16:02:24 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class CancelReservationCustomerForm extends JPanel {
    JFrame jframe;
    CancelReservationCustomerForm currentForm;
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

    public void setCurrentForm(CancelReservationCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    public CancelReservationCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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



        this.reservations.forEach((id, Reservation) -> {
         if (Objects.equals(Reservation.getUsername(),this.customer.getUsername())){
             model.addElement("reservation's id:\"" + reservations.get(id).getReservationID()
             +"Guest number:\"" + reservations.get(id).getGuestNumber()+"total nights:\"" +reservations.get(id).getTotalNights()+
             "Room's id:\"" +reservations.get(id).getRoomID() +"check in:\"" + reservations.get(id).getCheckIn() + "check out:\""+
                     reservations.get(id).getCheckOut() +"Customer's username:\"" + reservations.get(id).getUsername() +"Total cost:\""+
                     df.format(reservations.get(id).getTotalPrice()));
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
    private void CancelClick(ActionEvent e) {
        customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.customer);
        customerForm.setCurrentForm(customerForm);
        this.jframe.add(customerForm);
        this.currentForm.setVisible(false);
    }

   private void cancelReservation(ActionEvent e){
            int id = 0;
            if (!list1.isSelectionEmpty()){
                id=idsInList.get(list1.getSelectedIndex());
                AtomicBoolean res= new AtomicBoolean(false);
                int finalid = id;

                if (reservations.containsKey(id) && Objects.equals(reservations.get(id).getUsername(),customer.getUsername())){
                    reservations.remove(id);
                    label1.setText("Successfully canceled reservation");
                    label1.setForeground(Color.green);
                    label1.setVisible(true);
                    customerForm customerForm= new customerForm(this.jframe,this.reservations,this.rooms,this.users,this.customers,this.providers,this.admins,
                            this.messages,this.mainui,this.customer);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        buttonCancelReservation = new JButton();
        buttonCancel = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
        . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing
        .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
        Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
        ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );

        //---- buttonCancelReservation ----
        buttonCancelReservation.setText("cancel reservation");
        buttonCancelReservation.addActionListener(e ->cancelReservation(e));

        //---- buttonCancel ----
        buttonCancel.setText("cancel");
        buttonCancel.addActionListener(e ->CancelClick(e));

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                    .addComponent(buttonCancelReservation)
                    .addGap(62, 62, 62))
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(214, 214, 214)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(71, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label1)
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonCancel)
                        .addComponent(buttonCancelReservation))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JButton buttonCancelReservation;
    private JButton buttonCancel;
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
