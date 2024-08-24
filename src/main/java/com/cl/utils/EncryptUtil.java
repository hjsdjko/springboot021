package com.cl.utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import cn.hutool.crypto.digest.DigestUtil;

public class EncryptUtil {
    
	/**
	 * md5算法
	 * @param text明文
	 * @param key密钥
	 * @return 密文
	 */
	// 带秘钥加密
	public static String md5(String text) {
        if(text==null) return null;
		// 加密后的字符串
		String md5str = DigestUtil.md5Hex(text);
		return md5str;
	}
	
	/**
	 * SHA-256算法
	 * @param text
	 * @return
	 * @throws Exception
	 */
    public static String sha256(String text) {
        if(text==null) return null;
    	StringBuilder stringBuilder = new StringBuilder();
        try {
			//获取SHA-256算法实例
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			//计算散列值
			byte[] digest = messageDigest.digest(text.getBytes());
			//将byte数组转换为15进制字符串
			for (byte b : digest) {
			    stringBuilder.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return stringBuilder.toString();
    }
    
    private static final String DES_ALGORITHM = "DES";

    /**
     * DES加密
     *
     * @param data 待加密的数据
     * @param key  密钥，长度必须为8位
     * @return 加密后的数据，使用Base64编码
     */
    public static String desEncrypt(String text) {
        if(text==null) return null;
        try {
            String key = "12345678";
			// 根据密钥生成密钥规范
			KeySpec keySpec = new DESKeySpec(key.getBytes());
			// 根据密钥规范生成密钥工厂
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
			// 根据密钥工厂和密钥规范生成密钥
			SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

			// 根据加密算法获取加密器
			Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
			// 初始化加密器，设置加密模式和密钥
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			// 加密数据
			byte[] encryptedData = cipher.doFinal(text.getBytes());
			// 对加密后的数据进行Base64编码
			return Base64.getEncoder().encodeToString(encryptedData);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        return null;
    }

    /**
     * DES解密
     *
     * @param encryptedData 加密后的数据，使用Base64编码
     * @param key 密钥，长度必须为8位
     * @return 解密后的数据
     */
    public static String desDecrypt(String text) {
        if(text==null) return null;
        try {
            String key = "12345678";
			// 根据密钥生成密钥规范
			KeySpec keySpec = new DESKeySpec(key.getBytes());
			// 根据密钥规范生成密钥工厂
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
			// 根据密钥工厂和密钥规范生成密钥
			SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

			// 对加密后的数据进行Base64解码
			byte[] decodedData = Base64.getDecoder().decode(text);
			// 根据加密算法获取解密器
			Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
			// 初始化解密器，设置解密模式和密钥
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			// 解密数据
			byte[] decryptedData = cipher.doFinal(decodedData);
			// 将解密后的数据转换为字符串
			return new String(decryptedData);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    private static final String AES_ALGORITHM = "AES";
    // AES加密模式为CBC，填充方式为PKCS5Padding
    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    // AES密钥为16位
    private static final String AES_KEY = "1234567890123456";
    // AES初始化向量为16位
    private static final String AES_IV = "abcdefghijklmnop";

    /**
     * AES加密
     *
     * @param data 待加密的数据
     * @return 加密后的数据，使用Base64编码
     */
    public static String aesEncrypt(String text) {
        if(text==null) return null;
        try {
			// 将AES密钥转换为SecretKeySpec对象
			SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), AES_ALGORITHM);
			// 将AES初始化向量转换为IvParameterSpec对象
			IvParameterSpec ivParameterSpec = new IvParameterSpec(AES_IV.getBytes());
			// 根据加密算法获取加密器
			Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
			// 初始化加密器，设置加密模式、密钥和初始化向量
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			// 加密数据
			byte[] encryptedData = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
			// 对加密后的数据使用Base64编码
			return Base64.getEncoder().encodeToString(encryptedData);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        return null;
    }

    /**
     * AES解密
     *
     * @param encryptedData 加密后的数据，使用Base64编码
     * @return 解密后的数据
     */
    public static String aesDecrypt(String text) {
        if(text==null) return null;
        try {
			// 将AES密钥转换为SecretKeySpec对象
			SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes(), AES_ALGORITHM);
			// 将AES初始化向量转换为IvParameterSpec对象
			IvParameterSpec ivParameterSpec = new IvParameterSpec(AES_IV.getBytes());
			// 根据加密算法获取解密器
			Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
			// 初始化解密器，设置解密模式、密钥和初始化向量
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
			// 对加密后的数据使用Base64解码
			byte[] decodedData = Base64.getDecoder().decode(text);
			// 解密数据
			byte[] decryptedData = cipher.doFinal(decodedData);
			// 返回解密后的数据
			return new String(decryptedData, StandardCharsets.UTF_8);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
        return null;
    }

}
