package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

  private Player player;
  private Map map;


  public void welcomeMessage(){
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
            You have arrived to Iceland with a sailboat, and you are on the most exciting trip of your life to experience
            the newly discovered lava caves, found by some researchers from the University of Aberdeen.
            You have heard that it is very difficult to find the greatest cave of them all, the one with purple stalactites all
            over, a huge waterfall and with the most amazing light, but with enough food, water and patience, you have decided
            to complete. Get ready for the Adventure of Vatnajökull!
            """);

    System.out.println("Press enter to play game");
  }

  public void showCommands() {
    System.out.println("COMMANDS:");
    System.out.println("\"Look\" | Description of surroundings");
    System.out.println("\"Take\" | Pick up an item you find");
    System.out.println("\"Drop\" | Get rid of an item from your inventory");
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
    System.out.println("""
            You have abseiled into a very small and dark cave with four tiny
            tunnels, you have no clues witch way to go. This cave is named The Claustrophobia...
            
            What do you do?
            """);


    // move this one?
    Torch torch = new Torch("torch", false);

    String input;
    do {

      input = sc.nextLine().trim().toLowerCase();

      if (input.equals("look")) {
        lookAround();
      }
        /*
        if (player.getCurrentRoom().getName().equals("The Mere Darkness")) {
          if (player.findItemPlayer("torch") == null) {
            System.out.println("You have to find a flashlight or torch or something to light up this dark cave!");
          }
        } else {
           lookAround(); // this is not finished
         }
        }
       /*else if (player.getCurrentRoom().getName().equals("The Mere Darkness") && player.findItemPlayer("torch").getName().equals("torch")) {
          System.out.println("It is dark, you have to write 'light on'.");

          // make a new method to check if the light is on?
          //BUG: you should only could see the things in the room if the light is on!lookAround();
        }*/

      else if (input.startsWith("go ")) {
        String direction = input.substring(input.indexOf(" ") + 1);
        Room room = player.movePlayer(direction);
        checkValidDirection(room, direction);

      } else if (input.startsWith("take ")) {
        String itemName = input.substring(input.indexOf(" ") + 1);
        System.out.println(player.takeItem(itemName));


      } else if (input.startsWith("drop ")) {
        String itemName = input.substring(input.indexOf(" ") + 1);
        System.out.println(player.dropItem(itemName));


      } else if (input.equals("inventory")) {
        if(player.checkEmptyBackpack() == true){
        System.out.println("You have nothing in your backpack");
        } else
        System.out.println("In your backpack you have:");
        showBackpackInventory(player.getBackpackInventory());

      } else if (input.equals("health")){
        checkHealthStatus();

      } else if (input.startsWith("eat ")){
        String eatenFood = input.substring(input.indexOf(" ") + 1);
        Item item = player.findItemPlayer(eatenFood);
        System.out.println(player.tryEatFood(item));

        // koble 2 arraylist??
        // hvordan også kunne spise food fra rum og vide om man spiser fra backpack eller room hvis flere genstander?

        if (item != null) {
          System.out.println("Spist");
        } else {
          System.out.println("Ikke spist");
        }

      }
       else if (input.equals("help")) {
        showCommands();

      } else if (input.equals("exit")) {
        System.out.println("Exiting game");

      } else if (input.equals("light on")) {
        // if you turn on the light and go to next room and go back, you should remember that you have been there
        // and therefore get another description of the room, because now you can see!
        if (player.getCurrentRoom().getName().equals("The Mere Darkness")){
          torch.pushDevice();
          System.out.println(torch);
        }

      } else if (input.equals("light off")) {
        torch.pushDevice();
        System.out.println(torch);

      } else {
        System.out.println("\"" + input + "\" is not a valid command. Try again!");
      }
    } while (!input.equals("exit"));
  }

  public void lookAround() {
    System.out.println("Looking around...");
    System.out.println(player.getCurrentRoom().getName());
    System.out.println(player.getCurrentRoom().getDescription());

    boolean result = player.getCurrentRoom().getItems().isEmpty();
    if(result == true) {
      System.out.println("You can not see any items to pick up in this cave");
    } else
      System.out.println("In the cave you can see:");

    StringBuilder sb = new StringBuilder();
    for (Item item : player.getCurrentRoom().getItems()) {
      String itemNameFirstLetterCapitalised = player.capitaliseFirstLetterItem(item) + ": " + item.getDescription() + "\n";
      sb.append(itemNameFirstLetterCapitalised);
    }
    System.out.println(sb);
  }

  public void showBackpackInventory(ArrayList<Item> inventoryPlayer){
    // StringBuilder sb = new StringBuilder();
    for (Item item : inventoryPlayer) {
      //String temp = item.getName();
      String temp = capitaliseFirstLetterItem(item);
      //sb.append(temp);
      System.out.println(temp);
    }

  }

  public String capitaliseFirstLetterItem(Item item) {
    String itemNameUpperCase = item.getName().substring(0,1).toUpperCase() + item.getName().substring(1).toLowerCase();
    return itemNameUpperCase;
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

  public void checkHealthStatus(){
    int tempHealth = player.getHealthStatus();

    if(tempHealth <= 100 || tempHealth >= 75) {
      System.out.println(tempHealth + " - You're in good shape!");
    } else if (tempHealth < 75 || tempHealth >= 50) {
      System.out.println(tempHealth + " - You're in okay shape. Some healthy food would be good for you!");
    } else if (tempHealth < 50 || tempHealth >= 25) {
      System.out.println(tempHealth + " - You're getting weak! Consider what you consume and try avoid combats.");
    } else if (tempHealth < 25 || tempHealth >= 1) {
      System.out.println(tempHealth + " - You're in health danger! Go find some healthy food before anything else!");
    } else {
      System.out.println("You're dead!");
    }
  }

  public void newLine() {
    System.out.println();
  }

}

