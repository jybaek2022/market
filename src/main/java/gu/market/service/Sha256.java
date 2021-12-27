package gu.market.service;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class Sha256 {
	public static String encrypt(String planText) {
		try {
			// MD2, MD4, MD5, SHA-1, SHA-256, SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(planText.getBytes());
			byte byteData[] = md.digest();
			return Hex.encodeHexString(byteData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

