package database;

import model.CoffeeRecipe;

import java.util.*;

public class Recipes {
    //База данных для хранения рецептов кофе
    private final Map<String, CoffeeRecipe> recipes = new HashMap<>();

    public void insert(CoffeeRecipe newRecipe) {
        recipes.put(newRecipe.getRecipeName(), newRecipe);
    }

    public void delete(String recipeName) {
        if (!recipes.containsKey(recipeName)) {
            throw new IllegalArgumentException("Error: Can not delete coffee recipe as there is no such recipe in the database");
        }
        recipes.remove(recipeName, recipes.get(recipeName));
    }

    public boolean contains(String recipeName) {
        return recipes.containsKey(recipeName);
    }

    public CoffeeRecipe get(String recipeName) {
        if (!recipes.containsKey(recipeName)) {
            throw new IllegalArgumentException("Error: Can not get coffee recipe as there is no such recipe in the database");
        }
        return recipes.get(recipeName);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Recipes:\n");
        for (var i : recipes.entrySet()) {
            stringBuilder.append(i.getValue());
        }
        return stringBuilder.toString();
    }
}
