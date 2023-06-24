package com.comp301.a01sushi;

public class AvocadoPortion extends IngredientPortionParent {
  public AvocadoPortion(double amount) {
    super(amount, new Avocado());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public AvocadoPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new AvocadoPortion(this.getAmount() + other.getAmount());
    }
  }
}
