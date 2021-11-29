package Main;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class FineWindow extends JFrame implements ActionListener {
    
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static String error="",due_date,Loan_id1,amount_status;
    static Date due_datefinal,date_today,date_in;
    public static ArrayList<Float> fine =new ArrayList<Float>();
    public static ArrayList<Float> estimated_fine =new ArrayList<Float>();
    public static ArrayList<String> fine_data =new ArrayList<String>();
    static float fine1,estimated_fine1;
    static HashMap hm=new HashMap();
    public static float fine_amount;
    private static float local_amount;
    static DefaultTableModel defaultTableModel;
    
	JFrame frame;
	static JFrame frame2 = new JFrame("Results From SQL");
	JButton pay_fines;
	static JTable table;
	JButton view_fines;

    
	FineWindow(){
		
		frame = new JFrame();
        frame.setTitle("Fine Window");
		
        //creating object for gridbag
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame.setSize(500, 300);
        frame.setLayout(bagLayout);
        
        bagConstraints.insets = new Insets(15, 0, 0, 0);//Setting the padding between the components and neighboring components
 
        //Setting the properties for each button needed for the assignment
        pay_fines = new JButton("Pay Fine");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        bagConstraints.ipadx = 100;
        bagConstraints.ipady = 50;
        frame.add(pay_fines, bagConstraints);
        
        view_fines = new JButton("View Fines");
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 0;
        bagConstraints.ipadx = 100;
        bagConstraints.ipady = 50;
        frame.add(view_fines, bagConstraints);
         
        
        pay_fines.addActionListener(this);
        view_fines.addActionListener(this);
     
        frame.setVisible(true);
        frame.validate();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        setLayout(new FlowLayout());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pay_fines){
			JFrame frame2 = new JFrame("Pay Fines");
			JButton pay = new JButton("Pay");
			JLabel loan_id = new JLabel("Loan_ID");
			JTextField loan = new JTextField(15);
			JLabel amount = new JLabel("Amount");
			JTextField amount_text = new JTextField(15);
			
			
	        //creating object for gridbag
	        GridBagLayout bagLayout = new GridBagLayout();
	        GridBagConstraints bagConstraints = new GridBagConstraints();
	        frame2.setSize(500, 300);
	        frame2.setLayout(bagLayout);
	              
	        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
	        
	        //Setting the properties for each button needed for the assignment
	        bagConstraints.gridx = 1;
	        bagConstraints.gridy = 0;
	        frame2.add(loan_id, bagConstraints);

	        bagConstraints.gridx = 2;
	        bagConstraints.gridy = 0;
	        frame2.add(loan, bagConstraints);

	        bagConstraints.gridx = 1;
	        bagConstraints.gridy = 1;
	        frame2.add(amount, bagConstraints);

	        bagConstraints.gridx = 2;
	        bagConstraints.gridy = 1;
	        frame2.add(amount_text, bagConstraints);
	      
	        bagConstraints.gridx = 2;
	        bagConstraints.gridy = 2;
	        bagConstraints.ipadx = 60;
	        frame2.add(pay, bagConstraints);
	                
	        frame2.setVisible(true);
	        frame2.validate();
	        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame2.setResizable(true);
      
			pay.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()== pay) { 
						String loan_string = loan.getText();
						float amt = Float.parseFloat(amount_text.getText());

						//payment_method(loan_string, amt);
					}
				}
			});	
		}
		if(e.getSource() == view_fines) {
			JFrame frame3 = new JFrame("Pay Fines");
			JButton submit = new JButton("View");
			JLabel card_id = new JLabel("Card_ID");
			JTextField cardID = new JTextField(15);
			JLabel view = new JLabel("View Option(All,Paid,Unpaid)");
			JTextField view_text = new JTextField(15);

			
	        //creating object for gridbag
	        GridBagLayout bagLayout = new GridBagLayout();
	        GridBagConstraints bagConstraints = new GridBagConstraints();
	        frame3.setSize(500, 300);
	        frame3.setLayout(bagLayout);
	              
	        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
	        
	        //Setting the properties for each button needed for the assignment
	        bagConstraints.gridx = 1;
	        bagConstraints.gridy = 0;
	        frame3.add(card_id, bagConstraints);

	        bagConstraints.gridx = 2;
	        bagConstraints.gridy = 0;
	        frame3.add(cardID, bagConstraints);
	        
	        bagConstraints.gridx = 1;
	        bagConstraints.gridy = 1;
	        frame3.add(view, bagConstraints);
	        
	        bagConstraints.gridx = 2;
	        bagConstraints.gridy = 1;
	        frame3.add(view_text, bagConstraints);
	        
	        bagConstraints.gridx = 2;
	        bagConstraints.gridy = 2;
	        frame3.add(submit, bagConstraints);
	              
	        frame3.setVisible(true);
	        frame3.validate();
	        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame3.setResizable(true);
	        
	        
			submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()== submit) { 
						String card_id_string = cardID.getText();
						String view_option = view_text.getText();
						displayFines(view_option, card_id_string);
					}
				}
			});
		}
	}
	
	public static void displayFines(String input,String cardId) {
		
			//setting the properties of jtable and defaulttablemodel
    		defaultTableModel = new DefaultTableModel();
    		table = new JTable(defaultTableModel);
    		table.setPreferredScrollableViewportSize(new Dimension(800,500));
    		table.setFillsViewportHeight(true);
    		frame2.add(new JScrollPane(table));
    	
    		defaultTableModel.addColumn("loan_id");
    		defaultTableModel.addColumn("fine_amt");
    		defaultTableModel.addColumn("card_id");
    		defaultTableModel.addColumn("paid");
		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "Thecrow_69");
			 Statement s = conn.createStatement();
			 String sql = null;
			 
			 if(input == "All") {
				 sql="SELECT * FROM fines WHERE card_id='" + cardId + "';";
			 }
			 else if(input == "Paid"){
				 sql="SELECT * FROM fines WHERE card_id='" + cardId + "' AND paid=TRUE;";
			 }
			 else {
				 sql="SELECT * FROM fines WHERE card_id='" + cardId + "' AND paid=FALSE;";
			 }
			 ResultSet rs = s.executeQuery(sql);
						 
			 while(rs.next()) {
        			//grabbing the items from the csv 
        			String loan_id = rs.getString("loan_id");
                    String fine_amt = rs.getString("fine_amt");
                    String card_id = rs.getString("card_id");
                    String paid = rs.getString("paid");
                    
                    defaultTableModel.addRow(new Object[] {loan_id,fine_amt,card_id,paid});
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                    table.setDefaultRenderer(String.class, centerRenderer);
                    
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setVisible(true);
                    frame2.validate();   
        		} 		 
		}
		catch(Exception e1) {
     		JOptionPane.showMessageDialog(null, e1);
	 	}		
	}

}