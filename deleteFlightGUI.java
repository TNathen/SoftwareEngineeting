import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class deleteFlightGUI extends JFrame implements ActionListener
{
    private final JLabel l1, l2;
    private final JTextField t1;
    private final JButton b1, b2, b3;
    private static String TheEmail="";
    public deleteFlightGUI()
    {
        super("delete Flight");
        setLayout(null);
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        l1 = new JLabel("Delete a Flight");
        l2 = new JLabel("Flight Number: ");
        t1 = new JTextField();
        b1 = new JButton("Delete");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        l1.setBounds(170, 10, 500, 30);
        l2.setBounds(30, 50, 200, 30);

        t1.setBounds(250, 50, 200, 30);
        b1.setBounds(40, 150, 100, 30);
        b2.setBounds(190, 150, 100, 30);
        b3.setBounds(340, 150, 100, 30);

        add(l1);
        add(l2);

        add(t1);
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
            String FlightNum = t1.getText();
            
            try {
				deleteFlight thisFlight=new deleteFlight(FlightNum);
                JOptionPane.showMessageDialog(this, "Flight has been deleted");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
            
            	
            
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
        }
        else if(e.getSource()==b3)
        {
            dispose();
        }
    }
    public static void main(String[] args)
    {
        deleteFlightGUI deleteFlightGUI = new deleteFlightGUI();
    }
}
