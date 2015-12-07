import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTable;


public class AccountGUI{
    
    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        String email[]={"u@ser.mail"};
        JFrame accountGUIframe = new AccountGUIFrame(email);
        accountGUIframe.setVisible(true);
    }
    public AccountGUI(String email[])
    {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame accountGUIframe = new AccountGUIFrame(email);
        accountGUIframe.setVisible(true);
    }
}

class AccountGUIFrame extends JFrame {
    
	JTable table;
    String Email[];;

  public AccountGUIFrame(String email[]) {
    super("Account Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500,500);
    setResizable(false);
    setLocationRelativeTo(null);
    JPanel mainframe = new JPanel();
    
    JButton backbutton=new JButton("Back");
    JButton editAccount=new JButton("Edit Account Info");
    
    Email=email;
    
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
		rowData = thisUser.makeArray(Email[0]);
	} catch (Exception e) {
		e.printStackTrace();
	}
    Object columnNames[] = {"FLIGHT_NUM" ,"PLANE_TYPE" ,"TICKET_NUMBER" ,"TICKET_VALUE" ,"CREDIT_CARD" ,"ADDRESS" ,"DATE_PURCHASED" ,"HANDICAP","Start Location","End Location","Departure Time"};
    table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    
    
    viewCoupon thisUserC=new viewCoupon();
    Object rowData2[][] = null;
	try {
		rowData2 = thisUserC.makeArray(Email[0]);
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
        dispose();
      }
    };
    backbutton.addActionListener(backlistener);
    
    ActionListener editlistener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
          boolean selected = abstractButton.getModel().isSelected();
          System.out.println("edit button has been clicked");
          try {
			editUserGUI edit=new editUserGUI(Email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
      };
      editAccount.addActionListener(editlistener);
  }
}