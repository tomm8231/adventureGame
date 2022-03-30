package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

  private Player player;
  private Map map;
  private boolean isAlive;


  public void welcomeMessage() {
    newLine();
    System.out.println("Welcome to Adventure Iceland!");
    System.out.println("""
                
           _____       .___                    __                         .___             .__                     .___._.
          /  _  \\    __| _/__  __ ____   _____/  |_ __ _________   ____   |   | ____  ____ |  | _____    ____    __| _/| |
         /  /_\\  \\  / __ |\\  \\/ // __ \\ /    \\   __\\  |  \\_  __ \\_/ __ \\  |   |/ ___\\/ __ \\|  | \\__  \\  /    \\  / __ | | |
        /    |    \\/ /_/ | \\   /\\  ___/|   |  \\  | |  |  /|  | \\/\\  ___/  |   \\  \\__\\  ___/|  |__/ __ \\|   |  \\/ /_/ |  \\|
        \\____|__  /\\____ |  \\_/  \\___  >___|  /__| |____/ |__|    \\___  > |___|\\___  >___  >____(____  /___|  /\\____ |  __
                \\/      \\/           \\/     \\/                        \\/           \\/    \\/          \\/     \\/      \\/  \\/
                
        """);

    System.out.println("""
        You have arrived to Iceland to experience the legendary lava caves, which no adventurer has ever been able to document before.
        You have heard various rumors, from purple stalactites all over to some horror stories, which can not be rooted in reality - you think.
        Get ready for the Adventure of Vatnajökull!
        """);

    System.out.println("Press enter to play game");
  }

  public void showCommands() {
    System.out.println("COMMANDS:");
    System.out.println("\"Look\" | Description of surroundings");
    System.out.println("\"Take\" | Pick up an item you find");
    System.out.println("\"Drop\" | Get rid of an item from your inventory");
    System.out.println("\"Equip\" | Choose your weapon from your inventory");
    System.out.println("\"Attack\" | Attack your enemy");
    System.out.println("\"Inventory\" | View your bag of things");
    System.out.println("\"Health\" | Health status");
    System.out.println("\"Help\" | Game instructions");
    System.out.println("\"Exit\" | Quit game");
    newLine();
    System.out.println("Directions:\n\"Go north\"\n\"Go south\"\n\"Go east\"\n\"Go west\"");
    newLine();
  }


  public void startGame() {

    // Music code fetched from some YouTube tutorial
    /* String filepath = "music.wav";
    PlayMusic play = new PlayMusic();
    play.playMusic(filepath);
     */

    map = new Map();
    player = new Player();
    map.createCaves();
    player.setCurrentRoom(map.getStarterRoom());
    Scanner sc = new Scanner(System.in);

    welcomeMessage();
    sc.nextLine();
    showCommands();
    displayIntroCave();
    loopGame();
/*
    isAlive = true;
    String input = "";

    do {

      input = sc.nextLine().trim().toLowerCase();


      if (input.equals("look")) {
        lookAround();

      } else if (input.startsWith("go ")) {
        goHelpMethod(input);

      } else if (input.startsWith("take ")) {
        takeHelpMethod(input);

      } else if (input.startsWith("drop ")) {
        dropHelpMethod(input);

      } else if (input.equals("inventory")) {
        inventoryHelpMethod();

      } else if (input.equals("health")) {
        checkHealthStatus();

      } else if (input.startsWith("eat ")) {
        eatHelpMethod(input);

      } else if (input.startsWith("equip ")) {
        equipHelpMethod(input);

      } else if (input.startsWith("attack ")) {
        attackHelpMethod(input);

      } else if (input.equals("help")) {
        showCommands();

      } else if (input.equals("exit")) {
        System.out.println("Exiting game");

      } else {
        System.out.println("\"" + input + "\" is not a valid command. Try again!");
      }

      warningHealth();

      isAlive = player.playerDead();
      if (!isAlive) {
        playAgain(isAlive);
      }

    } while (!input.equals("exit") && (isAlive));



 */
  }

  public void loopGame(){

    Scanner sc = new Scanner(System.in);

    String input;

    isAlive = true;
    do {

     input = sc.nextLine().trim().toLowerCase();

      if (input.equals("look")) {
        lookAround();

      } else if (input.startsWith("go ")) {
        goHelpMethod(input);

      } else if (input.startsWith("take ")) {
        takeHelpMethod(input);

      } else if (input.startsWith("drop ")) {
        dropHelpMethod(input);

      } else if (input.equals("inventory")) {
        inventoryHelpMethod();

      } else if (input.equals("health")) {
        checkHealthStatus();

      } else if (input.startsWith("eat ")) {
        eatHelpMethod(input);

      } else if (input.startsWith("equip ")) {
        equipHelpMethod(input);

      } else if (input.startsWith("attack ")) {
        attackHelpMethod(input);


      } else if (input.equals("help")) {
        showCommands();

      } else if (input.equals("exit")) {
        System.out.println("Exiting game");

      } else {
        System.out.println("\"" + input + "\" is not a valid command. Try again!");
      }

      warningHealth();
      afterDeath();


    } while (!input.equals("exit") && (isAlive));


  }


  public void playAgain(boolean isAlive) {
    Scanner sc = new Scanner(System.in);
    String answer = "";
    int counter = 0;

    while (!answer.equals("yes") && !answer.equals("no"))
      if (!isAlive) {
        if (counter < 1) {
          System.out.println("Play again? (yes/no)");
          counter++;
        }
        answer = sc.nextLine().trim().toLowerCase();
        if (answer.equals("yes")) {
          isAlive = true;
          startGame();
        } else if (answer.equals("no")) {
          System.out.println("Quitting game...");
          isAlive = false;
        } else if (!answer.equals("yes") || !answer.equals("no"))
          System.out.println("Please answer yes or no");
      }
  }

  public void afterDeath(){

    isAlive = player.playerDead();

    if (!isAlive){
      playAgain(isAlive);
    }
  }


  public void displayIntroCave() {
    System.out.println("""
        You have abseiled into a very small and dark cave with four tiny
        tunnels, you have no clues witch way to go. This cave is named The Claustrophobia...
                    
        What do you do?
        """);
  }


  public void checkUsabilityWeapon(Usability usability) {

    if (usability == Usability.NOT_PRESENT) {
      System.out.println("This item is not in your backpack.");

    } else if (usability == Usability.NOT_PRESENT_WEAPON) {
      System.out.println("This weapon is not in your backpack.");

    // Find the equipped weapon in Player Class
    } else if (usability == Usability.USABLE) {
      ArrayList<Item> found = player.getEquippedWeapon();
      System.out.println("You're now carrying the " + player.getEquippedWeapon().get(0).getName() + " in your hands.");

    } else if (usability == Usability.NON_USABLE) {
      System.out.println("This item is not a weapon!");
    }
  }

  public String capitaliseFirstLetterItem(Item item) {
    return item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1).toLowerCase();
  }

  public String capitaliseFirstLetterItem(String item) {
    return item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase();

  }

  public String capitaliseFirstLetterEnemy(Enemy enemy) {
    return enemy.getName().substring(0, 1).toUpperCase() + enemy.getName().substring(1).toLowerCase();

  }

  public void lookAround() {
    System.out.println("Looking around...");
    System.out.println(player.getCurrentRoom().getName());
    System.out.println(player.getCurrentRoom().getDescription());

    boolean isCaveEmpty = player.getCurrentRoom().getItems().isEmpty();

    if (isCaveEmpty) {
      System.out.println("You can not see any items to pick up in this cave");
    } else
      System.out.println("In the cave you can see:");

    StringBuilder sb = new StringBuilder();
    for (Item item : player.getCurrentRoom().getItems()) {
      String itemNameFirstLetterCapitalised = capitaliseFirstLetterItem(item) + ": " + item.getDescription() + "\n";
      sb.append(itemNameFirstLetterCapitalised);
    }
    System.out.println(sb);

    StringBuilder sbEnemy = new StringBuilder();
    for (Enemy enemy : player.getCurrentRoom().getEnemies()){
      String enemyNameFirstLetterCapitalised = capitaliseFirstLetterEnemy(enemy) + ": " + enemy.getDescription() + "\n";
      sbEnemy.append(enemyNameFirstLetterCapitalised);
    }
    System.out.println(sbEnemy);
  }

  public void goHelpMethod(String input) {
    String direction = input.substring(input.indexOf(" ") + 1);
    Room room = player.movePlayer(direction);
    checkValidDirection(room, direction);
  }


  public void takeHelpMethod(String input) {
    String itemName = input.substring(input.indexOf(" ") + 1);
    Item found = player.getCurrentRoom().findItemRoom(itemName);
    Item itemTaken = player.takeItem(found);

    if (itemTaken != null) {
      String itemNameFirstLetterCapitalised = capitaliseFirstLetterItem(itemTaken);
      System.out.println(itemNameFirstLetterCapitalised + " has been added to your pack.");
    } else {
      System.out.println("There's nothing " + itemName + " in this cave.");
    }
  }

  public void dropHelpMethod(String input) {
    String itemName = input.substring(input.indexOf(" ") + 1);
    Item found = player.findItemPlayer(itemName);
    Item itemDropped = player.dropItem(found);

    if (itemDropped != null) {
      String itemNameFirstLetterCapitalised = capitaliseFirstLetterItem(itemDropped);
      System.out.println(itemNameFirstLetterCapitalised + " has been dropped.");
    } else {
      System.out.println("There is nothing like " + itemName + " in your backpack.");
    }
  }

  public void equipHelpMethod(String input) {
    String requestedWeapon = input.substring(input.indexOf(" ") + 1);
    Usability found = player.tryEquip(requestedWeapon);
    checkUsabilityWeapon(found);
  }

// print when player writes "inventory"
  public void showEquippedWeaponInventory() {

    if (player.getEquippedWeapon().isEmpty()) {
      System.out.println("You are not equipped with any weapon");
    } else {
      System.out.println("You are equipped with: " + player.getEquippedWeapon().get(0).getName());
    }
  }

  public void displayCheckedWeaponAttack() {
    ArrayList<Item> playerEquippedWeapon = player.getEquippedWeapon();

    if (playerEquippedWeapon.isEmpty()) {
      System.out.println("You are not equipped with any weapon!");
    } else {
      Weapon equippedWeapon = (Weapon) player.getEquippedWeapon().get(0);
      Usability usabilityWeapon = player.checkWeapon(equippedWeapon);
      System.out.println("You are equipped with: " + player.getEquippedWeapon().get(0).getName());

      if (usabilityWeapon == Usability.USABLE) {
        System.out.println("Attack the enemy!");

      } else if (usabilityWeapon == Usability.NON_USABLE) {
        System.out.println("Sorry your weapon is out ammo!");
      }
    }
  }

  public void inventoryHelpMethod() {
    // boolean true
    if (player.checkEmptyBackpack()) {
      System.out.println("You have nothing in your backpack");
    } else
      System.out.println("In your backpack you have:");
    showBackpackInventory(player.getBackpackInventory());
    showEquippedWeaponInventory();
  }

  public void attackHelpMethod(String input) {
    String requestedEnemy = input.substring(input.indexOf(" ") + 1);
    displayCheckedWeaponAttack();
    player.attackEnemy(requestedEnemy);
  }

  public void eatHelpMethod(String input) {
    String requestedFood = input.substring(input.indexOf(" ") + 1);
    Usability found = player.tryEatFood(requestedFood);


    if (found == Usability.USABLE) {
      System.out.println("You have eaten the " + requestedFood);
      System.out.println("HP: " + player.getHealthPoints());
    } else if (found == Usability.NON_USABLE) {
      System.out.println("You can not eat the " + requestedFood);
    } else {
      String requestedFoodCapitalised = capitaliseFirstLetterItem(requestedFood);
      System.out.println(requestedFoodCapitalised + " is not within reach.");
    }
  }


  public void showBackpackInventory(ArrayList<Item> inventoryPlayer) {

    for (Item item : inventoryPlayer) {
      String temp = capitaliseFirstLetterItem(item);
      System.out.println(temp);
    }
  }

  public void checkValidDirection(Room cave, String direction) {

    if (cave == null) {
      System.out.println("Ófærð! Try another path.");

    } else {
      System.out.println("Going " + direction + "...\n" +
          "\n----------------\n" +
          "You have entered \"" + player.getCurrentRoom().getName() + "\":\n" +
          player.getCurrentRoom().getDescription() +
          "\n----------------\n");
    }
  }


  public void warningHealth() {
    int tempHealth = player.getHealthPoints();

    if (tempHealth < 25 && tempHealth > 0) {
      System.out.println("Warning: Your health points are low!");
    } else if (tempHealth <= 0) {
      System.out.println("You are dead");
    }
  }


  public void checkHealthStatus() {
    int tempHealth = player.getHealthPoints();

    if (tempHealth <= 100 && tempHealth >= 75) {
      System.out.println(tempHealth + " - You're in good shape!");
    } else if (tempHealth < 75 && tempHealth >= 50) {
      System.out.println(tempHealth + " - You're in okay shape. Some healthy food would be good for you!");
    } else if (tempHealth < 50 && tempHealth >= 25) {
      System.out.println(tempHealth + " - You're getting weak! Consider what you consume and try avoid combats.");
    } else if (tempHealth < 25 && tempHealth >= 1) {
      System.out.println(tempHealth + " - You're in health danger! Go find some healthy food before anything else!");
    }
  }

  public void newLine() {
    System.out.println();
  }

}

