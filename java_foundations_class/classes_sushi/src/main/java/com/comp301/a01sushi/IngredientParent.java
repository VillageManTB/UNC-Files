package com.comp301.a01sushi;

public class IngredientParent implements Ingredient {
  private final double price;
  private final String name;
  private final int calories;
  private final boolean isVeg;
  private final boolean hasRice;
  private final boolean hasShell;

  public IngredientParent(
      double price, String name, int calories, boolean isVeg, boolean hasRice, boolean hasShell) {
    this.price = price;
    this.name = name;
    this.calories = calories;
    this.isVeg = isVeg;
    this.hasRice = hasRice;
    this.hasShell = hasShell;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return calories / price;
  }

  @Override
  public int getCaloriesPerOunce() {
    return calories;
  }

  @Override
  public double getPricePerOunce() {
    return price;
  }

  @Override
  public boolean getIsVegetarian() {
    return isVeg;
  }

  @Override
  public boolean getIsRice() {
    return hasRice;
  }

  @Override
  public boolean getIsShellfish() {
    return hasShell;
  }

  @Override
  public boolean equals(Ingredient other) {
    if (other == null) {
      return false;
    } else
      return name == other.getName()
          && calories == other.getCaloriesPerOunce()
          && price == other.getPricePerOunce()
          && isVeg == other.getIsVegetarian()
          && hasRice == other.getIsRice()
          && hasShell == other.getIsShellfish();
  }
}
