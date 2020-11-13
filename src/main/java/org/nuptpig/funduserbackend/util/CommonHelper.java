package org.nuptpig.funduserbackend.util;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.security.SecureRandom;
import java.util.Random;

public class CommonHelper {
    public static String generateSalt(){
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        return new BASE64Encoder().encode(salt);
    }
    public static void main(String[] args) {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        String encodedSalt = new BASE64Encoder().encode(salt);
        System.out.println(encodedSalt);

        String password = "admin";
        password = HashHelper.md5Hash(password);
        password = HashHelper.sha512Hash(password, encodedSalt);
        System.out.println(password);
    }
}
