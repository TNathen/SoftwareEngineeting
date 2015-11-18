import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.text.DefaultFormatter;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
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
    
  static String email ="";
    
  public Main_ScreenGUIFrame() {
    super("Main Screen");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600,400);
        
    
    String[] states =  new String[]{"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
	String[] cap = new String[]{"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St. Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"};
	String[] both= new String[51];
	both[0] = "";
	for(int i =1; i <51;i++)
	{
		both[i]=cap[i-1] + ", " + states[i-1];
	}
    

    JTextField area2 = new JTextField();
    JTextField searchtext=new JTextField();
    JPanel mainframe = new JPanel();
    JButton searchbutton=new JButton("Submit");
    JButton registerbutton=new JButton("Register");
    JButton loginbutton=new JButton("Login");
    String[] start = both;
    String[] end = both;
    
    final JComboBox dropdown1 = new JComboBox(start);
    final JComboBox dropdown2 = new JComboBox(end);


    
    searchtext.setAlignmentY(LEFT_ALIGNMENT);
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());
    JPanel p3 = new JPanel(new BorderLayout());
    JPanel p4 = new JPanel(new BorderLayout());
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
    p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
    p1.setBorder(BorderFactory.createTitledBorder("Seach by start location, end location, and/or date"));
    p2.setBorder(BorderFactory.createTitledBorder("SEARCH"));
    p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS)); 
    p3.setBorder(BorderFactory.createTitledBorder("User Account"));
    p3.add(registerbutton);
    p3.add(loginbutton);
    
    
    
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


        if(!date.equals("")) 
        	{
        		System.out.println(start.length());
        		
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
        String last = (new Pull_Flight_Info(vars)).get();
        System.out.println(last);
        try {
        	Flight_SearchGUI flightsearchGUIframe  = new Flight_SearchGUI(last,email);
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
        System.out.println("Register button has been clicked");
		LoginGUI loginAttempt=new LoginGUI();
        email=loginAttempt.getUserEmail();
      }
    };
    loginbutton.addActionListener(loginlistener);


    
    
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

