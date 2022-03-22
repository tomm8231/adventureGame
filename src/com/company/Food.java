package com.company;

public class Food extends Item {

  private int health;
  Edible edible;


  public Food(String name, String description) {
    super(name, description);
  }

  public Food(String name, String description, int health, String edible) {
    super(name, description);
    this.health = health;
    this.edible = Edible.EDIBLE;
  }

  public Food() {
    super();
  }

  public int getHealth() {
    return health;
  }
}

