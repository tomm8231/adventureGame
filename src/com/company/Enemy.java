package com.company;

import java.util.ArrayList;

public class Enemy {


  private String name;
  private String description;
  private int healthPoints;
  private ArrayList<Item> equippedWeaponEnemy = new ArrayList<>();

  public Enemy(String name, String description, int healthPoints, Weapon weapon) {
    this.name = name;
    this.description = description;
    this.healthPoints = healthPoints;
    this.equippedWeaponEnemy.add(weapon);

  }

  public int attackPlayer() {
    ((Weapon) getEquippedWeaponEnemy().get(0)).setHitAttempts();
    // return the health damage of the weapon
    return ((Weapon) getEquippedWeaponEnemy().get(0)).getHealthDamage();
  }


  public boolean attackedByPlayer(Weapon weapon, Room room){ //changed from String

  // getDamage(Weapon)
    Weapon equippedWeaponPlayer = weapon;
    System.out.println("TEST: Enemy HP before attack: " + getHealthPoints()); //TODO: Fjerne når det fungerer
    setHealthPoints(equippedWeaponPlayer.healthDamage);
    System.out.println("TEST: Enemy HP after been attacked " + getHealthPoints()); //TODO: Fjerne når det fungerer

    boolean isEnemyAlive = isEnemyAlive();

    if(isEnemyAlive){
      attackPlayer();
      return true;
    } else {
      dropWeapon((Weapon) equippedWeaponEnemy.get(0), room);
      removeDeadEnemy(room);
      return false;
    }
  }
//TODO: SE PÅ DETTE TORSDAG AFTEN!
/*
  public String attackedByPlayer(Weapon weapon, Room room){

    // getDamage(Weapon)
    Weapon equippedWeaponPlayer = weapon;
    System.out.println("TEST: Enemy HP before attack: " + getHealthPoints()); //TODO: Fjerne når det fungerer
    setHealthPoints(equippedWeaponPlayer.healthDamage);
    System.out.println("TEST: Enemy HP after been attacked " + getHealthPoints()); //TODO: Fjerne når det fungerer

    boolean isEnemyAlive = isEnemyAlive();

    if(isEnemyAlive){
      attackPlayer();
      return "\n" + getName() + " is still alive.\n Enemy's HP is now " + getHealthPoints();
    } else {
      dropWeapon((Weapon) equippedWeaponEnemy.get(0), room);
      removeDeadEnemy(room);
      return "The enemy is dead and seems to have dropped something.";
    }
  }

 */ //attackedByPlayer before Marcus tried to fix it

  public boolean isEnemyAlive(){
    return healthPoints > 0;
  }



  public void dropWeapon(Weapon weapon, Room room) {
    room.addItem(weapon);
  }

  public void removeDeadEnemy(Room room){
    room.removeEnemy(room.getEnemies().get(0));
  }

  public String getName() {
    return name;
  }

  public ArrayList<Item> getEquippedWeaponEnemy() {
    return equippedWeaponEnemy;
  }

  public void setHealthPoints(int playerDamage) {
    this.healthPoints += playerDamage;
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

