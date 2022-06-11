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
                    shelterSearch(selected);
//                TODO: have user add in animal data
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
//                    System.out.println("Receiving disabled for shelter " + selected + "\n");
                    break;
                case 5:
                    Utilities.writeJSON();
//                TODO: provide user feedback
                    break;
            }
        }

        public static void shelterSearch(String selected){
            if (shelterMap.containsShelter(selected)) {
                if (shelterMap.getShelter(selected).isReceiving()) {

                } else {
                    System.out.println("This shelter is not receiving animals.");
                }
            }
        }

        public static void shelterExists(String selected, boolean status) {
            if (!shelterMap.containsShelter(selected)) {
                System.out.println("This is not a valid shelter");
            } else {
                shelterMap.getShelter(selected).setReceiving(status);
            }
            if(status == true){
                System.out.println("Receiving enabled for shelter " + selected + "\n");
            } else {
                System.out.println("Receiving disabled for shelter " + selected + "\n");
            }
        }


}

