import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.*;

public class reserveRoomCustomerForm extends JPanel {
    JFrame jframe;
    reserveRoomCustomerForm currentForm;
    private final Customer customer;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    private final ArrayList<Integer> idsInList;
    DefaultListModel<String> model;
    private static DecimalFormat df;
    private final int guests;
    LocalDate checkIn;
    LocalDate checkOut;
    Map<Integer, Room> filteredRooms;
    Map<String,Boolean> previousFilters;
    private final long nights;
    String type;
    String maxPrice;


    public void setCurrentForm(reserveRoomCustomerForm currentForm) {
        this.currentForm = currentForm;
    }

    public reserveRoomCustomerForm(JFrame jframe, Map<Integer, Reservation> reservations, Map<Integer, Room> rooms,
                                   Map<String, Authentication> users, Map<String, Customer> customers, Map<String, Provider> providers,
                                   Map<String, Admin> admins, Map<Integer, Message> messages, MainUI mainUI, Customer customer,
                                   int guests, LocalDate checkIn, LocalDate checkOut, Map<Integer, Room> filteredRooms,
                                   Map<String,Boolean> previousFilters, String type, String maxPrice) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI = mainUI;
        this.customer = customer;
        this.filteredRooms = filteredRooms;
        this.guests = guests;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.previousFilters = previousFilters;
        this.type = type;
        this.maxPrice = maxPrice;
        initComponents();
        jframe.setPreferredSize(new Dimension(665, 400));
        jframe.pack();

        idsInList = new ArrayList<>();
        df = new DecimalFormat("0.00");
        model = new DefaultListModel<>();
        nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        AtomicBoolean noRoomsForReservation = new AtomicBoolean(true);
        this.filteredRooms.forEach((roomID, room) -> {
            model.addElement("Name: \"" + room.getName() +
                    "\", Type: " + room.getType() + ", Capacity: " +
                    room.getCapacity() + ", Price/night: $" +
                    df.format(room.getPrice()) + ", Total price: $" +
                    df.format((room.getPrice()*nights)));
            idsInList.add(roomID);
            noRoomsForReservation.set(false);
        });
        if (noRoomsForReservation.get()) {
            model.addElement("No rooms found");
            list1.setEnabled(false);
            button2.setEnabled(false);
        }
        list1.setModel(model);
    }

        private void reserveButtonClick() {
            if (list1.isEnabled() && !list1.isSelectionEmpty()) {
                boolean addedToHashMap = false;
                int i=1;
                while(!addedToHashMap && i<1000) {
                    if (!reservations.containsKey(i)) {
                        int roomID = idsInList.get(list1.getSelectedIndex());
                        reservations.put(i, new Reservation(i, guests, nights, roomID,
                                checkIn, checkOut, this.customer.getUsername(),
                                this.rooms.get(roomID).getPrice()*nights));
                        addedToHashMap = true;
                        cancelButtonClick();
                    }
                    else {i++;}
                }
            }
        }

        public void backButtonClick(){
            reserveRoomForm reserveRoomForm = new reserveRoomForm(this.jframe, this.reservations, this.rooms,
                    this.users,this.customers,this.providers,this.admins, this.messages, this.mainUI, this.customer);
            reserveRoomForm.setCurrentForm(reserveRoomForm);
            reserveRoomForm.returnToPreviousFormState(guests, checkIn, checkOut, maxPrice, type, previousFilters);
            this.jframe.add(reserveRoomForm);
            this.currentForm.setVisible(false);
        }

        private void cancelButtonClick() {
            customerForm customerForm= new customerForm(this.jframe, this.reservations, this.rooms, this.users,
                    this.customers, this.providers, this.admins, this.messages, this.mainUI, this.customer);
            customerForm.setCurrentForm(customerForm);
            this.jframe.add(customerForm);
            this.currentForm.setVisible(false);
        }

        private void initComponents () {
            JLabel label2 = new JLabel();
            JLabel label1 = new JLabel();
            JScrollPane scrollPane1 = new JScrollPane();
            list1 = new JList<>();
            JButton button3 = new JButton();
            JButton button1 = new JButton();
            button2 = new JButton();

            //======== this ========
            setBackground(new Color(51, 102, 255));
            setLayout(null);

            //---- label2 ----
            label2.setText("Room reservation");
            label2.setFont(new Font("Tahoma", Font.BOLD, 22));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setForeground(Color.white);
            add(label2);
            label2.setBounds(225, 5, 214, 40);

            //---- label1 ----
            label1.setText("Select a room to reserve:");
            label1.setFont(new Font("Tahoma", Font.BOLD, 14));
            label1.setForeground(Color.white);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            add(label1);
            label1.setBounds(new Rectangle(new Point(245, 60), label1.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

                //---- list1 ----
                list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                list1.setModel(new AbstractListModel<>() {
                    final String[] values = {
                            "Name: \"test\", type: hotel, capacity: 2, price: $40.00"
                    };

                    @Override
                    public int getSize() {
                        return values.length;
                    }

                    @Override
                    public String getElementAt(int i) {
                        return values[i];
                    }
                });
                list1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
                list1.setBackground(Color.white);
                list1.setForeground(Color.black);
                scrollPane1.setViewportView(list1);
            }
            add(scrollPane1);
            scrollPane1.setBounds(50, 85, 565, 220);

            //---- button3 ----
            button3.setText("Cancel");
            button3.setFont(new Font("Tahoma", Font.BOLD, 14));
            button3.setForeground(Color.white);
            button3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            button3.addActionListener(e -> cancelButtonClick());
            add(button3);
            button3.setBounds(95, 320, 125, 40);

            //---- button1 ----
            button1.setText("Back");
            button1.setFont(new Font("Tahoma", Font.BOLD, 14));
            button1.setForeground(Color.white);
            button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            button1.addActionListener(e -> backButtonClick());
            add(button1);
            button1.setBounds(270, 320, 125, 40);

            //---- button2 ----
            button2.setText("Reserve");
            button2.setFont(new Font("Tahoma", Font.BOLD, 14));
            button2.setForeground(Color.white);
            button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
            button2.addActionListener(e -> reserveButtonClick());
            add(button2);
            button2.setBounds(445, 320, 125, 40);

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
        }
    private JList<String> list1;
    private JButton button2;
}
