package com.verizon.magento.util;

import org.mindrot.jbcrypt.BCrypt;

public class Utility {

	private Utility() {

	}

	public static String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public static boolean checkPass(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
}
