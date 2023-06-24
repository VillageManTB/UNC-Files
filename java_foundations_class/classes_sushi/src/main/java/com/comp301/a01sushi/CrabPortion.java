package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortionParent {
  public CrabPortion(double amount) {
    super(amount, new Crab());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public CrabPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new CrabPortion(this.getAmount() + other.getAmount());
    }
  }
}
