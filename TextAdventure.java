import java.util.Scanner;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("distantcity.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    ourHero.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. \nYou see what looks like a city in the distance. \nWhat would you like to do?\n \ncity: go towards the \"City\"? \nforest: turn around and re-enter the forest\nnap: go back to sleep\nmountains: Go up the steep mountains to check out the cave\ngrave: enter \"dead mans\" grave\nbeach: go to the beach and explore a \"ship reck\"\nvillage: go into the near by village\n\n " + ourHero.getName() + ": ");

    // get user input and go to the appropriate zone based on their input
    input = inScanner.nextLine();
    if(input.equalsIgnoreCase("city"))
    {
    	enterZone1();
    }
    else if(input.equalsIgnoreCase("forest"))
    {
    	enterZone2();
    }
    else if(input.equalsIgnoreCase("mountains"))
    {
    	enterZone3();
    }
    else if(input.equalsIgnoreCase("grave"))
    {
    	enterZone4();
    }
    else if(input.equalsIgnoreCase("village"))
    {
    	enterZone5();
    }
    else if(input.equalsIgnoreCase("beach"))
    {
    	enterZone6();
    }
    else if(input.equalsIgnoreCase("nap"))
    {
    	gameEnd();
    }

  }

  private void enterZone1()
  {
    // change image

    console.setImage("city.png");

    // describe the area/situation to the user. 
    // Give them options for choices.

    console.setImage("pumpkintrio.png");
    System.out.println("\n" + ourHero.getName() + " Walks into the city and see a wanted poster near a cafe \n it says \"WANTED DEAD OR ALIVE The Three P's \" \n\nDo you want to get this bounty: (y/n): ");
    String userInpuString = inScanner.nextLine();

    // Take action or go to another zone based on their choice
    if(userInpuString.equalsIgnoreCase("y"))
    {
      console.setImage("city.png");
      System.out.println(ourHero.getName() + "goes into the cafe and ask the bartender about the wanted poster \n\nBartender: \"Well I've heard that the monster have been terroizing the people in the city for a while, stealing things left and right making the city a living hell\"");
      System.out.println("Bartender: \"Hey " + ourHero.getName() + " are you looking to get the 500 gold bounty?");
      System.out.println(ourHero.getName() + " \"Yes I am\" ");
      System.out.println("Bartender: \"Alright the Three P's are near the town hall, Please I beg of you get RID OF THEM\". ");
      System.out.println(ourHero.getName() + " \"No problem I'm glad to help\"\n");
      System.out.println("\"" + ourHero.getName() + " start walking to the town hall and gets there pretty quickly\"");
      System.out.println("You then see in the corner of your eye the Three P's. You go after them, do you want to use your \"sword\" or \"axe\" to chase them down with?\n");

      String weapon = inScanner.nextLine();
      if(weapon.equalsIgnoreCase("sword"))
      {
        System.out.println("\n" + ourHero.getName() + "takes out their weapon and chases the monsters for a small period of time before catching up to them");
      }
      else if(weapon.equalsIgnoreCase("axe"))
      {
        System.out.println("\n" + ourHero.getName() + "takes out their weapon and chases the monsters for a long period of time before catching up to them");
      }
      System.out.println(ourHero.getName() + " starts fighting the Three P's and attacks them first (type \"yes\" to start the fight\n");
      int monsterHealth = 50;

      //Add code for fight that doesn't cause loops(Note to self)
      while(true)
      {
        double randomAttackForMonster = Math.random();
        double HeroChanceOfHitMonster = Math.random();
        double monsterRandomChanceOfHit = Math.random();
        if(randomAttackForMonster > 0.5)
        {
          if(monsterRandomChanceOfHit > randomAttackForMonster)
          {
            ourHero.setHealth();
            System.out.println("Monster Hit!");
          }
          else if(ourHero.getHealth() == 0)
          {
            gameEnd();
            break;
          }
        }
        else if(randomAttackForMonster < 0.5)
        {
          System.out.println("This is your chance to fight back!\nGuess a number between 0 and 1 to see if you hit them or not\n");
          double hitMonster = inScanner.nextDouble();
          if(HeroChanceOfHitMonster < hitMonster)
          {
            System.out.println("You got a hit!");
            monsterHealth = monsterHealth - 5;
          }
          else if(monsterHealth == 0)
          {
            break;
          }
        }
      }

    }
    else if(userInpuString.equalsIgnoreCase("n"))
    {
      console.setImage("city.png");
      System.out.println("Man that's boring\n");
      System.out.println("Where do you want to go then?\n\nforest: turn around and re-enter the forest\nnap: go back to sleep\nmountains: Go up the steep mountains to check out the cave\ngrave: enter \"dead mans\" grave\nbeach: go to the beach and explore a \"ship reck\"\nvillage: go into the near by village\n\n " + ourHero.getName() + ": ");
      String inputUser = inScanner.nextLine();
      if(inputUser.equalsIgnoreCase("forest"))
      {
    	  enterZone2();
      }
      else if(inputUser.equalsIgnoreCase("mountains"))
      {
    	  enterZone3();
      }
      else if(inputUser.equalsIgnoreCase("grave"))
      {
    	  enterZone4();
      }
      else if(inputUser.equalsIgnoreCase("village"))
      {
    	  enterZone5();
      }
      else if(inputUser.equalsIgnoreCase("beach"))
      {
    	  enterZone6();
      }
        else if(inputUser.equalsIgnoreCase("nap"))
      {
    	  gameEnd();
      }
    }

  }

  private void enterZone2()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEnd()
  {
    // ADD CODE HERE
    console.setImage("gameOver.png");
    System.out.println("Play again? (y/n)\n");
    String StartOver = inScanner.nextLine();
    if(StartOver.equalsIgnoreCase("y"))
    {
      play();
    }
    else if(StartOver.equalsIgnoreCase("n"))
    {
      System.out.println("Thanks for playing!");
      inScanner.close();
    }
  }
  private void gameEndFinal()
  {
    String StartOver2 = inScanner.nextLine();
    // ADD CODE HERE
    console.setImage("Victory.png");
    System.out.println("Play again? (y/n)");
    if(StartOver2.equalsIgnoreCase("y"))
    {
      play();
    }
    else if(StartOver2.equalsIgnoreCase("n"))
    {
      System.out.println("Thanks for playing!");
      System.out.println("You can close the game now");
      inScanner.close();
    }
  }
}