import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> animalList = new ArrayList<Animal>();
    private String shelterID;
    private  Boolean receiving;
    Shelter(String shelterId){
        this.shelterID = shelterId;
    }
    public Shelter createShelter(){
        return new Shelter();
    }
    public boolean enableReceiving(){
        this.receiving = true;
        return this.receiving;
    }
    public boolean disableReceiving (){
        this.receiving = false;
        return this.receiving;
    }
}
