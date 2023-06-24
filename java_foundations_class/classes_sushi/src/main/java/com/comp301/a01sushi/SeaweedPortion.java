package com.comp301.a01sushi;

public class SeaweedPortion extends IngredientPortionParent {
  public SeaweedPortion(double amount) {
    super(amount, new Seaweed());
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  @Override
  public SeaweedPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("These ingredients are not equal");
    } else {
      return new SeaweedPortion(this.getAmount() + other.getAmount());
    }
  }
}
