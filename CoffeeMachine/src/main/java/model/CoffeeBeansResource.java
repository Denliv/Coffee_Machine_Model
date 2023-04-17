package model;

public class CoffeeBeansResource extends Resource {
    //Класс модель ингридиента "Кофейные зёрна"
    public static final String name = "COFFEE_BEANS";
    public CoffeeBeansResource() {
    }

    public CoffeeBeansResource(double totalResourceAmount) {
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
