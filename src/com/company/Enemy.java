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
    // returnere våbenets health damage?
    return ((Weapon) getEquippedWeaponEnemy().get(0)).getHealthDamage();
  }


  public void attackedByPlayer(Weapon weapon, Room room){

  // getDamage(Weapon) from Player
    Weapon equippedWeaponPlayer = weapon;
    setHealthPoints(equippedWeaponPlayer.healthDamage);

    isEnemyAlive = isEnemyAlive();

    if(isEnemyAlive){
      //TODO: BUG: attackedByEnemy(equippedWeaponPlayer);
      System.out.println("Enemy is alive. Attack again");
    } else{
      dropWeapon((Weapon) equippedWeaponEnemy.get(0), room);
      removeDeadEnemy(room);
    }

    attackPlayer();
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

