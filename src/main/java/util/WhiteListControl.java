package util;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class WhiteListControl {

    public boolean isRequestAuthorized(HttpServletRequest servletRequest) {
        return Arrays.asList(getWhiteListedArray()).contains(servletRequest.getRemoteAddr());
    }

    private String[] getWhiteListedArray()  {
        String key = "whitelisted.ip";
        Properties properties = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (input != null) {

            try {
                properties.load(input);
                return properties.getProperty(key).split(";");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return new String[0];
    }

}
