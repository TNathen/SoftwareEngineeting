import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

import javax.swing.*;


public class addAdminGUI extends JFrame implements ActionListener
{
	private final JLabel l1, l2, l3, l4;
	private final JTextField t1;
	private final JPasswordField p1, p2;
    private final JButton b1, b2, b3;

    private final String validEmail = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\."
            + "[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private final String validPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
	
	public addAdminGUI()
	{
        super("Sign-Up Form");
        setLayout(null);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l1 = new JLabel("Enter the following information to Add Admin!");
        l2 = new JLabel("Email:");
        l3 = new JLabel("Password:");
        l4 = new JLabel("Confirm password:");
        
        t1 = new JTextField();
        
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        
        b1 = new JButton("Sign Up");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");

        l3.setToolTipText("<html><p>Password must include at least:</p>"
                + "<p>one digit from 0-9</p>"
                + "<p>one lowercase character</p>"
                + "<p>one uppercase character</p>"
                + "<p>length of 6-20 characters</p></html>");
        
        l4.setToolTipText("<html><p>Password must include at least:</p>"
                + "<p>one digit from 0-9</p>"
                + "<p>one lowercase character</p>"
                + "<p>one uppercase character</p>"
                + "<p>length of 6-20 characters</p></html>");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        l1.setBounds(120, 10, 500, 30);
        l2.setBounds(30, 50, 200, 30);
        l3.setBounds(30, 100, 200, 30);
        l4.setBounds(30, 150, 200, 30);
        
        t1.setBounds(250, 50, 200, 30);
        
        p1.setBounds(250, 100, 200, 30);
        p2.setBounds(250, 150, 200, 30);
        
        b1.setBounds(340, 400, 100, 30);
        b2.setBounds(190, 400, 100, 30);
        b3.setBounds(40, 400, 100, 30);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(p1);
        add(p2);
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
            char[] pw1 = p1.getPassword();
            char[] pw2 = p2.getPassword();
            String password1 = String.valueOf(pw1);
            String password2 = String.valueOf(pw2);

            Pattern emailPattern = Pattern.compile(validEmail);
            Matcher emailMatcher = emailPattern.matcher(email);
            if("".equals(email))
            {
            	JOptionPane.showMessageDialog(this, "Please enter e-mail");
            }
            else if(emailMatcher.matches())
            {
            	Pattern passwordPattern = Pattern.compile(validPassword);
            	Matcher passwordMatcher = passwordPattern.matcher(password1);
            	if("".equals(password1))
            	{
            		JOptionPane.showMessageDialog(this, "Please enter password");
            	}
                else if(passwordMatcher.matches())
                {
                	Matcher passwordMatcher2 = passwordPattern.matcher(password2);
                    if("".equals(password2))
                    {
                    	JOptionPane.showMessageDialog(this, "Please enter password");
                    }
                    else if(passwordMatcher2.matches())
                    {
                    	if(password1.equals(password2))
                        {
                    		try {
								System.out.println(email);
								addAdmin thisPerson=new addAdmin(email,password1);
								System.out.println(thisPerson.isSuccessful());
								if(thisPerson.isSuccessful()==true)
								{
                                    JOptionPane.showMessageDialog(this, "New admin has been created");
                                    dispose();
								}
								else
								{
                                    JOptionPane.showMessageDialog(this, "Email is already in the database.");
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}															
                        }
                    	else
                    	{
                    		JOptionPane.showMessageDialog(this, "Passwords do not match");
                    		p1.setText("");
                    		p2.setText("");
                    	}
                    }
                    else
                    {
                    	JOptionPane.showMessageDialog(this, "Invalid password");
                    	p2.setText("");
                    }
                 }
                 else
                 {
                	 JOptionPane.showMessageDialog(this, "Invalid password");
                	 p1.setText("");
                 }
            }
            else
            {
            	JOptionPane.showMessageDialog(this, "Invalid e-mail");
                t1.setText("");
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            p1.setText("");
            p2.setText("");
        }
        else if(e.getSource()==b3)
        {
            dispose();
        }
    }
    public static void main(String[] args)
    {
    	addAdminGUI addNewAdmin = new addAdminGUI();
    }   
}
