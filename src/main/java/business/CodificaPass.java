package business;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class CodificaPass  {
    public CodificaPass(){
    }

    public String toHash (String password) throws NoSuchAlgorithmException {
        String hashString = null;
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            hashString = "";
            for (int i = 0; i < hash.length; i++) {
                hashString += Integer.toHexString(
                        (hash[i] & 0xFF) | 0x100
                ).substring(1, 3);
            }
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return hashString;
    }
}

