import java.util.List;
import java.util.Scanner;

public class Main {
    static ShelterList shelterMap = new ShelterList();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Please choose from the following options:\n" +
                    "1: Import json of animals\n" +
                    "2: Add additional incoming animal\n" +
                    "3: Enable receiving animals\n" +
                    "4: Disable receiving animals\n" +
                    "5: Export json file");
            int userOption = scan.nextInt();
            scan.nextLine();
            userMenu(userOption);
        } while(true);
    }

        public static void userMenu(int userOption) {
            String selected = "";
            Scanner scan = new Scanner(System.in);

            switch (userOption) {
                case 1:
                    shelterMap.addIncoming();
                    break;

                case 2:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    boolean shelterAvailable = shelterSearch(selected);
//                TODO: have user add in animal data
                    if(shelterAvailable) {
                        addNewAnimal(selected);
                    }
                    break;

                case 3:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    shelterExists(selected, true);
                    break;
                case 4:
                    shelterMap.showShelters();
                    System.out.println("Please select a shelter: ");
                    selected = scan.nextLine();
                    shelterExists(selected, false);
                    break;
                case 5:
                    Utilities.writeJSON(shelterMap);
//                TODO: provide user feedback
                    break;
            }
        }

        public static boolean shelterSearch(String selected){
            if (shelterMap.containsShelter(selected)) {
                if (shelterMap.getShelter(selected).isReceiving()) {
                    return true;
                } else {
                    System.out.println("This shelter is not receiving animals\n");
                    return false;
                }
            } else {
                System.out.println("Please select a valid shelter\n");
            }
            return false;
        }

        public static void shelterExists(String selected, boolean status) {
            if (!shelterMap.containsShelter(selected)) {
                System.out.println("This is not a valid shelter.");
            } else {
                shelterMap.getShelter(selected).setReceiving(status);
            }
            if(status){
                System.out.println("Receiving enabled for shelter " + selected + "\n");
            } else {
                System.out.println("Receiving disabled for shelter " + selected + "\n");
            }
        }

        public static void addNewAnimal(String selected) {
            Scanner scan = new Scanner(System.in);
//            if(!shelterMap.containsShelter(selected)){
//                System.out.println("This is not a valid shelter.");
//            } else {
            System.out.println("Please enter the animal type: ");
            String type = scan.nextLine();
            if (type.equalsIgnoreCase("cat") ||
                    type.equalsIgnoreCase("dog") ||
                    type.equalsIgnoreCase("bird") ||
                    type.equalsIgnoreCase("rabbit")) {

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

                Animal addition = new Animal(type, name, id, weight, receipt);
                Shelter tempShelter = shelterMap.getShelter(selected);
                List<Animal> tempList = tempShelter.getAnimalList();
                tempList.add(addition);
                tempShelter.setAnimalList(tempList);

                System.out.println("New Animal has been added.");
            } else {
                System.out.println("Not a valid animal type.");
            }
//        }
        }
}

