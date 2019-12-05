package ClassPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ClassPackage.Secretaries;
import ClassPackage.Users;

public class Professors extends Users {
	public Professors() {
		
	}
	static String username;
	public static void getter(String usr) {
		username = usr;
	}
	public static ArrayList<String> ViewGrades() {
		ArrayList<String> Result = new ArrayList<String>();
		
		try {
	    	  Class.forName("org.postgresql.Driver"); 
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT COURSE.coursetitle , grades.grade,grades.stud_regnum from COURSE\n"
	 	        		+ "INNER JOIN PROFESSORS ON COURSE.PROFESSORS_AFM = PROFESSORS.AFM\n"
	 	        		+ "INNER JOIN GRADES ON COURSE.IDCOURSE = GRADES.COURSEID\n"
	 	        		+ "WHERE PROFESSORS.USERNAME='"+username+"'");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	        
	 	         while(Rs.next()) {
	 	        	Result.add(Rs.getString(1));
	 	        	Result.add(Rs.getString(2));
	 	        	Result.add(Rs.getString(3));
	 	         }	 	        
	 	        stmt.close();	 	       
	 	         c.close();
	 	         }
	      catch (Exception e) 
	      {
	    	  System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	 	  }
		return (Result);
	}
	public static ArrayList<String> SetGrades(){
		ArrayList<String> Result = new ArrayList<String>();
		try {
	    	  Class.forName("org.postgresql.Driver"); 
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT COURSE.coursetitle , grades.stud_regnum from COURSE\n"
	 	        		+ "INNER JOIN PROFESSORS ON COURSE.PROFESSORS_AFM = PROFESSORS.AFM\n"
	 	        		+ "INNER JOIN GRADES ON COURSE.IDCOURSE = GRADES.COURSEID\n"
	 	        		+ "WHERE PROFESSORS.USERNAME='"+username+"' AND GRADES.GRADE IS NULL");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	        
	 	         while(Rs.next()) {
	 	        	Result.add(Rs.getString(1));
	 	        	Result.add(Rs.getString(2));
	 	        
	 	         }	 	        
	 	        stmt.close();	 	       
	 	         c.close();
	 	         }
	      catch (Exception e) 
	      {
	    	  System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	 	  }
		
		return Result;
	}
	public static void setgrade(int regnum,int grade) {
		 	       try {
				        Class.forName("org.postgresql.Driver"); 
				    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
				 	        c.setAutoCommit(false);
				        	Statement stmt1 = c.createStatement();
			        		stmt1.executeUpdate("UPDATE grades\n" + 
			 	        		"SET grade = '"+grade +"'\n" + 
			 	        		"WHERE stud_regnum ="+regnum);
			        	
			        		c.commit();
				       }catch (Exception e) {
				        	
				        }
		
	}
}
	

