package Main;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagmentWindow extends JFrame implements ActionListener {
		
	JFrame frame = new JFrame("Management");
	JTextField firstName = new JTextField(15);
    JTextField lastName = new JTextField(15);
    JTextField ssn = new JTextField(15);
    JTextField address = new JTextField(15);
    JTextField city = new JTextField(15);
    JTextField state = new JTextField(15);
    JTextField phone = new JTextField(15);
    JLabel lbFirstNameLabel= new JLabel("First Name");
    JLabel lbLastNameLabel = new JLabel("Last Name");    
    JLabel lbSSNLabel = new JLabel("SSN");
    JLabel lbAddressLabel = new JLabel("Street Address");
    JLabel lbCityLabel = new JLabel("City");
    JLabel lbStateLabel = new JLabel("State");
    JLabel lbPhoneLabel = new JLabel("Phone number");
    JButton submit = new JButton("Insert Account");
    String ssn_string;
    String fname_string;
    String lname_string;
    String address_string;
    String city_string;
    String state_string;
    String phone_string;
    GridBagLayout bagLayout = new GridBagLayout();
	GridBagConstraints bagConstraints = new GridBagConstraints();

	ManagmentWindow(){

    	frame.setLayout(bagLayout);
		bagConstraints.insets = new Insets(15, 40, 0, 0);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		frame.add(lbFirstNameLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		frame.add(firstName, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		frame.add(lbLastNameLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		frame.add(lastName, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		frame.add(lbSSNLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		frame.add(ssn, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 3;
		frame.add(lbAddressLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 3;
		frame.add(address, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		frame.add(lbCityLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 4;
		frame.add(city, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 5;
		frame.add(lbStateLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 5;
		frame.add(state, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 6;
		frame.add(lbPhoneLabel, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 6;
		frame.add(phone, bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 3;
		frame.add(submit, bagConstraints);
		
		submit.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(500,300);
        frame.setVisible(true);

	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == submit) {
    			
    		fname_string = firstName.getText();
    		lname_string = lastName.getText();
    		ssn_string = ssn.getText();
    		address_string = address.getText();
    		city_string = city.getText();
    		state_string = state.getText();
    		phone_string = phone.getText();
    
    		//invalid criteria
    		if((fname_string == null) || (lname_string == null) || (ssn_string == null) || (address_string == null) || (city_string == null) || (state_string == null) || (phone_string == null)) {
				JOptionPane.showConfirmDialog(null, "Invalid Criteria", "Result",JOptionPane.DEFAULT_OPTION);
				System.exit(0);
			}
    		//ssn is already existing
	        else if (checkSSN(ssn_string) == true) {
	        	JOptionPane.showConfirmDialog(null,"Borrower Already exists", "Result", JOptionPane.DEFAULT_OPTION);
				System.exit(0);
	        }
    		//new account can be made
			else{

		        try {
		      
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "Thecrow_69");               		
		            Statement s = conn.createStatement();
		            
		            String sql = "SELECT COUNT(*) FROM borrower;";
		            ResultSet rs = s.executeQuery(sql);
		            rs.next();
		            String max = rs.getString(1); //gets 1000 or the highest count

	        		int newCardID = Integer.parseInt(max) + 1;
	        		
	        			address_string += ", " + city_string + ", " + state_string;
	                    String bname = fname_string +" "+ lname_string; 
	                    String insert_stmt = "Insert into BORROWER (card_id, ssn, bname, address, phone) Values ('" + newCardID + "', '" + ssn_string + "', '" + bname + "', '"  + address_string + "', '" + phone_string + "')";
	                    int insert = s.executeUpdate(insert_stmt);
	                    JOptionPane.showConfirmDialog(null, "New account has been created", "Result" , JOptionPane.DEFAULT_OPTION);
	                    System.exit(0);
	                    
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null, e1);
		        }		
			}			
    	}
    }
    
    public Boolean checkSSN(String ssn){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "Thecrow_69");               		
            Statement s = conn.createStatement();
            String sql = "SELECT EXISTS(SELECT Ssn FROM borrower WHERE borrower.ssn = '" + ssn + "')";
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            boolean test = rs.getBoolean(1);
            
    		if(test == true) {	
				return true;
    		}

        }catch(Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }
        return false;	
    }
}