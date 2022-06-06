import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Utilities {

    // reads in a JSON file and converts into a JSON object
    public static JSONArray readJSON(){
        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("Project1_input.json"));
            return (JSONArray)obj.get("shelter_roster");
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
