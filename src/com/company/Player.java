package com.company;

import java.util.ArrayList;

public class Player {

  private Room currentRoom;
  private int healthStatus = 100;
  private ArrayList<Item> inventoryPlayer = new ArrayList<>();


  public int getHealthStatus(){
    return healthStatus;
  }

  public void setHealthStatus(int healthStatus) {
    this.healthStatus = healthStatus;
  }

  // Should return an enum, for ex. EDIBLE
  public int tryEatFood(Item itemName){
    // search if the food is available

    // move this to where?
    setHealthStatus(getHealthStatus() + itemName.getHealth());
    //currentRoom.removeItem(itemName);
    // Should also check the rooms items
    inventoryPlayer.remove(itemName);

    return healthStatus;
  }


  public Item findItemRoom(String itemName) {

    for (Item item : currentRoom.getItems()) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }

  public Item findItemPlayer(String itemName) {

    for (Item item : inventoryPlayer) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }

  public String takeItem(String itemName) {
    // remove from cave´s arrayList and put into players arrayList

    Item item = findItemRoom(itemName);

    if (item != null) {
      inventoryPlayer.add(item);
      currentRoom.removeItem(item);
      String itemNameFirstLetterCapitalised = capitaliseFirstLetterItem(item);
      return itemNameFirstLetterCapitalised + " has been added to your backpack.";

    } else return "There is nothing like " + itemName + " in this cave.";
  }


  public String dropItem(String itemName) {
    // remove from players arrayList and add to the Arraylist of the cave
    Item item = findItemPlayer(itemName);

    if (item != null) {
      currentRoom.addItem(item);
      inventoryPlayer.remove(item);
      String ItemNameFirstLetterCapitalised = capitaliseFirstLetterItem(item);
      return ItemNameFirstLetterCapitalised + " has been dropped";

    } else return "There is nothing like " + itemName + " in your backpack.";
  }

  public String capitaliseFirstLetterItem(Item item) {
    String itemNameUpperCase = item.getName().substring(0,1).toUpperCase() + item.getName().substring(1).toLowerCase();
    return itemNameUpperCase;
  }


  public ArrayList<Item> getBackpackInventory(){
    return inventoryPlayer;
  }

  public boolean checkEmptyBackpack(){
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
