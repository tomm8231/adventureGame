package com.company;

import java.util.Scanner;

public class UserInterface {

  private Player player;
  private Map map;


  public void welcomeMessage(){
    newLine();
    System.out.println("Welcome to Adventure Iceland!");
    newLine();
    System.out.println("""
            You have arrived to Iceland with a sailboat, and you are on the most exciting trip of your life to experience
            the newly discovered lava caves, found by some researchers from the University of Aberdeen.
            You have heard that it is very difficult to find the greatest cave of them all, the one with purple stalactites all
            over, a huge waterfall and with the most amazing light, but with enough food, water and patience, you have decided
            to complete. Get ready for the Adventure of Vatnajökull!
            """);
    showCommands();
    System.out.println("""
            You have abseiled into a very small and dark cave with four tiny
            tunnels, you have no clues witch way to go. This cave is named The Claustrophobia...
            
            What do you do?
            """);

  }

  public void showCommands() {
    System.out.println("COMMANDS:");
    System.out.println("\"Look\" | Description of surroundings");
    System.out.println("\"Take\" | + of things you find");
    System.out.println("\"Drop\" | + name of things you find");
    System.out.println("\"Inventory\" | View your bag of things");
    System.out.println("\"Help\" | Game instructions");
    System.out.println("\"Exit\" | Quit game");
    newLine();
    System.out.println("Directions:\n\"Go north\"\n\"Go south\"\n\"Go east\"\n\"Go west\"");
    newLine();
  }

  public void startGame() {

    //ATTEMPT TO ADD MUSIC
    String filepath = "music.wav";
    PlayMusic play = new PlayMusic();
    play.playMusic(filepath);

    map = new Map();
    player = new Player();

    map.createCaves();

    player.setCurrentRoom(map.getStarterRoom());

    Scanner sc = new Scanner(System.in);

    welcomeMessage();

    Torch flashlight = new Torch("flashlight", false);

    String input;
    do {

      input = sc.nextLine().trim().toLowerCase();

      if (input.equals("look")) {
        lookAround();
      } else if (input.startsWith("go ")) {
        String direction = input.substring(input.indexOf(" ") + 1);
        System.out.println(player.movePlayer(direction));
        //  printe hvad der er i det givne rum


      } else if (input.equals("help")) {
        showCommands();
      } else if (input.equals("exit")) {
        System.out.println("Exiting game");

      } else if (input.equals("light on")) {
        flashlight.pushDevice();
        System.out.println(flashlight);
      } else if (input.equals("light off")) {
        flashlight.pushDevice();
        System.out.println(flashlight);

      } else {
        System.out.println("\"" + input + "\" is not a valid command. Try again!");
      }
    } while (!input.equals("exit"));
  }

  public void lookAround() {
    System.out.println("Looking around...");
    System.out.println(player.getCurrentRoom().getName());
    System.out.println(player.getCurrentRoom().getDescription());
  }

  public void newLine() {
    System.out.println();
  }

}

