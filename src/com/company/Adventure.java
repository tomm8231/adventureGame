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

        createCaves();

        Scanner sc = new Scanner(System.in);

        welcomeMessage();

        Devices flashlight = new Devices("flashlight", false);

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

    public void createCaves() {
        // N, S, E, W

        Room cave1 = new Room("The Claustrophobia", """
            \tThe cave is surprisingly small and you feel that the walls are getting closer every second you stand there.
            \tYou have to decide fast where to go, because you're claustrophobia is freaking you out.""");

        Room cave2 = new Room("The Moist", """
            \tSuddenly you're standing in water to your knees.
            \tThere's a long way home to your boat. But there are possibilities to move on...""");

        Room cave3 = new Room("The Bats Nest", """
            \tWhen you enter the cave you hear screaming bats all over the place. You consider if this is a good idea.""");

        Room cave4 = new Room("The Eternal Deep", """
            \tYou step onto a surface which feels rather wobbly. There's a distinct smell of rotten eggs. Your doubts about
            \tyour journey have never been bigger. Be very careful when you take further steps.""");

        Room cave5 = new Room("The Spectacular", """
            \tYou have finally found the greatest cave of them all, the one with purple stalactites all over, a huge waterfall
            \tand with the most amazing light. Something glittering is shining in the corner.""");

        Room cave6 = new Room("The Mere Darkness", """
            \tIt's dark. You pick up your flashlight. To turn it on, write: 'light on'""");

        Room cave7 = new Room("The Lava Surprise", """
            \tYou didn't believe it was possible, but now you see it with your own eyes: 
            \tyou are almost surrounded by lava with three narrow passages, leading to the other caves.
            \tThe cave is enormous and while you are walking into the cave your eyes are almost melting. 
            \tYou think you saw something moving down in the lava.""");


        Room cave8 = new Room("The Massive Boulder ", """
            \tWhen you enter the cave you hear something rumbling and the whole cave is covered by a massive rock slide. 
            \tYou look at your compass and to the north you can see bright flashes through a big pile of boulders blocking the way.""");

        Room cave9 = new Room("The Windy Tunnel", """
            \tThe wind blows your mind away and you cannot hear your own thoughts.
            \tLike the cave is protecting itself from you going deeper into it.""");

        cave1.setEast(cave2);
        cave1.setSouth(cave4);

        cave3.setWest(cave2);
        cave3.setSouth(cave6);

        cave9.setNorth(cave6);
        cave9.setWest(cave8);

        cave7.setNorth(cave4);
        cave7.setEast(cave8);

        cave8.setNorth(cave5);

        currentRoom = cave1;
    }


    public static void main(String[] args) {

        Adventure adventure = new Adventure();

        adventure.mainMenu();

    }
}
