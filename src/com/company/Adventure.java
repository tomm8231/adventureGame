package com.company;

import java.util.Scanner;
/*
Det er Adventure-klassen der skal bygge "kortet" ved at oprette og forbinde
de ni room objekter - room objekterne må ikke være hardcoded med kortet på nogen måde,
og der skal heller ikke oprettes arrays eller andre datastrukturer med “kortet”,
kun forbindelser fra room-objekt til room-objekt
 */


public class Adventure {

    enum Direction{
        NORTH, EAST, SOUTH, WEST
    }

    public void playAdventure(){

    }

    public static void main(String[] args) {

        Direction dirN = Direction.NORTH;
        Direction dirE = Direction.EAST;
        Direction dirS = Direction.SOUTH;
        Direction dirW = Direction.WEST;

        Scanner sc = new Scanner(System.in);



        // starter spillet

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
