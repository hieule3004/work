public class Main {

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Joe", "Human Warrior", 16, 12, 12);
        Fighter fighter2 = new Fighter("Alex", "Elf Lord", 18, 6, 11);
        GameEngine gameEngine = new GameEngine(fighter1, fighter2);

        gameEngine.simulateBattle();
    }
}
