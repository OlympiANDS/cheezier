package org.academiadecodigo.olympiands.badromance.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A security implementation for password security
 */
public class Security {

    private final static String ALGORITHM = "SHA";

    /**
     * A hashcode generator for passwords
     * @param message password to be encrypted
     * @return encrypted password
     */
    public static String getHash(String message){
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);

            md.reset();;
            md.update(message.getBytes());
            byte[] digest = md.digest();

            BigInteger bigInt = new BigInteger(1, digest);
            StringBuilder hashText = new StringBuilder(bigInt.toString(16));


            while (hashText.length() < 32){
                hashText.insert(0, "0");
            }

            return hashText.toString();
        } catch (NoSuchAlgorithmException ex){
            return message;
        }
    }
}
