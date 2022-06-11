import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ShelterList shelterMap = new ShelterList();

    /**
     * Method controls flow of user input from console.
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Please choose from the following options:\n" +
                    "1: Import json of animals\n" +
                    "2: Add additional incoming animal\n" +
                    "3: Enable receiving animals\n" +
                    "4: Disable receiving animals\n" +
                    "5: See animals in a shelter\n" +
                    "6: See animals in ALL shelters\n" +
                    "7: Export json file");
            int userOption = scan.nextInt();
            scan.nextLine();
            userMenu(userOption);
        } while(true);
    }

    /**
     * Method directs program commands for user selection through switch case
     * @param userOption - (int) user selected value from main()
     */
    public static void userMenu(int userOption) {
            String selected;
            Scanner scan = new Scanner(System.in);

            switch (userOption) {
                case 1:
                    shelterMap.addIncoming();
                    break;

                case 2:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    if(shelterSearch(selected)) {
                        Animal newAnimal = createNewAnimal();
                        if(newAnimal != null) {
                            addUserCreatedAnimal(newAnimal, selected);
                        }
                    }
                    break;

                case 3:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    if(shelterSearch(selected)) {
                        changeReceiving(selected, true);
                    }
                    break;

                case 4:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    if(shelterSearch(selected)) {
                        changeReceiving(selected, false);
                    }
                    break;

                case 5:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    if(shelterSearch(selected)){
                        System.out.println(shelterMap.getShelter(selected).showAnimals());
                    }
                    break;
                case 6:
                    showAllAnimals();

                    break;
                case 7:
                    Utilities.writeJSON(shelterMap);
                    break;
            }
        }

    /**
     * Method responsible for verifying that a shelter exists and is accepting new Animal objects
     * @param selected - (String) User submitted String for shelter name search
     * @return - boolean representing if new Animal objects can be added to shelter
     */
    public static boolean shelterSearch(String selected){
            if (shelterMap.containsShelter(selected)) {
                if (shelterMap.getShelter(selected).isReceiving()) {
                    return true;
                } else {
                    System.out.println("This shelter is not receiving animals\n");
                    return false;
                }
            } else {
                System.out.println("Invalid shelter ID\n");
            }
            return false;
        }

    /**
     * Method to toggle isReceiving attribute of a Shelter object to receiving or not receiving based on
     * submitted shelter name and boolean value.
     * @param selected - (String) user submitted shelter name
     * @param status - (boolean) true enables receiving, false disables
     */
    public static void changeReceiving(String selected, boolean status) {
            if(status){
                System.out.println("Receiving enabled for shelter " + selected + "\n");
            } else {
                System.out.println("Receiving disabled for shelter " + selected + "\n");
            }
        }

    /**
     * Method responsible for collecting user input to create new Animal object
     * @return (Animal) - user defined animal object
     */
    public static Animal createNewAnimal() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the animal type: ");
            String type = scan.nextLine();
            if (shelterMap.validAnimal(type)) {
                try {
                    System.out.println("Please enter the animal name: ");
                    String name = scan.nextLine();
                    System.out.println("Please enter the animal ID: ");
                    String id = scan.nextLine();
                    System.out.println("Please enter the animal weight: ");
                    double weight = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Please enter the receipt date: ");
                    long receipt = scan.nextLong();
                    scan.nextLine();
                    return new Animal(type, name, id, weight, receipt);
                }catch (Exception e){
                    System.out.println("Animal could not be created\n");
                    return null;
                }
            } else {
                System.out.println("Not a valid animal type.\n");
                return null;
            }
        }

    /**
     * Method responsible for adding Animal object into previously created Shelter object
     * @param newAnimal - (Animal) animal object to be added to shelter object
     * @param selected - (String) shelter ID
     */
    public static void addUserCreatedAnimal(Animal newAnimal, String selected){
            try{
                Shelter tempShelter = shelterMap.getShelter(selected);
                List<Animal> tempList = tempShelter.getAnimalList();
                tempList.add(newAnimal);
                tempShelter.setAnimalList(tempList);
                System.out.println("New Animal has been added.\n");
            } catch (Exception e) {
                System.out.println("Animal could not be added.\n");
            }
        }

    /**
     * Method loops through all shelters in map and all animal objects in each shelter object
     * and prints all to console.
     */
    public static void showAllAnimals(){
            List<Shelter> allShelters = new ArrayList<>(shelterMap.getShelters());
            for (Shelter currentShelter : allShelters) {
                System.out.println("Shelter ID: " + currentShelter);
                for (int j = 0; j < currentShelter.size(); j++) {
                    System.out.println(currentShelter.getAnimalList().get(j));
                }
                System.out.println();
            }
        }
}

