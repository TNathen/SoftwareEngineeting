import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Flight_SeatingGUI4 {
    public Flight_SeatingGUI4(String flightNum, String email) throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame flightseatingGUIframe = new Flight_SeatingGUI4Frame(flightNum,email);
        flightseatingGUIframe.setVisible(true);
    }
}

class Flight_SeatingGUI4Frame extends JFrame 
{
    static JToggleButton btn[]=new JToggleButton[90];
    boolean needsDiscount;
    public Flight_SeatingGUI4Frame(final String flightNum, final String email) throws Exception
    {
    super("Flight Seating Assignment");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(600,500);
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
    JPanel p12 = new JPanel();
    JPanel p13 = new JPanel();
    
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
    p11.setLayout(new BoxLayout(p11, BoxLayout.X_AXIS));
    p12.setLayout(new BoxLayout(p12, BoxLayout.X_AXIS));
    p13.setLayout(new BoxLayout(p13, BoxLayout.X_AXIS));
    
    JToggleButton btn1 = new JToggleButton(" 1 ");
    JToggleButton btn2 = new JToggleButton(" 2 ");
    JToggleButton btn3 = new JToggleButton(" 3 ");
    JToggleButton btn4 = new JToggleButton(" 4 ");
    JToggleButton btn5 = new JToggleButton(" 5 ");
    JToggleButton btn6 = new JToggleButton(" 6 ");
    JToggleButton btn7 = new JToggleButton(" 7 ");
    JToggleButton btn8 = new JToggleButton(" 8 ");
    JToggleButton btn9 = new JToggleButton(" 9 ");
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
    JToggleButton btn61 = new JToggleButton("61");
    JToggleButton btn62 = new JToggleButton("62");
    JToggleButton btn63 = new JToggleButton("63");
    JToggleButton btn64 = new JToggleButton("64");
    JToggleButton btn65 = new JToggleButton("65");
    JToggleButton btn66 = new JToggleButton("66");
    JToggleButton btn67 = new JToggleButton("67");
    JToggleButton btn68 = new JToggleButton("68");
    JToggleButton btn69 = new JToggleButton("69");
    JToggleButton btn70 = new JToggleButton("70");
    JToggleButton btn71 = new JToggleButton("71");
    JToggleButton btn72 = new JToggleButton("72");
    JToggleButton btn73 = new JToggleButton("73");
    JToggleButton btn74 = new JToggleButton("74");
    JToggleButton btn75 = new JToggleButton("75");
    JToggleButton btn76 = new JToggleButton("76");
    JToggleButton btn77 = new JToggleButton("77");
    JToggleButton btn78 = new JToggleButton("78");
    JToggleButton btn79 = new JToggleButton("79");
    JToggleButton btn80 = new JToggleButton("80");
    JToggleButton btn81 = new JToggleButton("81");
    JToggleButton btn82 = new JToggleButton("82");
    JToggleButton btn83 = new JToggleButton("83");
    JToggleButton btn84 = new JToggleButton("84");
    JToggleButton btn85 = new JToggleButton("85");
    JToggleButton btn86 = new JToggleButton("86");
    JToggleButton btn87 = new JToggleButton("87");
    JToggleButton btn88 = new JToggleButton("88");
    JToggleButton btn89 = new JToggleButton("89");
    JToggleButton btn90 = new JToggleButton("90");

    btn1.setBackground(Color.BLUE);
    btn2.setBackground(Color.BLUE);
    btn3.setBackground(Color.BLUE);
    btn4.setBackground(Color.BLUE);
    btn5.setBackground(Color.BLUE);
    btn6.setBackground(Color.BLUE);
    btn7.setBackground(Color.BLUE);
    btn8.setBackground(Color.BLUE);
    btn9.setBackground(Color.BLUE);
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
    btn61.setBackground(Color.GREEN);
    btn62.setBackground(Color.GREEN);
    btn63.setBackground(Color.GREEN);
    btn64.setBackground(Color.GREEN);
    btn65.setBackground(Color.GREEN);
    btn66.setBackground(Color.GREEN);
    btn67.setBackground(Color.GREEN);
    btn68.setBackground(Color.GREEN);
    btn69.setBackground(Color.GREEN);
    btn70.setBackground(Color.GREEN);
    btn71.setBackground(Color.GREEN);
    btn72.setBackground(Color.GREEN);
    btn73.setBackground(Color.GREEN);
    btn74.setBackground(Color.GREEN);
    btn75.setBackground(Color.GREEN);
    btn76.setBackground(Color.GREEN);
    btn77.setBackground(Color.GREEN);
    btn78.setBackground(Color.GREEN);
    btn79.setBackground(Color.GREEN);
    btn80.setBackground(Color.GREEN);
    btn81.setBackground(Color.GREEN);
    btn82.setBackground(Color.GREEN);
    btn83.setBackground(Color.GREEN);
    btn84.setBackground(Color.GREEN);
    btn85.setBackground(Color.GREEN);
    btn86.setBackground(Color.GREEN);
    btn87.setBackground(Color.GREEN);
    btn88.setBackground(Color.GREEN);
    btn89.setBackground(Color.GREEN);
    btn90.setBackground(Color.GREEN);

    p1.add(Box.createRigidArea(new Dimension(0,50)));
    
    p2.add(btn1);
    p2.add(btn2);
    p2.add(btn3);
    p2.add(Box.createRigidArea(new Dimension(50,0)));
    p2.add(btn4);
    p2.add(btn5);
    p2.add(btn6);
    p2.add(Box.createRigidArea(new Dimension(50,0)));
    p2.add(btn7);
    p2.add(btn8);
    p2.add(btn9);
    
    p3.add(btn10);
    p3.add(btn11);
    p3.add(btn12);
    p3.add(Box.createRigidArea(new Dimension(50,0)));
    p3.add(btn13);
    p3.add(btn14);
    p3.add(btn15);
    p3.add(Box.createRigidArea(new Dimension(50,0)));
    p3.add(btn16);
    p3.add(btn17);
    p3.add(btn18);
    
    p4.add(btn19);
    p4.add(btn20);
    p4.add(btn21);
    p4.add(Box.createRigidArea(new Dimension(50,0)));
    p4.add(btn22);
    p4.add(btn23);
    p4.add(btn24);
    p4.add(Box.createRigidArea(new Dimension(50,0)));
    p4.add(btn25);
    p4.add(btn26);
    p4.add(btn27);
    
    p5.add(btn28);
    p5.add(btn29);
    p5.add(btn30);
    p5.add(Box.createRigidArea(new Dimension(50,0)));
    p5.add(btn31);
    p5.add(btn32);
    p5.add(btn33);
    p5.add(Box.createRigidArea(new Dimension(50,0)));
    p5.add(btn34);
    p5.add(btn35);
    p5.add(btn36);
    
    p6.add(btn37);
    p6.add(btn38);
    p6.add(btn39);
    p6.add(Box.createRigidArea(new Dimension(50,0)));
    p6.add(btn40);
    p6.add(btn41);
    p6.add(btn42);
    p6.add(Box.createRigidArea(new Dimension(50,0)));
    p6.add(btn43);
    p6.add(btn44);
    p6.add(btn45);
   
    p7.add(btn46);
    p7.add(btn47);
    p7.add(btn48);
    p7.add(Box.createRigidArea(new Dimension(50,0)));
    p7.add(btn49);
    p7.add(btn50);
    p7.add(btn51);
    p7.add(Box.createRigidArea(new Dimension(50,0)));
    p7.add(btn52);
    p7.add(btn53);
    p7.add(btn54);
    
    p8.add(btn55);
    p8.add(btn56);
    p8.add(btn57);
    p8.add(Box.createRigidArea(new Dimension(50,0)));
    p8.add(btn58);
    p8.add(btn59);
    p8.add(btn60);
    p8.add(Box.createRigidArea(new Dimension(50,0)));
    p8.add(btn61);
    p8.add(btn62);
    p8.add(btn63);
    
    p9.add(btn64);
    p9.add(btn65);
    p9.add(btn66);
    p9.add(Box.createRigidArea(new Dimension(50,0)));
    p9.add(btn67);
    p9.add(btn68);
    p9.add(btn69);
    p9.add(Box.createRigidArea(new Dimension(50,0)));
    p9.add(btn70);
    p9.add(btn71);
    p9.add(btn72);
    
    p10.add(btn73);
    p10.add(btn74);
    p10.add(btn75);
    p10.add(Box.createRigidArea(new Dimension(50,0)));
    p10.add(btn76);
    p10.add(btn77);
    p10.add(btn78);
    p10.add(Box.createRigidArea(new Dimension(50,0)));
    p10.add(btn79);
    p10.add(btn80);
    p10.add(btn81);
    
    p11.add(btn82);
    p11.add(btn83);
    p11.add(btn84);
    p11.add(Box.createRigidArea(new Dimension(50,0)));
    p11.add(btn85);
    p11.add(btn86);
    p11.add(btn87);
    p11.add(Box.createRigidArea(new Dimension(50,0)));
    p11.add(btn88);
    p11.add(btn89);
    p11.add(btn90);
    
    p12.add(Box.createRigidArea(new Dimension(0,50)));
     
    p13.add(cancelbutton);
    p13.add(Box.createRigidArea(new Dimension(50,0)));
    p13.add(submitbutton);
    
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
    mainframe.add(p11);
    mainframe.add(p12);
    mainframe.add(p13);
    
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
    btn[60]=btn61;
    btn[61]=btn62;
    btn[62]=btn63;
    btn[63]=btn64;
    btn[64]=btn65;
    btn[65]=btn66;
    btn[66]=btn67;
    btn[67]=btn68;
    btn[68]=btn69;
    btn[69]=btn70;
    btn[70]=btn71;
    btn[71]=btn72;
    btn[72]=btn73;
    btn[73]=btn74;
    btn[74]=btn75;
    btn[75]=btn76;
    btn[76]=btn77;
    btn[77]=btn78;
    btn[78]=btn79;
    btn[79]=btn80;
    btn[80]=btn81;
    btn[81]=btn82;
    btn[82]=btn83;
    btn[83]=btn84;
    btn[84]=btn85;
    btn[85]=btn86;
    btn[86]=btn87;
    btn[87]=btn88;
    btn[88]=btn89;
    btn[89]=btn90;

    //discount
    discount thisDiscount=new discount(flightNum);
    needsDiscount=thisDiscount.getDiscount();
    System.out.println(needsDiscount);
    //tool tips
    for(int a=0;a<90;a++)
    {
		seatInfo thisSeat=new seatInfo(flightNum,a+1,needsDiscount);
    	btn[a].setToolTipText(thisSeat.getInfo()+thisSeat.getPrice());
    }
    
    //disable seats that are already bought
    getPurchasedSeats thisPlane = new getPurchasedSeats(flightNum);
    int usedSeats[]=thisPlane.allPurchasedSeats();
   
    for(int a : usedSeats)
    {
    	for(int b=0;b<90;b++)
    	{
    		int c=b+1;
    		if(a==c)
    		{
			btn[b].setEnabled(false);
		    btn[b].setBackground(Color.CYAN);
			}
    	}
    }
    


	for(int b=1;b<90;b++)
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
        	for(int b=0;b<90;b++)
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
        	for(int b=0;b<90;b++)
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