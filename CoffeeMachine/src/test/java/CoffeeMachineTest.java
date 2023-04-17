import coffeemachine.CoffeeMachine;
import interfaces.ICoffeeMachine;
import database.Resources;
import model.Coffee;
import model.CoffeeRecipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMachineTest {
    ICoffeeMachine coffeeMachine;

    @Before
    public void begin() {
        Resources coffeeMachineResources = new Resources(10, 10, 10);
        coffeeMachine = new CoffeeMachine(coffeeMachineResources);
    }

    @Test
    public void makeCoffeeTest() {
        CoffeeRecipe latte = new CoffeeRecipe("Latte", 2, 1, 3);
        CoffeeRecipe cappuccino = new CoffeeRecipe("Cappuccino", 1, 1, 4);
        CoffeeRecipe americano = new CoffeeRecipe("Americano", 0, 3, 5);
        coffeeMachine.addCoffeeRecipe(latte);
        coffeeMachine.addCoffeeRecipe(cappuccino);
        coffeeMachine.addCoffeeRecipe(americano);
        Coffee latteCoffee = coffeeMachine.makeCoffee("Latte");
        Coffee cappuccinoCoffee = coffeeMachine.makeCoffee("Cappuccino");
        assertEquals(new Coffee(latte), latteCoffee);
        assertEquals(new Coffee(cappuccino), cappuccinoCoffee);
    }

    @Test
    public void addCoffeeMachineResourcesTest() {
        assertEquals(new Resources(10, 10, 10), coffeeMachine.getCoffeeMachineResources());
        Resources newResources = new Resources(5, 4, 3);
        coffeeMachine.addCoffeeMachineResources(newResources);
        assertEquals(new Resources(15, 14, 13), coffeeMachine.getCoffeeMachineResources());
    }

    @Test
    public void coffeeRecipeOperationsTest() {
        Resources newResources = new Resources(100, 100, 100);
        coffeeMachine.addCoffeeMachineResources(newResources);
        CoffeeRecipe latte = new CoffeeRecipe("Latte", 2, 1, 3);
        CoffeeRecipe cappuccino = new CoffeeRecipe("Cappuccino", 1, 1, 4);
        CoffeeRecipe americano = new CoffeeRecipe("Americano", 0, 3, 5);
        coffeeMachine.addCoffeeRecipe(latte);
        coffeeMachine.addCoffeeRecipe(cappuccino);
        coffeeMachine.addCoffeeRecipe(americano);
        assertTrue(coffeeMachine.getRecipesDataBase().contains("Latte"));
        assertTrue(coffeeMachine.getRecipesDataBase().contains("Cappuccino"));
        assertTrue(coffeeMachine.getRecipesDataBase().contains("Americano"));
        coffeeMachine.deleteCoffeeRecipe("Latte");
        assertFalse(coffeeMachine.getRecipesDataBase().contains("Latte"));
        coffeeMachine.resetRecipesDataBase();
        assertFalse(coffeeMachine.getRecipesDataBase().contains("Latte"));
        assertFalse(coffeeMachine.getRecipesDataBase().contains("Cappuccino"));
        assertFalse(coffeeMachine.getRecipesDataBase().contains("Americano"));
    }

    @Test
    public void coffeeRecipeErrorTest() {
        assertThrows(IllegalArgumentException.class, () -> coffeeMachine.makeCoffee("CoffeeSample1"));
        CoffeeRecipe latte = new CoffeeRecipe("Latte", 2, 1, 3);
        CoffeeRecipe cappuccino = new CoffeeRecipe("Cappuccino", 1, 1, 4);
        coffeeMachine.addCoffeeRecipe(latte);
        coffeeMachine.addCoffeeRecipe(cappuccino);
        assertThrows(IllegalArgumentException.class, () -> coffeeMachine.makeCoffee("CoffeeSample1"));
    }

    @Test
    public void makeCoffeeErrorTest() {
        CoffeeRecipe latte = new CoffeeRecipe("Latte", 2, 1, 3);
        coffeeMachine.addCoffeeRecipe(latte);
        coffeeMachine.makeCoffee("Latte");
        coffeeMachine.makeCoffee("Latte");
        coffeeMachine.makeCoffee("Latte");
        assertThrows(IllegalArgumentException.class, () -> coffeeMachine.makeCoffee("Latte"));
    }
}