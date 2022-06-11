import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> animalList = new ArrayList<Animal>();
    private String shelterID;
    private boolean receiving = true;

    Shelter(String shelterId){
        this.shelterID = shelterId;
    }

    public void setReceiving(boolean receive){

        receiving = receive;
    }

    public boolean isReceiving(){

        return receiving;
    }

    public List<Animal> getAnimalList() {

        return animalList;
    }

    public void setAnimalList(List<Animal> newlist) {

        animalList = newlist;
    }

    public String toString(){
        return shelterID;
    }
/*
returns a string of all animals in the list for specific shelter
 */
    public String showAnimals(){
        String str = "Shelter: " + shelterID + "\n";

        for (int i = 0; i < size(); i++) {
            str += animalList.get(i).toString();
            str += "\n";
        }
        return str;

    }
    public int size(){
        return animalList.size();
    }
}
