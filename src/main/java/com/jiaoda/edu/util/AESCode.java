package com.jiaoda.edu.util;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AESCode {

	/// 默认密钥
	private static final String key = "FC72E7899C804EEC";

	/// 默认向量
	private static final String iv = "43C0EC5CECAD4396";

	/**
	 * 提供密钥ECB模式进行加密
	 * 
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String Encrypt(String sSrc) {
		byte[] decrypted = null;
		try {
			decrypted = sSrc.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return EncryptByte(decrypted);
	}

	/**
	 * 提供密钥ECB模式进行加密
	 * 
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String EncryptByte(byte[] decrypted) {
		String result = null;
		try {
			byte[] key = AESCode.key.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(decrypted);
			result = Base64.encodeBase64String(encrypted);// 此处使用base64做转码功能，同时能起到2次加密的作用。
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提供密钥ECB模式进行解密
	 * 
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String Decrypt(String sSrc) {
		byte[] encrypted = Base64.decodeBase64(sSrc);
		return DecryptByte(encrypted);
	}

	/**
	 * 提供密钥ECB模式进行解密
	 * 
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String DecryptByte(byte[] encrypted) {
		String result = null;
		try {
			byte[] key = AESCode.key.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] original = cipher.doFinal(encrypted);
			result = new String(original, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提供密钥和向量进行加密
	 * 
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String EncryptIv(String param) {
		String result = null;
		try {
			byte[] key = AESCode.key.getBytes("utf-8");
			byte[] iv = AESCode.iv.getBytes("utf-8");
			result = AESCode.Encrypt(param, key, iv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提供密钥和向量进行解密
	 * 
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String DecryptIv(String param) {
		String result = null;
		try {
			byte[] key = AESCode.key.getBytes("utf-8");
			byte[] iv = AESCode.iv.getBytes("utf-8");
			result = Decrypt(param, key, iv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提供密钥和向量进行加密
	 * 
	 * @param sSrc
	 * @param key
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static String Encrypt(String sSrc, byte[] key, byte[] iv) {
		String result = null;
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
			IvParameterSpec _iv = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			result = Base64.encodeBase64String(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提供密钥和向量进行解密
	 * 
	 * @param sSrc
	 * @param key
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static String Decrypt(String sSrc, byte[] key, byte[] iv) {
		String result = null;
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec _iv = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
			byte[] encrypted = Base64.decodeBase64(sSrc);
			byte[] original = cipher.doFinal(encrypted);
			result = new String(original, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 使用密钥进行加密
	 * 
	 * @param sSrc
	 * @param keyStr
	 * @return
	 * @throws Exception
	 */
	public static String Encrypt(String sSrc, String keyStr) {
		if (keyStr == null) {
			return Encrypt(sSrc);
		}
		String result = null;
		try {
			byte[] key = keyStr.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			result = Base64.encodeBase64String(encrypted);// 此处使用base64做转码功能，同时能起到2次加密的作用。
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 使用密钥进行解密
	 * 
	 * @param sSrc
	 * @param keyStr
	 * @return
	 * @throws Exception
	 */
	public static String Decrypt(String sSrc, String keyStr) {
		if (keyStr == null) {
			return Decrypt(sSrc);
		}
		String result = null;
		try {
			byte[] key = keyStr.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted = Base64.decodeBase64(sSrc);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted);
			result = new String(original, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 提供密钥和向量进行解密
	 * 
	 * @param sSrc
	 * @param key
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static String Decrypt(String sSrc, String sKey, String sIv) {
		// 被加密的数据
		byte[] dataByte = Base64.decodeBase64(sSrc);
		// 加密秘钥
		byte[] keyByte = Base64.decodeBase64(sKey);
		// 偏移量
		byte[] ivByte = Base64.decodeBase64(sIv);
		// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
		int base = 16;
		if (keyByte.length % base != 0) {
			int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
			byte[] temp = new byte[groups * base];
			Arrays.fill(temp, (byte) 0);
			System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
			keyByte = temp;
		}
		String result = null;
		try {
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters _iv = AlgorithmParameters.getInstance("AES");
			_iv.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, _iv);
			byte[] original = cipher.doFinal(dataByte);
			result = new String(original, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}