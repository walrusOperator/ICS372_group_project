import java.io.*;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Utilities {

    // reads in a JSON file and converts into a JSON object
    public JSONObject readJSON(){
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

    public static void writeJSON(List shelters){
//        TODO: After shelter and animal classes created build
    }


}
