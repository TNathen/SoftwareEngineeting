import java.awt.event.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener
{
    private final JLabel l1, l2, l3, l4, l5, l6, l7;
    private final JTextField t1, t2, t3, t4;
    private final JButton b1, b2, b3;
    private final JPasswordField p1, p2;
    private final String validEmail = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\."
            + "[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String validPhone = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})"
            + "[-.\\s]?([0-9]{4})$";
    
    public SignUp()
    {
        super("Sign-Up Form");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Enter the following information to sign-up!");
        l2 = new JLabel("First name:");
        l3 = new JLabel("Last name:");
        l4 = new JLabel("E-mail:");
        l5 = new JLabel("Phone:");
        l6 = new JLabel("Password:");
        l7 = new JLabel("Confirm Password:");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        b1 = new JButton("Submit");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");
        
        l5.setToolTipText("<html><p>Use any of the following format:</p>"
                + "<p>1234567890</p><p>123-456-7890</p><p>123.456.7890</p>"
                + "<p>123 456 7890</p><p>(123) 456 7890</p></html>");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        l1.setBounds(120, 10, 500, 30);
        l2.setBounds(30, 50, 200, 30);
        l3.setBounds(30, 100, 200, 30);
        l4.setBounds(30, 150, 200, 30);
        l5.setBounds(30, 200, 200, 30);
        l6.setBounds(30, 250, 200, 30);
        l7.setBounds(30, 300, 200, 30);
        t1.setBounds(250, 50, 200, 30);
        t2.setBounds(250, 100, 200, 30);
        t3.setBounds(250, 150, 200, 30);
        t4.setBounds(250, 200, 200, 30);
        p1.setBounds(250, 250, 200, 30);
        p2.setBounds(250, 300, 200, 30);
        b1.setBounds(40, 350, 100, 30);
        b2.setBounds(190, 350, 100, 30);
        b3.setBounds(340, 350, 100, 30);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(p1);
        add(p2);
        add(b1);
        add(b2);
        add(b3);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String s1 = t1.getText();
            String s2 = t2.getText();
            String s3 = t3.getText();
            String s4 = t4.getText();
            char[] s5 = p1.getPassword();
            char[] s6 = p2.getPassword();
            
            Pattern emailPattern = Pattern.compile(validEmail);
            Matcher emailMatcher = emailPattern.matcher(s3);
            if(emailMatcher.matches())
            {
                Pattern phonePattern = Pattern.compile(validPhone);
                Matcher phoneMatcher = phonePattern.matcher(s4);
                if(phoneMatcher.matches())
                {
                    if(Arrays.equals(s5, s6))
                    {
                        JOptionPane.showMessageDialog(b1, 
                                "You are now a member!");
                        //Code here to store information in database
                    }
                    else{
                        JOptionPane.showMessageDialog(b1, 
                                "Passwords do not match");
                        p1.setText("");
                        p2.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(b1, "Invalid phone number");
                    t4.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(b1, "Invalid e-mail");
                t3.setText("");
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            p1.setText("");
            p2.setText("");
        }
        else if(e.getSource()==b3)
        {
            System.exit(0);
        }
    }
    
    public static void main(String[] args)
    {
        SignUp signUp = new SignUp();
    }    
}