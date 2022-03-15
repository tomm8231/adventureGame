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
        System.out.println("""
            You have arrived to Iceland with a sailboat, and you are on the most exciting trip of your life to experience
            the newly discovered lava caves, found by some researchers from the University of Aberdeen.
            You have heard that it is very difficult to find the greatest cave of them all, the one with purple stalactites all
            over, a huge waterfall and with the most amazing light, but with enough food, water and patience, you have decided
            to complete. Get ready to the Adventure of Vatnajökull!
            
            You have abseiled into a very small and dark cave with four tiny
            tunnels, you have no clues witch way to go. This cave is named The Claustrophobia...
            """);

        helpMenu();

    }

    public void helpMenu() {
        System.out.println("To get the description of which room you are in, write: look ");
        System.out.println("To get instructions and a overview of possible commands, write: help  ");
        System.out.println("To exit the game, write: exit");
        System.out.println("You use the commands 'go north', 'go east', 'go south' and 'go west' to change the " +
        "direction in this game ");
        newLine();
    }

    public void lookAround() {
        System.out.println("Looking around...");
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());
    }

    public void mainMenu() {

        createCaves();

        Scanner sc = new Scanner(System.in);

        welcomeMessage();

        String input;
        do {

            input = sc.nextLine().trim().toLowerCase();

            if (input.equals("look")) {
                lookAround();
            } else if(input.startsWith("go ")) {
                String direction = input.substring(input.indexOf(" ")+1);
                checkRoomNull(direction);

            } else if (input.equals("help")) {
                helpMenu();
            } else if (input.equals("exit")) {
                System.out.println("You have ended the game - welcome back!");
            } else
                System.out.println("Not a valid command, try again!");
        }
        while (!input.equals("exit"));

        /*
        String input;
        do {
            System.out.println("To get the description of which room you are in, write: look ");
            System.out.println("To get instructions and a overview of possible commands, write: help  ");
            System.out.println("To exit the game, write: exit");

            input = sc.nextLine().trim().toLowerCase();

            if (input.equals("look")) {
                System.out.println("Looking around...");
                System.out.println(currentRoom.getName());
                System.out.println(currentRoom.getDescription());

            } else if(input.startsWith("go ")) {
                String direction = input.substring(input.indexOf(" ")+1);
                checkRoomNull(direction);

            } else if (input.equals("help")) {
                System.out.println("You use the commands 'go north', 'go east', 'go south' and 'go west' to change the " +
                    "direction in this game ");
            } else if (input.equals("exit")) {
                System.out.println("You have ended the game - welcome back!");
            } else
                System.out.println("Not a valid command, try again!");
        }
        while (!input.equals("exit"));
        */
    }

    public void checkRoomNull(String direction){
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

        if(cave == null){
            System.out.println("This way is ófærð. Try another path.");
        } else {
            System.out.println("Going " + direction);
            currentRoom = cave;
            System.out.println(currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        }
    }

    public void createCaves() {
        // N, S, E, W

        Room cave1 = new Room("The Claustrophobia", """
            The cave is surprisingly small and you feel that the walls are getting closer every second you stand there.
            You have to decide fast where to go, because you're claustrophobia is freaking you out. 
            """);

        Room cave2 = new Room("The Moist", """
            Suddenly you're standing in water to your knees. 
            There's a long way home to your boat. But there are possibilities to move on...
            """);

        Room cave3 = new Room("The Bats Nest", """
            When you enter the cave you hear screaming bats all over the place. You consider if this is a good idea.
            """);

        Room cave4 = new Room("The Eternal Deep", """
            You step onto a surface which feels rather wobbly. There's a distinct smell of rotten eggs. Your doubts about
            your journey have never been bigger. Be very careful when you take further steps.
            """);

        Room cave5 = new Room("The Spectacular", """
            You have finally found the greatest cave of them all, the one with purple stalactites all over, a huge waterfall
            and with the most amazing light. Something glittering is shining in the corner.
            """);

        Room cave6 = new Room("The Mere Darkness", """
            It's dark. You forgot your torch...
            """);

        Room cave7 = new Room("The Lava Surprise", """
            You didn't believe it was possible, but now you see it with your own eyes: 
            you are almost surrounded by lava with three narrow passages, leading to the other caves.
            The cave is enormous and while you are walking into the cave your eyes are almost melting. 
            You think you saw something moving down in the lava.
            """);


        Room cave8 = new Room("The Massive Boulder ", """
            When you enter the cave you hear something rumbling and the whole cave is covered by a massive rock slide. 
            You look at your compass and to the north you can see bright flashes through a big pile of boulders blocking the way.
            """);

        Room cave9 = new Room("The Windy Tunnel", """
            The wind blows your mind away and you cannot hear your own thoughts.
            Like the cave is protecting itself from you going deeper into it.
            """);

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
