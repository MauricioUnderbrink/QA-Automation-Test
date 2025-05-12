package testcoreutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialReader {

private static Properties properties;

    /**
     * This method gets the credential properties from the properties file.
     */
    static {
    try {
        FileInputStream authFile = new FileInputStream("src/main/java/resources/credentials.properties");
        properties = new Properties();
        properties.load(authFile);
    } catch (IOException e) {
        throw new RuntimeException("Failed to load credentials file", e);
    }
}

    /**
     * This method returns the username from the properties file based on the given user type.
     * @param userType The user type to get the username from.
     * @return the username of the user.
     */
    public static String getUserName(String userType){
        return properties.getProperty(userType + ".username");
    }

    /**
     * This method returns the user's password from the properties file based on the given user type.
     * @param userType The user type to get the username from.
     * @return the user's password.
     */
    public static String getPassword(String userType){

    return properties.getProperty(userType + ".password");

}

}
