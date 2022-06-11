import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    static ShelterList shelterMap = new ShelterList();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Please choose from the following options:\n" +
                    "1: Import json of animals\n" +
                    "2: Add additional incoming animal\n" +
                    "3: Enable receiving animals\n" +
                    "4: Disable receiving animals\n" +
                    "5: Export json file\n");
            int userOption = scan.nextInt();
            scan.nextLine();
            userMenu(userOption);
        }
    }
        public static void userMenu(int userOption) {
            String selected = "";
            Scanner scan = new Scanner(System.in);

            switch (userOption) {
                case 1:
                    shelterMap.addIncoming();
//                TODO: provide feedback to user if successful
                    break;
                case 2:
//                TODO: list shelters from shelter class to console.
                    System.out.println("Please select a shelter: ");
                    shelterMap.showShelters();
//                TODO: have user select shelter
                    selected = scan.nextLine();
                    if (shelterMap.containsShelter(selected)) {
                        if (shelterMap.getShelter(selected).isReceiving()) {

                        } else {
                            System.out.println("This shelter is not receiving animals.");
                        }
                    } else {
                        System.out.println("This is not a valid shelter.");
                    }
//                TODO: have user add in animal data
                    break;
                case 3:
//                TODO: list shelters from shelter class to console.
                    System.out.println("Please select a shelter: ");
                    shelterMap.showShelters();
//                TODO: have user select shelter
                    selected = scan.nextLine();
                    if (shelterMap.containsShelter(selected)) {
                        shelterMap.getShelter(selected).setReceiving(true);
                        System.out.println("Shelter " + selected + " is receiving animals.");
                    } else {
                        System.out.println("This is not a valid shelter.");
                    }
                    break;
                case 4:
//                TODO: list shelters from shelter class to console.
                    System.out.println("Please select a shelter: ");
                    shelterMap.showShelters();
//                TODO: have user select shelter
                    selected = scan.nextLine();
                    if (shelterMap.containsShelter(selected)) {
                        shelterMap.getShelter(selected).setReceiving(false);
                        System.out.println("Shelter " + selected + " is not receiving animals.");
                    } else {
                        System.out.println("This is not a valid shelter.");
                    }
                    break;
                case 5:
                    Utilities.writeJSON();
//                TODO: provide user feedback
                    break;
            }
        }


}

