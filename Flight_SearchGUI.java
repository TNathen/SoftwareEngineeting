import static java.awt.Component.LEFT_ALIGNMENT;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Flight_SearchGUI{

    public static void main(String args[]) throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame flightsearchGUIframe = new Flight_SearchGUIFrame("select FLIGHT_NUM, START_LOC, END_LOC, FLIGHT_TIME from FLIGHTS where Flight_time like \'%20151120%\'limit 100;","");
        flightsearchGUIframe.setVisible(true);
        

    }
    public Flight_SearchGUI(String select,String email)throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame Flight_SearchGUIFrame = new Flight_SearchGUIFrame(select,email);
        Flight_SearchGUIFrame.setVisible(true);
        

    }
}

class Flight_SearchGUIFrame extends JFrame {

	String flight;
    
  public Flight_SearchGUIFrame(String select,final String email) throws Exception {
    super("Flight Search");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(400,600);
    JPanel mainframe = new JPanel();

    JButton searchbutton=new JButton("Submit");
    JButton cancelbutton=new JButton("Cancel");



    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

    p1.setBorder(BorderFactory.createTitledBorder("FLIGHT LISTINGS"));
    
    
    // populate the table below with the hit results from DB!
    
    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
    Statement stat = conn.createStatement();
    ResultSet rs = stat.executeQuery(select);
    //FLIGHT_TIME
    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount-1; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        String x = (String) rs.getObject(columnCount);
        x = x.substring(0, 4) + "-" + x.substring(4, 6) + "-" + x.substring(6, 11)+":"+x.substring(11, 13);
        
        vector.add(x);
        data.add(vector);
    }
    conn.close();
    
    final JTable table = new JTable(data, columnNames);

    JScrollPane scrollable = new JScrollPane(table);
    
    
    scrollable = table.createScrollPaneForTable( table );
    
    p1.add(scrollable);
    p2.add(cancelbutton);
    p2.add(searchbutton);

    mainframe.add(p1);
    mainframe.add(p2);
    
    this.add(mainframe);
    int[] selectedRow = table.getSelectedRows();


    

    //the code below listens for when the submit button is clicked
    ActionListener submitlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        try {
        	Flight_SeatingGUI flightseatingGUI = new Flight_SeatingGUI(flight,email);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("panic");
		}
        
      }
    };
    searchbutton.addActionListener(submitlistener);
    
    ActionListener cancellistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();    
        dispose();
      }
    };
    cancelbutton.addActionListener(cancellistener);
    
    
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            flight = table.getValueAt(table.getSelectedRow(), 0).toString();
            System.out.println(flight);
        }
    });
    
    
    
    
    
    
    
    
  }
}