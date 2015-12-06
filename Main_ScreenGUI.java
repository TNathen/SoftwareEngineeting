import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Main_ScreenGUI{
    
    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame mainscreenGUIframe = new Main_ScreenGUIFrame();
        mainscreenGUIframe.setVisible(true);
    }
}

class Main_ScreenGUIFrame extends JFrame {
    
    String email[] = new String[1];
    JPanel mainframe;
    public Main_ScreenGUIFrame() {
        super("Main Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        
        email[0]="";
    
        String[] states = new String[]{"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
        String[] cap = new String[]{"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St. Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"};
        String[] both= new String[51];
        both[0] = "";
        for(int i=1; i<51; i++)
        {
            both[i] = cap[i-1] + ", " + states[i-1];
        }
    
        JTextField area2 = new JTextField();
        JTextField searchtext = new JTextField();
        mainframe = new JPanel();
        JButton searchbutton = new JButton("Submit");
        JButton registerbutton = new JButton("Register");
        JButton loginbutton = new JButton("Login");
        JButton logoutbutton = new JButton("Log out");
        JButton Accountbutton = new JButton("Acccount page");
        String[] start = both;
        String[] end = both;

        final JComboBox<String> dropdown1 = new JComboBox<String>(start);
        final JComboBox<String> dropdown2 = new JComboBox<String>(end);
    
        searchtext.setAlignmentY(LEFT_ALIGNMENT);
    
        mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new BorderLayout());
        JPanel p4 = new JPanel(new BorderLayout());

        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS ));
        p1.setMaximumSize(new Dimension(500,50));
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
        p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS)); 
        p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
        
        p1.setBorder(BorderFactory.createTitledBorder("Seach by start location, end location, and/or date"));
        p2.setBorder(BorderFactory.createTitledBorder("DATE"));
        p3.setBorder(BorderFactory.createTitledBorder("User Account"));
        
        p3.add(registerbutton);
        p3.add(loginbutton);
        p3.add(logoutbutton);
        p3.add(Accountbutton);
    
        //calendar at the end, needs DateLabelFormatter.java
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        
        p2.add(datePicker);

        // USEFUL INFORMATION FOR MICHAEL C.: remember to add ActionListeners for selection menus
        // :D

        // http://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html

        // go there for the action listeners like i suggest,

        // or you can do some fancy Submit button shit like you were talking about to get values of these ComboBoxes @ time of Submit button press, who knows

        p2.add(searchbutton);
        ImageIcon icon = new ImageIcon("map.jpg"); 
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        p4.setMaximumSize(new Dimension(500,300));
        p4.add(thumb);
        p1.add(dropdown1);
        p1.add(dropdown2);
        mainframe.add(p3);
        mainframe.add(p4);
        mainframe.add(p1);
        mainframe.add(p2);

        this.add(mainframe);
    

    //the code below listens for when the submit button is clicked
    ActionListener submitlistener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            String date = datePicker.getJFormattedTextField().getText();
            String start = dropdown1.getSelectedItem().toString();
            String end = dropdown2.getSelectedItem().toString();
            ArrayList<String> vars = new ArrayList<String>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date today = new Date();

        if(!date.equals("")) 
        	{
        		if(Integer.parseInt(dateFormat.format(today)) > Integer.parseInt(date.substring(0, 4)+date.substring(5, 7)+date.substring(8)))
        		{
        			JOptionPane.showMessageDialog(mainframe, "Please pick a future date.");
        			return;
        		}
        		vars.add("FLIGHT_TIME");
        		vars.add(date.substring(0, 4)+date.substring(5, 7)+date.substring(8));
        		
        		
        	}
        if(!start.equals("")) 
    	{
        	System.out.println(start.length());
        	System.out.println(dropdown2.getSelectedItem().toString());
    		vars.add("START_LOC");
    		vars.add(start);
    	}
        if(!end.equals("")) 
    	{
        	System.out.println(end.length());
    		vars.add("END_LOC");
    		vars.add(end);
    	}
        vars.add("panic");
        vars.add("panic2");
        System.out.println(vars);
        String last = (new Pull_Flight_Info(vars, dateFormat.format(today))).get();
        System.out.println(last);
        try {
        	Flight_SearchGUI flightsearchGUIframe  = new Flight_SearchGUI(last,email[0]);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("panic3");
		}
      }
    };
    searchbutton.addActionListener(submitlistener);
    
    
    //the code below listens for when the Register button is clicked
    ActionListener registerlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("Register button has been clicked");
		SignUpGUI signUp=new SignUpGUI();
      }
    };
    registerbutton.addActionListener(registerlistener);
    
    //the code below listens for when the Login button is clicked
    ActionListener loginlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("Login button has been clicked");
		LoginGUI loginAttempt=new LoginGUI(email);
      }
    };
    loginbutton.addActionListener(loginlistener);
    
    ActionListener logoutistener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
          boolean selected = abstractButton.getModel().isSelected();
          System.out.println("Log out button has been clicked");
          if(email[0]!="")
          {
              email[0]="";
              JOptionPane.showMessageDialog(mainframe, "You have been logged out");
          }
          else
          {
              JOptionPane.showMessageDialog(mainframe, "You have not been signed in to be logged out");
          }
        }
      };
      logoutbutton.addActionListener(logoutistener);
      
      ActionListener Accountlistener = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            System.out.println("Account button has been clicked");
    		//kdsklfnlknlnlfd
            if(email[0]!="")
            {
            	AccountGUI account=new AccountGUI(email);
            }
            else
            {
                JOptionPane.showMessageDialog(mainframe, "You are not signed in to view account page");
            }
          }
        };
        Accountbutton.addActionListener(Accountlistener);
    
    DocumentListener documentListener = new DocumentListener() {
        public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
        public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
        public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
        private void printIt(DocumentEvent documentEvent) {
            DocumentEvent.EventType type = documentEvent.getType();
            String typeString = "";
            if (type.equals(DocumentEvent.EventType.CHANGE)) {
                typeString = "(CHANGED KEY) ";
            }  else if (type.equals(DocumentEvent.EventType.INSERT)) {
                typeString = "(PRESSED KEY) ";
            }  else if (type.equals(DocumentEvent.EventType.REMOVE)) {
                typeString = "(DELETED KEY) ";
            }
            System.out.print("Type : " + typeString);
            Document source = documentEvent.getDocument();
            int length = source.getLength();
            System.out.println("Current size: " + length);
            //String contents=source.getText(0, length);
            //System.out.println(contents);
        }
    };
    area2.getDocument().addDocumentListener(documentListener);
    }
}
