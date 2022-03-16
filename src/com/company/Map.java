package com.company;

public class Map {

  private Room starterRoom;

  public Room getStarterRoom() {
    return starterRoom;
  }

  public void setStarterRoom(Room room) {
    this.starterRoom = room;
  }


  public void createCaves() {

    UserInterface ui = new UserInterface();

    Room cave1 = new Room(ui.getName1(),ui.getDescription1());
    Room cave2 = new Room(ui.getName2(),ui.getDescription2());
    Room cave3 = new Room(ui.getName3(),ui.getDescription3());
    Room cave4 = new Room(ui.getName4(),ui.getDescription4());
    Room cave5 = new Room(ui.getName5(),ui.getDescription5());
    Room cave6 = new Room(ui.getName6(),ui.getDescription6());
    Room cave7 = new Room(ui.getName7(),ui.getDescription7());
    Room cave8 = new Room(ui.getName8(),ui.getDescription8());
    Room cave9 = new Room(ui.getName9(),ui.getDescription9());


    cave1.setEast(cave2);
    cave1.setSouth(cave4);

    cave3.setWest(cave2);
    cave3.setSouth(cave6);

    cave9.setNorth(cave6);
    cave9.setWest(cave8);

    cave7.setNorth(cave4);
    cave7.setEast(cave8);

    cave8.setNorth(cave5);

    setStarterRoom(cave1);
  }
}
