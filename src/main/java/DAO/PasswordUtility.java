package DAO;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtility {

    // Mã hóa mật khẩu
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    // Kiểm tra mật khẩu
    public static boolean checkPassword(String plainTextPassword, String hashedPassword){
        if (hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
            return false; // Trả về false thay vì ném ngoại lệ
        }
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
