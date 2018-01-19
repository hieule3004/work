import java.util.Random;

public class Dice {

  private Random generator = new Random();
  private final int SIDES = 6;

  int roll() {
    return generator.nextInt(SIDES) + 1;
  }
}
