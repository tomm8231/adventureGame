package com.company;

import java.util.ArrayList;

public class Enemy {


  private String name;
  private String description;
  private int healthPoints;
  private ArrayList<Item> equippedWeaponEnemy = new ArrayList<>();
  private boolean isEnemyAlive;

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


  public String attackedByPlayer(Weapon weapon, Room room){

  // getDamage(Weapon)
    Weapon equippedWeaponPlayer = weapon;
    System.out.println("Enemy HP before attack: " + getHealthPoints());
    setHealthPoints(equippedWeaponPlayer.healthDamage);
    System.out.println("Enemy HP after been attacked " + getHealthPoints());

    isEnemyAlive = isEnemyAlive();

    if(isEnemyAlive){
      attackPlayer();
      return "Enemy is still alive.\nWhat's your next move?";
    } else {
      dropWeapon((Weapon) equippedWeaponEnemy.get(0), room);
      removeDeadEnemy(room);
      return "The enemy is dead and seems to have dropped something.";
    }
  }

  public boolean isEnemyAlive(){
    if (healthPoints <= 0){
      return false;
    } else {
      return true;
    }
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

