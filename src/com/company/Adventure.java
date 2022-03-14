package com.company;

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

        Scanner sc = new Scanner(System.in);

        welcomeMessage();


        String input;
        do {
            System.out.println("To get the description of which room you are in, write: look ");
            System.out.println("To get instructions and a overview of possible commands, write: help  ");
            System.out.println("To exit the game, write: exit");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("look")) {
                System.out.println("Looking around...");
                System.out.println(currentRoom.getDescription());

            } else if (input.equalsIgnoreCase("Go north")) {
                System.out.println("Going north!");
                Room caveToTheNorth = currentRoom.getNorth();
                currentRoom = caveToTheNorth;

            } else if (input.equalsIgnoreCase("Go south")) {
                System.out.println("Going south!");
                Room caveToTheSouth = this.currentRoom.getSouth();
                this.currentRoom = caveToTheSouth;


            } else if (input.equalsIgnoreCase("Go east")) {
                System.out.println("Going east!");

                Room roomToTheEast = currentRoom.getEast();
                currentRoom = roomToTheEast;

            } else if (input.equalsIgnoreCase("Go west")) {
                System.out.println("Going west!");
                Room caveToTheWest = currentRoom.getWest();
                currentRoom = caveToTheWest;

            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("You use the commands 'go north', 'go east', 'go south' and 'go west' to change the " +
                    "direction in this game ");
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("You have ended the game - welcome back!");
            } else
                System.out.println("Not a valid command, try again!");
        }
        while (!input.equals("exit")); // or (!"exit".equals(input) ??)

    }


    public void createCaves() {
        // N, S, E, W
        Room cave1 = new Room("the claustrophobia", "You are in a very small and dark cave with 4 tiny holes, you have no clues witch way to go. This cave is named the claustrophobia.");
        Room cave2 = new Room("cave 2", "Here comes a description of cave 2");
        Room cave3 = new Room(name, description);
        Room cave4 = new Room("cave 4", "Here comes a description of cave 4");
        Room cave5 = new Room(name, description);
        Room cave6 = new Room(name, description);
        Room cave7 = new Room(name, description);
        Room cave8 = new Room(name, description);
        Room cave9 = new Room(name, description);

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
