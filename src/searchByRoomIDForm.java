import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
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
    private Admin admin;
    private MainUI mainUI;
    private Map<Integer,Reservation> reservations;
    private Map<Integer,Room> rooms;
    private Map<String,Authentication> users;
    private Map<String,Customer> customers;
    private Map<String,Provider> providers;
    private Map<String,Admin> admins;
    private Map<Integer,Message> messages;
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
        model = new DefaultListModel<String>();
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

    private void textField1Click(MouseEvent e) {
        if (!noRoomsFound.get()) {
            list1.setEnabled(false);
            textField1.setEnabled(true);
        }
    }

    private void list1Click(MouseEvent e) {
        if (!noRoomsFound.get()) {
            list1.setEnabled(true);
            textField1.setEnabled(false);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
        (0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
        .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
        propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
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
        label1.setText("Type the room ID to return reservations for:");
        add(label1, "cell 6 0");

        //---- label2 ----
        label2.setText("Room ID:");
        add(label2, "cell 5 1");

        //---- textField1 ----
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1Click(e);
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
                    list1Click(e);
                }
            });
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 6 3");

        //---- button1 ----
        button1.setText("Back");
        button1.addActionListener(e -> backButtonClick(e));
        add(button1, "cell 5 5");

        //---- button2 ----
        button2.setText("Next");
        button2.addActionListener(e -> nextButtonClick(e));
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
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
