package test;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Precondition {
    private WebDriver webDriver;
    private TestUser testUser;

    public TestUser getTestUser() {
        return testUser;
    }

    public Precondition(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.initProperties();
    }


    private void initProperties (){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
           this.testUser = new TestUser();
           this.testUser.setUserLogin(properties.getProperty("userLogin"));
           this.testUser.setUserPassword(properties.getProperty("userPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class TestUser {
        private String userLogin;
        private String userPassword;

        public void setUserLogin(String userLogin) {
            this.userLogin = userLogin;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
        public String getUserLogin() {
            return userLogin;
        }
        public String getUserPassword() {
            return userPassword;
        }
    }
}

