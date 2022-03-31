package com.company;

public class Map {

  private Room starterRoom;


  public Room getStarterRoom() {
    return starterRoom;
  }



  public void createCaves() {

    // Weapons to the enemy:
    MeleeWeapon swordEnemy = new MeleeWeapon("sword", "It's very sharp and curvy!", -20);
    MeleeWeapon batFangs = new MeleeWeapon("bat-fangs", "In the mouth you see som crazy sharp fangs", -30);
    MeleeWeapon spear = new MeleeWeapon("spear", "A sharp spear", -30);
    MeleeWeapon lavaclub = new MeleeWeapon("lava-club", "A large lava club", -30);
    MeleeWeapon mjolnir = new MeleeWeapon("mjölnir", "looks like the legendary hammer of Thor!", -40);




    // Caves with items, food, weapons and enemies:
    Room cave1 = new Room("The Claustrophobia","""
            \tThe cave is surprisingly small and you feel that the walls are getting closer every second you stand there.
            \tYou have to decide fast where to go, because you're claustrophobia is freaking you out.""");
    cave1.addItem(new Food ("apple", "A red apple", 5));
    cave1.addItem(new Food("orange", "A rotten orange", -100));
    cave1.addItem(new Food("bread", "A piece of bread", 10));
    cave1.addItem(new MeleeWeapon("axe","This axe is very blunt", -20)); // healthDamage
    cave1.addItem(new MeleeWeapon("knife","A rusty old knife", -10));
    cave1.addItem(new RangedWeapon("crossbow", "crossbow", -20, 5));
    cave1.addItem(new RangedWeapon("slingshot", "A homemade slingshot", -3, 50));




    Room cave2 = new Room("The moist","""
            \tSuddenly you're standing in water to your knees.
            \tThere's a long way home to your boat. But there are possibilities to move on...""");
    cave2.addItem(new Item("rope", "A long rope"));
    cave2.addItem(new Item("key", "An antique skeleton key"));
    cave2.addItem(new Food("fish", "Some smelly fish", -5)); // -health
    cave2.addItem(new Food("bread", "Surprisingly fresh bread", 5));
    cave2.addItem(new Food("energybar","An energy bar with banan fudge", 30 ));
    cave2.addItem(new RangedWeapon("harpoon", "A sharp harpoon", -30, 5));
    cave2.addEnemy(new Enemy("orc", "This orc seems extremely aggressive!", 50, swordEnemy));




    Room cave3 = new Room("The Bats Nest","""
            \tWhen you enter the cave you hear screaming bats all over the place. You consider if this is a good idea.""");
    cave3.addItem(new Item ("torch", "A fire torch"));
    cave3.addItem(new Item ("matches", "A box of matches"));
    cave3.addItem(new Food("beer", "A cold beer", 10));
    cave3.addItem(new Food("candy", "Jelly Beans with butter taste", -5));
    cave3.addItem(new Food("banana", "A nice looking banana", 10));
    cave3.addItem(new Food ("poison", "A brown bottle marked with poison", -100));
    cave3.addItem(new MeleeWeapon("sledgehammer", "Rather large and heavy", -20));
    cave3.addEnemy(new Enemy("bat-gremlin", "A weird little creature, a hybrid between a bat and a gremlin.", 50, batFangs));



    Room cave4 = new Room("The Eternal Deep","""
            \tYou step onto a surface which feels rather wobbly. There's a distinct smell of rotten eggs. Your doubts about
            \tyour journey have never been bigger. Be very careful when you take further steps.""");
    cave4.addItem(new Item ("lighter", "A silver zippo lighter"));
    cave4.addItem(new Item ("oil", "A tiny bottle of oil"));
    cave4.addItem(new Food ("chocolate", "A snickers", 10));
    cave4.addItem(new MeleeWeapon ("spear", "Sharp spartan spear", -50));
    cave4.addItem(new RangedWeapon("bow", "A set of bow and arrow", -20, 5));
    cave4.addItem(new MeleeWeapon("axe", "TEST axe damage -100",-100));
    cave4.addEnemy(new Enemy("monster", "Creepy monster", 100, spear));


    Room cave5 = new Room("The Spectacular","""
            \tYou have finally found the greatest cave of them all, the one with purple stalactites all over, a huge waterfall
            \tand with the most amazing light. Something glittering is shining in the corner.""");
    cave5.addItem(new Item ("diamond", "A big shiny diamond"));
    cave5.addItem(new Item ("treasure", "A large treasure chest"));
    cave5.addItem(new Food("champagne", "A large bottle of Champagne", 50));
    cave5.addItem(new MeleeWeapon ("sword", "A sharp sword looking kind if medieval", -50));




    Room cave6 = new Room("The Mere Darkness","""
            \tIt's dark.""");
    cave6.addItem(new Food("water", "A large bottle of water", 5));
    cave6.addItem(new Food("harðfiskur", "Harðfiskur is dried fish", 100));
    cave6.addItem(new Food("brændevin", "A bottle of The Black Death", -10));
    cave6.addItem(new Food("tablets", "Some white tablets with smiley on", -50));
    cave6.addItem(new RangedWeapon ("dynamite", "A large box of TNT dynamite", -100, 1));
    cave6.addItem(new RangedWeapon ("revolver", "A Colt Model 1849 revolver", -10, 3));


    Room cave7 = new Room("The Lava Surprise","""
            \tYou didn't believe it was possible, but now you see it with your own eyes: 
            \tyou are almost surrounded by lava with three narrow passages, leading to the other caves.
            \tThe cave is enormous and while you are walking into the cave your eyes are almost melting. 
            \tYou think you saw something moving down in the lava.""");
    cave7.addItem(new Item ("compass", "An old hand holding compass"));
    cave7.addItem(new Food("kiwi", "A fresh kiwi", 10));
    cave7.addItem(new Item ("coins", "A stack of coins"));
    cave7.addItem(new MeleeWeapon("panabas", "A large battle axe", -50));
    cave7.addEnemy(new Enemy ("lavamonster", "A creepy large lava monster is located in the surface", 50, lavaclub));
    cave7.addItem(new MeleeWeapon("lavarock", "a porous, sharp rock from a recent eruption", -5));


    Room cave8 = new Room("The Massive Boulder","""
            \tWhen you enter the cave you hear something rumbling and the whole cave is covered by a massive rock slide. 
            \tYou look at your compass and to the north you can see bright flashes through a big pile of boulders blocking the way.""");
    cave8.addItem(new Item ("book", "An old geology book"));
    cave8.addItem(new Item ("map", "An old handwritten map of some tunnels"));
    cave8.addItem(new Food("skyr", "An old box of Skyr", -5));
    cave8.addItem(new Food("hákarl", "A piece of some fermented shark", 50));
    cave8.addItem(new MeleeWeapon("karambit", "Historical combat knife", -20 ));
    cave8.addEnemy(new Enemy("viking", "An extremely aggressive viking warrior throwing his hammer is shouting and making thunder in the cave.", 250, mjolnir));


    Room cave9 = new Room("The Windy Tunnel","""
            \tThe wind blows your mind away and you cannot hear your own thoughts.
            \tLike the cave is protecting itself from you going deeper into it.""");
    cave9.addItem(new Item ("screwdriver", "A flat screwdriver"));
    cave9.addItem(new Food ("maxim", "A bottle of maxim energy drink", 20));
    cave9.addItem(new Food ("rúgbrauð", "Dark Rye Bread from a Hot Spring", 50));
    cave9.addItem(new Food ("banana", "A yellow and fresh banana", 10));


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
