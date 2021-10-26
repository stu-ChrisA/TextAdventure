import java.util.Scanner;
import java.lang.Thread;

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

  public void play() throws InterruptedException
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
    System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. \nYou see what looks like a city in the distance and you decided to go into the city");
    // get user input and go to the appropriate zone based on their input
    Thread.sleep(2000);
    enterZone1();

  }

  private void enterZone1() throws InterruptedException
  {
                                                                                                                                                    //City
    // change image

    console.setImage("city.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    Thread.sleep(3000);
    System.out.println("\n" + ourHero.getName() + " Walks into the city and see a wanted poster near a cafe \n it says \"WANTED DEAD OR ALIVE The Three P's \" \n\nDo you want to get this bounty: (y/n): ");
    console.setImage("pumpkintrio.png");
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
      int monsterHealth = 50; // Put this value in Player.java

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
            System.out.println("Current health is: " + ourHero.getHealth());
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
            monsterHealth = monsterHealth - 5; //Use player object
            System.out.println("Monster current health is: " + monsterHealth); //Same here use player java
            if(monsterHealth <= 0 ) //Same here as well
            {
              ourHero.defeatMonster(); //adds 1 to the counter
              System.out.println("You've defeated the Three P's. Now it time to return to the cafe and claim your reward");
              Thread.sleep(1000);
              console.setImage("download.png");
              System.out.println("Bartender: \"Wow " + ourHero.getName() + " has done it! You have earned the bounty\"");
              ourHero.setGold(500);
              System.out.println("Awesome now you're 500 gold richer!");
              Thread.sleep(5000);
              System.out.println("In the distance from the cafe you see a hooded figure in a alleyway and you decide to follow him\n");
              console.setImage("Alley.png");
              System.out.println();
              Thread.sleep(2000);
              System.out.println("You exit the cafe to talk to the hooded figure\n Hooded man: \"Well it seems your interested in something\"");
              Thread.sleep(1000);
              console.setImage("hooded.png");
              System.out.println(ourHero.getName() + ": \"Well of course I want to know why you're in a alleyway.\"");
              System.out.println("Hooded man: \"Well " + ourHero.getName() + " I need some help with something. \n I found something cool at \"dead man's grave\" but it's a little to diffucult for me to get it all by myself\n Would you be able to help me out");
              System.out.println(ourHero.getName() + ": \"Of course I can\"");
              enterZone4();
              break;
            
            }
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

  private void enterZone2() throws InterruptedException
  {
                                                                                                                                              //forest
    // change image
    console.setImage("set image later");

    // describe the area/situation to the user. 
    // Give them options for choices.
    Thread.sleep(2000);
    System.out.println("You start walking towards the forest where you started and in the distance you see a tree house.\nYou figured that it's the hooded mans base and when you get to the enterance of the base you see the hooded man.");
    System.out.println("Hooded man: \"Well, well, well "+ ourHero.getName() + " it seems you defeated my servent it's time to finish you off myself then!");
    System.out.println("Type \"start\" when you're ready");
    String HoodedFigureFight = inScanner.next();
    int HoodedHealth = 75;
    if(JSquidFight.equals("fight"))
    {
        while(true)
        {
            double randomAttackForHoodedF = Math.random();
            double HeroChanceOfHitHooded = Math.random();
            double HoodedFRandomChanceOfHit = Math.random();
            if(randomAttackForHoodedF > 0.5)
            {
                if(HoodedFRandomChanceOfHit > randomAttackForHoodedF)
                {
                    ourHero.setHealth(); //Make a method in player class to regain player health
                    System.out.println("The hooded figure landed a Hit!");
                    System.out.println("Current health is: " + ourHero.getHealth());
                }
                else if(ourHero.getHealth() == 0)
                {
                    gameEnd();
                    break;
                }
            }
            else if(randomAttackForHoodedF < 0.5)
            {
                System.out.println("This is your chance to fight back!\nGuess a number between 0 and 1 to see if you hit them or not\n");
                double hitHooded = inScanner.nextDouble();
                if(HeroChanceOfHitHooded < hitHooded)
                {
                    System.out.println("You got a hit!");
                    HoodedHealth = HoodedHealth - 20; //Use player object
                    System.out.println("Monster current health is: " + HoodedHealth); //Same here use player java
                    if(HoodedHealth <= 5) 
                    {
                        ourHero.defeatMonster();
                        //ourHero.regainHealth() add health
                        System.out.println("Hooded figure: \"Shoot I need to get out of here.\"");
                        System.out.println(ourHero.getName() + " \"Give me the gold from the treasure and the gold you stole from me\"");
                        System.out.println("Hooded figure: \" No never!\"");
                        System.out.println("You start chasing the hooded figure and he runs through the village");
                        enterZone5();
                        
                    }
                }
            }
        }
    }
    

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3()
  {
                                                                                                                                            //mountains
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4() throws InterruptedException
  {
                                                                                                                        /*Graveyard Zone*/
    // change image
    console.setImage("graveyard.jpg");
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You and the hooded man just arrived at the grave yard.");
    System.out.println(ourHero.getName() + ": \" So what was the thing you found?\nHooded figure: \"Well I saw treasure in this area but it 's guarded by a ghost name \"The Boo\" and the only way to get it is to play a game.\"\n" + ourHero.getName() + ": \"A game you say..?\n Sure ill help you what's the game?");
    System.out.println("Hooded figure: \"Well " +ourHero.getName() + " it's a guessing game and I'm not really good at those types of games\"\n");
    Thread.sleep(5000);
    console.setImage("ghost.png");
    Thread.sleep(5000);
    System.out.println("The Boo: \"Muahahahaha who dares come into MY graveyard?\"");
    System.out.println(ourHero.getName() + ": \"Tis was me I'm here to play your little game. :) ");
    System.out.println("The Boo: \"Oh really? If you win ill let you get the treasure and tell you where the next turesure is and if I win I take 100 of your gold.\"");
    System.out.println(ourHero.getName() + ": \"Game on!\"");
    System.out.println("\nWhen you're ready type \"start\" to start the guessing game\n");
    String guessGameStart = inScanner.next();
    if(guessGameStart.equalsIgnoreCase("start"))
    {
      while(true)
      {
        int randomnumber = (int)(Math.random()) * (5-1) + 1;
        int attempts = 0;
        System.out.println("The Boo: \"Guess a number between 1 and 5 in 10 attempts\n");
        int guessNum = inScanner.nextInt();
        if(guessNum == randomnumber)
        {
          //ourHero.defeatedMonster(); Won aganist boo
          System.out.println("The Boo: \"Ugh, you got lucky here's 100 coins\"");
          ourHero.setGold(600);
          System.out.println("The Boo: \"Fine you win the next treasure is located at the beach near the ship reck\"");
          enterZone6();
          break;
        }
        else if(guessNum != randomnumber)
        {
          System.out.println("Nope Try Again!");
          attempts++;
        }
        else if(attempts > 10)
        {
          gameEnd();
          break;
        }
      }
    }
  }

  private void enterZone5()
  {
                                                                                                                                    //village
    // change image
    console.setImage("village.png");

    // describe the area/situation to the user. 
    // Give them options for choices.
    Thread.sleep(2000);
    System.out.println();
    System.out.println("You keep chasing them but spontaniouly they use a smoke bomb to get away.\nYou get upset that you lost him but someone close by saw where he went.");
    System.out.println("Eddie: \"Hey! You there, your name is " + ourHero.getName() + " right? if you wanna know where the mysterious man went pay me " + ourHero.getGold + " or you can play my little game\"");
    System.out.println("Type \"pay\" if you're willing to pay him or type \"game\" if you're willing to play is little game");
    String EddieG = inScanner.next();
    if(EddieG.equals("pay")
    {
        System.out.println();
        System.out.println("Eddie: \"Thanks "+ ourHero.getName() + " The hooded man ran towards the mountains.");
    }
    else if(EddieG.equals("game")
    {
        //blackjack - 21 card game
        Scanner input = new Scanner(System.in);
	    int cardOne,cardTwo,cardThree;
        int dealer1, dealer2, dealer3; // dealer’s cards
        int dealerTotal,playerTotal;
        int playerResponse; // Player wants another card
	    cardOne = (int)(Math.random()*(10 - 1)) + 1;
	    cardTwo = (int)(Math.random()*(10 - 1)) + 1;
        playerTotal = cardOne + cardTwo;
	
	    System.out.println("Players cards: " + cardOne + " " + cardTwo + " " + "and total: " + playerTotal);
	    System.out.print("Do you want another card? Enter 1 if yes or enter 2 if no: ");
	    playerResponse = inScanner.nextInt();
	
	    if(playerResponse == 1)
	    {
		    cardThree = (int)Math.random()*10 + 1;
		    playerTotal += cardThree;
		    System.out.println("the new card is " + cardThree + " and total is "+ playerTotal);
	    }
	    
	    dealer1 = (int)(Math.random()*(10 - 1)) + 1;
	    dealer2 = (int)(Math.random()*(10 - 1)) + 1;
	    dealer3 = (int)(Math.random()*(10 - 1)) + 1;
	    dealerTotal = dealer1 + dealer2 + dealer3;
	    System.out.println("dealer cards are: " + dealer1 + " " + dealer2 + " " + dealer3 + " and dealer's total: " + dealerTotal);
	
        if(playerTotal > 21){
            System.out.println("\nPlayer loses");
        }
        else if (dealerTotal > 21){
            System.out.println("\nPlayer wins");
        }
        else if(playerTotal > dealerTotal){
            System.out.println("\nPlayer wins");
        }
        else if(playerTotal < dealerTotal){
            System.out.println("\nDealer wins");
        }
    }
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6() throws InterruptedException
  {
                                                                                                                                    //Beach
    // change image
    // ADD CODE HERE
    console.setImage("add image here later"):

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println():
    System.out.println(ourHero.getName() + " and the Hooded figure arrive at the beach\nand they see a ship-reck in the distance. You both walk towards the ship-reck to see if the ghost was lying or not.\n When you both go inside you see the treasure the ghost was talking about.");
    ourHero.setGold(400);
    System.out.println("The Hooded figure realized that the ghost was telling truth and took 200 gold from you + the treasure and pushed you to the ground.\nYou chase him further into the ship reck but you need to fight against his servent \"JSquid\".");
    System.out.println("Type \"fight\" to start the fight");
    String JSquidFight = inScanner.next();
    int JSquidHealth = 150;
    if(JSquidFight.equals("fight"))
    {
        while(true)
        {
            double randomAttackForJSquid = Math.random();
            double HeroChanceOfHitJSquid = Math.random();
            double JSquidRandomChanceOfHit = Math.random();
            if(randomAttackForJSquid > 0.5)
            {
                if(JSquidRandomChanceOfHit > randomAttackForJSquid)
                {
                    ourHero.setHealth(); //Make a method in player class to regain player health
                    System.out.println("JSquid landed a Hit!");
                    System.out.println("Current health is: " + ourHero.getHealth());
                }
                else if(ourHero.getHealth() == 0)
                {
                    gameEnd();
                    break;
                }
            }
            else if(randomAttackForJSquid < 0.5)
            {
                System.out.println("This is your chance to fight back!\nGuess a number between 0 and 1 to see if you hit them or not\n");
                double hitMonster = inScanner.nextDouble();
                if(HeroChanceOfHitJSquid < hitMonster)
                {
                    System.out.println("You got a hit!");
                    JSquidHealth = JSquidHealth - 20; //Use player object
                    System.out.println("Monster current health is: " + JSquidHealth); //Same here use player java
                    if(JSquidHealth <= 0) 
                    {
                        ourHero.defeatMonster();
                        //ourHero.regainHealth() add health
                        System.out.println("JSquid: \"Ok ok I'm done you win, his base is deep in the forest\".");
                        enterZone2();
                    }
                }
            }
        }
    }
    
  }

  private void gameEnd() throws InterruptedException
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
  /*private void gameEndFinal()
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
  }*/
}
