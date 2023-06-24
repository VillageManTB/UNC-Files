package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  private String name;

  private IngredientPortion ingredient;

  public Sashimi(SashimiType type) {

    if (type == SashimiType.TUNA) {
      this.name = "tuna sashimi";
      this.ingredient = new TunaPortion(0.75);
    } else if (type == SashimiType.YELLOWTAIL) {
      this.name = "yellowtail sashimi";
      this.ingredient = new YellowtailPortion(0.75);
    } else if (type == SashimiType.EEL) {
      this.name = "eel sashimi";
      this.ingredient = new EelPortion(0.75);
    } else if (type == SashimiType.CRAB) {
      this.name = "crab sashimi";
      this.ingredient = new CrabPortion(0.75);
    } else if (type == SashimiType.SHRIMP) {
      this.name = "shrimp sashimi";
      this.ingredient = new ShrimpPortion(0.75);
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingArr = new IngredientPortion[1];
    ingArr[0] = ingredient;
    return ingArr;
  }

  @Override
  public int getCalories() {
    return (int) Math.round(this.ingredient.getCalories());
  }

  @Override
  public double getCost() {
    return this.ingredient.getCost();
  }

  @Override
  public boolean getHasRice() {
    return this.ingredient.getIsRice();
  }

  @Override
  public boolean getHasShellfish() {
    return this.ingredient.getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return this.ingredient.getIsVegetarian();
  }

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
