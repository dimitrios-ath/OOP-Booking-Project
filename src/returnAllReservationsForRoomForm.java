import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 21:42:13 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class returnAllReservationsForRoomForm extends JPanel {
    JFrame jframe;
    returnAllReservationsForRoomForm currentForm;
    private final Provider provider;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    private static DecimalFormat df;
    DefaultListModel<String> model;

    public void setCurrentForm(returnAllReservationsForRoomForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public returnAllReservationsForRoomForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        df = new DecimalFormat("0.00");
        initComponents();
        jframe.setPreferredSize(new Dimension(930, 425));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        
        label1.setText("Room \"" + rooms.get(id).getName() + "\" reservations:");
        model = new DefaultListModel<>();
        AtomicBoolean roomFound = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(1);
        reservations.forEach((reservationID, reservation) -> {
            if (reservation.getRoomID() == id) {
                model.addElement(counter + ". " + "reservation ID: " + reservation.getReservationID() + ", Username: \""
                        + reservation.getUsername() + "\", Guests: " + reservation.getGuestNumber() + ", Check in: "
                        + reservation.getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Check out: " + reservation.getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Total price: $" + df.format((reservation.getTotalPrice())));
                roomFound.set(true);
                counter.getAndIncrement();
            }
        });
        if (!roomFound.get()) {
            model.addElement("No reservations found for this room");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void returnButtonClick() {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    private void returnButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
        , 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
        , new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
         getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("Room \"name\" reservations:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(new Rectangle(new Point(365, 90), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Please select a room");
        label2.setVisible(false);
        add(label2);
        label2.setBounds(0, 0, 0, 0);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(52, 120, 818, 210);

        //---- button1 ----
        button1.setText("Return");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.addActionListener(e -> returnButtonClick(e));
        add(button1);
        button1.setBounds(390, 360, 145, button1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Reservations");
        label3.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label3);
        label3.setBounds(new Rectangle(new Point(390, 20), label3.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
