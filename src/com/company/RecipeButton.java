package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeButton implements ActionListener {

    JButton recipeButton = new JButton();
    String recipeName;

    RecipeButton(String recipeName){
        this.recipeName = recipeName;
        recipeButton.setText(recipeName);
        recipeButton.addActionListener(this);
    }

    public JButton getRecipeButton() {
        return recipeButton;
    }

    public void setRecipeButton(JButton recipeButton) {
        this.recipeButton = recipeButton;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(getRecipeName());
    }
}
