
public class Main {
    private static final ShelterList shelterMap = new ShelterList();

    public static void main(String[] args) {
        UserInterface.printMenu();
        int userSelection = UserInterface.userOption();
        UserInterface.userMenu(userSelection, shelterMap);

    }
}

