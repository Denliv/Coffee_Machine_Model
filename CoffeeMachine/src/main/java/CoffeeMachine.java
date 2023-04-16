import database.Recipes;
import database.Resources;
import model.Coffee;
import model.CoffeeRecipe;
import service.CoffeeMachineService;

public class CoffeeMachine {
    //Класс модели "Кофемашина"
    private final Resources coffeeMachineResources;
    //Ресурсы кофемашины
    private final Recipes recipesDataBase;
    //Рецепты кофемашины(база данных рецептов)

    public CoffeeMachine() {
        this(new Resources());
    }

    public CoffeeMachine(Resources coffeeMachineResources) {
        this.coffeeMachineResources = coffeeMachineResources;
        this.recipesDataBase = new Recipes();
    }

    public Resources getCoffeeMachineResources() {
        return coffeeMachineResources;
    }

    public Recipes getRecipesDataBase() {
        return recipesDataBase;
    }

    //Метод приготовления кофе
    public Coffee makeCoffee(String coffeeRecipeName) {
        return CoffeeMachineService.makeCoffee(coffeeRecipeName, coffeeMachineResources, recipesDataBase);
    }

    //Метод добавления ресурсов/ингридиентов в кофемашину
    public void addCoffeeMachineResources(Resources newResources) {
        CoffeeMachineService.addResources(coffeeMachineResources, newResources);
    }

    //Метод добавления нового рецепта кофе в базу данных рецептов
    public void addCoffeeRecipe(CoffeeRecipe newRecipe) {
        CoffeeMachineService.addCoffeeRecipe(recipesDataBase, newRecipe);
    }
}
