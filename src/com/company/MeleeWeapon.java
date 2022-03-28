package com.company;

public class MeleeWeapon extends Weapon {
  // Hvor mange gange skal man kunne bruge det før det bliver "ødelagt"


  public MeleeWeapon(String name, String description, int healthDamage) {
    super(name, description, healthDamage);
  }

  @Override
  public int remainingUses() {
    return 1;
  }

  @Override
  public void setHitAttempts() {
  }
}
