package util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class WhiteListControl {

    private HttpServletRequest servletRequest;

    public WhiteListControl(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public boolean isRequestAuthorized() throws IOException {
        return Arrays.asList(getWhiteListedArray()).contains(servletRequest.getRemoteAddr());
    }

    private String[] getWhiteListedArray() throws IOException {
        String key = "whitelisted.ip";
        Properties properties = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (input != null) {
            properties.load(input);
            return properties.getProperty(key).split(";");
        }
        return new String[0];
    }

}
