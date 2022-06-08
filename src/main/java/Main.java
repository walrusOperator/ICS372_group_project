import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShelterList shelterMap = new ShelterList();
//        List shelters = new ArrayList<JSONObject>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Please choose from the following options:\n" +
                "1: Show current animals\n" +
                "2: add incoming animals\n" +
                "2: enable receiving animals\n" +
                "3: disable receiving animals\n" +
                "4: export json file\n");
        int userOption = scan.nextInt();
        switch (userOption){
            case 1:
                shelterMap.addIncoming();
//                TODO: provide feedback to user if successful
                break;
            case 2:
//                TODO: list shelters from shelter class to console.
//                TODO: have user select shelter
                break;
            case 3:
//                TODO: list shelters from shelter class to console.
//                TODO: have user select shelter
                break;
            case 4:
                Utilities.writeJSON();
//                TODO: provide user feedback
                break;
        }
    }

}

