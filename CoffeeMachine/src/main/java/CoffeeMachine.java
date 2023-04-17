import database.Recipes;
import database.Resources;
import model.Coffee;
import model.CoffeeRecipe;
import service.CoffeeMachineService;

public class CoffeeMachine implements ICoffeeMachine {
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
    //Метод
    public Resources getCoffeeMachineResources() {
        return coffeeMachineResources;
    }

    public Recipes getRecipesDataBase() {
        return recipesDataBase;
    }

    //Метод приготовления кофе
    @Override
    public Coffee makeCoffee(String coffeeRecipeName) {
        return CoffeeMachineService.makeCoffee(coffeeRecipeName, coffeeMachineResources, recipesDataBase);
    }

    //Метод добавления ресурсов/ингридиентов в кофемашину
    @Override
    public void addCoffeeMachineResources(Resources newResources) {
        CoffeeMachineService.addResources(coffeeMachineResources, newResources);
    }

    //Метод добавления нового рецепта кофе в базу данных рецептов
    @Override
    public void addCoffeeRecipe(CoffeeRecipe newRecipe) {
        CoffeeMachineService.addCoffeeRecipe(recipesDataBase, newRecipe);
    }

    //Метод удаления нового рецепта кофе из базы данных рецептов
    @Override
    public void deleteCoffeeRecipe(String recipeName) {
        CoffeeMachineService.deleteCoffeeRecipe(recipesDataBase, recipeName);
    }

    //Метод очистки базы данных рецептов
    @Override
    public void resetRecipesDataBase() {
        CoffeeMachineService.resetRecipesDataBase(recipesDataBase);
    }
}
