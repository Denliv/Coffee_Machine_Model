package model;

public class MilkResource extends Resource {
    //Класс модель ингридиента "Молоко"
    public static final String name = "MILK";

    public MilkResource() {
    }

    public MilkResource(double totalResourceAmount) {
        super(totalResourceAmount);
    }

    @Override
    public void validate(double resourceAmount) {
        if (resourceAmount < 0) {
            throw new IllegalArgumentException("Error: Invalid amount of milk resource\n");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "=" + super.getTotalResourceAmount();
    }
}
