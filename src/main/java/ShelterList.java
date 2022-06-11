import org.json.simple.*;
import org.json.simple.JSONObject;

import java.util.*;

public class ShelterList {
    Map<String, Shelter> mapOfShelters = new HashMap<>();

    public void addIncoming() {
        JSONArray j = Utilities.readJSON();
        j.forEach( animal -> parseAnimalObject( (JSONObject) animal));
//        Shelter temp = mapOfShelters.get("12513");

    }

    private void parseAnimalObject(JSONObject animal) {

        String shelter_id = (String) animal.get("shelter_id");
        String animal_type = (String) animal.get("animal_type");
        String animal_name = (String) animal.get("animal_name");
        String animal_id = (String) animal.get("animal_id");
        Object temp = animal.get("weight");
        Double animal_weight;
        if(temp instanceof Double){
            animal_weight = (Double) temp;
        } else {
            animal_weight = ((Long) temp).doubleValue();
        }
        long receipt_date = (long) animal.get("receipt_date");

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

    public void addShelter(String id){
        mapOfShelters.put(id, new Shelter(id));
    }

    public void showShelters(){
        System.out.println(mapOfShelters.values());
    }

    public boolean containsShelter(String id){
        if(mapOfShelters.containsKey(id)) {
            return true;
        }
        return false;
    }

    public Shelter getShelter(String id){
        return mapOfShelters.get(id);
    }

    public int size(){
        return mapOfShelters.size();}

    public Collection<Shelter> getShelters(){
        return mapOfShelters.values();}
}
