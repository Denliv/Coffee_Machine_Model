package coffee_machine_example;

import coffeemachine.*;
import database.*;
import interfaces.*;
import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ICoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        int param;
        while (true) {
            System.out.println("""
                    COFFEE_MACHINE:
                    1) Make coffee
                    2) Add resources
                    3) Add coffee recipe
                    4) Delete coffee recipe
                    5) Get recipes list
                    6) Get resources list
                    7) Reset recipes database
                    8) Turn off""");
            param = scanner.nextInt();
            switch (param) {
                case 1:
                    System.out.println("Enter coffee recipe name:");
                    String makeCoffeeRecipeName = scanner.next();
                    try {
                        coffeeMachine.makeCoffee(makeCoffeeRecipeName);
                        System.out.println("Your coffee \"" + makeCoffeeRecipeName + "\" is ready");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter the amount of milk:");
                    double milkResource = scanner.nextDouble();
                    System.out.println("Enter the amount of water:");
                    double waterResource = scanner.nextDouble();
                    System.out.println("Enter the amount of coffee beans:");
                    double coffeeBeansResource = scanner.nextDouble();
                    try {
                        Resources newResources = new Resources(milkResource, waterResource, coffeeBeansResource);
                        coffeeMachine.addCoffeeMachineResources(newResources);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter coffee recipe name:");
                        String name = scanner.next();
                        System.out.println("Enter the amount of milk:");
                        double recipeMilkResource = scanner.nextDouble();
                        System.out.println("Enter the amount of water:");
                        double recipeWaterResource = scanner.nextDouble();
                        System.out.println("Enter the amount of coffee beans:");
                        double recipeCoffeeBeansResource = scanner.nextDouble();
                        CoffeeRecipe newCoffeeRecipe = new CoffeeRecipe(
                                name, recipeMilkResource, recipeWaterResource, recipeCoffeeBeansResource
                        );
                        coffeeMachine.addCoffeeRecipe(newCoffeeRecipe);
                        System.out.println("Recipe:{\n" + newCoffeeRecipe + "} was added to database");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Enter coffee recipe name:");
                        String deleteCoffeeRecipeName = scanner.next();
                        coffeeMachine.deleteCoffeeRecipe(deleteCoffeeRecipeName);
                        System.out.println("Recipe" + deleteCoffeeRecipeName + " was deleted from database");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    System.out.println(coffeeMachine.getRecipesDataBase().toString());
                    break;
                case 6:
                    System.out.println(coffeeMachine.getCoffeeMachineResources().toString());
                    break;
                case 7:
                    coffeeMachine.resetRecipesDataBase();
                    System.out.println("Recipes database was reset");
                    break;
                case 8:
                    return;
            }
        }
    }
}