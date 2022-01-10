import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Jan 06 16:19:49 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class showAllReservationsCustomerForm extends JPanel {
    JFrame jframe;
    showAllReservationsCustomerForm currentForm;
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    DefaultListModel<String> model;
    private static DecimalFormat df;

    public void setCurrentForm(showAllReservationsCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    public showAllReservationsCustomerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        jframe.setPreferredSize(new Dimension(1000, 425));
        jframe.pack();

        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        AtomicBoolean noRoomsForCustomer = new AtomicBoolean(true);
        this.reservations.forEach((id, reservation) -> {
            if (Objects.equals(reservation.getUsername(),this.customer.getUsername())){
                model.addElement("Reservation ID: " + reservation.getReservationID()
                        + ", Guest number: " + reservation.getGuestNumber()+", Total nights: " + reservation.getTotalNights()+
                        ", Room id: " + reservation.getRoomID() + ", Room name: \"" + this.rooms.get(reservation.getRoomID()).getName() +
                        "\", Check in: " + reservation.getCheckIn() + ", Check out: " + reservation.getCheckOut() + ", Price/night: $" +
                        df.format(reservation.getTotalPrice()/reservation.getTotalNights()) + ", Total cost: $" +
                        df.format(reservation.getTotalPrice()));
                noRoomsForCustomer.set(false);
            }
        });
        if (noRoomsForCustomer.get()){
            model.addElement("No reservations found");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    private void returnButtonClick(ActionEvent e) {
        customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers,this.providers,this.admins, this.messages, this.mainUI, this.customer);
        customerForm.setCurrentForm(customerForm);
        this.jframe.add(customerForm);
        this.currentForm.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button1 = new JButton();

        //======== this ========
        setForeground(new Color(51, 102, 255));
        setBackground(new Color(51, 102, 255));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Reservations");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(430, 20), label1.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "Reservation ID: 123 Username: \"testCustomer\", Guests: 1, Check in: 01-03-2022, Check out: 03-03-2022, Total price: $80.00"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            list1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(55, 65, 890, 260);

        //---- button1 ----
        button1.setText("Return");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> returnButtonClick(e));
        add(button1);
        button1.setBounds(435, 340, 125, 40);

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
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
