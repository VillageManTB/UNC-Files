package com.comp301.a01sushi;

public class YellowtailPortion extends IngredientPortionParent {
  public YellowtailPortion(double amount) {
    super(amount, new Yellowtail());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public YellowtailPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new YellowtailPortion(this.getAmount() + other.getAmount());
    }
  }
}
