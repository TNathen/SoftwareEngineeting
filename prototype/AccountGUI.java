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
    
  
    
  public AccountGUIFrame() {
    super("Account Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,300);
    JPanel mainframe = new JPanel();
    
    JButton backbutton=new JButton("Back");


    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();  //table panel
    JPanel p2 = new JPanel();  //back button panel
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

    p1.setBorder(BorderFactory.createTitledBorder("Flight Purchase History"));
    
    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
    Object columnNames[] = { "Column One", "Column Two", "Column Three" };
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    
    p1.add(table);
    p2.add(backbutton);
    
    mainframe.add(p1);
    mainframe.add(p2);
    
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
  }
}