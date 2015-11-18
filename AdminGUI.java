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
    
  
    
  public AdminGUIFrame() {
    super("Admin Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,500);
    JPanel mainframe = new JPanel();
    
    JButton addflightbutton=new JButton("Add Flight");
    JButton editflightbutton=new JButton("Edit Flight");
    JButton deleteflightbutton=new JButton("Delete Flight");
    JButton donebutton=new JButton("Done");
    
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel(); //table displaying flights
    JPanel p2 = new JPanel(); //buttons to edit table, etc
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

    p1.setBorder(BorderFactory.createTitledBorder("Flights"));
    viewAllFlight allF=new viewAllFlight();


    Object rowData[][] = null;
	try {
		rowData = allF.AllTheFlight();
	} catch (Exception e) {
		e.printStackTrace();
	}
    boolean AllFComplete=allF.finish();
    System.out.println(AllFComplete);
    
    Object columnNames[] = { "PLANE_ID", "FLIGHT_NUM", "START_LOC" ,"END_LOC","BASE_PRICE","PLANE_TYPE","FLIGHT_TIME"};
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollable = new JScrollPane(table);
    
    
    scrollable = table.createScrollPaneForTable( table );
    p1.add(scrollable);
    
    p2.add(addflightbutton);
    p2.add(editflightbutton);
    p2.add(deleteflightbutton);
    p2.add(donebutton);
    
    mainframe.add(p1);
    mainframe.add(p2);
    
    this.add(mainframe);
    

    //the code below listens for when the DELETE button is clicked
    ActionListener deletelistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("DELETE button has been clicked");
        deleteFlightGUI deleteF=new deleteFlightGUI();
      }
    };
    deleteflightbutton.addActionListener(deletelistener);
    
    //the code below listens for when the EDIT button is clicked
    ActionListener editlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("EDIT button has been clicked");
        editFlightGUI editF=new editFlightGUI();
      }
    };
    editflightbutton.addActionListener(editlistener);
    
    //the code below listens for when the ADD FLIGHT button is clicked
    ActionListener addlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("ADD FLIGHT button has been clicked");
        AddFlightGUI addF=new AddFlightGUI();
      }
    };
    addflightbutton.addActionListener(addlistener);
    
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
  }
}