import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * Created by JFormDesigner on Fri Jan 07 13:49:10 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class searchByCustomerUsernameForm extends JPanel {
    JFrame jframe;
    searchByCustomerUsernameForm currentForm;
    private final Admin admin;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    DefaultListModel<String> model;
    AtomicBoolean noCustomersFound;

    public void setCurrentForm(searchByCustomerUsernameForm currentForm) {
        this.currentForm = currentForm;
    }

    public searchByCustomerUsernameForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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
        model = new DefaultListModel<>();
        noCustomersFound = new AtomicBoolean(true);
        this.customers.forEach((username, Customer) -> {
                model.addElement(username);
                noCustomersFound.set(false);
        });
        if (noCustomersFound.get()) {
            model.addElement("No customers found");
        }
        list1.setModel(model);
        if (!noCustomersFound.get()){
            list1.setEnabled(true);
            textField1.setEnabled(false);
        } else {
            list1.setEnabled(false);
            textField1.setEnabled(false);
            button2.setEnabled(false);
        }
    }

    private void list1Click() {
        if (!noCustomersFound.get()) {
            list1.setEnabled(true);
            textField1.setEnabled(false);
        }
    }

    private void textField1Click() {
        if (!noCustomersFound.get()) {
            list1.setEnabled(false);
            textField1.setEnabled(true);
        }
    }

    private void backButtonClick() {
        searchReservationsForm searchReservationsForm = new searchReservationsForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        searchReservationsForm.setCurrentForm(searchReservationsForm);
        jframe.add(searchReservationsForm);
        this.currentForm.setVisible(false);
    }

    private void nextButtonClick() {
        if (!noCustomersFound.get()) {
            if (list1.isEnabled() && !textField1.isEnabled()) {
                returnReservationsByCustomer returnReservationsByCustomer = new returnReservationsByCustomer(
                        jframe, this.reservations, this.rooms, this.users, this.customers, this.providers, this.admins,
                        this.messages, this.mainUI, this.admin, list1.getSelectedValue());
                returnReservationsByCustomer.setCurrentForm(returnReservationsByCustomer);
                jframe.add(returnReservationsByCustomer);
                this.currentForm.setVisible(false);

            }
            else if (textField1.isEnabled() && !list1.isEnabled()) {
                if (this.customers.containsKey(textField1.getText())) {
                    returnReservationsByCustomer returnReservationsByCustomer = new returnReservationsByCustomer(jframe, this.reservations,
                            this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                            this.mainUI, this.admin, textField1.getText());
                    returnReservationsByCustomer.setCurrentForm(returnReservationsByCustomer);
                    jframe.add(returnReservationsByCustomer);
                    this.currentForm.setVisible(false);
                } else {
                    label3.setForeground(Color.red);
                    label3.setVisible(true);
                }

            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(e -> {if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
        ();});
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
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
            "[]"));

        //---- label1 ----
        label1.setText("Type the username to return reservations for:");
        add(label1, "cell 6 0");

        //---- label2 ----
        label2.setText("Username:");
        add(label2, "cell 5 1");

        //---- textField1 ----
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1Click();
            }
        });
        add(textField1, "cell 6 1");

        //---- label4 ----
        label4.setText("Or select one from the list below:");
        add(label4, "cell 6 2");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setEnabled(false);
            list1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    list1Click();
                }
            });
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 6 3");

        //---- button1 ----
        button1.setText("Back");
        button1.addActionListener(e -> backButtonClick());
        add(button1, "cell 5 5");

        //---- button2 ----
        button2.setText("Next");
        button2.addActionListener(e -> nextButtonClick());
        add(button2, "cell 7 5");

        //---- label3 ----
        label3.setText("Username not found");
        label3.setVisible(false);
        add(label3, "cell 7 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
