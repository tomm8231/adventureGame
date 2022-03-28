package com.company;

import java.util.Scanner;

public class Game {

  public void game(String input){
    Scanner sc = new Scanner(System.in);
    UserInterface ui = new UserInterface();


    do {

      input = sc.nextLine().trim().toLowerCase();
      ui.isAlive = true;

      if (input.equals("look")) {
        ui.lookAround();
      }

      else if (input.startsWith("go ")) {
        ui.goHelpMethod(input);

      } else if (input.startsWith("take ")) {
        ui.takeHelpMethod(input);

      } else if (input.startsWith("drop ")) {
        ui.dropHelptMethod(input);

      } else if (input.equals("inventory")) {
        ui.inventoryHelpMethod();

      } else if (input.equals("health")) {
        ui.checkHealthStatus();

      } else if (input.startsWith("eat ")) {
        ui.eatHelpMethod(input);

      } else if (input.startsWith("equip ")) {
        ui.equipHelpMethod(input);

      } else if (input.startsWith("attack ")) {
        ui.attackHelpMethod(input);


      } else if (input.equals("help")) {
        ui.showCommands();

      } else if (input.equals("exit")) {
        System.out.println("Exiting game");

      } else {
        System.out.println("\"" + input + "\" is not a valid command. Try again!");
      }

      ui.warningHealth();
      //OBS loopet skal også stoppe hvis Player dør!!

    } while (!input.equals("exit"));  // || isAlive == false
  }

}

}
