package com.company;

public class RangedWeapon extends Weapon  {
protected int hitAttempts;


  public RangedWeapon(String name, String description, int healthDamage, int hitAttempts) {
    super(name, description, healthDamage);
    this.hitAttempts = hitAttempts;
  }

@Override
  public void setHitAttempts(){
    this.hitAttempts -= 1;
  }

@Override
  public int remainingUses(){
    return hitAttempts;
  }

}