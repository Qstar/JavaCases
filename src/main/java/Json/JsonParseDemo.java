package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParseDemo {

    private static final String filePath = "/Users/Qstar/spring/JavaDemo/src/Json/jsonDemoFile.json";

    public static void main(String[] args) {

        try {
            // read the json file
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // get a number from the JSON object
            Long id = (Long) jsonObject.get("id");
            System.out.println("The id is: " + id);

            // get a String from the JSON object
            String type = (String) jsonObject.get("type");
            System.out.println("The type is: " + type);

            // get a String from the JSON object
            String name = (String) jsonObject.get("name");
            System.out.println("The name is: " + name);

            // get a number from the JSON object
            Double ppu = (Double) jsonObject.get("ppu");
            System.out.println("The PPU is: " + ppu);

            // get an array from the JSON object
            System.out.println("Batters:");
            JSONArray batterArray = (JSONArray) jsonObject.get("batters");

            // take each value from the json array separately
            for (Object aBatterArray : batterArray) {
                JSONObject innerObj = (JSONObject) aBatterArray;
                System.out.println("ID " + innerObj.get("id") +
                        " type " + innerObj.get("type"));
            }

            // get an array from the JSON object
            System.out.println("Topping:");
            JSONArray toppingArray = (JSONArray) jsonObject.get("topping");
            // take each value from the json array separately
            for (Object aToppingArray : toppingArray) {
                JSONObject innerObj = (JSONObject) aToppingArray;
                System.out.println("ID " + innerObj.get("id") +
                        " type " + innerObj.get("type"));
            }

        } catch (NullPointerException | ParseException | IOException ex) {
            ex.printStackTrace();
        }

    }

}