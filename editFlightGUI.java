import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class editFlightGUI extends JFrame implements ActionListener
{
    private final JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    private final JTextField t1, t2, t3, t4, t5, t6, t7;
    private final JButton b1, b2, b3;
    //private final String validTime = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
    
    public editFlightGUI(String PLANE_ID,String FLIGHT_NUM,String START_LOC,String END_LOC,String BASE_PRICE,String PLANE_TYPE,String FLIGHT_TIME)
    {
        super("edit Flight");
        setLayout(null);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l1 = new JLabel("Enter flight information.");
        l2 = new JLabel("Plane ID:");
        l3 = new JLabel("Flight Number:");
        l4 = new JLabel("Start Location:");
        l5 = new JLabel("End Location:");
        l6 = new JLabel("Base Price:");
        l7 = new JLabel("Plane Type:");
        l8 = new JLabel("Flight Time:");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        b1 = new JButton("edit Flight");
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
        l7.setBounds(30, 300, 200, 30);
        l8.setBounds(30, 350, 200, 30);
        t1.setBounds(250, 50, 200, 30);
        t2.setBounds(250, 100, 200, 30);
        t3.setBounds(250, 150, 200, 30);
        t4.setBounds(250, 200, 200, 30);
        t5.setBounds(250, 250, 200, 30);
        t6.setBounds(250, 300, 200, 30);
        t7.setBounds(250, 350, 200, 30);
        b1.setBounds(40, 400, 100, 30);
        b2.setBounds(190, 400, 100, 30);
        b3.setBounds(340, 400, 100, 30);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(b1);
        add(b2);
        add(b3);
        
        t1.setText(PLANE_ID);
        t2.setText(FLIGHT_NUM);
        t3.setText(START_LOC);
        t4.setText(END_LOC);
        t5.setText(BASE_PRICE);
        t6.setText(PLANE_TYPE);
        t7.setText(FLIGHT_TIME);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String planeID = t1.getText();
            String flightNum = t2.getText();
            String startLoc = t3.getText();
            String endLoc = t4.getText();
            String basePrice = t5.getText();
            double basePricev=Double.parseDouble(basePrice);
            String planeType = t6.getText();
            int planeTypev=Integer.parseInt(planeType);
            String flightTime = t7.getText();
            
            if("".equals(planeID))
            {
                JOptionPane.showMessageDialog(this, "Please enter flight ID");
            } 
            else if("".equals(flightNum))
            {
                JOptionPane.showMessageDialog(this, "Please enter flight number");
            }
            else if("".equals(startLoc))
            {
                JOptionPane.showMessageDialog(this, "Please enter start location");
            }
            else if("".equals(endLoc))
            {
                JOptionPane.showMessageDialog(this, "Please enter end location");
            }
            else if("".equals(basePrice))
            {
                JOptionPane.showMessageDialog(this, "Please enter base price");
            }
            else if("".equals(planeType))
            {
                JOptionPane.showMessageDialog(this, "Please enter plane type");
            }
            else
            {
                //Pattern timePattern = Pattern.compile(validTime);
                //Matcher timeMatcher = timePattern.matcher(flightTime);
                //if(timeMatcher.matches())
               // {
                    //Code here to store information in database
                    try {
						editFlight thisFlight=new editFlight(flightNum,planeID,startLoc,endLoc,basePricev,planeTypev,flightTime);
						if (thisFlight.FlightNumExist()==true)
						{
		                    JOptionPane.showMessageDialog(this, "Flight has been edited");
		                    dispose();
						}
						else
						{
		                    JOptionPane.showMessageDialog(this, "Flight number does not exist in the database");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
                    //String planeID,String flightNum,String sLoc,String eLoc, double bPrice, int planeType, String dTime
              //  }
               // else
               // {
               //     JOptionPane.showMessageDialog(this, "Use 12-hour format and include AM or PM");
               //     t7.setText("");
               // }
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
        }
        else if(e.getSource()==b3)
        {
            dispose();
        }
    }
    
    public static void main(String[] args)
    {
        AddFlightGUI addFlightGUI = new AddFlightGUI();
    }
}
