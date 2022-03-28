package com.company;

// ikke lave new Weapon noget sted!

public abstract class Weapon extends Item {
  protected int healthDamage;



  public Weapon(String name, String description, int healthDamage) {
    super(name, description);
    this.healthDamage = healthDamage;
  }

  @Override
  public String getName() {
    return super.getName();
  }

  public int getHealthDamage() {
    return healthDamage;
  }

  public abstract int remainingUses(); // det skal være en metode i Weapon og en Override i RangedWeapon

  public abstract void setHitAttempts();


  @Override // kan godt ligge i subclasses
  public String toString() {
    return "Health Damage: " + healthDamage;
  }
}
