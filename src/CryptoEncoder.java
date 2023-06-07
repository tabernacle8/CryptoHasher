package cryptoRunner;

import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CryptoEncoder
{
    public static String version;
    private static boolean crossVersionCompatiable;
    
    static {
        CryptoEncoder.version = Main.version;
        CryptoEncoder.crossVersionCompatiable = false;
    }
    
    public static String ComplexHash(final String number, final String salt, final String content) {
        if (!verifyInputs(false, number, salt, content, "")) {
            return "Error: Password field left blank";
        }
        String readyToHash = "";
        if (CryptoEncoder.crossVersionCompatiable) {
            readyToHash = String.valueOf(number) + content + number + salt;
        }
        else {
            readyToHash = String.valueOf(number) + content + number + salt + CryptoEncoder.version;
        }
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(readyToHash.getBytes(StandardCharsets.UTF_8));
            String hexStr = "";
            byte[] array;
            for (int length = (array = hash).length, i = 0; i < length; ++i) {
                final byte element = array[i];
                hexStr = String.valueOf(hexStr) + Integer.toString((element & 0xFF) + 256, 16).substring(1);
            }
            hexStr = String.valueOf(hexStr) + CryptoEncoder.version;
            return hexStr;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Failed to hash! Check your inputs and try again. :(";
        }
    }
    
    public static boolean VerifyComplexHash(final String number, final String content, final String salt, final String expected) {
        String readyToHash = "";
        if (CryptoEncoder.crossVersionCompatiable) {
            readyToHash = String.valueOf(number) + content + number + salt;
        }
        else {
            readyToHash = String.valueOf(number) + content + number + salt + CryptoEncoder.version;
        }
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(readyToHash.getBytes(StandardCharsets.UTF_8));
            String hexStr = "";
            byte[] array;
            for (int length = (array = hash).length, i = 0; i < length; ++i) {
                final byte element = array[i];
                hexStr = String.valueOf(hexStr) + Integer.toString((element & 0xFF) + 256, 16).substring(1);
            }
            hexStr = String.valueOf(hexStr) + CryptoEncoder.version;
            return hexStr.equals(expected);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean verifyInputs(final boolean typeVerify, final String number, final String salt, final String content, final String expectedHash) {
        if (!typeVerify) {
            return !content.equals("");
        }
        return !content.equals("") && !expectedHash.equals("");
    }
}
