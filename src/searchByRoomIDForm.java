import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Jan 07 15:26:38 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class searchByRoomIDForm extends JPanel {
    JFrame jframe;
    searchByRoomIDForm currentForm;
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
    AtomicBoolean noRoomsFound;
    ArrayList<Integer> roomIDsInList;
    private static DecimalFormat df;

    public void setCurrentForm(searchByRoomIDForm currentForm) {
        this.currentForm = currentForm;
    }

    public searchByRoomIDForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
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

        roomIDsInList = new ArrayList<>();
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        noRoomsFound = new AtomicBoolean(true);
        this.rooms.forEach((roomID, room) -> {
            model.addElement("Room ID: " + room.getId() + ", Name: \"" + room.getName() +
                    "\", Type: " + room.getType() + ", Capacity: " +
                    room.getCapacity().toString()+ ", Price: $" +
                    df.format(room.getPrice()));
            roomIDsInList.add(roomID);
            noRoomsFound.set(false);
        });
        if (noRoomsFound.get()) {
            model.addElement("No rooms found");
        }
        list1.setModel(model);
        if (!noRoomsFound.get()){
            list1.setEnabled(true);
            textField1.setEnabled(false);
        } else {
            list1.setEnabled(false);
            textField1.setEnabled(false);
            button2.setEnabled(false);
        }
    }

    private void textField1Click() {
        if (!noRoomsFound.get()) {
            list1.setEnabled(false);
            textField1.setEnabled(true);
        }
    }

    private void list1Click() {
        if (!noRoomsFound.get()) {
            list1.setEnabled(true);
            textField1.setEnabled(false);
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
        if (!noRoomsFound.get()) {
            if (list1.isEnabled() && !textField1.isEnabled()) {
                returnReservationsByRoomID returnReservationsByRoomID = new returnReservationsByRoomID(
                        jframe, this.reservations, this.rooms, this.users, this.customers, this.providers, this.admins,
                        this.messages, this.mainUI, this.admin, roomIDsInList.get(list1.getSelectedIndex()));
                returnReservationsByRoomID.setCurrentForm(returnReservationsByRoomID);
                jframe.add(returnReservationsByRoomID);
                this.currentForm.setVisible(false);

            }
            else if (textField1.isEnabled() && !list1.isEnabled()) {
                try {
                    Integer givenID = Integer.parseInt(textField1.getText());
                    if (this.rooms.containsKey(givenID)) {
                        returnReservationsByRoomID returnReservationsByRoomID = new returnReservationsByRoomID(jframe, this.reservations,
                                this.rooms, this.users, this.customers, this.providers, this.admins, this.messages,
                                this.mainUI, this.admin, givenID);
                        returnReservationsByRoomID.setCurrentForm(returnReservationsByRoomID);
                        jframe.add(returnReservationsByRoomID);
                        this.currentForm.setVisible(false);
                    } else {
                        label3.setText("Room not found");
                        label3.setForeground(Color.red);
                        label3.setVisible(true);
                    }
                } catch (NumberFormatException ignored) {
                    label3.setText("Please enter a valid room ID");
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
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //---- label1 ----
        label1.setText("Type the room ID:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(new Rectangle(new Point(235, 85), label1.getPreferredSize()));

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.BOLD, 14));
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1Click(e);
            }
        });
        add(textField1);
        textField1.setBounds(375, 80, 95, textField1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Select one from the list below:");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setForeground(Color.white);
        add(label4);
        label4.setBounds(210, 155, 275, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setEnabled(false);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    list1Click(e);
                }
            });
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(45, 195, 585, 195);

        //---- button1 ----
        button1.setText("Back");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));
        button1.addActionListener(e -> backButtonClick(e));
        add(button1);
        button1.setBounds(45, 395, 120, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Next");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(new Color(51, 102, 255));
        button2.addActionListener(e -> nextButtonClick(e));
        add(button2);
        button2.setBounds(480, 395, 150, button2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Username not found");
        label3.setVisible(false);
        add(label3);
        label3.setBounds(0, 0, 0, 0);

        //---- label5 ----
        label5.setText("Reservations");
        label5.setFont(new Font("Tahoma", Font.BOLD, 22));
        label5.setForeground(Color.white);
        add(label5);
        label5.setBounds(new Rectangle(new Point(265, 25), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("Or");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setBackground(Color.white);
        label6.setForeground(Color.white);
        add(label6);
        label6.setBounds(new Rectangle(new Point(335, 125), label6.getPreferredSize()));

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
