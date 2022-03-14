package com.company;


public class Room {

  private String name;
  private String description;

  private Room north;
  private Room south;
  private Room east;
  private Room west;


  // et rum med et navn, en beskrivelse og fire forbindelser til andre rum
  //TODO: Parameter med beskrivelse af rum mangler!
  public Room(String name, String description){ // 4 connections to other rooms?

    // Room har 4 attributter af typen Room til at håndtere forbindelser til de fire andre rum:
    // north, east, south and west eller null
    this.name = name;
    this.description = description;

  }



  public void setDescription(String aDescription){
    this.description = aDescription;

  }

  public void setNorth(Room cave) {
    north = cave;
  }

  public void setSouth(Room cave) {
    south = cave;
  }

  public void setEast(Room cave) {
    east = cave;
  }

  public Room getEast() {
    return east;
  }

  public void setWest(Room cave) {
    west = cave;
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
