package com.company;

public class RangedWeapon extends Weapon  {
protected int hitAttempts;


  public RangedWeapon(String name, String description, int healthDamage, int hitAttempts) {
    super(name, description, healthDamage);
    this.hitAttempts = hitAttempts;
  }

  public int getHitAttempts(){
    return hitAttempts;
  }

  public void setHitAttempts(int hit){
    this.hitAttempts -= hit;
  }

@Override
  public int remainingUses(){ // eller canUse() ??
    return hitAttempts;
  }

}