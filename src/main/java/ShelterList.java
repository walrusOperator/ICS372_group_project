import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShelterList {
    public static void main(String[] args) {
        List shelters = new ArrayList<JSONObject>();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please choose from the following options:\n" +
                "1: add incoming animals\n" +
                "2: enable receiving animals\n" +
                "3: disable receiving animals\n" +
                "4: export json file\n");
        int userOption = scan.nextInt();
        switch (userOption){
            case 1:
                Utilities.readJSON();
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
