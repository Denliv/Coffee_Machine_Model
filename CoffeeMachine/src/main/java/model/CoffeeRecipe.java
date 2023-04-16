package model;

import java.util.Objects;

public class CoffeeRecipe {
    //Класс модели "Рецепт Кофе"
    private String recipeName;
    private double milkAmount;
    private double waterAmount;
    private double coffeeBeansAmount;

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
        return milkAmount;
    }

    private void setMilkAmount(double milkAmount) {
        validate(milkAmount);
        this.milkAmount = milkAmount;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    private void setWaterAmount(double waterAmount) {
        validate(waterAmount);
        this.waterAmount = waterAmount;
    }

    public double getCoffeeBeansAmount() {
        return coffeeBeansAmount;
    }

    private void setCoffeeBeansAmount(double coffeeBeansAmount) {
        validate(coffeeBeansAmount);
        this.coffeeBeansAmount = coffeeBeansAmount;
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
        return Double.compare(that.milkAmount, milkAmount) == 0 && Double.compare(that.waterAmount, waterAmount) == 0 && Double.compare(that.coffeeBeansAmount, coffeeBeansAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(milkAmount, waterAmount, coffeeBeansAmount);
    }
}
