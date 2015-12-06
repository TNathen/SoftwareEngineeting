import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class editUserGUI extends JFrame implements ActionListener
{
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private JTextField t1, t2, t3, t4, t5, t6;
    private JPasswordField p1, p2, p3;
    private JButton b1, b2, b3;
    private String validName = "[a-zA-Z]+";
    private String validDOB = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
    private String validEmail = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\."
            + "[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String validPhone = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})"
            + "[-.\\s]?([0-9]{4})$";
    private final String validPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
    String[] email;
    public editUserGUI(String[] TheEmail) throws Exception
    {
        super("Edit Account");
        setLayout(null);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l1 = new JLabel("Enter the following information to edit account");
        l2 = new JLabel("First name:");
        l3 = new JLabel("Last name:");
        l4 = new JLabel("Date of Birth:");
        l5 = new JLabel("E-mail:");
        l6 = new JLabel("Phone Number:");
        l7 = new JLabel("Password:");
        l8 = new JLabel("Confirm Password:");
        l9 = new JLabel("Security Question:");
        l10 = new JLabel("Security Answer:");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        p1 = new JPasswordField();
        p2 = new JPasswordField();
        p3 = new JPasswordField();

        
        b1 = new JButton("Edit");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");
        
        email=TheEmail;
        
        l4.setToolTipText("<html><p>Use the following format:</p>"
                + "<p>mm/dd/yyyy</p></html>");
        
        l6.setToolTipText("<html><p>Use any of the following format:</p>"
                + "<p>1234567890</p>"
                + "<p>123-456-7890</p>"
                + "<p>123.456.7890</p>"
                + "<p>123 456 7890</p>"
                + "<p>(123) 456 7890</p></html>");
        
        l7.setToolTipText("<html><p>Password must include at least:</p>"
                + "<p>one digit from 0-9</p>"
                + "<p>one lowercase character</p>"
                + "<p>one uppercase character</p>"
                + "<p>length of 6-20 characters</p></html>");
        
        l8.setToolTipText("<html><p>Password must include at least:</p>"
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
        l5.setBounds(30, 200, 200, 30);
        l6.setBounds(30, 250, 200, 30);
        l7.setBounds(30, 300, 200, 30);
        l8.setBounds(30, 350, 200, 30);
        l9.setBounds(30, 400, 200, 30);
        l10.setBounds(30, 450, 200, 30);
        
        t1.setBounds(250, 50, 200, 30);
        t2.setBounds(250, 100, 200, 30);
        t3.setBounds(250, 150, 200, 30);
        t4.setBounds(250, 200, 200, 30);
        t5.setBounds(250, 250, 200, 30);
        t6.setBounds(250, 400, 200, 30);

        
        p1.setBounds(250, 300, 200, 30);
        p2.setBounds(250, 350, 200, 30);
        p3.setBounds(250, 450, 200, 30);

        
        b1.setBounds(340, 500, 100, 30);
        b2.setBounds(190, 500, 100, 30);
        b3.setBounds(40, 500, 100, 30);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);

        
        add(p1);
        add(p2);
        add(p3);
        
        add(b1);
        add(b2);
        add(b3);
        
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
		        
        ResultSet rs = stat.executeQuery("select * from USERS where EMAIL = \""+email[0]+"\" ;");
        while (rs.next()) 
        {
            p1.setText(rs.getString("PASS"));
            p2.setText(rs.getString("PASS"));
            p3.setText(rs.getString("ANSWER"));
        	t1.setText(rs.getString("FIRST_NAME"));
        	t2.setText(rs.getString("LAST_NAME"));
        	t3.setText(rs.getString("DOB"));
            t4.setText(rs.getString("EMAIL"));
        	t5.setText(rs.getString("PHONE"));
        	t6.setText(rs.getString("SECURITY_QUESTION"));
        }
        rs.close();
        conn.close();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            //Use these strings to input the data into the database
            String firstName = t1.getText();
            String lastName = t2.getText();
            String dateOfBirth = t3.getText();
            String newEmail = t4.getText();
            String phoneNumber = t5.getText();
            String Squestion = t6.getText();

            char[] pw1 = p1.getPassword();
            char[] pw2 = p2.getPassword();
            char[] pw3 = p3.getPassword();

            String password1 = String.valueOf(pw1);
            String password2 = String.valueOf(pw2);
            String Sanswer = String.valueOf(pw3);

            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(dateOfBirth);
            System.out.println(newEmail);
            System.out.println(phoneNumber);


            
            Pattern namePattern = Pattern.compile(validName);
            Matcher firstNameMatcher = namePattern.matcher(firstName);
            if("".equals(firstName))
            {
                JOptionPane.showMessageDialog(this, "Please enter first name");
            } 
            else if(firstNameMatcher.matches())
            {
                Matcher lastNameMatcher = namePattern.matcher(lastName);
                if("".equals(lastName))
                {
                    JOptionPane.showMessageDialog(this, "Please enter last name");
                }
                else if(lastNameMatcher.matches())
                {
                    Pattern dateOfBirthPattern = Pattern.compile(validDOB);
                    Matcher dateOfBirthMatcher = dateOfBirthPattern.matcher(dateOfBirth);
                    if("".equals(dateOfBirth))
                    {
                        JOptionPane.showMessageDialog(this, "Please enter date of birth");
                    }
                    else if(dateOfBirthMatcher.matches())
                    {
                        try
                        {
                            Date today = new Date();
                            Date dobDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
                            String arrDOB[] = dateOfBirth.split("/");
                            int birthYear = Integer.parseInt(arrDOB[2]);
                            if(dobDate.compareTo(today) <= 0)
                            {
                                if(2015-birthYear >= 18)
                                {
                                    Pattern emailPattern = Pattern.compile(validEmail);
                                    Matcher emailMatcher = emailPattern.matcher(email[0]);
                                    if("".equals(email))
                                    {
                                        JOptionPane.showMessageDialog(this, "Please enter e-mail");
                                    }
                                    else if(emailMatcher.matches())
                                    {
                                        Pattern phonePattern = Pattern.compile(validPhone);
                                        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
                                        if("".equals(phoneNumber))
                                        {
                                            JOptionPane.showMessageDialog(this, "Please enter phone number");
                                        }
                                        else if(phoneMatcher.matches())
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
                                                        //Code here to store information in database
                                                    	
                                                    	if(Squestion.length()>=6)
                                                    	{
                                                    		if(Sanswer.length()>=3)
                                                    		{
                                                                //Code here to store information in database
                                                            	
                                                                try {
                                                                	if(newEmail.compareToIgnoreCase(email[0])==0)
                                                                	{
            															editUser thisPerson=new editUser(email[0],password1,firstName,lastName,phoneNumber,dateOfBirth,Squestion,Sanswer);
        		                                                        JOptionPane.showMessageDialog(this, "Account has been edited");
            															dispose();
                                                                	}
                                                                	else
        															{
            															replaceUser thisPerson=new replaceUser(newEmail,email[0],password1,firstName,lastName,phoneNumber,dateOfBirth,Squestion,Sanswer);
            															System.out.println(thisPerson.isSuccessful());
                                                                		if(thisPerson.isSuccessful()==true)//new email not in data base
                                                                		{
            		                                                        JOptionPane.showMessageDialog(this, "Account has been edited");
            		                                                        email[0]=newEmail;
            		                                                        dispose();
                                                                		}
                                                                		else
                                                                		{
            		                                                        JOptionPane.showMessageDialog(this, "Email is already in the database.");
                                                                		}
        															}													
        														} catch (Exception e1) {
        															e1.printStackTrace();
        														}
                                                    		}
                                                    		else
                                                    		{
                                                                JOptionPane.showMessageDialog(this, "Invalid security password");
                                                                p3.setText("");
                                                    		}
                                                    	}
                                                    	else
                                                    	{
                                                            JOptionPane.showMessageDialog(this, "Invalid security question");
                                                            t6.setText("");
                                                    	}
                                                    	//

                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(this, 
                                                            "Passwords do not match");
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
                                            JOptionPane.showMessageDialog(this, "Invalid phone number");
                                            t5.setText("");
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(this, "Invalid e-mail");
                                        t4.setText("");
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(this, "You need to be 18 years or older");
                                    t3.setText("");
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "Invalid birthdate");
                                t3.setText("");
                            }
                        }
                        catch(ParseException ex){
                            JOptionPane.showMessageDialog(this, "Exception thrown: " + ex);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Invalid birthdate");
                        t3.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Invalid last name");
                    t2.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid first name");
                t1.setText("");
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            p1.setText("");
            p2.setText("");
        }
        else if(e.getSource()==b3)
        {
            dispose();
        }
    }
}
