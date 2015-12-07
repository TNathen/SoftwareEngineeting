import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class LoginGUI extends JFrame implements ActionListener
{
    private JLabel l1, l2, l3;
    private JTextField t1;
    private JPasswordField p1;
    private JButton b1, b2, b3, b4;
    String copyEmail[];
    public LoginGUI(String[] TheEmail)
    {
        super("Log In");
        setLayout(null);
        setSize(500, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        copyEmail=TheEmail;
        
        l1 = new JLabel("Log into your account.");
        l2 = new JLabel("E-mail:");
        l3 = new JLabel("Password:");
        t1 = new JTextField();
        p1 = new JPasswordField();
        b1 = new JButton("Login");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");
        b4 = new JButton("Forgot Password");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        
        l1.setBounds(170, 10, 500, 30);
        l2.setBounds(30, 50, 200, 30);
        l3.setBounds(30, 100, 200, 30);
        t1.setBounds(250, 50, 200, 30);
        p1.setBounds(250, 100, 200, 30);
        b1.setBounds(370, 150, 100, 30);
        b2.setBounds(120, 150, 100, 30);
        b3.setBounds(20, 150, 100, 30);
        b4.setBounds(220, 150, 150, 30);
        
        b4.setToolTipText("<html><p>Enter Email then press Forgot Password button</p></html>");

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(p1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String email = t1.getText();
            char[] pw = p1.getPassword();
            String password = String.valueOf(pw);
            
            if("".equals(email))
            {
                JOptionPane.showMessageDialog(this, "Please enter e-mail address");
            } 
            else if("".equals(password))
            {
                JOptionPane.showMessageDialog(this, "Please enter password");
            }
            else
            {
            	try {
					login attemptLogin=new login(email,password);
					if(attemptLogin.loginsuccess()==true)
					{
						if(attemptLogin.isUser()==true)
						{
							System.out.println(email);
							getUserEmail(email);
			                JOptionPane.showMessageDialog(this, "Welcome, "+attemptLogin.getName()+"\nYou have successfully logged in");
						}
						else
						{
							AdminGUI admin=new AdminGUI();	
						}
						dispose();
					}
					else
					{
		                JOptionPane.showMessageDialog(this, "Incorrect e-mail or password");
					}			
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            p1.setText("");
        }
        else if(e.getSource()==b3)
        {
            dispose();
        }
        else if(e.getSource()==b4)
        {
        	//forgot password
            String email = t1.getText();
            if(email.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(this, "Enter an e-mail");
            }
            else
            {
            	try {
            		boolean emailInUserDB = false;

                    Class.forName("org.sqlite.JDBC");
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
                    Statement stat = conn.createStatement();
                    ResultSet rs1 = stat.executeQuery("select * from USERS;");
                    while (rs1.next()) 
                    {
                    	if (rs1.getString("EMAIL").compareToIgnoreCase(email)==0)
                    	{
                    		emailInUserDB = true;
                    	}
                    }
                    rs1.close();
                    if (emailInUserDB == true)
                    {
        				forgotPasswordGUI tryReset=new forgotPasswordGUI(email);
                    }
                    else
                    {
    	                JOptionPane.showMessageDialog(this, "E-mail does not exist in database");
                    }
                    conn.close();
    			} catch (Exception e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            }

        }
    }
    public void getUserEmail(String email)
    {
    	copyEmail[0]=email; 
    }
}