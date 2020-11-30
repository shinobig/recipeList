package com.company;

import javax.swing.*;

public class IngredientsLabel {

        JLabel ingredient = new JLabel();
        IngredientsLabel(String ingredientName){
            ingredient.setText(ingredientName);
        }
        public JLabel getIngredient() {
            return ingredient;
        }

}
