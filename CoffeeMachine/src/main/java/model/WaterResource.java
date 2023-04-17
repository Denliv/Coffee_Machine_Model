package model;

public class WaterResource extends Resource {
    //Класс модель ингридиента "Вода"
    public static final String name = "WATER";
    public WaterResource() {
    }

    public WaterResource(double totalResourceAmount) {
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
        return name + "=" + super.getTotalResourceAmount() + "\n";
    }
}
