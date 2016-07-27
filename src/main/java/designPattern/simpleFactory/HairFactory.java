package designPattern.simpleFactory;

import java.util.Map;

public class HairFactory {
    public HairInterface getHairByString(String hairName) {
        if ("left".equals(hairName)) {
            return new LeftHair();
        } else if ("right".equals(hairName)) {
            return new RightHair();
        } else if ("center".equals(hairName)) {
            return new CenterHair();
        }
        return null;
    }

    public HairInterface getHairByClassName(String className) {
        try {
            HairInterface hairInterface = (HairInterface) Class.forName(className).newInstance();
            return hairInterface;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HairInterface getHairByClassKey(String key) {
        try {
            Map<String, String> map = new PropertyRead().getProperties();
            HairInterface hairInterface = (HairInterface) Class.forName(map.get(key)).newInstance();
            return hairInterface;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
