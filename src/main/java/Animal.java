import java.util.Random;

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

    public void setAnimalID(){
        animal_ID = genRandomAlphanumeric(5);
    }

    public String getAnimal_ID(){
        return animal_ID;
    }

    public void setAnimal_Type(String type){
        animal_Type = type;
    }

    public String getAnimal_Type(){
        return animal_Type;
    }

    public void setAnimal_Name(String name){
        animal_Name = name;
    }

    public String getAnimal_Name(){
        return animal_Name;
    }

    public void setAnimal_weight(float weight){
        animal_weight = weight;
    }

    public float getAnimal_weight(){
        return animal_weight;
    }

    private String genRandomAlphanumeric(int length){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        char[] alphanumeric = (letters + letters.toUpperCase() + "0123456789").toCharArray();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 5; i++){
            result.append(alphanumeric[new Random().nextInt(alphanumeric.length)]);
        }
        return result.toString();


    }
}

