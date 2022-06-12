public class Animal {
    private String animal_ID;
    private String animal_Type;
    private String animal_Name;
    private double animal_weight;
    private long receipt_date;

    public Animal(String animal_type, String animal_name, String animal_id, double animal_weight, long receipt_date){
        this.animal_Type = animal_type;
        this.animal_Name = animal_name;
        this.animal_ID = animal_id;
        this.animal_weight = animal_weight;
        this.receipt_date = receipt_date;
    }

    public String getAnimal_ID() {
        return animal_ID;
    }

    public String getAnimal_Type() {
        return animal_Type;
    }

    public String getAnimal_Name() {
        return animal_Name;
    }

    public void setAnimal_weight(double animal_weight) {
        this.animal_weight = animal_weight;
    }

    public double getAnimal_weight() {
        return animal_weight;
    }

    public long getReceipt_date() {
        return receipt_date;
    }

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

