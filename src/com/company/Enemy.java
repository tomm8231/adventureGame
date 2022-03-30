package com.company;

import java.util.ArrayList;

public class Enemy {


  private String name;
  private String description;
  private int healthPoints;
  private ArrayList<Item> equippedWeaponEnemy = new ArrayList<>();
  //private boolean isAliveEnemy;
  //TODO: Skal arrayList være protected?


  public Enemy(String name, String description, int healthPoints, Weapon weapon) {
    this.name = name;
    this.description = description;
    this.healthPoints = healthPoints;
    this.equippedWeaponEnemy.add(weapon);

  }

  public Usability attackPlayer() {
    ((Weapon) getEquippedWeaponEnemy().get(0)).setHitAttempts();
    // returnere våbenets health damage?
    return Usability.USABLE;
  }

  public void attackedByPlayer(Weapon weapon){
  // getDamage(Weapon) from Player
    Weapon equippedWeaponPlayer = weapon;
    setHealthPoints(equippedWeaponPlayer.healthDamage);

    //isAliveEnemy = enemyDead();

    if(!enemyDead()){

    }

  }

  public boolean enemyDead(){
    if (healthPoints <= 0){
      return false;
    } else {
      return true;
    }
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

