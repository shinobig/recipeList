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
    // private JButton testButton = new JButton();

    Gui (RecipeList recipeList){
        int height = 700;
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

        frame.add(buttonPanel);
        frame.add(recipePanel);

        //  buttonPanel.add(testButton.getRecipeButton());
        // frame.add(testButton2.getRecipeButton());

        getAllButtons(recipeList.getRecipeName());

        frame.setVisible(true);
    }

    public void getAllButtons(ArrayList<String> allButtons){
        for(int i = 0; i < allButtons.size(); i++){
            RecipeButton recipeButtonToAdd = new RecipeButton(allButtons.get(i));
            recipeButtonToAdd.getRecipeButton().setBounds(25, ((i+1)*50), 150, 30);
            buttonPanel.add(recipeButtonToAdd.getRecipeButton());
        }
    }

    private class RecipeButton implements ActionListener {

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

}
