import java.awt.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

public class providerReturnAllReservationsForRoomForm extends JPanel {
    JFrame jframe;
    providerReturnAllReservationsForRoomForm currentForm;
    private final Provider provider;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;
    private static DecimalFormat df;
    DefaultListModel<String> model;

    public void setCurrentForm(providerReturnAllReservationsForRoomForm currentForm) {
        this.currentForm = currentForm;
    }

    /**
     * Constructor of providerReturnAllReservationsForRoomForm. Adds to displayed list all existing
     * reservations for given room id
     *
     * @param jframe
     * @param reservations
     * @param rooms
     * @param users
     * @param customers
     * @param providers
     * @param admins
     * @param messages
     * @param mainUI
     * @param provider
     * @param id
     */
    public providerReturnAllReservationsForRoomForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                                                    Map<String,Authentication> users, Map<String,Customer> customers, Map<String, Provider> providers,
                                                    Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI, Provider provider, Integer id) {
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
        df = new DecimalFormat("0.00");
        initComponents();
        jframe.setPreferredSize(new Dimension(1000, 425));
        jframe.pack();

        label1.setText("Room \"" + rooms.get(id).getName() + "\" reservations:");
        model = new DefaultListModel<>();
        AtomicBoolean roomFound = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(1);
        reservations.forEach((reservationID, reservation) -> {
            if (reservation.getRoomID() == id) {
                model.addElement(counter + ". " + "reservation ID: " + reservation.getReservationID() + ", Username: \""
                        + reservation.getUsername() + "\", Guests: " + reservation.getGuestNumber() + ", Check in: "
                        + reservation.getCheckIn().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Check out: " + reservation.getCheckOut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + ", Total price: $" + df.format((reservation.getTotalPrice())));
                roomFound.set(true);
                counter.getAndIncrement();
            }
        });
        if (!roomFound.get()) {
            model.addElement("No reservations found for this room");
            list1.setEnabled(false);
        }
        list1.setModel(model);
    }

    /**
     * Returns to provider panel
     */
    private void returnButtonClick() {
        providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                this.providers, this.admins, this.messages, this.mainUI, this.provider);
        providerForm.setCurrentForm(providerForm);
        this.jframe.add(providerForm);
        this.currentForm.setVisible(false);
    }

    /**
     *   Form generator
     */
    private void initComponents() {
        label1 = new JLabel();
        JLabel label2 = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        JButton button1 = new JButton();
        JLabel label3 = new JLabel();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setLayout(null);

        //---- label1 ----
        label1.setText("Room \"name\" reservations:");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(300, 65, 410, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Please select a room");
        label2.setVisible(false);
        add(label2);
        label2.setBounds(0, 0, 0, 0);

        //======== scrollPane1 ========
        {
            scrollPane1.setFont(new Font("Tahoma", Font.BOLD, 14));

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            list1.setModel(new AbstractListModel<>() {
                final String[] values = {
                        "Reservation ID: 123 Username: \"testCustomer\", Guests: 1, Check in: 01-03-2022, Check out: 03-03-2022, Total price: $80.00"
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
            list1.setForeground(Color.black);
            list1.setBackground(Color.white);

            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(55, 90, 890, 225);

        //---- button1 ----
        button1.setText("Return");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(new Color(51, 102, 255));

        button1.addActionListener(e -> returnButtonClick());
        add(button1);
        button1.setBounds(435, 340, 125, 40);

        //---- label3 ----
        label3.setText("Reservations");
        label3.setFont(new Font("Tahoma", Font.BOLD, 22));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(new Rectangle(new Point(430, 20), label3.getPreferredSize()));

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
    private JLabel label1;
    private JList<String> list1;
}
