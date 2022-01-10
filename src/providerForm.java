import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;

import java.util.Map;
/*
 * Created by JFormDesigner on Thu Jan 06 11:50:57 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class providerForm extends JPanel {
    JFrame jframe;
    providerForm currentForm;
    private final Provider provider;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(providerForm currentForm) {
        this.currentForm = currentForm;
    }

    public providerForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                        Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                        Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Provider provider) {
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
        initComponents();
        jframe.setPreferredSize(new Dimension(330 , 485));
        jframe.pack();
    }

    private void addRoomButtonClick(ActionEvent e) {
        addNewRoomProviderForm addNewRoomProviderForm = new addNewRoomProviderForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        addNewRoomProviderForm.setCurrentForm(addNewRoomProviderForm);
        this.jframe.add(addNewRoomProviderForm);
        this.currentForm.setVisible(false);
    }

    private void editRoomButtonClick(ActionEvent e) {
        selectRoomAndEditForm selectRoomAndEditForm = new selectRoomAndEditForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        selectRoomAndEditForm.setCurrentForm(selectRoomAndEditForm);
        this.jframe.add(selectRoomAndEditForm);
        this.currentForm.setVisible(false);
    }

    private void deleteExistingRoomButtonClick(ActionEvent e) {
        selectRoomAndDeleteForm selectRoomAndDeleteForm = new selectRoomAndDeleteForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        selectRoomAndDeleteForm.setCurrentForm(selectRoomAndDeleteForm);
        this.jframe.add(selectRoomAndDeleteForm);
        this.currentForm.setVisible(false);
    }

    private void showAllRoomsButtonClick(ActionEvent e) {
        showAllRoomsForm showAllRoomsForm = new showAllRoomsForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        showAllRoomsForm.setCurrentForm(showAllRoomsForm);
        this.jframe.add(showAllRoomsForm);
        this.currentForm.setVisible(false);
    }

    private void returnAllReservationsButtonClick(ActionEvent e) {
        selectRoomAndReturnReservationsForm selectRoomAndReturnReservationsForm = new selectRoomAndReturnReservationsForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        selectRoomAndReturnReservationsForm.setCurrentForm(selectRoomAndReturnReservationsForm);
        this.jframe.add(selectRoomAndReturnReservationsForm);
        this.currentForm.setVisible(false);
    }

    private void messagesButtonClick(ActionEvent e) {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider.getUsername());
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void logoutButtonClick(ActionEvent e) {
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    private void exitButtonClick(ActionEvent e) {
        this.mainUI.saveAndExit();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //---- label1 ----
        label1.setText("Provider panel");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(80, 15, 175, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Edit existing room");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> editRoomButtonClick(e));
        add(button2);
        button2.setBounds(60, 105, 210, 40);

        //---- button3 ----
        button3.setText("Delete existing room");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(Color.white);
        button3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button3.addActionListener(e -> deleteExistingRoomButtonClick(e));
        add(button3);
        button3.setBounds(60, 150, 210, 40);

        //---- button4 ----
        button4.setText("Show all rooms");
        button4.setFont(new Font("Tahoma", Font.BOLD, 14));
        button4.setForeground(Color.white);
        button4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button4.addActionListener(e -> showAllRoomsButtonClick(e));
        add(button4);
        button4.setBounds(60, 195, 210, 40);

        //---- button5 ----
        button5.setText("Show all reservations");
        button5.setFont(new Font("Tahoma", Font.BOLD, 14));
        button5.setForeground(Color.white);
        button5.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button5.addActionListener(e -> returnAllReservationsButtonClick(e));
        add(button5);
        button5.setBounds(60, 240, 210, 40);

        //---- button6 ----
        button6.setText("Messages");
        button6.setFont(new Font("Tahoma", Font.BOLD, 14));
        button6.setForeground(Color.white);
        button6.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button6.addActionListener(e -> messagesButtonClick(e));
        add(button6);
        button6.setBounds(60, 285, 210, 40);

        //---- button7 ----
        button7.setText("Log out");
        button7.setFont(new Font("Tahoma", Font.BOLD, 14));
        button7.setForeground(Color.white);
        button7.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button7.addActionListener(e -> logoutButtonClick(e));
        add(button7);
        button7.setBounds(100, 350, 125, 40);

        //---- button8 ----
        button8.setText("Exit");
        button8.setFont(new Font("Tahoma", Font.BOLD, 14));
        button8.setForeground(Color.white);
        button8.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button8.addActionListener(e -> exitButtonClick(e));
        add(button8);
        button8.setBounds(100, 395, 125, 40);

        //---- button1 ----
        button1.setText("Add new room");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> addRoomButtonClick(e));
        add(button1);
        button1.setBounds(60, 60, 210, 40);

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
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
