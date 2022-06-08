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
    public int size(){
        return animalList.size();
    }
}
