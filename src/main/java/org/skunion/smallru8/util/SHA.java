package org.skunion.smallru8.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	
	public static String SHA1(String input) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(input.getBytes("utf-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return String.format("%040x", new BigInteger(1, digest.digest()));
	}
	
	public static String SHA256(String input) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf-8"));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return String.format("%064x", new BigInteger(1, digest.digest()));
	}
	
	public static String SHA512(String input) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(input.getBytes("utf-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return String.format("%0128x", new BigInteger(1, digest.digest()));
	}
	
}
