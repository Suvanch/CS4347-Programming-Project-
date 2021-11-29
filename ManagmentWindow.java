package Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;
import java.lang.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ManagmentWindow extends JFrame implements ActionListener {
	


    ManagmentWindow(){
        creatNewAccountGUI();
		

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

	

	public void creatNewAccountGUI(){
		JFrame frame = new JFrame("Mangament");
		JPanel pnPanel0;
		JLabel lbNewAccountTitle;
		JLabel lbNameLable;
		JLabel lbSSNLable;
		JLabel lbAddressLable;
		JLabel lbLastNameLable;
		JLabel lbPhoneNumberLabel;
		JButton btCreateAccountButton;
		JTextField tfNameText;
		JTextField tfSSNText;
		JTextField tfAddressText;
		JTextField tfLastNameText;
		JTextField tfPhoneNumberText;
		


		pnPanel0 = new JPanel();
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		pnPanel0.setLayout( gbPanel0 );

		lbNewAccountTitle = new JLabel( "          New Account"  );
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 9;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.CENTER;
		gbcPanel0.insets = new Insets( 0,17,0,0 );
		gbPanel0.setConstraints( lbNewAccountTitle, gbcPanel0 );
		pnPanel0.add( lbNewAccountTitle );

		lbNameLable = new JLabel( "First Name"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbNameLable, gbcPanel0 );
		pnPanel0.add( lbNameLable );

		lbLastNameLable = new JLabel( "Last Name"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLastNameLable, gbcPanel0 );
		pnPanel0.add( lbLastNameLable );

		lbSSNLable = new JLabel( "SSN"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbSSNLable, gbcPanel0 );
		pnPanel0.add( lbSSNLable );

		lbAddressLable = new JLabel( "Address"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbAddressLable, gbcPanel0 );
		pnPanel0.add( lbAddressLable );

		lbPhoneNumberLabel = new JLabel( "Phone Number"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbPhoneNumberLabel, gbcPanel0 );
		pnPanel0.add( lbPhoneNumberLabel );

		

		btCreateAccountButton = new JButton( "Create Account"  );
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 20;
		gbcPanel0.gridwidth = 9;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbcPanel0.insets = new Insets( 0,29,0,0 );
		gbPanel0.setConstraints( btCreateAccountButton, gbcPanel0 );
		pnPanel0.add( btCreateAccountButton );



		tfNameText = new JTextField( );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfNameText, gbcPanel0 );
		pnPanel0.add( tfNameText );

		tfLastNameText = new JTextField( );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfLastNameText, gbcPanel0 );
		pnPanel0.add( tfLastNameText );

		

		tfSSNText = new JTextField( );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfSSNText, gbcPanel0 );
		pnPanel0.add( tfSSNText );

		tfAddressText = new JTextField( );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfAddressText, gbcPanel0 );
		pnPanel0.add( tfAddressText );
        
		tfPhoneNumberText = new JTextField( );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfPhoneNumberText, gbcPanel0 );
		pnPanel0.add( tfPhoneNumberText );

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pnPanel0);
		frame.setResizable(true);
        frame.setSize(1000,1000);
        frame.setVisible(true);


		tfNameText.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			  changed();
			}
			public void removeUpdate(DocumentEvent e) {
			  changed();
			}
			public void insertUpdate(DocumentEvent e) {
			  changed();
			}
		  
			public void changed() {
				btCreateAccountButton.setEnabled(validatess(tfSSNText, tfNameText, tfLastNameText, tfAddressText, tfPhoneNumberText));
			}
		  });

tfSSNText.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			  changed();
			}
			public void removeUpdate(DocumentEvent e) {
			  changed();
			}
			public void insertUpdate(DocumentEvent e) {
			  changed();
			}
		  
			public void changed() {
				btCreateAccountButton.setEnabled(validatess(tfSSNText, tfNameText, tfLastNameText, tfAddressText, tfPhoneNumberText));

		  
			}
		  });

		  tfAddressText.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			  changed();
			}
			public void removeUpdate(DocumentEvent e) {
			  changed();
			}
			public void insertUpdate(DocumentEvent e) {
			  changed();
			}
		  
			public void changed() {
				btCreateAccountButton.setEnabled(validatess(tfSSNText, tfNameText, tfLastNameText, tfAddressText, tfPhoneNumberText));

		  
			}
		  });
		  
		  tfLastNameText.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			  changed();
			}
			public void removeUpdate(DocumentEvent e) {
			  changed();
			}
			public void insertUpdate(DocumentEvent e) {
			  changed();
			}
		  
			public void changed() {
				btCreateAccountButton.setEnabled(validatess(tfSSNText, tfNameText, tfLastNameText, tfAddressText, tfPhoneNumberText));

		  
			}
		  });
		  
		  tfPhoneNumberText.getDocument().addDocumentListener((DocumentListener) new DocumentListener(){
			public void changedUpdate(DocumentEvent e) {
			  changed();
			}
			public void removeUpdate(DocumentEvent e) {
			  changed();
			}
			public void insertUpdate(DocumentEvent e) {
			  changed();
			}
		  
			public void changed() {
				btCreateAccountButton.setEnabled(validatess(tfSSNText, tfNameText, tfLastNameText, tfAddressText, tfPhoneNumberText));

				
			}
		  });








		btCreateAccountButton.addActionListener(new ActionListener(){
			
			@Override
            public void actionPerformed(ActionEvent e) {
				
				
					person newPerson = new person(tfNameText.getText(),tfLastNameText.getText() , tfSSNText.getText(),tfAddressText.getText(),tfPhoneNumberText.getText());


					int veriNum = newPerson.verifyiPerson();
					if(veriNum == -1){
						JOptionPane.showMessageDialog(frame, "SSN is alredy being used");
					}
					else if(veriNum == 0){
						newPerson.addPerson();
						JOptionPane.showMessageDialog(frame, "New account has been created");
						frame.setVisible(false); //you can't see me!
						frame.dispose(); //Destroy the JFrame object					
					}
					
				}
				
			

		});
	}

	public boolean validatess(JTextField tfSSNText, JTextField tfNameText, JTextField tfLastNameText, JTextField tfAddressText, JTextField tfPhoneNumberText){


		return !tfSSNText.getText().equals("") && !tfNameText.getText().equals("") && !tfLastNameText.getText().equals("")&&!tfAddressText.getText().equals("")&&!tfPhoneNumberText.getText().equals("");
	}

}

