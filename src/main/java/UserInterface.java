import java.util.Scanner;

public class UserInterface {
    static Scanner scan = new Scanner(System.in);

    public static int userOption(){
        Scanner scan = new Scanner(System.in);
            int userOption = scan.nextInt();
            return userOption;
    }

    public static void printMenu(){
        System.out.println("Please choose from the following options:\n" +
                "1: Import json of animals\n" +
                "2: Add additional incoming animal\n" +
                "3: Enable receiving animals\n" +
                "4: Disable receiving animals\n" +
                "5: See animals in a shelter\n" +
                "6: See animals in ALL shelters\n" +
                "7: Export json file");
    }

    public static String shelterSelection(){
        System.out.println("Please select a shelter: ");
        String selected;
        selected = scan.nextLine();
        return selected;
    };

    public static void userMenu(int userOption, ShelterList shelterMap) {

        String selected;

        switch (userOption) {
            //call to add all shelters and animals from JSON file
            case 1:
                shelterMap.addIncoming();
                break;

            //validate shelter ID, if shelter exists create Animal object and add to existing Shelter object
            case 2:
                shelterMap.showShelters();
                selected = shelterSelection();
                if(ShelterList.shelterSearch(selected, shelterMap)) {
                    Animal newAnimal = Animal.createNewAnimal(shelterMap);
                    if(newAnimal != null) {
                        Shelter.addUserCreatedAnimal(newAnimal, selected, shelterMap);
                    }
                }
                break;

            //Check for existing shelter, if exists update shelter to accept incoming animals
            case 3:
                shelterMap.showShelters();
                selected = shelterSelection();
                if(ShelterList.shelterSearch(selected, shelterMap)) {
                    Shelter.changeReceiving(selected, true);
                }
                break;

            //Check for existing shelter, if exists update shelter to deny incoming animals
            case 4:
                shelterMap.showShelters();
                selected = shelterSelection();
                if(ShelterList.shelterSearch(selected, shelterMap)) {
                    Shelter.changeReceiving(selected, false);
                }
                break;

            //validate that shelter exists, print all objects contained in shelter object
            case 5:
                shelterMap.showShelters();
                selected = shelterSelection();
                if(ShelterList.shelterSearch(selected, shelterMap)){
                    System.out.println(shelterMap.getShelter(selected).showAnimals());
                }
                break;

            //call method to display all Animal objects to console by shelter
            case 6:
                ShelterList.showAllAnimals(shelterMap);
                break;

            //call Utilities method to create a JSON file of the shelterMap hashmap
            case 7:
                Utilities.writeJSON(shelterMap);
                break;
        }
    }

}
