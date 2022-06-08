import org.json.simple.*;
import org.json.simple.JSONObject;

import java.util.*;

public class ShelterList {
    Map<String, Shelter> mapOfShelters = new HashMap<>();

    public void addIncoming() {
        JSONArray j = Utilities.readJSON();
        j.forEach( animal -> parseAnimalObject( (JSONObject) animal));
//        List temp = mapOfShelters.get("12513").getAnimalList();
//        System.out.println(temp);
    }

    private void parseAnimalObject(JSONObject animal) {

        String shelter_id = (String) animal.get("shelter_id");
        String animal_type = (String) animal.get("animal_type");
        String animal_name = (String) animal.get("animal_name");
        String animal_id = (String) animal.get("animal_id");
        Object temp = animal.get("weight");
        Double animal_weight = 0.0;
        if(temp instanceof Double){
            animal_weight = (Double) temp;
        } else {
            animal_weight = ((Long) temp).doubleValue();
        }
        long receipt_date = (long) animal.get("receipt_date");
//        System.out.println(receipt_date + "\n");
//        System.out.println(shelter_id);
//        System.out.println(animal_type);
//        System.out.println(animal_name);
//        System.out.println(animal_id+"\n");
//        System.out.println(animal_weight);
        //Validation that animal is allowed
        if (animal_type.equalsIgnoreCase("dog") || animal_type.equalsIgnoreCase("cat") ||
                animal_type.equalsIgnoreCase("bird") || animal_type.equalsIgnoreCase("rabbit")) {

                Animal tempAnimal = new Animal(animal_type, animal_name, animal_id, animal_weight, receipt_date);
                if (!(mapOfShelters.containsKey(shelter_id))) {
                    Shelter tempShelter = new Shelter(shelter_id);
                    mapOfShelters.put(shelter_id, tempShelter);
                }
                Shelter tempShelter = mapOfShelters.get(shelter_id);
                List tempAnimalList = tempShelter.getAnimalList(); //get current list from shelter object in map
                tempAnimalList.add(tempAnimal); //add new animal to list
                tempShelter.setAnimalList(tempAnimalList); //set revised animal list into Shelter Object
                mapOfShelters.put(shelter_id, tempShelter); //replace previous map entry with updated key value pair.
        }
    }
}
