package com.company;

public class RangedWeapon extends Weapon  {
protected int rangeWeapon;


  public RangedWeapon(String name, String description, int healthDamage, int range) {
    super(name, description, healthDamage);
    this.rangeWeapon = range;
  }
}