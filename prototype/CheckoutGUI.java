import static java.awt.Component.LEFT_ALIGNMENT;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.text.DefaultFormatter;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;


public class CheckoutGUI{
    
    public CheckoutGUI(int seatNums[],double SeatPrices[],String SeatTypes[],String flightNum, String email)throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame checkoutGUIframe = new CheckoutGUIFrame(seatNums,SeatPrices,SeatTypes,flightNum,email);
        checkoutGUIframe.setVisible(true);
        

    }
}

class CheckoutGUIFrame extends JFrame {
	 JPanel mainframe;
	 JTextField creditcard;
	 JTextField addresstext;
	 JTextField couponcode;
	 JRadioButton visa ;
	 JRadioButton mastercard ;
	 JRadioButton discover ;
	 JRadioButton amex ;
	 static String email;
  public CheckoutGUIFrame(final int SeatNums[],final double SeatPrices[],final String SeatTypes[],final String flightNum, String Email)throws Exception {
    super("Checkout");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(400,375);
    mainframe = new JPanel();
    
    email=Email;
    
    JButton checkoutbutton=new JButton("Checkout");
    JButton cancelbutton=new JButton("Cancel");

    visa = new JRadioButton("Visa");
    mastercard= new JRadioButton("Mastercard");
    discover = new JRadioButton("Discover Card");
    amex = new JRadioButton("American Express");
    
    ButtonGroup cardtype = new ButtonGroup();
    cardtype.add(visa);
    cardtype.add(mastercard);
    cardtype.add(discover);
    cardtype.add(amex);
    
    
    String theTickets="<html>";
    for(int a=0;a<SeatNums.length;a++)
    {
    	theTickets+="Flight Number: "+flightNum+"    Seat Number: "+ SeatNums[a]+"    "+  SeatTypes[a]+"    $"+  SeatPrices[a]+"<br>";
    }
    theTickets+="</html>";
    creditcard=new JTextField();
    JLabel namelabel=new JLabel(theTickets);

    addresstext = new JTextField();
    couponcode = new JTextField();

    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();  //p1 is verified information
    JPanel p2 = new JPanel();  //p2 is credit card textfield
    JPanel p4 = new JPanel();  //p4 address
    JPanel p5 = new JPanel();  //p4 address
    JPanel p3 = new JPanel();  //p3 is buttons
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
    p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
    p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
    
    p1.setBorder(BorderFactory.createTitledBorder("Confirmed Information"));
    p2.setBorder(BorderFactory.createTitledBorder("Credit Card Number"));
    p4.setBorder(BorderFactory.createTitledBorder("Billing Address"));
    p5.setBorder(BorderFactory.createTitledBorder("Coupon Code"));
    
    

    p1.add(namelabel);

    
    p2.add(creditcard);
    p2.add(visa);
    p2.add(amex);
    p2.add(discover);
    p2.add(mastercard);
    
    p3.add(cancelbutton);
    p3.add(checkoutbutton);
    p4.add(addresstext);
    p5.add(couponcode);
    
    mainframe.add(p1);
    mainframe.add(p2);
    mainframe.add(p4);
    mainframe.add(p5);
    mainframe.add(p3);
    
    this.add(mainframe);
    

    
    //the code below listens for when the checkout button is clicked
    ActionListener checkoutlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        String CreditCardNum=creditcard.getText();
        String address=addresstext.getText();
        String coupon=couponcode.getText();
        String cardType="";
    	System.out.println(email);

        if(visa.isSelected()==true)
        {
        	cardType="visa";
        }
        if(amex.isSelected()==true)
        {
        	cardType="americanexpress";
        }
        if(discover.isSelected()==true)
        {
        	cardType="discovercard";
        }
        if(mastercard.isSelected()==true)
        {
        	cardType="mastercard";
        }
        CreditCardValidation checkCard = new CreditCardValidation(CreditCardNum,cardType);
        boolean creditCardValid= checkCard.isValid();
        boolean couponEmailMatch=false;
        boolean codeExist=false;
        checkCoupon checkTheCoupon;
		try {
			checkTheCoupon = new checkCoupon(coupon,email);
	        couponEmailMatch=checkTheCoupon.perfectMatch();
	        codeExist=checkTheCoupon.codeMatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(email.compareTo("")==0)
        {
        	JOptionPane.showMessageDialog(mainframe, "Go back to the home page to login");
        	//LoginGUI attemptLogin=new LoginGUI();
        	//email=attemptLogin.getUserEmail();
        	//System.out.println(email);

        }
        else if(address.compareTo("")==0)
        {
        	JOptionPane.showMessageDialog(mainframe, "Enter Address please.");

        }
        else if(creditCardValid==false)
        {
        	JOptionPane.showMessageDialog(mainframe, "Credit card information is invalid. \n Please try again.");
        }
        else if(coupon.compareTo("")!=0&&codeExist==false)
        {
        	JOptionPane.showMessageDialog(mainframe, "Coupon code is invalid. \n Please try again.");
        }
        else if(coupon.compareTo("")!=0&&couponEmailMatch==false)
        {
        	JOptionPane.showMessageDialog(mainframe, "Coupon code is does not belong to this user. \n Please try one that does belong to you.");
        }
        else
        {
        	if(couponEmailMatch==true)
        	{
        		//apply coupon then send all info to confirmation page
        		double newPrices[]=new double [SeatPrices.length];
        		for (int a=0;a<SeatPrices.length;a++)
        		{
        			newPrices[a]=SeatPrices[a]*.9;
        		}
        		try {
					ConfirmationGUI Confirm=new ConfirmationGUI(SeatNums,newPrices, SeatTypes, flightNum, email,address,CreditCardNum,coupon);
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
        	else
        	{
        		//do not apply coupon then send all info to confirmation page
        		try {
					ConfirmationGUI Confirm=new ConfirmationGUI(SeatNums,SeatPrices, SeatTypes, flightNum, email,address,CreditCardNum,coupon);
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
        }
      }
    };
    checkoutbutton.addActionListener(checkoutlistener);
    
    //the code below listens for when the checkout button is clicked
    ActionListener cancellistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();

        }
    };

    cancelbutton.addActionListener(cancellistener);
  }
}