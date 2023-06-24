package com.comp301.a01sushi;

public class IngredientPortionParent implements IngredientPortion {
  private final Ingredient ingredient;
  private final double amount;

  public IngredientPortionParent(double amount, Ingredient ingredient) {
    this.amount = amount;
    this.ingredient = ingredient;
  }

  @Override
  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return (this.amount * ingredient.getCaloriesPerOunce());
  }

  @Override
  public double getCost() {
    return ((this.amount * ingredient.getPricePerOunce()) * 100.0) / 100.0;
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {

    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new IngredientPortionParent(
          this.getAmount() + other.getAmount(), other.getIngredient());
    }
  }
}
