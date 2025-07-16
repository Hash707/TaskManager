package task.manager.main;

import task.manager.utility.DBUtil;
import task.manager.utility.PasswordUtility;

public class Main {

	public static void main(String[]args) {
		
		
		String original = "somethig";
		String encrypted = PasswordUtility.encryptPassword("arsh");
		
		System.out.println(encrypted + " : " + original);
		
		DBUtil util = new DBUtil();
		
	}
	
}
