public class GameEngine {

  private Fighter fighter1;
  private Fighter fighter2;
  //private Fighter dummy = new Fighter("N/A", "N/A", 0, 0, 0);
  private Fighter[] fighters;

  GameEngine(Fighter fighter1, Fighter fighter2) {
    this.fighter1 = fighter1;
    this.fighter2 = fighter2;
    fighters = new Fighter[] {fighter1, fighter2};
  }
  void simulateBattle() {
    int l;
    System.out.println("At the start of battle, stats are:");
    getStat();
    do {
      l = lowerAttack();
      hit(l);
    } while (!fighter1.isDead() && !fighter2.isDead());
    getWinner((l + 1) % 2);
  }

  void hit(int l) {
    if (l < 2) {
      fighters[l].takeDamage(calcDMG(l));
      fighter1.reduceLuck();
      fighter2.reduceLuck();
      System.out.println(fighters[(l + 1) % 2].getName() + " hits "
          + fighters[l].getName() + ", stats are:");
      getStat();
    } else {
      System.out.println(fighter1.getName() + " draws with " + fighter2.getName());
      separate();
    }
  }

  int calcDMG(int l) {
    return 2 + luckDmg(fighters[(l + 1) % 2]) - luckDmg(fighters[l]);
  }

  private int lowerAttack() {
    int a1 = fighter1.calculateAttackScore();
    int a2 = fighter2.calculateAttackScore();
    if (a1 < a2) {
      return 0;
    } else if (a1 > a2) {
      return 1;
    } else {
      return 2;
    }
  }

  int luckDmg(Fighter fighter) {
    int dice1 = new Dice().roll();
    int dice2 = new Dice().roll();
    if (dice1 + dice2 > fighter.getLuck()) {
      return - 1;
    } else {
      return 1;
    }
  }

  void getWinner(int l) {
    System.out.print("End of battle, ");
    fighters[l].printFighter();
    System.out.print(" wins.");
    System.out.println();
  }

  void getStat() {
    fighter1.printFighter();
    System.out.println();
    fighter2.printFighter();
    System.out.println();
    separate();
  }

  void separate() {
    for (int i = 0; i < 30; i++) {
      System.out.print('-');
    }
    System.out.println();
  }

}
