package com.company;

import java.util.Scanner;
/*
Det er Adventure-klassen der skal bygge "kortet" ved at oprette og forbinde
de ni room objekter - room objekterne må ikke være hardcoded med kortet på nogen måde,
og der skal heller ikke oprettes arrays eller andre datastrukturer med “kortet”,
kun forbindelser fra room-objekt til room-objekt

The object represent the human player and we need this object to keep track of where the player is.

Adventure description of the game: in the README.txt
AdventureIceland is an old school command line java game where the player move from room to room by typing in simple commands.
 */


public class Adventure {

    private Room currentRoom; // int or Room?? where the player is at current
    private String name;
    private String description;

        Direction dirN = Direction.NORTH;
        Direction dirE = Direction.EAST;
        Direction dirS = Direction.SOUTH;
        Direction dirW = Direction.WEST;

    // use enum or int????
    public enum Direction{
        NORTH, EAST, SOUTH, WEST; // You can access enum constants: Direction dirN = Direction.NORTH;
        final int NOEXIT = -1; // ??
        }


/* A class constructor for the Adventure class
public Adventure (String aName, String aDescription){
this.currentRoom = aRoom;
}
 */


    public void setRoom(Room aRoom){
        this.currentRoom = aRoom;
    }

    public Room getRoom(){
        return this.currentRoom;
    }

    public String getName(){
        return name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String aDescription){
        this.description = aDescription;
    }

/*
public int movePlayerTo(Direction dir){
    return moveTo(player, dir)
}

 */ // movePlayerTo

    public void updateOutput(int currentRoom){
        String s;
    }

    public void welcomeMessage(){
        System.out.println("Welcome to Adventure Iceland!");
        System.out.println("Adventure Iceland is a game where the player move " +
            "from cave to cave by typing in commands: go north, go east, etc.");
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

            if (input.equals("look")) {
                System.out.println("You are in room " + currentRoom); //hardcoded as example
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

    public void playAdventure(){
    }



    public static void main(String[] args) {

        Adventure adventure = new Adventure();

        // starter spillet
        adventure.mainMenu();

        Room room1 = new Room("Room 1", "Description...", 0, 4, 2, 0);


        //  oprette og forbinde de ni room objekter

        // kun forbindelser fra room-objekt til room-objekt

        // Man skal kunne skrive "go north", "go east", "go south" og "go west" for at navigere rundt.

        // Hvis man kan flytte sig i den ønskede retning, udskrives navn og beskrivelse for det nye rum man er i - hvis det ikke er muligt at flytte sig,
        // får man beskeden "you cannot go that way" og forbliver hvor man var.

        // Al input/output og kommunikation med brugeren skal foregå i Adventure-objektet.

        // Adventure-objektet holder hele tiden styr på hvilket rum spilleren befinder sig i
        // - f.eks. med en variabel: currentRoom.

        // exit - for at afbryde spillet helt, og afslutte programmet

        // help - for at få en instruktion og oversigt over mulige kommandoer

        // look - for at få gentaget beskrivelsen af det rum man er i




    }
}
