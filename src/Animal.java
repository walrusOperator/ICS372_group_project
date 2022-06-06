import java.util.Random;

public class Animal {
    private String animal_ID;
    private String animal_Type;
    private String animal_Name;
    private int weight;
    private boolean animal_Allowed;

    public String createAnimal(String type, String name){
        animal_Type = type;
        animal_Name = name;

        Random random = new Random();

        if(animal_Type.equals("dog") || animal_Type.equals("DOG") ||
                                        animal_Type.equals("cat") ||
                                        animal_Type.equals("CAT") ||
                                        animal_Type.equals("bird") ||
                                        animal_Type.equals("BIRD") ||
                                        animal_Type.equals("rabbit") ||
                                        animal_Type.equals("RABBIT")) {

              animal_Allowed = true;
              animal_ID = genRandomAlphanumeric(5);
              weight = random.nextInt(100);
          }
          else{
              animal_Allowed = false;
              System.out.println("Animal type is not supported!");
          }
        return (animal_Type + animal_Name + animal_ID + weight);
    }

    private String genRandomAlphanumeric(int length){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        char[] alphanumeric = (letters + letters.toUpperCase() + "0123456789").toCharArray();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++){
            result.append(alphanumeric[new Random().nextInt(alphanumeric.length)]);
        }
        return result.toString();


    }
}

