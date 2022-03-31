package com.company;

import java.util.ArrayList;

public class Enemy {


  private String name;
  private String description;
  private int healthPoints;
  private ArrayList<Item> weaponEnemy = new ArrayList<>();

  public Enemy(String name, String description, int healthPoints, Weapon weapon) {
    this.name = name;
    this.description = description;
    this.healthPoints = healthPoints;
    this.weaponEnemy.add(weapon);

  }

  public int attackPlayer() {
    ((Weapon) getWeaponEnemy().get(0)).setHitAttempts();
    // return the health damage of the weapon
    return ((Weapon) getWeaponEnemy().get(0)).getHealthDamage();
  }


  public void attackedByPlayer(Weapon weapon, Room room){

  // getDamage(Weapon)
    Weapon equippedWeaponPlayer = weapon;
    System.out.println("TEST: Enemy HP before attack: " + getHealthPoints()); //TODO: Fjerne når det fungerer
    setHealthPoints(equippedWeaponPlayer.healthDamage);
    System.out.println("TEST: Enemy HP after been attacked " + getHealthPoints()); //TODO: Fjerne når det fungerer

    boolean isEnemyAlive = isEnemyAlive();

    if(isEnemyAlive){
      attackPlayer();
    } else {
      dropWeapon((Weapon) weaponEnemy.get(0), room);
      removeDeadEnemy(room);
    }
  }


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

  public ArrayList<Item> getWeaponEnemy() {
    return weaponEnemy;
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

