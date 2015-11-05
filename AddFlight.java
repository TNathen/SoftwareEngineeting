import java.awt.event.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;

public class AddFlight extends JFrame implements ActionListener
{
    private final JLabel l1, l2, l3, l4, l5, l6;
    private final JTextField t1, t2, t3, t4, t5;
    private final JButton b1, b2, b3;
    private final String validTime = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
    
    public AddFlight()
    {
        super("Add Flight");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Enter flight information.");
        l2 = new JLabel("Flight number:");
        l3 = new JLabel("Depature location:");
        l4 = new JLabel("Destination:");
        l5 = new JLabel("Departure Time:");
        l6 = new JLabel("Arrival Time:");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        b1 = new JButton("Submit");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        l1.setBounds(170, 10, 500, 30);
        l2.setBounds(30, 50, 200, 30);
        l3.setBounds(30, 100, 200, 30);
        l4.setBounds(30, 150, 200, 30);
        l5.setBounds(30, 200, 200, 30);
        l6.setBounds(30, 250, 200, 30);
        t1.setBounds(250, 50, 200, 30);
        t2.setBounds(250, 100, 200, 30);
        t3.setBounds(250, 150, 200, 30);
        t4.setBounds(250, 200, 200, 30);
        t5.setBounds(250, 250, 200, 30);
        b1.setBounds(40, 300, 100, 30);
        b2.setBounds(190, 300, 100, 30);
        b3.setBounds(340, 300, 100, 30);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
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
            String s5 = t5.getText();
            
            Pattern timePattern = Pattern.compile(validTime);
            Matcher timeMatcher = timePattern.matcher(s4);
            if(timeMatcher.matches())
            {
                Pattern timePattern2 = Pattern.compile(validTime);
                Matcher timeMatcher2 = timePattern2.matcher(s5);
                if(timeMatcher2.matches())
                {
                    JOptionPane.showMessageDialog(b1, "Flight added");
                    //Code here to store information in database
                }
                else
                {
                    JOptionPane.showMessageDialog(b1, "Use 12-hour format and include AM or PM");
                    t5.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(b1, "Use 12-hour format and include AM or PM");
                t4.setText("");
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
        }
        else if(e.getSource()==b3)
        {
            System.exit(0);
        }
    }
    
    public static void main(String [] args)
    {
        new AddFlight();
    }
}