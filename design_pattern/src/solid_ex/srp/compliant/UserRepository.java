package solid_ex.srp.compliant;

public class UserRepository {
    public void saveUser(User user) {
        // Save user to database
        System.out.println("User saved to database: " + user.getName());
    }
}