package com.company;


import java.util.ArrayList;

public class Room {

  private String name;
  private String description;
  private ArrayList<Item> items;
  private ArrayList<Enemy> enemies;

  private Room north;
  private Room south;
  private Room east;
  private Room west;


  public Room(String name, String description) {
    this.name = name;
    this.description = description;
    this.items = new ArrayList<>();
    this.enemies = new ArrayList<>();
  }

  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
  }

  public void removeEnemy(Enemy enemy) {
    this.enemies.remove(enemy);
  }

  public Enemy findEnemyRoom(String enemyName) {
    for (Enemy enemy : enemies) {
      if (enemy.getName().equals(enemyName)) {
        return enemy;
      }
    }
    return null;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }



  public void addItem(Item item){
    items.add(item);
  }

  public Item findItemRoom(String itemName) {

    for (Item item : items) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }

  // deleteItem should be done in Room public Item deleteItem(String name) med for-løkke
  // we do not use this method!
  public Item deleteItem() {
    for (int i = 0; i < items.size(); i++) {
      Item temp = items.get(i);
      if (temp.getName().equals(name)) {
        items.remove(temp);

      }
    }
    return null;
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public ArrayList<Item> getItems() {
    return items;
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
