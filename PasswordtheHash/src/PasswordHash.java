import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class PasswordHash {
    private String password;
    private String salt;

    PasswordHash(String password)
    {
        this.password = password;
        this.salt = generateSalt();
    }

    public String encrypt() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(salt.getBytes());
        messageDigest.update(password.getBytes());
        return bytesToHex(messageDigest.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes)
        {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public String getSalt() {
        return this.salt;
    }

    private String generateSalt() {
        byte[] bytes = new byte[20];
        new Random().nextBytes(bytes);
        return new String(Base64.getEncoder().encode(bytes));
    }
}
