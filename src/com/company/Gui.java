package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui {

    public JFrame frame = new JFrame("Recipes tests");
    ArrayList<JButton> recipeButtons = new ArrayList<JButton>();
    RecipeList recipeList;

    JPanel buttonPanel = new JPanel();
    JPanel recipePanel = new JPanel();
    JLabel recipeTitle = new JLabel();
    Recipe displayedRecipe;


    Gui (RecipeList recipeList){
        int height = 700;
        this.displayedRecipe = recipeList.getAllRecipes().get(0);
        this.recipeList = recipeList;




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, height);
        frame.getContentPane().setBackground(new Color(215,204,200));
        frame.setLayout(null);

        // RecipeButton testButton = new RecipeButton("holis");
        //  RecipeButton testButton2 = new RecipeButton("borolis");
        // testButton2.getRecipeButton().setBounds(500,550,55,42);

        buttonPanel.setBounds(0,0, 200,height);
        buttonPanel.setBackground(new Color(139,195,74));
        buttonPanel.setLayout(null);
        recipePanel.setBounds(200, 0, 400, height);
        recipePanel.setBackground(new Color(215,204,200));
        recipePanel.setLayout(null);

        frame.add(buttonPanel);
        frame.add(recipePanel);

        getAllButtons(recipeList.getRecipeName());

        // Show labels
        setAllLabels();



        // Show gui
        frame.setVisible(true);
    }

    public void setAllLabels(){
this.recipeTitle.setText(this.displayedRecipe.getName());
this.recipeTitle.setHorizontalAlignment(JLabel.CENTER);
        this.recipeTitle.setVerticalAlignment(JLabel.TOP);
this.recipeTitle.setFont(new Font("Helvetica", Font.BOLD, 20));
recipePanel.add(this.recipeTitle);
        getAllIngredients(displayedRecipe);


    }

    // Methods here

    public void getAllButtons(ArrayList<String> allButtons){
        for(int i = 0; i < allButtons.size(); i++){
            RecipeButton recipeButtonToAdd = new RecipeButton(allButtons.get(i));
            recipeButtonToAdd.getRecipeButton().setBounds(25, ((i+1)*50), 150, 30);
            buttonPanel.add(recipeButtonToAdd.getRecipeButton());
        }
    }

    private void getAllIngredients(Recipe recipeToCheck){
        for (int i = 0; i < recipeToCheck.getIngredients().size(); i++){
         recipePanel.setBounds(110,50, 50, 50);
            recipePanel.add(new IngredientsLabel(recipeToCheck.getIngredientName(i)).getIngredient());

        }
    }
}
