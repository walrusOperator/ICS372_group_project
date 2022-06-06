import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> animalList = new ArrayList<Animal>();
    private String shelterID;
    private  Boolean receiving;

    Shelter(String shelterId){
        this.shelterID = shelterId;
    }

    public Shelter createShelter(String id){
        return new Shelter(id);

    }
    public void enableReceiving(){
        this.receiving = true;

    }
    public void disableReceiving (){
        this.receiving = false;

    }
}
