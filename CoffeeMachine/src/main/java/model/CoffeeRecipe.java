package model;

import java.util.Objects;

public class CoffeeRecipe {
    //Класс модель "Рецепт Кофе"
    private String recipeName;
    private MilkResource milkAmount;
    private WaterResource waterAmount;
    private CoffeeBeansResource coffeeBeansAmount;

    public CoffeeRecipe(String recipeName, double milkAmount, double waterAmount, double coffeeBeansAmount) {
        setRecipeName(recipeName);
        setMilkAmount(milkAmount);
        setWaterAmount(waterAmount);
        setCoffeeBeansAmount(coffeeBeansAmount);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        if (recipeName == null || recipeName.equals("")) {
            throw new IllegalArgumentException("Error: Invalid name of the recipe\n");
        }
        this.recipeName = recipeName;
    }

    public double getMilkAmount() {
        return milkAmount.getTotalResourceAmount();
    }

    private void setMilkAmount(double milkAmount) {
        this.milkAmount = new MilkResource(milkAmount);
    }

    public double getWaterAmount() {
        return waterAmount.getTotalResourceAmount();
    }

    private void setWaterAmount(double waterAmount) {
        this.waterAmount = new WaterResource(waterAmount);
    }

    public double getCoffeeBeansAmount() {
        return coffeeBeansAmount.getTotalResourceAmount();
    }

    private void setCoffeeBeansAmount(double coffeeBeansAmount) {
        this.coffeeBeansAmount = new CoffeeBeansResource(coffeeBeansAmount);
    }

    private void validate(double resourceAmount) {
        if (resourceAmount < 0) {
            throw new IllegalArgumentException("Error: Invalid amount of ingredients in the recipe\n");
        }
    }

    @Override
    public String toString() {
        return recipeName + ":" +
                "\nMilk Amount=" + milkAmount +
                "\nWater Amount=" + waterAmount +
                "\nCoffee Beans Amount=" + coffeeBeansAmount +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeRecipe that = (CoffeeRecipe) o;
        return Objects.equals(recipeName, that.recipeName) && Objects.equals(milkAmount, that.milkAmount) && Objects.equals(waterAmount, that.waterAmount) && Objects.equals(coffeeBeansAmount, that.coffeeBeansAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName, milkAmount, waterAmount, coffeeBeansAmount);
    }
}
