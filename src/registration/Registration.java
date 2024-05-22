/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;

/**
 *
 * @author lab_services_student
 */
import javax.swing.JOptionPane;

public class Registration {
    String name;
    String surname;
    String username;
    String password;
    int validUsername;
    int validPassword;

    // Validate Username
    public boolean checkUserName(String username) {
        boolean valid = false;
        boolean unSc = false;
        int c = 0;
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '_') {
                unSc = true;
            }
            c++;
        }
        if (unSc && c <= 5) {
            valid = true;
            JOptionPane.showMessageDialog(null, "Username successfully captured");
            validUsername++;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure username contains an underscore and is no more than 5 characters in length");
        }
        return valid;
    }

    // Password Validation
    public boolean checkPasswordComplexity(String password) {
        boolean containsCapitalLetter = false;
        boolean containsNumber = false;
        boolean containsSpecialChar = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    containsCapitalLetter = true;
                } else if (Character.isDigit(ch)) {
                    containsNumber = true;
                } else if (!Character.isLetterOrDigit(ch)) {
                    containsSpecialChar = true;
                }
            }
        }

        if (containsCapitalLetter && containsNumber && containsSpecialChar) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
            validPassword++;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return false;
        }
    }

    // User Registration
    public void registerUser() {
        name = JOptionPane.showInputDialog("Enter your name:");
        surname = JOptionPane.showInputDialog("Enter your surname:");
        username = JOptionPane.showInputDialog("Enter your username:");
        password = JOptionPane.showInputDialog("Enter your password:");

        if (checkUserName(username) && checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Registration successful");
        } else {
            JOptionPane.showMessageDialog(null, "Registration unsuccessful");
        }
    }

    // User Login
    public boolean loginUser(String username, String password) {
        String usernameVerify = JOptionPane.showInputDialog("To login, please enter your username:");
        String passwordVerify = JOptionPane.showInputDialog("To login, please enter your password:");

        if (usernameVerify.equals(username) && passwordVerify.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + name + " " + surname + ". It is great to see you again");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
            return false;
        }
    }

    // Return login status
    public void returnLoginStatus() {
        if (loginUser(username, password)) {
            JOptionPane.showMessageDialog(null, "User Status: Logged In");
        } else {
            JOptionPane.showMessageDialog(null, "User Status: Not Logged In");
        }
    }

    public static void main(String[] args) {
        Registration userAuth = new Registration();
        userAuth.registerUser();
        userAuth.returnLoginStatus();
    }
}
