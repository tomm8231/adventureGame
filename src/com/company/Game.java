package com.company;

import java.util.Scanner;

public class Game {

  public void game(String input){
    Scanner sc = new Scanner(System.in);

    do {

      input = sc.nextLine().trim().toLowerCase();
      isAlive = true;

      if (input.equals("look")) {
        lookAround();
      }

      else if (input.startsWith("go ")) {
        goHelpMethod(input);

      } else if (input.startsWith("take ")) {
        takeHelpMethod(input);

      } else if (input.startsWith("drop ")) {
        dropHelptMethod(input);

      } else if (input.equals("inventory")) {
        inventoryHelpMethod();

      } else if (input.equals("health")) {
        checkHealthStatus();

      } else if (input.startsWith("eat ")) {

      } else if (input.startsWith("equip ")) {
        equipHelpMethod(input);

      } else if (input.startsWith("attack ")) {
        attackHelpMethod(input);


      } else if (input.equals("help")) {
        showCommands();

      } else if (input.equals("exit")) {
        System.out.println("Exiting game");

      } else {
        System.out.println("\"" + input + "\" is not a valid command. Try again!");
      }

      warningHealth();
      //OBS loopet skal også stoppe hvis Player dør!!

    } while (!input.equals("exit"));  // || isAlive == false
  }

}

}
