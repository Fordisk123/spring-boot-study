package henryhui.site.study.core.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Random;

public class PasswordUtils {

    public static String encode(String password, String salt) throws Exception {
        if (salt == null) {
            throw new Exception("Password can't be empty!");
        }
        if (salt.length() != 16) {
            throw new Exception("Salt value must be 16 bits\n");
        }
        byte[] raw = salt.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(password.getBytes("utf-8"));

        return new String(Base64.getEncoder().encode(encrypted));
    }

    public static String decode(String password , String salt) throws Exception{
        if (salt == null) {
            throw new Exception("Password can't be empty!");
        }
        if (salt.length() != 16) {
            throw new Exception("Salt value must be 16 bits\n");
        }
        byte[] raw = salt.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(password.getBytes()));
        String originalString = new String(original,"utf-8");
        return originalString;
    }

    public static String getCKey(int n) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equalsIgnoreCase(str)) { // 产生字母
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) (nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(str)) { // 产生数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        String passwd = "test";
        String slat = "156TS2d95jO997hS";
        System.out.println(PasswordUtils.encode(passwd , slat));
        System.out.println(PasswordUtils.encode("admin" , slat));
            System.out.println(PasswordUtils.encode("admin" , "R3RpK750B8h84wm2"));
        System.out.println(PasswordUtils.decode(PasswordUtils.encode(passwd , slat) , slat));

        System.out.println(PasswordUtils.getCKey(16));
    }
}
