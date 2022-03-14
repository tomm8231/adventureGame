package com.company;

import java.util.Locale;
import java.util.Scanner;
/*
Adventure description of the game: in the README.txt
AdventureIceland is an old school command line java game where the player move from room to room by typing in simple commands.
 */


public class Adventure {

    private Room currentRoom;
    private String name;
    private String description;


    public void newLine() {
        System.out.println();
    }

/*
    public void setRoom(Room aRoom){
      //  this.currentRoom = aRoom;
    }

    public Room getRoom(){
        return this.currentRoom;
    }


 */
    public void welcomeMessage(){
        System.out.println("Welcome to Adventure Iceland!");
        newLine();
        System.out.println("Adventure Iceland is a game where the player move " +
            "from cave to cave by typing in commands: go north, go east, etc.");
        newLine();
        System.out.println("You have arrived in Iceland with a sailboat, and you are on the most exciting trip of your life to experience\n" +
            " the newly discovered lava caves, found by some researchers from the University of Aberdeen. You have heard that\n" +
            " it is very difficult to find the greatest cave of them all, the one with purple stalactites all over, a huge waterfall and with the most\n" +
            "  amazing light, but with enough food, water and patience, you have decided to complete. Get ready to the Adventure of Vatnajökull!");
        newLine();
    }

    public void mainMenu() {

        createCaves();

        Scanner sc = new Scanner(System.in);

        welcomeMessage();

        String input;
        do {
            System.out.println("To get the description of which room you are in, write: look ");
            System.out.println("To get instructions and a overview of possible commands, write: help  ");
            System.out.println("To exit the game, write: exit");
            input = sc.nextLine().toLowerCase();
            //Programme does not run properly with .equals
            // Does with .equalsIgnoreCase does. Why??

            if (input.equals("look")) {
                System.out.println("Looking around...");
                System.out.println(currentRoom.getDescription());

            } else if (input.equalsIgnoreCase("go north")) {
              //  System.out.println("Going north!");
                Room caveToTheNorth = currentRoom.getNorth();
                String direction = "north";
                checkRoomNull(caveToTheNorth, direction);

            } else if (input.equalsIgnoreCase("go south")) {
                Room caveToTheSouth = currentRoom.getSouth();
                String direction = "south";
                checkRoomNull(caveToTheSouth, direction);

            } else if (input.equalsIgnoreCase("Go east")) {
                Room caveToTheEast = currentRoom.getEast();
                String direction = "east";
                checkRoomNull(caveToTheEast, direction);

            } else if (input.equalsIgnoreCase("Go west")) {
                Room caveToTheWest = currentRoom.getWest();
                String direction = "west";
                checkRoomNull(caveToTheWest, direction);

            } else if (input.equals("help")) {
                System.out.println("You use the commands 'go north', 'go east', 'go south' and 'go west' to change the " +
                    "direction in this game ");
            } else if (input.equals("exit")) {
                System.out.println("You have ended the game - welcome back!");
            } else
                System.out.println("Not a valid command, try again!");
        }
        while (!input.equals("exit")); // or (!"exit".equals(input) ??)


    }

    public void checkRoomNull(Room cave, String direction){

        if(cave == null){
            System.out.println("You cannot go in that direction");
        } else {
            System.out.println("Going " + direction);
            currentRoom = cave;
        }
    }

    public void createCaves() {
        // N, S, E, W

        Room cave1 = new Room("the claustrophobia", "You are in a very small and dark cave with 4 tiny holes, you have no clues witch way to go. This cave is named the claustrophobia.");
        Room cave2 = new Room("Cave 2", "Here comes a description of cave 2");
        Room cave3 = new Room("Cave 3", "description3...");
        Room cave4 = new Room("Cave 4", "Here comes a description of cave 4");
        Room cave5 = new Room("Cave 5", "description5...");
        Room cave6 = new Room("Cave 6", "description6");
        Room cave7 = new Room("Cave 7", "description7");
        Room cave8 = new Room("Cave 8", "description8");
        Room cave9 = new Room("Cave 9", "description9");

        cave1.setEast(cave2);
        cave1.setSouth(cave4);

        cave2.setWest(cave1);
        cave2.setEast(cave3);

        cave3.setWest(cave2);
        cave3.setSouth(cave6);

        cave4.setNorth(cave1);
        cave4.setSouth(cave7);

        cave5.setSouth(cave8);

        cave6.setNorth(cave3);
        cave6.setSouth(cave9);

        cave7.setNorth(cave4);
        cave7.setEast(cave8);

        cave8.setWest(cave7);
        cave8.setNorth(cave5);
        cave8.setEast(cave9);

        cave9.setWest(cave8);
        cave9.setNorth(cave6);

        currentRoom = cave1;
    }


    public static void main(String[] args) {

        Adventure adventure = new Adventure();

        // starter spillet
        adventure.mainMenu();

    }
}
