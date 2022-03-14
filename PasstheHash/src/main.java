import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "arad4228as";
        String result;
        PasswordHash SHA256 = new PasswordHash(password);
        result = SHA256.encrypt();
        System.out.println("Originam Password is:"+ password);
        System.out.println("Hashed Password is:"+result);
    }
}
