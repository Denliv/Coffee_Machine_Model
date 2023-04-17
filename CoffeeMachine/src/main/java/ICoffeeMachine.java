import database.Recipes;
import database.Resources;
import model.Coffee;
import model.CoffeeRecipe;

public interface ICoffeeMachine {
    Resources getCoffeeMachineResources();

    Recipes getRecipesDataBase();

    Coffee makeCoffee(String coffeeRecipeName);

    void addCoffeeMachineResources(Resources newResources);

    void addCoffeeRecipe(CoffeeRecipe newRecipe);

    void deleteCoffeeRecipe(String recipeName);

    void resetRecipesDataBase();
}
