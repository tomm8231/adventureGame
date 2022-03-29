package com.company;

public class Enemy {


  private String name;
  private String description;
  private int healthPoints;



  public Enemy(String name, String description, int healthPoints) {
    this.name = name;
    this.description = description;
    this.healthPoints = healthPoints;
  }


  public String getName() {
    return name;
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

