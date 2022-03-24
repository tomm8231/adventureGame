package com.company;

// ikke lave new Weapon noget sted!

public abstract class Weapon extends Item {
  protected int healthDamage; // husk at lave attributt først!
  // protected, hele hiarkiet skal have tilgang

  public Weapon(String name, String description, int healthDamage) {
    super(name, description);
    this.healthDamage = healthDamage;

  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override // kan godt ligge i subclasses
  public String toString() {
    return "Health Damage: " + healthDamage;
  }
}
