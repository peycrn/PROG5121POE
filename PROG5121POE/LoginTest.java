import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    //USERNAME TESTS
    @Test
    public void testCheckUserNameCorrect() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    //PASSWORD TESTS 
    @Test
    public void testPasswordComplexityCorrect() {
        Login login = new Login("Test", "User");
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordComplexityIncorrect() {
        Login login = new Login("Test", "User");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    //CELLPHONE TESTS 
    @Test
    public void testCellPhoneCorrect() {
        Login login = new Login("Test", "User");
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrect() {
        Login login = new Login("Test", "User");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    //REGISTRATION TESTS -
    @Test
    public void testRegisterUserAllCorrect() {
        Login login = new Login("Kyle", "Smith");
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("User registered successfully!", result);
    }

    @Test
    public void testRegisterUserBadUsername() {
        Login login = new Login("Kyle", "Smith");
        String result = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testRegisterUserBadPassword() {
        Login login = new Login("Kyle", "Smith");
        String result = login.registerUser("kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testRegisterUserBadCell() {
        Login login = new Login("Kyle", "Smith");
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.", result);
    }

    //LOGIN FEATURE TESTS 
    @Test
    public void testLoginSuccess() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertEquals("Welcome Kyle Smith, it is great to see you again.",
                     login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "wrong"));
        assertEquals("Username or password incorrect, please try again.",
                     login.returnLoginStatus("wrong", "wrong"));
    }
}
