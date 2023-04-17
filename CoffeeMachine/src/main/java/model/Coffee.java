package model;

import java.util.Objects;

public class Coffee {
    //Класс модель "Кофе"
    private CoffeeRecipe coffeeRecipe;

    public Coffee(CoffeeRecipe coffeeRecipe) {
        this.coffeeRecipe = coffeeRecipe;
    }

    public CoffeeRecipe getCoffeeRecipe() {
        return coffeeRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(coffeeRecipe, coffee.coffeeRecipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeRecipe);
    }
}
