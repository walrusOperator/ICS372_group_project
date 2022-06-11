import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

    public static void writeJSON(ShelterList roster){
//        TODO: After shelter and animal classes created build
        JSONArray sheltersToWrite = new JSONArray();
        JSONObject fileData = new JSONObject();
        List<Shelter> allShelters =  new ArrayList<Shelter>(roster.getShelters());

        for (int i = 0; i < allShelters.size(); i++) {
            Shelter currentShelter = allShelters.get(i);

            for (int j = 0; j < currentShelter.size(); j++) {
                Animal currentAnimal = currentShelter.getAnimalList().get(j);
                JSONObject currentAnimalData = new JSONObject();

                currentAnimalData.put("shelter_id", currentShelter.toString());
                currentAnimalData.put("animal_type", currentAnimal.getAnimal_Type());
                currentAnimalData.put("animal_name", currentAnimal.getAnimal_Name());
                currentAnimalData.put("animal_id", currentAnimal.getAnimal_ID());
                currentAnimalData.put("weight", currentAnimal.getAnimal_weight());
                currentAnimalData.put("receipt_date", currentAnimal.getReceipt_date());

                sheltersToWrite.add(currentAnimalData);
            }
        }
        fileData.put("shelter_roster", sheltersToWrite);

        try(FileWriter file = new FileWriter("Project1_output.json")){
            file.write(fileData.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
