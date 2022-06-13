public class Animal {
    private String animal_ID;
    private String animal_Type;
    private String animal_Name;
    private double animal_weight;
    private long receipt_date;

    /**
     * Animal Constructor - responsible for creating/setting animal variables with the passed on parameters
     *
     * @param animal_type
     * @param animal_name
     * @param animal_id
     * @param animal_weight
     * @param receipt_date
     */
    public Animal(String animal_type, String animal_name, String animal_id, double animal_weight, long receipt_date){
        this.animal_Type = animal_type;
        this.animal_Name = animal_name;
        this.animal_ID = animal_id;
        this.animal_weight = animal_weight;
        this.receipt_date = receipt_date;
    }

    /**
     * getAnimal_ID method - responsible for getting the animal ID
     * @return
     */
    public String getAnimal_ID() {
        return animal_ID;
    }

    /**
     * getAnimal_Type method - responsible for getting animal type
     * @return
     */
    public String getAnimal_Type() {
        return animal_Type;
    }

    /**
     * getAnimal_Name() method - responsible for getting animal name
     * @return
     */
    public String getAnimal_Name() {
        return animal_Name;
    }

    /**
     * setAnimal_weight method - responsible for setting the animal_weight
     * @param animal_weight
     */
    public void setAnimal_weight(double animal_weight) {
        this.animal_weight = animal_weight;
    }

    /**
     * getAnimal_weight method - responsible for getting animal weight
     * @return
     */
    public double getAnimal_weight() {
        return animal_weight;
    }

    /**
     * getReceipt_date() method - responsible for getting the receipt date of animal
     * @return
     */
    public long getReceipt_date() {
        return receipt_date;
    }

    /**
     * toString method - responsible for printing out Animal's variables
     * @return
     */
    @Override
    public String toString() {
        return "Animal{" +
                "animal_ID='" + animal_ID + '\'' +
                ", animal_Type='" + animal_Type + '\'' +
                ", animal_Name='" + animal_Name + '\'' +
                ", animal_weight=" + animal_weight +
                ", receipt_date=" + receipt_date +
                '}';
    }
}

