package main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Helpers {
	
	/**
	 * The method creates a hashcode for every password 
	 * given as input. The hashcode is almost unique and 
	 * it is impossible to check the actual password or 
	 * go back to it from the hashcode.
	 * @param input
	 * @return md5
	 */
	public static String hashingPassword(String input) {
		String md5 = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return md5;
	}
}