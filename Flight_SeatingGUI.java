import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class Flight_SeatingGUI{
    
    public Flight_SeatingGUI(String flightNum, String email) throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame flightseatingGUIframe = new Flight_SeatingGUIFrame(flightNum,email);
        flightseatingGUIframe.setVisible(true);
        

    }
}

class Flight_SeatingGUIFrame extends JFrame 
{
    static JToggleButton btn[]=new JToggleButton[60];
    boolean needsDiscount;
  public Flight_SeatingGUIFrame(final String flightNum, final String email) throws Exception
  {
    super("Flight Seating Assignment");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500,500);
    setResizable(false);
    setLocationRelativeTo(null);
    final JPanel mainframe = new JPanel();
    
    //JToggleButton r1c1=new JToggleButton("Row1 Col1");
    //JToggleButton r1c2=new JToggleButton("Row1 Col2");
    
    
    JButton submitbutton=new JButton("Submit");
    JButton cancelbutton=new JButton("Cancel");
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();
    JPanel p7 = new JPanel();
    JPanel p8 = new JPanel();
    JPanel p9 = new JPanel();
    JPanel p10 = new JPanel();
    JPanel p11 = new JPanel();
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
    p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
    p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
    p5.setLayout(new BoxLayout(p5, BoxLayout.X_AXIS));
    p6.setLayout(new BoxLayout(p6, BoxLayout.X_AXIS));
    p7.setLayout(new BoxLayout(p7, BoxLayout.X_AXIS)); 
    p8.setLayout(new BoxLayout(p8, BoxLayout.X_AXIS));
    p9.setLayout(new BoxLayout(p9, BoxLayout.X_AXIS));
    p10.setLayout(new BoxLayout(p10, BoxLayout.X_AXIS));
    p11.setLayout(new BoxLayout(p11, BoxLayout.X_AXIS));
    
    JToggleButton btn1 = new JToggleButton("1");
    JToggleButton btn2 = new JToggleButton("2");
    JToggleButton btn3 = new JToggleButton("3");
    JToggleButton btn4 = new JToggleButton("4");
    JToggleButton btn5 = new JToggleButton("5");
    JToggleButton btn6 = new JToggleButton("6");
    JToggleButton btn7 = new JToggleButton("7");
    JToggleButton btn8 = new JToggleButton("8");
    JToggleButton btn9 = new JToggleButton("9");
    JToggleButton btn10 = new JToggleButton("10");
    JToggleButton btn11 = new JToggleButton("11");
    JToggleButton btn12 = new JToggleButton("12");
    JToggleButton btn13 = new JToggleButton("13");
    JToggleButton btn14 = new JToggleButton("14");
    JToggleButton btn15 = new JToggleButton("15");
    JToggleButton btn16 = new JToggleButton("16");
    JToggleButton btn17 = new JToggleButton("17");
    JToggleButton btn18 = new JToggleButton("18");
    JToggleButton btn19 = new JToggleButton("19");
    JToggleButton btn20 = new JToggleButton("20");
    JToggleButton btn21 = new JToggleButton("21");
    JToggleButton btn22 = new JToggleButton("22");
    JToggleButton btn23 = new JToggleButton("23");
    JToggleButton btn24 = new JToggleButton("24");
    JToggleButton btn25 = new JToggleButton("25");
    JToggleButton btn26 = new JToggleButton("26");
    JToggleButton btn27 = new JToggleButton("27");
    JToggleButton btn28 = new JToggleButton("28");
    JToggleButton btn29 = new JToggleButton("29");
    JToggleButton btn30 = new JToggleButton("30");
    JToggleButton btn31 = new JToggleButton("31");
    JToggleButton btn32 = new JToggleButton("32");
    JToggleButton btn33 = new JToggleButton("33");
    JToggleButton btn34 = new JToggleButton("34");
    JToggleButton btn35 = new JToggleButton("35");
    JToggleButton btn36 = new JToggleButton("36");
    JToggleButton btn37 = new JToggleButton("37");
    JToggleButton btn38 = new JToggleButton("38");
    JToggleButton btn39 = new JToggleButton("39");
    JToggleButton btn40 = new JToggleButton("40");
    JToggleButton btn41 = new JToggleButton("41");
    JToggleButton btn42 = new JToggleButton("42");
    JToggleButton btn43 = new JToggleButton("43");
    JToggleButton btn44 = new JToggleButton("44");
    JToggleButton btn45 = new JToggleButton("45");
    JToggleButton btn46 = new JToggleButton("46");
    JToggleButton btn47 = new JToggleButton("47");
    JToggleButton btn48 = new JToggleButton("48");
    JToggleButton btn49 = new JToggleButton("49");
    JToggleButton btn50 = new JToggleButton("50");
    JToggleButton btn51 = new JToggleButton("51");
    JToggleButton btn52 = new JToggleButton("52");
    JToggleButton btn53 = new JToggleButton("53");
    JToggleButton btn54 = new JToggleButton("54");
    JToggleButton btn55 = new JToggleButton("55");
    JToggleButton btn56 = new JToggleButton("56");
    JToggleButton btn57 = new JToggleButton("57");
    JToggleButton btn58 = new JToggleButton("58");
    JToggleButton btn59 = new JToggleButton("59");
    JToggleButton btn60 = new JToggleButton("60");
    
    btn1.setBackground(Color.BLUE);
    btn2.setBackground(Color.BLUE);
    btn3.setBackground(Color.BLUE);
    btn4.setBackground(Color.BLUE);
    btn5.setBackground(Color.BLUE);
    btn6.setBackground(Color.BLUE);
    btn7.setBackground(Color.GREEN);
    btn8.setBackground(Color.GREEN);
    btn9.setBackground(Color.GREEN);
    btn10.setBackground(Color.GREEN);
    btn11.setBackground(Color.GREEN);
    btn12.setBackground(Color.GREEN);
    btn13.setBackground(Color.GREEN);
    btn14.setBackground(Color.GREEN);
    btn15.setBackground(Color.GREEN);
    btn16.setBackground(Color.GREEN);
    btn17.setBackground(Color.GREEN);
    btn18.setBackground(Color.GREEN);
    btn19.setBackground(Color.GREEN);
    btn20.setBackground(Color.GREEN);
    btn21.setBackground(Color.GREEN);
    btn22.setBackground(Color.GREEN);
    btn23.setBackground(Color.GREEN);
    btn24.setBackground(Color.GREEN);
    btn25.setBackground(Color.GREEN);
    btn26.setBackground(Color.GREEN);
    btn27.setBackground(Color.GREEN);
    btn28.setBackground(Color.GREEN);
    btn29.setBackground(Color.GREEN);
    btn30.setBackground(Color.GREEN);
    btn31.setBackground(Color.GREEN);
    btn32.setBackground(Color.GREEN);
    btn33.setBackground(Color.GREEN);
    btn34.setBackground(Color.GREEN);
    btn35.setBackground(Color.GREEN);
    btn36.setBackground(Color.GREEN);
    btn37.setBackground(Color.GREEN);
    btn38.setBackground(Color.GREEN);
    btn39.setBackground(Color.GREEN);
    btn40.setBackground(Color.GREEN);
    btn41.setBackground(Color.GREEN);
    btn42.setBackground(Color.GREEN);
    btn43.setBackground(Color.GREEN);
    btn44.setBackground(Color.GREEN);
    btn45.setBackground(Color.GREEN);
    btn46.setBackground(Color.GREEN);
    btn47.setBackground(Color.GREEN);
    btn48.setBackground(Color.GREEN);
    btn49.setBackground(Color.GREEN);
    btn50.setBackground(Color.GREEN);
    btn51.setBackground(Color.GREEN);
    btn52.setBackground(Color.GREEN);
    btn53.setBackground(Color.GREEN);
    btn54.setBackground(Color.GREEN);
    btn55.setBackground(Color.GREEN);
    btn56.setBackground(Color.GREEN);
    btn57.setBackground(Color.GREEN);
    btn58.setBackground(Color.GREEN);
    btn59.setBackground(Color.GREEN);
    btn60.setBackground(Color.GREEN);
    
    p1.add(btn1);
    p1.add(btn2);
    p1.add(btn3);
    p1.add(Box.createRigidArea(new Dimension(100,0)));
    p1.add(btn4);
    p1.add(btn5);
    p1.add(btn6);
    
    p2.add(btn7);
    p2.add(btn8);
    p2.add(btn9);
    p2.add(Box.createRigidArea(new Dimension(100,0)));
    p2.add(btn10);
    p2.add(btn11);
    p2.add(btn12);
    
    p3.add(btn13);
    p3.add(btn14);
    p3.add(btn15);
    p3.add(Box.createRigidArea(new Dimension(100,0)));
    p3.add(btn16);
    p3.add(btn17);
    p3.add(btn18);
    
    p4.add(btn19);
    p4.add(btn20);
    p4.add(btn21);
    p4.add(Box.createRigidArea(new Dimension(100,0)));
    p4.add(btn22);
    p4.add(btn23);
    p4.add(btn24);
    
    p5.add(btn25);
    p5.add(btn26);
    p5.add(btn27);
    p5.add(Box.createRigidArea(new Dimension(100,0)));
    p5.add(btn28);
    p5.add(btn29);
    p5.add(btn30);
    
    p6.add(btn31);
    p6.add(btn32);
    p6.add(btn33);
    p6.add(Box.createRigidArea(new Dimension(100,0)));
    p6.add(btn34);
    p6.add(btn35);
    p6.add(btn36);
    
    p7.add(btn37);
    p7.add(btn38);
    p7.add(btn39);
    p7.add(Box.createRigidArea(new Dimension(100,0)));
    p7.add(btn40);
    p7.add(btn41);
    p7.add(btn42);
    
    p8.add(btn43);
    p8.add(btn44);
    p8.add(btn45);
    p8.add(Box.createRigidArea(new Dimension(100,0)));
    p8.add(btn46);
    p8.add(btn47);
    p8.add(btn48);
   
    p9.add(btn49);
    p9.add(btn50);
    p9.add(btn51);
    p9.add(Box.createRigidArea(new Dimension(100,0)));
    p9.add(btn52);
    p9.add(btn53);
    p9.add(btn54);
    
    p10.add(btn55);
    p10.add(btn56);
    p10.add(btn57);
    p10.add(Box.createRigidArea(new Dimension(100,0)));
    p10.add(btn58);
    p10.add(btn59);
    p10.add(btn60);


    
    p11.add(cancelbutton);
    p11.add(submitbutton);

    
    
    mainframe.add(p1);
    mainframe.add(p2);
    mainframe.add(p3);
    mainframe.add(p4);
    mainframe.add(p5);
    mainframe.add(p6);
    
    mainframe.add(p7);
    mainframe.add(p8);
    mainframe.add(p9);
    mainframe.add(p10);
    mainframe.add(p11);
    
    this.add(mainframe);
    
    
    
    
    btn[0]=btn1;
    btn[1]=btn2;
    btn[2]=btn3;
    btn[3]=btn4;
    btn[4]=btn5;
    btn[5]=btn6;
    btn[6]=btn7;
    btn[7]=btn8;
    btn[8]=btn9;
    btn[9]=btn10;
    btn[10]=btn11;
    btn[11]=btn12;
    btn[12]=btn13;
    btn[13]=btn14;
    btn[14]=btn15;
    btn[15]=btn16;
    btn[16]=btn17;
    btn[17]=btn18;
    btn[18]=btn19;
    btn[19]=btn20;
    btn[20]=btn21;
    btn[21]=btn22;
    btn[22]=btn23;
    btn[23]=btn24;
    btn[24]=btn25;
    btn[25]=btn26;
    btn[26]=btn27;
    btn[27]=btn28;
    btn[28]=btn29;
    btn[29]=btn30;
    btn[30]=btn31;
    btn[31]=btn32;
    btn[32]=btn33;
    btn[33]=btn34;
    btn[34]=btn35;
    btn[35]=btn36;
    btn[36]=btn37;
    btn[37]=btn38;
    btn[38]=btn39;
    btn[39]=btn40;
    btn[40]=btn41;
    btn[41]=btn42;
    btn[42]=btn43;
    btn[43]=btn44;
    btn[44]=btn45;
    btn[45]=btn46;
    btn[46]=btn47;
    btn[47]=btn48;
    btn[48]=btn49;
    btn[49]=btn50;
    btn[50]=btn51;
    btn[51]=btn52;
    btn[52]=btn53;
    btn[53]=btn54;
    btn[54]=btn55;
    btn[55]=btn56;
    btn[56]=btn57;
    btn[57]=btn58;
    btn[58]=btn59;
    btn[59]=btn60;
    
    
    //discount
    discount thisDiscount=new discount(flightNum);
    needsDiscount=thisDiscount.getDiscount();
    System.out.println(needsDiscount);
    //tool tips
    for(int a=0;a<60;a++)
    {
		seatInfo thisSeat=new seatInfo(flightNum,a+1,needsDiscount);
    	btn[a].setToolTipText(thisSeat.getInfo()+thisSeat.getPrice());
    }
    
    //disable seats that are already bought
    getPurchasedSeats thisPlane = new getPurchasedSeats(flightNum);
    int usedSeats[]=thisPlane.allPurchasedSeats();
   
    for(int a : usedSeats)
    {
    	for(int b=0;b<60;b++)
    	{
    		int c=b+1;
    		if(a==c)
    		{
			btn[b].setEnabled(false);
		    btn[b].setBackground(Color.CYAN);
			}
    	}
    }
    


	for(int b=1;b<60;b++)
	{
	   if (btn[b].isSelected()==true)
	   {
		   System.out.println(b+1);
	   }
	}
	

    //the code below listens for when the submit button is clicked
    ActionListener submitlistener = new ActionListener() 
    {
      public void actionPerformed(ActionEvent actionEvent) 
      {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        	int SeatsNums[];
        	double SeatPrices[];
        	String SeatTypes[];
        	int counter=0;
        	for(int b=0;b<60;b++)
	    	{
	    	   if (btn[b].isSelected()==true)
	    	   {
	    		   counter++;
	    	   }
	    	}
        	SeatsNums=new int[counter];
        	SeatPrices=new double[counter];
        	SeatTypes=new String[counter];

        	int index=0;
        	for(int b=0;b<60;b++)
	    	{
	    	   if (btn[b].isSelected()==true)
	    	   {
	    		   SeatsNums[index]=b+1;

	    		   try 
	    		   {
					seatInfo thisSeat=new seatInfo(flightNum,b+1,needsDiscount);
					SeatPrices[index]=thisSeat.getPrice();
					SeatTypes[index]=thisSeat.getType();
	    		   } catch (Exception e) 
	    		   {
					e.printStackTrace();
	    		   }
	    		   index++;
	    	   }
	    	}
        	if(SeatsNums.length==0)
        	{
            	JOptionPane.showMessageDialog(mainframe, "Require at least one seat be selected to move to the check out page.");
        	}
        	else
        	{
            	try {
            		removeExpiredCoupons removeC = new removeExpiredCoupons();
    				CheckoutGUI checkOut=new CheckoutGUI(SeatsNums,SeatPrices,SeatTypes,flightNum,email);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        	}
      }
    };
    submitbutton.addActionListener(submitlistener);
    
	
    //the code below listens for when the submit button is clicked
    ActionListener cancellistener = new ActionListener() 
    {
      public void actionPerformed(ActionEvent actionEvent) 
      {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        dispose();
      }
    };
    cancelbutton.addActionListener(cancellistener);
  }
}