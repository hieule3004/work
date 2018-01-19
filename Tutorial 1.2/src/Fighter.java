import java.util.Random;

public class Fighter {

  private String name;
  private String type;
  private final int skill;
  private int stamina;
  private int luck;
  private String strategy;
  private final String[] strats = new String[] {"Aggressive", "Defensive", "Average"};

  public Fighter(String name, String type, int skill, int stamina, int luck) {
    this.name = name;
    this.type = type;
    this.skill = skill;
    this.stamina = stamina;
    this.luck = luck;
    strategy = strats[new Random().nextInt(strats.length)];
  }

  String getName() {
    return name;
  }

  String getType() {
    return type;
  }

  int getSkill() {
    return skill;
  }

  int getStamina() {
    return stamina;
  }

  int getLuck() {
    return luck;
  }

  String getStrategy() {
    return strategy;
  }

  void reduceLuck() {
    luck--;
  }

  void printFighter() {
    System.out.print(name + " - " + type + " - skill: " + skill + "; stamina: " + stamina + "; luck: " + luck);
  }

  public  void takeDamage(int damage) {
    if (stamina < damage) {
      stamina = 0;
    } else {
      stamina -= damage;
    }
  }

  private int calculateDamage() {
    return new Dice().roll();
  }

  public int calculateAttackScore() {
    int roll1 = calculateDamage();
    int roll2 = calculateDamage();
    return skill + roll1 + roll2;
  }

  public boolean isDead() {
    return stamina == 0;
  }
}
