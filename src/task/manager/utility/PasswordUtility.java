package task.manager.utility;

import java.security.MessageDigest;

public class PasswordUtility {

	// Using hashing for the passwords instead of the encryption as it is more secure.
	public static String encryptPassword(String originalPassword) {
		
		StringBuilder b = new StringBuilder();
		
		try {
			// SHA-256 -> Simple Hashing Algorithm 256 is used here.
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashbytes = md.digest(originalPassword.getBytes("UTF-8"));
			
			for(byte c : hashbytes) {
				b.append(String.format("%02x", c));
			}
			
			return b.toString();
		} catch (Exception e) {
			System.out.println("Can't initiate the algorithm");
			e.printStackTrace();
			return b.toString();
		}
	}
	
	
}
