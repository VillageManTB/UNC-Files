package com.comp301.a01sushi;

public class EelPortion extends IngredientPortionParent {
  public EelPortion(double amount) {
    super(amount, new Eel());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public EelPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new EelPortion(this.getAmount() + other.getAmount());
    }
  }
}
