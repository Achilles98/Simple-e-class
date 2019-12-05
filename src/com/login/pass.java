package com.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class pass {
	public static final String SALT = "SALTBAE";
	public static void createpass() {
		try {
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			
	    	  Class.forName("org.postgresql.Driver");
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT * FROM PUBLIC.PROFESSORS");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	        
	 	         while(Rs.next()) {
	 	        	 if (Rs.getString(5).equals(username)) {
	 	        		Statement stmt1 = c.createStatement();
	 	        		Scanner in2 = new Scanner(System.in);
	 	        		String pass = in2.nextLine();
	 	        		String saltedPassword = SALT + pass;
	 	        		System.out.println(saltedPassword);
	 	        		String hashedPassword = generateHash(saltedPassword);
	 	        		System.out.println(hashedPassword);
	 	        		stmt1.executeUpdate("UPDATE professors\n" + 
			 	        		"SET passwords = '"+ hashedPassword +"'\n" + 
			 	        		"WHERE username ='"+username+"'");
	 	        		System.out.println("i did it");
	 	        		c.commit();
	 	        	 }	 	        	
	 	         }
	 	         
	 	        stmt.close();	 	       
	 	         c.close();
	 	         }
	      catch (Exception e) 
	      {
	    	  System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	 	         }
	}
	public Boolean login(String username, String password, int counter) {
		Boolean flag = false;
		String dep = null;
		int thesiuser = 0;
		int thesipass = 0;
		if (counter == 1) {
			dep = "SECRETARIES";
			thesiuser = 1;
			thesipass = 3;
		}else if (counter == 2) {
			dep = "STUDENTS";
			thesiuser = 5;
			thesipass = 6;
		}else {
			dep = "PROFESSORS";
			thesiuser = 5;
			thesipass = 6;
		}
		try {
	    	  Class.forName("org.postgresql.Driver"); 
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT * FROM PUBLIC."+dep);
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	        
	 	         while(Rs.next()) {
	 	        	 if (Rs.getString(thesiuser).equals(username)) {
	 	        		String saltedPassword = SALT + password;
	 	        		String hashedPassword = generateHash(saltedPassword);
	 	        		if (Rs.getString(thesipass).equals(hashedPassword)) {
	 	        			flag = true;
	 	        		}
	 	        	 }	 	        	
	 	         }	 	        
	 	        stmt.close();	 	       
	 	         c.close();
	 	         }
	      catch (Exception e) 
	      {
	    	  System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	 	         }
		
		
		return flag;
	}
	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}
}
