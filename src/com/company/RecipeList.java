package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeList {

    private static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();

    public RecipeList() {
        JSONParser parser = new JSONParser();

        try{
            Object obj =  parser.parse(new FileReader("src/com/company/recipes.json"));
            JSONArray arrayOfRecipes = (JSONArray) obj;

            for (int i = 0; i < arrayOfRecipes.size(); i++){
                JSONObject recipeObject = (JSONObject) arrayOfRecipes.get(i);
                String name = (String) recipeObject.get("name");
                String imageUrl = (String) recipeObject.get("imageURL");

                // Se crea array con los pasos
                ArrayList<String> steps = new ArrayList<String>();
                JSONArray originSteps = (JSONArray) recipeObject.get("steps");
                for(Object step : originSteps){
                    steps.add((String)originSteps.get(i));
                    //    System.out.println(step);
                }

                // Recipe constructor
                Recipe newRecipe = new Recipe(name, steps, imageUrl);

                // adding ingredients
                JSONArray ingredients = (JSONArray) recipeObject.get("ingredients");
                for (Object ingredient : ingredients) {
                    JSONObject individualIngredient = (JSONObject) ingredient;
                    String quantity = (String) individualIngredient.get("quantity");
                    String ingredientName = (String) individualIngredient.get("name");
                    String type = (String) individualIngredient.get("type");
                    newRecipe.addIngredients(quantity, ingredientName, type);
                }
                allRecipes.add(newRecipe);
            }
        }catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Recipe> getAllRecipes() {
        return allRecipes;
    }

    public static void setAllRecipes(ArrayList<Recipe> allRecipes) {
        RecipeList.allRecipes = allRecipes;
    }

    public static ArrayList<String> getRecipeName (){
        ArrayList<String> allRecipeName = new ArrayList<String>();
        for(int i = 0; i < allRecipes.size(); i++) {
            allRecipeName.add(allRecipes.get(i).getName());
        }
        return allRecipeName;
        }
    }
