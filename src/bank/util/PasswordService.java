package bank.util;

import java.util.Base64;

public interface PasswordService {

    static String encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    static boolean login(String password, String encodedPassword) {
        String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword));
        return password.equals(decodedPassword);
    }
}
