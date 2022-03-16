package com.company;

import java.util.Scanner;

public class UserInterface {

  private Room currentRoom;

  private String name1 = "The Claustrophobia";
  private String description1 = """
            \tThe cave is surprisingly small and you feel that the walls are getting closer every second you stand there.
            \tYou have to decide fast where to go, because you're claustrophobia is freaking you out.""";

  private String name2 = "The Moist";
  private String description2 = """
            \tSuddenly you're standing in water to your knees.
            \tThere's a long way home to your boat. But there are possibilities to move on...""";

  private String name3 = "The Bats Nest";
  private String description3 = """
            \tWhen you enter the cave you hear screaming bats all over the place. You consider if this is a good idea.""";

  private String name4 = "The Eternal Deep";
  private String description4 = """
            \tYou step onto a surface which feels rather wobbly. There's a distinct smell of rotten eggs. Your doubts about
            \tyour journey have never been bigger. Be very careful when you take further steps.""";

  private String name5 = "The Spectacular";
  private String description5 = """
            \tYou have finally found the greatest cave of them all, the one with purple stalactites all over, a huge waterfall
            \tand with the most amazing light. Something glittering is shining in the corner.""";

  private String name6 = "The Mere Darkness";
  private String description6 = """
            \tIt's dark. You pick up your flashlight. To turn it on, write: 'light on'""";

  private String name7 ="The Lava Surprise";
  private String description7 = """
            \tYou didn't believe it was possible, but now you see it with your own eyes: 
            \tyou are almost surrounded by lava with three narrow passages, leading to the other caves.
            \tThe cave is enormous and while you are walking into the cave your eyes are almost melting. 
            \tYou think you saw something moving down in the lava.""";

  private String name8 ="The Massive Boulder";
  private String description8 = """
            \tWhen you enter the cave you hear something rumbling and the whole cave is covered by a massive rock slide. 
            \tYou look at your compass and to the north you can see bright flashes through a big pile of boulders blocking the way.""";

  private String name9 ="The Windy Tunnel";
  private String description9 = """
            \tThe wind blows your mind away and you cannot hear your own thoughts.
            \tLike the cave is protecting itself from you going deeper into it.""";


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
    helpMenu();
    System.out.println("""
            You have abseiled into a very small and dark cave with four tiny
            tunnels, you have no clues witch way to go. This cave is named The Claustrophobia...
            
            What do you do?
            """);

  }

  public void helpMenu() {
    System.out.println("COMMANDS:");
    System.out.println("\"Look\" | Description of surroundings");
    System.out.println("\"Help\" | Game instructions"); // Skal fjernes, når menuen hentes senere i spillet!
    System.out.println("\"Exit\" | Quit game");
    newLine();
    System.out.println("Directions:\n\"Go north\"\n\"Go south\"\n\"Go east\"\n\"Go west\"");
    newLine();
  }

  public void mainMenu() {

    Map map = new Map();
    UserInterface ui = new UserInterface();

    map.createCaves();

    currentRoom = map.getStarterRoom();


    Scanner sc = new Scanner(System.in);

    ui.welcomeMessage();

    Torch flashlight = new Torch("flashlight", false);

    String input;
    do {

      input = sc.nextLine().trim().toLowerCase();

      if (input.equals("look")) {
        lookAround();
      } else if (input.startsWith("go ")) {
        String direction = input.substring(input.indexOf(" ") + 1);
        checkRoomNull(direction);

      } else if (input.equals("help")) {
        ui.helpMenu();
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
    System.out.println(currentRoom.getName());
    System.out.println(currentRoom.getDescription());
  }

  public void checkRoomNull(String direction) {
    Room cave = null;
    if(direction.equals("north")) {
      cave = currentRoom.getNorth();
    } else if (direction.equals("south")) {
      cave = currentRoom.getSouth();
    } else if (direction.equals("east")) {
      cave = currentRoom.getEast();
    } else if (direction.equals("west")) {
      cave = currentRoom.getWest();
    }

    if(cave == null) {
      System.out.println("This way is ófærð. Try another path.");
      newLine();
    } else {
      System.out.println("Going " + direction + "...");
      newLine();
      currentRoom = cave;
      System.out.println("--------------------");
      System.out.println("You have entered " + currentRoom.getName() + ":");
      System.out.println(currentRoom.getDescription());
      System.out.println("--------------------");
      newLine();
    }
  }

  public void newLine() {
    System.out.println();
  }


  // GETTERS AND SETTERS:

  public String getName1() {
    return name1;
  }

  public String getDescription1() {
    return description1;
  }

  public String getName2() {
    return name2;
  }

  public String getDescription2() {
    return description2;
  }

  public String getName3() {
    return name3;
  }

  public String getDescription3() {
    return description3;
  }

  public String getName4() {
    return name4;
  }

  public String getDescription4() {
    return description4;
  }

  public String getName5() {
    return name5;
  }

  public String getDescription5() {
    return description5;
  }

  public String getName6() {
    return name6;
  }

  public String getDescription6() {
    return description6;
  }

  public String getName7() {
    return name7;
  }

  public String getDescription7() {
    return description7;
  }

  public String getName8() {
    return name8;
  }

  public String getDescription8() {
    return description8;
  }

  public String getName9() {
    return name9;
  }

  public String getDescription9() {
    return description9;
  }

}

