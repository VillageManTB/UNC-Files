package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortionParent {
  public TunaPortion(double amount) {
    super(amount, new Tuna());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  public TunaPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new TunaPortion(this.getAmount() + other.getAmount());
    }
  }
}
