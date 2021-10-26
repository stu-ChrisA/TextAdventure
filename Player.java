public class Player
{
  String name;
  int health;
  double gold;
  int monstersDefeated;

  public Player(String playerName, int startingHealth, double startingGold)
  {
    name = playerName;
    health = startingHealth;
    gold = startingGold;
  }

public String getName()
  {
    return name;
  }

  public void changeName(String newName)
  {
    name = newName;
  }

  public int getHealth()
  {
    return health;
  }

  public void setHealth()
  {
    health = health - 5;
  }

  public double getGold()
  {
    return gold;
  }

  public void setGold(double newAmount)
  {
    gold = newAmount;
  }

  public int getMonstersDefeated()
  {
    return monstersDefeated;
  }

  public void defeatMonster()
  {
    monstersDefeated++;
  }
  public void gainHealth(int newHealth)
  {
    health = newHealth;
  }
}