package ClassPackage;
import java.sql.*;
import java.util.Scanner;

import com.login.pass;

import ClassPackage.Professors;
import ClassPackage.Secretaries;
import ClassPackage.Users;

public class CreateUsers {
	
	
	public static void main(String[] args) {
		
	     
	         
	    
		// TODO Auto-generated method stub
		boolean flag = false;
		while (flag == false) {
			Scanner reg = new Scanner(System.in);
			Scanner usr = new Scanner(System.in);
			Scanner nm = new Scanner(System.in);
			Scanner srnm = new Scanner(System.in);
			Scanner dprt = new Scanner(System.in);
			System.out.println("Dose katallilo arithmo mitroou");		
			String reg2 = reg.nextLine();
			try {
				int num = Integer.parseInt(reg2);
				String usr2 = usr.nextLine();
				String nm2 = nm.nextLine();
				String srnm2 = srnm.nextLine();
				String dprt2 = dprt.nextLine();
				flag = true;
				Students stu = new Students(num, usr2, nm2,  srnm2, dprt2);
				System.out.println("Dimiourgithike to antikimeno ths klasis Students ths opoias ta xaraktiristika einai o arithmos mitroou kai auta pou klironomisan apo tin Users");
			}
			catch(NumberFormatException e) {
				System.out.println("Edoses lathos mitroo");
				
				
			}catch (Exception e) {
				
			}
		}
		Users use = new Users();
		System.out.println("Dimiourgithike to antikimeno ths klasis Users tis opias ta xaraktiristika einai to username to onoma to epitheto to tmima kai o metritits twn xristwn");
		
		
		Professors pro = new Professors();
		System.out.println("Dimiourgithike to antikimeno ths klasis Professors ths ta xaraktiristika einai auta pou klironomei apo tin Users");
		Secretaries sec = new Secretaries();
		System.out.println("Dimiourgithike to antikimeno ths klasis Secretaries ths ta xaraktiristika einai auta pou klironomei apo tin Users");
		
	}
}
	

