package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ClassPackage.Professors;
import ClassPackage.Secretaries;
import ClassPackage.Students;


@WebServlet("/loginservlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ArrayList<String> cou = new ArrayList();
		ArrayList<String> pr= new ArrayList();
		
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("pass");
		if (request.getParameter("btn")!= null) {
			Secretaries.getter(uname);
			Professors.getter(uname);
			Students.getter(uname);
			pass elegxos = new pass();

			if (elegxos.login(uname,pass, 1)) {
				response.sendRedirect("LoggedIn.jsp");
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(10*60);

			
			}else if(elegxos.login(uname,pass, 2)) {
				response.sendRedirect("Students.jsp");
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(10*60);
			
			}else if(elegxos.login(uname,pass, 3)) {
				response.sendRedirect("professors.jsp");
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(10*60);
			}else {
				response.sendRedirect("Login.jsp"); 
			}
		}
		else if (request.getParameter("btn1")!=null) {		
			ArrayList<String> CTitle = Secretaries.viewcourses();
			RequestDispatcher rd = request.getRequestDispatcher("LoggedIn.jsp");
			rd.include(request, response);
			out.println("<br><br>");
			out.println("<table border == '2'>");
			for (int i = 0; i < CTitle.size(); i++) {
		        out.println("<tr><td>" + CTitle.get(i) + "</td></tr>");
		        
		    }
			out.println("</table>");
			
		}else if (request.getParameter("btn2")!=null) {		
			ArrayList<String> ProCou = Secretaries.viewprocour();
			RequestDispatcher rd = request.getRequestDispatcher("LoggedIn.jsp");
			rd.include(request, response);
			out.println("<br><br>");
			out.println("<table border == '1'>");
			for (int i = 0; i < ProCou.size(); i=i+3) {
		        out.println("<tr><td>" + ProCou.get(i) + "</td>");
		        out.println("<td>" + ProCou.get(i+1) + "</td>");
		        out.println("<td>" + ProCou.get(i+2) + "</td></tr>");
		        
		    }
			out.println("</table>");
			
			
				
		}else if (request.getParameter("btn3")!=null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("LoggedIn.jsp");
			rd.include(request, response);
			cou = Secretaries.courbutt();
			pr = Secretaries.profbutt();
		
			out.print("<table border=='1'>");
			for (int i =0;i<pr.size()-1;i=i+2) {
				out.println("<tr><td>"+pr.get(i)+"</td>");
				out.println("<td>"+pr.get(i+1)+"</td></tr>");
			}
			out.print("</table>");
			out.print("<br><br>");
			out.print("<table border=='1'>");
			for (int i =0;i<cou.size()-1;i=i+2) {
				out.println("<tr><td>"+cou.get(i)+"</td>");
				out.println("<td>"+cou.get(i+1)+"</td></tr>");
			}	
			out.print("</table>");
			out.print("<br>");
			out.println("<label for=\"afm\"> Professor AFM : </label> \n" + 
					"	    	       <input id=\"afm\" type=\"text\" name=\"afm\" >"
					+ "<label for=\"id\"> Course ID: </label> \n" + 
					"	    	       <input id=\"courseid\" type=\"text\" name=\"courseid\" ><br>"
					+ "<input id=\"setcoursetoprof\" type= \"submit\" name = \"setcoursetoprof\" value= \"OK\"><br><br><br>");
		}else if (request.getParameter("setcoursetoprof")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("LoggedIn.jsp");
			
			rd.include(request, response);
			cou = Secretaries.courbutt();
			pr = Secretaries.profbutt();
		
			out.print("<table border=='1'>");
			for (int i =0;i<pr.size()-1;i=i+2) {
				out.println("<tr><td>"+pr.get(i)+"</td>");
				out.println("<td>"+pr.get(i+1)+"</td></tr>");
			}
			out.print("</table>");
			out.print("<br><br>");
			out.print("<table border=='1'>");
			for (int i =0;i<cou.size()-1;i=i+2) {
				out.println("<tr><td>"+cou.get(i)+"</td>");
				out.println("<td>"+cou.get(i+1)+"</td></tr>");
			}	
			out.print("</table>");
			out.print("<br>");
			out.println("<label for=\"afm1\"> Professor AFM : </label> \n" + 
					"	    	       <input id=\"afm\" type=\"text\" name=\"afm\" >"
					+ "<label for=\"id\"> Course ID: </label> \n" + 
					"	    	       <input id=\"courseid\" type=\"text\" name=\"courseid\" ><br>"
					+ "<input id=\"setcoursetoprof\" type= \"submit\" name = \"setcoursetoprof\" value= \"OK\"><br><br><br>");
			out.println("<p>"+ Secretaries.setprof(Integer.parseInt(request.getParameter("afm")), Integer.parseInt(request.getParameter("courseid")))+"</p>");
		}else if (request.getParameter("btn5")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("professors.jsp");
			ArrayList<String> grades = Professors.ViewGrades();
			rd.include(request, response);
			out.println("<br><br>");
			out.println("<table border == '1'>");
			for (int i = 0; i < grades.size(); i=i+3) {
		        out.println("<tr><td>" + grades.get(i) + "</td>");
		        out.println("<td>" + grades.get(i+1) + "</td>");
		        out.println("<td>" + grades.get(i+2) + "</td></tr>");
		        
		    }
			out.println("</table>");
		}else if (request.getParameter("btn6")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("professors.jsp");
			ArrayList<String> grades = Professors.SetGrades();
			rd.include(request, response);
			out.println("<br><br>");
			out.println("<table border == '1'>");
			for (int i = 0; i < grades.size(); i=i+2) {
		        out.println("<tr><td>" + grades.get(i) + "</td>");
		        out.println("<td>" + grades.get(i+1) + "</td></tr>");		        
			}
			out.println("<label for=\"Grade\"> Grade : </label> \n" +
        		" <input id=\"Grade\" type=\"text\" name=\"Grade\" >"+
        		"<label for=\"regnum\">Student's Registration Number : </label> \n" +
			    	       "<input id=\"regnum\" type=\"text\" name=\"regnum\" >"
        		+ "<input id=\"setgrade\" type= \"submit\" name = \"setgrade\" value= \"OK\"><br><br><br>");
	
		}else if (request.getParameter("setgrade")!=null) {
			
			Professors.setgrade(Integer.parseInt(request.getParameter("regnum")), Integer.parseInt(request.getParameter("Grade")));
			RequestDispatcher rd = request.getRequestDispatcher("professors.jsp");
			ArrayList<String> grades = Professors.SetGrades();
			rd.include(request, response);
			out.println("<br><br>");
			out.println("<table border == '1'>");
			for (int i = 0; i < grades.size(); i=i+2) {
				
		        out.println("<tr><td>" + grades.get(i) + "</td>");
		        out.println("<td>" + grades.get(i+1) + "</td></tr>");
			}
		        out.println("<label for=\"Grade1\"> Grade : </label> \n" + 
						"	    	       <input id=\"Grade\" type=\"text\" name=\"Grade\" >"
						+ "<label for=\"regnum\">Student's Registration Number : </label> \n" + 
						"	    	       <input id=\"regnum\" type=\"text\" name=\"regnum\" >"
		        		
						+ "<input id=\"setgrade\" type= \"submit\" name = \"setgrade\" value= \"OK\"><br><br><br>");
		        		        
		
			
		}else if (request.getParameter("viewgrades")!=null) {
			ArrayList<String> grades = Students.ViewGrades();
			RequestDispatcher rd = request.getRequestDispatcher("Students.jsp");
			rd.include(request, response);
			out.println("<br><br>");
			out.println("<table border == '1' style='background-color: #f1f1c1' >");
			 out.println("<tr style='font-weight: bold'><td>Course </td><td>Grade </td><td>Registration Number </td></tr>");
			for (int i = 0; i < grades.size(); i=i+3) {
		        out.println("<tr><td>" + grades.get(i) + "</td>");
		        out.println("<td>" + grades.get(i+1) + "</td>");
		        out.println("<td>" + grades.get(i+2) + "</td></tr>");
		        
		    }
		}else if (request.getParameter("semestergrades")!=null) {	
			
			RequestDispatcher rd = request.getRequestDispatcher("Students.jsp");
			rd.include(request, response);
			out.println("<br><br>");
			 out.println("<label for=\"semester\"> Semester : </label> \n" + 
						"	    	       <input id=\"semester\" type=\"text\" name=\"semester\" >"
		
						+ "<input id=\"showsemestergrades\" type= \"submit\" name = \"showsemestergrades\" value= \"OK\"><br><br><br>");
		}else if (request.getParameter("showsemestergrades")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("Students.jsp");
			rd.include(request, response);
			ArrayList<String> grades = Students.semestergrades(request.getParameter("semester"));
			
			out.println("<br><br>");
			
			out.println("<table border == '1' style='background-color: #f1f1c1' >");
			 out.println("<tr style='font-weight: bold'><td>Course </td><td>Grade </td><td>Registration Number </td><td>Course Semester </td></tr>");
			for (int i = 0; i < grades.size(); i=i+4) {
		        out.println("<tr><td>" + grades.get(i) + "</td>");
		        out.println("<td>" + grades.get(i+1) + "</td>");
		        out.println("<td>" + grades.get(i+2) + "</td>");
		        out.println("<td>" + grades.get(i+3) + "</td></tr>");
		}
		}else if (request.getParameter("avggrade")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("Students.jsp");
			rd.include(request, response);
			ArrayList<String> grades = Students.gradesavg();
			out.println("<br><br>");
			out.println("<table border == '1' style='background-color: #f1f1c1' >");
			 out.println("<tr style='font-weight: bold'><td>Grades' Average </td><td>Registration Number </td></tr>");
			for (int i = 0; i < grades.size(); i=i+2) {
		        out.println("<tr><td>" + grades.get(i) + "</td>");        
		        out.println("<td>" + grades.get(i+1) + "</td></tr>");
		}
		}
		session.setAttribute("username", uname);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
