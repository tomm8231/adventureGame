package com.company;

import javax.swing.text.Utilities;
import java.util.ArrayList;

public class Player {

  private Room currentRoom;
  private int healthStatus = 100;
  private ArrayList<Item> inventoryPlayer = new ArrayList<>();
  private ArrayList<Item> equippedWeapon = new ArrayList<>();
// change to Weapon

  public int getHealthStatus() {
    return healthStatus;
  }

  // use later?
  public void setHealthStatus(int healthStatus) {
    this.healthStatus = healthStatus;
  }

  public ArrayList<Item> getEquippedWeapon() {
    return equippedWeapon;
  }

  public Usability tryEquip(String itemName) {

    Item foundItemPlayer = findItemPlayer(itemName);

    // Check if it is a weapon

    if (foundItemPlayer == null) { // not in backpack
      Item foundItemRoom = currentRoom.findItemRoom(itemName);
      if (foundItemRoom != null) {
        if (foundItemRoom instanceof Weapon) {
          return Usability.NOT_PRESENT_WEAPON;
        } else {
          return Usability.NOT_PRESENT;
        }
      } else if (foundItemPlayer == null) {
        return Usability.NOT_PRESENT;
      }
    }
    if (foundItemPlayer instanceof Weapon) {
      equipWeapon((Weapon) foundItemPlayer);
      return Usability.USABLE;

    } else return Usability.NON_USABLE;
  }

  public Weapon equipWeapon(Weapon weapon) {

    boolean isEmpty = equippedWeapon.isEmpty();

    if (isEmpty) {
      inventoryPlayer.remove(weapon);
      equippedWeapon.add(weapon);
      return weapon;
    } else {
      inventoryPlayer.add(equippedWeapon.get(0));
      equippedWeapon.clear();
      equippedWeapon.add(weapon);
      inventoryPlayer.remove(weapon);
      return weapon;
    }
  }

  public Usability checkWeapon(Weapon weapon) {
    int ammoLeft = weapon.remainingUses();

    if (equippedWeapon.isEmpty()) {
      return Usability.NOT_PRESENT_WEAPON; // if not equipped weapon
    }

    if (ammoLeft > 0) {
      return Usability.USABLE;
    } else {
      return Usability.NON_USABLE;
      // RangedWeapon rangedWeapon = (RangedWeapon) getEquippedWeapon().get(0); //type caste
    }
  }




/*
 public Usability checkWeapon(Weapon weapon) {
    int ammoLeft = weapon.remainingUses();
    //TODO: Ændre til det samme som i UI!
    if(equippedWeapon.isEmpty()){

    }

    if (equippedWeapon.get(0) != null) { // weapon is equipped
      if (ammoLeft > 0) {
        return Usability.USABLE;
      } else {
        return Usability.NON_USABLE;
        // RangedWeapon rangedWeapon = (RangedWeapon) getEquippedWeapon().get(0); //type caste
      }
    }
      return Usability.NOT_PRESENT_WEAPON; // if not equipped weapon
  }
 */


  public Usability attackEnemy() {

    ArrayList<Item> weapons = equippedWeapon;
    if (weapons.isEmpty()) {
      return Usability.NOT_PRESENT_WEAPON;
    } else {
      Usability found = checkWeapon((Weapon) getEquippedWeapon().get(0));

      if (found == Usability.USABLE) {
        ((Weapon) getEquippedWeapon().get(0)).setHitAttempts();
        return Usability.USABLE;
      }
    }
    return null;
  }




      // use in next part:
      //  int healthDamage = ((Weapon) getEquippedWeapon().get(0)).getHealthDamage();
      //  ((Weapon) getEquippedWeapon().get(0)).setHealthDamage(healthDamage);




  public Usability tryEatFood(String itemName) {

    // search if the food is available
    Item foundItem = currentRoom.findItemRoom(itemName);

    if (foundItem == null) {
      foundItem = findItemPlayer(itemName);
      if (foundItem == null) {
        return Usability.NOT_PRESENT;
      }
    }

    if (foundItem instanceof Food) {
      eat((Food) foundItem);
      return Usability.USABLE;
    } else return Usability.NON_USABLE;

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
