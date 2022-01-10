import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
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
        jframe.setPreferredSize(new Dimension(320, 480));
        jframe.pack();

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

    private void list1Click(MouseEvent e) {
        if (!noCustomersFound.get()) {
            list1.setEnabled(true);
            textField1.setEnabled(false);
        }
    }

    private void textField1Click(MouseEvent e) {
        if (!noCustomersFound.get()) {
            list1.setEnabled(false);
            textField1.setEnabled(true);
        }
    }

    private void backButtonClick(ActionEvent e) {
        searchReservationsForm searchReservationsForm = new searchReservationsForm(jframe, this.reservations,
                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                this.mainUI, this.admin);
        searchReservationsForm.setCurrentForm(searchReservationsForm);
        jframe.add(searchReservationsForm);
        this.currentForm.setVisible(false);
    }

    private void nextButtonClick(ActionEvent e) {
        if (!noCustomersFound.get()) {
            if (list1.isEnabled() && !textField1.isEnabled()) {
                if (!list1.isSelectionEmpty()) {
                    returnReservationsByCustomer returnReservationsByCustomer = new returnReservationsByCustomer(
                            jframe, this.reservations, this.rooms, this.users, this.customers, this.providers, this.admins,
                            this.messages, this.mainUI, this.admin, list1.getSelectedValue().toString());
                    returnReservationsByCustomer.setCurrentForm(returnReservationsByCustomer);
                    jframe.add(returnReservationsByCustomer);
                    this.currentForm.setVisible(false);
                }
                else {
                    label3.setText("Please select a username");
                    label3.setForeground(Color.red);
                    label3.setVisible(true);
                }

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
                    label3.setText("Username not found");
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Type the username:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(20, 80, 145, 30);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1Click(e);
            }
        });
        add(textField1);
        textField1.setBounds(170, 80, 130, textField1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Select one from the list below:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setForeground(Color.white);
        add(label4);
        label4.setBounds(20, 150, 285, label4.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setEnabled(false);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            list1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    list1Click(e);
                }
            });
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(50, 180, 220, 205);

        //---- button1 ----
        button1.setText("Back");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> backButtonClick(e));
        add(button1);
        button1.setBounds(50, 400, 100, 40);

        //---- button2 ----
        button2.setText("Next");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> nextButtonClick(e));
        add(button2);
        button2.setBounds(170, 400, 100, 40);

        //---- label3 ----
        label3.setText("Username not found");
        label3.setVisible(false);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        add(label3);
        label3.setBounds(65, 55, 200, 25);

        //---- label5 ----
        label5.setText("Reservations");
        label5.setFont(new Font("Tahoma", Font.BOLD, 22));
        label5.setForeground(Color.white);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        add(label5);
        label5.setBounds(new Rectangle(new Point(90, 20), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("or");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        add(label6);
        label6.setBounds(new Rectangle(new Point(160, 120), label6.getPreferredSize()));

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
