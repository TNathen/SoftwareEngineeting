import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class LoginGUI extends JFrame implements ActionListener
{
    private JLabel l1, l2, l3;
    private JTextField t1;
    private JPasswordField p1;
    private JButton b1, b2, b3;
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

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        l1.setBounds(170, 10, 500, 30);
        l2.setBounds(30, 50, 200, 30);
        l3.setBounds(30, 100, 200, 30);
        t1.setBounds(250, 50, 200, 30);
        p1.setBounds(250, 100, 200, 30);
        b1.setBounds(40, 150, 100, 30);
        b2.setBounds(190, 150, 100, 30);
        b3.setBounds(340, 150, 100, 30);
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(p1);
        add(b1);
        add(b2);
        add(b3);

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
		                JOptionPane.showMessageDialog(this, "Incorrect email or password");
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
    }
    public void getUserEmail(String email)
    {
    	copyEmail[0]=email; 
    }
}