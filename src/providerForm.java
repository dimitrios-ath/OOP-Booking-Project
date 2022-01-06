import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.Map;
import java.util.Scanner;
/*
 * Created by JFormDesigner on Thu Jan 06 11:50:57 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class providerForm extends JPanel {
    JFrame jframe;
    providerForm currentForm;
    private Provider provider;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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
        add(button4, "cell 6 5");

        //---- button5 ----
        button5.setText("Return all reservations");
        add(button5, "cell 6 6");

        //---- button6 ----
        button6.setText("Messages");
        add(button6, "cell 6 7");

        //---- button7 ----
        button7.setText("Log out");
        add(button7, "cell 6 8");

        //---- button8 ----
        button8.setText("Exit");
        add(button8, "cell 6 9");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
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
