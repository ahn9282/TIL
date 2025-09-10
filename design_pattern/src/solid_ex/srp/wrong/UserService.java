package solid_ex.srp.wrong;

public class UserService {
    public void saveUser(User user) {
        // Save user to database
        System.out.println("User saved to database: " + user.getName());
    }

    public void sendWelcomeEmail(User user) {
        // Send welcome email to user
        System.out.println("Welcome email sent to: " + user.getEmail());
    }

    public void logUserActivity(User user) {
        // Log user activity
        System.out.println("Logging activity for user: " + user.getName());
    }
}