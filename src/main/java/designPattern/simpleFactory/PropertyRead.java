package designPattern.simpleFactory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyRead {
    public Map<String, String> getProperties() {
        Map<String, String> map = new HashMap<String, String>();
        Properties props = new Properties();
        try {
            InputStream in = getClass().getResourceAsStream("property.type");
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String property = props.getProperty(key);
                map.put(key, property);
                System.out.println(key + " " + property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
