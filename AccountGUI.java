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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JTable;


public class AccountGUI{
    
    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame accountGUIframe = new AccountGUIFrame();
        accountGUIframe.setVisible(true);
    }
}

class AccountGUIFrame extends JFrame {
    
	JTable table;
    
  public AccountGUIFrame() {
    super("Account Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,300);
    JPanel mainframe = new JPanel();
    
    JButton backbutton=new JButton("Back");
    JButton editAccount=new JButton("Edit Account Info");
    
    String email="u@ser.mail";
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();  //table panel
    JPanel p2 = new JPanel(); 
    JPanel p3 = new JPanel(); //back button panel
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS)); 
    p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));

    p1.setBorder(BorderFactory.createTitledBorder("Flight Purchase History"));
    p2.setBorder(BorderFactory.createTitledBorder("Coupons"));

    viewTickets thisUser=new viewTickets();
    Object rowData[][] = null;
	try {
		rowData = thisUser.makeArray(email);
	} catch (Exception e) {
		e.printStackTrace();
	}
    Object columnNames[] = {"FLIGHT_NUM" ,"PLANE_TYPE" ,"TICKET_NUMBER" ,"TICKET_VALUE" ,"CREDIT_CARD" ,"ADDRESS" ,"DATE_PURCHASED" ,"FOOD" ,"BAGGAGE_NUM" ,"HANDICAP"};
    table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    
    
    viewCoupon thisUserC=new viewCoupon();
    Object rowData2[][] = null;
	try {
		rowData2 = thisUserC.makeArray(email);
	} catch (Exception e) {
		e.printStackTrace();
	}
    Object columnNames2[] = {"CODE","Expiration date" ,"Percent Off"};
    table = new JTable(rowData2, columnNames2);
    JScrollPane scrollPane2 = new JScrollPane(table);
    
    p1.add(scrollPane);
    p2.add(scrollPane2);
    p3.add(backbutton);
    p3.add(editAccount);
    
    mainframe.add(p1);
    mainframe.add(p2);
    mainframe.add(p3);

    this.add(mainframe);
    


    

    //the code below listens for when the submit button is clicked
    ActionListener backlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("Back button has been clicked");
      }
    };
    backbutton.addActionListener(backlistener);
    
    ActionListener editlistener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
          boolean selected = abstractButton.getModel().isSelected();
          System.out.println("edit button has been clicked");
        }
      };
      editAccount.addActionListener(editlistener);
  }
}