package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.Arrays;

public class Roll implements Sushi {
  private final String name;
  private final IngredientPortion[] clone_ingredients;
  private final ArrayList<IngredientPortion> ingredientList;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    IngredientPortion[] clone_ingredients1;
    this.name = name;
    clone_ingredients1 = roll_ingredients.clone();
    ingredientList = new ArrayList<IngredientPortion>(Arrays.asList(clone_ingredients1));
    for (int i = 0; i < ingredientList.size(); i++) {
      for (int j = i + 1; j < ingredientList.size(); j++) {
        if (ingredientList.get(i).getName().equals(ingredientList.get(j).getName())) {
          ingredientList.set(i, ingredientList.get(i).combine(ingredientList.get(j)));
          ingredientList.remove(j);
          j--;
        }
      }
    }
    boolean testingSeaweed = false;
    for (int k = 0; k < ingredientList.size(); k++) {
      if ((ingredientList.get(k).getName().equals("seaweed"))
          && (ingredientList.get(k).getAmount() < 0.1)) {
        ingredientList.set(k, new SeaweedPortion(0.12));
        testingSeaweed = true;
      } else if (ingredientList.get(k).getName().equals("seaweed")) {
        testingSeaweed = true;
      }
    }
    if (testingSeaweed == false) {
      ingredientList.add(new SeaweedPortion(0.12));
    }
    clone_ingredients1 = ingredientList.toArray(new IngredientPortion[0]);
    this.clone_ingredients = clone_ingredients1;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return this.clone_ingredients;
  }

  @Override
  public int getCalories() {
    int countCals = 0;
    for (int i = 0; i < clone_ingredients.length; i++) {
      countCals += clone_ingredients[i].getCalories();
    }
    return countCals;
  }

  @Override
  public double getCost() {
    double countCost = 0;
    for (int i = 0; i < clone_ingredients.length; i++) {
      countCost += clone_ingredients[i].getCost();
    }
    return Math.round(countCost * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    boolean hasRice = false;
    for (int i = 0; i < clone_ingredients.length; i++) {
      if (clone_ingredients[i].getIsRice()) {
        hasRice = true;
      }
    }
    return hasRice;
  }

  @Override
  public boolean getHasShellfish() {
    boolean hasShell = false;
    for (int i = 0; i < clone_ingredients.length; i++) {
      if (clone_ingredients[i].getIsShellfish()) {
        hasShell = true;
      }
    }
    return hasShell;
  }

  @Override
  public boolean getIsVegetarian() {
    boolean isVeg = false;
    for (int i = 0; i < clone_ingredients.length; i++) {
      if (clone_ingredients[i].getIsVegetarian()) {
        isVeg = true;
      }
    }
    return isVeg;
  }
}
