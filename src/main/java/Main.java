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

        UserInterface.printMenu();
        int userSelction = UserInterface.userOption();
        UserInterface.userMenu(userSelction, shelterMap);

    }
}

