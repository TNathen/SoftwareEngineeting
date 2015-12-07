
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class AdminGUI{
    
    public AdminGUI(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame adminGUIframe = new AdminGUIFrame();
        adminGUIframe.setVisible(true);
        

    }
}


class AdminGUIFrame extends JFrame {
    
	JTable table;
	Vector<Vector<Object>> rowData;
    String PLANE_ID="";
    String FLIGHT_NUM="";
    String START_LOC="";
    String END_LOC ="";
    String BASE_PRICE = "";
    String PLANE_TYPE="";
    String FLIGHT_TIME="";
    JScrollPane scrollable;
    JPanel mainframe;
    JTextField Tplane, TflightNum;
    JComboBox<String> dropdown1, dropdown2;
    JDatePickerImpl datePicker;
  public AdminGUIFrame() {
    super("Admin Menu");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500,500);
    setResizable(false);
    setLocationRelativeTo(null);
    mainframe = new JPanel();
    
    JButton addflightbutton=new JButton("Add Flight");
    JButton editflightbutton=new JButton("Edit Flight");
    JButton deleteflightbutton=new JButton("Delete Flight");
    JButton addAdminbutton=new JButton("Add Admin");
    JButton donebutton=new JButton("Done");
    
    //filter parts
    JLabel Lplane, LflightNum, Lstart_loc, Lend_loc, Ldate;

    
    String[] states = new String[]{"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
    String[] cap = new String[]{"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St. Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"};
    String[] both= new String[51];
    both[0] = "";
    for(int i=1; i<51; i++)
    {
        both[i] = cap[i-1] + ", " + states[i-1];
    }
    JButton filterButton = new JButton("Filter");

    
    
    
    
    
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel(); //table displaying flights
    JPanel p2 = new JPanel(); //buttons to edit table, etc
    JPanel p3 = new JPanel(); //filters
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
    p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS ));
    
    p1.setBorder(BorderFactory.createTitledBorder("Flights"));
    viewAllFlight allF=new viewAllFlight();


    rowData = new Vector<Vector<Object>>();
	try {
		rowData = allF.AllTheFlight();
	} catch (Exception e) {
		e.printStackTrace();
	}
    
	Vector<String> columnNames = new Vector<String>();
	columnNames.add("PLANE_ID");
	columnNames.add("FLIGHT_NUM");
	columnNames.add("START_LOC");
	columnNames.add("END_LOC");
	columnNames.add("BASE_PRICE");
	columnNames.add("PLANE_TYPE");
	columnNames.add("FLIGHT_TIME");
	
	DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames){

	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	
    table = new JTable(dtm);
    
    
    scrollable = new JScrollPane(table);
    
    
    p1.add(scrollable);
    
    p2.add(addflightbutton);
    p2.add(editflightbutton);
    p2.add(deleteflightbutton);
    p2.add(addAdminbutton);
    p2.add(donebutton);
    
    
    dropdown1 = new JComboBox<String>(both);
    dropdown2 = new JComboBox<String>(both);
    Lplane = new JLabel("by Plane ID", SwingConstants.LEFT);
    LflightNum = new JLabel("by Flight Number");
    Lstart_loc = new JLabel("by Starting Location");
    Lend_loc = new JLabel("by Destination");
    Ldate = new JLabel("by Date");
    Tplane = new JTextField();
    TflightNum = new JTextField();
    
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    
    Tplane.setMaximumSize(new Dimension(100, 30));
    TflightNum.setMaximumSize(new Dimension(100, 30));
    dropdown1.setMaximumSize(new Dimension(200, 30));
    dropdown2.setMaximumSize(new Dimension(200, 30));
    datePicker.setMaximumSize(new Dimension(150, 30));
    
    
    
    p3.setBorder(BorderFactory.createTitledBorder("Filter"));
    p3.add(Lplane);
    p3.add(Tplane);
    p3.add(LflightNum);
    p3.add(TflightNum);
    p3.add(Lstart_loc);
    p3.add(dropdown1);
    p3.add(Lend_loc);
    p3.add(dropdown2);
    p3.add(Ldate);
    p3.add(datePicker);
    p3.add(filterButton);
    
    
    
    mainframe.add(p1);
    mainframe.add(p2);
    mainframe.add(p3);
    
    this.add(mainframe);
    

    //the code below listens for when the DELETE button is clicked
    ActionListener deletelistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("DELETE button has been clicked");
        deleteFlightGUI deleteF=new deleteFlightGUI(FLIGHT_NUM, rowData, table.getSelectedRow(), scrollable);
      }
    };
    deleteflightbutton.addActionListener(deletelistener);
    
    //the code below listens for when the EDIT button is clicked
    ActionListener editlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("EDIT button has been clicked");
        editFlightGUI editF=new editFlightGUI(PLANE_ID,FLIGHT_NUM,START_LOC,END_LOC,BASE_PRICE,PLANE_TYPE, FLIGHT_TIME, rowData, table.getSelectedRow(), scrollable);
      }
    };
    editflightbutton.addActionListener(editlistener);
    
    //the code below listens for when the ADD FLIGHT button is clicked
    ActionListener addlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("ADD FLIGHT button has been clicked");
        AddFlightGUI addF=new AddFlightGUI(rowData, table.getSelectedRow(), scrollable);
      }
    };
    addflightbutton.addActionListener(addlistener);
    
    ActionListener addAlistener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
          boolean selected = abstractButton.getModel().isSelected();
          System.out.println("DONE button has been clicked");
          addAdminGUI addA=new addAdminGUI();
        }
      };
      addAdminbutton.addActionListener(addAlistener);
    
    //the code below listens for when the DONE button is clicked
    ActionListener donelistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("DONE button has been clicked");
        dispose();
      }
    };
    donebutton.addActionListener(donelistener);
    
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
        	int row = table.getSelectedRow();
        	if(row ==  -1){}
        	else 
        	{
        		FLIGHT_NUM = table.getValueAt(table.getSelectedRow(), 1).toString();
        		PLANE_ID=table.getValueAt(table.getSelectedRow(), 0).toString();
        		START_LOC=table.getValueAt(table.getSelectedRow(), 2).toString();
        		END_LOC =table.getValueAt(table.getSelectedRow(), 3).toString();
        		BASE_PRICE = table.getValueAt(table.getSelectedRow(), 4).toString();
        		PLANE_TYPE=table.getValueAt(table.getSelectedRow(), 5).toString();
        		FLIGHT_TIME=table.getValueAt(table.getSelectedRow(), 6).toString();
        	}
            System.out.println(FLIGHT_NUM);
        }
    });
    
  //the code below listens for when the submit button is clicked
    ActionListener filterlistener = new ActionListener() {
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
        			JOptionPane.showMessageDialog(mainframe, "Date incorrect");
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
        if(!Tplane.getText().trim().equals("")) 
    	{
    		vars.add("PLANE_ID");
    		vars.add(Tplane.getText());
    	}
        if(!TflightNum.getText().trim().equals("")) 
    	{
    		vars.add("FLIGHT_NUM");
    		vars.add(TflightNum.getText());
    	}
        vars.add("panic");
        vars.add("panic2");
        System.out.println(vars);
        String last = (new Pull_Flight_Info(vars)).get();
        System.out.println(last);
        


    	try {
    		rowData.removeAllElements();
    		rowData.addAll(new viewAllFlight().AllTheFlight(last));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	table.clearSelection();
    	scrollable.repaint();
    	
      }
    };
    filterButton.addActionListener(filterlistener);
    
    
    
  }
  
}