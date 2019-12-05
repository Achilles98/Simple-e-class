package ClassPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Secretaries extends Users {
	public Secretaries() {
			}
	static String  Username = null;
	public void createStu(String usr, String nm, String srnm, String dprt, int regnum)
	{
	
	}
	public void createprof(String usr, String nm, String srnm, String dprt) 
	{
		
	}
	public static void getter(String usr) {
		Username = usr;
	}
	public static ArrayList<String> viewcourses () {
		String dep="";
		ArrayList<Integer> afm = new ArrayList<Integer>();
		ArrayList<String> title = new ArrayList<String>();
		
		try {
	    	  Class.forName("org.postgresql.Driver");
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT * FROM PUBLIC.SECRETARIES");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	       
	 	         while(Rs.next()) {
	 	        	 if (Rs.getString(1).equals(Username)) {
	 	        		
	 	        		dep = Rs.getString(2);
	 	        		
	 	        	 }	 	        	
	 	         }
	 	        stmt =c.prepareStatement("SELECT * FROM PUBLIC.PROFESSORS");
	 	       Rs = stmt.executeQuery();
	 	      while(Rs.next()) {
	 	        	 if (Rs.getString(4).equals(dep)) {
	 	        		afm.add(Rs.getInt(1));
	 	        		
	 	        		
	 	        	 }	 	        	
	 	         }
	 	     stmt =c.prepareStatement("SELECT * FROM PUBLIC.COURSE");
	 	      Rs = stmt.executeQuery();
	 	     while(Rs.next()) {
	 	    	 
 	        	 if (afm.contains(Rs.getInt(4))) {
 	        		
 	        		title.add(Rs.getString(2));
 	        		
 	        	 
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
		return (title);
	}
	public static ArrayList<String> courbutt() {
		ArrayList<String> courses = new ArrayList();
		try {
			Class.forName("org.postgresql.Driver");
		  	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
			        c.setAutoCommit(false);
			        PreparedStatement stmt =c.prepareStatement("SELECT * FROM PUBLIC.COURSE");
			        
			        ResultSet Rs = stmt.executeQuery();
			        while(Rs.next()) {
			        	
			        	courses.add(Integer.toString(Rs.getInt(1)));
			        	courses.add(Rs.getString(2));
		 	         }
		}catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
		}
		
	       
		
		return courses;
	}
	public static ArrayList<String> profbutt() {
		ArrayList<String> prof = new ArrayList();
		String dep = "";
		try {
			Class.forName("org.postgresql.Driver");
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT * FROM PUBLIC.SECRETARIES");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	       
	 	         while(Rs.next()) {
	 	        	 if (Rs.getString(1).equals(Username)) {
	 	        		
	 	        		dep = Rs.getString(2);
	 	        		
	 	        	 }	 	        	
	 	         }
	 	        stmt =c.prepareStatement("SELECT * FROM PUBLIC.PROFESSORS");
	 	       Rs = stmt.executeQuery();
	 	      while(Rs.next()) {
	 	        	 if (Rs.getString(4).equals(dep)) {
	 	        		prof.add(Rs.getString(3));
	 	        		prof.add(Integer.toString(Rs.getInt(1)));
	 	        		
	 	        	 }	 	        	
	 	         }
		}catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
		}
		
	       
		
		return prof;
	}
	public static String setprof(int afm,int id) {
		boolean f = false;
		try {
				Class.forName("org.postgresql.Driver");
		    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
		 	        c.setAutoCommit(false);
		 	        
		 	       
		 	        Statement stmt1 = c.createStatement();
		 	        
		 	       stmt1.executeUpdate("UPDATE course\n" + 
		 	        		"SET professors_afm = "+ afm +"\n" + 
		 	        		"WHERE idcourse ="+id);
		 	        c.commit();
		 	         f = true;
		 	        
		 	         }catch(Exception e) {
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		          System.exit(0);
			}
		if (f) {
			return ("You did it!!!");
		}else {
			return ("Try again.");
		}
         }
	public static ArrayList<String> viewprocour() {
		int afm = 0;
		ArrayList<String> Result = new ArrayList<String>();
		String dep = "";
		
		try {
			Class.forName("org.postgresql.Driver");
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT * FROM PUBLIC.SECRETARIES");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	       
	 	         while(Rs.next()) {
	 	        	 if (Rs.getString(1).equals(Username)) {
	 	        		
	 	        		dep = Rs.getString(2);
	 	        		
	 	        	 }	 	        	
	 	         }
	 	       
	 	        PreparedStatement stmt1 =c.prepareStatement("SELECT * FROM PUBLIC.COURSE");
 	        	
		 	        stmt =c.prepareStatement("SELECT * FROM PUBLIC.PROFESSORS");
		 	        Rs = stmt.executeQuery();
		 	         while(Rs.next()) {
		 	        	 if (Rs.getString(4).equals(dep)) {
		 	        				 	        
		 	        		afm=Rs.getInt(1);
		 	        		ResultSet Rs1 = stmt1.executeQuery();
		 	        		 while(Rs1.next()) {
		 	        			
			 	 	        	 if (afm==Rs1.getInt(4)) {
			 	 	        		Result.add(Rs.getString(3));
				 	        		Result.add(Rs.getString(2));
			 	 	        		Result.add(Rs1.getString(2));
			 	 	        		
			 	 	        		
			 		 	    	 }
			 	 	         }
		 	        	 }
		 	        	 
		 	         } 		 	  
		 	         
		}catch(Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
		}
		return (Result);
		
    }
	public void setgradelist(String am,String grade, String title) {
		
         }
	
	}

