
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Topic_10_Properties {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        try (InputStream input = new FileInputStream(projectPath + "\\envConfig\\dev.properties")) {
            Properties prop = new Properties();

            //load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("App.Url"));
            System.out.println(prop.getProperty("App.User"));
            System.out.println(prop.getProperty("App.Pass"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}