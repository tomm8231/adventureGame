package com.company;

public class Item {

  private String name;
  private String description;

  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name + ": " + description;
  }

/*
  public void viewObjects(){
    for (int i = 0; i <= items.size(); i++) {
      System.out.println();
    }
  }

 */

  public void setName(String aName) {
    this.name = aName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String aDescription) {
    this.description = aDescription;
  }

}