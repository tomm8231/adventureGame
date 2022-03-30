package com.company;

import java.util.ArrayList;

public class Player {

  private Room currentRoom;
  private int healthPoints = 100;
  private ArrayList<Item> inventoryPlayer = new ArrayList<>();
  private ArrayList<Item> equippedWeapon = new ArrayList<>();


  public int getHealthPoints() {
    return healthPoints;
  }

  // use later?
  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
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

    }
  }


  public void attackEnemy(String enemyName) {

    ArrayList<Item> weaponPlayer = equippedWeapon;

    if (!weaponPlayer.isEmpty()) {

      ((Weapon) getEquippedWeapon().get(0)).setHitAttempts();

      Enemy enemy = currentRoom.findEnemyRoom(enemyName);
      // The enemy gets automatically attacked by Player, we send our weapon as parameter to the
      // method in the enemy Class: attackedByPlayer:

      if (enemy != null) {
        enemy.attackedByPlayer((Weapon) equippedWeapon.get(0));
        System.out.println("Enemy hp before attack: " + enemy.getHealthPoints()); //TODO: Enemy skal holde styr på sin egne HP
        enemy.setHealthPoints(10);

        System.out.println("Enemy hp after attack: " + enemy.getHealthPoints());

        setHealthPoints(healthPoints - enemy.attackPlayer());
      }
    }
  }

  public void attackedByEnemy(Weapon weapon){
    Weapon weaponEnemy = weapon;
    setHealthPoints(weaponEnemy.getHealthDamage());
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
    this.healthPoints += healthStatus;
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

  public boolean playerDead(){
    int tempHealth = getHealthPoints();
    if (tempHealth <= 0){
      return false;
    } else {
      return true;
    }
  }
}
