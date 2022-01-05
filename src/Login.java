import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Jan 05 17:33:12 EET 2022
 */



/**
 * @author Nikos Mpasdanis
 */
public class Login extends JFrame implements ActionListener {
    public Login() {
        initComponents();
    }



    private void textUsernameFocusGained(FocusEvent e) {
        textUsername.setText("");
    }

    private void PasswordFieldFocusGained(FocusEvent e) {
        PasswordField.setText("");
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void login(ActionEvent e) {
        // TODO add your code here
    }

    private void commentsLloginMouseClicked(MouseEvent e) {
        Register register=new Register();
        register.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
        panel4 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        panel2 = new JPanel();
        labelLogin = new JLabel();
        labelUserName = new JLabel();
        labelPass = new JLabel();
        comboBoxSelectUser = new JComboBox<>();
        labelSelectRole = new JLabel();
        buttonLogin = new JButton();
        buttonClear = new JButton();
        commentsLlogin = new JLabel();
        textUsername = new JTextField();
        PasswordField = new JPasswordField();
        panelMeTa = new JPanel();
        labelMeta = new JLabel();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();

        //======== panel4 ========
        {
            panel4.setBackground(new Color(51, 51, 255));
            panel4.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,panel4. getBorder( )) ); panel4. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- label6 ----
            label6.setText("luxury must be");
            label6.setForeground(Color.white);
            label6.setFont(new Font("Century Gothic", Font.ITALIC, 14));

            //---- label7 ----
            label7.setText("comfortable,");
            label7.setForeground(Color.white);
            label7.setFont(new Font("Century Gothic", Font.ITALIC, 14));

            //---- label8 ----
            label8.setText("otherwise");
            label8.setForeground(Color.white);
            label8.setFont(new Font("Century Gothic", Font.ITALIC, 14));

            //---- label9 ----
            label9.setText("it is not luxury.");
            label9.setForeground(Color.white);
            label9.setFont(new Font("Century Gothic", Font.ITALIC, 14));

            //---- label10 ----
            label10.setText("Coco Chanel");
            label10.setFont(new Font("Rage Italic", Font.BOLD, 16));
            label10.setForeground(Color.white);

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup()
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label10)
                        .addContainerGap(110, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {

            //---- labelLogin ----
            labelLogin.setText("LOGIN");
            labelLogin.setForeground(new Color(51, 51, 255));
            labelLogin.setFont(new Font("Century Gothic", Font.BOLD, 30));

            //---- labelUserName ----
            labelUserName.setText("Username");
            labelUserName.setForeground(new Color(51, 51, 255));
            labelUserName.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- labelPass ----
            labelPass.setText("Password");
            labelPass.setForeground(new Color(51, 51, 255));
            labelPass.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- comboBoxSelectUser ----
            comboBoxSelectUser.setMaximumRowCount(10);
            comboBoxSelectUser.setFont(new Font("Century Gothic", Font.BOLD, 18));
            comboBoxSelectUser.setModel(new DefaultComboBoxModel<>(new String[] {
                "Admin",
                "Provider",
                "Customer"
            }));
            comboBoxSelectUser.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            comboBoxSelectUser.setForeground(new Color(51, 51, 255));

            //---- labelSelectRole ----
            labelSelectRole.setText("Select Role");
            labelSelectRole.setForeground(new Color(51, 51, 255));
            labelSelectRole.setFont(new Font("Century Gothic", Font.BOLD, 20));

            //---- buttonLogin ----
            buttonLogin.setText("Login");
            buttonLogin.setFont(new Font("Century Gothic", Font.BOLD, 18));
            buttonLogin.setForeground(new Color(51, 51, 255));
            buttonLogin.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            buttonLogin.addActionListener(e -> {
			button1(e);
			login(e);
		});

            //---- buttonClear ----
            buttonClear.setText("Clear");
            buttonClear.setFont(new Font("Century Gothic", Font.BOLD, 18));
            buttonClear.setForeground(new Color(51, 51, 255));
            buttonClear.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            buttonClear.addActionListener(this);

            //---- commentsLlogin ----
            commentsLlogin.setText("if you want to create a new account,click here");
            commentsLlogin.setForeground(new Color(51, 51, 255));
            commentsLlogin.setFont(new Font("Century Gothic", Font.BOLD, 14));
            commentsLlogin.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    commentsLloginMouseClicked(e);
                }
            });

            //---- textUsername ----
            textUsername.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 51, 255), new Color(51, 51, 255), Color.white, Color.darkGray));
            textUsername.setFont(new Font("Century Gothic", Font.PLAIN, 14));

            //---- PasswordField ----
            PasswordField.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(102, 102, 255), new Color(51, 51, 255), Color.white, Color.darkGray));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(0, 129, Short.MAX_VALUE)
                        .addComponent(buttonLogin, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(buttonClear, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(labelPass, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUserName, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSelectRole))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(comboBoxSelectUser, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(labelLogin, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(104, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(85, Short.MAX_VALUE)
                        .addComponent(commentsLlogin, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(labelLogin)
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxSelectUser, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSelectRole))
                        .addGap(29, 29, 29)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUserName))
                        .addGap(29, 29, 29)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPass)
                            .addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonClear)
                            .addComponent(buttonLogin))
                        .addGap(10, 10, 10)
                        .addComponent(commentsLlogin, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
            );
        }

        //======== panelMeTa ========
        {
            panelMeTa.setBackground(new Color(51, 51, 255));

            //---- labelMeta ----
            labelMeta.setText("meTa");
            labelMeta.setForeground(Color.white);
            labelMeta.setFont(new Font("Century Gothic", Font.BOLD, 18));

            GroupLayout panelMeTaLayout = new GroupLayout(panelMeTa);
            panelMeTa.setLayout(panelMeTaLayout);
            panelMeTaLayout.setHorizontalGroup(
                panelMeTaLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelMeTaLayout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(labelMeta, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
            );
            panelMeTaLayout.setVerticalGroup(
                panelMeTaLayout.createParallelGroup()
                    .addGroup(panelMeTaLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(labelMeta, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(159, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panelMeTa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE))
                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMeTa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nikos Mpasdanis
    private JPanel panel4;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JPanel panel2;
    private JLabel labelLogin;
    private JLabel labelUserName;
    private JLabel labelPass;
    private JComboBox<String> comboBoxSelectUser;
    private JLabel labelSelectRole;
    private JButton buttonLogin;
    private JButton buttonClear;
    private JLabel commentsLlogin;
    JTextField textUsername;
    JPasswordField PasswordField;
    private JPanel panelMeTa;
    private JLabel labelMeta;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonClear){
            textUsername.setText("");
            PasswordField.setText("");
        }
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
