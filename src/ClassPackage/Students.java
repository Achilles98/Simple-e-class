package ClassPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ClassPackage.Secretaries;
import ClassPackage.Users;

public class Students extends Users {
	
	static String username;
	public Students(int registrationNumber, String usr, String nm, String srnm, String dprt) {				
		Secretaries sec = new Secretaries();
		sec.createStu(usr, nm, srnm, dprt, registrationNumber);
	}
	public static void getter (String usr) {
		username = usr;
	}
	public static ArrayList<String> ViewGrades() {
		ArrayList<String> Result = new ArrayList<String>();
		
		try {
	    	  Class.forName("org.postgresql.Driver"); 
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT COURSE.coursetitle , grades.grade,grades.stud_regnum from GRADES\n"
	 	        		+ "INNER JOIN STUDENTS ON GRADES.STUD_REGNUM = STUDENTS.REGNUM\n"
	 	        		+ "INNER JOIN COURSE ON COURSE.IDCOURSE = GRADES.COURSEID\n"
	 	        		+ "WHERE STUDENTS.USERNAME='"+username+"'");
	 	        
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
	public static ArrayList<String> semestergrades(String sem) {
		ArrayList<String> Result = new ArrayList<String>();
		
		try {
	    	  Class.forName("org.postgresql.Driver"); 
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT COURSE.coursetitle , grades.grade,grades.stud_regnum, COURSE.COURSESEMESTER from GRADES\n"
	 	        		+ "INNER JOIN STUDENTS ON GRADES.STUD_REGNUM = STUDENTS.REGNUM\n"
	 	        		+ "INNER JOIN COURSE ON COURSE.IDCOURSE = GRADES.COURSEID\n"
	 	        		+ "WHERE STUDENTS.USERNAME='"+username+"' AND COURSE.COURSESEMESTER='"+sem+"'");
	 	        
	 	        ResultSet Rs = stmt.executeQuery();
	 	        
	 	         while(Rs.next()) {
	 	        	Result.add(Rs.getString(1));
	 	        	Result.add(Rs.getString(2));
	 	        	Result.add(Rs.getString(3));
	 	        	Result.add(Rs.getString(4));
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
	public static ArrayList<String> gradesavg() {
		ArrayList<String> Result = new ArrayList<String>();
		
		try {
	    	  Class.forName("org.postgresql.Driver"); 
	    	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456789");
	 	        c.setAutoCommit(false);
	 	        PreparedStatement stmt =c.prepareStatement("SELECT avg(grades.grade),grades.stud_regnum from GRADES\n"
	 	        		+ "INNER JOIN STUDENTS ON GRADES.STUD_REGNUM = STUDENTS.REGNUM\n"
	 	        		+ "INNER JOIN COURSE ON COURSE.IDCOURSE = GRADES.COURSEID\n"
	 	        		+ "WHERE STUDENTS.USERNAME='"+username+"' AND grades.grade IS NOT NULL\n"
	 	        		+ "GROUP BY grades.stud_regnum");
	 	        
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
		return (Result);
	}
}
	


		
		
     



