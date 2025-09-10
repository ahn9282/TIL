package solid_ex.srp.compliant;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private EmailService emailService = new EmailService();
    private UserActivityLogger userActivityLogger = new UserActivityLogger();

    public void registerUser(User user) {
        userRepository.saveUser(user);
        emailService.sendWelcomeEmail(user);
        userActivityLogger.logUserActivity(user);
    }
}