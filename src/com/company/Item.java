package com.company;

public class Item {

  private String name;
  private String description;
  private int health;


  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Item() {

  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name + ": " + description;
  }

  public int getHealth() {
    return health;
  }

  public String getDescription() {
    return description;
  }


}