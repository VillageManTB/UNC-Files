package com.comp301.a01sushi;

public class RicePortion extends IngredientPortionParent {
  public RicePortion(double amount) {
    super(amount, new Rice());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public RicePortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new RicePortion(this.getAmount() + other.getAmount());
    }
  }
}
