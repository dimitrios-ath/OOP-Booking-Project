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

    private void textField1Click(MouseEvent e) {
        // TODO add your code here
    }

    private void list1Click(MouseEvent e) {
        // TODO add your code here
    }

    private void backButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void nextButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        label1 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setFont(new Font("Tahoma", Font.BOLD, 14));
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Type the username:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(25, 80, 158, 20);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.BOLD, 14));
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1Click(e);
            }
        });
        add(textField1);
        textField1.setBounds(195, 80, 170, textField1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Select one from the list below:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setForeground(Color.white);
        add(label4);
        label4.setBounds(45, 155, 285, label4.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setEnabled(false);
            list1.setFont(new Font("Tahoma", Font.BOLD, 14));
            list1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    list1Click(e);
                }
            });
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(65, 185, 245, 190);

        //---- button1 ----
        button1.setText("Back");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(0, 102, 255));
        button1.addActionListener(e -> backButtonClick(e));
        add(button1);
        button1.setBounds(65, 380, 95, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Next");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(0, 102, 255));
        button2.addActionListener(e -> nextButtonClick(e));
        add(button2);
        button2.setBounds(200, 380, 110, button2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Username not found");
        label3.setVisible(false);
        add(label3);
        label3.setBounds(0, 0, 0, 0);

        //---- label5 ----
        label5.setText("Users info");
        label5.setFont(new Font("Tahoma", Font.BOLD, 22));
        label5.setForeground(Color.white);
        add(label5);
        label5.setBounds(new Rectangle(new Point(135, 25), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("Or");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        add(label6);
        label6.setBounds(new Rectangle(new Point(175, 125), label6.getPreferredSize()));

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
    private JTextField textField1;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
