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


public class Flight_SearchGUI{

    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        JFrame flightsearchGUIframe = new Flight_SearchGUIFrame();
        flightsearchGUIframe.setVisible(true);
        

    }
}

class Flight_SearchGUIFrame extends JFrame {

  
    
  public Flight_SearchGUIFrame() {
    super("Flight Search");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
    Object columnNames[] = { "Column One", "Column Two", "Column Three" };
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);


    JScrollPane scrollable = new JScrollPane(table);
    
    
    scrollable = table.createScrollPaneForTable( table );
    
    p1.add(scrollable);
    p2.add(cancelbutton);
    p2.add(searchbutton);

    mainframe.add(p1);
    mainframe.add(p2);
    
    this.add(mainframe);
    


    

    //the code below listens for when the submit button is clicked
    ActionListener submitlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("Submit button has been clicked");
      }
    };
    searchbutton.addActionListener(submitlistener);
    
    ActionListener cancellistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        System.out.println("Cancel button has been clicked");
      }
    };
    cancelbutton.addActionListener(cancellistener);
  }
}