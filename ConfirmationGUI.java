import static java.awt.Component.LEFT_ALIGNMENT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


import java.awt.event.*;
import javax.swing.*;


public class ConfirmationGUI{
    
    public ConfirmationGUI(int seatNums[],double SeatPrices[],String SeatTypes[],String flightNum, String email,String address,String creditcard,String coupon) throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame confirmationGUIframe = new ConfirmationGUIFrame(seatNums,SeatPrices,SeatTypes,flightNum, email,address,creditcard,coupon);
        confirmationGUIframe.setVisible(true);

    }
}

class ConfirmationGUIFrame extends JFrame {
	JPanel mainframe;

    
  public ConfirmationGUIFrame(final int SeatNums[],final double SeatPrices[],final String SeatTypes[],final String flightNum,final String email,final String address,final String creditcard,final String coupon) throws Exception{
    super("Flight Order Confirmation");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(400,375);
    mainframe = new JPanel();
    
    JButton checkoutbutton=new JButton("Confirm");
    JButton cancelbutton=new JButton("Cancel");
    
    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
    Statement stat = conn.createStatement();
    ResultSet rs = stat.executeQuery("select * from USERS where EMAIL = \""+email+"\";");
    
    String fName=rs.getString("First_NAME");
    String lName=rs.getString("LAST_NAME");
    
    rs.close();
    ResultSet rs2 = stat.executeQuery("select * from FLIGHTS where FLIGHT_NUM = \""+flightNum+"\";");
    int planeType=rs.getInt("PLANE_TYPE");
    rs2.close();
    conn.close();
    String theTickets="<html>";
    for(int a=0;a<SeatNums.length;a++)
    {
    	theTickets+="Flight Number: "+flightNum+"    Seat Number: "+ SeatNums[a]+"    "+  SeatTypes[a]+"    $"+  SeatPrices[a]+"<br>";
    }
    theTickets+="</html>";
    
    double total=0;
    for(int a=0;a<SeatPrices.length;a++)
    {
    	total+=SeatPrices[a];
    }
    
    JLabel namelabel=new JLabel(fName+" "+lName);
    JLabel flightlabel=new JLabel(theTickets);
    JLabel seatlabel=new JLabel("Your total cost is: "+total);
    JLabel creditcardlast4digs=new JLabel("Your Credit Card: *********"+creditcard.substring(creditcard.length()-4));
    JLabel billingaddress=new JLabel("Billing Address: "+address);

    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();  //p1 is verified information
    JPanel p2 = new JPanel();  //p2 is duh buttinz
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
    
    p1.setBorder(BorderFactory.createTitledBorder("Confirmed Information"));
    //p2.setBorder(BorderFactory.createTitledBorder("Credit Card Number"));
    //p4.setBorder(BorderFactory.createTitledBorder("Billing Address"));
    //p5.setBorder(BorderFactory.createTitledBorder("Coupon Code"));
    
    
    
    
    
    
    p1.add(namelabel);
    p1.add(flightlabel);
    p1.add(seatlabel);
    p1.add(creditcardlast4digs);
    p1.add(billingaddress);
    
    
    p2.add(cancelbutton);
    p2.add(checkoutbutton);
    
    mainframe.add(p1);
    mainframe.add(p2);
    
    this.add(mainframe);
    
    
    
    //the code below listens for when the checkout button is clicked
    ActionListener checkoutlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        
        if(coupon.compareTo("")!=0)
        {
        	try {
				removeCoupon thisCoupon=new removeCoupon(coupon);
			} catch (Exception e) {
				e.printStackTrace();
			}

        }
        for(int a=0;a<SeatNums.length;a++)
        {
        	int isHandicap=0;
        	if(SeatTypes[a].compareTo("Handicap Seat")==0)
        	{
        		isHandicap=1;
        	}
        	try {
				addTicket thisTicket=new addTicket(flightNum,email,1,SeatNums[a],SeatPrices[a],creditcard,address,'c',0,isHandicap);
	            Class.forName("org.sqlite.JDBC");
	            Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
	            Statement stat = conn.createStatement();
	    	    ResultSet rs = stat.executeQuery("select * from USERS where EMAIL = \""+email+"\";");
	    	    double moneySpent= rs.getDouble("MONEYSPENT");
	    	    moneySpent+=SeatPrices[a];
	            stat.executeUpdate("UPDATE USERS SET MONEYSPENT = '"+ moneySpent+"' WHERE EMAIL = \""+email+"\";");
	            rs.close();
	            conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

        }
        //generate coupon
        boolean coupon=false;
        String theCode="";
        try {
			generateCoupon makeCoupon=new generateCoupon (email);
			coupon=makeCoupon.createCoupon();
			theCode=makeCoupon.getCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(coupon==true)
        {
        	String quote="For being a loyal customer, have a coupon for 10% off for your next purchase.\n\t\t\t"+theCode+"\nMake sure you save the code somewhere\nCoupon expire one year from today.";
            JOptionPane.showMessageDialog(mainframe, quote);
        }

        //stops entire program
        System.exit(0);
      }
    };
    checkoutbutton.addActionListener(checkoutlistener);
    
    //the code below listens for when the checkout button is clicked
    ActionListener cancellistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        dispose();
      }
    };
    cancelbutton.addActionListener(cancellistener);
  }
}