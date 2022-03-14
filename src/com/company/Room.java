package com.company;


public class Room {

  private final int north;
  private final int south;
  private final int east;
  private final int west;
  private String name;
  private String description;

  private String roomDescription;

  // et rum med et navn, en beskrivelse og fire forbindelser til andre rum
  //TODO: Parameter med beskrivelse af rum mangler!
  public Room(String aName, int north, int south, int east, int west){ // 4 connections to other rooms?

    // Room har 4 attributter af typen Room til at håndtere forbindelser til de fire andre rum:
    // north, east, south and west eller null
    System.out.println(aName);
    this.roomDescription = roomDescription;
    this.north = north;
    this.south = south;
    this.east = east;
    this.west = west;
        /*
    Adventure.Direction dirN = Adventure.Direction.NORTH;
    Adventure.Direction dirE = Adventure.Direction.EAST;
    Adventure.Direction dirS = Adventure.Direction.SOUTH;
    Adventure.Direction dirW = Adventure.Direction.WEST;
         */

  }

  public void setDescription(String aDescription){
    this.description = aDescription;

    String cave1 = "You are in a very small and dark cave with 4 tiny holes, you have no clues witch way to go. This cave is named the claustrophobia ";

    String cave2 = "cave 2";

    String cave3 = "cave 3";

    String cave4 = "cave 4";

    String cave5 = "cave 5";

    String cave6 = "cave 6";

    String cave7 = "cave 7";

    String cave8 = "cave 8";

    String cave9 = "cave 9";

  }




  // THE LOGIC IN THE GAME:
  // Room 1: Go EAST = 2, Go SOUTH = 4
  // Room 2: Go WEST = 1, Go EAST = 3
  // Room 3: Go WEST = 2, Go SOUTH = 6
  // Room 4: Go NORTH = 1, Go SOUTH = 7;
  // Room 5: Go south = 8 --> You won? Do the player continue from 5??
  // Room 6: Go north = 3, Go SOUTH = 9
  // Room 7: Go north = 4, Go EAST = 8
  // Room 8: Go north = 5 --> You won the game???
  // Room 9: Go north = 6, Go WEST = 8


// Hvert room objekt har attributten name - det er en god ide at bruge samme værdi til denne attribut,
// som navnet på variablen du opretter rummet med i Adventure-klassen.


}
