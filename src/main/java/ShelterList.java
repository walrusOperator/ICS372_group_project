import org.json.simple.*;
import org.json.simple.JSONObject;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

public class ShelterList {
//    public static void main(String[] args) {
//
//    }

    public static void addIncoming() {
        JSONArray j = Utilities.readJSON();

        j.forEach( animal -> parseAnimalObject( (JSONObject) animal));

//        return Utilities.readJSON();

//        TODO: Get JSON array from utilities
//        TODO: for each loop passing shelter ID to createShelter()
//        TODO: for each loop of shelter objects to populate with matching animals
//        TODO: method to return shelters by ShelterID
    }
    private static void parseAnimalObject(JSONObject animal){
        JSONObject animalObject = animal;

        String shelter_id = (String) animalObject.get("shelter_id");
        System.out.println(shelter_id);
        String animal_type = (String) animalObject.get("animal_type");
        System.out.println(animal_type);
        String animal_name = (String) animalObject.get("animal_name");
        System.out.println(animal_name);
        String animal_id = (String) animalObject.get("animal_id");
        System.out.println(animal_id+"\n");
//        float animal_weight = (float) animalObject.get("weight");
//        System.out.println(animal_weight);
//        int receipt_date = (int) animalObject.get("receipt_date");
//        System.out.println(receipt_date+"\n");

    }

}
