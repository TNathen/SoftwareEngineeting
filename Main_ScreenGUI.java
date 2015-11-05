import javax.swing.*;
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
    
  
    
  public Main_ScreenGUIFrame() {
    super("Main Screen");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 600);

        


    

    JTextArea area1 = new JTextArea();
    JTextArea area2 = new JTextArea();
    JSpinner myspinner=new JSpinner();
    JPanel mainframe = new JPanel();
    JToggleButton searchbutton=new JToggleButton("Submit");
    JToggleButton registerbutton=new JToggleButton("Login/Register");
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
    p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
    p1.setBorder(BorderFactory.createTitledBorder("FLIGHT LISTINGS"));
    p2.setBorder(BorderFactory.createTitledBorder("SEARCH"));
    p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS)); 
    p3.setBorder(BorderFactory.createTitledBorder("User Account"));
    p3.add(registerbutton);
    p1.add(area1);
    p2.add(myspinner);
    p2.add(searchbutton);
    
    ImageIcon icon = new ImageIcon("map.jpg"); 
    JLabel thumb = new JLabel();
    thumb.setIcon(icon);
    p4.add(thumb);
    
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
        System.out.println("Submit button has been clicked and is: " + selected + "\n");
      }
    };
    searchbutton.addActionListener(submitlistener);
    
    
    //the code below listens for when the register/login button is clicked
    ActionListener registerlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        //System.out.println("Register/login button has been clicked and is: " + selected + "\n");
        SignUp su_gui = new SignUp();
      }
    };
    registerbutton.addActionListener(registerlistener);

    
    
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
        String typeString = null;
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
    area1.getDocument().addDocumentListener(documentListener);
    area2.getDocument().addDocumentListener(documentListener);
  }
}