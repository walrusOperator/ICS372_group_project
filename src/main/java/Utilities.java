import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Utilities {

    // reads in a JSON file and converts into a JSON object
    public static JSONObject readJSON(){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("whatever the file ends up being"));
            return (JSONObject) obj;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void writeJSON(){
//        TODO: After shelter and animal classes created build
    }


}
