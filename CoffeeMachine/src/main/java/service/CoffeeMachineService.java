package service;

import database.Recipes;
import database.Resources;
import model.Coffee;
import model.CoffeeRecipe;

public class CoffeeMachineService {
    //Класс-сервис для кофемашины, обеспечивает её работу
    public static Coffee makeCoffee(String coffeeRecipeName, Resources coffeeMachineResources, Recipes recipesDataBase) {
        if (!recipesDataBase.contains(coffeeRecipeName)) {
            throw new IllegalArgumentException("Error: There is no such coffee recipe in the database\n");
        }
        CoffeeRecipe currentRecipe = recipesDataBase.get(coffeeRecipeName);
        if (currentRecipe.getMilkAmount() > coffeeMachineResources.getTotalMilkAmount() ||
                currentRecipe.getWaterAmount() > coffeeMachineResources.getTotalWaterAmount() ||
                currentRecipe.getCoffeeBeansAmount() > coffeeMachineResources.getTotalCoffeeBeansAmount()) {
            throw new IllegalArgumentException("Error: Not enough ingredients\n");
        }
        coffeeMachineResources.setTotalMilkAmount(
                coffeeMachineResources.getTotalMilkAmount() - currentRecipe.getMilkAmount()
        );
        coffeeMachineResources.setTotalWaterAmount(
                coffeeMachineResources.getTotalWaterAmount() - currentRecipe.getWaterAmount()
        );
        coffeeMachineResources.setTotalCoffeeBeansAmount(
                coffeeMachineResources.getTotalCoffeeBeansAmount() - currentRecipe.getCoffeeBeansAmount()
        );
        return new Coffee(currentRecipe);
    }

    public static void addResources(Resources coffeeMachineResources, Resources newResources) {
        if (newResources == null) {
            return;
        }
        coffeeMachineResources.setTotalMilkAmount(
                coffeeMachineResources.getTotalMilkAmount() + newResources.getTotalMilkAmount()
        );
        coffeeMachineResources.setTotalWaterAmount(
                coffeeMachineResources.getTotalWaterAmount() + newResources.getTotalWaterAmount()
        );
        coffeeMachineResources.setTotalCoffeeBeansAmount(
                coffeeMachineResources.getTotalCoffeeBeansAmount() + newResources.getTotalCoffeeBeansAmount()
        );
    }

    public static void addCoffeeRecipe(Recipes recipesDataBase, CoffeeRecipe newRecipe) {
        recipesDataBase.insert(newRecipe);
    }

    public static void deleteCoffeeRecipe(Recipes recipesDataBase, String recipeName) {
        recipesDataBase.delete(recipeName);
    }

    public static void resetRecipesDataBase(Recipes recipesDataBase) {
        recipesDataBase.clear();
    }
}
