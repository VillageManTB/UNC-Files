package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortionParent {
  public ShrimpPortion(double amount) {
    super(amount, new Shrimp());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public ShrimpPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new ShrimpPortion(this.getAmount() + other.getAmount());
    }
  }
}
