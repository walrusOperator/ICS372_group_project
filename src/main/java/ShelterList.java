import org.json.simple.*;
import org.json.simple.JSONObject;

import java.util.*;

public class ShelterList {
    Map<String, Shelter> mapOfShelters = new HashMap<>();

    public void addIncoming() {
        JSONArray j = Utilities.readJSON();
//      https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
        j.forEach( animal -> parseAnimalObject( (JSONObject) animal));
    }

    //consider moving method to animal class.
    private void parseAnimalObject(JSONObject animal) {
        String shelter_id = (String) animal.get("shelter_id");
        String animal_type = (String) animal.get("animal_type");
        String animal_name = (String) animal.get("animal_name");
        String animal_id = (String) animal.get("animal_id");
        Object temp = animal.get("weight");
        double animal_weight;
        if(temp instanceof Double){
            animal_weight = (Double) temp;
        } else {
            animal_weight = ((Long) temp).doubleValue();
        }
        long receipt_date = (long) animal.get("receipt_date");
        if (validAnimal(animal_type)) {
                Animal tempAnimal = new Animal(animal_type, animal_name, animal_id, animal_weight, receipt_date);
                if (!(mapOfShelters.containsKey(shelter_id))) {
                    Shelter tempShelter = new Shelter(shelter_id);
                    mapOfShelters.put(shelter_id, tempShelter);
                }
                Shelter tempShelter = mapOfShelters.get(shelter_id);
                List<Animal> tempAnimalList = tempShelter.getAnimalList(); //get current list from shelter object in map
                tempAnimalList.add(tempAnimal); //add new animal to list
                tempShelter.setAnimalList(tempAnimalList); //set revised animal list into Shelter Object
                mapOfShelters.put(shelter_id, tempShelter); //replace previous map entry with updated key value pair.
        }
    }

    public void showShelters(){
        System.out.println(mapOfShelters.values());
    }

    public boolean containsShelter(String id){
        return mapOfShelters.containsKey(id);
    }

    public Shelter getShelter(String id){
        return mapOfShelters.get(id);
    }

    public Collection<Shelter> getShelters(){
        return mapOfShelters.values();}

    public boolean validAnimal(String type){
        if(type.equalsIgnoreCase("dog") || type.equalsIgnoreCase("cat") ||
                type.equalsIgnoreCase("bird") || type.equalsIgnoreCase("rabbit")){
            return true;
        }
        return false;
    }
}
