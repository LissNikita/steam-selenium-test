package pageobjects;
import java.io.*;
import java.util.Properties;

public class Property {


    public static String getPropertyValue(String propertyName){
        String propertyValue = "";
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream("C:\\Users\\drago\\IdeaProjects\\steamTesting\\src\\test\\resources\\config.properties")){
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        }catch (IOException e){
            System.out.println(e);
        }
        return propertyValue;
    }
}
