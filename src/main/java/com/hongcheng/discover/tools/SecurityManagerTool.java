package com.hongcheng.discover.tools;


import com.hongcheng.discover.common.exception.BizException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密，解密
 */
public class SecurityManagerTool {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    private SecretKeySpec secretKey;

    public SecurityManagerTool(String secret) {init(secret.getBytes());}

    private void init(byte[] key) {
        this.secretKey = new SecretKeySpec(key,ALGORITHM);
    }

    public byte[] encrypt(byte[] content) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("加密失败",e);
        }
    }

    public byte[] decrypt(byte[] content) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
             throw new BizException("解密失败",e);
        }
    }

    public String encryptAndBase64(String content) {
        byte[] encryptedContent = encrypt(content.getBytes());
        return new Base64().encodeToString(encryptedContent);
    }

    public String decryptBase64String(String content) {
        byte[] decryptedContent = new Base64().decode(content.getBytes());
        return new String(decrypt(decryptedContent));
    }

    public static void main(String[] args) {
        SecurityManagerTool securityManager = new SecurityManagerTool("mysecretmysecret");
        String testStr = "1:hongchengw";

        String encryptStr = securityManager.encryptAndBase64(testStr);

        System.out.println(encryptStr);

        System.out.println(securityManager.decryptBase64String(encryptStr));
    }
}
