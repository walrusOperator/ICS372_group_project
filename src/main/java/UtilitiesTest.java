import java.io.*;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.*;
public class UtilitiesTest {
    public static void main(String[] args){
        JSONArray smallArray = Utilities.readJSON();

        for (int i = 0; i < smallArray.size(); i++) {
            JSONObject loc = (JSONObject) smallArray.get(i);
            System.out.println("Shelter: " + loc.get("shelter_id"));
            System.out.println("Type: " + loc.get("animal_type"));
            System.out.println("Name: " + loc.get("animal_name"));
            System.out.println("ID: " + loc.get("animal_id"));
            System.out.println("Weight: " + loc.get("weight"));
            System.out.println("Date Received: " + loc.get("receipt_date") + "\n");
        }
    }
}
