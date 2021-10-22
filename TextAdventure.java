import java.util.*;

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
    System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. \nYou see what looks like a city in the distance. \nWhat would you like to do?\n \ncity: go towards the \"City\"? \nforest: turn around and re-enter the forest\nnap: go back to sleep\nmountains: Go up the steep mountains to check out the cave\ngrave: enter \"dead mans\" grave\nbeach: go to the beach and explore a \"ship reck\"\nvillage: go into the near by village " + ourHero.getName() + ": ");

    // get user input and go to the appropriate zone based on their input
    input = inScanner.nextLine();
    if(input.contentEquals("City"))
    {
    	ourHero.enterZone1();
    }
    else if(input.contentEquals("Zone 2"))
    {
    	ourHero.enterZone2();
    }
    else if(input.contentEquals("Zone 3"))
    {
    	ourHero.enterZone3();
    }
    else if(input.contentEquals("Zone 4"))
    {
    	ourHero.enterZone4();
    }
    else if(input.contentEquals("Zone 5"))
    {
    	ourHero.enterZone5();
    }
    else if(input.contentEquals("Zone 6"))
    {
    	ourHero.enterZone6();
    }
    else if(input.contentEquals("nap"))
    {
    	ourHero.gameEnd();
    }

  }

  private void enterZone1()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE

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

    inScanner.close();
  }
}