package Main;
import java.lang.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class person {
    String FirstName;
    String LastName;
    String SSN;
    String phoneNumber;
    String Address;

    person(String _firstName, String _lastName, String _SSN, String _address, String _phoneNumber){
        FirstName = _firstName;
        LastName = _lastName;
        SSN = _SSN;
        Address = _address;
        phoneNumber = _phoneNumber;
        //if(verifyiPerson(_firstName, _lastName, _SSN,_address)){
        //    addPerson(_firstName, _lastName, _SSN,_address);
        //}
    }

    public int verifyiPerson(){
        //if entry is  null
        if((FirstName == null) || (LastName == null) || (SSN == null) || (phoneNumber == null) || (Address == null)){
            return -2;
        }
        //if ssn is alredy used
        if(!checkSSN(SSN)){
            return -1;
        }
        //if ssn is new
        else{
            return 0;
        }
    }

    //need to make warning when error or success
    //3) Success account created
    public Boolean addPerson(){
        System.out.println("=======================================================");
        int numEntries=0;
        try {
            System.out.println("hi1");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "a");               		
            String sql = "SELECT COUNT(*) FROM borrower;";
            PreparedStatement pstmt = conn.prepareStatement(sql);            		
            ResultSet rs = pstmt.executeQuery();
            System.out.println("hi1");
            while(rs.next()){
                numEntries = rs.getInt("COUNT(*)");
            }
            
            String card_id = Integer.toString(numEntries+1);
            System.out.println(card_id);

            
            sql = "insert into borrower (card_id,ssn,bname,address,phone) values (" + "\'" +card_id+ "\',\'" +SSN+ "\',\'"+FirstName+ " "+LastName+"\',\'"+Address+"\',\'"+ phoneNumber+"\'); ";
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql);          
            System.out.println("hi1");  		
            Boolean ss = pstmt.execute();
            System.out.println("hi1");
            return true;

        } catch(Exception e1) {
            JOptionPane.showMessageDialog(null, e1);

        }
        return false;
    }

    public Boolean checkSSN(String _ssn){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "a");               		
            String sql = "SELECT card_id FROM borrower where ssn=\'"+_ssn+"\'";
            PreparedStatement pstmt = conn.prepareStatement(sql);            		
            ResultSet rs = pstmt.executeQuery();
            if(!rs.next()){
                return true;
            }
        } catch(Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }
        return false;	
    }
}
