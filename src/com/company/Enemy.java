package com.company;

public class Enemy {


  private String name;
  private String description;



  public Enemy(String name, String description) {
    this.name = name;
    this.description = description;
  }


  public String getName() {
    return name;
  }

  public String toString() {
    return name + ": " + description;
  }


  public String getDescription() {
    return description;
  }

}

