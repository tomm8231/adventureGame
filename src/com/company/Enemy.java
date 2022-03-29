package com.company;

import java.util.ArrayList;

public class Enemy {


  private String name;
  private String description;
  private int healthPoints;
  ArrayList<Item> equippedWeaponEnemy = new ArrayList<>();



  public Enemy(String name, String description, int healthPoints, Weapon weapon) {
    this.name = name;
    this.description = description;
    this.healthPoints = healthPoints;
    equipEnemy(weapon);
  }


  public void equipEnemy(Weapon weapon) {
    equippedWeaponEnemy.add(weapon);
  }

  public Usability attackPlayer() {
    ((Weapon) getEquippedWeaponEnemy().get(0)).setHitAttempts();
    return Usability.USABLE;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Item> getEquippedWeaponEnemy() {
    return equippedWeaponEnemy;
  }

  public void setHealthPoints(int playerDamage) {
    this.healthPoints -= playerDamage;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public String toString() {
    return name + ": " + description;
  }




  public String getDescription() {
    return description;
  }

}

