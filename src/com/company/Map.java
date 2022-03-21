package com.company;

public class Map {

  private Room starterRoom;


  public Room getStarterRoom() {
    return starterRoom;
  }



  public void createCaves() {

    Item axe = new Item ("axe", "This axe is very blunt");
    Item torch = new Item ("torch", "A fire torch");
    Item rope = new Item ("rope", "A long rope");
    Item sword = new Item ("sword", "A sharp sword looking kind if medieval");
    Item dynamite = new Item ("dynamite", "A large box of TNT dynamite");
    Item diamond = new Item ("diamond", "A big shiny diamond");
    Item knife = new Item ("knife", "A rusty old knife");
    Item key = new Item ("key", "An antique skeleton key");
    Item poison = new Item ("poison", "A brown bottle marked with poison");
    Item coins = new Item ("coins", "A stack of coins");
    Item book = new Item ("book", "An old geology book");
    Item map = new Item ("map", "An old handwritten map of some tunnels");
    Item revolver = new Item ("revolver", "A Colt Model 1849 revolver");
    Item matches = new Item ("matches", "A box of matches"); // to dynamite and torch
    Item compass = new Item ("compass", "An old hand holding compass");
    Item screwdriver = new Item ("screwdriver", "A flat screwdriver");
    Item oil = new Item ("oil", "A tiny bottle of oil");
    Item lighter = new Item ("lighter", "A silver zippo lighter");
    Item treasure = new Item ("treasure", "A large treasure chest"); // needs the key??

    Torch torchUse = new Torch("torch", false);
    // Creates the caves with fixed items in different rooms

    Room cave1 = new Room("The Claustrophobia","""
            \tThe cave is surprisingly small and you feel that the walls are getting closer every second you stand there.
            \tYou have to decide fast where to go, because you're claustrophobia is freaking you out.""");
    cave1.addItem(axe);
    cave1.addItem(knife);


    Room cave2 = new Room("The moist","""
            \tSuddenly you're standing in water to your knees.
            \tThere's a long way home to your boat. But there are possibilities to move on...""");
    cave2.addItem(rope);
    cave2.addItem(key);


    Room cave3 = new Room("The Bats Nest","""
            \tWhen you enter the cave you hear screaming bats all over the place. You consider if this is a good idea.""");
    cave3.addItem(torch);
    cave3.addItem(poison);
    cave3.addItem(matches);

    Room cave4 = new Room("The Eternal Deep","""
            \tYou step onto a surface which feels rather wobbly. There's a distinct smell of rotten eggs. Your doubts about
            \tyour journey have never been bigger. Be very careful when you take further steps.""");
    cave4.addItem(sword);
    cave4.addItem(lighter);
    cave4.addItem(oil);

    Room cave5 = new Room("The Spectacular","""
            \tYou have finally found the greatest cave of them all, the one with purple stalactites all over, a huge waterfall
            \tand with the most amazing light. Something glittering is shining in the corner.""");
    cave5.addItem(diamond);
    cave5.addItem(treasure);


    Room cave6 = new Room("The Mere Darkness","""
            \tIt's completely dark and you don't see anything.""");
    cave6.addItem(dynamite);
    cave6.addItem(revolver);


    Room cave7 = new Room("The Lava Surprise","""
            \tYou didn't believe it was possible, but now you see it with your own eyes: 
            \tyou are almost surrounded by lava with three narrow passages, leading to the other caves.
            \tThe cave is enormous and while you are walking into the cave your eyes are almost melting. 
            \tYou think you saw something moving down in the lava.""");
    cave7.addItem(compass);
    cave7.addItem(coins);


    Room cave8 = new Room("The Massive Boulder","""
            \tWhen you enter the cave you hear something rumbling and the whole cave is covered by a massive rock slide. 
            \tYou look at your compass and to the north you can see bright flashes through a big pile of boulders blocking the way.""");
    cave8.addItem(book);
    cave8.addItem(map);


    Room cave9 = new Room("The Windy Tunnel","""
            \tThe wind blows your mind away and you cannot hear your own thoughts.
            \tLike the cave is protecting itself from you going deeper into it.""");
    cave9.addItem(screwdriver);


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
