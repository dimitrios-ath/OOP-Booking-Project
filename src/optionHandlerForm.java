import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 05 21:21:15 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class optionHandlerForm extends JPanel {
    JFrame jframe;
    optionHandlerForm previousPanel; // object tis login

    void setPanel(optionHandlerForm previousPanel){
        this.previousPanel = previousPanel;
    }

    public optionHandlerForm(JFrame frame) {
        initComponents();
        this.jframe = frame;
    }

    private void button1(ActionEvent e) {
        //System.out.println("test");
        test hey = new test(this.jframe);
        hey.setPreviousPanel(hey);
        this.jframe.add(hey);
        this.previousPanel.setVisible(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();

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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("login");
        add(label1, "cell 3 0");

        //---- textField1 ----
        textField1.setText("user");
        add(textField1, "cell 3 2");

        //---- textField2 ----
        textField2.setText("pass");
        add(textField2, "cell 3 3");

        //---- button1 ----
        button1.setText("login");
        button1.addActionListener(e -> button1(e));
        add(button1, "cell 3 5");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
