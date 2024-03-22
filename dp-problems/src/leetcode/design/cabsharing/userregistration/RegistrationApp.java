package leetcode.design.cabsharing.userregistration;

public class RegistrationApp {

    public static void main(String[] args) {
        UserManager userManager = new RiderRegistrationManager();
        userManager.register();
    }
}
