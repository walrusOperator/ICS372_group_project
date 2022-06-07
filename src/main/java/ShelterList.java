import org.json.simple.*;
import org.json.simple.JSONObject;

import java.util.*;

public class ShelterList {
    Map<String, Shelter> mapOfShelters = new HashMap<>();

    public void addIncoming() {
//        Map<String, Shelter> listOfShelters = new HashMap<>();
        JSONArray j = Utilities.readJSON();
        j.forEach( animal -> parseAnimalObject( (JSONObject) animal));
    }

    private void parseAnimalObject(JSONObject animal){
//        TODO: create key using shelter id
//        TODO: value will contain the shelter object with an array of animal objects in an array
        String shelter_id = (String) animal.get("shelter_id");
        String animal_type = (String) animal.get("animal_type");
        String animal_name = (String) animal.get("animal_name");
        String animal_id = (String) animal.get("animal_id");
        double animal_weight = (double) animal.get("weight");
        long receipt_date = (long) animal.get("receipt_date");
        System.out.println(receipt_date+"\n");
//        System.out.println(shelter_id);
//        System.out.println(animal_type);
//        System.out.println(animal_name);
//        System.out.println(animal_id+"\n");
//        System.out.println(animal_weight);

        Animal tempAnimal = new Animal(animal_type, animal_name, animal_id, animal_weight, receipt_date);
        if(!(mapOfShelters.containsKey(shelter_id))) {
            Shelter tempShelter = new Shelter(shelter_id);
            mapOfShelters.put(shelter_id, tempShelter);
        }
        //            TODO: access list in shelter object, add animal


    }

}
