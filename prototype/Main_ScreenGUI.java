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
    
  static String email="";
    
  public Main_ScreenGUIFrame() {
    super("Main Screen");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,400);
        


    

    JTextField area2 = new JTextField();
    JTextField searchtext=new JTextField();
    JPanel mainframe = new JPanel();
    JButton searchbutton=new JButton("Submit");
    JButton registerbutton=new JButton("Register");
    JButton loginbutton=new JButton("Login");
    String[] whatsupmichaelchangethisdog = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    String[] whatsupmichaelchangethisdog2 = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    String[] whatsupmichaelchangethisdog3 = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    
    JComboBox dropdown1 = new JComboBox(whatsupmichaelchangethisdog);
    JComboBox dropdown2 = new JComboBox(whatsupmichaelchangethisdog);
    JComboBox dropdown3 = new JComboBox(whatsupmichaelchangethisdog);

    
    searchtext.setAlignmentY(LEFT_ALIGNMENT);
    
    mainframe.setLayout(new BoxLayout(mainframe, BoxLayout.Y_AXIS));
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS)); 
    p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
    p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
    p1.setBorder(BorderFactory.createTitledBorder("DROPDOWN MENUS RE-NAME THIS PLZ"));
    p2.setBorder(BorderFactory.createTitledBorder("SEARCH"));
    p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS)); 
    p3.setBorder(BorderFactory.createTitledBorder("User Account"));
    p3.add(registerbutton);
    p3.add(loginbutton);
    p2.add(searchtext);
    
    
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
    p1.add(dropdown3);
    
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
        System.out.println("Submit button has been clicked");
      }
    };
    searchbutton.addActionListener(submitlistener);
    
    
    //the code below listens for when the Register button is clicked
    ActionListener registerlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        SignUpGUI signUp=new SignUpGUI();
      }
    };
    registerbutton.addActionListener(registerlistener);
    
    
    //the code below listens for when the Login button is clicked
    ActionListener loginlistener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        boolean selected = abstractButton.getModel().isSelected();
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
    area2.getDocument().addDocumentListener(documentListener);
  }
}