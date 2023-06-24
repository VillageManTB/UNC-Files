package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  private final IngredientPortion[] ingredients = new IngredientPortion[2];
  private String name;

  public Nigiri(NigiriType type) {

    if (type == NigiriType.TUNA) {
      this.name = "tuna nigiri";
      ingredients[0] = new TunaPortion(0.75);
    } else if (type == NigiriType.YELLOWTAIL) {
      this.name = "yellowtail nigiri";
      ingredients[0] = new YellowtailPortion(0.75);
    } else if (type == NigiriType.EEL) {
      this.name = "eel nigiri";
      ingredients[0] = new EelPortion(0.75);
    } else if (type == NigiriType.CRAB) {
      this.name = "crab nigiri";
      ingredients[0] = new CrabPortion(0.75);
    } else if (type == NigiriType.SHRIMP) {
      this.name = "shrimp nigiri";
      ingredients[0] = new ShrimpPortion(0.75);
    }
    ingredients[1] = new RicePortion(0.5);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return ingredients;
  }

  @Override
  public int getCalories() {
    return (int) Math.round(ingredients[0].getCalories() + ingredients[1].getCalories());
  }

  @Override
  public double getCost() {
    return (ingredients[0].getCost() + ingredients[1].getCost());
  }

  @Override
  public boolean getHasRice() {
    Ingredient ing = ingredients[0].getIngredient();
    Ingredient ing2 = ingredients[1].getIngredient();
    return (ing.getIsRice() || ing2.getIsRice());
  }

  @Override
  public boolean getHasShellfish() {
    Ingredient ing = ingredients[0].getIngredient();
    Ingredient ing2 = ingredients[1].getIngredient();
    return (ing.getIsShellfish() || ing2.getIsShellfish());
  }

  @Override
  public boolean getIsVegetarian() {
    Ingredient ing = ingredients[0].getIngredient();
    Ingredient ing2 = ingredients[1].getIngredient();
    return (ing.getIsVegetarian() || ing2.getIsVegetarian());
  }

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
