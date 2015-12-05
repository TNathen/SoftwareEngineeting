import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class forgotPasswordGUI extends JFrame implements ActionListener
{
    private JLabel l1, l2, l3;
    private final JButton b1, b2, b3;
    private JPasswordField p1;
    String question[]=new String [1];
    String answer[]=new String [1];
    String Email;
    public forgotPasswordGUI(String email) throws Exception
    {
        super("Log In");
        setLayout(null);
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Email=email;
        
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from USERS where email = \""+email+"\";");
        int counter=0;
        while (rs.next()) 
        {
        	question[counter]=rs.getString("SECURITY_QUESTION");
            answer[counter]=rs.getString("ANSWER");
            counter++;
        }
        rs.close();
        conn.close();

        //storeint cell 0 = question    cell 1 = answer
        
        l1 = new JLabel("Reset Password");
        l2 = new JLabel(question[0]);
//replace with security question
        l3 = new JLabel("Answer");
        
        b1 = new JButton("Submit");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");
        
        p1 = new JPasswordField();

        
        l1.setBounds(170, 10, 500, 30);
        l2.setBounds(30, 50, 450, 30);
        l3.setBounds(30, 100, 200, 30);
        p1.setBounds(250, 100, 200, 30);
        b1.setBounds(350, 150, 100, 30);
        b2.setBounds(200, 150, 100, 30);
        b3.setBounds(50, 150, 100, 30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        add(l1);
        add(l2);
        add(l3);
        add(p1);
        add(b1);
        add(b2);
        add(b3);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            char[] pw = p1.getPassword();
            String theAnswer = String.valueOf(pw);
            if(theAnswer.compareTo(answer[0])==0)
            {
            	try {
					passwordReset reset=new passwordReset(Email);
					String newPass=reset.getNewPass();
					String phrase="Password has been reset\n"+newPass+" is your new password";
	                JOptionPane.showMessageDialog(this, phrase);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            else if (theAnswer.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(this, "Please enter the answer");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Incorrect answer\nPlease try again");
            }
        }
        if(e.getSource()==b2)
        {
            p1.setText("");
        }
        if(e.getSource()==b3)
        {
        	dispose();
        }
    }
    public static void main(String[] args)
    {
    	try {
			forgotPasswordGUI test = new forgotPasswordGUI("u@ser.mail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   
}
