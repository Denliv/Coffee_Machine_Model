package database;

import model.CoffeeRecipe;

import java.util.*;

public class Recipes {
    //База данных для хранения рецептов кофе
    private final Map<String, CoffeeRecipe> recipes = new HashMap<>();

    public void insert(CoffeeRecipe newRecipe) {
        recipes.put(newRecipe.getRecipeName().toUpperCase(), newRecipe);
    }

    public void delete(String recipeName) {
        if (!recipes.containsKey(recipeName.toUpperCase())) {
            throw new IllegalArgumentException("Error: Can not delete coffee recipe as there is no such recipe in the database\n");
        }
        recipes.remove(recipeName.toUpperCase(), recipes.get(recipeName.toUpperCase()));
    }

    public boolean contains(String recipeName) {
        return recipes.containsKey(recipeName.toUpperCase());
    }

    public CoffeeRecipe get(String recipeName) {
        if (!recipes.containsKey(recipeName.toUpperCase())) {
            throw new IllegalArgumentException("Error: Can not get coffee recipe as there is no such recipe in the database\n");
        }
        return recipes.get(recipeName.toUpperCase());
    }

    public void clear() {
        recipes.clear();
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
