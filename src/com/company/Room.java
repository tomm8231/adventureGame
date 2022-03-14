package com.company;


public class Room {

  private String name;
  private String description;

  private Room north;
  private Room south;
  private Room east;
  private Room west;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;

  }

  public void setDescription(String aDescription){
    this.description = aDescription;

  }

  public void setNorth(Room cave) {
    north = cave;
  }

  public Room getNorth() {
    return north;
  }

  public void setSouth(Room cave) {
    south = cave;
  }

  public Room getSouth() {
    return south;
  }

  public void setEast(Room cave) {
    east = cave;
  }

  public Room getEast() {
    return east;
  }

  public void setWest(Room cave) {
    west = cave;
  }

  public Room getWest() {
    return west;
  }

  public String getName(){
    return name;
  }

  public void setName(String aName){
    this.name = aName;
  }

  public String getDescription(){
    return description;
  }

}
