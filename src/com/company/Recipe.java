package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recipe {

    private String name;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<String> steps;
    private String imageUrl;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, ArrayList<String> steps) {
        this.name = name;
        this.steps = steps;
    }

    public Recipe(String name, ArrayList<String> steps, String imageUrl) {
        this.name = name;
        this.steps = steps;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

public String getIngredientName(int index){
        return ingredients.get(index).getIngredientName();
}



    public void addIngredients (String quantity, String ingredientName, String type){
        Ingredient ingredientToAdd = new Ingredient(quantity, ingredientName, type);
        ingredients.add(ingredientToAdd);
    }

    private static class Ingredient {
        private String quantity;
        private String ingredientName;
        private String type;

        public Ingredient(String quantity, String ingredientName, String type) {
            this.quantity = quantity;
            this.ingredientName = ingredientName;
            this.type = type;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getIngredientName() {
            return ingredientName;
        }

        public void setIngredientName(String ingredientName) {
            this.ingredientName = ingredientName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
