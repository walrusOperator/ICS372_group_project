import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> animalList = new ArrayList<Animal>();
    private String shelterID;
    private  Boolean receiving;
    Shelter(String shelterId){
        this.shelterID = shelterId;
    }
    public void setReceiving(Boolean receive){
        receiving = receive;
    }
    public List<Animal> getAnimalList() {
        return animalList;
    }
    public void setAnimalList(List<Animal> newlist) {
        animalList = newlist;
    }

}
