public class Animal {
    private String animal_ID;
    private String animal_Type;
    private String animal_Name;
    private float animal_weight;
    private boolean animal_Allowed;

    public void createAnimal(){

        if(animal_Type.equalsIgnoreCase("dog") ||
                                        animal_Type.equalsIgnoreCase("cat") ||
                                        animal_Type.equalsIgnoreCase("bird") ||
                                        animal_Type.equalsIgnoreCase("rabbit")){

              animal_Allowed = true;
              getAnimal_ID();
              getAnimal_Name();
              getAnimal_Type();
              getAnimal_weight();
          }
          else{
              animal_Allowed = false;
              System.out.println("Animal type is not supported!");
          }
    }

    public void setAnimal_ID(String animal_ID) {
        this.animal_ID = animal_ID;
    }
    public String getAnimal_ID() {
        return animal_ID;
    }
    public void setAnimal_Type(String animal_Type) {
        this.animal_Type = animal_Type;
    }
    public String getAnimal_Type() {
        return animal_Type;
    }
    public void setAnimal_Name(String animal_Name) {
        this.animal_Name = animal_Name;
    }
    public String getAnimal_Name() {
        return animal_Name;
    }
    public void setAnimal_weight(float animal_weight) {
        this.animal_weight = animal_weight;
    }
    public float getAnimal_weight() {
        return animal_weight;
    }
}

