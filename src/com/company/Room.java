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

  public void setNorth(Room cave) {
    north = cave;
    if(cave.south != this) {
      cave.setSouth(this);
    }
  }

  public Room getNorth() {
    return north;
  }

  public void setSouth(Room cave) {
    south = cave;
    if(cave.north != this) {
      cave.setNorth(this);
    }
  }

  public Room getSouth() {
    return south;
  }

  public void setEast(Room cave) {
    east = cave;
    if(cave.west != this) {
      cave.setWest(this);
    }
  }

  public Room getEast() {
    return east;
  }

  public void setWest(Room cave) {
    west = cave;
    if(cave.east != this) {
      cave.setEast(this);
    }
  }

  public Room getWest() {
    return west;
  }

  public String getName(){
    return name;
  }

  public String getDescription(){
    return description;
  }

}
