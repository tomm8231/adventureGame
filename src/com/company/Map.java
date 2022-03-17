package com.company;

public class Map {

  private Room starterRoom;


  public Room getStarterRoom() {
    return starterRoom;
  }


  public void createCaves() {


    Room cave1 = new Room("The Claustrophobia","""
            \tThe cave is surprisingly small and you feel that the walls are getting closer every second you stand there.
            \tYou have to decide fast where to go, because you're claustrophobia is freaking you out.""");
    Room cave2 = new Room("The moist","""
            \tSuddenly you're standing in water to your knees.
            \tThere's a long way home to your boat. But there are possibilities to move on...""");
    Room cave3 = new Room("The Bats Nest","""
            \tWhen you enter the cave you hear screaming bats all over the place. You consider if this is a good idea.""");
    Room cave4 = new Room("The Eternal Deep","""
            \tYou step onto a surface which feels rather wobbly. There's a distinct smell of rotten eggs. Your doubts about
            \tyour journey have never been bigger. Be very careful when you take further steps.""");
    Room cave5 = new Room("The Spectacular","""
            \tYou have finally found the greatest cave of them all, the one with purple stalactites all over, a huge waterfall
            \tand with the most amazing light. Something glittering is shining in the corner.""");
    Room cave6 = new Room("The Mere Darkness","""
            \tIt's dark. You pick up your flashlight. To turn it on, write: 'light on'""");
    Room cave7 = new Room("The Lava Surprise","""
            \tYou didn't believe it was possible, but now you see it with your own eyes: 
            \tyou are almost surrounded by lava with three narrow passages, leading to the other caves.
            \tThe cave is enormous and while you are walking into the cave your eyes are almost melting. 
            \tYou think you saw something moving down in the lava.""");
    Room cave8 = new Room("The Massive Boulder","""
            \tWhen you enter the cave you hear something rumbling and the whole cave is covered by a massive rock slide. 
            \tYou look at your compass and to the north you can see bright flashes through a big pile of boulders blocking the way.""");
    Room cave9 = new Room("The Windy Tunnel","""
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


    starterRoom = cave1;
  }
}
