import java.awt.event.*;
import javax.swing.*;
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
    }

    private void addRoomButtonClick() {
        addNewRoomProviderForm addNewRoomProviderForm = new addNewRoomProviderForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        addNewRoomProviderForm.setCurrentForm(addNewRoomProviderForm);
        this.jframe.add(addNewRoomProviderForm);
        this.currentForm.setVisible(false);
    }

    private void editRoomButtonClick() {
        selectRoomAndEditForm selectRoomAndEditForm = new selectRoomAndEditForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        selectRoomAndEditForm.setCurrentForm(selectRoomAndEditForm);
        this.jframe.add(selectRoomAndEditForm);
        this.currentForm.setVisible(false);
    }

    private void deleteExistingRoomButtonClick() {
        selectRoomAndDeleteForm selectRoomAndDeleteForm = new selectRoomAndDeleteForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        selectRoomAndDeleteForm.setCurrentForm(selectRoomAndDeleteForm);
        this.jframe.add(selectRoomAndDeleteForm);
        this.currentForm.setVisible(false);
    }

    private void showAllRoomsButtonClick() {
        showAllRoomsForm showAllRoomsForm = new showAllRoomsForm(this.jframe,
                this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        showAllRoomsForm.setCurrentForm(showAllRoomsForm);
        this.jframe.add(showAllRoomsForm);
        this.currentForm.setVisible(false);
    }

    private void returnAllReservationsButtonClick() {
        selectRoomAndReturnReservationsForm selectRoomAndReturnReservationsForm = new selectRoomAndReturnReservationsForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider);
        selectRoomAndReturnReservationsForm.setCurrentForm(selectRoomAndReturnReservationsForm);
        this.jframe.add(selectRoomAndReturnReservationsForm);
        this.currentForm.setVisible(false);
    }

    private void messagesButtonClick() {
        messageForm messageForm = new messageForm(
                this.jframe, this.reservations, this.rooms, this.users, this.customers, this.providers,
                this.admins, this.messages, this.mainUI, this.provider.getUsername());
        messageForm.setCurrentForm(messageForm);
        this.jframe.add(messageForm);
        this.currentForm.setVisible(false);
    }

    private void logoutButtonClick() {
        loginForm loginForm = new loginForm(jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI);
        loginForm.setCurrentForm(loginForm);
        jframe.add(loginForm);
        this.currentForm.setVisible(false);
    }

    private void exitButtonClick() {
        this.mainUI.saveAndExit();
    }

    private void addRoomButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void editRoomButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteExistingRoomButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void showAllRoomsButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void returnAllReservationsButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void messagesButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void logoutButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void exitButtonClick(ActionEvent e) {
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
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Provider panel");
        add(label1, "cell 6 0");

        //---- button1 ----
        button1.setText("Add new room");
        button1.addActionListener(e -> addRoomButtonClick(e));
        add(button1, "cell 6 2");

        //---- button2 ----
        button2.setText("Edit existing room");
        button2.addActionListener(e -> editRoomButtonClick(e));
        add(button2, "cell 6 3");

        //---- button3 ----
        button3.setText("Delete existing room");
        button3.addActionListener(e -> deleteExistingRoomButtonClick(e));
        add(button3, "cell 6 4");

        //---- button4 ----
        button4.setText("Show All rooms");
        button4.addActionListener(e -> showAllRoomsButtonClick(e));
        add(button4, "cell 6 5");

        //---- button5 ----
        button5.setText("Return all reservations");
        button5.addActionListener(e -> returnAllReservationsButtonClick(e));
        add(button5, "cell 6 6");

        //---- button6 ----
        button6.setText("Messages");
        button6.addActionListener(e -> messagesButtonClick(e));
        add(button6, "cell 6 7");

        //---- button7 ----
        button7.setText("Log out");
        button7.addActionListener(e -> logoutButtonClick(e));
        add(button7, "cell 6 8");

        //---- button8 ----
        button8.setText("Exit");
        button8.addActionListener(e -> exitButtonClick(e));
        add(button8, "cell 6 9");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
