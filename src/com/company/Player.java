package com.company;

public class Player {


  private Room currentRoom;


  public void takeItem(){

  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public String movePlayer(String direction){
    Room nextRoom = findNewRoom(direction);
    return checkValidDirection(nextRoom, direction);
  }

  public String checkValidDirection(Room cave, String direction) {

    if(cave == null) {
      return "Ófærð! Try another path.";

    } else {
      currentRoom = cave;
      return "Going " + direction + "...\n" +
          "\n----------------\n" +
          "You have entered \"" + currentRoom.getName() + "\":\n" +
          currentRoom.getDescription() +
          "\n----------------\n";
    }
  }

  public Room findNewRoom(String direction){

    if(direction.equals("north")) {
      return currentRoom.getNorth();
    } else if (direction.equals("south")) {
      return currentRoom.getSouth();
    } else if (direction.equals("east")) {
      return currentRoom.getEast();
    } else if (direction.equals("west")) {
      return currentRoom.getWest();
    } return null;
  }
}
