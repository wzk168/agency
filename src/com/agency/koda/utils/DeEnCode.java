package com.agency.koda.utils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 加密/解密类
 * 
 * @author Waco
 *
 */
public class DeEnCode {
	private static final String key0 = "BLOGISTICS()*&<EBANG";
	private static final Charset charset = Charset.forName("UTF-8");
	private static byte[] keyBytes = key0.getBytes(charset);

	/**
	 * 加密
	 * 
	 * @param enc
	 * @return
	 */
	public static String encode(String enc) {
		byte[] b = enc.getBytes(charset);
		for (int i = 0, size = b.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				b[i] = (byte) (b[i] ^ keyBytes0);
			}
		}
		return new sun.misc.BASE64Encoder().encodeBuffer(b).trim();
	}

	/**
	 * 解密
	 * 
	 * @param dec
	 * @return
	 * @throws IOException
	 */
	public static String decode(String dec) {
		byte[] e;
		try {
			e = new sun.misc.BASE64Decoder().decodeBuffer(dec);
			byte[] dee = e;
			for (int i = 0, size = e.length; i < size; i++) {
				for (byte keyBytes0 : keyBytes) {
					e[i] = (byte) (dee[i] ^ keyBytes0);
				}
			}
			return new String(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}
