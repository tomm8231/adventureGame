package com.company;

import java.util.Scanner;

public class Adventure {

    private Room currentRoom;


    public void newLine() {
        System.out.println();
    }

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

    public void lookAround() {
        System.out.println("Looking around...");
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());
    }

    public void mainMenu() {

        Map map = new Map();

        map.createCaves();

        currentRoom = map.getStarterRoom();




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
                checkRoomNull(direction);

            } else if (input.equals("help")) {
                helpMenu();
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

    public void checkRoomNull(String direction) {
        Map map = new Map();
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


    public static void main(String[] args) {

        Adventure adventure = new Adventure();

        adventure.mainMenu();

    }
}
