package com.company;

import java.util.ArrayList;

public class Player {

  private Room currentRoom;
  private int healthStatus = 100;
  private ArrayList<Item> inventoryPlayer = new ArrayList<>();


  public int getHealthStatus() {
    return healthStatus;
  }

  public void setHealthStatus(int healthStatus) {
    this.healthStatus = healthStatus;
  }

  public Edible tryEquip(String itemName){
    Item foundItem = currentRoom.findItemRoom(itemName);

    if (foundItem == null){
      foundItem = findItemPlayer(itemName);
      if (foundItem == null){
        return Edible.NOT_PRESENT;
      }
    }
    if (foundItem instanceof Weapon){
      equipWeapon((Weapon) foundItem);
      return Edible.EDIBLE;

    } else return Edible.NON_EDIBLE; //TODO: Ændre navn på enum!
  }

  public void equipWeapon(Weapon weapon){
    inventoryPlayer.remove(weapon);
    // adde det valgte våben til nyt array eller arraylist? playersWeapon
    // switch sådan at hvis man vælger et nyt våben som equip, så går det forrige tilbage i inventoryPlayer

  }

  // Should return an enum, for ex. EDIBLE
  public Edible tryEatFood(String itemName) { // String eller Item?

    // search if the food is available
    Item foundItem = currentRoom.findItemRoom(itemName);

    if (foundItem == null) {
      foundItem = findItemPlayer(itemName);
      if (foundItem == null) {
        return Edible.NOT_PRESENT;
      }
    }

    if (foundItem instanceof Food) {
      eat((Food) foundItem);
      return Edible.EDIBLE;
    } else return Edible.NON_EDIBLE;

  }

  public void updateHealthStatus(int healthStatus) {
    this.healthStatus += healthStatus;
  }

  public void eat(Food food) {
    updateHealthStatus(food.getHealth());
    inventoryPlayer.remove(food);
    currentRoom.removeItem(food);
  }

  public Item findItemPlayer(String itemName) {

    for (Item item : inventoryPlayer) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }

  public Item takeItem(Item found) {

    if (found != null) {
      inventoryPlayer.add(found);
      currentRoom.removeItem(found);
      return found;
    } else return null;

  }

  public Item dropItem(Item found) {

    if (found != null) {
      currentRoom.addItem(found);
      inventoryPlayer.remove(found);
      return found;
    } else return null;

  }

  public ArrayList<Item> getBackpackInventory() {
    return inventoryPlayer;
  }

  public boolean checkEmptyBackpack() {
    boolean result = inventoryPlayer.isEmpty();
    return result;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public Room movePlayer(String direction) {
    Room nextRoom = null;
    if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
      nextRoom = findNewRoom(direction);
      if (nextRoom != null) {
        currentRoom = nextRoom;
      }
    }
    return nextRoom;
  }


  public Room findNewRoom(String direction) {

    if (direction.equals("north")) {
      return currentRoom.getNorth();
    } else if (direction.equals("south")) {
      return currentRoom.getSouth();
    } else if (direction.equals("east")) {
      return currentRoom.getEast();
    } else if (direction.equals("west")) {
      return currentRoom.getWest();
    } else return null;
  }


}
