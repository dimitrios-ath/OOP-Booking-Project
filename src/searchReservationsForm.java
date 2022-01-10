import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 07 13:41:10 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class searchReservationsForm extends JPanel {
    JFrame jframe;
    searchReservationsForm currentForm;
    private final Admin admin;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    
    public void setCurrentForm(searchReservationsForm currentForm) {
        this.currentForm = currentForm;
    }
    
    public searchReservationsForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                  Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                                  Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Admin admin) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.admin = admin;
        initComponents();
    }

    private void searchByCustomerUsernameButtonClick() {
        searchByCustomerUsernameForm searchByCustomerUsernameForm = new searchByCustomerUsernameForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        searchByCustomerUsernameForm.setCurrentForm(searchByCustomerUsernameForm);
        this.jframe.add(searchByCustomerUsernameForm);
        this.currentForm.setVisible(false);
    }

    private void searchByRoomButtonClick() {
        searchByRoomIDForm searchByRoomIDForm = new searchByRoomIDForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        searchByRoomIDForm.setCurrentForm(searchByRoomIDForm);
        this.jframe.add(searchByRoomIDForm);
        this.currentForm.setVisible(false);
    }

    private void showAllReservationsButtonClick() {
        returnAllReservationsAdminForm returnAllReservationsAdminForm = new returnAllReservationsAdminForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.admin);
        returnAllReservationsAdminForm.setCurrentForm(returnAllReservationsAdminForm);
        this.jframe.add(returnAllReservationsAdminForm);
        this.currentForm.setVisible(false);
    }

    private void cancelButtonClick() {
        adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI, this.admin);
        adminForm.setCurrentForm(adminForm);
        this.jframe.add(adminForm);
        this.currentForm.setVisible(false);
    }

    private void searchByCustomerUsernameButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void searchByRoomButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void showAllReservationsButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void cancelButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Search reservations");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBackground(Color.white);
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(65, 40, 240, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Search by customer");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> searchByCustomerUsernameButtonClick(e));
        add(button1);
        button1.setBounds(65, 105, 238, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Search by room");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));
        button2.addActionListener(e -> searchByRoomButtonClick(e));
        add(button2);
        button2.setBounds(65, 135, 238, button2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("Show all reservations");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(new Color(51, 102, 255));
        button3.addActionListener(e -> showAllReservationsButtonClick(e));
        add(button3);
        button3.setBounds(65, 165, 238, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("Cancel");
        button4.setFont(new Font("Tahoma", Font.BOLD, 14));
        button4.setForeground(new Color(51, 102, 255));
        button4.addActionListener(e -> cancelButtonClick(e));
        add(button4);
        button4.setBounds(100, 205, 155, button4.getPreferredSize().height);

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
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
