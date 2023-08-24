package security;

public interface PasswordEncryptor {
    String encryptPassword(String password);
    boolean isPasswordValid(String inputPassword, String storedPassword);
}
