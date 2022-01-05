import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/*
 * Created by JFormDesigner on Sun Jan 02 20:12:26 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class Register extends JFrame implements ActionListener {
    public Register() {
        initComponents();
    }


    public JButton getButtonRegister() {
        return ButtonRegister;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        this2 = new JFrame();
        panel2 = new JPanel();
        label12 = new JLabel();
        labelRegestration = new JLabel();
        labelFirstName = new JLabel();
        textFirstName = new JTextField();
        labelPhone = new JLabel();
        label1 = new JLabel();
        label25 = new JLabel();
        label27 = new JLabel();
        label30 = new JLabel();
        label31 = new JLabel();
        label33 = new JLabel();
        textLastName = new JTextField();
        label35 = new JLabel();
        textPhone = new JTextField();
        textUserName = new JTextField();
        labelLastName = new JLabel();
        labelUserName = new JLabel();
        labelPass = new JLabel();
        label28 = new JLabel();
        textPassword = new JTextField();
        labelEmail = new JLabel();
        textEmail = new JTextField();
        labelCountry = new JLabel();
        labelOffice = new JLabel();
        labelRegion = new JLabel();
        labelGender = new JLabel();
        labelBirthdate = new JLabel();
        labelConfirmPass = new JLabel();
        label36 = new JLabel();
        textCountry = new JTextField();
        textOffice = new JTextField();
        textField21 = new JTextField();
        textBirthdate = new JTextField();
        textConfirmPassword = new JTextField();
        label37 = new JLabel();
        label39 = new JLabel();
        label24 = new JLabel();
        labelCustomerOrProvider = new JLabel();
        ComboBoxOfGender = new JComboBox<>();
        ComboBoxOfCustomerOrProvider = new JComboBox<>();
        commentsOfRegistration = new JLabel();
        ButtonClear = new JButton();
        ButtonRegister = new JButton();
        PanelOfBookinh = new JPanel();
        labelBooking = new JLabel();
        commentsOfRegistration2 = new JLabel();
        label29 = new JLabel();

        //======== this2 ========
        {
            this2.setResizable(false);
            var this2ContentPane = this2.getContentPane();

            //======== panel2 ========
            {
                panel2.setBackground(new Color(51, 51, 255));
                panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
                . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder
                . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .
                awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel2. getBorder( )) )
                ; panel2. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
                ;

                //---- label12 ----
                label12.setText("meTa");
                label12.setFont(new Font("Century Gothic", Font.BOLD, 28));
                label12.setForeground(Color.white);

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(10, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(388, 388, 388)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(400, Short.MAX_VALUE))
                );
            }

            //---- labelRegestration ----
            labelRegestration.setText("REGISTRATION");
            labelRegestration.setForeground(new Color(51, 51, 255));
            labelRegestration.setFont(new Font("Century Gothic", Font.BOLD, 30));

            //---- labelFirstName ----
            labelFirstName.setText("First Name");
            labelFirstName.setForeground(new Color(51, 51, 255));
            labelFirstName.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- textFirstName ----
            textFirstName.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textFirstName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
            textFirstName.setText("e.g ");
            textFirstName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            //---- labelPhone ----
            labelPhone.setText("Phone");
            labelPhone.setForeground(new Color(51, 51, 255));
            labelPhone.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- label1 ----
            label1.setText("*");
            label1.setForeground(new Color(255, 0, 102));
            label1.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label25 ----
            label25.setText("**");
            label25.setForeground(new Color(255, 0, 102));
            label25.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label27 ----
            label27.setText("*");
            label27.setForeground(new Color(255, 0, 102));
            label27.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label30 ----
            label30.setText("*");
            label30.setForeground(new Color(255, 0, 102));
            label30.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label31 ----
            label31.setText("*");
            label31.setForeground(new Color(255, 0, 102));
            label31.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label33 ----
            label33.setText("*");
            label33.setForeground(new Color(255, 0, 102));
            label33.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- textLastName ----
            textLastName.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textLastName.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- label35 ----
            label35.setText("*");
            label35.setForeground(new Color(255, 0, 102));
            label35.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- textPhone ----
            textPhone.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textPhone.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- textUserName ----
            textUserName.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textUserName.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- labelLastName ----
            labelLastName.setText("Last Name");
            labelLastName.setForeground(new Color(51, 51, 255));
            labelLastName.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelUserName ----
            labelUserName.setText("Username");
            labelUserName.setForeground(new Color(51, 51, 255));
            labelUserName.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelPass ----
            labelPass.setText("Password");
            labelPass.setForeground(new Color(51, 51, 255));
            labelPass.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- label28 ----
            label28.setText("*");
            label28.setForeground(new Color(255, 0, 102));
            label28.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- textPassword ----
            textPassword.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- labelEmail ----
            labelEmail.setText("Email");
            labelEmail.setForeground(new Color(51, 51, 255));
            labelEmail.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- textEmail ----
            textEmail.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textEmail.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- labelCountry ----
            labelCountry.setText("Country");
            labelCountry.setForeground(new Color(51, 51, 255));
            labelCountry.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelOffice ----
            labelOffice.setText("Office");
            labelOffice.setForeground(new Color(51, 51, 255));
            labelOffice.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelRegion ----
            labelRegion.setText("Region");
            labelRegion.setForeground(new Color(51, 51, 255));
            labelRegion.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelGender ----
            labelGender.setText("Gender");
            labelGender.setForeground(new Color(51, 51, 255));
            labelGender.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelBirthdate ----
            labelBirthdate.setText("Birthdate");
            labelBirthdate.setForeground(new Color(51, 51, 255));
            labelBirthdate.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelConfirmPass ----
            labelConfirmPass.setText("Confirm Password");
            labelConfirmPass.setForeground(new Color(51, 51, 255));
            labelConfirmPass.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- label36 ----
            label36.setText("*");
            label36.setForeground(new Color(255, 0, 102));
            label36.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- textCountry ----
            textCountry.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textCountry.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- textOffice ----
            textOffice.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textOffice.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- textField21 ----
            textField21.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textField21.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- textBirthdate ----
            textBirthdate.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textBirthdate.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- textConfirmPassword ----
            textConfirmPassword.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textConfirmPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- label37 ----
            label37.setText("*");
            label37.setForeground(new Color(255, 0, 102));
            label37.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label39 ----
            label39.setText("*");
            label39.setForeground(new Color(255, 0, 102));
            label39.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- label24 ----
            label24.setText("**");
            label24.setForeground(new Color(255, 0, 102));
            label24.setFont(new Font("Tahoma", Font.PLAIN, 14));

            //---- labelCustomerOrProvider ----
            labelCustomerOrProvider.setText("Customer/Provider");
            labelCustomerOrProvider.setForeground(new Color(51, 51, 255));
            labelCustomerOrProvider.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- ComboBoxOfGender ----
            ComboBoxOfGender.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            ComboBoxOfGender.setModel(new DefaultComboBoxModel<>(new String[] {
                "Male",
                "Female"
            }));
            ComboBoxOfGender.setFont(new Font("Century Gothic", Font.BOLD, 18));
            ComboBoxOfGender.setForeground(new Color(51, 51, 255));
            ComboBoxOfGender.setRequestFocusEnabled(false);
            ComboBoxOfGender.setVerifyInputWhenFocusTarget(false);

            //---- ComboBoxOfCustomerOrProvider ----
            ComboBoxOfCustomerOrProvider.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            ComboBoxOfCustomerOrProvider.setModel(new DefaultComboBoxModel<>(new String[] {
                "Customer",
                "Provider"
            }));
            ComboBoxOfCustomerOrProvider.setFont(new Font("Century Gothic", Font.BOLD, 18));
            ComboBoxOfCustomerOrProvider.setForeground(new Color(51, 51, 255));

            //---- commentsOfRegistration ----
            commentsOfRegistration.setText("* required field");
            commentsOfRegistration.setForeground(new Color(255, 0, 102));
            commentsOfRegistration.setFont(new Font("Century Gothic", Font.BOLD, 14));

            //---- ButtonClear ----
            ButtonClear.setText("Clear");
            ButtonClear.setForeground(new Color(51, 51, 255));
            ButtonClear.setFont(new Font("Century Gothic", Font.BOLD, 18));
            ButtonClear.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));

            //---- ButtonRegister ----
            ButtonRegister.setText("Register");
            ButtonRegister.setForeground(new Color(51, 51, 255));
            ButtonRegister.setFont(new Font("Century Gothic", Font.BOLD, 18));
            ButtonRegister.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            ButtonRegister.setVerifyInputWhenFocusTarget(false);
            ButtonRegister.setFocusable(false);
            ButtonRegister.setDefaultCapable(false);
            ButtonRegister.setContentAreaFilled(false);
            ButtonRegister.setSelected(true);
            ButtonRegister.setFocusPainted(false);

            //======== PanelOfBookinh ========
            {
                PanelOfBookinh.setBackground(new Color(51, 51, 255));

                //---- labelBooking ----
                labelBooking.setText(".Booking");
                labelBooking.setFont(new Font("Century Gothic", Font.BOLD, 20));
                labelBooking.setForeground(Color.white);

                GroupLayout PanelOfBookinhLayout = new GroupLayout(PanelOfBookinh);
                PanelOfBookinh.setLayout(PanelOfBookinhLayout);
                PanelOfBookinhLayout.setHorizontalGroup(
                    PanelOfBookinhLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, PanelOfBookinhLayout.createSequentialGroup()
                            .addContainerGap(10, Short.MAX_VALUE)
                            .addComponent(labelBooking, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                PanelOfBookinhLayout.setVerticalGroup(
                    PanelOfBookinhLayout.createParallelGroup()
                        .addGroup(PanelOfBookinhLayout.createSequentialGroup()
                            .addGap(393, 393, 393)
                            .addComponent(labelBooking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(395, Short.MAX_VALUE))
                );
            }

            //---- commentsOfRegistration2 ----
            commentsOfRegistration2.setText("**informations that refers to providers");
            commentsOfRegistration2.setForeground(new Color(255, 0, 102));
            commentsOfRegistration2.setFont(new Font("Century Gothic", Font.BOLD, 14));

            //---- label29 ----
            label29.setText("*");
            label29.setForeground(new Color(255, 0, 102));
            label29.setFont(new Font("Tahoma", Font.PLAIN, 14));

            GroupLayout this2ContentPaneLayout = new GroupLayout(this2ContentPane);
            this2ContentPane.setLayout(this2ContentPaneLayout);
            this2ContentPaneLayout.setHorizontalGroup(
                this2ContentPaneLayout.createParallelGroup()
                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelUserName)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label30, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textUserName, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                    .addComponent(textFirstName, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                                                .addGap(87, 87, 87)
                                                .addComponent(textLastName, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelEmail)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label31, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(labelPhone)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label33, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textCountry, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField21, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(labelCountry)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label37, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelBirthdate)
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(labelRegion)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label25, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(textBirthdate, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonRegister, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonClear, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(commentsOfRegistration, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(commentsOfRegistration2)
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label27, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelOffice)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label24, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(textOffice, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(textPhone, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(79, 79, 79)
                                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelLastName)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label35, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelPass)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label28, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelCustomerOrProvider)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label29, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(labelGender)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label39, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ComboBoxOfGender, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelConfirmPass, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                                .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(ComboBoxOfCustomerOrProvider, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textConfirmPassword, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label36, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(labelRegestration, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(PanelOfBookinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            this2ContentPaneLayout.setVerticalGroup(
                this2ContentPaneLayout.createParallelGroup()
                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(labelRegestration)
                        .addGap(18, 18, 18)
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label27)
                                    .addComponent(labelLastName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label35))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textLastName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFirstName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(labelPass)
                                    .addComponent(label28))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(labelUserName))
                                    .addComponent(label30, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textUserName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(labelEmail)
                                    .addComponent(label31))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelConfirmPass)
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(label36))
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textConfirmPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(8, 8, 8)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label33)
                                        .addGap(21, 21, 21))
                                    .addComponent(labelPhone, GroupLayout.Alignment.TRAILING))
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(label1))
                                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textPhone, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(labelCountry)
                                    .addComponent(label37))
                                .addGap(10, 10, 10)
                                .addComponent(textCountry, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(labelCustomerOrProvider)
                                    .addComponent(label29))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxOfCustomerOrProvider, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label39)
                                    .addComponent(labelGender))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboBoxOfGender, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addComponent(labelOffice)
                            .addComponent(label24))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textOffice, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addComponent(labelRegion)
                            .addComponent(label25))
                        .addGap(11, 11, 11)
                        .addComponent(textField21, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelBirthdate)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textBirthdate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRegister)
                            .addComponent(ButtonClear))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commentsOfRegistration, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commentsOfRegistration2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelOfBookinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
            this2.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JFrame this2;
    private JPanel panel2;
    private JLabel label12;
    private JLabel labelRegestration;
    private JLabel labelFirstName;
    private JTextField textFirstName;
    private JLabel labelPhone;
    private JLabel label1;
    private JLabel label25;
    private JLabel label27;
    private JLabel label30;
    private JLabel label31;
    private JLabel label33;
    private JTextField textLastName;
    private JLabel label35;
    private JTextField textPhone;
    private JTextField textUserName;
    private JLabel labelLastName;
    private JLabel labelUserName;
    private JLabel labelPass;
    private JLabel label28;
    private JTextField textPassword;
    private JLabel labelEmail;
    private JTextField textEmail;
    private JLabel labelCountry;
    private JLabel labelOffice;
    private JLabel labelRegion;
    private JLabel labelGender;
    private JLabel labelBirthdate;
    private JLabel labelConfirmPass;
    private JLabel label36;
    private JTextField textCountry;
    private JTextField textOffice;
    private JTextField textField21;
    private JTextField textBirthdate;
    private JTextField textConfirmPassword;
    private JLabel label37;
    private JLabel label39;
    private JLabel label24;
    private JLabel labelCustomerOrProvider;
    private JComboBox<String> ComboBoxOfGender;
    private JComboBox<String> ComboBoxOfCustomerOrProvider;
    private JLabel commentsOfRegistration;
    private JButton ButtonClear;
    private JButton ButtonRegister;
    private JPanel PanelOfBookinh;
    private JLabel labelBooking;
    private JLabel commentsOfRegistration2;
    private JLabel label29;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
